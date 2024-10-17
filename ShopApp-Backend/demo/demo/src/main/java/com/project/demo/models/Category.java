package com.project.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Data // to string
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "name", nullable = false)
    private String name;
}
