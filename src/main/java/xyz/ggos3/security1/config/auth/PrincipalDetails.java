package xyz.ggos3.security1.config.auth;

// 스프링시큐리티가 /login에 요청이 오면 낚아채 로그인을 진행 시킨다.
// 로그인 진행이 완료되면 시큐리티 session을 발행한다. 키 값 = (Security ContextHolder)
// 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야함
// User 오브젝트 => UserDetails 타입 객체

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.ggos3.security1.model.User;

import java.util.ArrayList;
import java.util.Collection;

// Security => Authentication => UserDetails(PrincipalDetails)

@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    // 계정의 활성화 여부 결정
    @Override
    public boolean isEnabled() {
        return true;
    }
}
