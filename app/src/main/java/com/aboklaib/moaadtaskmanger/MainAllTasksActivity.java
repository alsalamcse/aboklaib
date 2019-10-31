package com.aboklaib.moaadtaskmanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aboklaib.moaadtaskmanger.ui.main.MyfragmentsPagerAdapter;

public class MainAllTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_all_tasks );
        MyfragmentsPagerAdapter sectionsPagerAdapter = new MyfragmentsPagerAdapter( this, getSupportFragmentManager() );
        ViewPager viewPager = findViewById( R.id.view_pager );
        viewPager.setAdapter( sectionsPagerAdapter );
        TabLayout tabs = findViewById( R.id.tabs );
        tabs.setupWithViewPager( viewPager );
        FloatingActionButton fab = findViewById( R.id.fab );

        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
                Intent i=new Intent( MainAllTasksActivity.this,addtask.class);
                startActivity( i );
            }
        } );
    }
}