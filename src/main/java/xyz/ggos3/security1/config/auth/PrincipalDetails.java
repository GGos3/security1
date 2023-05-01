package xyz.ggos3.security1.config.auth;

// 스프링시큐리티가 /login에 요청이 오면 낚아채 로그인을 진행 시킨다.
// 로그인 진행이 완료되면 시큐리티 session을 발행한다. 키 값 = (Security ContextHolder)
// 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야함
// User 오브젝트 => UserDetails 타입 객체

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// Security => Authentication => UserDetails(PrincipalDetails)
public class PrincipalDetails implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
