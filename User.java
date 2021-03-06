package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class User 
{
	@NotNull(message = "Please enter a first name this is a required field")
	@Size(min =4, max=15)
	String firstName = "";
	@NotNull(message = "Please enter a first name this is a required field")
	@Size(min =4, max=15)
	String lastName = "";
	
	public User()
	{
		firstName = "Donnell";
		lastName = "Sample";
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
	
	
	

}
