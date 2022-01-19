package com.gwabs.martialart.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gwabs.martialart.R;

public class NewMartialArtActivity extends AppCompatActivity {

    public static final String KEY = "fevMa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_martial_art);

        EditText edtMartialArt = findViewById(R.id.editMartialArt);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            // new intent
            Intent getBackIntent = new Intent();
            if (TextUtils.isEmpty(edtMartialArt.getText().toString())) {
                edtMartialArt.setError("no empty");
                setResult(RESULT_CANCELED, getBackIntent);
            } else {

                // sending data to an activity
                String favMa = edtMartialArt.getText().toString();
                getBackIntent.putExtra(KEY, favMa);
                setResult(RESULT_OK, getBackIntent);
            }
            finish();
        });
    }
}