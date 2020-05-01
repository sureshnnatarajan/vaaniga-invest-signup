package com.vaaniga.invest.signup.service.impl;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vaaniga.invest.signup.constants.SignupServiceCommonConstants;
import com.vaaniga.invest.signup.dto.SignupRequestDto;
import com.vaaniga.invest.signup.dto.SignupResponseDto;
import com.vaaniga.invest.signup.exception.SignupServiceGenericException;
import com.vaaniga.invest.signup.service.VaanigaSignupService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VaanigaSignupServiceImpl implements VaanigaSignupService {

	@Override
	public void preSignUpUser(SignupRequestDto signupRequestDto) {
		handleInputValidation(signupRequestDto);
	}

	@Override
	public SignupResponseDto signUpUser(SignupRequestDto signupRequestDto)
			throws SignupServiceGenericException {
		
		preSignUpUser(signupRequestDto);
		
		SignupResponseDto signupResponseDto = doSignUpUser(signupRequestDto);
		
		if (null == signupResponseDto ) {
			String _ERROR_MESSAGE = "Unable to signup user with the given details. Try after sometime!";
			log.error(_ERROR_MESSAGE);
			throw new SignupServiceGenericException(_ERROR_MESSAGE);
		}
		
		postSignUpUser(signupRequestDto, signupResponseDto);
		
		return signupResponseDto;
	}

	private SignupResponseDto doSignUpUser(SignupRequestDto signupRequestDto) {
		SignupResponseDto signupResponseDto = null; 
		
		//TODO: Change logic after DB integration
		signupResponseDto = new SignupResponseDto();
		signupResponseDto.setFirstName(signupRequestDto.getFirstName());
		signupResponseDto.setLastName(signupRequestDto.getLastName());
		signupResponseDto.setEmail(signupRequestDto.getEmail());
		signupResponseDto.setMobileNumber(signupRequestDto.getMobileNumber());
		
		return signupResponseDto;
	}

	@Override
	public void postSignUpUser(SignupRequestDto signupRequestDto, SignupResponseDto signupResponseDto) {
		// TODO Auto-generated method stub

	}
	
	private void handleInputValidation(SignupRequestDto signupRequestDto) {
		if (StringUtils.isEmpty(signupRequestDto.getEmail())) {
			log.error(SignupServiceCommonConstants._EMPTY_EMAIL_ADDRESS_ERROR_MESSAGE);
			throw new IllegalArgumentException(SignupServiceCommonConstants._EMPTY_EMAIL_ADDRESS_ERROR_MESSAGE);
		}
		
		if (!EmailValidator.getInstance().isValid(signupRequestDto.getEmail())) {
			log.error(SignupServiceCommonConstants._INVALID_EMAIL_ADDRESS_ERROR_MESSAGE);
			throw new IllegalArgumentException(SignupServiceCommonConstants._INVALID_EMAIL_ADDRESS_ERROR_MESSAGE);
		}
		
		if (StringUtils.isEmpty(signupRequestDto.getFirstName())) {
			log.error(SignupServiceCommonConstants._EMPTY_FIRST_NAME_ERROR_MESSAGE);
			throw new IllegalArgumentException(SignupServiceCommonConstants._EMPTY_FIRST_NAME_ERROR_MESSAGE);
		}
		
		if (StringUtils.isEmpty(signupRequestDto.getLastName())) {
			log.error(SignupServiceCommonConstants._EMPTY_LAST_NAME_ERROR_MESSAGE);
			throw new IllegalArgumentException(SignupServiceCommonConstants._EMPTY_LAST_NAME_ERROR_MESSAGE);
		}
		
		if (signupRequestDto.getMobileNumber() <= 0 
				|| String.valueOf(signupRequestDto.getMobileNumber()).length() != 10) {
			log.error(SignupServiceCommonConstants._INVALID_MOBILE_NUMBER_ERROR_MESSAGE);
			throw new IllegalArgumentException(SignupServiceCommonConstants._INVALID_MOBILE_NUMBER_ERROR_MESSAGE);
		}
	}

}
