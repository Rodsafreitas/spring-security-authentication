package br.com.module.security.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable  {

    @Id
    private Long user_id;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "senha")
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") })
    private Set<Authority> authorities = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }


    public Set<Authority> getAuthorities() {
       return authorities;
    }
}
