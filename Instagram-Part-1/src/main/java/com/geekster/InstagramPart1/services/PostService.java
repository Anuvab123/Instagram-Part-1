package com.geekster.InstagramPart1.services;

import com.geekster.InstagramPart1.models.Post;
import com.geekster.InstagramPart1.models.User;
import com.geekster.InstagramPart1.repositories.PostRepo;
import com.geekster.InstagramPart1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;

    public void savePost(Post post) {

        Long userId = post.getUser().getUserId();
        User user=userRepo.findByUserId(userId);

        if(user != null){
            post.setUser(user);
            postRepo.save(post);
        }

        else {
                throw new IllegalStateException("you need to signup before posting anything");
            }

    }

    public Post fetchPost(Long postId) {
        return postRepo.findByPostId(postId);
    }
}
