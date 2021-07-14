package com.gov.erf.config.basic;

import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.RoleType;
import com.gov.erf.models.claims.Region;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "username")
    private String username;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "locked")
    private Boolean locked;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public AbstractUser(
            String name,
            String surname,
            String patronymic,
            String username,
            String email,
            String phone,
            String password,
            Boolean locked,
            Boolean enabled,
            Role role,
            Region region
    ) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
        this.locked = locked;
        this.enabled = enabled;
        this.region = region;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(role.getTitle());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
