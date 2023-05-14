package com.geekster.InstagramPart1.repositories;

import com.geekster.InstagramPart1.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Long> {
    Post findByPostId(Long postId);
}
