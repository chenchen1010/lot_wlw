package com.chen.lot_wlw;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private int[] num1 = new int[20];
    private float[] num2 = new float[20];
    private int[] num3 = new int[20];
    private int[] num4 = new int[20];
    private float[] num5 = new float[20];
    private TextView shijian;
    private TextView wendu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        shijian = (TextView) findViewById(R.id.shijian);
        wendu = (TextView) findViewById(R.id.wendu);
        final SimpleDateFormat sDateFormat2 = new SimpleDateFormat("HH:mm");




        for(int i=0;i<20;i++){
            num1[i] = (int) (100 + Math.random()*10-5);
            num2[i] = (float) (7 + Math.random()*0.6-0.3);
            String a = new DecimalFormat("###,###,###.#").format(num2[i]);
            num2[i] = Float.parseFloat(a);
            num3[i] = (int) (40 + Math.random()*10-5);
            num4[i] = (int) (8 + Math.random()*4-2);
         //   num5[i] = (float) (15 + Math.random()*1-0.5);
            num5[i] = (float) (25);
            String b = new DecimalFormat("###,###,###.#").format(num5[i]);
            num5[i] = Float.parseFloat(b);
        }

        //静止版本
        String time = sDateFormat2.format(new java.util.Date());
        shijian.setText("时间 "+time);
        wendu.setText("温度 25 ℃ ");
        //延迟3s再执行显示
        new Thread(new Runnable()
        {
            public void run()
            {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        final Handler mHandler = new Handler();
        Runnable r = new Runnable() {
            int j = 0;
            @Override
            public void run() {
                //do something
//                String time = sDateFormat2.format(new java.util.Date());
//                shijian.setText("时间 "+time);
//                wendu.setText("温度 "+num5[j]);
//                tv1.setText(""+num1[j]);
//                tv2.setText(""+num2[j]);
//                tv3.setText(""+num3[j]);
//                tv4.setText(""+num4[j]);
                j++;
                if(j==20)
                    j = 0;
                //每隔1s循环执行run方法
                mHandler.postDelayed(this, 1000);
            }
        };

        mHandler.postDelayed(r, 10000);//延时100毫秒
    }
}
