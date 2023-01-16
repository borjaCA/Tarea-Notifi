package com.example.tareanotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.nio.channels.Channel;

public class Notificacion extends AppCompatActivity {

    private SeekBar seekBar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() < 25) {
                    Toast toast = Toast.makeText(Notificacion.this, "ESTE TOAST TENDRIA QUE IR ABAJO", Toast.LENGTH_SHORT);
                    toast.show();

                }
                if (seekBar.getProgress() > 25) {
                    Toast toast2 = Toast.makeText(Notificacion.this, "ESTE TOAST TENDRIA QUE IR EN MEDIO", Toast.LENGTH_LONG);
                    toast2.show();
                }
                if (seekBar.getProgress() > 50) {
                    Toast toast3 = Toast.makeText(Notificacion.this, "ESTE TOAST TENDRIA QUE IR ENCIMA", Toast.LENGTH_LONG);
                    toast3.show();
                }
            }
        });
//
        EditText editText = (EditText) findViewById(R.id.EditText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });


    }
}