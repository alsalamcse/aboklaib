package com.aboklaib.moaadtaskmanger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.oob.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

    public void dattaHandler()
    {
        boolean isok=true;//if all the fields filled well
        String email=em2.getText().toString();
        String passw1=pass2.getText().toString();
        String passw2=rewarte.getText().toString();
        String fname1=fname.getText().toString();
        String lname1=Lname.getText().toString();
        String btnsave1=save1.getText().toString();
        if(email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            em2.setError( "Wrong Email" );
            isok = false;
        }
        if (passw2.length()<8 ||  passw1.equals( passw2 )==false){
            pass2.setError( "have to at least 8 char and the same password" );
            rewarte.setError( "have to be at least 8 char and the same password" );
            isok=false;
    }
    if (fname1.length()==0)
    {
        fname.setError( "enter name" );
        isok=false;

    }
    if (isok)
    {
        createAcount(email,passw1,fname1,lname1,phone);

    }

    }

    private void createAcount(String email, String passw1, String fname1, String lname1, EditText phone) {
     FirebaseAuth auth = FirebaseAuth.getInstance();
        Task<AuthResult> authResultTask = auth.createUserWithEmailAndPassword( email, passw1 ).addOnCompleteListener( this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText( signup.this, "sign up Successful", Toast.LENGTH_SHORT ).show();
                    finish();
                } else {
                    em2.setError( "sign up failed" );
                }

            }
        } );
    }
}

