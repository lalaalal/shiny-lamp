package com.lalaalal.notice.view;

import android.content.Context;

import androidx.cardview.widget.CardView;

import java.sql.ResultSet;
import java.sql.SQLException;

class CategoryData {
    public final String NAME;

    public CategoryData(String name) {
        NAME = name;
    }
}

public class CategoryCardViewMaker extends CardViewMaker {
    private final int NAME_COL = 2;
    private String name;

    public CategoryCardViewMaker(ResultSet result) {
        super(result);
    }

    public CardView makeCardView(Context context) {
        try {
            name = getResult().getString(NAME_COL);
        } catch (SQLException e) {
            System.out.println("An SQLException Occurred while making CardView");
        }
        return new CategoryCardView(context, new CategoryData(name));
    }
}
