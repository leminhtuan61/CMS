package fa.training.dao;

import java.util.List;

import fa.training.models.Content;

/**
 * @author TuanLM16
 *
 */
public interface ContentDao {
	// method list all content use hql
	List<Content> findAllContent() throws Exception;

	// method find title containing tile use hql
	List<Content> findByTitleContaining(String title) throws Exception;

	// method save or update content use session
	boolean saveOrUpdateContent(Content content) throws Exception;

	// method delete content by contentId use session
	boolean deleteContentByContentId(int contentId) throws Exception;

	// method find content by contentId use sesion
	Content findContentByContentId(int contentId) throws Exception;
}
