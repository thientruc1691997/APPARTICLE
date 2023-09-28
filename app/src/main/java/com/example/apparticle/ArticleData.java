package com.example.apparticle;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ArticleData extends AsyncTask<String, String, String> {

    private Context context;
    private GridView gridView;
    public static ArticleList data;

    public ArticleData(Context context, GridView gridView) {
        this.context = context;
        this.gridView = gridView;
    }
    public static Article getPhotoFromId(int id){
        for(int i=0;i<data.getArticles().size();i++)
            if(data.getArticles().get(i).getArticleId()==id)
                return data.getArticles().get(i);
        return null;

    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        StringBuilder stringBuilder = null;
        try {
    //        url = new URL("https://raw.githubusercontent.com/thanhdnh/json/main/products.json");
      //      url=new URL("https://firebasestorage.googleapis.com/v0/b/photoapp-a9387.appspot.com/o/articles.json?alt=media&token=80eae203-6516-4b90-8f40-5428f1f38068");
   //         url = new URL("http://172.28.194.189:8888//wsv/articles.json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 2. Open InputStream to connection
            conn.connect();
            InputStream in = conn.getInputStream();
            // 3. Download and decode the string response using builder
            stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();

    }

    protected void onPostExecute(String result){
        super.onPostExecute(result);
        Gson gson = new Gson();
        data=gson.fromJson(result, (Type) ArticleList.class);
        ArticleAdapter adapter = new ArticleAdapter(data.getArticles(),context);
        gridView.setAdapter(adapter);
    }

}
