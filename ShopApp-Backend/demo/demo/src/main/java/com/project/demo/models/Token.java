package com.project.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "token" , nullable = false , length = 255)
    private String token ;
    @Column(name = "token_type" , nullable = false , length =50)
    private String tokenType ;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate ;
    private boolean revoked ;
    private boolean expired ;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.project.demo.models.User  user ;
}
