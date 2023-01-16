package com.example.tareanotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificador;
    String CHANNEL_ID = "23";
    Button myButton ;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = findViewById(R.id.button2);
        crearNotificacion();
        Intent intent2 = new Intent(MainActivity.this, Notificacion.class);
        notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Mensaje de Alerta")
                .setContentText("NOTIFICACION")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setTicker("AVISO DE NOTIFICACION");


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent2);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);
        myButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("Esta la casilla marcada","opcion 1" + pref.getBoolean("opcion 1", false));
                Log.i("Version del Sistema Operativo", "Opcion 2" + pref.getString("opcion2", "No Asignada"));
                Log.i("Version del Windows", "opcion 3" + pref.getString("opcion3" , "No Asignada"));

            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification n = builder.build();
                builder.setFullScreenIntent(resultPendingIntent, true);
                notificador.notify(1,n);

            }
        });
    }

public void cambiarVentana(View view){
        Intent intent1 = new Intent(MainActivity.this, Preferencias.class);
        startActivity(intent1);
}
private void crearNotificacion(){

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.channel1);
            String descripcion = getString(R.string.descripcion);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(descripcion);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
}
}