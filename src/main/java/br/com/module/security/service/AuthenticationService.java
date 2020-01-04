package br.com.module.security.service;

import br.com.module.security.model.Details;
import br.com.module.security.model.Users;
import br.com.module.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    private boolean encrypt(String passwordEncrypted, String passwordAuthentication) {
        return new BCryptPasswordEncoder(10).matches(passwordAuthentication, passwordEncrypted);
    }

    public Details isCorrectCredentials(Authentication authentication) {

        Users users = this.userRepository.findByLogin(authentication.getName());

        if(users == null || !encrypt(users.getSenha(), authentication.getCredentials().toString())) {
            return null;
        }

        Details details = new Details(users);
        details.setAuthenticated(true);

        return details;
    }
}
