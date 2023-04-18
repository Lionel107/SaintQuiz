package com.example.gestionprofil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestionprofil.Model.Question;
import com.example.gestionprofil.Model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView game_activity_textview_question;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3 ;
    private Button mAnswerButton4;
    private int mRemainingQuestionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mRemainingQuestionCount = 4;
        game_activity_textview_question = findViewById(R.id.game_activity_textview_question);


        mAnswerButton1 = findViewById(R.id.game_activity_button_1);
        mAnswerButton2 = findViewById(R.id.game_activity_button_2);
        mAnswerButton3 = findViewById(R.id.game_activity_button_3);
        mAnswerButton4 = findViewById(R.id.game_activity_button_4);
// Use the same listener for the four buttons.
// The view id value will be used to distinguish the button triggered
        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);


    }

    private QuestionBank ListeQuestion() {
        Question question1 = new Question(
                "Quel est le groupe d'aliments qui est une source importante de protéines?",
                Arrays.asList(
                        "Fruits",
                        "Légumes",
                        "Viandes",
                        "Pain"
                ),
                2
        );


        Question question2 = new Question(
                "Quel est l'élément nutritif que l'on trouve principalement dans les produits laitiers?",
                Arrays.asList(
                        "Protéines",
                        "Fibres",
                        "Calcium",
                        "Vitamine C"
                ),
                2
        );


        Question question3 = new Question(
                "Quel est le meilleur type de gras à consommer pour une santé optimale?",
                Arrays.asList(
                        "Graisses trans",
                        "Graisses saturées",
                        "Graisses monoinsaturées",
                        "Graisses polyinsaturées"
                ),
                2
        );


        Question question4 = new Question(
                "Quel nutriment est essentiel pour une vision saine?",
                Arrays.asList(
                        "Calcium",
                        "Vitamine C",
                        "Vitamine A",
                        "Fibres"
                ),
                2
        );


        Question question5 = new Question(
                "Quel est le groupe d'aliments qui est une source importante de glucides?",
                Arrays.asList(
                        "Viandes",
                        "Légumes",
                        "Poissons",
                        "Pâtes et pains"
                ),
                3
        );


        Question question6 = new Question(
                "Quel est l'élément nutritif que l'on trouve principalement dans les fruits et légumes?",
                Arrays.asList(
                        "Fibres",
                        "Calcium",
                        "Protéines",
                        "Vitamine C"
                ),
                0
        );


        Question question7 = new Question(
                "Quel est le meilleur type de sel à utiliser pour une santé optimale?",
                Arrays.asList(
                        "Sel iodé",
                        "Sel de mer",
                        "Sel rose de l'Himalaya",
                        "Sel noir"
                ),
                0
        );


        Question question8 = new Question(
                "Quel est le groupe d'aliments qui est une source importante de fer?",
                Arrays.asList(
                        "Fruits",
                        "Viandes",
                        "Lait et produits laitiers",
                        "Pains et pâtes"
                ),
                1
        );


        Question question9 = new Question(
                "Quel est l'élément nutritif que l'on trouve principalement dans les noix et les graines?",
                Arrays.asList(
                        "Fibres",
                        "Protéines",
                        "Vitamine C",
                        "Graisses insaturées"
                ),
                3
        );


        Question question10 = new Question(
                "Quel est le meilleur type de thé pour une santé optimale?",
                Arrays.asList(
                        "Thé vert",
                        "Thé noir",
                        "Thé à la menthe",
                        "Thé à la camomille"
                ),
                0
        );
        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10));
    }
    private void displayQuestion(final Question question) {
// Set the text for the question text view and the four buttons
        game_activity_textview_question.setText(question.getQuestion());
        mAnswerButton1.setText(question.getmChoiceList().get(0));
        mAnswerButton2.setText(question.getmChoiceList().get(1));
        mAnswerButton3.setText(question.getmChoiceList().get(2));
        mAnswerButton4.setText(question.getmChoiceList().get(3));
    }

    @Override
    public void onClick(View view) {
        int index;
        if (view == mAnswerButton1) {
            index = 0;
        } else if (view == mAnswerButton2) {
            index = 1;
        } else if (view == mAnswerButton3) {
            index = 2;
        } else if (view == mAnswerButton4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + view);
        }
        if (index == ListeQuestion().getNextQuestion().getAnswerIndex()){
            Toast.makeText(this, "Bonne réponse", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
        }

       // ListeQuestion().getNextQuestion();

    }

}