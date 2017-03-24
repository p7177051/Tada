package lyp.bawei.com.jinri.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Myadapter.Shouyeviewpager;
import lyp.bawei.com.jinri.R;
import lyp.bawei.com.jinri.YangguangFragment.GaoxiaoFragment;
import lyp.bawei.com.jinri.YangguangFragment.JingpinFragment;
import lyp.bawei.com.jinri.YangguangFragment.RedianFragment;
import lyp.bawei.com.jinri.YangguangFragment.YuleFragment;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Yangguang extends Fragment{

    private View view;
    private TabLayout yangguang_tablayout;
    private ViewPager yangguang_viewpager;
private String[] arr=new String[]{"热点","娱乐","搞笑","精品"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.yangguang, null);
        init();
        guanlian();
        return view;

    }
    public void init(){
        yangguang_tablayout = (TabLayout) view.findViewById(R.id.yangguang_tablayout);
        yangguang_viewpager = (ViewPager) view.findViewById(R.id.yangguang_viewpager);
    }
   public void guanlian(){
       ArrayList<Fragment> list=new ArrayList<Fragment>();

           RedianFragment redian=new RedianFragment();
           list.add(redian);
       YuleFragment yuleFragment=new YuleFragment();
       list.add(yuleFragment);
       GaoxiaoFragment gaoxiaoFragment=new GaoxiaoFragment();
       list.add(gaoxiaoFragment);
       JingpinFragment jingpinFragment=new JingpinFragment();
       list.add(jingpinFragment);
       Shouyeviewpager shouyeviewpager=new Shouyeviewpager(getChildFragmentManager(),list,arr);
       yangguang_viewpager.setAdapter(shouyeviewpager);
       yangguang_viewpager.setAdapter(shouyeviewpager);
       yangguang_tablayout.setupWithViewPager(yangguang_viewpager);
       yangguang_tablayout.setTabsFromPagerAdapter(shouyeviewpager);
   }
}
