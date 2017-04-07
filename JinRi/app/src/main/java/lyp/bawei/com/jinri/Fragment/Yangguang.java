package lyp.bawei.com.jinri.Fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Myadapter.Shouyeviewpager;
import lyp.bawei.com.jinri.Myadapter.Yangguangpageradapter;
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

    private ViewPager yangguang_viewpager;
private String[] arr=new String[]{"热点","娱乐","搞笑","精品"};
    private MagicIndicator magicIndicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.yangguang, null);
        init();
        guanlian();
        return view;

    }
    public void init(){
        magicIndicator = (MagicIndicator) view.findViewById(R.id.yangguang_tablayout);

        yangguang_viewpager = (ViewPager) view.findViewById(R.id.yangguang_viewpager);
        final CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return arr == null ? 0 : arr.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);

                clipPagerTitleView.setText(arr[index]);
                clipPagerTitleView.setTextColor(Color.BLACK);
                clipPagerTitleView.setClipColor(Color.RED);
                clipPagerTitleView.setTextSize(30);

                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        yangguang_viewpager.setCurrentItem(index);
                    }
                });

                return clipPagerTitleView;
            }



            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;    // 没有指示器，因为title的指示作用已经很明显了
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        yangguang_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicIndicator.onPageScrollStateChanged(state);
            }
        });

        yangguang_viewpager.setCurrentItem(1);
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

       Yangguangpageradapter yangguangpageradapter=new Yangguangpageradapter(getChildFragmentManager(),list);
       yangguang_viewpager.setAdapter(yangguangpageradapter);


   }
}
