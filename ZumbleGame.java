package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ZumbleGame extends AppCompatActivity {
    TextView tv_info,tv_word;
    EditText et_guess;
    Random r;
    String currentWord;
    Button b_check,b_new;
    String[] dictionary = {
            "one","two","three","four","five","six","seven","eight","nine","ten"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zumble_game);
        tv_info = findViewById(R.id.tv_info);
        tv_word = findViewById(R.id.tv_word);
        et_guess = findViewById(R.id.et_guess);
        b_check = findViewById(R.id.b_check);
        b_new = findViewById(R.id.b_new);
        r = new Random();
        newGame();
        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(et_guess.getText().toString().equalsIgnoreCase(currentWord))
               {
                   tv_info.setText("excellent");
                   b_check.setEnabled(false);
                   b_new.setEnabled(true);
               }
               else
               {
                   tv_info.setText("try Again!");
               }
            }
        });
        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });
    }
        private String shuffleWord(String word)
        {
            List<String> letters = Arrays.asList(word.split(""));
            Collections.shuffle(letters);
            String shuffled = "";
            for(String letter : letters)
            {
                shuffled+= letter;
            }
            return shuffled;

        }
        private  void newGame()
        {
            currentWord = dictionary[r.nextInt(dictionary.length)];
            tv_word.setText(shuffleWord(currentWord));
            et_guess.setText("");
            b_new.setEnabled(false);
            b_check.setEnabled(true);

        }
}
