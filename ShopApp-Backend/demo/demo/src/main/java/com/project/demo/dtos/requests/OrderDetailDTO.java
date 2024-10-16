package com.project.demo.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    @Min(value = 1 , message = "Please enter orderId number")
    @JsonProperty("order-id")
    private int orderId ;
    @Min(value = 1 , message = "Please enter productId number")
    @JsonProperty("product-id")
    private int productId;
    @Min(value = 0 , message = "Please enter price number")
    @JsonProperty("price")
    private float price ;
    @Min(value = 1 , message = "Please enter numberOrProduct number")
    @JsonProperty("number-or-product")
    private int numberOrProduct;
    @Min(value = 1 , message = "Please enter totalMoney number")
    @JsonProperty("total-money")
    private float totalMoney;
    @NotNull(message = "Please enter color")
    @JsonProperty("color")
    private String color;
}
