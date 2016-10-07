package com.zhi.www.viewpagertest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zhi.www.viewpagertest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/7.
 */
public class ChatFragment extends Fragment {
    private ListView mListView;
    private List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
    private Map<String, String> data;

    private String[] names = new String[20];
    private String[] des = new String[20];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, null);
        mListView = (ListView) view.findViewById(R.id.listView);

        init();
        return view;
    }

    private void init() {
        for(int i=0;i<names.length;i++){
            names[i]="姓名："+i;
        }

        for(int i=0;i<des.length;i++){
            des[i]="我来自南岸："+i;
        }

        maps.clear();
        for (int i = 0; i < 20; i++) {
            data = new HashMap<String, String>();
            data.put("name", names[i]);
            data.put("des", des[i]);
            maps.add(data);
        }

        SimpleAdapter sa = new SimpleAdapter(this.getActivity(), maps,
                R.layout.item, new String[]{"name", "des"}, new int[]{R.id.tv_name, R.id.tv_des});
        mListView.setAdapter(sa);
    }
}