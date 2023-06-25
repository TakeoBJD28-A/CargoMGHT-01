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
@Table(name="FEEDBACK")
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FID")
    private int fid;
    @Column(name="FULLNAME")
    private String fullName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="MESSAGE")
    private String message;

}
