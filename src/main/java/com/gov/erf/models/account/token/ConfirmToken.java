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
@Table(name = "confirm_token")
@NoArgsConstructor
public class ConfirmToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,
            name = "token")
    private String token;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "confirmed_at")
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
