package com.example.nvz;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment(findViewById(R.id.isValid)))
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{
        private TextView isValid;
        public SettingsFragment(TextView isValid) {this.isValid = isValid;}
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        String url = sharedPreferences.getString(key, "");
        if (URLUtil.isValidUrl(url)) {
            isValid.setText("URL VALID");
            isValid.setTextColor(Color.parseColor("#00FF00"));
        } else {
            isValid.setText("URL INVALID");
            isValid.setTextColor(Color.parseColor("#FF0000"));
        }
    }
    }
}