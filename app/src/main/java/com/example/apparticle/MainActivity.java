package com.example.apparticle;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("articles");
    ArrayList<Article> dataList;


//    private AdapterView.OnItemClickListener onitemclick = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Intent intent = new Intent(getApplicationContext(), ViewArticleActivity.class);
//            intent.putExtra("id", gridview.getAdapter().getItemId(position));
//            startActivity(intent);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = findViewById(R.id.gridview);

        dataList = new ArrayList<Article>();

        getdata();


        //gridview.setOnItemClickListener(onitemclick);
        //FirebaseApp.initializeApp(this);

    }

    private void getdata() {
        List<Article> articleList = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                articleList.clear();
                try {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        System.out.println("The read data: " + postSnapshot.getValue().toString());
                        Article article = postSnapshot.getValue(Article.class);
                        articleList.add(article);

                        // here you can access to name property like article.name

                    }
                } catch (Exception e) {
                    System.out.println("The read failed: " + e.getMessage());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });
//        final ArrayAdapter<Article> adapter = new ArrayAdapter<Article>(this, R.layout.article_disp_tpl, dataList);
//        myRef = FirebaseDatabase.getInstance().getReference();
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                dataList.add(snapshot.getValue(Article.class));
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//                dataList.remove(snapshot.getValue(Article.class));
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        gridview.setAdapter(adapter);


    }

}