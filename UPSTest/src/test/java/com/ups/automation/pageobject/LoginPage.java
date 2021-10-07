package com.ups.automation.pageobject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginpage")
public class LoginPage extends AbstractPage {

	@Value("${com.ups.platform-url}")
	String platformUrl;

	public LoginPage toPage() {
		fullScreen();
		navigate(platformUrl);
		return this;
	}

	public void login(String userName, String userPassword) {
		editText("loginUserEmail", userName);
		editText("loginUserPassword", userPassword);
		waitUntilElementWithIdPresent("login-signin-btn");
		clickId("login-signin-btn");
	}

	public void logout() {
	}


	
	
}
