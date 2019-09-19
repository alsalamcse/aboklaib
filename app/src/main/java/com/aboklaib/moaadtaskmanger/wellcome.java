package com.aboklaib.moaadtaskmanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class wellcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_wellcome );

        Thread th=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent i=new Intent(getApplication(),signin.class);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        };
        th.start();
    }
}
