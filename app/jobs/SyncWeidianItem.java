package jobs;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mysql.jdbc.log.Log;

import json.model.WeidianItem;

import evn.PubParam;

import models.DBGoods;
import models.DBWeidianGoodsItem;

import play.Logger;
import play.Play;
import play.cache.Cache;
import play.jobs.Every;
import play.jobs.Job;
import play.utils.HTML;
import utils.HTTPCommonUtil;

@Every("10mn")
public class SyncWeidianItem extends Job{

	/**
	 * 同步有几个步骤：
	 * 1、获取需要同步的itemId
	 * 2、循环需要同步的itemId，从微店api中获取对应的商品数据
	 * 3、通过itemId从数据库中查找，看是否item已经存在
	 * 4、如果已经存在，逐一检查数据是否一致，如果不一致就更新数据
	 * 5、如果数据不存在，插入该条数据
	 * 6、将待同步列表中的itemId项标记成已同步
	 * 7、清空商品数据的缓存
	 */
	
	@Override
	public void doJob() throws Exception {
		if(Play.mode.isProd()) {
			Logger.info("start sync Weidian data");
			rangeSyncItemIds();
			Logger.info("end sync Weidian data");
			clearGoodsCache();
		}
	}
	
	public static void clearGoodsCache() {
		for(int i=1;i<100;i++) {
			Cache.delete(PubParam.getIndexPageGoodsCacheKey(i+""));
		}
	}

	public static void rangeSyncItemIds() {
		List<DBWeidianGoodsItem> itemIdList = getItemIdList();
		for(DBWeidianGoodsItem dbItem:itemIdList) {
			WeidianItem item = getWeidianItemDataFromWeidianAPI(dbItem.itemId);
			
			//如果item是空的，说明在远程读取的时候遇到的问题，这时候我们得检查一下了.
			if(null==item) {
				Logger.error("loding api data exception.. ItemId:%s", dbItem.itemId);
				continue;
			}
			
			DBGoods.checkAndUpdateOrInsertGoods(dbItem,item);
		}
	}
	
	/**
	 * 获取需要同步的itemId
	 * @return itemId List
	 */
	public static List<DBWeidianGoodsItem> getItemIdList() {
		List<DBWeidianGoodsItem> itemIds = DBWeidianGoodsItem.find("isSync=? and category=? and source=? order by id asc", false,PubParam.getWeidianCategory(),PubParam.getWeidianSource()).fetch(200);
		return itemIds;
	}
	
	/**
	 * 通过微店ItemId获取微店的商品Item
	 * @param itemId
	 * @return WeidianItem
	 */
	public static WeidianItem getWeidianItemDataFromWeidianAPI(String itemId) {
		String apiUrl = "https://api.vdian.com/api?public={\"method\":\"vdian.cps.item.get\",\"access_token\":\"%s\",\"version\":\"1.0\",\"format\":\"json\"}&param={\"itemid\":\"%s\"}";
		String accessToken;
		try {
			accessToken = PubParam.getWeidianAccessToken();
		} catch (Exception e) {
			Logger.error("getAccessToken error!");
//			e.printStackTrace();
			return null;
		}
		String url = String.format(apiUrl, accessToken,itemId);
		String json = null;
		try {
			json = HTTPCommonUtil.getJsonString(url);
			System.out.println(json);
			return WeidianItem.fullWeidianItemDataFromJson(json);		
		} catch (Exception e) {
			Logger.error("getWeidianItemAPI error..");
//			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		/*
		String html = "【口袋春上新】栀子花耳钉韩国 可爱 耳环 韩国 时尚夸张 耳饰 小饰品 1对 <br />\n栀子花开。白色珐琅镶钻耳环大大的，很有气质，尤其适合盘发的装束，很有韩国女主角的味道！<br />\n！！！！！重要说明！！！！！<br />\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓<br />\n1：小饰品东西不能喝专柜几百几千元的正品相比对，毕竟不是专卖，我想您如果拿放大镜购物，什么东西都可以挑出问题的，对于质量非常苛刻的客户，请到专柜购买！<br />\n2：实物与图片难免会有些色差，望理解！<br />\n3：除非有质量问题，本店不接受任何因为不喜欢、和想象的不一样、佩戴不好看等理由的退换货。<br />\n4：图片仅供参考，谢绝您的想象和您个人的主观想法。每个人的想象都无限大，无法一一满足，请以实物为准！<br />\n5：对合金材质过敏的MM慎重下手，每个人的体质不一样，请理解！";
		
		System.out.println(html);
		System.out.println("***************************************************");
		Document doc = Jsoup.parse(html);
		System.out.println(doc.text());
		*/
		String json = "{\"result\":{\"itemid\":\"868120022\",\"item_name\":\"可爱羊年小羊毛绒公仔玩偶 三羊开泰绵羊玩具布娃娃 新年礼品批发\",\"stock\":3001,\"price\":\"18.62-34.30\",\"sold\":0,\"seller_id\":\"261331840\",\"item_url\":\"http://wd.koudai.com/item.html?itemID=868120022\",\"skus\":[{\"id\":\"2281112860\",\"title\":\"灰色-25厘米\",\"price\":\"18.62\",\"stock\":509,\"sku_merchant_code\":null},{\"id\":\"2281112862\",\"title\":\"灰色-40厘米\",\"price\":\"34.30\",\"stock\":540,\"sku_merchant_code\":null},{\"id\":\"2281112864\",\"title\":\"粉色-25厘米\",\"price\":\"18.62\",\"stock\":494,\"sku_merchant_code\":null},{\"id\":\"2281112866\",\"title\":\"粉色-40厘米\",\"price\":\"34.30\",\"stock\":480,\"sku_merchant_code\":null},{\"id\":\"2281112868\",\"title\":\"米白-25厘米\",\"price\":\"18.62\",\"stock\":465,\"sku_merchant_code\":null},{\"id\":\"2281112870\",\"title\":\"米白-40厘米\",\"price\":\"34.30\",\"stock\":513,\"sku_merchant_code\":null}],\"imgs\":[\"http://wd.geilicdn.com/vshop261331840-1420872030-867413.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872031-58145.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872031-302433.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872031-495272.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872031-675838.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872031-996315.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872032-130326.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872032-493964.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872032-701971.jpg?w=480&h=0\",\"http://wd.geilicdn.com/vshop261331840-1420872032-839482.jpg?w=480&h=0\"],\"thumb_imgs\":[\"http://wd.geilicdn.com/vshop261331840-1420872030-867413.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872031-58145.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872031-302433.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872031-495272.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872031-675838.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872031-996315.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872032-130326.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872032-493964.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872032-701971.jpg?w=110&h=110&cp=1\",\"http://wd.geilicdn.com/vshop261331840-1420872032-839482.jpg?w=110&h=110&cp=1\"],\"rate\":9.0,\"click_url\":\"http://v5.cc/5TK3ZcO5\",\"h5_click_url\":\"http://v5.cc/zfNalG43\"},\"status\":{\"status_code\":0,\"status_reason\":\"success\"}}";
		WeidianItem item = WeidianItem.fullWeidianItemDataFromJson(json);
		System.out.println(item);
	}
}
