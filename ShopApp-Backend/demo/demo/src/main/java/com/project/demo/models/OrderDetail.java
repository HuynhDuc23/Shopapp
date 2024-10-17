//package com.project.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "order_details")
//public class OrderDetail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id ;
//    @JoinColumn(name = "order_id")
//    private Order order ;
//    @JoinColumn(name = "product_id")
//    @ManyToOne(fetch=FetchType.LAZY)
//    private Product product;
//    @Column(name = "price" , nullable = false)
//    private Float price ;
//    @Column(name = "number_of_products", nullable = false)
//    private int numberOfProducts ;
//    @Column(name = "total_money", nullable = false)
//    private int totalMoney ;
//    @Column(name = "color")
//    private String color ;
//}
