package com.example.dkarmazin.webviewtest.activity;

import android.preference.PreferenceActivity;

import com.example.dkarmazin.webviewtest.R;

import java.util.List;

public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_headers, target);
        super.onBuildHeaders(target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }
}
