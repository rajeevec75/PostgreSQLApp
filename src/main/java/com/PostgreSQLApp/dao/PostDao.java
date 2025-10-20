package com.PostgreSQLApp.dao;

import com.PostgreSQLApp.model.Post;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getRecentPosts(int count, int offset) {
        int start = Math.min(offset, posts.size());
        int end = Math.min(offset + count, posts.size());
        return posts.subList(start, end);
    }

    public void savePost(Post post) {
        posts.add(post);
    }
}
