package com.example.emily.whph2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView tvThanks;
    private TextView tvContact;
    private TextView tvAloke;
    private TextView tvUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //set text to caviar
        tvThanks = (TextView) findViewById(R.id.tvThanks);
        tvContact = (TextView) findViewById(R.id.tvContact);
        tvAloke = (TextView) findViewById(R.id.tvAloke);
        tvUs = (TextView) findViewById(R.id.tvUs);
        Typeface caviar = Typeface.createFromAsset(getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        tvThanks.setTypeface(caviar);
        tvContact.setTypeface(caviar);
        tvAloke.setTypeface(caviar);
        tvUs.setTypeface(caviar);


    }

}
