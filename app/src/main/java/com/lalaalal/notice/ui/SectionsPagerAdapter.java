package com.lalaalal.notice.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.lalaalal.notice.MysqlClient;
import com.lalaalal.notice.R;
import com.lalaalal.notice.fragment.CategoryFragment;
import com.lalaalal.notice.fragment.HomeFragment;
import com.lalaalal.notice.fragment.LunchFragment;
import com.lalaalal.notice.fragment.ScheduleFragment;

import java.sql.SQLException;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final int HOME = 0;
    private static final int CATEGORY = 1;
    private static final int SCHEDULE = 2;
    private static final int LUNCH = 3;

    private static final int[] TAB_TITLES = new int[] { R.string.tab_home_title, R.string.tab_category_title, R.string.tab_schedule_title, R.string.tab_lunch_title };
    private final Context mContext;

    private MysqlClient mysqlClient;

    public SectionsPagerAdapter(Context context, FragmentManager fm) throws ClassNotFoundException, SQLException {
        super(fm);
        mContext = context;
        mysqlClient = new MysqlClient();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case CATEGORY:
                return new CategoryFragment(mysqlClient);
            case SCHEDULE:
                return new ScheduleFragment();
            case LUNCH:
                return new LunchFragment();
            default:
                return new HomeFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
