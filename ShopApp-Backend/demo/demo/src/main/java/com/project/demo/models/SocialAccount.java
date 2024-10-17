//package com.project.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Data
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "social_accounts")
//public class SocialAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id ;
//    @Column(name = "provider" , nullable = false , length = 20)
//    private String provider ;
//    @Column(name = "provider_id", nullable = false , length =50)
//    private String providerId ;
//    private String name ;
//    private String email ;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user ;
//}
