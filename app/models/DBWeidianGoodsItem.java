package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import json.model.WeidianItem;

import play.db.jpa.Model;

@Entity
@Table(name="weidian_goods_item")
public class DBWeidianGoodsItem extends Model {

	@Column(columnDefinition="varchar(20)")
	public String itemId;
	
	/**
	 * isSync false  还未同步
	 * 		  true   已同步
	 */
	public boolean isSync = false;
	
	public long addTime = new Date().getTime();
	
	@ManyToOne(targetEntity=DBCategory.class)
	public DBCategory category;
	
	@ManyToOne(targetEntity=DBSource.class)
	public DBSource source;

	public static void syncFlag(WeidianItem item) {
		List<DBWeidianGoodsItem> dbItemList = DBWeidianGoodsItem.find("itemId=?", item.itemId).fetch();
		for(DBWeidianGoodsItem dbItem:dbItemList) {
			dbItem.isSync = true;
			dbItem.save();
		}
	}
	
}
