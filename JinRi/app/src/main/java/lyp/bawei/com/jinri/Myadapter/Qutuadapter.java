package lyp.bawei.com.jinri.Myadapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Bean.ItemBean;
import lyp.bawei.com.jinri.R;

/**
 * Created by Administrator on 2017/3/25.
 */

public class Qutuadapter extends BaseAdapter{
    private ArrayList<ItemBean> list;
    private Context context;

    public Qutuadapter(ArrayList<ItemBean> list, Context context) {
        this.list = list;
        this.context = context;
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
        Holder holder;
        if(convertView==null){
           convertView= convertView.inflate(context, R.layout.tupian_item,null);
            holder=new Holder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.tupian_item_img);
            holder.textView= (TextView) convertView.findViewById(R.id.tupian_item_text);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).screen_name);
        Glide.with(context).load(list.get(position).large_image.url_list.get(0).url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.imageView);


        return convertView;
    }
    class Holder{
        TextView textView;
        ImageView imageView;
    }
}
