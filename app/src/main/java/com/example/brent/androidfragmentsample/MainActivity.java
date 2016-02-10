package com.example.brent.androidfragmentsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import layout.InputFragment;
import layout.InputFragmentListener;
import layout.OutputFragment;

public class MainActivity extends AppCompatActivity
    implements InputFragmentListener {

    private final String TAG = this.getClass().getName();
    private final String INPUT_FRAGMENT = "INPUT_FRAGMENT";
    private final String OUTPUT_FRAGMENT = "OUTPUT_FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreateView()");
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, InputFragment.newInstance(), INPUT_FRAGMENT)
                    .add(R.id.fragmentContainer, OutputFragment.newInstance(), OUTPUT_FRAGMENT)
                    .commit();
        }
    }

    @Override
    public void onUpdateText(String output) {
        Log.d(TAG, "onUpdateText(): " + output);
        ((OutputFragment)getFragmentManager().findFragmentByTag(OUTPUT_FRAGMENT))
                .setOutputText(output);
    }
}
