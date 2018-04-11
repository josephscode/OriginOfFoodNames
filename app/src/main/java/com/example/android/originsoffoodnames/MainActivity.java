package com.example.android.originsoffoodnames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // If we have a saved state from rotation then we can restore it now
    if (savedInstanceState != null) {
      EditText editText;

      //Get saved values
      //User name
      editText = findViewById(R.id.user_name);
      editText.setText(savedInstanceState.getString("current_user_name"));
    }
  }

  public void startQuiz(View view){
    Intent intent = new Intent(this, QuizActivity.class);
    EditText editText = findViewById(R.id.user_name);
    String message = editText.getText().toString();
    Bundle bundle = new Bundle();
    bundle.putString("user_name", message);
    intent.putExtras(bundle);
    startActivity(intent);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    // Make sure to call the super method so that the states of our views are saved
    super.onSaveInstanceState(outState);
    // Upon rotation, save the state now
    EditText editText;

    //User name
    editText = findViewById(R.id.user_name);
    outState.putString("current_user_name", editText.getText().toString());
  }

}
