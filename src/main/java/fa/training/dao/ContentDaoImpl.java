package fa.training.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.models.Content;

@Repository
@Transactional
public class ContentDaoImpl implements ContentDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<Content> findAllContent() throws Exception {
		Query<Content> query = sessionFactory.getCurrentSession().createQuery("FROM Content");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Content> findByTitleContaining(String title) throws Exception {
		Query<Content> query = sessionFactory.getCurrentSession().createQuery("from Content where title LIKE  :title");
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}

	@Override
	public boolean saveOrUpdateContent(Content content) throws Exception {
		session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(content);
		return true;
	}

	@Override
	public boolean deleteContentByContentId(int contentId) throws Exception {
		session = sessionFactory.getCurrentSession();
		Content content = session.get(Content.class, contentId);
		session.remove(content);
		return true;
	}

	@Override
	public Content findContentByContentId(int contentId) throws Exception {
		session = sessionFactory.getCurrentSession();
		Content content = session.get(Content.class, contentId);
		return content;
	}

}
