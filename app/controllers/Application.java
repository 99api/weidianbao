package controllers;

import play.*;
import play.cache.Cache;
import play.cache.CacheFor;
import play.mvc.*;
import utils.HTTPCommonUtil;
import utils.IpUtils;
import utils.JsonToMap;

import java.util.*;

import evn.PubParam;
import json.model.Category;
import json.model.Goods;
import json.model.Issue;
import json.model.JiuJiu;
import json.model.MoreIssues;
import json.model.ViewRecord;
import json.model.WeidianItem;
import models.*;

public class Application extends Controller {

	@CacheFor
    public static void index() {
    	render();
    }
    
    @CacheFor("15min")
    public static void jiujiu(String pageNum) {
    	JiuJiu jiujiu = new JiuJiu();
    	jiujiu.pageNum = getPage(pageNum);
    	jiujiu.status = 2;
    	Category c = new Category();
    	c.categoryName = "九块九包邮";
    	jiujiu.category = c;
    	List<DBGoods> dbgList = DBGoods.find("isPub = ? order by addtime desc",true).fetch(jiujiu.pageNum, PubParam.getPageRecord());
    	jiujiu.list = Goods.transGoods(dbgList);
    	
    	jiujiu.records = PubParam.getPageRecord();
    	jiujiu.lst = dbgList.size() == jiujiu.records?false :true;
    	
    	Logger.info("cache the api/jiujiu/%s", jiujiu.pageNum);
    	
        renderJSON(jiujiu);
    }
    
    @CacheFor("15min")
    public static void moreIssues() {
    	List<DBIssue> dbiList = DBIssue.find("isPub = ? order by orderFlag desc", true).fetch();
    	List<Issue> issues = Issue.getIssues(dbiList);
    	MoreIssues mi = new MoreIssues(1, 1, issues, null);
    	
    	Logger.info("cache the api/more");
    	
    	renderJSON(mi);
    }
    
    /**
     * 
     * @param deviceType  设备类型 iPhone or Android
     * @param os 		  操作系统信息
     * @param sw		  屏幕宽度
     * @param sh		  屏幕高度
     * @param v			  app版本号
     * @param imei		  设备 imei 号
     * @param uuid        设备uuid
     * @param channel     渠道来源
     * 
     * 请求实例：http://hot.gara.cc/api/listening?deviceType=android&os=ios 6.01&sw=640&sh=960&v=1.0.1&imei=xxxxxx&uuid=xxxxx&channel=yingyongbao
     * 
     */
    public static void listening(String deviceType,String os,String sw,String sh,String v,String imei,String uuid,String channel) {
    	String ip = request.headers.get("x-real-ip").value();
    	Logger.info("listening : %s",ip);
    	long time = new Date().getTime();
    	ViewRecord vr = new ViewRecord(IpUtils.ipToLong(IpUtils.singleIp(ip)),deviceType,os,sw,sh,v,imei,uuid,channel,time);
    	PubParam.CacheViewRecord(vr);
    	renderText(ip + " : " + channel + " ok");
    }
    
    /**
     * 
     * @param pageNum 页码
     * @return 过滤掉页数中异常后的页码
     */
    public static int getPage(String pageNum) {
    	int page=0;
    	try {
    		page = Integer.parseInt(pageNum);
    	} catch (Exception e) {
    		page = 0;
		}finally {
			if(page<1) {
				page = 1;
			}
		}
		return page;
		
    }
    
    
    
    public static void main(String[] args) throws Exception {
//    	String s = "http://m.hot.weidian.com/cpszhuti?group_id=40&w=SBT3IARj7zHUFRTiAuII/i6SIpZ5JC2u6XZ/Ww841StTlM=&mkId=1857976";
//		String ss = "http://weidian.com/item.html?itemID=1092637894&sk=WLU798Uf0D6fb8RAyXAn477x0YvJDO+II0bAWskiQMjUtuSTAjLK7iZf85+C0UZF&wfr=kd!hotH5!NA!NA!1427090452655!union_1857976_1_108_0_0_ueaOXvau&eventBackURL=http://m.hot.weidian.com/cpszhuti?group_id=36&w=SBT3IARj7zHUFRTiAuII/i6SE24ZJ3CtZge/Ww841StTlM=&mkId=1857976";
		
//		String token = PubParam.getWeidianAccessTokenOnLine();
//		System.out.println(token);
		
//		String apiUrl = "https://api.vdian.com/api?public={\"method\":\"vdian.cps.item.get\",\"access_token\":\"3e2ec8329a26acdb9b0062f9f152f326\",\"version\":\"1.0\",\"format\":\"json\"}&param={\"itemid\":\"272475237\"}";
		
		
//		PubParam.getWeidianAccessTokenOnLine();
		
		String apiUrl = "https://api.vdian.com/api?public={\"method\":\"vdian.cps.item.get\",\"access_token\":\"%s\",\"version\":\"1.0\",\"format\":\"json\"}&param={\"itemid\":\"%s\"}";
		
		
		
		String url = String.format(apiUrl, "37740250e4c4096bedc433e60d62943d","376787406");
		System.out.println(url);
		String json = HTTPCommonUtil.getJsonString(url);
		System.out.println(json);
//		Map<String, Object> jsonMap = JsonToMap.toMap(JsonToMap.toMap(json).get("result").toString());
		
		
		WeidianItem wdi = WeidianItem.fullWeidianItemDataFromJson(json);
		System.out.println(wdi);
		
	}    

}