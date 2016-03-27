package edu.ifpb.pdm.servicosmedicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import edu.ifpb.pdm.servicosmedicos.entities.CommentVO;
import edu.ifpb.pdm.servicosmedicos.entities.Doctor;
import edu.ifpb.pdm.servicosmedicos.storage.UserPreferences;

public class AddComment extends AppCompatActivity {
    private Doctor doctor;
    private CommentVO comment;
    private UserPreferences u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        u = new UserPreferences(this);
        comment = new CommentVO();
        comment.setUserName(u.getUserName());
        doctor = (Doctor) getIntent().getSerializableExtra("Doctor");
        comment.setDoctorId(doctor.getId());
        TextView user = (TextView) findViewById(R.id.UserNameView);
        user.setText(u.getUserName());
    }

    public void sendComment(){
        RatingBar avaliacao = (RatingBar) findViewById(R.id.avaliacao);
        comment.setRating(avaliacao.getRating());

        EditText com = (EditText) findViewById(R.id.editTextComment);
        if (com.getText().toString().equals("")){
            Toast.makeText(this,"Digite um comentário", Toast.LENGTH_SHORT);
        }else{
            comment.setComment(com.getText().toString());
        }
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.postForEntity("http://192.168.0.101:8080/doctors/comments", comment, Void.class);
    }

    public void add(View v){
        sendComment();
        Toast.makeText(this,"Obrigado pela Avaliação!",Toast.LENGTH_SHORT);
    }
}
