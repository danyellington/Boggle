package com.example.guest.bogglesolitare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mSubmitButton;
    private Button mGuessButton;
    private EditText mUserGuess;

    public ArrayList<String> resultsList = new ArrayList<String>();


    GridView gridView;
    String[] letters = new String[] {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] vowels = new String[] {
            "A", "E", "I", "O", "U", "Y"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Caviar_Dreams_Bold.ttf");
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new BoggleAdapter(this, letters, vowels, typeface));

        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mGuessButton = (Button) findViewById(R.id.guessButton);

        mUserGuess = (EditText) findViewById(R.id.userGuess);

        mSubmitButton.setOnClickListener(this);
        mGuessButton.setOnClickListener(this);





}

    @Override
    public void onClick(View v) {

        if (v == mGuessButton) {
            String userGuess = mUserGuess.getText().toString();
            Intent intent = new Intent(String.valueOf(MainActivity.this));
            intent.putStringArrayListExtra("userGuess", resultsList);



        }
        if (v == mSubmitButton) {
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            intent.putStringArrayListExtra("results", resultsList);
            startActivity(intent);
        }
    }
}
