package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    //private UserRepository userRepository;
    private UserRepositoryWithDatabase userRepositoryWithDatabase;

    private final AtomicLong counter = new AtomicLong();

    public void addUser(String name){
        userRepositoryWithDatabase.save(new User(counter.incrementAndGet() , name));
    }

    public Iterable<User> getAllUsers() {
        return userRepositoryWithDatabase.findAll();
    }
}
