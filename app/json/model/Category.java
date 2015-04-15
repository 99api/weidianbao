package json.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Category {

	@Column(columnDefinition="varchar(50)")
	public String categoryName;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	public List<Goods> goodsList;
	
}
