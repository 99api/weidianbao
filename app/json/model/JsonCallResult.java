package json.model;

import java.util.Map;

import utils.JsonToMap;

public class JsonCallResult {

	/**
	 * status
	 * 1:ok
	 * 104:参数错误
	 * 1001:用户不存在
	 * 102:数据库错误
	 * 1010:密码错误
	 * 
	 * 0：自身服务器请求异常
	 */
	public String status;
	public String desc;
	
	
	public JsonCallResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JsonCallResult(String status, String desc) {
		super();
		this.status = status;
		this.desc = desc;
	}


	@Override
	public String toString() {
		String format = "status:%s , desc:%s";
		return String.format(format, this.status,this.desc);
	}
	
	public static JsonCallResult getUUCallCallResultJsonObject(String json){
		Map<String, Object> jsonMap = JsonToMap.toMap(json);
		String desc = jsonMap.get("desc").toString().replaceAll("\"", "");
		String status = jsonMap.get("status").toString().replaceAll("\"", "");
		return new JsonCallResult(status,desc);
	}
	
	public static void main(String[] args) {
		String json = "{\"desc\":\"OK\",\"status\":\"1\"}";
		System.out.println(getUUCallCallResultJsonObject(json).toString());
	}
}
