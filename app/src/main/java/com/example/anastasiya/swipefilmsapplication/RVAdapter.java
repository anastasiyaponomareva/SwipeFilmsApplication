package com.example.anastasiya.swipefilmsapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import entities.Film;

/**
 * Created by Anastasiya on 03.05.2016.
 */
public class RVAdapter extends  RecyclerView.Adapter<RVAdapter.PersonViewHolder>{


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.description.setText(films.get(i).getDescription());
        personViewHolder.title.setText(films.get(i).getTitle());
        personViewHolder.filmPoster.setImageResource(films.get(i).getPosterId());

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView description;
        ImageView filmPoster;


        PersonViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            filmPoster=(ImageView)itemView.findViewById(R.id.film_poster);

        }
    }
    List<Film> films;
    RVAdapter(List<Film> films)
    {
        this.films =films;
    }

}
