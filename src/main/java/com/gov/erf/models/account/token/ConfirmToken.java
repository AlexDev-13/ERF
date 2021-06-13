package com.gov.erf.models.account.token;

import com.gov.erf.models.account.Admin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ConfirmToken {

    @SequenceGenerator(
            name = "conf_token_sq",
            sequenceName = "conf_token_sq",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "conf_token_sq"
    )
    private Long id;

    @Column(nullable = false)
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "admin_id"
    )
    private Admin admin;

    public ConfirmToken(
            String token,
            Admin admin,
            LocalDateTime createdAt,
            LocalDateTime expiredAt
    ) {
        this.token = token;
        this.admin = admin;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }

}
