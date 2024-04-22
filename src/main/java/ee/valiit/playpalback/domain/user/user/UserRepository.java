package ee.valiit.playpalback.domain.user.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = :username and u.password = :password and u.status = :status")
    Optional<User> findUserBy(String username, String password, String status);

    @Query("select (count(u) > 0) from User u where upper(u.username) = upper(:username)")
    boolean usernameExists(String username);




}