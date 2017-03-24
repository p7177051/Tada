package lyp.bawei.com.jinri.Bean;

/**
 * Created by Administrator on 2017/3/23.
 */

public class ShoucangBean {
    private String imgurl;
    private String title;
    private String url;

    public ShoucangBean(String imgurl, String title, String url) {
        this.imgurl = imgurl;
        this.title = title;
        this.url = url;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
