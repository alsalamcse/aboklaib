package com.aboklaib.moaadtaskmanger.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aboklaib.moaadtaskmanger.R;
import com.aboklaib.moaadtaskmanger.data.TasksAdapter;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {

    private TasksAdapter tasksAdapter;
    private ListView listView;


    public AllTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasksAdapter=new TasksAdapter( getContext() );
        // Inflate the layout for this fragment
        View view= inflater.inflate( R.layout.fragment_all_tasks, container, false );
        listView=view.findViewById( R.id.lstvTasks );
        return view;
    }


    public void readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("tasks").child(uid).addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    Task t=d.getValue(Task.class);
                    Log.d( "Task",t.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );
    }

}
