package backend.parameter.welcome;

/**
 * @author Wen Sun
 * @date 2019-3-18
 */
public class UserQueryParameter {
    String username;
    String date;
    int type;

    public UserQueryParameter() {
    }

    public UserQueryParameter(String username, String date, int type) {
        this.username = username;
        this.date = date;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
