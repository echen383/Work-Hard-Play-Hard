package com.example.emily.whph2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class StudyFeedActivity extends AppCompatActivity {

    private ImageButton btnHome;
    private Firebase firebase;
    private ImageButton btnCreateEvent;
    private ListView listView;
    private ArrayList<StudyBuddy> sbObjList;
    private StudyBuddy studyBuddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_feed);

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudyFeedActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnCreateEvent = (ImageButton) findViewById(R.id.newpostbtn);
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudyFeedActivity.this, NewStudyBuddyActivity.class);
                startActivity(i);
            }
        });


        Firebase.setAndroidContext(this);

        firebase = new Firebase("https://sizzling-torch-3755.firebaseio.com/");
        listView = (ListView) findViewById(R.id.listView);
        sbObjList = new ArrayList<StudyBuddy>();

        StudyBuddy dummy = new StudyBuddy("","","","");
        sbObjList.add(dummy);

        final CustomAdapter myAdapter = new CustomAdapter(this, sbObjList);
        listView.setAdapter(myAdapter);

        sbObjList.remove(0);

        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.exists()) {
                    StudyBuddy sb = dataSnapshot.getValue(StudyBuddy.class);
                    sbObjList.add(sb);
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("Error: " + firebaseError.getMessage());
            }
        });

    }

    public ArrayList<StudyBuddy> getSBObjList() {
        return sbObjList;
    }

}
