package com.vaaniga.invest.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Long mobileNumber;
}
