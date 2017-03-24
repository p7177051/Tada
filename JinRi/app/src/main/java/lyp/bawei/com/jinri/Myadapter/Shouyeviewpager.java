package lyp.bawei.com.jinri.Myadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/14.
 */

public class Shouyeviewpager extends FragmentPagerAdapter{
    private ArrayList<Fragment> list;
    private String[] arr;



    public Shouyeviewpager(FragmentManager fm, ArrayList<Fragment> list, String[] arr) {
        super(fm);
        this.list = list;
        this.arr = arr;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
