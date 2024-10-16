package com.project.demo.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("phone_number")
    @NotBlank(message = "Please enter a valid phone number")
    private String phoneNumber ;
    @JsonProperty("password")
    @NotBlank(message = "Please enter a valid password")
    private String password ;
}
