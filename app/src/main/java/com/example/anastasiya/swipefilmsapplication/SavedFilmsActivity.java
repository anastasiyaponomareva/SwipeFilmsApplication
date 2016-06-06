package com.example.anastasiya.swipefilmsapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import controller.UserFilmsController;
import entities.Film;

public class SavedFilmsActivity extends Activity {

    RecyclerView rv;
    private List<Film> films;
    UserFilmsController userFilmsController;
    FloatingActionButton randomizeFilms;
    FloatingActionButton recommendedFilmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_films);
        rv = (RecyclerView) findViewById(R.id.rv);
        randomizeFilms = (FloatingActionButton) findViewById(R.id.fab_randomize_films);
        recommendedFilmsButton = (FloatingActionButton) findViewById(R.id.fab_recommended_films);
        recommendedFilmsButton.setBackgroundTintList(getResources().getColorStateList(R.color.fab_color_2));

        Intent intent = getIntent();
        userFilmsController = (UserFilmsController) intent.getExtras()
                .getSerializable("userFilmsController");
        setTitle(intent.getStringExtra("activityTitle"));
        Resources r = getResources();

        //TODO: dummy variable now, add saved films somehow
        films = userFilmsController.getFilmsList();


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(films);
        rv.setAdapter(adapter);
        randomizeFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        SavedFilmsActivity.this,
                        SwipeCardsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("userFilmsController", userFilmsController);
                intent.putExtras(bundle);
                startActivity(intent);

                finish();
            }
        });

        recommendedFilmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        SavedFilmsActivity.this,
                        CardViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("userFilmsController", userFilmsController);
                intent.putExtras(bundle);
                startActivity(intent);

                finish();
            }
        });
    }
}
