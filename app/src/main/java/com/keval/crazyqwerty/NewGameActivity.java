package com.keval.crazyqwerty;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;

import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class NewGameActivity extends AppCompatActivity {

    int highscore = 0;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        SharedPreferences sp = this.getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
        if(sp.contains("MyHighScore"))
            highscore = sp.getInt("MyHighScore", 0);

        TextView textView = (TextView) findViewById(R.id.highscore);
        textView.setText("High Score: "+highscore);


    }

    public void play_activity_main(View view) {
        Intent z = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(z);
    }
    public void play_settings(View v){
        Intent z = new Intent(getApplicationContext(),SettingsPrefActivity.class);
        startActivity(z);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
//        Toast toast = Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT);
        Toasty.info(getApplicationContext(), "Please click BACK again to exit", Toast.LENGTH_SHORT, true).show();


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

        return;
    }

}