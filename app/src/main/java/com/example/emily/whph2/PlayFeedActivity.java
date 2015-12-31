package com.example.emily.whph2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class PlayFeedActivity extends AppCompatActivity {

    private Button workbtn;
    private ImageButton btnHome;
    private Firebase firebase;
    private ImageButton btnCreateEvent;
    private ListView listView;
    private ArrayList<PlayBuddy> pbObjList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_feed);

        //home button returns to main screen
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayFeedActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //create event button allows user to create a new studying event
        btnCreateEvent = (ImageButton) findViewById(R.id.newpostbtn);
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayFeedActivity.this, NewPlayBuddyActivity.class);
                startActivity(i);
            }
        });

        //work button links to study feed
        workbtn = (Button) findViewById(R.id.workbtn);
        workbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayFeedActivity.this, StudyFeedActivity.class);
                startActivity(i);
            }
        });


        Firebase.setAndroidContext(this);
        firebase = new Firebase("https://playfeed.firebaseio.com/");

        listView = (ListView) findViewById(R.id.listView);
        pbObjList = new ArrayList<PlayBuddy>();

        PlayBuddy dummy = new PlayBuddy("","","","");
        pbObjList.add(dummy);

        final CustomAdapterPlay myAdapter = new CustomAdapterPlay(this, pbObjList);
        listView.setAdapter(myAdapter);

        pbObjList.remove(0);

        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.exists()) {
                    PlayBuddy pb = dataSnapshot.getValue(PlayBuddy.class);
                    pbObjList.add(pb);
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

    public ArrayList<PlayBuddy> getPBObjList() {
        return pbObjList;
    }

}
