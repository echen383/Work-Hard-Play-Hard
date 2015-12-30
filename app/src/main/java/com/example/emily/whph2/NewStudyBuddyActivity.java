package com.example.emily.whph2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class NewStudyBuddyActivity extends AppCompatActivity {

    private Firebase firebase;
    private StudyBuddy studyBuddy;
    private EditText nameText;
    private EditText locText;
    private EditText timeText;
    private EditText subText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_study_buddy);

        Firebase.setAndroidContext(this);
        firebase = new Firebase("https://sizzling-torch-3755.firebaseio.com/");

        //Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Helvetica.dfont");
        TextView titleText = (TextView) findViewById(R.id.tvPrompt);
        //titleText.setTypeface(myTypeface);
        nameText = (EditText) findViewById(R.id.etName);
        //nameText.setTypeface(myTypeface);
        locText = (EditText) findViewById(R.id.etLocation);
        //locText.setTypeface(myTypeface);
        timeText = (EditText) findViewById(R.id.etTime);
        //timeText.setTypeface(myTypeface);
        subText = (EditText) findViewById(R.id.etSubject);
        //subText.setTypeface(myTypeface);
        TextView enterText = (TextView) findViewById(R.id.btnSubmit);
        //enterText.setTypeface(myTypeface);

        Button submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                studyBuddy = new StudyBuddy("", "", "", "");

                studyBuddy.setName(nameText.getText().toString());
                studyBuddy.setLocation(locText.getText().toString());
                studyBuddy.setStartTime(timeText.getText().toString());
                studyBuddy.setSubject(subText.getText().toString());

                System.out.println(studyBuddy.getName());
                System.out.println(studyBuddy.getLocation());
                System.out.println(studyBuddy.getStartTime());
                System.out.println(studyBuddy.getSubject());

                firebase.push().setValue(studyBuddy);

                Intent i = new Intent(NewStudyBuddyActivity.this, com.example.emily.whph2.StudyFeedActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

