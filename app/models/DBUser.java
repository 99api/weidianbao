package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;
import play.libs.Codec;

@Entity
@Table(name="db_user")
public class DBUser extends Model {

	@Column(columnDefinition="char(32)")
	public String aliasId = Codec.UUID();
	
	//电话号码就是用户名
	@Column(columnDefinition="char(11)")
	public String phone;
	
	//MD5后的字符长度是32位
	@Column(columnDefinition="char(32)")
	public String password;
	
	//用户手机是否被验证
	public boolean isValid = false;
	
	//手机被验证的时间
	public long validTime;
	
	//注册时候的ip
	public long regIp;
	
	//设备IMEI
	@Column(columnDefinition="varchar(50)")
	public String imei;
	
	//设备唯一UUID
	@Column(columnDefinition="varchar(50)")
	public String uuid;
	
	//app安装来源渠道
	@Column(columnDefinition="varchar(50)")
	public String channel;
	
	public static void main(String[] args) {
		String password = "d999";
		String pwd2 = "gxh921921";
		String md5Pwd = Codec.hexMD5(password);
		System.out.println(md5Pwd.length());
		System.out.println(Codec.hexMD5(pwd2).length());
		System.out.println(Codec.UUID().length());
	}
}
