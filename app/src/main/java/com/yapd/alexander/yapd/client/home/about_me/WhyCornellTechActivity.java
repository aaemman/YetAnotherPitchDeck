package com.yapd.alexander.yapd.client.home.about_me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yapd.alexander.yapd.R;

public class WhyCornellTechActivity extends AppCompatActivity {

    public static final int LAYOUT = R.layout.activity_why_cornell_tech;

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, WhyCornellTechActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
    }
}
