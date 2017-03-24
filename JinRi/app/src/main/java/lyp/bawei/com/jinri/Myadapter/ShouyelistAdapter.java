package lyp.bawei.com.jinri.Myadapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Bean.ItemBean;
import lyp.bawei.com.jinri.R;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ShouyelistAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<ItemBean> list;

    public ShouyelistAdapter(Context context, ArrayList<ItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        ItemBean news = list.get(position);
//   Log.i("图片信")
        if (news.has_image) {
            if (news.image_list.size() ==3) {
                //上面TextView+下面3张图片  item0
                return 1;
            } else if (news.image_list.size() == 0 && news.large_image_list.size() != 0) {
                //上面TextView+下面一张图片   item1
                return 2;
            } else if (news.image_list.size() == 0 && news.large_image_list.size() == 0 && news.middle_image.url != null) {
                //左边TextView+右边Img   item2
                return 0;
            }else{
                //纯文本显示 item3
                return 3;
            }
        }else if (news.has_video&&news.large_image_list.size()!=0){
            if (news.large_image_list.size()!=0){
                return 2;
            }else if(news.middle_image.url!=null){

                return 2;

            }else{
                return 3;
            }
            //返回一个上面textView  下面一张大图片的视图 item1
        }else{
            return 3;
        }


    }

    @Override
    public int getViewTypeCount() {
        return 4;
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
        int itemViewType = getItemViewType(position);
        Myholder0 myholder0=null;
        Myholder1 myholder1=null;
        Myholder2 myholder2=null;
        Myholder3 myholder3=null;
        if(convertView==null){
    switch (itemViewType){
        case 0:
            convertView= View.inflate(context, R.layout.shouye_tuijian_item1, null);
            myholder0=new Myholder0();
            myholder0.textView= (TextView) convertView.findViewById(R.id.tuijian_item1_text);
            myholder0.img= (ImageView) convertView.findViewById(R.id.tuijian_item1_img);
            convertView.setTag(myholder0);
            break;
        case 1:
            convertView= View.inflate(context, R.layout.shoute_item2, null);
            myholder1=new Myholder1();
            myholder1.textView= (TextView) convertView.findViewById(R.id.sitem2_text);
            myholder1.img1= (ImageView) convertView.findViewById(R.id.sitem2_img1);
            myholder1.img2= (ImageView) convertView.findViewById(R.id.sitem2_img2);
            myholder1.img3= (ImageView) convertView.findViewById(R.id.sitem2_img3);
            convertView.setTag(myholder1);
            break;
        case 2:
            convertView= View.inflate(context, R.layout.shouye_item3, null);
            myholder2=new Myholder2();
            myholder2.textView= (TextView) convertView.findViewById(R.id.sitem3_text);
            myholder2.img= (ImageView) convertView.findViewById(R.id.sitem3_img);
            convertView.setTag(myholder2);
            break;
        case 3:
            convertView= View.inflate(context, R.layout.shouye_item4, null);
            myholder3=new Myholder3();
            myholder3.textView= (TextView) convertView.findViewById(R.id.tuijian_item4_text);
            convertView.setTag(myholder3);
            break;
    }
}else {
            switch (itemViewType){
                case 0:
                    myholder0= (Myholder0) convertView.getTag();
                    break;
                case 1:
                    myholder1= (Myholder1) convertView.getTag();
                    break;
                case 2:
                    myholder2= (Myholder2) convertView.getTag();
                    break;
                case 3:
                    myholder3= (Myholder3) convertView.getTag();
                    break;
            }

        }
        switch (itemViewType){
            case 0:
                myholder0.textView.setText(list.get(position).title);
                //Log.e("holder0",list.get(position).middle_image.url);
                Picasso.with(context).load(list.get(position).middle_image.url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myholder0.img);
                break;
            case 1:
                myholder1.textView.setText(list.get(position).title);
                Picasso.with(context).load(list.get(position).image_list.get(0).url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myholder1.img1);
                Picasso.with(context).load(list.get(position).image_list.get(1).url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myholder1.img2);
                Picasso.with(context).load(list.get(position).image_list.get(2).url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myholder1.img3);
                break;
            case 2:
                myholder2.textView.setText(list.get(position).title);
                Picasso.with(context).load(list.get(position).large_image_list.get(0).url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myholder2.img);
                break;
            case 3:
                myholder3.textView.setText(list.get(position).title);
                break;
        }
        return convertView;
    }
    class Myholder0{
       TextView textView;
        ImageView img;
    }
    class  Myholder1{
        TextView textView;
        ImageView img1;
        ImageView img2;
        ImageView img3;
    }
    class Myholder2{
        TextView textView;
        ImageView img;
    }
    class Myholder3{
        TextView textView;
    }
}
