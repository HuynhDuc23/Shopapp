package com.project.demo.dtos.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "this field name not null ")
    @Size(min = 3 , max = 10 , message = "this field to 3 to 10 character")
    private String name ;
    @Min(value = 10 , message = "Price between 10 max 100")
    @Max(value = 100 , message = "Price between 10 max 100" )
    private float price ;
    @NotNull(message = "this field thumbnail not null")
    private String thumbnail ;
    private String description ;
    @JsonProperty("category_id")
    private int categoryId ;
    private List<MultipartFile> files ;
}
