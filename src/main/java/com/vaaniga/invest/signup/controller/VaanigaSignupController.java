package com.vaaniga.invest.signup.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaaniga.invest.signup.dto.SignupRequestDto;
import com.vaaniga.invest.signup.dto.SignupResponseDto;
import com.vaaniga.invest.signup.exception.SignupServiceGenericException;
import com.vaaniga.invest.signup.service.VaanigaSignupService;


@RestController
@RequestMapping(path="/signUp")
@CrossOrigin("*")
public class VaanigaSignupController {

	private VaanigaSignupService vaanigaSignupService;
	
	@Autowired
	public VaanigaSignupController(VaanigaSignupService vaanigaSignupServiceParam) {
		super();
		this.vaanigaSignupService = vaanigaSignupServiceParam;
	}

	@PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> signupUser(@RequestBody SignupRequestDto signupRequestDto ) throws SignupServiceGenericException {
		
		long startTime = System.nanoTime();
		
		SignupResponseDto signupResponseDto = vaanigaSignupService.signUpUser(signupRequestDto);
		
		JSONObject responseObject = new JSONObject();
		
		long timeElapsed = System.nanoTime() - startTime;
		
		responseObject.put("results", signupResponseDto);
		responseObject.put("executionTime", timeElapsed / 1000000 + " milliseconds");
		
		return new ResponseEntity<>(responseObject.toMap(), HttpStatus.OK);
	}
	
	/*
	//@CrossOrigin(origins = "https://vaaniga-invest-app.herokuapp.com/")
	@GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
	
	//@CrossOrigin(origins = "https://vaaniga-invest-app.herokuapp.com/")
	@GetMapping("/social/{appName}")
	public String redirectToSocial(@PathVariable String appName) {
		
		return "redirect:"+vaanigaSignupService.constructSocialRedirection(appName);
	}
	*/
}

