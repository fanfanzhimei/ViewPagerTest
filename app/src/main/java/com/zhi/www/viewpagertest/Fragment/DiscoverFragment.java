package com.zhi.www.viewpagertest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhi.www.viewpagertest.R;

/**
 * Created by Administrator on 2016/10/7.
 */
public class DiscoverFragment  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, null);
        return view;
    }
}
