package evn;

import play.Logger;


public class CacheKeyPrefix {

	public final static String frequenceCacheTime = "30mn";
	public final static String blackListCacheTime = "24h";
	public final static String captchaEffectTime = "30mn";
	public final static String songMessageCodeEffectTime = "10mn";
	public final static String allowRegTime = "6h";
	
	public final static String frequencePhone = "frequencePhonePrefix://";
	public final static String frequenceIP = "frequenceIPPrefix://";
	public final static String frequenceImeiUUID = "frequenceImeiUUIDPrefix://";
	
	public final static String blackListPhone = "blackListPhone://";
	public final static String blackListIP = "blackListIP://";
	public final static String blackListImeiUUID = "blackListImeiUUID://";
	
	public final static String captchaKey = "captchaKey://";
	public final static String captchaValue = "captchaValue://";
	
	public final static String songMessageCode = "songMessageCode://";
	
	public final static String allowSignupPhone = "allowSignupPhone://";
	
	public final static String autologin = "autologin://";
	
	public final static String user = "cacheUser://";
	
	/**
	 * @param phone
	 * @return 记录频率的phone key
	 */
	public static String getFrequencePhone(String phone) {
		return frequencePhone.concat(phone);
	}
	
	/**
	 * 
	 * @param IP
	 * @return 记录频率的IP key
	 */
	public static String getFrequenceIP(String IP) {
		return frequenceIP.concat(IP);
	}
	
	/**
	 * @param imei
	 * @param uuid
	 * @return 记录频率的imei uuid key
	 */
	public static String getFrequenceImeiUUID(String imei,String uuid) {
		return frequenceImeiUUID.concat(null==imei?"":imei).concat(null==uuid?"":uuid);
	}
	
	/**
	 * 
	 * @param phone
	 * @return phone 黑名单 key
	 */
	public static String getBlackListPhone(String phone) {
		return blackListPhone.concat(phone);
	}
	
	/**
	 * 
	 * @param IP
	 * @return ip 的黑名单 key
	 */
	public static String getBlackListIP(String IP) {
		return blackListIP.concat(IP);
	}
	
	/**
	 * 
	 * @param imei
	 * @param uuid
	 * @return 黑名单的imei uuid key
	 */
	public static String getBlackListImeiUUID(String imei,String uuid) {
		return blackListImeiUUID.concat(null==imei?"":imei).concat(null==uuid?"":uuid);
	}

	public static String getCaptchaKey(String phone) {
		return captchaKey.concat(null==phone?"":phone);
	}
	
	public static String getCaptchaValue(String key) {
		return captchaValue.concat(null==key?"":key);
	}
	
	public static String getSongMessageCode(String phone) {
		return songMessageCode.concat(phone);
	}
	
	public static String getAllowSignupPhone(String phone) {
		return allowSignupPhone.concat(phone);
	}
	
	public static String getAutoLogin(String token) {
		return autologin.concat(null==token?"":token);
	}
	
	public static String getCacheUser(String userAliasId){
		return user.concat(userAliasId);
	}
	
	public static void main(String[] args) {
		System.out.println(getFrequencePhone("18650808266"));
		System.out.println(getFrequenceImeiUUID("asdfasdfasdfasdfasdfasdf", null));
		Logger.info("[%s],[%s]", "aa",null);
	}
	
}
