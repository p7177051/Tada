package lyp.bawei.com.jinri.Fragment;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.trs.channellib.channel.channel.helper.ChannelDataHelepr;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import lyp.bawei.com.jinri.Activity.PindaoActivity;
import lyp.bawei.com.jinri.Activity.XiazaiActivity;
import lyp.bawei.com.jinri.Bean.PindaoBean;
import lyp.bawei.com.jinri.Myadapter.Shouyeviewpager;
import lyp.bawei.com.jinri.R;
import lyp.bawei.com.jinri.SHouyeFragment.JiankanFragment;
import lyp.bawei.com.jinri.SHouyeFragment.Qutu_fragment;
import lyp.bawei.com.jinri.SHouyeFragment.RedianShouyueFragment;
import lyp.bawei.com.jinri.SHouyeFragment.ShehuiFragment;
import lyp.bawei.com.jinri.SHouyeFragment.TuijianFragment;
import lyp.bawei.com.jinri.SHouyeFragment.TupianFragment;
import lyp.bawei.com.jinri.SHouyeFragment.YuleShouyeFragment;
import lyp.bawei.com.jinri.SHouyeFragment.ZhengFragment;
import lyp.bawei.com.jinri.Utiles.NetWorkUtils;
import lyp.bawei.com.jinri.Utiles.ThemeManager;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Shouye extends Fragment implements View.OnClickListener,ThemeManager.OnThemeChangeListener,ChannelDataHelepr.ChannelDataRefreshListenter{


    private TabLayout shouye_tabs;
    private ViewPager shouye_viewpager;
    private View view;
    private ToggleButton shouye_togbutton;
    ChannelDataHelepr<PindaoBean> dataHelepr;
    private SlidingMenu slidingMenu;
private String[] tabarr=new String[]{"推荐","热点","社会","娱乐","健康","正能量","图片","趣图"};
    private ImageView denglu_qq;
    private ImageView dengglu_touxiang;
    private TextView denglu_text;
    private LinearLayout denglu_le;
    private LinearLayout denglu_mei;
    private ActionBar supportActionBar;
    private Button denglu_rijianmoshi;
    private LinearLayout relativeLayout;
    private LinearLayout denglu;
    private SharedPreferences zhuangtai;
    private SharedPreferences.Editor editor;
    private Button denglu_lixianhuancun;
    private AlertDialog.Builder builder;
    private ImageView shouye_pindaobutton;
int needShowPosition=-1;
    private ArrayList<PindaoBean> pindaplist;
    private ArrayList<PindaoBean> mypindaolist;
    private Shouyeviewpager shouyeviewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shouye, null);

        ThemeManager.registerThemeChangeListener(this);
        supportActionBar = getActivity().getActionBar();
       //sp生命
        dengluzhuangtai();
        //找空间
        init();
        //侧滑页面
        cehua();
        //tab联动效果
        gettab();
