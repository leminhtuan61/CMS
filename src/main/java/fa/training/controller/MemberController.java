package fa.training.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fa.training.models.Member;
import fa.training.services.MemberServiceImpl;
import fa.training.utils.LogUtils;

@Controller
public class MemberController {
	/*
	 * get bean service in IO container
	 */
	@Autowired
	private MemberServiceImpl memberService;

	@ModelAttribute("member")
	public Member setUpUserForm() {

		return new Member();
	}
	/*
	 * handle req /login, check from database if valid return home-page else return
	 * view login and send message login fail
	 */

	@PostMapping("/login")
	public String Login(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult, Model model,
			HttpSession session) throws Exception {
		if (bindingResult.hasErrors()) {
			LogUtils.getLogger().info(bindingResult);
			return "login";

		} else {

			Member result;

			result = memberService.checkLogin(member);
			if (result != null) {
				session.setAttribute("member", result);
				return "home-page";
			} else {
				return "login";
			}

		}

	}
	/*
	 * handle req ../edit-profile, use session stored and getEmail to find Member
	 * inject data to form , resp form edit-profile and data
	 */

	@GetMapping("/edit-profile")
	public String goEditProfile(HttpSession session, Model model) throws Exception {
		Member member = (Member) session.getAttribute("member");

		Member member1 = memberService.findMemberByEmail(member.getEmail());
		model.addAttribute("member", member1);

		return "edit-profile";
	}

	/*
	 * handle req ../processRegister and check if containing memberId then save
	 * member and message else update member . Check data valid send message success
	 * else message fail and Check validate
	 */

	@PostMapping("/processRegister")
	public String register(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult, Model model)
			throws Exception {

		int id = member.getMemberId();
		if (id == 0) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("messageErr", "Register fail!!");
				LogUtils.getLogger().info(bindingResult);
				return "register";
			} else {

				boolean result = memberService.saveOrUpdateMember(member);

				if (result) {

					model.addAttribute("message", "Register success!!");
					return "register";
				}

				return "register";
			}
		} else {
			if (bindingResult.hasErrors()) {
				model.addAttribute("messageErr", "Edit fail!!");
				LogUtils.getLogger().info(bindingResult);
				return "edit-profile";
			} else {
				Member oldMember;

				oldMember = memberService.findMemberById(id);
				oldMember.setFirstName(member.getFirstName());
				oldMember.setLastName(member.getLastName());
				oldMember.setPhone(member.getPhone());
				oldMember.setDescription(member.getDescription());

				boolean result = memberService.saveOrUpdateMember(oldMember);

				if (result) {

					model.addAttribute("message", "Edit success!!");
					return "edit-profile";

				}
			}
			return "edit-profile";
		}
	}

}
