package com.aboklaib.moaadtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity
{
    private EditText fname,Lname,em2,pass2,rewarte,phone;
    private Button save1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup );

        fname=findViewById( R.id.fname );
        Lname=findViewById( R.id.Lname );
        phone=findViewById( R.id.phone );
        em2=findViewById( R.id.em2 );
        pass2=findViewById( R.id.pass2 );
        rewarte=findViewById( R.id.rewarte);
        save1=findViewById( R.id.save1 );

    }
    boolean isok=true;//if all the fields filled well
    String email=em2.getText().toString();
    String passw2=pass2.getText().toString();
    String fname1=fname.getText().toString();
    String lname1=Lname.getText().toString();
    String rewarte1=rewarte.getText().toString();
    String btnsave1=save1.getText().toString();
    if(email.length()<4 || email.indexOf('@')<0 || email.indexOF('.')<0)
    {
        em2.setError( "Wrong Email" );
        isok = false;
    }

    public String getPassw2() {

    }if ()

    }


