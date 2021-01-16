package fa.training.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Content")
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_id")
	private int contentId;

	@Pattern(regexp = "^.{10,200}$", message = "Title must contain at least 10 character and maximum 200 character")
	@Column(name = "title")
	private String title;

	@Pattern(regexp = "^.{30,150}$", message = "Brief must contain at least 30 character and maximum 150 character")
	@Column(name = "brief")
	private String brief;

	@Pattern(regexp = "^.{50,1000}$", message = "Content must contain at least 50 character and maximum 1000 character")
	@Column(name = "content")
	private String content;
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateTime;
	@Column(name = "sort")
	private String sort;
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Content() {
		super();
	}

	public Content(String title, String brief, String content, Date createDate, Date updateTime, String sort,
			Member member) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateTime = updateTime;
		this.sort = sort;
		this.member = member;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public Content(String title, String brief, String content) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
