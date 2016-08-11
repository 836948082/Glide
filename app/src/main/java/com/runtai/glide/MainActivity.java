package com.runtai.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {

    public static final String RESOURCE = "android.resource://";
    public static final String SLASH = "/";

    private String path = "/androidesk/wallpapers/57484f7869401b103938f52a.jpg";
    private int resId = R.mipmap.ic_launcher;
    private String url_img = "http://p4.so.qhimg.com/t010c102c7b029340d4.jpg";
    private String url_gif = "http://pic.uuhy.com/uploads/2011/02/11/005.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ImageView iv = (ImageView) findViewById(R.id.iv);

        /**
             //加载资源中的图片
             Glide.with(context).load(R.drawable.ic_launcher).into(iv);
             //加载文件中的图片
             File file = new File(Environment.getExternalStorageDirectory().getPath() + path);
             Glide.with(context).load(file).into(iv);
             //加载Uri中的图片
             Uri uri = Uri.parse(RESOURCE + getPackageName() + SLASH + resId);
             Glide.with(context).load(uri).into(iv);
             //加载网络图片
             Glide.with(context).load(url_img).into(iv);
         */


        /**
         * 使用缓存
         * diskCacheStrategy(DiskCacheStrategy.SOURCE)
         * 为其添加缓存策略,其中缓存策略可以为:Source及None,None及为不缓存,Source为缓存原型.  如果为ALL和Result就不行
         */
        Glide.with(MainActivity.this).load(url_gif).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);

        /**
         * 不使用缓存
         */
        Glide.with(this).load(url_gif).into(iv);
    }

}