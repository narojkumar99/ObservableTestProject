package com.dipanshu.app.observabletestproject.services;


import com.dipanshu.app.observabletestproject.model.Posts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KRISHNA on 24-12-2017.
 */

public class PostsDataProvider {

    public static List<Posts> posts(){
        List<Posts> posts = new ArrayList<>();
        posts.add(new Posts("Post Title One","This is a dummy text for this post's description","25-12-2017 02:51:00.000"));
        posts.add(new Posts("Post Title Two","This is a dummy text for this post's description","25-12-2017 02:50:00.000"));
        posts.add(new Posts("Post Title Three","This is a dummy text for this post's description","24-12-2017 22:25:00.000"));
        posts.add(new Posts("Post Title Four","This is a dummy text for this post's description","24-12-2017 18:10:00.000"));
        posts.add(new Posts("Post Title Five","This is a dummy text for this post's description","24-12-2017 13:45:00.000"));
        posts.add(new Posts("Post Title Six","This is a dummy text for this post's description","23-12-2017 18:35:00.000"));
        posts.add(new Posts("Post Title Seven","This is a dummy text for this post's description","23-12-2017 08:25:00.000"));
        return posts;
    }
}
