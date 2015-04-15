package json.model;

import java.util.List;

public class MoreIssues {

	/**
	 * status 返回值：
	 *  0 : 服务器异常
	 *  1 ： 无需更新
	 *  2 ： 数据有更新
	 */
	public int status;
	
	public int pageNum;
	
	public List<Issue> list;
	
	/**
	 * pubInfo:公共信息
	 */
	public PubInfo pubInfo;

	public MoreIssues(int status, int pageNum, List<Issue> list, PubInfo pubInfo) {
		super();
		this.status = status;
		this.pageNum = pageNum;
		this.list = list;
		this.pubInfo = pubInfo;
	}
	
}
