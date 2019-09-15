package com.lalaalal.notice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lalaalal.notice.MysqlClient;
import com.lalaalal.notice.R;
import com.lalaalal.notice.view.CardViewAdapter;
import com.lalaalal.notice.view.CardViewMaker;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryFragment extends MainFragment {

    public CategoryFragment(MysqlClient mysqlClient) {
        super(mysqlClient);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        LinearLayout layout = root.findViewById(R.id.category_layout);

        try {
            ArrayList<CardViewMaker> cardViewMakers = getCategoriesFromDB();

            CardViewAdapter cardViewAdapter = new CardViewAdapter(getContext(), cardViewMakers);
            layout.addView(cardViewAdapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return root;
    }

    private ArrayList<CardViewMaker> getCategoriesFromDB() throws SQLException {
        ArrayList<CardViewMaker> cardViewMakers;
        cardViewMakers = getMysqlClient().getCategories();

        return cardViewMakers;
    }
}
