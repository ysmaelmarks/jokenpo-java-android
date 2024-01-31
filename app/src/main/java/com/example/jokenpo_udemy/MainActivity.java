package com.example.jokenpo_udemy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectRock(View view){
        result("rock");
    }
    public void selectPaper(View view){
        result("paper");
    }
    public void selectScissor(View view){
        result("scissor");
    }

    private String createAppChoice() {
        String[] options = {"rock", "paper", "scissor"};
        int number = new Random().nextInt(3);

        ImageView imageApp = findViewById(R.id.image_app);
        String appChoice = options[number];
        switch(appChoice){
            case "rock" :
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case  "paper":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "scissor":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return appChoice;
    }

    public void result (String playerChoice){
        String appChoice = createAppChoice();
        TextView textResult = findViewById(R.id.text_result);

        if(
            (appChoice == "rock" && playerChoice == "scissor") ||
            (appChoice == "paper" && playerChoice == "rock") ||
            (appChoice == "scissor" && playerChoice == "paper")
        ){
            textResult.setText("You lose");
        }else if((playerChoice == "rock" && appChoice == "scissor") ||
                (playerChoice == "paper" && appChoice == "rock") ||
                (playerChoice == "scissor" && appChoice == "paper")){
            textResult.setText("You win");
        }
        else{
            textResult.setText("Draw");
        }
    }




}