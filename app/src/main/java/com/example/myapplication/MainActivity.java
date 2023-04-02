package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import android.widget.ProgressBar;



public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int timeInterval=10000;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.content_main);
        TextView text=findViewById(R.id.textView);
        setSupportActionBar(binding.toolbar);
        Button button4 = (Button) findViewById(R.id.button4);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        ProgressBar progressBar2 = findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4);

        progressBar.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.VISIBLE);
        progressBar3.setVisibility(View.VISIBLE);
        progressBar4.setVisibility(View.VISIBLE);



        progressBar.setProgress(satiety);
        progressBar2.setProgress(fun);
        progressBar3.setProgress(energylvl);
        progressBar4.setProgress(cleanliness);



        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                satiety-=1;
                fun-=1;
                energylvl-=1;
                cleanliness-=1; // remove the value from the variable
                progressBar.setProgress(satiety);
                progressBar2.setProgress(fun);
                progressBar3.setProgress(energylvl);
                progressBar4.setProgress(cleanliness);
                handler.postDelayed(this, timeInterval); // post the Runnable again after the time interval
            }
        };
        handler.postDelayed(runnable, timeInterval);


        button4.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick (View view){
                if (satiety == 100) {
//                    Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText("Im already full!");
                } else if (satiety < 81) {
                    // Toast.makeText(getApplicationContext(), "Mmmmmmm", Toast.LENGTH_SHORT).show();
                    text.setText("Mmmmmmm");
                    satiety += 20;
                    progressBar.setProgress(satiety);
                } else {
                    //Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText("Mmmmmmm");
                    satiety = 100;
                    progressBar.setProgress(satiety);
                }

            }
        });



        //zabawa

        Button button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick (View view){
                if (fun == 100) {
//                    Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("I dont want to play anymore!");

                } else if (fun < 81) {
                    // Toast.makeText(getApplicationContext(), "Mmmmmmm", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("Meow");
                    fun += 20;
                    energylvl-=10;
                    progressBar2.setProgress(fun);
                    progressBar4.setProgress(energylvl);
                } else {
                    //Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("Meow");
                    fun = 100;
                    energylvl-=10;
                    progressBar2.setProgress(fun);
                    progressBar4.setProgress(energylvl);
                }

            }
        });

        //mycie

        Button button6 = (Button) findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick (View view){
                if (cleanliness == 100) {
//                    Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("I'm already clean!");

                } else if (cleanliness < 81) {
                    // Toast.makeText(getApplicationContext(), "Mmmmmmm", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("Meow");
                    cleanliness += 20;
                    progressBar3.setProgress(cleanliness);
                } else {
                    //Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("Meow");
                    cleanliness = 100;
                    progressBar3.setProgress(cleanliness);
                }

            }
        });

        //spanie

        Button button7 = (Button) findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick (View view){
                if (energylvl == 100) {
//                    Toast.makeText(getApplicationContext(), "Im already full!", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("I don't want to sleep anymore");

                } else if (energylvl < 100) {
                    // Toast.makeText(getApplicationContext(), "Mmmmmmm", Toast.LENGTH_SHORT).show();
                    text.setText(Integer.toString(fun));
                    text.setText("Zzzzzz...");
                    try {
                        Thread.sleep(20000);
                        int timeInterval=5000;

                        Handler handler1 = new Handler();
                        Runnable runnable1 = new Runnable() {
                            @Override
                            public void run() {
                                if(energylvl<100) {
                                    energylvl += 1;
                                    progressBar4.setProgress(energylvl);
                                }
                                handler1.postDelayed(this, timeInterval);
                            }
                        };

                    } catch (InterruptedException e) {};



                }

            }
        });
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.toolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    //zabawa

    //mycie

    //spanie

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    int satiety = 100; //sytosc
    int energylvl = 100; //poziom energii
    int cleanliness = 100; //poziom czytosci (?)
    int fun = 100; //poziom zabawy/dobrego samopoczucia



    //domyslnie wszystkie na 100=max

    //karmienie



    //koniec karmienia

    //zabawa

    //mycie

    //spanie


}