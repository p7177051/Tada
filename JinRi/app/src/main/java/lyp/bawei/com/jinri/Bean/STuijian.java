package lyp.bawei.com.jinri.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */

public class STuijian {


    private int login_status;
    private int total_number;
    private boolean has_more;
    private String post_content_hint;
    private int show_et_status;
    private int feed_flag;
    private int action_to_last_stick;
    private String message;
    private boolean has_more_to_refresh;
    private TipsBean tips;
    private List<DataBean> data;

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getPost_content_hint() {
        return post_content_hint;
    }

    public void setPost_content_hint(String post_content_hint) {
        this.post_content_hint = post_content_hint;
    }

    public int getShow_et_status() {
        return show_et_status;
    }

    public void setShow_et_status(int show_et_status) {
        this.show_et_status = show_et_status;
    }

    public int getFeed_flag() {
        return feed_flag;
    }

    public void setFeed_flag(int feed_flag) {
        this.feed_flag = feed_flag;
    }

    public int getAction_to_last_stick() {
        return action_to_last_stick;
    }

    public void setAction_to_last_stick(int action_to_last_stick) {
        this.action_to_last_stick = action_to_last_stick;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHas_more_to_refresh() {
        return has_more_to_refresh;
    }

    public void setHas_more_to_refresh(boolean has_more_to_refresh) {
        this.has_more_to_refresh = has_more_to_refresh;
    }

    public TipsBean getTips() {
        return tips;
    }

    public void setTips(TipsBean tips) {
        this.tips = tips;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TipsBean {
        /**
         * display_info : 今日头条推荐引擎有11条更新
         * open_url :
         * web_url :
         * app_name : 今日头条
         * package_name :
         * display_template : 今日头条推荐引擎有%s条更新
         * type : app
         * display_duration : 2
         * download_url :
         */

        private String display_info;
        private String open_url;
        private String web_url;
        private String app_name;
        private String package_name;
        private String display_template;
        private String type;
        private int display_duration;
        private String download_url;

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public String getOpen_url() {
            return open_url;
        }

        public void setOpen_url(String open_url) {
            this.open_url = open_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getDisplay_template() {
            return display_template;
        }

        public void setDisplay_template(String display_template) {
            this.display_template = display_template;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDisplay_duration() {
            return display_duration;
        }

        public void setDisplay_duration(int display_duration) {
            this.display_duration = display_duration;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }
    }

    public static class DataBean {
        /**
         * content : {"read_count": 463311, "media_name": "\u592e\u89c6\u65b0\u95fb", "ban_comment": 0, "abstract": "\u5728\u9655\u5317\uff0c\u4ed6\u201c\u770b\u5230\u4e86\u4eba\u6c11\u7fa4\u4f17\u7684\u6839\u672c\uff0c\u771f\u6b63\u7406\u89e3\u4e86\u8001\u767e\u59d3\u201d\uff1b\u5728\u6b63\u5b9a\uff0c\u4ed6\u5b9e\u73b0\u4e86\u6539\u5584\u519c\u6c11\u751f\u6d3b\u7684\u627f\u8bfa\uff1b\u572880\u5e74\u4ee3\u672b\u7684\u5b81\u5fb7\uff0c\u4ed6\u8bf4\u201c\u5f53\u5b98\u4e0d\u8981\u60f3\u53d1\u8d22\u201d\u3002\u8ddf\u968f\u592e\u89c6\u539f\u521b\u5fae\u89c6\u9891\uff0c\u4e00\u8d77\u8ffd\u5bfb\u4e60\u8fd1\u5e73\u603b\u4e66\u8bb0\u7684\u521d\u5fc3\u3002", "image_list": [], "has_video": false, "article_type": 0, "tag": "news_politics", "has_m3u8_video": 0, "keywords": "\u5fae\u89c6\u9891,\u5b81\u5fb7\u5730\u533a,\u5f20\u5fd7\u575a,\u5b81\u5fb7,\u8001\u767e\u59d3,\u4e1c\u65b9\u65f6\u7a7a", "rid": "20170321134807172017214004486F15", "label": "\u7f6e\u9876", "show_portrait_article": false, "user_verified": 1, "aggr_type": 1, "cell_type": 0, "article_sub_type": 0, "bury_count": 0, "title": "\u592e\u89c6\u539f\u521b\u5fae\u89c6\u9891\u300a\u521d\u5fc3\u300b\uff5c\u5728\u798f\u5efa\u5b81\u5fb7\uff0c\u4e60\u8fd1\u5e73\u8bf4\u4e86\u54ea\u53e5\u63b7\u5730\u6709\u58f0\u7684\u8bdd\uff1f", "ignore_web_transform": 1, "source_icon_style": 4, "tip": 0, "hot": 0, "share_url": "http://toutiao.com/group/6399054668421185793/?iid=8742166056&app=news_article", "has_mp4_video": 0, "source": "\u592e\u89c6\u65b0\u95fb", "comment_count": 64, "article_url": "http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&mid=2656575968&idx=3&sn=280142d456e98570bedcb4d3ff76ebda", "filter_words": [], "share_count": 1027, "stick_label": "\u7f6e\u9876", "publish_time": 1489896066, "action_list": [{"action": 1, "extra": {}, "desc": ""}, {"action": 3, "extra": {}, "desc": ""}, {"action": 7, "extra": {}, "desc": ""}, {"action": 9, "extra": {}, "desc": ""}], "has_image": true, "cell_layout_style": 1, "tag_id": 6399054668421185793, "video_style": 0, "verified_content": "\u4e2d\u592e\u7535\u89c6\u53f0\u65b0\u95fb\u4e2d\u5fc3\u5b98\u65b9\u5e10\u53f7", "display_url": "http://toutiao.com/group/6399054668421185793/", "is_stick": true, "large_image_list": [], "item_id": 6399059923199590914, "is_subject": false, "stick_style": 1, "show_portrait": false, "repin_count": 3153, "cell_flag": 11, "user_info": {"verified_content": "\u4e2d\u592e\u7535\u89c6\u53f0\u65b0\u95fb\u4e2d\u5fc3\u5b98\u65b9\u5e10\u53f7", "avatar_url": "http://p3.pstatp.com/thumb/4306/2602403105", "user_id": 4492956276, "name": "\u592e\u89c6\u65b0\u95fb", "follower_count": 0, "follow": false, "user_auth_info": "{\"auth_type\": \"0\", \"auth_info\": \"\u4e2d\u592e\u7535\u89c6\u53f0\u65b0\u95fb\u4e2d\u5fc3\u5b98\u65b9\u5e10\u53f7\"}", "user_verified": true, "description": ""}, "source_open_url": "sslocal://profile?uid=4492956276", "level": 0, "like_count": 9, "digg_count": 9, "behot_time": 1490075287, "cursor": 1490075287999, "url": "http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&mid=2656575968&idx=3&sn=280142d456e98570bedcb4d3ff76ebda", "preload_web": 1, "user_repin": 0, "label_style": 1, "item_version": 0, "media_info": {"user_id": 4492956276, "verified_content": "", "avatar_url": "http://p2.pstatp.com/large/4306/2602403105", "media_id": 4492956276, "name": "\u592e\u89c6\u65b0\u95fb", "recommend_type": 0, "follow": false, "recommend_reason": "", "is_star_user": false, "user_verified": true}, "group_id": 6399054668421185793, "middle_image": {"url": "http://p2.pstatp.com/list/300x196/199200106c6adcfaa7fc.webp", "width": 960, "url_list": [{"url": "http://p2.pstatp.com/list/300x196/199200106c6adcfaa7fc.webp"}, {"url": "http://p4.pstatp.com/list/300x196/199200106c6adcfaa7fc.webp"}, {"url": "http://p.pstatp.com/list/300x196/199200106c6adcfaa7fc.webp"}], "uri": "list/199200106c6adcfaa7fc", "height": 540}, "gallary_image_count": 7}
         * code :
         */

        private String content;
        private String code;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