//登陆界面的逻辑
       getDenglu();
        return view;

    }
    public void init(){

        shouye_tabs = (TabLayout) view.findViewById(R.id.shouye_tabs);
        shouye_viewpager = (ViewPager) view.findViewById(R.id.shouye_viewpager);
        shouye_togbutton = (ToggleButton) view.findViewById(R.id.shouye_togbutton);
        shouye_pindaobutton = (ImageView) view.findViewById(R.id.shouye_pindaobutton);
        shouye_pindaobutton.setOnClickListener(this);
        shouye_togbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle();
            }
        });


    }
    public void cehua(){
        slidingMenu = new SlidingMenu(getActivity());

//从左边滑出
        slidingMenu.setMode(SlidingMenu.LEFT);
//设置整个屏幕都可以滑出
// slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//设置整个屏幕都不可以滑出菜单
// slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//设置主屏幕滑出的宽度
        slidingMenu.setBehindOffset(200);
        slidingMenu.attachToActivity(getActivity(), SlidingMenu.SLIDING_CONTENT);
//设置侧滑的布局页
        slidingMenu.setMenu(R.layout.denglu);

    }
    public void getDenglu(){
        relativeLayout = (LinearLayout)getActivity().findViewById(R.id.zhuye);
        denglu = (LinearLayout)getActivity().findViewById(R.id.denglu);
        ImageView denglu_qq=  (ImageView) getActivity().findViewById(R.id.denglu_qq);
        denglu_rijianmoshi = (Button) getActivity().findViewById(R.id.denglu_rijianmoshi);
        ImageView denglu_shouji= (ImageView) getActivity().findViewById(R.id.denglu_shouji);
        denglu_le = (LinearLayout) getActivity().findViewById(R.id.denglu_le);
        denglu_mei = (LinearLayout) getActivity().findViewById(R.id.denglu_mei);
        dengglu_touxiang = (ImageView) getActivity().findViewById(R.id.dengglu_touxiang);
        denglu_text = (TextView) getActivity().findViewById(R.id.denglu_text);
       Button denglu_zhuxiao= (Button) getActivity().findViewById(R.id.denglu_zhuxiao);
        denglu_lixianhuancun = (Button) getActivity().findViewById(R.id.denglu_lixianhuancun);
        denglu_zhuxiao.setOnClickListener(this);
        denglu_qq.setOnClickListener(this);
        denglu_shouji.setOnClickListener(this);
        denglu_rijianmoshi.setOnClickListener(this);
        denglu_lixianhuancun.setOnClickListener(this);
    }
    public void gettab(){

        dataHelepr = new ChannelDataHelepr(getContext(), this,view.findViewById(R.id.shouye_pindaobutton) );
        pindaplist = new ArrayList<PindaoBean>();
        mypindaolist = new ArrayList<PindaoBean>();
        ArrayList<Fragment> flist=new ArrayList<Fragment>();
        TuijianFragment tuijianFragment=new TuijianFragment();
        flist.add(tuijianFragment);
        RedianShouyueFragment redianShouyueFragment=new RedianShouyueFragment();
        flist.add(redianShouyueFragment);
        ShehuiFragment shehuiFragment=new ShehuiFragment();
        flist.add(shehuiFragment);
        YuleShouyeFragment yuleShouyeFragment=new YuleShouyeFragment();
        flist.add(yuleShouyeFragment);
        JiankanFragment jiankanFragment=new JiankanFragment();
        flist.add(jiankanFragment);
        ZhengFragment zhengFragment=new ZhengFragment();
        flist.add(zhengFragment);
        TupianFragment tupianFragment=new TupianFragment();
        flist.add(tupianFragment);
        Qutu_fragment shouye_fragment=new Qutu_fragment();
        flist.add(shouye_fragment);

        PindaoBean pindaoBean1=new PindaoBean("推荐",0,1,1,tuijianFragment);
        PindaoBean pindaoBean2=new PindaoBean("热点",0,1,1,redianShouyueFragment);
        PindaoBean pindaoBean3=new PindaoBean("社会",1,0,1,shehuiFragment);
        PindaoBean pindaoBean4=new PindaoBean("娱乐",1,0,1,yuleShouyeFragment);
        PindaoBean pindaoBean5=new PindaoBean("健康",1,0,1,jiankanFragment);
        PindaoBean pindaoBean6=new PindaoBean("正能量",1,0,1,zhengFragment);
        PindaoBean pindaoBean7=new PindaoBean("图片",1,0,1,tupianFragment);
        PindaoBean pindaoBean8=new PindaoBean("趣图",1,0,1,shouye_fragment);
        pindaplist.add(pindaoBean1);
        pindaplist.add(pindaoBean2);
        pindaplist.add(pindaoBean3);
        pindaplist.add(pindaoBean4);
        pindaplist.add(pindaoBean5);
        pindaplist.add(pindaoBean6);
        pindaplist.add(pindaoBean7);
        pindaplist.add(pindaoBean8);
        dataHelepr.setSwitchView(shouye_pindaobutton);

        shouyeviewpager = new Shouyeviewpager(getChildFragmentManager(),mypindaolist);
        shouye_viewpager.setAdapter(shouyeviewpager);
        shouye_tabs.setupWithViewPager(shouye_viewpager);
        loadData();
    }

    @Override
    public void onClick(View v) {
        boolean flag = zhuangtai.getBoolean("flag", false);
        //final boolean isauth = UMShareAPI.get(getActivity()).isAuthorize(getActivity(),SHARE_MEDIA.QQ);
        switch (v.getId()){
            case R.id.denglu_qq:
                Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();
                UMShareAPI.get(getActivity()).doOauthVerify(getActivity(), SHARE_MEDIA.QQ.toSnsPlatform().mPlatform, umAuthListener);
                break;
            case R.id.denglu_zhuxiao:
                if(flag){
                    UMShareAPI.get(getActivity()).deleteOauth(getActivity(),SHARE_MEDIA.QQ.toSnsPlatform().mPlatform,umAuthListener);
                }else {
                    Toast.makeText(getActivity(), "没登陆", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.denglu_rijianmoshi:

                ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY   ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);
                break;
            case R.id.denglu_shouji:
                SMSSDK.initSDK(getActivity(), "1c0e2609bb4aa", "a941cdb1b2e606adc23902d0f08b60cf");

//打开注册页面
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
                            denglu_le.setVisibility(View.VISIBLE);
                            denglu_mei.setVisibility(View.INVISIBLE);
                            denglu_text.setText(country+phone);
                            editor.putBoolean("flag",true);
                            editor.commit();
// 提交用户信息（此方法可以不调用）
                            //registerUser(country, phone);
                        }
                    }
                });
                registerPage.show(getActivity());
                            break;
            case R.id.denglu_lixianhuancun:
                xiazai();
                break;
            /*case R.id.shouye_pindaobutton:
                Intent intent=new Intent(getActivity(),PindaoActivity.class);
                startActivity(intent);
                break;*/
        }
    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            switch (action){
                case ACTION_AUTHORIZE:
                    Toast.makeText(getContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
                    UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(),SHARE_MEDIA.QQ,umAuthListener);
                    editor.putBoolean("flag",true);
                    editor.commit();
                    break;
                case ACTION_DELETE:
                    denglu_le.setVisibility(View.INVISIBLE);
                    denglu_mei.setVisibility(View.VISIBLE);

                    break;
                case ACTION_GET_PROFILE:
                    String screen_name = data.get("screen_name");
                    String profile_image_url = data.get("profile_image_url");
                    denglu_le.setVisibility(View.VISIBLE);
                    denglu_mei.setVisibility(View.INVISIBLE);
                    denglu_text.setText(screen_name);
                    ImageOptions options = new ImageOptions.Builder().setCircular(true).setCrop(true).setSize(100, 100).setLoadingDrawableId(R.mipmap.ic_launcher).build();
                    //加载图片
                    x.image().bind(dengglu_touxiang,profile_image_url, options);
                    break;
            }


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(SHARE_MEDIA platform, int action) {
        Toast.makeText( getActivity(), "Authorize cancel", Toast.LENGTH_SHORT).show();
    }
    };
    public void initTheme() {
        //tv.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        denglu_rijianmoshi.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getActivity(), R.color.textColor)));
        relativeLayout.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getActivity(), R.color.backgroundColor)));
        denglu.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getActivity(), R.color.backgroundColor)));
        // 设置标题栏颜色
        if(supportActionBar != null){
            supportActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(ThemeManager.getCurrentThemeRes(getActivity(), R.color.colorPrimary))));
        }
        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.setStatusBarColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getActivity(), R.color.colorPrimary)));
        }
    }
    @Override
    public void onThemeChanged() {
        initTheme();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        ThemeManager.unregisterThemeChangeListener(this);
    }
    public void dengluzhuangtai(){
        zhuangtai = getActivity().getSharedPreferences("zhuangtai", Context.MODE_PRIVATE);
        editor = zhuangtai.edit();
    }
    public void xiazai(){
        if(NetWorkUtils.isNetWorkAvailable(getActivity())){
           Intent intent=new Intent(getActivity(), XiazaiActivity.class);
            startActivity(intent);
        }else {
            builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("当前没有网络");
            builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = null;
                    // 先判断当前系统版本
                    if(android.os.Build.VERSION.SDK_INT > 10){  // 3.0以上
                        intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                    }else{
                        intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                    }
                    getActivity().startActivity(intent);

                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    builder.create().hide();
                }
            });
            builder.create().show();
        }

    }

    @Override
    public void updateData() {
        loadData();
    }
    //实现的方法  点击频道中的item的时候触发  可以根据是否有更新进行选择  viewpager切换的时机
    @Override
    public void onChannelSeleted(boolean update,final int posisiton) {
        if(!update) {
            //如果没有更新  那么viewpager显示的是posisiton位置的数据
            shouye_viewpager.setCurrentItem(posisiton);
        }else {
            //如果更新数据了  那么默认显示的位置为posisiton，用needShowPosition接出来
            needShowPosition=posisiton;
        }

    }

    //每次数据加载完成后，过滤一遍，只显示订阅的频道
    private void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                // String data = getFromRaw();
                //解析得到数据
                //  List<MyChannel> alldata = GsonUtil.jsonToBeanList(data, MyChannel.class);
                //Library中已经封装了数据库操作，获取需要显示的数据只需要一行代码即可
                //过滤数据  如果有新的频道会自动订阅并保存到数据库中  从数据库中得到数据
                final List<PindaoBean> showChannels = dataHelepr.getShowChannels(pindaplist);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //清空频道集合
                        mypindaolist.clear();
                        //添加从数据库中查询到的最新的集合数据
                        mypindaolist.addAll(showChannels);
                        //适配器刷新
                        shouyeviewpager.notifyDataSetChanged();
                        //needShowPosition需要显示的默认位置-1
                        if(needShowPosition!=-1){
                            //如果不等于-1  viewpager显示当前位置
                            shouye_viewpager.setCurrentItem(needShowPosition);
                            //显示完之后重新等于默认值，等待下一次被赋值
                            needShowPosition=-1;
                        }
                    }
                });

            }
        }).start();
    }
}
