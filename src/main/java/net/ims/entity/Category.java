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
	@Table(name="CATEGORY")
	public class Category {	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column (name="CID")
		private int cid;
		@Column (name="CNAME")
		private String cname;
		@Column (name="DESCRIPTION")
		private String description;
		
		

	}


