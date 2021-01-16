package fa.training.services;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.MemberDao;
import fa.training.models.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	public boolean saveOrUpdateMember(Member member) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Member> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return false;
		} else {

			return memberDao.saveOrUpdateMember(member);
		}
	}

	public Member checkLogin(Member member) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Member> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return null;
		} else {
			return memberDao.checkLogin(member);
		}
	}

	public Member findMemberById(int id) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Integer>> constraintViolations = validator.validate(id);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Integer> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return null;
		} else {
			return memberDao.findMemberByMemberId(id);
		}
	}

	public Member findMemberByEmail(String email) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<String>> constraintViolations = validator.validate(email);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<String> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}

			return null;
		} else {
			return memberDao.findMemberByEmail(email);
		}
	}
}
