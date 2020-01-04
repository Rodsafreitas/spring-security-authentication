package br.com.module.security.model;


import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EnumType;

@Entity
@Table(name = "authority")
public class Authority {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority() {}

    public Authority(AuthorityType name) {
        this.name = name;
    }

    public AuthorityType getName() {
        return name;
    }

    public void setName(AuthorityType name) {
        this.name = name;
    }
}