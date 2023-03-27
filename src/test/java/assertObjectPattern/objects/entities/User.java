package assertObjectPattern.objects.entities;

public class User {
    private String login;
    private String password;
    private String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }
    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

}
