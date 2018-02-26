package org.mcare.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Permission;
import org.mcare.acl.entity.Role;
import org.mcare.acl.service.impl.RoleServiceImpl;
import org.mcare.acl.service.impl.UserServiceImpl;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author proshanto
 */

@Controller
public class UserController {
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private Account account;
	
	@Autowired
	private Permission permission;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@RequestMapping("/")
	public String showView(Model model) {
		/*
		Class<UserEntity> className = UserEntity.class;
		userEntity.setName("user");
		databaseServiceImpl.save(userEntity);
		List<UserEntity> users = databaseServiceImpl.findAll(userEntity, "UserEntity");
		for (UserEntity userEntity : users) {
			System.err.println("" + userEntity.getName());
		}
		
		UserEntity user = databaseServiceImpl.findById(1, "id", className);
		System.err.println("UserName:::" + user.getName());
		model.addAttribute("name", "Tom");
		model.addAttribute("formatted", "<b>blue</b>");*/
		return "user/home";
	}
	
	@RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
	public ModelAndView saveUser(Model model, HttpSession session) {
		int[] selectedRoles = null;
		model.addAttribute("account", new Account());
		session.setAttribute("roles", databaseServiceImpl.findAll("Role"));
		session.setAttribute("selectedRoles", selectedRoles);
		return new ModelAndView("user/add", "command", account);
	}
	
	@RequestMapping(value = "/user/add.html", method = RequestMethod.POST)
	public ModelAndView saveUser(@RequestParam(value = "roles", required = false) int[] roles,
	                             @Valid @ModelAttribute("account") Account account, BindingResult binding, ModelMap model,
	                             HttpSession session) {
		
		try {
			if (userService.isValid(account).equalsIgnoreCase("false")) {
				account.setRoles(userService.setRoles(roles));
				userService.registerNewUserAccount(account);
				
				return new ModelAndView("redirect:/user.html");
			} else {
				session.setAttribute("roles", databaseServiceImpl.findAll("Role"));
				session.setAttribute("selectedRoles", roles);
				model.addAttribute("passwordNotMatch", "Password Does not match");
				return new ModelAndView("/user/add");
			}
		}
		catch (Exception e) {
			session.setAttribute("roles", databaseServiceImpl.findAll("Role"));
			session.setAttribute("selectedRoles", roles);
			model.addAttribute("unigue", "User name alreday taken");
			return new ModelAndView("/user/add");
		}
		
	}
	
	@RequestMapping(value = "/user/{id}/edit.html", method = RequestMethod.GET)
	public ModelAndView editUser(Model model, HttpSession session, @PathVariable("id") int id) {
		Account account = userService.findById(id, "id", Account.class);
		System.err.println("" + account.toString());
		int[] selectedRoles = new int[200];
		model.addAttribute("account", account);
		Set<Role> getRoles = account.getRoles();
		int i = 0;
		for (Role role : getRoles) {
			selectedRoles[i] = role.getId();
			i++;
		}
		model.addAttribute("id", id);
		session.setAttribute("roles", databaseServiceImpl.findAll("Role"));
		session.setAttribute("selectedRoles", selectedRoles);
		return new ModelAndView("user/edit", "command", account);
	}
	
	@RequestMapping(value = "/user/{id}/edit.html", method = RequestMethod.POST)
	public ModelAndView editUser(@RequestParam(value = "roles", required = false) int[] roles,
	                             @Valid @ModelAttribute("account") Account account, BindingResult binding, ModelMap model,
	                             HttpSession session, @PathVariable("id") int id) {
		
		account.setRoles(userService.setRoles(roles));
		account.setId(id);
		userService.update(account);
		
		return new ModelAndView("redirect:/user.html");
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}
	
	@RequestMapping(value = "/user/administration", method = RequestMethod.GET)
	public String administrationPage() {
		return "user/administration";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
