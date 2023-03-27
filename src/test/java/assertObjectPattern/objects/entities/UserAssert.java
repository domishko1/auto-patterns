package assertObjectPattern.objects.entities;

public class UserAssert {

    private User user;

    public UserAssert(User user) {
        this.user = user;
    }

    public boolean hasProfileData() {
        return !user.getLogin().isEmpty() && !user.getEmail().isEmpty();
    }
}
