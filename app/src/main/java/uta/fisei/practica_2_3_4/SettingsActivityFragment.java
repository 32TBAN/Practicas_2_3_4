package uta.fisei.practica_2_3_4;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;

public class SettingsActivityFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}