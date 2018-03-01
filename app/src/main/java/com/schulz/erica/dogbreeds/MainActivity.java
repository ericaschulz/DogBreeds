package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Toolbar toolbar = findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                final Intent intent = new Intent(MainActivity.this, BreedListActivity.class);
                final Intent imageIntent = new Intent(MainActivity.this, BreedImageActivity.class);

                Button seeBreedImage =findViewById(R.id.see_breed_images);
                Button seeBreeds = findViewById(R.id.see_breeds);



                seeBreeds.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(intent);
                    }
                });


                seeBreedImage.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        startActivity(imageIntent);

                    }
                });


        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                        return true;
                }


                return super.onOptionsItemSelected(item);

        }
}































