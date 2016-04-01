package me.payge.viewflipanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import me.payge.viewflipanimator.lib.ViewAnimUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int duration = 500;

    private View button;
    private View frame;
    private View front;
    private View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        frame = findViewById(R.id.frame);
        front = findViewById(R.id.front);
        back = findViewById(R.id.back);
        button.setOnClickListener(this);
    }

    private void switchViewVisibility() {
        if (back.isShown()) {
            back.setVisibility(View.GONE);
            front.setVisibility(View.VISIBLE);
        } else {
            back.setVisibility(View.VISIBLE);
            front.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            int direction = 1;
            if (back.isShown()) {
                direction = -1;
            }
            ViewAnimUtils.flip(frame, duration, direction);
            frame.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switchViewVisibility();
                }
            }, duration);
        }
    }
}
