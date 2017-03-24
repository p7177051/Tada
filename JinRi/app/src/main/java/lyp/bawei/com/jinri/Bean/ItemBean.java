package lyp.bawei.com.jinri.Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/14.
 */
public class ItemBean {
    public String comment_count;
    public boolean has_image;
    public boolean has_video;
    public ArrayList<Img> image_list;
    public ArrayList<LargeImg> large_image_list;
    public MiddleImg middle_image;
    public String source;
    public String url;
    public String title;
    public String repin_count;


    public class Img{
        public String url;
    }
    public class MiddleImg{
        public String url;
    }
    public class LargeImg{
        public String url;
    }





}
