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
	@Table(name="SERVICE_COST")
	public class Service_Cost {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column (name="SBID")
		private int sbid;
		@Column (name="WEIGHT")
		private String weight;
		@Column (name="COST")
		private double cost;
		@Column (name="DESCRIPTION")
		private String description;
		
		

	}

