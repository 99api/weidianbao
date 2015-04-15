package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name="db_valid_message")
public class DBValidMessage extends Model {

	@Column(columnDefinition="char(11)")
	public String phone;
	
	@Column(columnDefinition="varchar(100)")
	public String validCode;
	
	@Column(columnDefinition="varchar(100)")
	public String validType;
	
	@Column(columnDefinition="varchar(20)")
	public String status;
	
	@Column(columnDefinition="varchar(250)",name="description")
	public String desc;
	
	public long sendTime;

	public DBValidMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBValidMessage(String phone, String validCode, String validType,
			String status, String desc, long sendTime) {
		super();
		this.phone = phone;
		this.validCode = validCode;
		this.validType = validType;
		this.status = status;
		this.desc = desc;
		this.sendTime = sendTime;
	}
	
	
}
