package com.corporation.cristhian.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Giroscopio extends AppCompatActivity implements SensorEventListener {

    TextView textView;
    SensorManager sm;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giroscopio);

        textView=(TextView)findViewById(R.id.txtgiroscopio);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        /*variables para mostrar los valores que me da el sensor*/
        float x,y,z;
        x=event.values[0];
        y=event.values[1];
        z=event.values[2];
        /*muestro los valores*/
        textView.append("\n"+"valor de x : "+x+" /S"+"\n"+"valor de y : "+y+"/S"+"\n"+"valor de z : "+z+" /S");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /*aqui detengo los valores del acelerometro para optimizar la app*/
    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }
}
