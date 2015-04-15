package evn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import json.model.ViewRecord;

import models.DBCategory;
import models.DBPubInfo;
import models.DBSource;
import models.DBViewRecord;
import play.Logger;
import play.cache.Cache;
import utils.HTTPCommonUtil;
import utils.JsonToMap;

//公共参数类
public class PubParam {

	public static String getCacheForKey(String key) {
		return "urlcache:" + key;
	}
	
	/**
	 * 
	 * @return	每页的记录数
	 */
	public static int getPageRecord() {
		int pageRecord;
		Object po = Cache.get("pageRecord");
		if(null == po) {
			DBPubInfo dp = DBPubInfo.all().first();
			
			if(null == dp ) {
				pageRecord = 12;
			} else {
				pageRecord = dp.pageRecord;
				
			}
			Cache.set("pageRecord", pageRecord,"10mn");
			
		} else {
			pageRecord = Integer.parseInt(po.toString());
		}
		
		if(pageRecord<4) {
			pageRecord = 12;
		}
		return pageRecord;
	}
	
	public static String getAndroidAppDownLoadAddr() {
		String key = "download:androidClient";
		Object app = Cache.get(key);
		if(null == app) {
			DBPubInfo dp = DBPubInfo.all().first();
			Cache.set(key, dp.androidAppCurrentVersionDownLoadAddress,"1h");
		}
		return (String)Cache.get(key);
	}
	
	public static String getIosAppDownLoadAddr() {
		String key = "download:IosClient";
		Object app = Cache.get(key);
		if(null == app) {
			DBPubInfo dp = DBPubInfo.all().first();
			Cache.set(key, dp.iosAppCurrentVersionDownLoadAddress,"1h");
		}
		return (String)Cache.get(key);
	}
	
	public static String getYingyongbaoAppDownLoadAddr() {
		String key = "download:yingyongbaoClient";
		Object app = Cache.get(key);
		if(null == app) {
			DBPubInfo dp = DBPubInfo.all().first();
			Cache.set(key, dp.yingyongbaoAddress,"1h");
		}
		return (String)Cache.get(key);
	}
	
	/**
	 * 获取微店源标示
	 * @return 微店源数据库对象 DBSource
	 */
	public static DBSource getWeidianSource() {
		Object o = Cache.get("WeidianSource");
		DBSource source = null;
		if(null==o) {
			source = DBSource.find("sourceName = ?", "weidian").first();
			Cache.set("WeidianSource", source,"1d");
		} else {
			source = (DBSource) o;
		}
		return source;
	}
	
	/**
	 * 获取9块9包邮分类标示
	 * @return 9块9包邮分类对象 DBCategory
	 */
	public static DBCategory getWeidianCategory() {
		Object o = Cache.get("WeidianCategory");
		DBCategory category = null;
		if(null==o) {
			category = DBCategory.find("categoryName = ?", "9块9包邮").first();
			Cache.set("WeidianCategory", category,"1d");
		} else {
			category = (DBCategory) o;
		}
		return category;
	}
	
	/**
	 * 先从缓存取，缓存没有的时候在线取，默认调用这个方法获取accessToken
	 * @return accessToken
	 * @throws Exception
	 */
	public static String getWeidianAccessToken() throws Exception {
		Object tkObj = Cache.get("WeidianAccessToken");
		String token;
		if(null==tkObj) {
			token = getWeidianAccessTokenOnLine();
			Cache.set("WeidianAccessToken", token,"7188s");
		} else {
			token = tkObj.toString();
		}
		
		//return getWeidianAccessTokenOnLine();
		return token;
	}
	
	/**
	 * 联网获得 AccessToken ,注意这个是在线获取的，一天只能获取2000次
	 * @return AccessToken
	 * @throws Exception
	 */
	public static String getWeidianAccessTokenOnLine() throws Exception {
		String appkey = "620748";
		String secret = "0b213d0545830e2e390091d7f09aeb0c";
		String getTokenUrl = "https://api.vdian.com/token?grant_type=client_credential&appkey=%s&secret=%s";
		String tokenUrl = String.format(getTokenUrl, appkey,secret);
		String json = HTTPCommonUtil.getJsonString(tokenUrl);
		Map<String, Object> jsonMap = JsonToMap.toMap(JsonToMap.toMap(json).get("result").toString());
		String token = jsonMap.get("access_token").toString().replaceAll("\"", "");
		System.out.println("accesstoken:" + token);
		System.out.println("accesstoken expire_in:"+jsonMap.get("expire_in").toString());
		return token;
	}
	
	private static String viewRecordsCacheKey = "userViewRecord:" + new Date().getTime();
	
	private static void updateViewRecordCacheKey() {
		viewRecordsCacheKey = "userViewRecord" + new Date().getTime();
	}
	
	public static String getViewRecordCacheKey() {
		return viewRecordsCacheKey;
	}
	
	public static void CacheViewRecord(ViewRecord vr) {
		List<ViewRecord> vrList = (List<ViewRecord>) Cache.get(viewRecordsCacheKey);
		if(null == vrList) {
			vrList = new ArrayList<ViewRecord>();
		}
		vrList.add(vr);
		Cache.set(viewRecordsCacheKey, vrList,"20mn");
	}
	
	/**
	 * 	1、记录当前的ViewRecordCacheKey
	 *	2、更新ViewRecordCacheKey
	 *	3、睡眠2s让之前还在使用中的key 的动作回收
	 *	4、将记录持久化
	 * 
	 */
	public static void AutoPersistViewRecord() {
		
		long startTime = System.currentTimeMillis();
		
		String key = viewRecordsCacheKey;
		updateViewRecordCacheKey();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Logger.error("let me sleep! %s", "AutoPersistViewRecord");
			e.printStackTrace();
		}
		
		List<ViewRecord> vrList = (List<ViewRecord>) Cache.get(key);
		
		if(null == vrList) {
			Cache.delete(key);
			return;
		}
		
		int size = vrList.size();
		DBViewRecord.BatchInsert(vrList);
		
		long endTime = System.currentTimeMillis();
		Logger.info("autoPersist %s data useing time : %s", size,endTime-startTime);
	}
	
	public static String getIndexPageGoodsCacheKey(String page) {
		String fmt = getCacheForKey("/api/jiujiu/%s");
		return String.format(fmt, page);
	}
	
	public static String getImeiIDFA(String imei,String uuid) {
		String imei_ = null==imei?"":imei;
		String uuid_ = null==uuid ? "":uuid;
		return imei_.concat(uuid_);
	}
	
}
