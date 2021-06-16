package com.gov.erf.models.account;

import com.gov.erf.config.basic.AbstractUser;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@Table(name = "admin")
public class Admin extends AbstractUser {

    public Admin(
            String name,
            String surname,
            String patronymic,
            String username,
            String email,
            String password,
            Boolean locked,
            Boolean enabled,
            Role roleType
    ) {
        super(name, surname, patronymic, username, email, password, locked, enabled, roleType);
    }
}
