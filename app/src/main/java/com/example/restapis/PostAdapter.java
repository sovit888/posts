package com.example.restapis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PostAdapter extends ArrayAdapter<Post> {
Post[] posts;
    public PostAdapter(@NonNull Context context, int resource, @NonNull Post[] posts) {
        super(context, resource,posts);
        this.posts=posts;
    }

    @Nullable
    @Override
    public Post getItem(int position) {
        return posts[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.postlayout,parent,false);
        TextView name=convertView.findViewById(R.id.name);
        name.setText("Name: "+posts[position].getName());
        TextView address=convertView.findViewById(R.id.address);
        address.setText("Address: "+posts[position].getAddress());
        Button btn=convertView.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Hello world",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}

