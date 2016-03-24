package edu.ifpb.pdm.servicosmedicos;




import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import edu.ifpb.pdm.servicosmedicos.List.ListDoctors;
import edu.ifpb.pdm.servicosmedicos.entities.Doctor;
import edu.ifpb.pdm.servicosmedicos.storage.UserPreferences;

public class ListDoctorsActivity extends AppCompatActivity {
    private List<Doctor> doctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doctors);
        this.doctors = getAllDoctors();

        ListDoctors listDoctors = new ListDoctors(this, doctors);

        ListView listView=(ListView)findViewById(R.id.listViewDoctors);

        listView.setAdapter(listDoctors);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doctor dr = (Doctor) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListDoctorsActivity.this, DoctorDetails.class);
                intent.putExtra("Doctor", dr);
                startActivity(intent);
            }
        });
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorList;
        String url= "http://192.168.0.101:8080/doctors";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        doctorList = restTemplate.getForObject(url, List.class);
        return doctorList;
    }

    public void filterDoctor(View view){
        TextView filterVw = (TextView) findViewById(R.id.filterValue);
        CharSequence filter = filterVw.getText();
        if(!filter.toString().equals("")) {
            ListDoctors listDoctors = new ListDoctors(this, getFilterList(filter));
            ListView listView = (ListView) findViewById(R.id.listViewDoctors);
            listView.setAdapter(listDoctors);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Doctor dr = (Doctor) parent.getItemAtPosition(position);
                    Intent intent = new Intent(ListDoctorsActivity.this, DoctorDetails.class);
                    intent.putExtra("Doctor", dr);
                    startActivity(intent);
                }
            });
        }
    }


    public List<Doctor> getFilterList(CharSequence filter){
        List<Doctor> filterlist = new ArrayList<>();
        for(Doctor d: doctors){
            if((d.getName().contains(filter))||(d.getClinic().getName().contains(filter))){
                filterlist.add(d);
            }
        }
        return filterlist;
    }
}
