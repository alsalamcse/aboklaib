package com.aboklaib.moaadtaskmanger.data;

import android.content.Context;
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

import com.aboklaib.moaadtaskmanger.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TasksAdapter extends ArrayAdapter<Task>
{
    public TasksAdapter(@NonNull Context context) {
        super( context, R.layout.taskitem );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,false);
        TextView tvTitle=vitem.findViewById(R.id.itmTvTitle);
        TextView tvSubject=vitem.findViewById(R.id.itmTvSubject);
        RatingBar rbPrio=vitem.findViewById(R.id.itmRatingPrio);
        CheckBox cbIsCompleted=vitem.findViewById(R.id.itemChbxIsCompleted);
        ImageView ivInfo=vitem.findViewById(R.id.itmImgInfo);

       final Task myTask = getItem(position);//getting data source

        //todo טיפול באירוע מחיקה
        cbIsCompleted.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked)
                 {
                     //todo delete this item
                     FirebaseUtils.getRefrence().child(myTask.getKey()).removeValue( new DatabaseReference.CompletionListener() {
                         @Override
                         public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                         }
                     } );
                 }
            }
        } );
//connect item view to data source
        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSub());
        rbPrio.setRating(myTask.getPrio());
        cbIsCompleted.setChecked(false);

        return vitem;



    }
}


