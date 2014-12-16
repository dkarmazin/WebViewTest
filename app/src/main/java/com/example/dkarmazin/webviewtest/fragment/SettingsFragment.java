package com.example.dkarmazin.webviewtest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.example.dkarmazin.webviewtest.R;
import com.example.dkarmazin.webviewtest.activity.SecondaryActivity;

public class SettingsFragment extends PreferenceFragment {
    private static final String HEADER_ID = "headerId", GENERAL = "general";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String headerId = getArguments().getString(HEADER_ID);

        if(headerId.equals(GENERAL)) {
            addPreferencesFromResource(R.xml.pref_general);

            findPreference("open_secondary_activity").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent secondaryActivity = new Intent(getActivity().getApplicationContext(), SecondaryActivity.class);
                    startActivity(secondaryActivity);
                    return true;
                }
            });

        }
    }
}
