package com.lalaalal.notice.view;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class CardViewAdapter extends LinearLayout {
    ArrayList<CardView> cardViews;

    public CardViewAdapter(Context context) {
        super(context);
        setOrientation(VERTICAL);

        cardViews = new ArrayList<>();
    }
//    public CardViewAdapter(Context context, ArrayList<CardView> cardViewArrayList) {
//        this(context);
//
//        for (int i = 0; i < cardViewArrayList.size(); i++)
//            addCardView(cardViewArrayList.get(i));
//    }
    public CardViewAdapter(Context context, ArrayList<CardViewMaker> cardViewMakers) {
        this(context);

        for (int i = 0; i < cardViewMakers.size(); i++) {
            CardView cardView = cardViewMakers.get(i).makeCardView(context);
            addCardView(cardView);
        }
    }

    public void addCardView(CardView cardView) {
        cardViews.add(cardView);
        addView(cardView);
    }
}
