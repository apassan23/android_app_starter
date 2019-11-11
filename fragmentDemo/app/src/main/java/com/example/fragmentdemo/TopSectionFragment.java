package com.example.fragmentdemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TopSectionFragment extends Fragment {

    private static Activity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.top_section_fragment,container,false);

        final EditText topInput = view.findViewById(R.id.top_text_input);
        final EditText bottomInput = view.findViewById(R.id.bottom_text_input);
        final Button btn = view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView topText = mainActivity.findViewById(R.id.top_text);
                TextView bottomText = mainActivity.findViewById(R.id.bottom_text);
                topText.setText(topInput.getText());
                bottomText.setText(bottomInput.getText());
            }
        });

        return view;
    }
}
