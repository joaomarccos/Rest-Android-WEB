package edu.ifpb.pdm.servicosmedicos.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import edu.ifpb.pdm.servicosmedicos.R;
import edu.ifpb.pdm.servicosmedicos.entities.Doctor;

/**
 * Created by Rafael on 23/03/2016.
 */
public class ListDoctors extends ArrayAdapter<Doctor> {
    public ListDoctors(Context context, List<Doctor> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Doctor dr = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.doctorslist,null);
        //ImageView imageView=(ImageView)convertView.findViewById(R.id.imageIcon);
        TextView doctorView=(TextView) convertView.findViewById(R.id.nameDoctorView);
        doctorView.setText(dr.getName());

        TextView clinicaView=(TextView) convertView.findViewById(R.id.nameClinicaView);
        clinicaView.setText(dr.getClinic().getName());

        RatingBar rating = (RatingBar) convertView.findViewById(R.id.ratingBar);
        rating.setRating(Float.parseFloat(String.valueOf(dr.getRating())));

        return convertView;
    }
}
