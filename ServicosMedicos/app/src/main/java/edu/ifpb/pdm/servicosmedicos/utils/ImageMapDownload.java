package edu.ifpb.pdm.servicosmedicos.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rafael on 23/03/2016.
 */
public class ImageMapDownload {
    public static Bitmap getGoogleMapThumbnail(String lati, String longi){
        String URL = "http://maps.google.com/maps/api/staticmap?center=" +lati + "," + longi +
                "&zoom=15&size=200x200&sensor=false&markers=color:red|label:C|" +lati + "," + longi + "";
        Bitmap bmp = null;
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet(URL);

        InputStream in = null;
        try {
            in = httpclient.execute(request).getEntity().getContent();
            bmp = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bmp;
    }
}
