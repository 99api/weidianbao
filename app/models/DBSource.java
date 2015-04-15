package models;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class DBSource extends Model {

	@Column(columnDefinition="varchar(30)")
	public String sourceName;

	public DBSource(String sourceName) {
		super();
		this.sourceName = sourceName;
	}

	@Override
	public String toString() {
		return this.sourceName;
	}
}
