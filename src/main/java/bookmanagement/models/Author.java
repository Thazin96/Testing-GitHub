package bookmanagement.models;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

//Author DTO (Data Transfer Object)
public class Author {
	private int id;
	@NotEmpty
	private String name;
	private String address;
	private String copyright_contace;
	private String contact_email;
	
	public String getCopyright_contace() {
		return copyright_contace;
	}

	public void setCopyright_contace(String copyright_contace) {
		this.copyright_contace = copyright_contace;
	}

	public Author() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(this==null) {
			return false;
		}
		if (getClass()!=obj.getClass()){
			return false;
		}
		Author other = (Author)obj;
		return Objects.equals(id, other.getId()) && Objects.equals(name, other.getName());
	}
}
