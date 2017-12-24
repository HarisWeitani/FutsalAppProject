package com.example.hweit.futsalappproject;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by hweit on 12/23/2017.
 */

public class TimerFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView timerText = (TextView) view.findViewById(R.id.txtTimer);

        view.findViewById(R.id.btnTimerTesting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timerController(view,timerText);

            }
        });
    }

    public void timerController(View view, final TextView timerText){

        final Button timerBtn = (Button) view.findViewById(R.id.btnTimerTesting);

        new CountDownTimer(100000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerBtn.setVisibility(View.GONE);
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                timerText.setText(String.format("%d:%02d", minutes, seconds));
            }
            public void onFinish() {
                timerText.setText("done!");
                timerBtn.setVisibility(View.VISIBLE);
            }
        }.start();

    }
}