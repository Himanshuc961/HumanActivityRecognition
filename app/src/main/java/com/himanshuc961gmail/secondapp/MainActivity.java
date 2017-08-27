package com.himanshuc961gmail.secondapp;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jjoe64.graphview.GraphView ;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import mr.go.sgfilter.SGFilter;
import mr.go.sgfilter.ZeroEliminator;

public class MainActivity extends Activity implements SensorEventListener{

    private TextView xText, yText, zText,gxText,gyText,gzText,mxText,myText,mzText;
    private Button btnStart, btnStop ;
    private Sensor mySensor,mySensor2,mySensor3;
    private SensorManager SM,SM2,SM3;

    private float x = 0;
    private float y = 0;
    private float z = 0;
    private float gx = 0;
    private float gy = 0;
    private float gz = 0;
    private float mx = 0;
    private float my = 0;
    private float mz = 0;
    private double acc = 0;
    private int count = 0;
    private int localcount = 0;
    private int state = 0;

    private LineGraphSeries<DataPoint> series;

    private final int nl = 5;
    private final int nr = 5;
    private final int degree = 3;
    private SGFilter sgFilter;

    private double[] data =new double[200];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        //SM2 = (SensorManager)getSystemService(SENSOR_SERVICE);
        //SM3= (SensorManager)getSystemService(SENSOR_SERVICE);
        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensor2 = SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mySensor3 = SM.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        SM.registerListener(this, mySensor2, SensorManager.SENSOR_DELAY_NORMAL);
        SM.registerListener(this, mySensor3, SensorManager.SENSOR_DELAY_NORMAL);
        // Assign TextView
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        gxText = (TextView)findViewById(R.id.textView6);
        gyText = (TextView)findViewById(R.id.textView);
        gzText = (TextView)findViewById(R.id.textView2);
        mxText = (TextView)findViewById(R.id.textView3);
        myText = (TextView)findViewById(R.id.textView4);
        mzText = (TextView)findViewById(R.id.textView5);
        // Assign Button
       /* btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnStart.setEnabled(true);
        btnStop.setEnabled(false); */

        // Initializing Graph

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }
       if( event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
           gx = event.values[0];
           gy = event.values[1];
           gz = event.values[2];
       }
       if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mx = event.values[0];
            my = event.values[1];
            mz = event.values[2];
        }

        xText.setText("X: " + x);
        yText.setText("Y: " + y);
        zText.setText("Z: " + z);
        gxText.setText("Gx: " + gx);
        gxText.setText("Gy: " + gy);
        gxText.setText("Gz: " + gz);
        mxText.setText("Mx: " + mx);
        myText.setText("My: " + my);
        mzText.setText("Mz: " + mz);


    }


}