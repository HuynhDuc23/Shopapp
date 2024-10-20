package com.project.demo.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.internal.build.AllowNonPortable;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {    private String name ;
    private float price ;
    private String thumbnail ;
    private String description ;
    private String category ;
}
