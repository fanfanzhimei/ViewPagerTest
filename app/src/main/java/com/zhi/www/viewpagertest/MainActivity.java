package com.zhi.www.viewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.zhi.www.viewpagertest.Adapter.PagerAdapter;
import com.zhi.www.viewpagertest.Fragment.ChatFragment;
import com.zhi.www.viewpagertest.Fragment.ContactsFragment;
import com.zhi.www.viewpagertest.Fragment.DiscoverFragment;
import com.zhi.www.viewpagertest.Fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements OnCheckedChangeListener{

    private List<Fragment> fragments = new ArrayList<Fragment>();

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
        initEvents();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);

    }

    private void initData() {
        fragments.add(new ChatFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MeFragment());
    }

    private void initEvents() {
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(new MyListener());
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int current = 0;
        switch (checkedId){
            case R.id.rb_chat:
                current = 0;
                break;
            case R.id.rb_contacts:
                current = 1;
                break;
            case R.id.rb_discover:
                current = 2;
                break;
            case R.id.rb_me:
                current = 3;
                break;
        }

        if(mViewPager.getCurrentItem() != current){
            mViewPager.setCurrentItem(current);
        }
    }

    class MyListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int currentItem = mViewPager.getCurrentItem();
            switch (currentItem){
                case 0:
                    mRadioGroup.check(R.id.rb_chat);
                    break;
                case 1:
                    mRadioGroup.check(R.id.rb_contacts);
                    break;
                case 2:
                    mRadioGroup.check(R.id.rb_discover);
                    break;
                case 3:
                    mRadioGroup.check(R.id.rb_me);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(MainActivity.this,"您点了搜索按钮", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
