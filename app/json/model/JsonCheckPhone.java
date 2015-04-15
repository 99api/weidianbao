package json.model;

public class JsonCheckPhone {

	/**
	 * status 
	 * 状态： 0/错误 1/进入下一步
	 */ 
	public int status;
	
	public String tip;
	
	public boolean isReg;
	
	public String phone;
	
	public JsonCheckPhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonCheckPhone(int status, String tip, boolean isReg, String phone) {
		super();
		this.status = status;
		this.tip = tip;
		this.isReg = isReg;
		this.phone = phone;
	}
	
}
