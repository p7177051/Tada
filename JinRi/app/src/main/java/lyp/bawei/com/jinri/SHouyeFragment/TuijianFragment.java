package lyp.bawei.com.jinri.SHouyeFragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import lyp.bawei.com.jinri.Activity.Xiangqing;
import lyp.bawei.com.jinri.Bean.ItemBean;
import lyp.bawei.com.jinri.Bean.STuijian;
import lyp.bawei.com.jinri.Myadapter.ShouyelistAdapter;
import lyp.bawei.com.jinri.R;
import lyp.bawei.com.jinri.mydb.Mydb;
import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * Created by Administrator on 2017/3/21.
 */

public class TuijianFragment extends Fragment{

    private XListView shouye_fragment_xlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_fragment, null);
        shouye_fragment_xlist = (XListView) view.findViewById(R.id.shouye_fragment_xlist);
        getData();
        shuaxin();
        return view;
    }
    public void getData(){
        String url ="http://lf.snssdk.com/api/news/feed/v51/?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489474181&last_refresh_sub_entrance_interval=1489474190&loc_mode=5&loc_time=1489084784&latitude=37.00125&longitude=110.56358166666665&city=%E5%90%95%E6%A2%81&tt_from=pull&lac=37142&cid=46142&cp=518fcb7a9d28eq1&iid=8742166056&device_id=35398884506&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=606&version_name=6.0.6&device_platform=android&ab_version=96766%2C111060%2C111305%2C101786%2C112146%2C111546%2C112157%2C101533%2C109464%2C110341%2C109891%2C109776%2C112072%2C106784%2C97142%2C111339%2C101558%2C104322%2C112166%2C109317%2C94043%2C105610%2C112343%2C105825%2C111316%2C108977%2C111798%2C111258%2C111581%2C108487%2C111897%2C110795%2C111418%2C98044%2C105475&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=vivo+Y31&device_brand=vivo&language=zh&os_api=19&os_version=4.4.2&uuid=864394010201061&openudid=206A8A39620A0000&manifest_version_code=605&resolution=720*1280&dpi=240&update_version_code=6060&_rticket=1489474190803";
        RequestParams params = new RequestParams(url);

        params.setCacheMaxAge(1000 * 60);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                STuijian sTuijian = gson.fromJson(result, STuijian.class);
                List<STuijian.DataBean> data = sTuijian.getData();
                ArrayList<ItemBean> list=new ArrayList<ItemBean>();
for (int i=0;i<data.size();i++){
    String content = data.get(i).getContent();
    ItemBean itemBean = gson.fromJson(content, ItemBean.class);
    list.add(itemBean);
}
                ShouyelistAdapter shouyelistAdapter=new ShouyelistAdapter(getActivity(),list);
                shouye_fragment_xlist.setAdapter(shouyelistAdapter);
                xiangqing(list);
                shoucang(list);
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
    public void shuaxin(){
        shouye_fragment_xlist.setPullRefreshEnable(true);
        shouye_fragment_xlist.setRefreshTime("刚刚");
        shouye_fragment_xlist.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                shouye_fragment_xlist.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                    }
                },2000);

                shouye_fragment_xlist.stopRefresh();

            }

            @Override
            public void onLoadMore() {

            }
        });
    }
    public void xiangqing(final ArrayList<ItemBean> list){
        shouye_fragment_xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Xiangqing.class);
                intent.putExtra("url",list.get(position-1).url);
                getActivity().overridePendingTransition(R.anim.activitynext, R.anim.activityone);
                startActivity(intent);
            }
        });
    }
    public void shoucang(final ArrayList<ItemBean> list){
        shouye_fragment_xlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Mydb mydb=new Mydb(getActivity());
                SQLiteDatabase writableDatabase = mydb.getWritableDatabase();
                String sql="insert into love(imgurl,url,title) values(?,?,?)";
                writableDatabase.execSQL(sql,new Object[]{list.get(position-1).image_list.get(0).url,list.get(position-1).url,list.get(position-1).title});
                Toast.makeText(getActivity(), "已经收藏", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}
