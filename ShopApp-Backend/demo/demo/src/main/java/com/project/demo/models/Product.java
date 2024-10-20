package com.project.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "name" , nullable = false , length = 350)
    private String name ;
    private Float price ;
    @Column(name = "thumbnail" , length = 300)
    private String thumbnail;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY , cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "category_id")
    private Category category;

}
