package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name="goods_category")
public class DBCategory extends Model{

	public String categoryName;
	
	public DBCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return this.categoryName;
	}
}
