package com.example.w8_fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;


public class FragmentDialog extends DialogFragment {

    public interface DialogClickListener{
         void dialogListnerWithCity(String city);
         void dialogListnerWithCancel();
    }

    public DialogClickListener listener;

    public static final String Tag = "tag";
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;


    public static FragmentDialog newInstance(String param1) {
        FragmentDialog fragment = new FragmentDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        TextView textView = v.findViewById(R.id.text_in_dialog);
        textView.setText(mParam1);

        EditText citytext = v.findViewById(R.id.city_text);

        Button yes = v.findViewById(R.id.yesid);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!citytext.getText().toString().isEmpty())
                listener.dialogListnerWithCity(citytext.getText().toString());
                dismiss();
            }
        });
        Button no = v.findViewById(R.id.noid);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.dialogListnerWithCancel();
                dismiss();
            }
        });



        return v;



    }
}