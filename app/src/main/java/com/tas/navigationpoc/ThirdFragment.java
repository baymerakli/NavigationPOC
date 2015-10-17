package com.tas.navigationpoc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.third_fragment,container,false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("Third Fragment");;

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Toast.makeText(getActivity(),"Finger Up",Toast.LENGTH_SHORT).show();
                    return true;
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Toast.makeText(getActivity(),"Finger Down",Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
        return rootView;
    }
}
