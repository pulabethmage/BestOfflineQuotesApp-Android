package com.rcustodio.bestofflinequotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rcustodio.bestofflinequotes.lovequotes.LoveQuotes01Activity;

public class DashboardHomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_home);
    }

    public void lovequotes(View v)
    {
        Intent intent = new Intent(DashboardHomeActivity.this, LoveQuotes01Activity.class);
        startActivity(intent);
    }
}
