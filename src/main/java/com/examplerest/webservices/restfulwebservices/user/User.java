package com.examplerest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id

	private Integer Id;
	
	@Size(min=2,message="name should have atleast 2 characters")
	private String Name;

	private String Desg;
	
	@Past
	private Date dateOfJoining ;
	
	/**
	 * 
	 */
	public User() {
	super();
	}


	/**
	 * @param id
	 * @param name
	 * @param desg
	 * @param dateOfJoining
	 */
	public User(Integer id, String name, String desg, Date dateOfJoining) {
		super();
		Id = id;
		Name = name;
		Desg = desg;
		this.dateOfJoining = dateOfJoining;
	}

	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the desg
	 */
	public String getDesg() {
		return Desg;
	}

	/**
	 * @param desg the desg to set
	 */
	public void setDesg(String desg) {
		Desg = desg;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Desg=" + Desg + ", dateOfJoining=" + dateOfJoining + "]";
	}
	
	

}


	


