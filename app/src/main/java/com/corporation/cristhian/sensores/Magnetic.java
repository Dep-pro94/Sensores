package com.corporation.cristhian.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Magnetic extends AppCompatActivity implements SensorEventListener {
    TextView textView;
    Sensor sensor;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetic);

        textView=(TextView)findViewById(R.id.txtmagnetic);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
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
        textView.append("\n"+"valor de x : "+x+" μT"+"\n"+"valor de y : "+y+"μT"+"\n"+"valor de z : "+z+" μT");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
