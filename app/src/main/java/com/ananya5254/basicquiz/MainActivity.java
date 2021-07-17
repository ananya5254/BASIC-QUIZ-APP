 package com.ananya5254.basicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTv,questionNumberTv;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore=0, questionAttempted=1 ,currentPos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTv=findViewById(R.id.question);
        questionNumberTv=findViewById(R.id.noofquestions);
        option1Btn=findViewById(R.id.option1);
        option2Btn=findViewById(R.id.option2);
        option3Btn=findViewById(R.id.option3);
        option4Btn=findViewById(R.id.option4);
        quizModalArrayList=new ArrayList<>();
        random=new Random();
        getQuizquestion(quizModalArrayList);
        currentPos=random.nextInt(quizModalArrayList.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDatatoViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDatatoViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDatatoViews(currentPos);
            }
        });

    }
    private void showBottomSheet()
    {
        BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(MainActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.Score));
        TextView ScoreTv=bottomSheetView.findViewById(R.id.TVScore);
        Button restartQuizBtn=bottomSheetView.findViewById(R.id.Restart);
        ScoreTv.setText("Your Score is\n"+currentScore+"/5");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt(quizModalArrayList.size());
                setDatatoViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void setDatatoViews(int currentPos)
    {
        questionNumberTv.setText("Questions Attempted:"+questionAttempted+"/5");
        if(questionAttempted==5)
        {
            showBottomSheet();
        }else {
            questionTv.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizquestion(ArrayList<QuizModal>quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("Who among the following wrote Sanskrit grammar?","Kalidasa",
                " Charak",
                "Panini",
                "Aryabhatt","Panini"));
        quizModalArrayList.add(new QuizModal(" The metal whose salts are sensitive to light is?",
                "Zinc",
                "Silver",
                "Copper",
                "Aluminum"
                ,"Silver"));
        quizModalArrayList.add(new QuizModal(" Patanjali is well known for the compilation of –",
                "Yoga Sutra",
                "Panchatantra",
                "(c) Brahma Sutra",
                "Ayurveda",
                "Yoga Sutra"));
        quizModalArrayList.add(new QuizModal(" Chambal river is a part of –",
                "Sabarmati basin",
                "Ganga basin",
                "Narmada basin",
                "Godavari basin",
                "Narmada basin"));
        quizModalArrayList.add(new QuizModal("D.D.T. was invented by?",
                "Mosley",
                "Rudolf",
                "Karl Benz",
                "Dalton","Mosley"));
    }
}