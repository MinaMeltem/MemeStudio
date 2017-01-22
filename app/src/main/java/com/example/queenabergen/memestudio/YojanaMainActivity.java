package com.example.queenabergen.memestudio;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class YojanaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yojana_activity_main);
//        dispatchTakePictureIntent();

        beginFragment();

    }

    private void beginFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new YojanaFragment());
        fragmentTransaction.commit();
    }

    }




