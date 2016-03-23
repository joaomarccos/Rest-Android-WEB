package edu.ifpb.pdm.servicosmedicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.ifpb.pdm.servicosmedicos.storage.UserPreferences;

public class MainActivity extends AppCompatActivity {
    private UserPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Metódo que chama a activity do perfil
     * @param view
     */
    public void callListDoctorActivity(View view){
        Intent intent = new Intent(this, ListDoctorsActivity.class);
        startActivity(intent);
    }

    public void saveUserName(){
        pref = new UserPreferences(this);
        String nome = String.valueOf(findViewById(R.id.nomeInput));
        pref.saveUserName(nome);
    }
}
