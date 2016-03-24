package edu.ifpb.pdm.servicosmedicos.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import edu.ifpb.pdm.servicosmedicos.R;
import edu.ifpb.pdm.servicosmedicos.entities.Comment;
import edu.ifpb.pdm.servicosmedicos.entities.Doctor;

/**
 * Created by Rafael on 24/03/2016.
 */
public class ListComments extends ArrayAdapter<Comment> {
    public ListComments(Context context, List<Comment> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.commentslist,null);
        //ImageView imageView=(ImageView)convertView.findViewById(R.id.imageIcon);
        TextView userName=(TextView) convertView.findViewById(R.id.UserNameView);
        userName.setText(comment.getUserName());

        TextView comm=(TextView) convertView.findViewById(R.id.commetView);
        comm.setText(comment.getComment());

        RatingBar rating = (RatingBar) convertView.findViewById(R.id.ratingBar2);
        rating.setRating(Float.parseFloat(String.valueOf(comment.getRating())));

        return convertView;
    }
}
