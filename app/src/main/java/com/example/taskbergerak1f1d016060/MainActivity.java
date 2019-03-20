package com.example.taskbergerak1f1d016060;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.Files;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int answer=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateQuestion();
    }


    public void generateQuestion()
    {
        Random rand = new Random();
        String question;
        int randA = rand.nextInt(50)+1;
        int randB = rand.nextInt(50)+1;
        int randOpt = rand.nextInt(3)+1;

        switch (randOpt)
        {
            case 1: question = Integer.toString(randA)+"+"+Integer.toString(randB);
                    answer = randA+randB;
                    break;
            case 2: question = Integer.toString(randA)+"x"+Integer.toString(randB);
                    answer = randA*randB;
                    break;
            case 3: question = Integer.toString(randA)+"/"+Integer.toString(randB);
                    answer = randA/randB;
                    break;
            default: question="";
        }
        TextView printQuestion = findViewById(R.id.questionText);
        printQuestion.setText(question);
    }
    public void checkAnswer(View view) {
        EditText answerBox = findViewById(R.id.answerBox);
        String jawaban = answerBox.getText().toString();
        if(jawaban.matches(""))
        {
            alert();
            generateQuestion();
        }
        else
        {
            TextView peringatan = findViewById(R.id.commandText);
            peringatan.setText("Masukkan hasil perhitungan di bawah dengan benar (bulatkan ke bawah)");
            int userAnswer = Integer.valueOf(answerBox.getText().toString());
            if (userAnswer==answer)
            {
                TextView printQuestion = findViewById(R.id.questionText);
                printQuestion.setText("Jawaban anda benar!");
                TextView resetButton = findViewById(R.id.submitButton);
                resetButton.setText("Coba lagi");
            }
            else
            {
                generateQuestion();
            }
        }
    }

    public void alert()
    {
        TextView peringatan = findViewById(R.id.commandText);
        peringatan.setText("Masukkan jawaban!");
    }
}
