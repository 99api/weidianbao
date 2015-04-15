package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import json.model.ViewRecord;

import play.Logger;
import play.db.DB;
import play.db.jpa.Model;

@Entity
@Table(name="view_records")
public class DBViewRecord extends Model {

	public long ip;
	
	//设别类型
	@Column(columnDefinition="varchar(30)")
	public String deviceType;
	
	//操作系统
	@Column(columnDefinition="varchar(200)",name="device_os")
	public String os;
	
	//屏幕宽度
	@Column(columnDefinition="varchar(20)")
	public String sw;
	
	//屏幕高度
	@Column(columnDefinition="varchar(20)")
	public String sh;

	//app版本号
	@Column(columnDefinition="varchar(20)",name="client_version")
	public String version;
	
	//设备IMEI
	@Column(columnDefinition="varchar(50)")
	public String imei;
	
	//设备唯一UUID
	@Column(columnDefinition="varchar(50)")
	public String uuid;
	
	//app安装来源渠道
	@Column(columnDefinition="varchar(50)")
	public String channel;
	
	//登陆时间
	public long viewTime = new Date().getTime();
	
	public static void BatchInsert(List<ViewRecord> vrList) {
		
		java.sql.Connection conn =  DB.getConnection();
		String sql = "INSERT INTO view_records(ip,deviceType,device_os,sw,sh,client_version,imei,uuid,channel,viewTime) VALUES(%d,'%s','%s','%s','%s','%s','%s','%s','%s',%d)";
		
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			for(ViewRecord vr:vrList) {
				String excuteSql = String.format(sql,vr.ip,vr.deviceType,vr.os,vr.sw,vr.sh,vr.version,vr.imei,vr.uuid,vr.channel,vr.viewTime);
			//	System.out.println(excuteSql);
				stmt.addBatch(excuteSql);
			}
			stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			Logger.error(sql);
			Logger.error(e.getMessage());
		}
		
	}
}
