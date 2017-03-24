package lyp.bawei.com.jinri.Utiles;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/3/10.
 */

public class XutileApplication extends Application{
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
        UMShareAPI.get(this);
        Config.DEBUG = true;
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
