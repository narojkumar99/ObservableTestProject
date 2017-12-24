package com.dipanshu.app.observabletestproject.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dipanshu.app.observabletestproject.R;
import com.dipanshu.app.observabletestproject.services.PostsDataProvider;
import com.dipanshu.app.observabletestproject.ui.adapters.PostsAdapter;


/**
 * Created by Dipanshu on 24-12-2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView list_items = findViewById(R.id.list_items);

        PostsAdapter adapter = new PostsAdapter(PostsDataProvider.posts());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        list_items.setLayoutManager(llm);
        list_items.setAdapter(adapter);
    }
}
