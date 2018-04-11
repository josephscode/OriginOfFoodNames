package com.example.android.originsoffoodnames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
  String user_name = "";
  int q1_result;
  int q2_result;
  int q3_result;
  int q4_result;
  int q5_result;
  int q6_result;
  int q7_result;
  int q8_result;
  int q9_result;
  int q10_result;
  ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    TextView textView;
    int totalScore=0;
    String scoreStatement;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_results);

    // Get the Intent that started this activity and extract the passed values
    Intent intent = getIntent();
    Bundle results_bundle = intent.getExtras();
    if(results_bundle != null && !results_bundle.isEmpty()){
      if(intent.hasExtra("user_name")){
        user_name = results_bundle.getString("user_name","John Doe");
      }
      if(intent.hasExtra("Q1_RESULT")){
        q1_result = results_bundle.getInt("Q1_RESULT",0);
      }
      if(intent.hasExtra("Q2_RESULT")){
        q2_result = results_bundle.getInt("Q2_RESULT",0);
      }
      if(intent.hasExtra("Q3_RESULT")){
        q3_result = results_bundle.getInt("Q3_RESULT",0);
      }
      if(intent.hasExtra("Q4_RESULT")){
        q4_result = results_bundle.getInt("Q4_RESULT",0);
      }
      if(intent.hasExtra("Q5_RESULT")){
        q5_result = results_bundle.getInt("Q5_RESULT",0);
      }
      if(intent.hasExtra("Q6_RESULT")){
        q6_result = results_bundle.getInt("Q6_RESULT",0);
      }
      if(intent.hasExtra("Q7_RESULT")){
        q7_result = results_bundle.getInt("Q7_RESULT",0);
      }
      if(intent.hasExtra("Q8_RESULT")){
        q8_result = results_bundle.getInt("Q8_RESULT",0);
      }
      if(intent.hasExtra("Q9_RESULT")){
        q9_result = results_bundle.getInt("Q9_RESULT",0);
      }
      if(intent.hasExtra("Q10_RESULT")){
        q10_result = results_bundle.getInt("Q10_RESULT",0);
      }
      totalScore = q1_result + q2_result + q3_result + q4_result + q5_result + q6_result + q7_result + q8_result + q9_result + q10_result;
    }

    scoreStatement = getString(R.string.score_statement, totalScore);
    textView = findViewById(R.id.score_statement);
    textView.setText(scoreStatement);

    //Use user_name in the subtitle
    textView = findViewById(R.id.subtitle);
    textView.setText(getString(R.string.subtitle_results, user_name));

    updateResultIcons();
  }

  //Update icons for Correct / Incorrect values of questions
  public void updateResultIcons(){
    //Question1
    imageView = findViewById(R.id.q1_icon_result);
    if(q1_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question2
    imageView = findViewById(R.id.q2_icon_result);
    if(q2_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question3
    imageView = findViewById(R.id.q3_icon_result);
    if(q3_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question4
    imageView = findViewById(R.id.q4_icon_result);
    if(q4_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question5
    imageView = findViewById(R.id.q5_icon_result);
    if(q5_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question6
    imageView = findViewById(R.id.q6_icon_result);
    if(q6_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question7
    imageView = findViewById(R.id.q7_icon_result);
    if(q7_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question8
    imageView = findViewById(R.id.q8_icon_result);
    if(q8_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question9
    imageView = findViewById(R.id.q9_icon_result);
    if(q9_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }

    //Question10
    imageView = findViewById(R.id.q10_icon_result);
    if(q10_result == 1){
      imageView.setImageResource(R.drawable.correct_icon);
    }
    else{
      imageView.setImageResource(R.drawable.incorrect_icon);
    }
  }

  //Retake quiz
  public void retakeQuiz(View view){
    //Open the quiz activity
    Intent intent = new Intent(this, QuizActivity.class);
    Bundle bundle = new Bundle();
    bundle.putString("user_name", user_name);
    intent.putExtras(bundle);
    startActivity(intent);

//    CheckBox checkBox;
//    RadioGroup radioGroup;
//    EditText editText;
//
//    //Question 1
//    checkBox = this.findViewById(R.id.q1_option1);
//    checkBox.setChecked(false);
//    checkBox = findViewById(R.id.q1_option2);
//    checkBox.setChecked(false);
//    checkBox = findViewById(R.id.q1_option3);
//    checkBox.setChecked(false);
//    checkBox = findViewById(R.id.q1_option4);
//    checkBox.setChecked(false);
//
//    //Question 2
//    radioGroup = findViewById(R.id.q2_options);
//    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);
//
//    //Question 3
//    editText = findViewById(R.id.q3_answer_entry);
//    editText.setText("");
//
//    //Question 4
//    radioGroup = findViewById(R.id.q4_options);
//    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);
//
//    //Question 5
//    editText = findViewById(R.id.q5_answer_entry);
//    editText.setText("");
//
//    //Question 6
//    radioGroup = findViewById(R.id.q6_options);
//    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);
//
//    //Question 7
//    radioGroup = findViewById(R.id.q7_options);
//    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);
//
//    //Question 8
//    radioGroup = findViewById(R.id.q8_options);
//    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
//    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);
//
//    //Question 9
//    editText = findViewById(R.id.q9_answer_entry);
//    editText.setText("");
//
//    //Question 10
//    checkBox = findViewById(R.id.q10_option1);
//    checkBox.setChecked(false);
//    checkBox = findViewById(R.id.q10_option2);
//    checkBox.setChecked(false);
//    checkBox = findViewById(R.id.q10_option3);
//    checkBox.setChecked(false);
//    checkBox = findViewById(R.id.q10_option4);
//    checkBox.setChecked(false);
  }

}
