package com.corporation.cristhian.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Acelerometro extends AppCompatActivity implements SensorEventListener{

    TextView textView;
    SensorManager sm;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        textView=(TextView)findViewById(R.id.txtacelerometro);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sm.getDefaultSensor(sensor.TYPE_ACCELEROMETER);



    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
