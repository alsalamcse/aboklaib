package com.aboklaib.moaadtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class signin extends AppCompatActivity {
    private EditText emsign,pssign;
    private Button signIn1,signUp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signin );

        emsign=findViewById( R.id.emSign);
        pssign=findViewById( R.id.psSign );
        signIn1=findViewById( R.id.signIn1);
        signUp1=findViewById( R.id.signUp1 );



    }

}
