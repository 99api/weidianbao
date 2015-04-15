package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name="issue")
public class DBIssue extends Model{

	/**
	 * issueImgUrl： issue封面url
	 */
	@Column(columnDefinition="varchar(300)")
	public String issueImgUrl;
	
	/**
	 * issueUrl:issue 链接
	 */
	@Column(columnDefinition="varchar(300)")
	public String issueUrl;
	
	/**
	 * defaultString:issue没有加载出来的时候，显示的字符内容
	 */
	@Column(columnDefinition="varchar(50)")
	public String defaultString;
	
	/**
	 * openWay:打开方式
	 * 0 : 直接在app中打开
	 * 1 : 跳出app使用浏览器打开
	 */
	public int openWay = 0;

	public long addTime = new Date().getTime();
	
	public boolean isPub = true;
	
	/**
	 * 排序，数字大的排列在前面
	 */
	public int orderFlag = 0;
	
	public DBIssue(String issueImgUrl, String issueUrl, String defaultString,
			int openWay) {
		super();
		this.issueImgUrl = issueImgUrl;
		this.issueUrl = issueUrl;
		this.defaultString = defaultString;
		this.openWay = openWay;
	}
	
	@Override
	public String toString() {
		return this.defaultString;
	}
	
}
