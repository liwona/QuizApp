package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * Extracting player name
     *
     * @return user name
     */

    public String extractName() {
        EditText userNameEditBox = (EditText) findViewById(R.id.name_field);
        String userName = userNameEditBox.getText().toString();
        return userName;
    }

    /**
     * Figure out what user selected in Question 1
     *
     * @return points for Question 1
     */

    private int questionOneSelection() {
        // Is the button now checked?
        RadioButton button = (RadioButton) findViewById(R.id.russel_crowe);
        boolean checked = button.isChecked();
        if (checked)
            // Russel Crowe selected
            return 1;
        else
            return 0;
    }

    /**
     * Figure out what user selected in Question 2
     *
     * @return points for Question 2
     */

    private int questionTwoSelection() {
        // Is the button now checked?
        RadioButton button = (RadioButton) findViewById(R.id.hans_zimmer);
        boolean checked = button.isChecked();
        if (checked)
            // Hans Zimmer selected
            return 1;
        else
            return 0;
    }

    /**
     * Method checking which option chosen
     * @param id is id of the options
     * @return which option checked by the user
     */

    private boolean checkSelectionById(int id) {
        CheckBox checkBoxOne = (CheckBox) findViewById(id);
        boolean checked = checkBoxOne.isChecked();
        return checked;
    }

    /**
     * Figure out what user selected in Question 3
     *
     * @return points for Question 3
     */

    private int questionThreeSelection() {
        //Correct CheckBox checked?
        boolean checkedOne = checkSelectionById(R.id.blood_diamond);
        boolean checkedTwo = checkSelectionById(R.id.inception);
        boolean checkedThree = checkSelectionById(R.id.the_hateful_eight);
        boolean checkedFour = checkSelectionById(R.id.chicago);
        boolean checkedFive = checkSelectionById(R.id.savings_private_ryan);
        if (checkedOne && checkedTwo && !checkedThree && !checkedFour && !checkedFive)
            // Correct selected
            return 1;
        else
            return 0;
    }

    /**
     * Figure out what user selected in Question 4
     *
     * @return points for Question 4
     */

    private int questionFourSelection() {
        //Correct CheckBox checked?
        boolean checkedOne = checkSelectionById(R.id.titanic);
        boolean checkedTwo = checkSelectionById(R.id.avatar);
        boolean checkedThree = checkSelectionById(R.id.la_la_land);
        boolean checkedFour = checkSelectionById(R.id.the_lord_of_the_rings_3);
        boolean checkedFive = checkSelectionById(R.id.ben_hur);
        boolean checkedSix = checkSelectionById(R.id.one_flew_over);
        if (checkedOne && checkedFour && checkedFive && !checkedTwo && !checkedThree && !checkedSix)
            // Correct selected
            return 1;
        else
            return 0;
    }

    /**
     * Figure out what user selected in Question 5
     *
     * @return points for Question 5
     */

    private int questionFiveSelection() {
        // Is the button now checked?
        RadioButton button = (RadioButton) findViewById(R.id.star_wars);
        boolean checked = button.isChecked();
        if (checked)
            // Russel Crowe selected
            return 1;
        else
            return 0;
    }

    /**
     * Extracting answer to question 6 provided by the user
     *
     * @return answer to question 6
     */

    public String extractAnswer() {
        EditText answerEditBox = (EditText) findViewById(R.id.question_six);
        String answer = answerEditBox.getText().toString();
        return answer;
    }

    /**
     * Figure out if answer in Question 6 is correct
     * @param answer1 contains player's input
     * @return points for Question 6
     */

    private int questionSixSelection(String answer1) {
        if (answer1.equalsIgnoreCase("Andy Serkis"))
            return 1;
        else
            return 0;
    }

    /**
     * Figure out what user selected in Question 7
     *
     * @return points for Question 7
     */

    private int questionSevenSelection() {
        // Is the button now checked?
        RadioButton button = (RadioButton) findViewById(R.id.eddie_murphy);
        boolean checked = button.isChecked();
        if (checked)
            // Eddie Murphy selected
            return 1;
        else
            return 0;
    }

    /**
     * Figure out what user selected in Question 8
     *
     * @return points for Question 8
     */

    private int questionEightSelection() {
        // Is the button now checked?
        RadioButton button = (RadioButton) findViewById(R.id.time_of_my_life);
        boolean checked = button.isChecked();
        if (checked)
            // b.	„(I've Had) The Time of My Life” selected
            return 1;
        else
            return 0;
    }

    /**
     * Figure out what user selected in Question 9
     *
     * @return points for Question 9
     */

    private int questionNineSelection() {
        // Is the button now checked?
        RadioButton button = (RadioButton) findViewById(R.id.nine_option_4);
        boolean checked = button.isChecked();
        if (checked)
            // Number of 4 selected
            return 1;
        else
            return 0;
    }


    public void submitAnswers(View view) {
        points = questionOneSelection() + questionTwoSelection() + questionThreeSelection() + questionFourSelection() + questionFiveSelection() + questionSixSelection(extractAnswer()) + questionSevenSelection() + questionEightSelection() + questionNineSelection();
        String resultsMessage = extractName() + ", you've got: " + points + " points";
        if (points == 1)
            // Show result's message on toast
            Toast.makeText(this, extractName() + ", you can be better! :) \nYou've got: " + points + " point", Toast.LENGTH_SHORT ).show();
        else if (points<4)
            // Show result's message on toast
            Toast.makeText(this, extractName() + ", you can be better! \nYou've got: " + points + " points", Toast.LENGTH_SHORT ).show();
        else if (points<7)
            // Show result's message on toast
            Toast.makeText(this, "Very good, " + extractName() + "! \nYou've got: " + points + " points", Toast.LENGTH_SHORT ).show();
        else
            // Show result's message on toast
            Toast.makeText(this, "Congratulations, " + extractName() + "! \nYou've got: " + points + " points", Toast.LENGTH_SHORT ).show();
        displayResult(resultsMessage);
        intentEnd();
    }

    private void displayResult(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.quiz_result_text_view);
        orderSummaryTextView.setText(message);
    }

    private void intentEnd () {
        Intent myIntent = new Intent(HomeActivity.this, EndActivity.class);
        myIntent.putExtra("points", points); //Optional parameters
        points = 0;
        HomeActivity.this.startActivity(myIntent);


    }

    /**
     * Method unchecking RadioGroup
     * @param id is id of the questions which contain RadioGroup
     */

    private void uncheckRadioGroup(int id) {
        RadioGroup group1 = (RadioGroup) findViewById(id);
        group1.clearCheck();
    }

    private void uncheckCheckBox(int id) {
        CheckBox button = (CheckBox) findViewById(id);
        button.setChecked(false);
    }

    private void cleanEditText(int id) {
        EditText editText = (EditText) findViewById(id);
        editText.getText().clear();
    }

    public void resetButton(View view) {
        points = 0;
        uncheckRadioGroup(R.id.question_one);
        uncheckRadioGroup(R.id.question_two);
        uncheckRadioGroup(R.id.question_five);
        uncheckRadioGroup(R.id.question_seven);
        uncheckRadioGroup(R.id.question_eight);
        uncheckRadioGroup(R.id.question_nine);
        uncheckCheckBox(R.id.blood_diamond);
        uncheckCheckBox(R.id.chicago);
        uncheckCheckBox(R.id.savings_private_ryan);
        uncheckCheckBox(R.id.inception);
        uncheckCheckBox(R.id.the_hateful_eight);
        uncheckCheckBox(R.id.titanic);
        uncheckCheckBox(R.id.avatar);
        uncheckCheckBox(R.id.la_la_land);
        uncheckCheckBox(R.id.the_lord_of_the_rings_3);
        uncheckCheckBox(R.id.ben_hur);
        uncheckCheckBox(R.id.one_flew_over);
        cleanEditText(R.id.name_field);
        cleanEditText(R.id.question_six);
        displayResult("");
    }

}
