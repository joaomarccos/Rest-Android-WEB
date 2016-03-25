package edu.ifpb.pdm.servicosmedicos.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rafael on 22/03/2016.
 */
public class UserPreferences {
    public static final String PREFS_NAME = "MyPrefsFile";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public UserPreferences(Context context){
        settings =  context.getSharedPreferences(PREFS_NAME, 0);
        editor = settings.edit();
    }


    public  void saveUserName(String name){
        editor.putString("UserName", name);
        editor.commit();
    }

    public String getUserName(){
        return settings.getString("UserName", "");
    }
}
