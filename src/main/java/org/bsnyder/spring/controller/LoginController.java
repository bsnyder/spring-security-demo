package org.bsnyder.spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	static final String ROLE_ADMIN = "ROLE_ADMIN";
	static final String ROLE_DEPLOYER = "ROLE_DEPLOYER";
	static final String ROLE_RELEASE_OWNER = "ROLE_RELEASE_OWNER";
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		List<String> roles = new ArrayList<String>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		for (GrantedAuthority authority : auth.getAuthorities()) {
			String a = authority.getAuthority();
			roles.add(a);
		}
		LOGGER.info("User logging in is: '{}' with roles: '{}'", name, roles.toString());
		
		model.addAttribute("username", name);
		
		if (roles.contains(ROLE_ADMIN)) {
			model.addAttribute("message", "Your are logged in as a ADMIN");
			return "admin";
		} else if (roles.contains(ROLE_RELEASE_OWNER)) {
			model.addAttribute("message", "Your are logged in as a RELEASE_OWNER");
			return "releaseOwner";
		} else if (roles.contains(ROLE_DEPLOYER)) {
			model.addAttribute("message", "Your are logged in as a DEPLOYER");
			return "deployer";
		} else {
			model.addAttribute("message", "You are logged in as a USER");
			return "hello";
		}
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		LOGGER.debug("login");
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		LOGGER.debug("loginfailed");
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		LOGGER.debug("logout");
		return "login";
	}
	
}
