package com.brijesh.restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class CountryActivity extends AppCompatActivity {
    Intent intent;
    ImageView Flagimg;
    TextView Nametxt,Capitaltxt,Regiontxt,Subregiontxt,Populationtxt,Borderstxt,Languagestxt,title;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        intent = getIntent();
        final String Flag = intent.getStringExtra("flag");
        final String Name = intent.getStringExtra("name");
        final String Capital = intent.getStringExtra("capital");
        final String Region = intent.getStringExtra("region");
        final String Subregion = intent.getStringExtra("subregion");
        final String Population = intent.getStringExtra("population");
        final String Borders = intent.getStringExtra("borders");
        final String Languages = intent.getStringExtra("languages");
        title = findViewById(R.id.title);
        Flagimg = findViewById(R.id.flag);
        Nametxt = findViewById(R.id.name);
        Capitaltxt = findViewById(R.id.capital);
        Regiontxt  = findViewById(R.id.region);
        Subregiontxt = findViewById(R.id.subregion);
        Populationtxt = findViewById(R.id.population);
        Borderstxt = findViewById(R.id.borders);
        Languagestxt = findViewById(R.id.languages);

        title.setText(Name);

        GlideToVectorYou.justLoadImage(CountryActivity.this, Uri.parse(Flag), Flagimg);

        Nametxt.setText("Name         : "+ Name);
        Capitaltxt.setText("Capital      : "+Capital);
        Regiontxt.setText("Region       : "+Region);
        Subregiontxt.setText("Subregion   : "+Subregion);
        Populationtxt.setText("Population  : "+Population);
        Borderstxt.setText("Borders    : "+Borders);
//        Languagestxt.setText("Languages : "+Languages);
    }
}