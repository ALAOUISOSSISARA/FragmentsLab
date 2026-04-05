package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btnHello;
    private int count = 0; // compteur de clics

    public FragmentOne() {
        super(R.layout.fragment_one); // lier directement le layout
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // récupérer les composants depuis le layout
        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        // afficher log quand fragment est chargé
        Log.d("FragmentOne", "FragmentOne affiché");

        // action quand on clique sur le bouton
        btnHello.setOnClickListener(v -> {

            count++; // incrémenter le compteur

            // changer le texte avec nombre de clics
            tv.setText("Bonjour depuis Fragment 1 \nClicks : " + count);
        });
    }
}