package br.com.module.security.config;

import br.com.module.security.model.Details;
import br.com.module.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthenticationDatabase implements AuthenticationProvider {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Details details = this.authenticationService.isCorrectCredentials(authentication);

        Collection<? extends GrantedAuthority> authorities = null;

        if(details != null) {
            authorities = details.getAuthorities();
        }

        return new UsernamePasswordAuthenticationToken(details, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
