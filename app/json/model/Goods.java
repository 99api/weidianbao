package json.model;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import models.DBGoods;

public class Goods {
	
	/**
	 * goodsId:商品id
	 */
	public long goodsId;
	
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
	 * openWay:打开方式
	 * 0 : 直接在app中打开
	 * 1 : 跳出app使用浏览器打开
	 */
	public int openWay;
	
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
	public String saleNum;

	public Goods(long goodsId, String goodsUrl, String goodsH5Url, String imgUrl, int openWay,
			String title, double price, String saleNum) {
		super();
		this.goodsId = goodsId;
		this.goodsUrl = goodsH5Url;
		//this.goodsUrl = goodsUrl;
		//this.goodsH5Url = goodsH5Url;
		this.imgUrl = imgUrl;
		this.openWay = openWay;
		this.title = title;
		this.price = price;
		this.saleNum = saleNum;
		
	}
	
	public static List<Goods> transGoods(List<DBGoods> dbgList) {
		
		List<Goods> goodsList = new ArrayList<Goods>();
		for(DBGoods dg : dbgList) {
			Document doc = Jsoup.parse(dg.title);
			Goods g = new Goods(dg.id,dg.goodsUrl,dg.goodsH5Url,dg.imgUrl,dg.openWay,doc.text(),dg.price,transSold(dg.sold));
			goodsList.add(g);
		}
		return goodsList;
	}
	
	public static String transSold(int sold) {
		if(sold<10) {
			return "最近成交10笔以内";
		}
		return "最近成交" + sold + "笔";
	}
	
}
