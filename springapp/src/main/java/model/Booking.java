package model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	private Integer id;
	private String bname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
}