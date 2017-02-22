package be.cegeka.bibliothouris.domain.users;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jensde on 22/02/2017.
 */
public interface UserRepositoryWithDatabase extends CrudRepository <User, Long> {
}
