package com.vaaniga.invest.signup.service;

import com.vaaniga.invest.signup.dto.SignupRequestDto;
import com.vaaniga.invest.signup.dto.SignupResponseDto;
import com.vaaniga.invest.signup.exception.SignupServiceGenericException;

public interface VaanigaSignupService {
	
	void preSignUpUser(SignupRequestDto signupRequestDto);
	
	SignupResponseDto signUpUser(SignupRequestDto signupRequestDto) throws SignupServiceGenericException;
	
	void postSignUpUser(SignupRequestDto signupRequestDto, SignupResponseDto signupResponseDto);
	
	String constructSocialRedirection(String appName);

}
