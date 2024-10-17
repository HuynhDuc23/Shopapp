//package com.project.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "orders")
//public class Order  {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "full_name", length = 100, nullable = false)
//    private String fullName;
//
//    @Column(name = "email", length = 100, nullable = false)
//    private String email;
//
//    @Column(name = "phone_number", nullable = false, length = 100)
//    private String phoneNumber;
//
//    @Column(name = "address", length = 100, nullable = false)
//    private String address;
//
//    @Column(name = "note", length = 100)
//    private String note;
//
//    @Column(name = "order_date")
//    private LocalDateTime orderDate;
//
//    @Column(name = "status")
//    private String status;
//
//    @Column(name = "total_money")
//    private int totalMoney;
//
//    @Column(name = "shipping_address")
//    private String shippingAddress;
//
//    @Column(name = "shipping_method")
//    private String shippingMethod;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "shipping_date")
//    private Date shippingDate;
//
//    @Column(name = "tracking_number")
//    private String trackingNumber;
//
//    @Column(name = "payment_method")
//    private String paymentMethod;
//
//    @Column(name = "payment_status")
//    private String paymentStatus;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "payment_date")
//    private Date paymentDate;
//
//    @Column(name = "active")
//    private Boolean active;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//}
