package com.example.android.originsoffoodnames;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
  String user_name;

  //Correct / Incorrect values of each question
  //0 = incorrect; 1 = correct
  int q1_isCorrect = 0;
  int q2_isCorrect = 0;
  int q3_isCorrect = 0;
  int q4_isCorrect = 0;
  int q5_isCorrect = 0;
  int q6_isCorrect = 0;
  int q7_isCorrect = 0;
  int q8_isCorrect = 0;
  int q9_isCorrect = 0;
  int q10_isCorrect = 0;
  int totalScore = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    TextView textView;

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz);

    // Get the Intent that started this activity and extract the user name
    Intent intent = getIntent();
    Bundle user_name_bundle = intent.getExtras();
    user_name = getString(R.string.default_user_name);
    if(user_name_bundle != null && !user_name_bundle.isEmpty()){
      if(intent.hasExtra("user_name")){
        user_name = user_name_bundle.getString("user_name",getString(R.string.default_user_name));
        if(user_name.contentEquals("")){
          user_name = getString(R.string.default_user_name);
        }
      }
    }
    else {
      user_name = getString(R.string.default_user_name);
    }

    //Set fonts for checkboxes and radio buttons
    CheckBox checkBox;
    RadioGroup radioGroup;
    EditText editText;
    Button button;

    //Question 1
    radioGroup = findViewById(R.id.q1_options);
    ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Question 2
    checkBox = findViewById(R.id.q2_option1);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    checkBox = findViewById(R.id.q2_option2);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    checkBox = findViewById(R.id.q2_option3);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    checkBox = findViewById(R.id.q2_option4);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Question 4
    radioGroup = findViewById(R.id.q4_options);
    ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Question 6
    radioGroup = findViewById(R.id.q6_options);
    ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Question 7
    radioGroup = findViewById(R.id.q7_options);
    ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Question 8
    radioGroup = findViewById(R.id.q8_options);
    ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Question 10
    checkBox = findViewById(R.id.q10_option1);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    checkBox = findViewById(R.id.q10_option2);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    checkBox = findViewById(R.id.q10_option3);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    checkBox = findViewById(R.id.q10_option4);
    checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Buttons
    button = findViewById(R.id.check_score);
    button.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

    //Use user_name in the subtitle
    textView = findViewById(R.id.subtitle);
    textView.setText(getString(R.string.subtitle_quiz, user_name));

    // If we have a saved state from rotation then we can restore it now
    if (savedInstanceState != null) {
      //Get saved values
      //Question 1
      if(savedInstanceState.getInt("current_q1") != -1){
        radioGroup = findViewById(R.id.q1_options);
        ((RadioButton) radioGroup.getChildAt(savedInstanceState.getInt("current_q2"))).setChecked(true);
        ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      }

      //Question 2
      checkBox = findViewById(R.id.q2_option1);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q2_option1"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      checkBox = findViewById(R.id.q2_option2);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q2_option2"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      checkBox = findViewById(R.id.q2_option3);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q2_option3"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      checkBox = findViewById(R.id.q2_option4);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q2_option4"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));

      //Question 3
      editText = findViewById(R.id.q3_answer_entry);
      editText.setText(savedInstanceState.getString("current_q3"));

      //Question 4
      if(savedInstanceState.getInt("current_q4") != -1){
        radioGroup = findViewById(R.id.q4_options);
        ((RadioButton) radioGroup.getChildAt(savedInstanceState.getInt("current_q4"))).setChecked(true);
        ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      }

      //Question 5
      editText = findViewById(R.id.q5_answer_entry);
      editText.setText(savedInstanceState.getString("current_q5"));

      //Question 6
      if(savedInstanceState.getInt("current_q6") != -1){
        radioGroup = findViewById(R.id.q6_options);
        ((RadioButton) radioGroup.getChildAt(savedInstanceState.getInt("current_q6"))).setChecked(true);
        ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      }

      //Question 7
      if(savedInstanceState.getInt("current_q7") != -1){
        radioGroup = findViewById(R.id.q7_options);
        ((RadioButton) radioGroup.getChildAt(savedInstanceState.getInt("current_q7"))).setChecked(true);
        ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      }

      //Question 8
      if(savedInstanceState.getInt("current_q8") != -1){
        radioGroup = findViewById(R.id.q8_options);
        ((RadioButton) radioGroup.getChildAt(savedInstanceState.getInt("current_q8"))).setChecked(true);
        ((RadioButton) radioGroup.getChildAt(0)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(1)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(2)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
        ((RadioButton) radioGroup.getChildAt(3)).setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      }

      //Question 9
      editText = findViewById(R.id.q9_answer_entry);
      editText.setText(savedInstanceState.getString("current_q9"));

      //Question 10
      checkBox = findViewById(R.id.q10_option1);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q10_option1"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      checkBox = findViewById(R.id.q10_option2);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q10_option2"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      checkBox = findViewById(R.id.q10_option3);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q10_option3"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
      checkBox = findViewById(R.id.q10_option4);
      checkBox.setChecked(savedInstanceState.getBoolean("current_q10_option4"));
      checkBox.setTypeface(ResourcesCompat.getFont(this, R.font.volkhov_bold));
    }

    //Hide keyboard
    this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

  }

  //Save instance state upon rotation
  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // Make sure to call the super method so that the states of our views are saved
    super.onSaveInstanceState(outState);
    // Upon rotation, save the state now
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editText;

    //Question 1
    radioGroup = findViewById(R.id.q1_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    outState.putInt("current_q1", radioGroup.indexOfChild(radioButton));

    //Question 2
    checkBox = findViewById(R.id.q2_option1);
    outState.putBoolean("current_q2_option1", checkBox.isChecked());
    checkBox = findViewById(R.id.q2_option2);
    outState.putBoolean("current_q2_option2", checkBox.isChecked());
    checkBox = findViewById(R.id.q2_option3);
    outState.putBoolean("current_q2_option3", checkBox.isChecked());
    checkBox = findViewById(R.id.q2_option4);
    outState.putBoolean("current_q2_option4", checkBox.isChecked());

    //Question 3
    editText = findViewById(R.id.q3_answer_entry);
    outState.putString("current_q3", editText.getText().toString());

    //Question 4
    radioGroup = findViewById(R.id.q4_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    outState.putInt("current_q4", radioGroup.indexOfChild(radioButton));

    //Question 5
    editText = findViewById(R.id.q5_answer_entry);
    outState.putString("current_q5", editText.getText().toString());

    //Question 6
    radioGroup = findViewById(R.id.q6_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    outState.putInt("current_q6", radioGroup.indexOfChild(radioButton));

    //Question 7
    radioGroup = findViewById(R.id.q7_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    outState.putInt("current_q7", radioGroup.indexOfChild(radioButton));

    //Question 8
    radioGroup = findViewById(R.id.q8_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    outState.putInt("current_q8", radioGroup.indexOfChild(radioButton));

    //Question 9
    editText = findViewById(R.id.q9_answer_entry);
    outState.putString("current_q9", editText.getText().toString());

    //Question 10
    checkBox = findViewById(R.id.q10_option1);
    outState.putBoolean("current_q10_option1", checkBox.isChecked());
    checkBox = findViewById(R.id.q10_option2);
    outState.putBoolean("current_q10_option2", checkBox.isChecked());
    checkBox = findViewById(R.id.q10_option3);
    outState.putBoolean("current_q10_option3", checkBox.isChecked());
    checkBox = findViewById(R.id.q10_option4);
    outState.putBoolean("current_q10_option4", checkBox.isChecked());

  }

  //Check Score
  public void checkScore(View view) {
    //Check results
    checkResults();

    totalScore = q1_isCorrect + q2_isCorrect + q3_isCorrect + q4_isCorrect + q5_isCorrect + q6_isCorrect + q7_isCorrect + q8_isCorrect
        + q9_isCorrect + q10_isCorrect;

    String additionalMessage = "";

    if(totalScore == 10){
      additionalMessage = getString(R.string.score_statement_10outof10);
    }
    else if(totalScore > 5) {
      additionalMessage = getString(R.string.score_statement_greaterthan5);
    }

    if(!additionalMessage.isEmpty()){
      Toast.makeText(this,additionalMessage + "\n" + getString(R.string.score_statement, totalScore),Toast.LENGTH_LONG).show();
    }
    else{
      Toast.makeText(this,getString(R.string.score_statement, totalScore),Toast.LENGTH_LONG).show();
    }
  }

  //View Detailed Results
  public void viewResults(View view){
    //Check results
    checkResults();

    //Open the results activity
    Intent intent = new Intent(this, ResultsActivity.class);
    Bundle bundle = new Bundle();
    bundle.putString("user_name", user_name);
    bundle.putInt("Q1_RESULT", q1_isCorrect);
    bundle.putInt("Q2_RESULT", q2_isCorrect);
    bundle.putInt("Q3_RESULT", q3_isCorrect);
    bundle.putInt("Q4_RESULT", q4_isCorrect);
    bundle.putInt("Q5_RESULT", q5_isCorrect);
    bundle.putInt("Q6_RESULT", q6_isCorrect);
    bundle.putInt("Q7_RESULT", q7_isCorrect);
    bundle.putInt("Q8_RESULT", q8_isCorrect);
    bundle.putInt("Q9_RESULT", q9_isCorrect);
    bundle.putInt("Q10_RESULT", q10_isCorrect);
    intent.putExtras(bundle);
    startActivity(intent);
  }

  //Check the results
  public void checkResults() {
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    //Question 1
    radioGroup = findViewById(R.id.q1_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    if(radioGroup.indexOfChild(radioButton) == 1){
      q1_isCorrect = 1;
    }
    else {
      q1_isCorrect = 0;
    }

    //Question 2
    checkBox1 = findViewById(R.id.q2_option1);
    checkBox2 = findViewById(R.id.q2_option2);
    checkBox3 = findViewById(R.id.q2_option3);
    checkBox4 = findViewById(R.id.q2_option4);

    if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()){
      q2_isCorrect = 1;
    }
    else {
      q2_isCorrect = 0;
    }

    //Question 3
    textView = findViewById(R.id.q3_answer_entry);

    if(String.valueOf(textView.getText()).toUpperCase().contentEquals("GREEK")){
      q3_isCorrect = 1;
    }
    else {
      q3_isCorrect = 0;
    }

    //Question 4
    radioGroup = findViewById(R.id.q4_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    if(radioGroup.indexOfChild(radioButton) == 1){
      q4_isCorrect = 1;
    }
    else {
      q4_isCorrect = 0;
    }

    //Question 5
    textView = findViewById(R.id.q5_answer_entry);

    if(String.valueOf(textView.getText()).toUpperCase().contentEquals("ITALIAN")){
      q5_isCorrect = 1;
    }
    else {
      q5_isCorrect = 0;
    }

    //Question 6
    radioGroup = findViewById(R.id.q6_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    if(radioGroup.indexOfChild(radioButton) == 3){
      q6_isCorrect = 1;
    }
    else {
      q6_isCorrect = 0;
    }

    //Question 7
    radioGroup = findViewById(R.id.q7_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    if(radioGroup.indexOfChild(radioButton) == 2){
      q7_isCorrect = 1;
    }
    else {
      q7_isCorrect = 0;
    }

    //Question 8
    radioGroup = findViewById(R.id.q8_options);
    radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    if(radioGroup.indexOfChild(radioButton) == 0){
      q8_isCorrect = 1;
    }
    else {
      q8_isCorrect = 0;
    }

    //Question 9
    textView = findViewById(R.id.q9_answer_entry);

    if(String.valueOf(textView.getText()).toUpperCase().contentEquals("MACADAM")){
      q9_isCorrect = 1;
    }
    else {
      q9_isCorrect = 0;
    }

    //Question 10
    checkBox1 = findViewById(R.id.q10_option1);
    checkBox2 = findViewById(R.id.q10_option2);
    checkBox3 = findViewById(R.id.q10_option3);
    checkBox4 = findViewById(R.id.q10_option4);

    if(!checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()){
      q10_isCorrect = 1;
    }
    else {
      q10_isCorrect = 0;
    }

  }

  //Reset answers
  public void resetAnswers(View view){
    CheckBox checkBox;
    RadioGroup radioGroup;
    EditText editText;

    //Question 1
    radioGroup = findViewById(R.id.q1_options);
    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);

    //Question 2
    checkBox = findViewById(R.id.q2_option1);
    checkBox.setChecked(false);
    checkBox = findViewById(R.id.q2_option2);
    checkBox.setChecked(false);
    checkBox = findViewById(R.id.q2_option3);
    checkBox.setChecked(false);
    checkBox = findViewById(R.id.q2_option4);
    checkBox.setChecked(false);

    //Question 3
    editText = findViewById(R.id.q3_answer_entry);
    editText.setText("");

    //Question 4
    radioGroup = findViewById(R.id.q4_options);
    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);

    //Question 5
    editText = findViewById(R.id.q5_answer_entry);
    editText.setText("");

    //Question 6
    radioGroup = findViewById(R.id.q6_options);
    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);

    //Question 7
    radioGroup = findViewById(R.id.q7_options);
    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);

    //Question 8
    radioGroup = findViewById(R.id.q8_options);
    ((RadioButton) radioGroup.getChildAt(0)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(1)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(2)).setChecked(false);
    ((RadioButton) radioGroup.getChildAt(3)).setChecked(false);

    //Question 9
    editText = findViewById(R.id.q9_answer_entry);
    editText.setText("");

    //Question 10
    checkBox = findViewById(R.id.q10_option1);
    checkBox.setChecked(false);
    checkBox = findViewById(R.id.q10_option2);
    checkBox.setChecked(false);
    checkBox = findViewById(R.id.q10_option3);
    checkBox.setChecked(false);
    checkBox = findViewById(R.id.q10_option4);
    checkBox.setChecked(false);
  }

}
