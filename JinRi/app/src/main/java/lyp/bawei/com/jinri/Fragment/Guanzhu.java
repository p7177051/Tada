package lyp.bawei.com.jinri.Fragment;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Activity.Xiangqing;
import lyp.bawei.com.jinri.Bean.ShoucangBean;
import lyp.bawei.com.jinri.Myadapter.GuanzhuAdapter;
import lyp.bawei.com.jinri.R;
import lyp.bawei.com.jinri.mydb.Mydb;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Guanzhu extends Fragment{

    private ListView guanzhu_listview;
Mydb mydb=null;
    private ArrayList<ShoucangBean> getdb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guanzhu, null);
        guanzhu_listview = (ListView) view.findViewById(R.id.guanzhu_listview);
        lookall();
        return view;

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            getdb = getdb();
            GuanzhuAdapter guanzhuAdapter=new GuanzhuAdapter(getdb,getActivity());
            guanzhu_listview.setAdapter(guanzhuAdapter);
        }
    }

    public ArrayList<ShoucangBean> getdb(){
        mydb=new Mydb(getActivity());
        SQLiteDatabase readableDatabase = mydb.getReadableDatabase();
        String sql="select * from love";
        Cursor cursor = readableDatabase.rawQuery(sql, null);
        ArrayList<ShoucangBean> list=new ArrayList<ShoucangBean>();
        while (cursor.moveToNext()){
            String imgurl = cursor.getString(1);
            String title = cursor.getString(2);
            String url = cursor.getString(3);
            ShoucangBean shoucangBean=new ShoucangBean(imgurl,title,url);
            list.add(shoucangBean);
        }
        return list;
    }
   public void lookall(){
       guanzhu_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(getActivity(), Xiangqing.class);
               intent.putExtra("url",getdb.get(position).getUrl());
               startActivity(intent);
           }
       });
   }
}
