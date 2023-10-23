package uta.fisei.practica_2_3_4;

import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.Set;

public class PreferenceChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Practica4 practica4;

    public PreferenceChangeListener(Practica4 practica4) {
        this.practica4 = practica4;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.practica4.setPreferencesChanged(true);

        if (key.equals(this.practica4.getREGIONS())) {
            this.practica4.getQuizViewModel().setGuessRows(sharedPreferences.getString(
                    Practica4.CHOICES, null));
            this.practica4.getQuizFragment().resetQuiz();
        } else if (key.equals(this.practica4.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.practica4.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.practica4.getQuizViewModel().setRegionsSet(regions);
                this.practica4.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.practica4.getString(R.string.default_region));
                editor.putStringSet(this.practica4.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.practica4, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.practica4, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
