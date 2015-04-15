package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name="db_autologin")
public class DBAutoLogin extends Model {

	@Column(columnDefinition="varchar(32)")
	public String aliasId;
	
	public long userId;
	
	@Column(columnDefinition="char(32)")
	public String token;
	
	@Column(columnDefinition="char(64)")
	public String imeiIdfa;
	
	public long tokenBuildTime;
}
