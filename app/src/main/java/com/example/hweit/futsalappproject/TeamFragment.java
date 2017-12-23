package com.example.hweit.futsalappproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;
import java.util.zip.Inflater;

/**
 * Created by hweit on 12/23/2017.
 */

public class TeamFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView playerTextA = (TextView) view.findViewById(R.id.tv_playerNameA);
        final TextView playerTextB = (TextView) view.findViewById(R.id.tv_playerNameB);

        view.findViewById(R.id.btnTeamTesting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerTextA.setText("");
                playerTextB.setText("");
                printPlayer(view,playerTextA,playerTextB);
            }
        });

    }
    public void printPlayer(View view,TextView playerTextA,TextView playerTextB){

        Vector<String> player = new Vector<String>();
        Random random = new Random();
        int trackA = 1 , trackB =1;

        for (int i=1 ; i<11 ; i++){
            player.add("Player " + i);
        }

        for (int i=0 ; i<player.size() ; i++) {

            if(trackA <= 5 && trackB <=5) {
                int randomNum = random.nextInt(3 - 1) + 1;

                if (randomNum%2==0) {
                    playerTextA.append(player.get(i) + "\n");
                    trackA++;
                } else if (randomNum%2!=0) {
                    playerTextB.append(player.get(i) + "\n");
                    trackB++;
                }
            }else if(trackA < trackB){
                playerTextA.append(player.get(i) + "\n");
            }else if(trackA > trackB){
                playerTextB.append(player.get(i) + "\n");
            }
        }
        Toast.makeText(getActivity(), "Random Team Generated", Toast.LENGTH_SHORT).show();
    }

}
