package fa.training.dao;

import fa.training.models.Member;

public interface MemberDao {
	// method check login member , getEmail and getPassword check from database
	Member checkLogin(Member member) throws Exception;

	// method save or update member use session
	boolean saveOrUpdateMember(Member member) throws Exception;

	// method find member by memberId use session
	Member findMemberByMemberId(int id) throws Exception;

	// method find member by email use hql
	Member findMemberByEmail(String email) throws Exception;
}
