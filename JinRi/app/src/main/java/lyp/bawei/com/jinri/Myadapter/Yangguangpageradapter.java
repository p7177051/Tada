package lyp.bawei.com.jinri.Myadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/27.
 */

public class Yangguangpageradapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> list;


    public Yangguangpageradapter(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list=list;

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
