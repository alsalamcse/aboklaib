package com.aboklaib.moaadtaskmanger.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboklaib.moaadtaskmanger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemoveFragment extends Fragment {


    public RemoveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_remove, container, false );
    }

}
