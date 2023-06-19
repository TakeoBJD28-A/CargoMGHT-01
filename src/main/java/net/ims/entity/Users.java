package net.ims.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USERS")

public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UID")
	private int uid;
	@Column(name="UNAME")
	private String uname;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="PHONE")
	private long phone;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column (name="ROLE_ID")
	private int role_id=2;
	
	
}
