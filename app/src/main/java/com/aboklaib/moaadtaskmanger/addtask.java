package com.aboklaib.moaadtaskmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.aboklaib.moaadtaskmanger.data.MyUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        save2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }

            private void dataHandler() {
                boolean isok=true;
                String Title=etTitle.getText().toString();
                String Subject=etSub.getText().toString();
                int priority=sk1.getProgress();
                if (Title.length()==0)
                {
                    etTitle.setError( "Enter Title" );
                    isok=false;
                }
                if (Subject.length()==0)
                {
                    etSub.setError( "Enter Subject" );
                    isok=false;
                }
                if (isok)
                {
                    task t=new task();
                    t.setTitle(title);
                    createtask(t);
                }
            }

            private void createtask(task t)
            {
                //.1
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                //.2
                DatabaseReference reference = database.getReference();
                String key = reference.child( "tasks" ).push().getKey();
                reference.child( "tasks" ).child( key ).setValue(t);

//
            }


        } );


    }
}
