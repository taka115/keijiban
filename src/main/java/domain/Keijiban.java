package domain;

import java.sql.Timestamp;

public class Keijiban {
	
	private Integer id;
	private String name;
	private String comment;
	private Timestamp createdAt;
	
	public Keijiban() {
		
	}
	
	public Keijiban(Integer id, String name, String comment, Timestamp createdAt) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
