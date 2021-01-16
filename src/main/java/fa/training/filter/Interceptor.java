package fa.training.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fa.training.models.Member;
import fa.training.services.MemberService;

@PropertySource(value = "classpath:memberRoles.properties")
public class Interceptor extends HandlerInterceptorAdapter {
	@Value("#{'${admin}'.split(',')}")
	List<String> roleAdmin;
	@Value("#{'${user}'.split(',')}")
	List<String> roleUser;

	@Autowired
	MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("member");
		System.out.println(roleUser);

		String role = request.getRequestURI().substring(request.getContextPath().length() + 1,
				request.getRequestURI().length());
		System.out.println(role);

		if (member != null) {
			Member newMember = memberService.findMemberByEmail(member.getEmail());
			if (newMember.getRole().equals("admin")) {
				return true;

			} else if (newMember.getRole().equals("user")) {
				if (roleUser.contains(role)) {
					return true;

				} else {
					response.sendRedirect(request.getContextPath() + "/view-content");
					return false;

				}
			} else {
				response.sendRedirect(request.getContextPath() + "/home");
				return false;
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
