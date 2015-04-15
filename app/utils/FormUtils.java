package utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import json.model.JsonCallResult;

import org.jsoup.Jsoup;

import play.Logger;
import play.libs.Codec;
import play.utils.HTTP;

public class FormUtils {

	public static boolean isMobilePhone(String phone) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(17[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	public static boolean isImei(String imei) {
		if(null == imei || imei.length()>15) {
			return false;
		}
		return true;
	}
	
	public static boolean isIosIDFA(String uuid) {
		if(null == uuid || uuid.length() > 50) {
			return false;
		}
		return true;
	}
	
	public static boolean isChannel(String channel) {
		if(null == channel || channel.length()>20) {
			return false;
		}
		return true;
	}
	
	/**
	 * 随机生成一个验证码字符
	 * @param length	验证码字符的长度
	 * @param lstFix	混淆验证码的字符串
	 * @param numbercode	boolean 是否全为数字，否则就是数字和字母混合
	 * @return	验证码字符串
	 */
	public static String getCaptchaCode(int length,String lstFix,boolean numbercode) {
		String originCode = Codec.hexMD5(Codec.UUID().concat(null==lstFix?"":lstFix));
		String captchaCode;
		if(numbercode) {
			Pattern p = Pattern.compile("[^0-9]");
			Matcher m = p.matcher(originCode);
			String numberCode = m.replaceAll("").trim();
			captchaCode = numberCode.substring(numberCode.length()-length, numberCode.length());
		} else {
			captchaCode = originCode.substring(originCode.length()-length, originCode.length());
		}
		
		return captchaCode;
	}
	
	public static JsonCallResult sendSongCode(String phone,String code){
		String callAddress = "http://voicecode.uucall.com/uucall/service/voice?number=%s&phone=%s&content=您的验证码是[%s]&pass=%s";
		String uucallNumber = "15980216370";
		String pass = Codec.hexMD5("123456").toUpperCase();
		String callUrl = String.format(callAddress, uucallNumber,phone,code,pass);
		JsonCallResult callResult = null;
		try {
			String json = HTTPCommonUtil.getHttpResponse(callUrl);
			callResult = JsonCallResult.getUUCallCallResultJsonObject(json);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error("call %s fail..", phone);
			callResult = new JsonCallResult("0","服务器链接请求UUCall异常");
		}
		return callResult;
	}
	
	public static String addWhiteBlank(String str,String append) {
		String strs[] = str.split("");
		StringBuffer sb = new StringBuffer(7);
		for(int i=0;i<strs.length;i++) {
			sb.append(strs[i]);
			if(i<strs.length-1) {
				sb.append(append);
			}
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			String originCode = Codec.hexMD5(Codec.UUID().concat("18650808266"));
			Pattern p = Pattern.compile("[^0-9]");     
			Matcher m = p.matcher(originCode);
			String numberCode = m.replaceAll("").trim();
			String captcha = numberCode.substring(numberCode.length()-4, numberCode.length());
			System.out.println(captcha);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start + "ms");
		System.out.println(Codec.hexMD5("asdf"));
		System.out.println(getCaptchaCode(4,"18559691033",true));
//		sendSongCode("18650808266","1234");
		
		
		
	}

	
}
