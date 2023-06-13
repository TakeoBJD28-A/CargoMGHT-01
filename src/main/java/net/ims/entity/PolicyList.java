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
@Table(name="POLICYLIST")
public class PolicyList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	@Column (name="CATEGORY")
	private String category;
	@Column (name="SUBCATEGORY")
	private String subCategory;
	@Column (name="NAME")
	private String name;
	@Column (name="SUMASSURED")
	private int sumAssured;
	@Column (name="PREMIUM")
	private int premium;
	@Column (name="DESCRIPTION")
	private String description;
	
	

}
