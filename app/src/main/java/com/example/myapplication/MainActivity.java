package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    //ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final ImageView image = new ImageView(this);
        //image = findViewById(R.id.image);
        setContentView(image);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                     bitmap = BitmapFactory.decodeStream(new URL("https://i.pinimg.com/736x/ae/5d/07/ae5d07ed7dec8c5c3e776fe8341d024a.jpg").openStream());
                } catch (Exception e) { e.printStackTrace(); }
            }
        };
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        image.setImageBitmap(bitmap);

    }
}
