package net.ims.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

    @Entity
    @Table(name = "SHIPPING_LIST")
    public class ShippingList {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "SLID")
        private int slid;
        @Column(name = "RECEIVER_NAME")
        private String receiverName;
        @Column(name = "RECEIVER_EMAIL")
         private String receiverEmail;
        @Column(name = "RECEIVER_ADDRESS")
        private String receiverAddress;

        @Column(name = "RECEIVER_PHONE")
        private long receiverPhone;
        @Column(name = "TRACKING_NUM")
         private String trackingNum;
         @Column(name = "SENDER_NAME")
        private String senderName;
         @Column(name = "CARGO_ID")
         private  int cargo_ID;

         @Column(name ="CARGO_Weight")
         private  double weight;

    /*@ManyToOne(optional = false)
    @JoinColumn(name = "USERS_ID",referencedColumnName = "uid")
    private Users users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CARGO_ID",referencedColumnName = "sbid")
    private Cargo cargo;*/
     

}


