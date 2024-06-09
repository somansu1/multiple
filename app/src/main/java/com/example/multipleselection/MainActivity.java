package com.example.multipleselection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TvShowsListener{

    private Button buttonAdd;
    RecyclerView tvShowsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvShowsRecyclerView=findViewById(R.id.tvShowsRecyclerView);
        buttonAdd = findViewById(R.id.buttonAdd);

        List<TvShow> tvShows=new ArrayList<>();

        TvShow the100=new TvShow();
        the100.image=R.drawable.first;
        the100.name="The 100";
        the100.rating=5f;
        the100.createdBy="Jason Rother";
        the100.story="The series is set 97 years after a devarcast in eatydjh hyhh";
        tvShows.add(the100);

        TvShow lostInSpace=new TvShow();
        lostInSpace.image=R.drawable.second;
        lostInSpace.name="Lost in Space ";
        lostInSpace.rating=4.5f;
        lostInSpace.createdBy="Jason murmu";
        lostInSpace.story="The series is set 97 years after a Allow in earth hyhh";
        tvShows.add(lostInSpace);

        TvShow viking=new TvShow();
        viking.image=R.drawable.third;
        viking.name="Viking";
        viking.rating=4.5f;
        viking.createdBy="Jason Rother";
        viking.story="The series is set 97 years after a devarcast in eatydjh hyhh";
        tvShows.add(viking);

        TvShow rising=new TvShow();
        rising.image=R.drawable.forth;
        rising.name="Rising";
        rising.rating=3.5f;
        rising.createdBy="Jason Rother";
        rising.story="The series is set 97 years after a devarcast in eatydjh hyhh";
        tvShows.add(rising);

        TvShow flying=new TvShow();
        flying.image=R.drawable.fif;
        flying.name="Flying";
        flying.rating=4.5f;
        flying.createdBy="Jason Rother";
        flying.story="The series is set 97 years after a devarcast in eatydjh hyhh";
        tvShows.add(flying);

        TvShow jumping=new TvShow();
        jumping.image=R.drawable.six;
        jumping.name="Jumping";
        jumping.rating=4.5f;
        jumping.createdBy="Jason Rother";
        jumping.story="The series is set 97 years after a devarcast in eatydjh hyhh";
        tvShows.add(jumping);

        TvShow lying=new TvShow();
        lying.image=R.drawable.seven;
        lying.name="Lying";
        lying.rating=4.5f;
        lying.createdBy="Jason Rother";
        lying.story="The series is set 97 years after a devarcast in eatydjh hyhh";
        tvShows.add(lying);


        TvShowAdapter tvShowsAdapter = new TvShowAdapter(tvShows,this);
        tvShowsRecyclerView.setAdapter(tvShowsAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<TvShow> selectedTvShows=tvShowsAdapter.getSelectedTvShows();

                StringBuilder tvShowNames=new StringBuilder();
                for (int i=0;i< selectedTvShows.size();i++){
                    if (i==0){
                        tvShowNames.append(selectedTvShows.get(i).name);
                    }else {
                        tvShowNames.append("\n").append(selectedTvShows.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, tvShowNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onTvShowAction(Boolean isSelected) {
        if (isSelected){
            buttonAdd.setVisibility(View.VISIBLE);
        }else{
            buttonAdd.setVisibility(View.GONE);
        }

    }
}