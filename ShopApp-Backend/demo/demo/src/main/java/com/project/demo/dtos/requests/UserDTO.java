package com.project.demo.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("username")
    @NotBlank(message = "Please enter a username")
    private String fullName ;
    @JsonProperty("password")
    @NotBlank(message = "Please enter password")
    @Size(min = 6 , max = 20 , message = "Password must be between 6 and 20 characters")
    private String password ;
    @JsonProperty("retype_password")
    @NotBlank(message = "Please retype password")
    @Size(min = 6 , max = 20 , message = "Password must be between 6 and 20 characters")
    private String retypePassword ;
    @JsonProperty("phone_number")
    @NotBlank(message = "Please enter phone number")
    private String phoneNumber ;
    @JsonProperty("address")
    private String address ;
    @JsonProperty("date_of_birth")
    private Date dateOfBirth ;
    @JsonProperty("facebook_account_id")
    private int facebookAccountId;
    @JsonProperty("google_account_id")
    private int googleAccountId ;
    @JsonProperty("role_id")
    private Long roleId ;
}
