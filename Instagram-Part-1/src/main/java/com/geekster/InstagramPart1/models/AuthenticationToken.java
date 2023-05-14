package com.geekster.InstagramPart1.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;
    @OneToOne
    @JoinColumn(name = "fk-user_id", nullable = false)
    private User user;

    public AuthenticationToken( User user) {

        this.token = UUID.randomUUID().toString();;
        this.tokenCreationDate = LocalDate.now();
        this.user = user;
    }
}
