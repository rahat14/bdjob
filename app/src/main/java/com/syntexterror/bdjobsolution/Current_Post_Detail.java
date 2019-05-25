package com.syntexterror.bdjobsolution;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.syntexterror.bdjobsolution.model.modelForBookMark;

public class Current_Post_Detail extends AppCompatActivity {
    TextView mTitleTv, mDetailTv;
    AdView mAdView ;
    DatabaseReference mref ;
    FirebaseAuth mauth ;
    String  uid ;
    Boolean ispressed = false ;

    String image = "null" , title , desc ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current__post__detail);
        mauth = FirebaseAuth.getInstance();
        try{
            uid = mauth.getUid();

        }
        catch (NullPointerException e ){


        }


        mref = FirebaseDatabase.getInstance().getReference("Users").child(uid).child("bookmarks");

        //advirtisement
        mAdView = findViewById(R.id.adView_current);

        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);




        //Action bar
        ActionBar actionBar = getSupportActionBar();
        //Actionbar title
        actionBar.setTitle("Post Detail");
        //set back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //initialize views
        mTitleTv = findViewById(R.id.detail_tile_current);
        mDetailTv = findViewById(R.id.detail_description_current);
        //get data from intent
         title = getIntent().getStringExtra("title");
         desc = getIntent().getStringExtra("description");
        //set data to views
        mTitleTv.setText(title);
        mDetailTv.setText(desc);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.bookmarkmenu, menu);
        MenuItem item = menu.findItem(R.id.bookmark_btn);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                if (ispressed){
                    Toast.makeText(getApplicationContext() , "You All Ready Added This", Toast.LENGTH_SHORT).show();
                }
                else  {
                    uploadPostToServer();

                }


                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    private void uploadPostToServer() {


        String ts = mref.push().getKey();

        modelForBookMark model = new modelForBookMark(title , image , desc, ts);
        mref.child(ts).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                ispressed= true ;


                Toast.makeText(getApplicationContext() , "Added To The Bookmark ", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                ispressed= false;

                Toast.makeText(getApplicationContext() , "Network Error!! Could Not Save The Data  ", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
