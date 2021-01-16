package fa.training.services;

import java.util.List;

import fa.training.models.Content;

public interface ContentService {

	// method save or update Content
	public boolean saveContent(Content content) throws Exception;

	// method delete Content by contentId
	public boolean deleteContentById(int contentId) throws Exception;

	// method list all Content
	public List<Content> findAllContent() throws Exception;

	// method find Content containing title
	public List<Content> findByTitleContaining(String title) throws Exception;

	// method find content by ContentId
	public Content findContentByContentId(int contentId) throws Exception;

}
