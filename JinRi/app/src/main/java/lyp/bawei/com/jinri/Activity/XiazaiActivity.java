package lyp.bawei.com.jinri.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.jiguang.net.HttpUtils;
import lyp.bawei.com.jinri.Bean.Xiazai;
import lyp.bawei.com.jinri.Myadapter.XiazaiAdapter;
import lyp.bawei.com.jinri.R;

import static android.R.attr.path;

/**
 * Created by Administrator on 2017/3/17.
 */

public class XiazaiActivity extends Activity{


    private ListView xiazai_listview;
    private Button xiazai_xiazaibutton;
private ArrayList<String> list=new ArrayList<>();
    private ProgressBar xiazai_seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiazai);
        xiazai_listview = (ListView) findViewById(R.id.xiazai_listview);
        xiazai_seekbar = (ProgressBar) findViewById(R.id.xiazai_seekbar);

        xiazai_xiazaibutton = (Button) findViewById(R.id.xiazai_xiazaibutton);
        getxiazaidata();
       getclick();

    }
   public void getclick(){
       xiazai_xiazaibutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
if(list!=null){
    for (int i=0;i<list.size();i++){
        String url=list.get(i);
        RequestParams params = new RequestParams(url);
        params.setSaveFilePath(Environment.getExternalStorageDirectory() + "/app/");
        //自动为文件命令
        params.setAutoRename(true);
        x.http().post(params, new Callback.ProgressCallback<File>(){
            @Override
            public void onSuccess(File result) {
                Toast.makeText(XiazaiActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                //apk下载完成后 调用系统的安装方法
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(result), "application/vnd.android.package-archive");
                startActivity(intent);
                Toast.makeText(XiazaiActivity.this, "安装成功", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
            @Override
            public void onWaiting() {
            }
            @Override
            public void onStarted() {
            }
            //下载的时候不断回调的方法
            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                int i1 = new Long(total).intValue();
                int i2 = new Long(current).intValue();
                xiazai_seekbar.setMax(i1);
                xiazai_seekbar.setProgress(i2);
                if(total==current){
                    xiazai_seekbar.setProgress(0);
                    Toast.makeText(XiazaiActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
           }
       });
   }
    public void getxiazaidata(){
        RequestParams params = new RequestParams("http://mapp.qzone.qq.com/cgi-bin/mapp/mapp_subcatelist_qq?yyb_cateid=-10&categoryName=%E8%85%BE%E8%AE%AF%E8%BD%AF%E4%BB%B6&pageNo=1&pageSize=20&type=app&platform=touch&network_type=unknown&resolution=412x732");
        params.setCacheMaxAge(1000 * 60);

        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                String substring = result.substring(0, result.length() - 1);

                Toast.makeText(XiazaiActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                List<Xiazai.AppBean> app = gson.fromJson(substring, Xiazai.class).getApp();

                XiazaiAdapter xiazaiAdapter=new XiazaiAdapter(XiazaiActivity.this,app,list);
                xiazai_listview.setAdapter(xiazaiAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        });

    }

}
