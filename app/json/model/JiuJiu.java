package json.model;

import java.util.List;

public class JiuJiu {

	/**
	 * status 返回值：
	 *  0 : 服务器异常
	 *  1 ： 无需更新
	 *  2 ： 数据有更新
	 */
	
	public int status;
	public int pageNum;
	public int records;
	public boolean lst;
	public Category category;
	public List<Goods> list;
	
	/**
	 * pubInfo:公共信息
	 */
	public PubInfo pubInfo;
	
}
