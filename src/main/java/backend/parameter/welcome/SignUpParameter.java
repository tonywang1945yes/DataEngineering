package backend.parameter.welcome;

public class SignUpParameter {
    String username;
    String phoneNumber;
    String password;
    String emailAddress;
    int type;

    public SignUpParameter() {
    }

    public SignUpParameter(String username, String phoneNumber, String password, String emailAddress, int type) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.emailAddress = emailAddress;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
