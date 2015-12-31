package com.example.emily.whph2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView WHPH;
    private TextView PYP;
    private ImageButton btnInfo;
    private ImageButton btnPencil;
    private ImageButton btnCup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set font to caviar
        WHPH = (TextView) findViewById(R.id.tvWHPH);
        PYP = (TextView) findViewById(R.id.tvPYP);
        Typeface caviar = Typeface.createFromAsset(getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        WHPH.setTypeface(caviar);
        PYP.setTypeface(caviar);

        //link info button to info screen
        btnInfo = (ImageButton) findViewById(R.id.infobtn);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });

        //link pencil/cup buttons to work/play feeds
        btnPencil = (ImageButton) findViewById(R.id.btnPencil);
        btnCup = (ImageButton) findViewById(R.id.btnCup);
        btnPencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StudyFeedActivity.class);
                startActivity(i);
            }
        });
        btnCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayFeedActivity.class);
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
