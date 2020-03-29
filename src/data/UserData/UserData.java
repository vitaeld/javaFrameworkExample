package data.UserData;

public class UserData {

	private String validEmail;
	private String validPassword;
	private String invalidEmail;
    
    public String getValidEmail() {
        return this.validEmail;
    }
  
    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }
    
    public String getValidPassword() {
        return this.validPassword;
    }
 
    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }
    
    public String getInvalidEmail() {
        return this.invalidEmail;
    }
 
    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }
}
