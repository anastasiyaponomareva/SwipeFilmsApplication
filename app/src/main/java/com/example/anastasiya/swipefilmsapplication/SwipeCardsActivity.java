package com.example.anastasiya.swipefilmsapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

import java.util.ArrayList;
import java.util.List;

import controller.UserFilmsController;

public class SwipeCardsActivity extends Activity {
    UserFilmsController userFilmsController;
    //костыли, много костылей
    int counter;
    int maxCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CardContainer mCardContainer;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_cards);
        mCardContainer = (CardContainer) findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Ordered);
        mCardContainer.setOrientation(Orientations.Orientation.Disordered);

        //This library with swipe cards cannot detect that there are no
        // cards left on the screen. So we have to use counter to jump
        //to a new activity after user has swiped all cards.
        counter = 0;


        //can fall here, but actually should work
        Intent intent = getIntent();
        userFilmsController = (UserFilmsController) intent.getExtras()
                .getSerializable("userFilmsController");
        Resources r = getResources();

        //TODO: get films list from userFilmsController, set maxCards value as its length
        maxCards = 5;

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);


        //TODO: here you should add films to swipecards instead of this dummy variables
        //TODO: (use userFilmsController)

        List<CardModel> cards = new ArrayList<>();
        cards.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
        cards.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
        cards.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        cards.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));

        //set listeners
        for (CardModel card : cards) {
            card.setOnCardDimissedListener(onCardDimissedListener);
            card.setOnClickListener(onClickListener);
            adapter.add(card);
        }


        mCardContainer.setAdapter(adapter);


    }
    CardModel.OnCardDimissedListener onCardDimissedListener =
            new CardModel.OnCardDimissedListener() {
        @Override
        public void onLike() {
            Log.i("Swipeable Cards", "I like the card");
            //TODO: count likes and do what you need with them
            ++counter;
            if (counter == maxCards) {
                Intent intent = new Intent(
                        SwipeCardsActivity.this,
                        CardViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("userFilmsController", userFilmsController);
                bundle.putString("activityTitle", "Recommendations for you");
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        }



        @Override
        public void onDislike() {
            Log.i("Swipeable Cards", "I dislike the card");
            //TODO: count dislikes and do what you need with them
            ++counter;
            if (counter == maxCards) {
                Intent intent = new Intent(
                        SwipeCardsActivity.this,
                        CardViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("userFilmsController", userFilmsController);
                bundle.putString("activityTitle", "Recommendations for you");
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        }
    };
    CardModel.OnClickListener onClickListener = new CardModel.OnClickListener() {
        @Override
        public void OnClickListener() {
            Log.i("Swipeable Cards", "I clicked on the card");
            //TODO: maybe you have some ideas what should be here

        }
    };
}
