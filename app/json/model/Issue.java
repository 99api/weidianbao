package json.model;

import java.util.ArrayList;
import java.util.List;

import models.DBIssue;

public class Issue {

	/**
	 * issueImgUrl： issue封面url
	 */
	public String issueImgUrl;
	
	/**
	 * issueUrl:issue 链接
	 */
	public String issueUrl;
	
	/**
	 * defaultString:issue没有加载出来的时候，显示的字符内容
	 */
	public String defaultString;
	
	/**
	 * openWay:打开方式
	 * 0 : 直接在app中打开
	 * 1 : 跳出app使用浏览器打开
	 */
	public int openWay;

	public Issue(String issueImgUrl, String issueUrl, String defaultString,
			int openWay) {
		super();
		this.issueImgUrl = issueImgUrl;
		this.issueUrl = issueUrl;
		this.defaultString = defaultString;
		this.openWay = openWay;
	}
	
	public static List<Issue> getIssues(List<DBIssue> dbiList) {
		List<Issue> issueList = new ArrayList<Issue>();
		
		for(DBIssue dbi:dbiList) {
			Issue i= new Issue(dbi.issueImgUrl,dbi.issueUrl,dbi.defaultString,dbi.openWay);
			issueList.add(i);
		}
		
		return issueList;
	}
	
}
