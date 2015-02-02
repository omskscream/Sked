package com.omskscream.sked.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.omskscream.sked.R;
import com.omskscream.sked.fragments.MainFragment;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings_config:
                Intent intentSettings = new Intent(/*this, SettingsActivity.class*/);
                startActivity(intentSettings);
                return true;
            case R.id.action_settings_data:
                Intent intentData = new Intent(/*this, ClassesCalendarActivity.class*/);
                startActivity(intentData);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
