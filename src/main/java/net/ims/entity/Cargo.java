package net.ims.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name="CARGO")
	public class Cargo {
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
	//@OneToMany(mappedBy = "cargo",cascade=CascadeType.ALL)
	//private List<ShippingList> shippingList;



}

