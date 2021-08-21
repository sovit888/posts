package com.example.restapis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RequestQueue;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView postlist=findViewById(R.id.postlistview);

        RequestQueue queue = Volley.newRequestQueue(this);
                String url ="http://10.0.2.2:2000/api/data";
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Post> posts = new ArrayList<Post>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject datas = response.getJSONObject(i);
                        String name= datas.getString("name");
                        String address=datas.getString("address");
                        int age=datas.getInt("age");
                        posts.add(new Post(name,age,address));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
               PostAdapter postadapter=new PostAdapter(MainActivity.this,R.layout.postlayout,posts.toArray(new Post[response.length()]));
                postlist.setAdapter(postadapter);
                postlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this,"Hello ikt is cliekc",Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);

    }
}