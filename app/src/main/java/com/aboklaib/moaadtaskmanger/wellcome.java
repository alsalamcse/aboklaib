package com.aboklaib.moaadtaskmanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class wellcome extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    sleep( 3000 );
                    FirebaseAuth auth = FirebaseAuth.getInstance();

                    if (auth.getCurrentUser() == null || auth.getCurrentUser().getEmail() == null) {
                        Intent i = new Intent( getApplication(), signin.class );
                        startActivity( i );
                        finish();
                    } else {
                        Intent i = new Intent( getApplication(), MainAllTasksActivity.class );
                        startActivity( i );
                        finish();
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        };
        th.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_wellcome );
    }
}
