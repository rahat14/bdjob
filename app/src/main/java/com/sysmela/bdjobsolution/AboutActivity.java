package com.sysmela.bdjobsolution;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;


import com.crashlytics.android.Crashlytics;



import io.fabric.sdk.android.Fabric;

public class AboutActivity extends AppCompatActivity {
    //private DrawerLayout mDrawerlayout;
    //private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this,new Crashlytics());

/*
        Element adsElement = new Element();
        adsElement.setTitle("Call Us: +880963824476");

        adsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String temp = "tel:" + "+880963824476";
                    intent.setData(Uri.parse(temp));

                    startActivity(intent);


            }
        });



        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.aboutlogo)
                .setDescription("জব সলিউশন")
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("contact.jobsolutionapp@gmail.com")
                //.addWebsite("http://metacoders.com")
                .addFacebook("jobsolutionapp")
                .addTwitter("JobSolution Twitter")
                .addPlayStore("Our Playstore")
                //.addItem(createCopyright())
                .create();
        
        setContentView(aboutPage);
*/
        /*
        mDrawerlayout = (DrawerLayout) findViewById(R.id.about_activity);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */
    }

    /*
    private Element createCopyright() {
        Element copyright = new Element();
        final String copyrightString = String.format("Copyright %d by MetaCoders", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutActivity.this, copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
    */

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        /*
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }
}
