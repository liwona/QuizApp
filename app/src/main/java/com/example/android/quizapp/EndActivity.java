package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {

    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();
        points = intent.getIntExtra("points", 0);
        displayScore();
        }

    /**
     * This method displays score.
     *
     */

    private void displayScore() {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.quiz_result_text_view);
        String message = getString(R.string.score_message) + points;
        if (points == 1)
            message += " point";
        else
            message += " points";
        orderSummaryTextView.setText(message);
    }

    /**
     * Method is allowing to send a message with the result.
     */

    public void intentShare (View view ) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String intentMessage = getString(R.string.intent_share_message_1) + points;
        if (points == 1)
            intentMessage += getString(R.string.intent_share_message_2);
        else
            intentMessage += getString(R.string.intent_share_message_3);
        sendIntent.putExtra(Intent.EXTRA_TEXT, intentMessage);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

}

