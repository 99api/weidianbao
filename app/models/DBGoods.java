package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import evn.PubParam;

import json.model.Goods;
import json.model.WeidianItem;

import play.db.jpa.Model;

@Entity
@Table(name="goods")
public class DBGoods extends Model{
	
	
	/**
	 * 商品ID，对应于外网网站的
	 */
	@Column(columnDefinition="varchar(20)")
	public String itemId;
	
	/**
	 * 库存
	 */
	public int stock;
	
	/**
	 * goodsUrl:webview对应的url
	 */
	@Column(columnDefinition="varchar(600)")
	public String goodsUrl;
	
	/**
	 * goodsH5Url:webview对应的HTML5 的 url
	 */
	@Column(columnDefinition="varchar(600)")
	public String goodsH5Url;
	
	/**
	 * imgUrl:图片网址
	 */
	@Column(columnDefinition="varchar(300)")
	public String imgUrl;
	
	/**
	 * openWay:打开方式
	 * 0 : 直接在app中打开
	 * 1 : 跳出app使用浏览器打开
	 */
	public int openWay = 0;
	
	/**
	 * 商品标题
	 */
	@Column(columnDefinition="varchar(6000)")
	public String title;
	
	/**
	 * 商品价格
	 */
	
	@Column(columnDefinition="DECIMAL(9,2)")
	public double price;
	
	/**
	 * 销售数量
	 */
	public int sold;

	@ManyToOne(targetEntity=DBCategory.class)
	public DBCategory category;
	
	/**
	 * 商品的佣金比例
	 */
	@Column(name="goodsRate")
	public double rate;
	
	public long addTime = new Date().getTime();
	
	/**
	 * 排序，数字大的排列在前面
	 */
	public int orderFlag = 0;
	
	/**
	 * 商品来源：例如来源于 微店 等
	 */
	@ManyToOne(targetEntity=DBSource.class)
	public DBSource source;
	
	public boolean isPub = true;
	
	
	@Override
	public String toString() {
		return this.title;
	}

	/**
	 * 1、判断是否已经存在属于这个itemId的商品
	 * 2、如果已经存在，更新数据
	 * 3、如果不存在，插入数据
	 * 4、将dbItemID表里面的同步标记成已同步
	 */
	public static void checkAndUpdateOrInsertGoods(DBWeidianGoodsItem dbItem,
			WeidianItem item) {
		DBGoods goods = DBGoods.find("itemId=?", item.itemId).first();
		if(goods != null) {
			//更新数据
			goods.addTime = new Date().getTime();
			goods.category = PubParam.getWeidianCategory();
			goods.goodsUrl = item.goodsUrl;
			goods.goodsH5Url = item.goodsH5Url;
			goods.imgUrl = item.imgUrl;
			goods.isPub = true;
			goods.itemId = item.itemId;
			goods.price = item.price;
			goods.rate = item.rate;
			goods.sold = item.sold;
			goods.source = PubParam.getWeidianSource();
			goods.stock = item.stock;
			goods.title = item.title;
		} else {
			//插入数据
			goods = new DBGoods();
			goods.addTime = new Date().getTime();
			goods.category = PubParam.getWeidianCategory();
			goods.goodsUrl = item.goodsUrl;
			goods.goodsH5Url = item.goodsH5Url;
			goods.imgUrl = item.imgUrl;
			goods.isPub = true;
			goods.itemId = item.itemId;
			goods.price = item.price;
			goods.rate = item.rate;
			goods.sold = item.sold;
			goods.source = PubParam.getWeidianSource();
			goods.stock = item.stock;
			goods.title = item.title;
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println(goods.itemId);
		System.out.println(goods.title);
		goods = goods.save();

		System.out.println("-------------------------------------------------");
		//更新DBItemID表的同步状态
		DBWeidianGoodsItem.syncFlag(item);
		
	}
}
