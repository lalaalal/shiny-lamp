package com.lalaalal.notice.view;

import android.content.Context;

import androidx.cardview.widget.CardView;

import java.sql.ResultSet;

public abstract class CardViewMaker {
    private final ResultSet result;

    public CardViewMaker(ResultSet result) {
        this.result = result;
    }

    public final ResultSet getResult() {
        return result;
    }

    public abstract CardView makeCardView(Context context);
}
