package com.corporation.cristhian.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    LinearLayout linear;
    SensorManager sm;
    Sensor sensor;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear=(LinearLayout)findViewById(R.id.linear);
        txt=(TextView)findViewById(R.id.texto);

        /*creamos el sensor manager*/
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

}

    @Override
    public void onSensorChanged(SensorEvent event) {
        String texto=String.valueOf(event.values[0]);
        txt.setText(texto);
        float valor=Float.parseFloat(texto);

        if(valor == 0){
            linear.setBackgroundColor(Color.CYAN);
        }else{
            linear.setBackgroundColor(Color.GRAY);
            }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
