package objectPoolPattern.objects;

import java.util.LinkedList;
import java.util.List;

public class UserPool {
    List<PooledUser> free = new LinkedList<>();
    List<PooledUser> used = new LinkedList<>();

    public PooledUser getPooledUser() {
        PooledUser pooledUser;
        if (free.isEmpty()) {
            pooledUser = new PooledUser();
            used.add(pooledUser);
        } else {
            pooledUser = free.get(0);
            used.add(pooledUser);
            free.remove(pooledUser);
        }
        return pooledUser;
    }

    public void releasePooledUser(PooledUser pooledUser) {
        used.remove(pooledUser);
        free.add(pooledUser);
    }

}
