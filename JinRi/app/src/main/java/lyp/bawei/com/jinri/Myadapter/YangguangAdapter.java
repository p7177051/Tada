package lyp.bawei.com.jinri.Myadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import lyp.bawei.com.jinri.Bean.Redian;
import lyp.bawei.com.jinri.R;

/**
 * Created by Administrator on 2017/3/19.
 */

public class YangguangAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Redian> list;


    public YangguangAdapter(Context context, ArrayList<Redian> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
if(convertView==null){
    convertView=convertView.inflate(context, R.layout.yangguang_item,null);
    myHolder=new MyHolder();
    myHolder.count= (TextView) convertView.findViewById(R.id.item_count);
    myHolder.jc= (JCVideoPlayerStandard) convertView.findViewById(R.id.yangguiang_item_jiecao);
    myHolder.name= (TextView) convertView.findViewById(R.id.item_name);
    myHolder.fenxiang= (TextView) convertView.findViewById(R.id.item_fenxiao);
    convertView.setTag(myHolder);
}else {
    myHolder= (MyHolder) convertView.getTag();
}
        myHolder.count.setText(list.get(position).getPlayCount()+"播放");
        myHolder.name.setText(list.get(position).getTopicName());
        myHolder.jc.setUp(list.get(position).getMp4_url(),list.get(position).getTitle());

        ImageView thumbImageView = myHolder.jc.thumbImageView;
        thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(context).load(list.get(position).getCover()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(thumbImageView);
        myHolder.fenxiang.setText("分享");
        myHolder.fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "fenxiang", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    class MyHolder{
        JCVideoPlayerStandard jc;
        TextView name;
        TextView count;
        TextView fenxiang;
    }
}
