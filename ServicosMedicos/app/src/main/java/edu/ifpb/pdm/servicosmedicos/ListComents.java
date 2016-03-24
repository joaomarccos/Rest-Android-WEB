package edu.ifpb.pdm.servicosmedicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import edu.ifpb.pdm.servicosmedicos.List.ListComments;
import edu.ifpb.pdm.servicosmedicos.entities.Comment;
import edu.ifpb.pdm.servicosmedicos.entities.Doctor;

public class ListComents extends AppCompatActivity {
    private Doctor doctor;
    private List<Comment> listComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coments);
        doctor = (Doctor) getIntent().getSerializableExtra("Doctor");

        listComment = getAllComments();

        ListComments commentsAdapter = new ListComments(this, listComment);

        ListView listView=(ListView)findViewById(R.id.listViewComment);

        listView.setAdapter(commentsAdapter);
    }

    public void callAddComment(View v){
        Intent intent = new Intent(ListComents.this, AddComment.class);
        startActivity(intent);
    }

    public List<Comment> getAllComments(){
        List<Comment> commentList;
        String url= "http://192.168.0.101:8080/doctors/comments/{"+doctor.getId()+"}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        commentList = restTemplate.getForObject(url, List.class);
        return commentList;
    }
}
