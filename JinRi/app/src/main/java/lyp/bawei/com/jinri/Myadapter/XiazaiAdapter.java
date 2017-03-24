package lyp.bawei.com.jinri.Myadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lyp.bawei.com.jinri.Bean.Xiazai;
import lyp.bawei.com.jinri.R;

/**
 * Created by Administrator on 2017/3/17.
 */

public class XiazaiAdapter extends BaseAdapter{
    private Context context;
    private List<Xiazai.AppBean> list;
private ArrayList<String> arraylist;

    public XiazaiAdapter(Context context, List<Xiazai.AppBean> list, ArrayList<String> arraylist) {
        this.context = context;
        this.list = list;
        this.arraylist = arraylist;
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
        Holder holder=null;
        if(convertView==null){
            convertView= convertView.inflate(context, R.layout.xiazai_item, null);
            holder=new Holder();
            holder.checkBox= (CheckBox) convertView.findViewById(R.id.xiazai_item_box);
            holder.text= (TextView) convertView.findViewById(R.id.xiazai_item_text);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
holder.text.setText(list.get(position).getName());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).isFlag()){
                    list.get(position).setFlag(false);
                    arraylist.remove(list.get(position).getUrl());
                }else {
                    list.get(position).setFlag(true);
                    arraylist.add(list.get(position).getUrl());
                }
            }
        });
        return convertView;
    }
  class Holder{
      TextView text;
      CheckBox checkBox;
  }
}
