package com.lalaalal.notice.fragment;

import androidx.fragment.app.Fragment;

import com.lalaalal.notice.MysqlClient;

public class MainFragment extends Fragment {
    private MysqlClient mysqlClient;

    public MainFragment(MysqlClient mysqlClient) {
        this.mysqlClient = mysqlClient;
    }

    public MysqlClient getMysqlClient() {
        return mysqlClient;
    }
}
