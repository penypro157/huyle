package spring.web.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.entity.TaiKhoan;
import spring.web.repo.TaiKhoanRepo;
import spring.web.service.TaiKhoanService;

import java.util.ArrayList;
import java.util.List;

@ComponentScan("spring.web.repo")
@Component
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    TaiKhoanService taiKhoanService;
    private UserDetails userDetails;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        TaiKhoan taiKhoan= taiKhoanService.getTaiKhoanByEmail(email);
        try {
            userDetails = new User(taiKhoan.getEmail(), taiKhoan.getPassword(),taiKhoan.getTrangThai().isVerified(),accountNonExpired,credentialsNonExpired,taiKhoan.getTrangThai().isActive(),getAuthorities(taiKhoan.getTrangThai().getRole()));
        }
         catch (Exception e){
             System.out.println(e);
         }

        return userDetails;
    }
    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = new ArrayList<>();
        if (role.intValue() == 1) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        } else if (role.intValue() == 2) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return authList;
    }
}
