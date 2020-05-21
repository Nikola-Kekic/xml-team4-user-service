package xml.xmluserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.xmluserservice.model.Admin;
import xml.xmluserservice.model.BasicUser;
import xml.xmluserservice.model.RoleTypes;
import xml.xmluserservice.model.User;
import xml.xmluserservice.repository.AdminRepository;
import xml.xmluserservice.repository.BasicUserRepository;
import xml.xmluserservice.repository.UserRepository;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

import static xml.xmluserservice.model.RoleTypes.BASIC_USER;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BasicUserRepository basicUserRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(User user) {
        User u = this.userRepository.findByUsername(user.getUsername());
        if(u != null) {
            if(u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }

        return null;
    }

    public BasicUser register(BasicUser user) {
        BasicUser u = this.basicUserRepository.findByUsername(user.getUsername());
        if(u == null) {
            user.setRoleType(BASIC_USER);
            u = this.basicUserRepository.save(user);
            return u;
        }

        return null;
    }

    public void changeRoleType(User user, String roleType) {
        // RoleTypes.valueOf(roleType);
         System.out.println(RoleTypes.valueOf(roleType));
        if(roleType == "ADMIN"){
            Admin admin = new Admin();
            admin.setRoleType(RoleTypes.valueOf(roleType));
            admin.setUsername(user.getUsername());
            admin.setPassword(user.getPassword());
            userRepository.deleteById(user.getId());
            this.adminRepository.save(admin);
        }

    }

    public User addNewUser(User u) {
        System.out.println(u.getUsername() + " noviii");
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if(user.getUsername().equals(u.getUsername())) {
                System.out.println("Ne moze!");
                return null;
            }
        }

        u.setRoleType(RoleTypes.BASIC_USER);
        this.userRepository.save(u);

        return u;
    }
}
