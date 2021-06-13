package com.gov.erf.models.account;

import com.gov.erf.config.basic.AbstractUser;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
public class Admin extends AbstractUser {

    public Admin(
            String name,
            String surname,
            String patronymic,
            String username,
            String email,
            String password,
            Role role
    ) {
        super(name, surname, patronymic, username, email, password, role);
    }
}
