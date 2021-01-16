package fa.training.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.ContentDao;
import fa.training.models.Content;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentDao contentDao;

	public boolean saveContent(Content content) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Content>> constraintViolations = validator.validate(content);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Content> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return false;
		} else {
			contentDao.saveOrUpdateContent(content);
			return true;
		}
	}

	public boolean deleteContentById(int contentId) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Integer>> constraintViolations = validator.validate(contentId);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Integer> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return false;
		} else {
			return contentDao.deleteContentByContentId(contentId);
		}
	}

	public List<Content> findAllContent() throws Exception {

		return contentDao.findAllContent();
	}

	public List<Content> findByTitleContaining(String title) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<String>> constraintViolations = validator.validate(title);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<String> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return null;
		} else {

			return contentDao.findByTitleContaining(title);
		}
	}

	public Content findContentByContentId(int contentId) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Integer>> constraintViolations = validator.validate(contentId);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Integer> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return null;
		} else {

			return contentDao.findContentByContentId(contentId);
		}
	}

}
