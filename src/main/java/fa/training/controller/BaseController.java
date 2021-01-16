package fa.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fa.training.models.Content;
import fa.training.models.Member;

@Controller
public class BaseController {
	/*
	 * 
	 * initialization Object member first for spring form
	 */
	@ModelAttribute("member")
	public Member setUpMemberForm() {

		return new Member();
	}

	@ModelAttribute("content")
	public Content setUpContentForm() {

		return new Content();
	}

	/*
	 * handle request and move to view respectively
	 */
	@GetMapping("/")
	public String home() {
		return "login";
	}

	@GetMapping("/login")
	public String goLogin() {
		return "login";
	}

	@GetMapping("/home")
	public String cms() {
		return "home-page";
	}

	@GetMapping("/register")
	public String goRegister(Model model) {

		return "register";
	}

	@GetMapping("/form-content")
	public String formContent() {
		return "add-content";
	}

	// store information of member login
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("member");
		return "login";
	}

}
