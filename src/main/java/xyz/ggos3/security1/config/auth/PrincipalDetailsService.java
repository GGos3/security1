package xyz.ggos3.security1.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.ggos3.security1.model.User;
import xyz.ggos3.security1.repository.UserRepository;

// 시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 loc 되어있는 loadUserByUsername 메서드가 실행된다.

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = repository.findByUsername(username);
        if (userEntity != null)
            return new PrincipalDetails(userEntity);
        return null;
    }
}
