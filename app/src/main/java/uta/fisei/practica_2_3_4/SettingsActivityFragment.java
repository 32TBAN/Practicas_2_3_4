package uta.fisei.practica_2_3_4;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivityFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}