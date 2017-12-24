package com.dipanshu.app.observabletestproject.ui.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.dipanshu.app.observabletestproject.R;
import com.dipanshu.app.observabletestproject.model.Posts;
import com.dipanshu.app.observabletestproject.ui.activities.PostDetailActivityOne;
import com.dipanshu.app.observabletestproject.util.Utility;

import java.util.List;

/**
 * Created by Dipanshu on 24-12-2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<Posts> postsList;

    public PostsAdapter(List<Posts> postsList) {
        this.postsList = postsList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_items, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindPostViews(postsList.get(position));
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView text_title;
        TextView text_description;
        TextView text_timing;
        View itemView;

        PostViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            text_title = itemView.findViewById(R.id.text_title);
            text_description = itemView.findViewById(R.id.text_description);
            text_timing = itemView.findViewById(R.id.text_timing);
        }

        void bindPostViews(final Posts posts){
            text_title.setText(posts.getTitle());
            text_description.setText(posts.getDescription());

            long postDate = Utility.timeInMillis(posts.getTimestamp());

            text_timing.setText(Utility.getDateDifference(postDate));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detailIntent = new Intent(v.getContext(), PostDetailActivityOne.class);
                    //Intent detailIntent = new Intent(v.getContext(), PostDetailActivityTwo.class);
                    //Intent detailIntent = new Intent(v.getContext(), PostDetailActivityThree.class);
                    detailIntent.putExtra("POST", posts);
                    v.getContext().startActivity(detailIntent);
                }
            });
        }
    }
}
