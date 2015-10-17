package com.tas.navigationpoc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    private TextView coordinateView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment,container,false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("Second Fragment");;

        coordinateView = (TextView) rootView.findViewById(R.id.coordinates);

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    String xCoordinate = String.valueOf(event.getX());
                    String yCoordinate = String.valueOf(event.getY());
                    coordinateView.setText("Finger X:"+xCoordinate+ " Y:"+yCoordinate);
                    return true;
                }
                return true; // must switch to get move events
            }
        });
        return rootView;
    }

}
