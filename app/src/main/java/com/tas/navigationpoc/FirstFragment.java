package com.tas.navigationpoc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.first_fragment,container,false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("First Fragment");;

        return rootView;
    }
}
