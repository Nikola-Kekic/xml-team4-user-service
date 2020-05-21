package xml.xmluserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xml.xmluserservice.model.User;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {

    ArrayList<User> findAll();
    User findByUsername(String username);
    void deleteById(Long id);
    User save(User user);


}
