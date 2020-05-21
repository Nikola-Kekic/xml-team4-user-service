package xml.xmluserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xml.xmluserservice.model.BasicUser;
import xml.xmluserservice.model.User;

import java.util.ArrayList;

public interface BasicUserRepository extends JpaRepository<BasicUser, Long> {

    ArrayList<BasicUser> findAll();
    BasicUser findByUsername(String username);
    void deleteById(Long id);
    BasicUser save(BasicUser user);


}