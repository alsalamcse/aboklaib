package com.aboklaib.moaadtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class addtask extends AppCompatActivity
{
    private EditText etTitle,etSub;
    private SeekBar sk1;
    private Button save2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_addtask );
        etTitle=findViewById( R.id.etTitle);
        etSub=findViewById( R.id.etSub );
        sk1=findViewById( R.id.sk1 );
        save2=findViewById( R.id.save2 );

    }
}
