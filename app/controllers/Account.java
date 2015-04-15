package controllers;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import jj.play.ns.nl.captcha.gimpy.DropShadowGimpyRenderer;

import org.apache.log4j.PatternLayout;

import models.DBAutoLogin;
import models.DBUser;
import models.DBValidMessage;
import evn.CacheKeyPrefix;
import evn.PubParam;
import evn.Tips;
import json.model.JsonCallResult;
import json.model.JsonCheckPhone;
import json.model.JsonReg;
import json.model.JsonSongMsg;
import json.model.Userinfo;
import play.Logger;
import play.Play;
import play.cache.Cache;
import play.libs.Codec;
import play.libs.Images;
import play.mvc.Controller;
import play.mvc.results.RenderJson;
import play.utils.Utils;
import utils.FormUtils;
import utils.HTTPCommonUtil;
import utils.IpUtils;

public class Account extends Controller {

	/**
	 * 发送语音验证码
	 * @param phone
	 * @return true成功
	 */
	private static boolean sendSongValidMessage(String phone) {
		String code = FormUtils.getCaptchaCode(4, phone, true);
		JsonCallResult cr = sendSongCode(phone,code);
		
		if(cr.status.equals("0")) {
			return false;
		}
		Cache.set(CacheKeyPrefix.getSongMessageCode(phone), code,CacheKeyPrefix.songMessageCodeEffectTime);
		return true;
	}

