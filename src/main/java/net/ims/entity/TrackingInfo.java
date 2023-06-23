package net.ims.entity;

import javax.persistence.*;
@Entity
@Table(name = "TRACKIN_INFO")
public class TrackingInfo {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "TLID")
        private int slid;

        @ManyToOne
        @JoinColumn(name = "SENDER_ID")
        private Users sender;

        @OneToOne
        @JoinColumn(name = "RECIVER_ID")
        private ShippingList reciverid;
        @Column(name = "DATE")
        private int date;



}
