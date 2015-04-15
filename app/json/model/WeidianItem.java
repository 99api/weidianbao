package json.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import utils.JsonToMap;

import models.DBCategory;
import models.DBSource;

public class WeidianItem {

	
	public String itemId;
	
	/**
	 * 库存
	 */
	public int stock;
	
	/**
	 * goodsUrl:webview对应的url
	 */
	public String goodsUrl;
	
	/**
	 * goodsH5Url:webview对应的HTML5 url
	 */
	public String goodsH5Url;
	
	/**
	 * imgUrl:图片网址
	 */
	public String imgUrl;
	
	/**
	 * 商品标题
	 */
	public String title;
	
	/**
	 * 商品价格
	 */
	public double price;
	
	/**
	 * 销售数量
	 */
	public int sold;

	/**
	 * 商品的佣金比例
	 */
	public double rate;

	public WeidianItem(String itemId, int stock, String goodsUrl,String goodsH5Url,
			String imgUrl, String title, double price, int sold,
			double rate) {
		super();
		this.itemId = itemId;
		this.stock = stock;
		this.goodsUrl = goodsUrl;
		this.imgUrl = imgUrl;
		this.title = title;
		this.price = price;
		this.sold = sold;
		this.rate = rate;
		this.goodsH5Url = goodsH5Url;
	}
	
	public WeidianItem() {
		
	}

	@Override
	public String toString() {
		String str = " itemId:%s \n title:%s \n stock:%s \n goodsUrl:%s \n imgUrl:%s \n price:%s \n sold:%s \n rate:%s ";
		
		return String.format(str, this.itemId,this.title,this.stock,this.goodsUrl,this.imgUrl,this.price,this.sold,this.rate);
	}


	public static WeidianItem fullWeidianItemDataFromJson(String json) {
		Map<String, Object> jsonMap = JsonToMap.toMap(JsonToMap.toMap(json).get("result").toString());
		WeidianItem item = new WeidianItem();
		item.goodsUrl = jsonMap.get("click_url").toString().replace("\"", "");
		item.imgUrl = ((List<Object>) jsonMap.get("imgs")).get(0).toString().replace("\"", "");
		
		//price 特殊处理
		String pc = jsonMap.get("price").toString().replace("\"", "");
		if(pc.contains("-")) {
			pc = pc.split("-")[0];
		}
		item.price = Double.parseDouble(pc);
		
		
		item.rate = Double.parseDouble(jsonMap.get("rate").toString());
		item.sold = Integer.parseInt(jsonMap.get("sold").toString());
		item.stock = Integer.parseInt(jsonMap.get("stock").toString());
		item.title = jsonMap.get("item_name").toString().replace("\"", "");
		item.itemId = jsonMap.get("itemid").toString().replace("\"", "");
		item.goodsH5Url = jsonMap.get("h5_click_url").toString().replace("\"", "");
		
		return item;
	}
	
}
