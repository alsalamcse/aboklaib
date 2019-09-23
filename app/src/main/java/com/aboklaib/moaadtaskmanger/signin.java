package com.aboklaib.moaadtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

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



        signIn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }

            private void dataHandler() {
                String email=emsign.getText().toString();
                String password=pssign.getText().toString();
                boolean isok=true;
                if (email.length()<4)
                {
                    if (email.indexOf( "@")<0|| email.indexOf( ".")<0{
                    {
                        emsign.setError( ("email vrong format") );
                        isok=false;
                    }
                    if (isok) {
                        if (password.length() < 8) {
                            pssign.setError( "password length eror" );
                        }
                        public boolean isValidEmailAddress (String email)
                        {

                        }
                        private void signIn (String, email, String password)
                        {
                            FirebaseAuth auth = FirebaseAuth.getInstance();
                            auth.signInWithEmailAndPassword( email,password. );
                        }
                    }




                    //signIn(email,passw)



                }
                }};
                }
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            return m.matches();

        }

