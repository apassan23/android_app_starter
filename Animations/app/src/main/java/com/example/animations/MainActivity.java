package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_view);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveButton(v);
                return true;
            }
        });
    }

    public void moveButton(View view){
        Button btn = view.findViewById(R.id.btn);

        TransitionManager.beginDelayedTransition(layout);

        // Change the position of button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        btn.setLayoutParams(positionRules);

        // Change the size of the button
        ViewGroup.LayoutParams sizeRules = btn.getLayoutParams();
        sizeRules.height = 450;
        sizeRules.width = 300;
        btn.setLayoutParams(sizeRules);
    }
}
