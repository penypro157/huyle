package spring.web.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import spring.web.entity.UserEntity;
import spring.web.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@ComponentScan("spring.web.repo")
@Component
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    private UserDetails userDetails;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        UserEntity userEntity=userRepository.findByEmail(email);
        userDetails= new User(userEntity.getEmail(),userEntity.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,getAuthorities(userEntity.getRoles()));

        return userDetails;
    }
    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = new ArrayList<>();
        if (role.intValue() == 1) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        } else if (role.intValue() == 2) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        System.out.println(authList);
        return authList;
    }
}
