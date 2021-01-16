package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fa.training.models.Content;
import fa.training.models.Member;
import fa.training.services.ContentServiceImpl;
import fa.training.services.MemberServiceImpl;
import fa.training.utils.LogUtils;

@Controller
public class ContentController {
	/*
	 * get bean service in IO container
	 */
	@Autowired
	private ContentServiceImpl contentService;
	@Autowired
	private MemberServiceImpl memberService;

	/*
	 * handle req ../view-content and resp list content to view
	 */
	@GetMapping("/view-content")
	public String listContent(@ModelAttribute("content") Content content, Model model) throws Exception {

		List<Content> contents = contentService.findAllContent();
		model.addAttribute("contents", contents);

		return "view-content";

	}

	/*
	 * handle req ../add-content and check if containing contentId then save content
	 * else update content perform, return ../view-content and resp list content to
	 * view .Check valid attributes import to form , if invalid return message
	 */
	@PostMapping("/add-content")
	public String addContent(@ModelAttribute("content") @Valid Content newContent, BindingResult bindingResult,
			Model model, HttpSession session) throws Exception {

		int id = newContent.getContentId();

		if (id == 0) {
			if (bindingResult.hasErrors()) {
				LogUtils.getLogger().info(bindingResult);
				return "add-content";
			} else {

				Member oldMember = (Member) session.getAttribute("member");
				Member member = memberService.findMemberByEmail(oldMember.getEmail());
				newContent.setMember(member);
				contentService.saveContent(newContent);
				List<Content> contents = contentService.findAllContent();
				model.addAttribute("contents", contents);

			}

		} else {

			if (bindingResult.hasErrors()) {
				LogUtils.getLogger().info(bindingResult);
				return "edit-content";
			} else {
				Content oldContent;
				try {
					oldContent = contentService.findContentByContentId(id);
					oldContent.setBrief(newContent.getBrief());
					oldContent.setContent(newContent.getContent());
					oldContent.setTitle(newContent.getTitle());
					contentService.saveContent(oldContent);
					List<Content> contents = contentService.findAllContent();
					model.addAttribute("contents", contents);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return "view-content";

	}

	/*
	 * handle req ../view-content/delete/{id}, take contentId and delete content by
	 * contentId , resp list content to view
	 */
	@GetMapping("/view-content/delete/{id}")
	public String deleteContent(@PathVariable("id") int id, @ModelAttribute("content") Content content, Model model)
			throws Exception {

		contentService.deleteContentById(id);
		List<Content> contents = contentService.findAllContent();
		model.addAttribute("contents", contents);

		return "view-content";
	}

	/*
	 * handle req ../search-content/{title}, take title and find content by title ,
	 * resp list content to view
	 */
	@GetMapping("/search-content/{title}")
	public String findContent(@PathVariable("title") String title, Model model) throws Exception {

		List<Content> contents = contentService.findByTitleContaining(title);
		model.addAttribute("contents", contents);

		return "view-content";
	}

	/*
	 * handle req ../edit-content/{id}, take contentId and find content by contentId
	 * ,inject data to form edit-content , resp form edit-content to view
	 */
	@GetMapping("/edit-content/{id}")
	public String goEditContent(@PathVariable("id") int id, @ModelAttribute("content") Content content, Model model)
			throws Exception {

		content = contentService.findContentByContentId(id);
		model.addAttribute("content", content);

		return "edit-content";
	}

}
