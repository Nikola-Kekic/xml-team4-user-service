package xml.xmluserservice.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private RoleTypes roleType;

    //private Set<Authority> authorities;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleTypes getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleTypes roleType) {
        this.roleType = roleType;
    }

    /*public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }*/
}
