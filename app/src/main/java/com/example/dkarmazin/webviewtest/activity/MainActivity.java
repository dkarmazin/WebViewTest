package com.example.dkarmazin.webviewtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dkarmazin.webviewtest.fragment.FragmentNewsPager;
import com.example.dkarmazin.webviewtest.R;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentNewsPager fragmentNewsPager = FragmentNewsPager.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.newsListContainer, fragmentNewsPager).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            final Intent settingsIntent = new Intent(this.getApplicationContext(), SettingsActivity.class);
            this.startActivity(settingsIntent);
            return (true);
        }

        return super.onOptionsItemSelected(item);
    }
}
