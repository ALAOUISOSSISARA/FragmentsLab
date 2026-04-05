package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2; // boutons pour changer les fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // récupérer les boutons depuis le layout
        btn1 = findViewById(R.id.btnFragment1);
        btn2 = findViewById(R.id.btnFragment2);

        // au premier lancement on affiche FragmentOne par défaut
        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne(), false);
            setTitle("Fragment One");
        }

        // clic bouton fragment 1
        btn1.setOnClickListener(v -> {
            Log.d("MainActivity", "FragmentOne sélectionné");
            replaceFragment(new FragmentOne(), true);
            setTitle("Fragment One");
        });

        // clic bouton fragment 2
        btn2.setOnClickListener(v -> {
            Log.d("MainActivity", "FragmentTwo sélectionné");
            replaceFragment(new FragmentTwo(), true);
            setTitle("Fragment Two");
        });
    }

    // méthode pour remplacer les fragments
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {

        // récupérer fragment manager
        FragmentManager fm = getSupportFragmentManager();

        // commencer transaction
        FragmentTransaction ft = fm.beginTransaction();

        // petite animation entre fragments
        ft.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
        );

        // remplacer le fragment actuel
        ft.replace(R.id.fragment_container, fragment);

        // ajouter au backstack pour bouton back
        if (addToBackStack) {
            ft.addToBackStack(null);
        }

        // appliquer transaction
        ft.commit();
    }
}