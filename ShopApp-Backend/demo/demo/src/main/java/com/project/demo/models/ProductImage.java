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
//@Builder
//@Entity
//@Table(name = "product_images")
//
//public class ProductImage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id ;
//
//    @Column(name = "img_url" , nullable = false , length = 300)
//    private String imgUrl ;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product ;
//}
