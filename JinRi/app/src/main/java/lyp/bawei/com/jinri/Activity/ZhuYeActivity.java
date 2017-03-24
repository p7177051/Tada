package lyp.bawei.com.jinri.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.umeng.socialize.UMShareAPI;

import lyp.bawei.com.jinri.Fragment.Guanzhu;
import lyp.bawei.com.jinri.Fragment.Shouye;
import lyp.bawei.com.jinri.Fragment.Yangguang;
import lyp.bawei.com.jinri.R;
import lyp.bawei.com.jinri.Utiles.ThemeManager;

/**
 * Created by Administrator on 2017/3/10.
 */
public class ZhuYeActivity extends FragmentActivity implements View.OnClickListener  {

    private FrameLayout zhouye_framelayout;
    private RadioGroup zhouye_group;
    private Button zhuye_shouye;
    private Button zhuye_guanzhu;
    private Button zhuye_denglu;
    private Button zhuye_yangguang;
    private FragmentManager supportFragmentManager;

    private Guanzhu guanzhu;
    private Shouye shouye;
    private Yangguang yangguang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuye);

        init();
        getfragment();
    }
    public void init(){
        zhouye_framelayout = (FrameLayout) findViewById(R.id.zhouye_framelayout);
        zhouye_group = (RadioGroup) findViewById(R.id.zhouye_group);

        zhuye_shouye = (Button) findViewById(R.id.zhuye_shouye);
        zhuye_guanzhu = (Button) findViewById(R.id.zhuye_guanzhu);
        zhuye_yangguang = (Button) findViewById(R.id.zhuye_yangguang);
        zhuye_shouye.setOnClickListener(this);
        zhuye_guanzhu.setOnClickListener(this);
        zhuye_yangguang.setOnClickListener(this);
    }
    public void getfragment(){


        guanzhu = new Guanzhu();
        shouye = new Shouye();
        yangguang = new Yangguang();

        zhouye_group.check(R.id.zhuye_shouye);
        //得到管理者
        supportFragmentManager = getSupportFragmentManager();
//开启事物
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//添加到布局
        fragmentTransaction.add(R.id.zhouye_framelayout, shouye,"benshe");
        fragmentTransaction.add(R.id.zhouye_framelayout, yangguang,"luxing");
        fragmentTransaction.add(R.id.zhouye_framelayout, guanzhu,"ziwo");

//控制隐藏显示
        fragmentTransaction.show(shouye);
        fragmentTransaction.hide(yangguang);
        fragmentTransaction.hide(guanzhu);

//提交事务
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhuye_shouye:
                FragmentTransaction f1 = supportFragmentManager.beginTransaction();
                f1.show(shouye);
                f1.hide(yangguang);
                f1.hide(guanzhu);

//提交事务
                f1.commit();
                break;
            case R.id.zhuye_guanzhu:
                FragmentTransaction f2 = supportFragmentManager.beginTransaction();
                f2.show(guanzhu);
                f2.hide(yangguang);
                f2.hide(shouye);

//提交事务
                f2.commit();
                break;

            case R.id.zhuye_yangguang:
                FragmentTransaction f4= supportFragmentManager.beginTransaction();
                f4.show(yangguang);

                f4.hide(shouye);
                f4.hide(guanzhu);
//提交事务
                f4.commit();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
