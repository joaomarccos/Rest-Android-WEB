package edu.ifpb.pdm.servicosmedicos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Rating;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.ifpb.pdm.servicosmedicos.entities.Doctor;
import edu.ifpb.pdm.servicosmedicos.utils.ImageMapDownload;

public class DoctorDetails extends AppCompatActivity {
    private ImageView image;
    private Doctor doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        image = (ImageView)findViewById(R.id.imageMap);
        doctor = (Doctor) getIntent().getSerializableExtra("Doctor");

        TextView nomeDoctor = (TextView) findViewById(R.id.nameDoctorView);
        nomeDoctor.setText(doctor.getName());

        TextView nomeClinica = (TextView) findViewById(R.id.nameClinicaView);
        nomeClinica.setText(doctor.getClinic().getName());

        RatingBar avaliacao = (RatingBar) findViewById(R.id.ratingBar);
        avaliacao.setRating(Float.parseFloat(String.valueOf(doctor.getRating())));

        TextView especialidade = (TextView) findViewById(R.id.drEspel);
        especialidade.setText(doctor.getSpecialty());

        TextView opiniao = (TextView) findViewById(R.id.drOpi);
        opiniao.setText(doctor.getOpinion());

        TextView contact = (TextView) findViewById(R.id.drContact);
        contact.setText(doctor.getContact());

        TextView location = (TextView) findViewById(R.id.drlocation);
        location.setText(doctor.getLocation());

        loadMap(doctor.getClinic().getCoord_lat(), doctor.getClinic().getCoord_lng());
    }

    public void callComments(View view){
        Intent intent=new Intent(this, ListComents.class);
        intent.putExtra("Doctor", doctor);
        startActivity(intent);
    }

    public void loadMap(String lat, String lng){
        TarefaDownload tarefa = new TarefaDownload();
        tarefa.execute(lat, lng);
    }

    private class TarefaDownload extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Bitmap doInBackground(String... params) {
            return ImageMapDownload.getGoogleMapThumbnail(params[0],params[1]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap){
                image.setImageBitmap(bitmap);
        }
    }

}
