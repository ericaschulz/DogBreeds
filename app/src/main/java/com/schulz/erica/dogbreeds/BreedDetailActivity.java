package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BreedDetailActivity extends AppCompatActivity {

    Button back2;
    Button home;
    TextView proof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);


        back2 = (findViewById(R.id.back_button_2));
        home = (findViewById(R.id.home));
        proof = (findViewById(R.id.detail_list_proof));


        final Intent homeIntent = new Intent(this, MainActivity.class);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeIntent);

            }
        });

        final Intent backIntent = new Intent(this, BreedListActivity.class);
        back2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
            }

        });
    }
}
