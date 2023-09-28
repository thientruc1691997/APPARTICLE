package com.example.apparticle;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ViewArticleActivity extends AppCompatActivity {
    ImageView iv_detail;
    TextView tv_detail_title, tv_detail_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_article);



            iv_detail = findViewById(R.id.iv_detail);
            tv_detail_title = findViewById(R.id.tv_detail_title);
            tv_detail_description = findViewById(R.id.tv_detail_description);

            int id = (int) getIntent().getLongExtra("id", 0);
            //new DownloadImage(iv_detail).execute((getPhotoFromId(id, generatePhotoData()).getSource_photo()));
            Picasso.get().load((ArticleData.getPhotoFromId(id).getArticle_image())).resize(400, 500).centerCrop().into(iv_detail);
            tv_detail_title.setText((ArticleData.getPhotoFromId(id)).getArticle_title());
            tv_detail_description.setText((ArticleData.getPhotoFromId(id)).getArticle_description());

    }

}