package org.wbing.app_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import org.wbing.app_list.databinding.ActivityMainBinding;
import org.wbing.base.ui.impl.WAct;
import org.wbing.list.WListFragment;

public class MainActivity extends WAct<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void loadData() {
        getBinding().content.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(int i) {
                return i == 0 ? new SingleListFragment() : new MultiListFragment();
            }
        });
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(android.R.id.content, new MainFragmet())
//                .commit();
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.single, new MainFragmet())
//                .commitNow();
        Log.e("TAG", "fsdfa");
    }

    @Override
    public void recycle() {

    }

}
