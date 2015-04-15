package controllers;

public class Security extends controllers.Secure.Security {
	
	static boolean authenticate(String username, String password) {
		if("daxiong921".equals(username) && "gxh921921".equals(password)) {
			return true;
		}
		return false;
    }
	
}
