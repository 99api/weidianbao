package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Table(name="pubinfo")
@Entity()
public class DBPubInfo extends Model {

	public int pageRecord;

	@Column(columnDefinition="varchar(150)",name="android_down_addr")
	public String androidAppCurrentVersionDownLoadAddress;
	
	@Column(columnDefinition="varchar(150)",name="ios_down_addr")
	public String iosAppCurrentVersionDownLoadAddress;
	
	@Column(columnDefinition="varchar(150)",name="yingyongbao_down_addr")
	public String yingyongbaoAddress;
	
	public DBPubInfo(int pageRecord) {
		super();
		this.pageRecord = pageRecord;
	}

	@Override
	public String toString() {
		String str = "[公共配置]  每页记录：[%s]";
		return String.format(str, this.pageRecord);
	}
}
