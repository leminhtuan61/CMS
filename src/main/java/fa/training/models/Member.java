package fa.training.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private int memberId;

	@Pattern(regexp = "^.{3,30}$", message = "First name must contain at least 3 character and maximum 30 character")
	@Column(name = "first_name")
	private String firstName;

	@Pattern(regexp = "^.{3,30}$", message = "Last name must contain at least 3 character and maximum 30 character")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "^.{3,30}$", message = "User name must contain at least 3 character and maximum 30 character")
	@Column(name = "user_name")
	private String userName;

	@Pattern(regexp = "^.{8,30}$", message = "must contain at least 8 character and maximum 30 character")
	@Column(name = "password")
	private String password;

	@Pattern(regexp = "^[0-9]{9,13}$", message = "Phone number must contain at least 9 character and maximum 13 character")
	@Column(name = "phone")
	private String phone;

	@Pattern(regexp = "^(.+)@(.+)$", message = "Email must contain at least 3 character and maximum 50 character")
	@Column(name = "email")
	private String email;
	@Pattern(regexp = "^.{0,200}$", message = "maximum description is 200 character")
	@Column(name = "description")
	private String description;
	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;
	@UpdateTimestamp
	@Column(name = "update_time")
	private Date updateTime;
	@Column(name = "role")
	private String role;
	@OneToMany(mappedBy = "member")
	private Set<Content> contents;
	
	

	public Member() {
		super();
	}

	public Member(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Member(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Member(String firstName, String lastName, String phone, String email, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.description = description;
	}

	public Member(String firstName, String lastName, String userName, String password, String phone, String email,
			String description, Date createdDate, Date updateTime, Set<Content> contents) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createdDate = createdDate;
		this.updateTime = updateTime;
		this.contents = contents;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Set<Content> getContents() {
		return contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}

}
