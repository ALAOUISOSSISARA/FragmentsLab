package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView tvValue;
    private SeekBar seek;

    private int progress = 0; // valeur actuelle
    private static final String KEY_PROGRESS = "progress"; // clé pour sauvegarde

    public FragmentTwo() {
        super(R.layout.fragment_two); // lier layout
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // récupérer les composants
        tvValue = view.findViewById(R.id.tvValue);
        seek = view.findViewById(R.id.seekBar);

        Log.d("FragmentTwo", "FragmentTwo affiché");

        // restaurer valeur après rotation écran
        if (savedInstanceState != null) {
            progress = savedInstanceState.getInt(KEY_PROGRESS, 0);
            seek.setProgress(progress);
            tvValue.setText("Valeur : " + progress);
        }

        // écouter les changements de la seekbar
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar s, int p, boolean fromUser) {

                progress = p; // sauvegarder valeur

                // afficher valeur
                tvValue.setText("Valeur : " + p);

                // petit message selon la valeur (personnalisation simple)
                if (p < 30) {
                    tvValue.setText("Valeur : " + p + " (faible)");
                } else if (p < 70) {
                    tvValue.setText("Valeur : " + p + " (moyenne)");
                } else {
                    tvValue.setText("Valeur : " + p + " (élevée)");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar s) {
                // appelé quand l'utilisateur commence à bouger la barre
            }

            @Override
            public void onStopTrackingTouch(SeekBar s) {
                // appelé quand l'utilisateur relâche la barre
            }
        });
    }

    // sauvegarder la valeur lors rotation écran
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // enregistrer la valeur actuelle
        outState.putInt(KEY_PROGRESS, progress);
    }
}