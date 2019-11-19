package com.aboklaib.moaadtaskmanger.data;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aboklaib.moaadtaskmanger.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TasksAdapter extends ArrayAdapter<Task> {
    public TasksAdapter(@NonNull Context context) {
        super( context, R.layout.taskitem );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vitem = LayoutInflater.from( getContext() ).inflate( R.layout.taskitem, parent, false );
        TextView tvTitle = vitem.findViewById( R.id.itmTvTitle );
        TextView tvSubject = vitem.findViewById( R.id.itmTvSubject );
        RatingBar rbPrio = vitem.findViewById( R.id.itmRatingPrio );
        CheckBox cbIsCompleted = vitem.findViewById( R.id.itemChbxIsCompleted );
        ImageView itmImgInfo = vitem.findViewById( R.id.itmImgInfo );

        final Task myTask = getItem( position );//getting data source

        //todo טיפול באירוע מחיקה
        cbIsCompleted.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //todo delete this item
                    FirebaseUtils.getRefrence().child( myTask.getKey() ).removeValue( new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null) {

                                Toast.makeText( getContext(), "delted", Toast.LENGTH_SHORT ).show();


                            } else {
                                Toast.makeText( getContext(), "not deleted" + databaseError.getMessage(), Toast.LENGTH_SHORT ).show();

                            }
                        }
                    } );
                }
            }
        } );

        itmImgInfo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getContext(), myTask.getTitle(), Toast.LENGTH_SHORT ).show();
                showmenu();
            }
        } );


//connect item view to data source
        tvTitle.setText( myTask.getTitle() );
        tvSubject.setText( myTask.getSub() );
        rbPrio.setRating( myTask.getPrio() );
        cbIsCompleted.setChecked( false );

        return vitem;

    }

    public void showmenu()
    {
        final String[] option = {"Add", "View", "Select", "Delete"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getContext(), android.R.layout.select_dialog_item );
        adapter.addAll( option );

        AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
        builder.setTitle( "Select option" );
        builder.setAdapter( adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0){

                Toast.makeText( getContext(), "Add", Toast.LENGTH_SHORT ).show();}

            if(i==1)
            {
                Toast.makeText( getContext(), "View", Toast.LENGTH_SHORT ).show();



            }
            if(i==2){
                Toast.makeText( getContext(), "Select", Toast.LENGTH_SHORT ).show();

            }
            if(i==3)
            {
                Toast.makeText( getContext(), "Delete", Toast.LENGTH_SHORT ).show();
            }
        } );
        final AlertDialog a = builder.create();
        a.show();



    }



}

