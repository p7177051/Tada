package lyp.bawei.com.jinri.YangguangFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lyp.bawei.com.jinri.Bean.Redian;
import lyp.bawei.com.jinri.Myadapter.YangguangAdapter;
import lyp.bawei.com.jinri.R;

/**
 * Created by Administrator on 2017/3/19.
 */

public class RedianFragment extends Fragment{

    private ListView yangguang_listview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yangguang_fragment, null);
        yangguang_listview = (ListView) view.findViewById(R.id.yangguang_listview);
        getData();

        return view;
    }
    public void getData(){
        String url = "http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html";
        RequestParams params = new RequestParams(url);

        params.setCacheMaxAge(1000 * 60);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ArrayList<Redian> list=new ArrayList<Redian>();
                JSONObject resultObject = null;
                try {
                    resultObject = new JSONObject(result);
                    Iterator<String> keys = resultObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray nextArray = resultObject.optJSONArray(next);
                        for (int i = 0; i < nextArray.length(); i++) {
                            JSONObject object = nextArray.optJSONObject(i);
                            Redian redian = gson.fromJson(object.toString(), Redian.class);
                            list.add(redian);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                YangguangAdapter yangguangAdapter=new YangguangAdapter(getActivity(),list);
                yangguang_listview.setAdapter(yangguangAdapter);

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