	private static JsonCallResult sendSongCode(String phone,String code){
		String callAddress = "http://voicecode.uucall.com/uucall/service/voice?number=%s&phone=%s&content=您的验证码是[%s]&pass=%s";
		String uucallNumber = "15980216370";
		String pass = Codec.hexMD5("123456").toUpperCase();
		String callUrl = String.format(callAddress, uucallNumber,phone,code,pass);
		JsonCallResult callResult = null;
		try {
			if(Play.mode.isProd() ){
				String json = HTTPCommonUtil.getHttpResponse(callUrl);
				callResult = JsonCallResult.getUUCallCallResultJsonObject(json);
			} else {
				callResult = new JsonCallResult("1","ok");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error("call %s fail..", phone);
			callResult = new JsonCallResult("0","request UUCall");
		}
		new DBValidMessage(phone,code,"注册验证",callResult.status,callResult.desc,new Date().getTime()).save();
		return callResult;
	}
	
	/**
	 * 检查参数，看是否符合加入黑名单的条件，如果符合条件，将其加入黑名单
	 * @param phone
	 * @param ip
	 * @param imei
	 * @param uuid
	 */
	private static void blackListChecker(String phone, String ip, String imei,
			String uuid) {
		
		long start = System.currentTimeMillis();
		String frePhoneKey = CacheKeyPrefix.getFrequencePhone(phone);
		String freIPKey = CacheKeyPrefix.getFrequenceIP(ip);
		String freIUKey = CacheKeyPrefix.getFrequenceImeiUUID(imei, uuid);
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		int phonerate = Cache.get(frePhoneKey)==null?0:(Integer)Cache.get(frePhoneKey);
		if (phonerate > 9) {
			Cache.add(CacheKeyPrefix.getBlackListPhone(phone), 1, CacheKeyPrefix.blackListCacheTime);// 将phone拉入黑名单
			sb.append(null==phone?"":phone).append(" in black list..").append("\n");
		}
		
		int iprate = Cache.get(freIPKey)==null?0:(Integer)Cache.get(freIPKey);
		if(iprate>19) {
			Cache.add(CacheKeyPrefix.getBlackListIP(ip), 1,CacheKeyPrefix.blackListCacheTime);//将ip拉入黑名单
			sb.append(null==ip?"":ip).append(" in black list..").append("\n");
		}
		
		int imeiuuidrate = Cache.get(freIUKey)==null?0:(Integer)Cache.get(freIUKey);
		if(imeiuuidrate>9) {
			Cache.add(CacheKeyPrefix.getBlackListImeiUUID(imei, uuid), 1,CacheKeyPrefix.blackListCacheTime);//将imei uuid拉入黑名单
			sb.append("imei :").append(null==imei?"":imei).append(" & idfa :").append(null==uuid?"":uuid).append(" in black list").append("\n");
		}
	    long end = System.currentTimeMillis();
	    sb.append("use time:").append((end-start)).append("ms");
	    Logger.info(sb.toString());
	}

	/**
	 * 获取图片验证码的地址
	 * @return	url
	 */
	private static String getCaptchaImgUrl(String phone) {
		String captchaId = Codec.hexMD5(Codec.UUID().concat(phone));
		String captchaUrl = "http://hot.gara.cc/api/captcha/%s/%s";
		
		if(Play.mode.isDev()) {
			captchaUrl = "http://localhost:9000/api/captcha/%s/%s";
		}
		
		String captchaKey = CacheKeyPrefix.getCaptchaKey(phone);
		
		Cache.set(captchaKey, captchaId,CacheKeyPrefix.captchaEffectTime);
		
		return String.format(captchaUrl, phone,captchaId);
	}

	/**
	 * 记录用户请求发送语音验证码的频次
	 * @param phone
	 * @param ip
	 * @param imei
	 * @param uuid
	 */
	private static void recordSongMessageFrequence(String phone, String ip,
			String imei, String uuid) {
		long start = System.currentTimeMillis();
		
		String phoneKey = CacheKeyPrefix.getFrequencePhone(phone);
		String ipKey = CacheKeyPrefix.getFrequenceIP(ip);
		String imeiUUIDKey = CacheKeyPrefix.getFrequenceImeiUUID(imei, uuid);
		
		int phoneCallTimes = 1;
		int ipCallTimes = 1;
		int imeiuuidCallTimes = 1;
		
		if (null==Cache.get(phoneKey) ) {
			Cache.add(phoneKey, phoneCallTimes, CacheKeyPrefix.frequenceCacheTime);
		} else {
			phoneCallTimes = (Integer) Cache.get(phoneKey);
			Cache.replace(phoneKey, (++phoneCallTimes), CacheKeyPrefix.frequenceCacheTime);
		}
		
		if (null == Cache.get(ipKey) ) {
			Cache.add(ipKey, ipCallTimes, CacheKeyPrefix.frequenceCacheTime);
		} else {
			ipCallTimes = (Integer) Cache.get(ipKey);
			Cache.replace(ipKey, (++ipCallTimes), CacheKeyPrefix.frequenceCacheTime);
		}
		
		if (null==Cache.get(imeiUUIDKey)) {
			Cache.add(imeiUUIDKey, imeiuuidCallTimes, CacheKeyPrefix.frequenceCacheTime);
		} else {
			imeiuuidCallTimes = (Integer) Cache.get(imeiUUIDKey);
			Cache.replace(imeiUUIDKey, (++imeiuuidCallTimes) , CacheKeyPrefix.frequenceCacheTime);
		}
		
		long end = System.currentTimeMillis();
		Logger.info(" phone [%s]'s frequence [%d];\n ip [%s]'s frequence [%d];\n imei [%s] and idfa [%s]'s frequence [%d];\n cache useing time: [%s]", phone,phoneCallTimes,ip,ipCallTimes,imei,uuid,imeiuuidCallTimes,(end-start)+"ms");
	}

	/**
	 * 判断给这个手机号发送语音验证码的时候，是否需要用图形验证码验证
	 * @param phone
	 * @return
	 */
	private static boolean isNeedCaptcha(String phone) {
		String phoneKey = CacheKeyPrefix.getFrequencePhone(phone);
		Object phoneCountObj = Cache.get(phoneKey);
		if(null == phoneCountObj || ((Integer)phoneCountObj).intValue() < 3) {
			return false;
		}
		return true;
	}
	
	/**
	 * 判断这个请求的用户是否在黑名单中
	 * @param phone
	 * @param ip
	 * @param imei
	 * @param uuid
	 * @return true 在黑名单  false 不在黑名单
	 */
	private static boolean inBlackList(String phone, String ip, String imei,
			String uuid) {
		String phoneKey = CacheKeyPrefix.getBlackListPhone(phone);
		String ipKey = CacheKeyPrefix.getBlackListIP(ip);
		String iuKey = CacheKeyPrefix.getBlackListImeiUUID(imei, uuid);
		
		if(Cache.get(phoneKey) != null) {
			Logger.info("*********Phone [ %s ] in break list", phone);
			return true;
		}
		
		if(Cache.get(ipKey) != null) {
			Logger.info("*********ip [ %s ] in break list", ip);
			return true;
		}
		
		if(Cache.get(iuKey) != null) {
			Logger.info("*********imei [ %s ] and idfa [ %s ] in break list", imei,uuid);
			return true;
		}
		
		return false;
	}
	
	public static void captcha(String phone,String captchaId) {
		//判断是否被恶意访问
		String captchaKey = CacheKeyPrefix.getCaptchaKey(phone);
		Object cvkObj =  Cache.get(captchaKey);
		
		String captchaValue = cvkObj==null?"--_null":(String)cvkObj;
		if(null == captchaId || !captchaId.equals(captchaValue)) {
			// 恶意访问
			renderText("opps..非法的请求");
		} else {
			//正确的访问，生成图片验证码
			
			Images.Captcha captcha = null;
			captcha = Images.captcha();
//		    captcha.gimpy = new DropShadowGimpyRenderer();
		    captcha.w = 280;
		    captcha.h = 75;
		    String code = captcha.getText(4, "0123456789");
		    String cc = FormUtils.addWhiteBlank(code," ");
		    Logger.info("captcha code is [%s]", cc);
		    captcha.text = cc;
//		    captcha.fonts.clear();
		    captcha.textColor = Color.decode("#9E5E5F");
		    captcha.setBackground("#F5FAFA","#D4EBE2");
		    captcha.addNoise();
		    captcha.fonts.clear();
		    captcha.fonts.add(new Font("Arial", Font.ITALIC, 55));
		    
		    captcha.setSquigglesBackground();
		    String captchaValueKey = CacheKeyPrefix.getCaptchaValue(captchaValue);
		    
		    
		    Cache.set(captchaValueKey, code,"30mn");
		    String codeAlis = (String) Cache.get(captchaValueKey);
		    Logger.info("\n\ncaptchaValueKey:%s\ncode:%s\nphone:%s\ncodeAlis:%s\n", captchaValueKey,Cache.get(captchaValueKey),phone,codeAlis);
		    renderBinary(captcha);
		}
	}
	
	/**
	 * 通过手机号判断程序接下来要进入到哪一步的action
	 * @param phone
	 * @param imei
	 * @param uuid
	 */
	public static void checkPhone(String phone,String imei,String uuid,String channel){
		//判断手机号码是否正确,如果手机号错误的话执行以下这段判断
		if(!FormUtils.isMobilePhone(phone)) {
			renderJSON(new JsonCheckPhone(1,Tips.phoneError,false,phone));
		}
		
		String phoneCacheKey = CacheKeyPrefix.getAllowSignupPhone(phone);
		
		DBUser user = (DBUser) Cache.get(phoneCacheKey);
		if(user == null) {
			user = DBUser.find("byPhone", phone).first();
		}
		
		//如果用户不存在，那么将这个手机号码作为预备用户选手存入用户表
		if(null == user) {
			DBUser newUser = new DBUser();
			newUser.phone = phone;
			newUser.password = "";
			newUser.regIp = IpUtils.ipToLong(IpUtils.getRealIp(request));
			newUser.isValid = false;
			newUser.imei = null==imei?"":imei;
			newUser.uuid = null==uuid?"":uuid;
			newUser.channel = null==channel?"":channel;
			try {
				newUser = newUser.save();
				Cache.set(CacheKeyPrefix.getAllowSignupPhone(phone), newUser,CacheKeyPrefix.allowRegTime);
			} catch (Exception e) {
				Logger.error("isPhone:%s,isImei:%s,isIDFA:%s,isChannel:%s", FormUtils.isMobilePhone(phone),FormUtils.isImei(imei),FormUtils.isIosIDFA(uuid),FormUtils.isChannel(channel));
			} finally {
				renderJSON(new JsonCheckPhone(0,null,false,phone));
			}
		} else if(!user.isValid){
			// 以前有提交过，但是没有验证的用户
			user.password = "";
			user.regIp = IpUtils.ipToLong(IpUtils.getRealIp(request));
			user.isValid = false;
			user.imei = null==imei?"":imei;
			user.uuid = null==uuid?"":uuid;
			user.channel = null==channel?"":channel;
			user = user.save();
			
			Cache.set(CacheKeyPrefix.getAllowSignupPhone(phone), user ,CacheKeyPrefix.allowRegTime);
			renderJSON(new JsonCheckPhone(0,null,false,phone));
		} else {
			// 已经注册过的用户
			Cache.set(CacheKeyPrefix.getAllowSignupPhone(phone), user ,CacheKeyPrefix.allowRegTime);
			renderJSON(new JsonCheckPhone(0,null,true,phone));
		}
	}
	
	/**
	 * 获取语音验证码接口
	 * @param phone
	 * @param imei
	 * @param uuid
	 * @param captcha
	 */
	public static void getSongMessageCode(String phone,String imei,String uuid,String captcha) {
		try {
			JsonSongMsg json = new JsonSongMsg();
			//验证客户端传入的手机号是否正确，如果错误的话直接返回
			if(!FormUtils.isMobilePhone(phone)) {
				json.status = 100;
				json.tip = Tips.phoneError;
				renderJSON(json);
			}
			
			String regPhoneKey = CacheKeyPrefix.getAllowSignupPhone(phone);
			DBUser user = (DBUser) Cache.get(regPhoneKey);
			if(null == user) {
				throw new Exception();
			}
			
			String ip = IpUtils.getRealIp(request);// 获取客户端的IP地址
			if(inBlackList(phone, ip, imei, uuid)){
				json.status = 2;
				json.tip = Tips.userInBlack;
				renderJSON(json);
			}
			
			//用户连续请求3次需要输入图片验证码的判断操作
			//判断是否需要验证码
			String captchaKey = CacheKeyPrefix.getCaptchaKey(phone);
			Object captchaObj = Cache.get(captchaKey);
			if(null == captchaObj) {
				//上一回请求不需要验证码
				//判断是否已经达到需要验证码的条件，如果需要就返回让用户输入验证码后重新请求这个action
				//发送语音验证码
				//纪录频次信息
				//是否加入到黑名单的判断
				//返回json
				Logger.info("don't need captcha不需要输入验证码的情况");
				
				
				if(isNeedCaptcha(phone)) {
					json.status = 101;
					json.tip = Tips.needCaptcha;
					json.isNeedCaptcha = true;
					json.captchaUrl = getCaptchaImgUrl(phone);
				} else {
					boolean sendSucc = sendSongValidMessage(phone);
					
					
					if(!sendSucc) {
						// 这里是验证码发送失败的场景
						json.status = 102;
						json.tip = Tips.sendSongMessageFail;
					} else {
						//验证码发送成功的场景
						recordSongMessageFrequence(phone, ip, imei, uuid);
						blackListChecker(phone, ip, imei, uuid);
						json.status = 0;
						json.tip = Tips.sendSongMessageSuccess;
					}
				}
				renderJSON(json);
			} else {
				//上一回的请求需要验证码
				
				String captchaValueKey = CacheKeyPrefix.getCaptchaValue(captchaObj.toString());
				String captchaValue = (String) Cache.get(captchaValueKey);
				Cache.safeDelete(captchaKey);
				
				Logger.info("captchavalueKey: %s", captchaValueKey);
				Logger.info("captcha's value: %s", captchaValue);
				Logger.info("request captcha value: %s", captcha);
				if(null == captcha || !captchaValue.equals(captcha)) {
					// 用户输入的验证码错误了
					// 提示前端让用户重新输入验证码
					Logger.info("need captcha,user input wrong captcha code需要验证码,用户验证码输入错误的情况");
					json.status = 103;
					json.tip = Tips.captchaError;
					json.isNeedCaptcha = true;
					json.captchaUrl = getCaptchaImgUrl(phone);
					
					renderJSON(json);
				} else {
					//验证码正确的情况
					//发送语音验证码
					//纪录频次信息
					//是否加入到黑名单到判断
					//返回json
					Logger.info("needcaptcha,user input right需要验证码且验证码正确的情况");
					boolean sendSucc = sendSongValidMessage(phone);
					
					if(!sendSucc) {
						json.status = 102;
						json.tip = Tips.sendSongMessageFail;
						json.isNeedCaptcha = true;
						json.captchaUrl = getCaptchaImgUrl(phone);
					} else {
						recordSongMessageFrequence(phone, ip, imei, uuid);
						blackListChecker(phone, ip, imei, uuid);
						json.status = 0;
						json.tip = Tips.sendSongMessageSuccess;
					}
					
					renderJSON(json);
				}
			}
		} catch (Exception e) {
			String ip = IpUtils.getRealIp(request);// 获取客户端的IP地址
			JsonSongMsg json = new JsonSongMsg();
			json.status=500;
			json.tip = Tips.illegalRequest;
			Logger.error("illegal request,ip[%s],imei[%s],idfa[%s],phone[%s]", ip,imei,uuid,phone);
			recordSongMessageFrequence(phone, ip, imei, uuid);
			blackListChecker(phone, ip, imei, uuid);
			renderJSON(json);
		}
	}
	
	public static void reg(String phone,String password,String code,String uuid,String imei,String channel) {
		
		String regPhoneKey = CacheKeyPrefix.getAllowSignupPhone(phone);
		JsonReg jsonReg = new JsonReg();
		DBUser user = (DBUser) Cache.get(regPhoneKey);
		if(null == user || user.isValid) {
			//这是注册，如果缓存中的用户不存在或者是已经注册过的用户，说明这个用户是非法闯入的，要让这个用户回到checkPhone步骤去
			jsonReg.status = 501;
			jsonReg.tip = Tips.regTimeout;
			Cache.delete(regPhoneKey);
			renderJSON(jsonReg);
		}
		
		//验证imei,uuid,channel 等信息
		if(!imei.equals(user.imei) || !uuid.equals(user.uuid) || !channel.equals(user.channel)) {
			jsonReg.status = 501;
			jsonReg.tip = Tips.regTimeout;
			Cache.delete(regPhoneKey);
			renderJSON(jsonReg);
		}
		
		//注册,密码客户端处理后传过来的，所以我们要对密码长度判断一下，我们约定了是32位长度，那么密码就是32位，否则是有问题的
		if(password.length()!=32) {
			jsonReg.status = 104;
			jsonReg.tip = Tips.passwordFormatError;
			Cache.delete(regPhoneKey);
			renderJSON(jsonReg);
		}
		
		//验证语音验证码
		String soundMessageCodeKey = CacheKeyPrefix.getSongMessageCode(phone);
		String soundCode = (String) Cache.get(soundMessageCodeKey);
		if(null == soundCode || null==code || !soundCode.equals(code)) {
			jsonReg.status = 105;
			jsonReg.tip = Tips.soundCodeError;
			Cache.delete(regPhoneKey);
			renderJSON(jsonReg);
		}
		
		//以上验证都没有问题的，注册吧
		user.password = password;
		user.isValid = true;
		user.validTime = new Date().getTime();
		user.aliasId = Codec.UUID();
		user = user.save();
		Logger.info("welcome user:[%s] come in.", user.phone);
		Cache.delete(regPhoneKey);
		
		//把用户缓存起来
		String cacheUserKey = CacheKeyPrefix.getCacheUser(user.aliasId);
		Cache.set(cacheUserKey, user);
		
		//自动登陆，获取用户自动登陆的信息
		jsonReg.status = 0;
		jsonReg.tip = Tips.regSuccess;
		Userinfo userinfo = buildAutoLoginUserinfo(imei, uuid, user);
		jsonReg.userinfo = userinfo;
		
		renderJSON(jsonReg);
	}
	
	public static void login(String phone,String password,String imei,String uuid) {
		
	}
	
	protected static Userinfo buildAutoLoginUserinfo(String imei,String uuid,DBUser user) {
		String imeiIDFA = PubParam.getImeiIDFA(imei, uuid);
		DBAutoLogin autoLogin = new DBAutoLogin();
		autoLogin.userId = user.id;
		autoLogin.aliasId = user.aliasId;
		autoLogin.imeiIdfa = imeiIDFA;
		autoLogin.token = Codec.UUID();
		autoLogin = autoLogin.save();
		Userinfo userInfo = new Userinfo(autoLogin.token,autoLogin.aliasId);
		
		String autologinKey = CacheKeyPrefix.getAutoLogin(autoLogin.token);
		Cache.set(autologinKey, autoLogin);
		
		return userInfo;
	}
	
}
