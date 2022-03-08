package com.example.w8_fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    interface FragmentOneCallBackInterface{
        void buttonClicked();
    }

    FragmentOneCallBackInterface listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one,container,false);
        TextView text = v.findViewById(R.id.textin_fragment1);
        Button button = v.findViewById(R.id.buttonin_fragment1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.buttonClicked();

            }
        });
        return v;
    }
}
