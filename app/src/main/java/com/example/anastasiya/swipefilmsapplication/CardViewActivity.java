package com.example.anastasiya.swipefilmsapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import controller.UserFilmsController;
import entities.Film;

public class CardViewActivity extends AppCompatActivity {
    RecyclerView rv;
    private List<Film> films;
    UserFilmsController userFilmsController;;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        rv=(RecyclerView)findViewById(R.id.rv);
        fab = (FloatingActionButton) findViewById(R.id.fab_gen);


        Intent intent = getIntent();
        userFilmsController = (UserFilmsController)intent.getExtras()
                .getSerializable("userFilmsController");
        setTitle(intent.getStringExtra("activityTitle"));
        Resources r = getResources();

        //TODO: dummy variable now, add films from userFilmsController
        films=userFilmsController.getFilmsList();


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(films);
        rv.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        CardViewActivity.this,
                        SwipeCardsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("userFilmsController", userFilmsController);
                intent.putExtras(bundle);
                startActivity(intent);

                finish();
            }
        });

    }
}
