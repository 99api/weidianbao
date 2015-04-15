package json.model;

import controllers.Account;

public class JsonReg {

	public int status;
	public String tip;
	public Userinfo userinfo;
	
	public JsonReg() {
		super();
	}

	public JsonReg(int status, String tip, Userinfo userinfo) {
		super();
		this.status = status;
		this.tip = tip;
		this.userinfo = userinfo;
	}
	
}
