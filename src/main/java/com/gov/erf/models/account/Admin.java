package com.gov.erf.models.account;

import com.gov.erf.config.basic.AbstractUser;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.Region;
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
            String phone,
            String password,
            Boolean locked,
            Boolean enabled,
            Role roleType,
            Region region,
            Organ organ
    ) {
        super(name, surname, patronymic, username, email, phone, password, locked, enabled, roleType, region,organ);
    }
}
