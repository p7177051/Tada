package lyp.bawei.com.jinri.Myadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Bean.ShoucangBean;
import lyp.bawei.com.jinri.R;
import lyp.bawei.com.jinri.mydb.Mydb;

/**
 * Created by Administrator on 2017/3/23.
 */

public class GuanzhuAdapter extends BaseAdapter{
    private ArrayList<ShoucangBean> list;
    private Context context;

    public GuanzhuAdapter(ArrayList<ShoucangBean> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            convertView= convertView.inflate(context, R.layout.guanzhi_item,null);
            holder=new Holder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.guanzhu_item_img);
            holder.textView= (TextView) convertView.findViewById(R.id.guanzhu_item_text);
            holder.button= (Button) convertView.findViewById(R.id.guanzhu_item_button);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getTitle());
        Picasso.with(context).load(list.get(position).getImgurl()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*PopupWindow popupWindow = new PopupWindow();
                popupWindow.showAsDropDown(v);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());*/


                Mydb mydb=new Mydb(context);
                SQLiteDatabase writableDatabase = mydb.getWritableDatabase();
                String sql="delete from love where title=?";
                writableDatabase.execSQL(sql,new Object[]{list.get(position).getTitle()});
                list.remove(position);
                Log.e("ceshi", list.toString());
                notifyDataSetChanged();
                Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();

            }
        });
        return convertView;
    }
    class Holder{
        ImageView imageView;
        TextView textView;
        Button button;
    }
}
