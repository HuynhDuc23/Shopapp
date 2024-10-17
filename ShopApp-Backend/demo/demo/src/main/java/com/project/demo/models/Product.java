//package com.project.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "products")
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class Product extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id ;
//    @Column(name = "name" , nullable = false , length = 350)
//    private String name ;
//    private Float price ;
//    @Column(name = "thumbnail" , length = 300)
//    private String thumbnail;
//    @Column(name = "description")
//    private String description;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//}
