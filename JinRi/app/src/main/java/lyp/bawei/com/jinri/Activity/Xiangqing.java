package lyp.bawei.com.jinri.Activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lyp.bawei.com.jinri.R;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by Administrator on 2017/3/23.
 */

public class Xiangqing extends SwipeBackActivity{

    private WebView xiangqing_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiangqing);
        xiangqing_webview = (WebView) findViewById(R.id.xiangqing_webview);

        SwipeBackLayout mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setScrimColor(Color.TRANSPARENT);
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");





        WebSettings settings = xiangqing_webview.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        xiangqing_webview.setWebViewClient(new WebViewClient());

        xiangqing_webview.loadUrl(url);



    }
    public void onBackPressed() {
        //关闭这个Activity
        scrollToFinishActivity();
    }
}
