package com.example.guest.bogglesolitare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private TextView mResultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        mResultsView = (TextView) findViewById(R.id.resultsView);
        Intent intent = getIntent();
        ArrayList<String> answer = intent.getStringArrayListExtra("results");

        for (int i = 0; i < answer.size(); i++) {
            mResultsView.append(answer.get(i));
            mResultsView.append("\n");
        }
    }
}
