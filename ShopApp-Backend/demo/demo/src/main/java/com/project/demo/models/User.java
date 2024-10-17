package com.project.demo.models;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "fullname", length = 100)
    private String fullName ;
    @Column(name = "phone_number", length = 10 , nullable = false)
    private String phoneNumber;
    @Column(name = "address" , length = 200)
    private String address ;
    @Column(name = "password" , length = 200 , nullable = false)
    private String password;
    private boolean active;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "facebook_account_id")
    private int faceBookAccountId ;
    @Column(name = "google_account_id")
    private int googleAccountId ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private com.project.demo.models.Role role ;


}
