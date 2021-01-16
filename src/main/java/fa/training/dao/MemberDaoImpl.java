package fa.training.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.models.Member;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session = null;

	@SuppressWarnings("unchecked")
	@Override
	public Member checkLogin(Member member) throws Exception {
		Query<Member> query = sessionFactory.getCurrentSession()
				.createQuery("From Member Where email=:email and password=:password");
		query.setParameter("email", member.getEmail());
		query.setParameter("password", member.getPassword());
		return query.getResultList().get(0);
	}

	@Override
	public boolean saveOrUpdateMember(Member member) throws Exception {
		session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(member);
		return true;
	}

	@Override
	public Member findMemberByMemberId(int id) throws Exception {
		session = sessionFactory.getCurrentSession();
		Member member = session.get(Member.class, id);
		return member;
	}

	@Override
	public Member findMemberByEmail(String email) throws Exception {
		@SuppressWarnings("unchecked")
		Query<Member> query = sessionFactory.getCurrentSession().createQuery("from Member where email=:email");
		query.setParameter("email", email);

		return query.getResultList().get(0);
	}

}
