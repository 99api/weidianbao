package json.model;

public class JsonSongMsg {

	/**
	 * status 状态： 
	 * 0/已发送 
	 * 100/异常的手机号
	 * 101/用户在规定时间内连续呼叫次数超过N次，从不需要输入图片验证码状态切换到需要输入图片验证码的状态的错误提示场景
	 * 102/服务器请求发送语音验证码失败的错误提示场景
	 * 103/图片验证码输入错误的提示场景
	 * 2/用户在黑名单中
	 * 500/非法的用户请求：非正常业务逻辑操作会出现的
	 */
	public int status;
	public String tip;
	public boolean isNeedCaptcha;
	public String captchaUrl;
	
	public JsonSongMsg() {
		super();
	}

	public JsonSongMsg(int status, String tip, boolean isNeedCaptcha,
			String captchaUrl) {
		super();
		this.status = status;
		this.tip = tip;
		this.isNeedCaptcha = isNeedCaptcha;
		this.captchaUrl = captchaUrl;
	}
	
}
