package lyp.bawei.com.jinri.Bean;

import android.support.v4.app.Fragment;

import com.trs.channellib.channel.channel.ChannelEntity;

/**
 * Created by Administrator on 2017/3/27.
 */

public class PindaoBean implements ChannelEntity.ChannelEntityCreater{
    public String title;

    public int channelType;

    public int isFix;

    public int isSubscrible;
    public Fragment fragment;

    public PindaoBean(String title, int channelType, int isFix, int isSubscrible, Fragment fragment) {
        this.title = title;
        this.channelType = channelType;
        this.isFix = isFix;
        this.isSubscrible = isSubscrible;
        this.fragment = fragment;
    }
    @Override
    public ChannelEntity createChannelEntity() {
        ChannelEntity entity=new ChannelEntity();
        //是否是固定频道
        entity.setFixed(isFix==1);
        //显示的名称
        entity.setName(title);
        return entity;
    }
}
