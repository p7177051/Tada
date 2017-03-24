package lyp.bawei.com.jinri.Myadapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2017/3/23.
 */

public class TupianContentAdapter extends PagerAdapter{
private ArrayList<PhotoView> list;

    public TupianContentAdapter(ArrayList<PhotoView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(list.get(position));
    }
}
