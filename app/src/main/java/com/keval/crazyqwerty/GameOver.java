package com.keval.crazyqwerty;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        SharedPreferences sp = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
        int hs = sp.getInt("MyHighScore", 0);

        SharedPreferences sp2 = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
        int ms = sp2.getInt("myScore", 0);

        TextView yourscoretext = (TextView) findViewById(R.id.yourscoretext);
        yourscoretext.setText("High Score: " + String.valueOf(hs));

        TextView myScore = (TextView) findViewById(R.id.myScore);
        myScore.setText("Your Score: " + String.valueOf(ms));

//        SharedPreferences sp3 = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
//        Set<String> wordData = new HashSet<String>(sp.getStringSet("WordsLister", new HashSet<String>()));
//        Set<String> meaningData = new HashSet<String>(sp.getStringSet("MeaningLister", new HashSet<String>()));



    }

    public void play_activity_main(View view) {
        Intent z = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(z);
    }

    public void viewWordsData(View view) {
        Intent z = new Intent(getApplicationContext(), WordsData.class);
        startActivity(z);
    }

    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed

        Intent z = new Intent(getApplicationContext(), NewGameActivity.class);
        startActivity(z);

        return;
    }
}