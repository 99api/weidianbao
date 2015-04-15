package json.model;

import java.io.Serializable;

public class ViewRecord implements Serializable{

	private static final long serialVersionUID = -6191310436318894858L;
	
	public long ip;
	
	public String deviceType;
	
	public String os;
	
	public String sw;
	
	public String sh;
	
	public String version;
	
	public String imei;
	
	public String uuid;
	
	public String channel;
	
	public long viewTime;

	public ViewRecord(long ip, String deviceType, String os, String sw,
			String sh, String version, String imei, String uuid, String channel,
			long viewTime) {
		super();
		this.ip = ip;
		this.deviceType = deviceType;
		this.os = os;
		this.sw = sw;
		this.sh = sh;
		this.version = version;
		this.imei = imei;
		this.uuid = uuid;
		this.channel = channel;
		this.viewTime = viewTime;
	}
	
	
}
