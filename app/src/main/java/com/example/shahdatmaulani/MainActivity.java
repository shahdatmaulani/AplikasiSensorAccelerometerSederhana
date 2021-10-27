package com.example.shahdatmaulani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    TextView xCoor;
    TextView yCoor;
    TextView zCoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xCoor = findViewById(R.id.xcoor);
        yCoor = findViewById(R.id.ycoor);
        zCoor = findViewById(R.id.zcoor);

        sensorManager =  (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onAccuracyChanged(Sensor sensor,int accuracy){

    }

    public void onSensorChanged(SensorEvent event){

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){

            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];

            xCoor.setText("X : "+x);
            yCoor.setText("Y : "+y);
            zCoor.setText("Z : "+z);
        }
    }
}
