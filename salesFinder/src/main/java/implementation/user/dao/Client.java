package implementation.user.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class Client {

    private String rolePrefix = "ROLE_";

    private String username;

    private String password;

    private List<String> roles;

    private String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<SimpleGrantedAuthority> getRoles() {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roles != null) {
            roles.stream().forEach(role -> {
                String authorityRole = role.startsWith(rolePrefix) ? role : rolePrefix + role;
                grantedAuthorities.add(new SimpleGrantedAuthority(authorityRole));
            });
        }
        return grantedAuthorities;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("password", password)
                .append("roles", roles)
                .append("email", email)
                .toString();
    }

}
