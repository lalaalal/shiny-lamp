package com.lalaalal.notice.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class CategoryCardView extends CardView {
    TextView textView;

    public int dpToPx(int dp){
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();

        return (int)(dp * (metrics.densityDpi / 160f));
    }

    public CategoryCardView(Context context) {
        super(context);
        initLayout();

        textView = new TextView(context);
        addView(textView);
    }
    public CategoryCardView(Context context, String text) {
        this(context);
        setText(text);
    }
    public CategoryCardView(Context context, CategoryData categoryData) {
        this(context);
        setText(categoryData.NAME);
    }

    private void initLayout() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        setForeground(getContext().getDrawable(typedValue.resourceId));

        LayoutParams layout = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.bottomMargin = dpToPx(10);

        setLayoutParams(layout);
        setContentPadding(dpToPx(10), dpToPx(10), dpToPx(10), dpToPx(10));
        setFocusable(true);
        setClickable(true);
    }

    public void setText(String string) {
        textView.setText(string);
    }
}
