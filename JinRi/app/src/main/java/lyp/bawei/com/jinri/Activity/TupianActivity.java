package lyp.bawei.com.jinri.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lyp.bawei.com.jinri.Myadapter.TupianContentAdapter;
import lyp.bawei.com.jinri.R;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2017/3/23.
 */
public class TupianActivity extends Activity{

    private ViewPager tupiancontent_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tupiancontent);
        tupiancontent_viewpager = (ViewPager) findViewById(R.id.tupiancontent_viewpager);
        Intent intent = getIntent();
        ArrayList<String> tupian = intent.getStringArrayListExtra("tupian");
        ArrayList<PhotoView> imglist=new ArrayList<PhotoView>();
        for (int i=0;i<tupian.size();i++){
            String temp = tupian.get(i);
            PhotoView img=new PhotoView(this);
            if(i!=0){
                temp = temp.replace("list", "list/300x196");
            }
            Log.e("========", tupian.get(i));
            Picasso.with(TupianActivity.this).load(temp).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(img);
            imglist.add(img);
        }
        TupianContentAdapter tupianContentAdapter=new TupianContentAdapter(imglist);
        tupiancontent_viewpager.setAdapter(tupianContentAdapter);
    }

}
