package com.geekster.InstagramPart1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String postData;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;


}
