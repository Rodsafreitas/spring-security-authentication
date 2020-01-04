package br.com.module.security.repository;

import br.com.module.security.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByLogin(String login);

}
