package xml.xmluserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xml.xmluserservice.model.Admin;

import java.util.ArrayList;

public interface AdminRepository extends JpaRepository<Admin, Long> {

        ArrayList<Admin> findAll();
        Admin findByUsername(String username);
        void deleteById(Long id);
        Admin save(Admin admin);

}