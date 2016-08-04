package com.qf.yueshijia01.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.yueshijia01.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColumnFragment extends Fragment {


    public ColumnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_column, container, false);
    }

}
