package lyp.bawei.com.jinri.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lyp.bawei.com.jinri.R;
import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * Created by Administrator on 2017/3/14.
 */

public class Shouye_fragment extends Fragment{

    private XListView shouye_fragment_xlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.shouye_fragment, null);
        shouye_fragment_xlist = (XListView) inflate.findViewById(R.id.shouye_fragment_xlist);

        return inflate;
    }
}
