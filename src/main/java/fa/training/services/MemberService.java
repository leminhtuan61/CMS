package fa.training.services;

import fa.training.models.Member;

public interface MemberService {

	// method save or update Member
	public boolean saveOrUpdateMember(Member member) throws Exception;

	// method login member check email and password from database
	public Member checkLogin(Member member) throws Exception;

	// method find member by memberId
	public Member findMemberById(int id) throws Exception;

	// method find member by email
	public Member findMemberByEmail(String email) throws Exception;
}
