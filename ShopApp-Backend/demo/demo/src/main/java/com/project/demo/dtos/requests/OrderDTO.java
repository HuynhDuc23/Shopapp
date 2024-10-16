package com.project.demo.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @JsonProperty("user_id")
    private Long userId ;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("email")
    private String email ;
    @JsonProperty("phone_number")
    @NotBlank(message = "Please enter phone number")
    @Size(max = 10 ,message = "Please enter phone number")
    private String phoneNumber;
    @JsonProperty("address")
    @NotBlank(message = "Please enter address")
    private String address ;
    @NotBlank(message = "Please enter note")
    private String note;
    @JsonProperty("total_money")
    @Min(value = 1 , message = "Please enter totalMoney")
    private Float totalMoney ;
    @NotBlank(message = "Please enter shippingMethod")
    @JsonProperty("shipping_method")
    private String shippingMethod;
    @NotBlank(message = "please enter shippingAddress")
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("tracking_number")
    private String trackingNumber ;

}
