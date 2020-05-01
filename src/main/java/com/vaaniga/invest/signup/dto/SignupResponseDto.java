package com.vaaniga.invest.signup.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponseDto {

	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Long mobileNumber;
	
	private Timestamp createdDate;
	
	private Boolean signupCompleted;
//	
//	public SignupResponseDto(UserSignUp userSignUp) {
//		this.email = userSignUp.getEmail();
//		this.firstName = userSignUp.getFirstName();
//		this.lastName = userSignUp.getLastName();
//		this.mobileNumber = userSignUp.getMobileNumber();
//		this.createdDate = userSignUp.getCreatedDate();
//		this.signupCompleted = userSignUp.getSignupCompleted();
//	}
	
}
