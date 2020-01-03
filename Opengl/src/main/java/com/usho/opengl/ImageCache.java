package com.usho.opengl;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 项目名称：com.usho.opengl
 * 类描述：
 * 作者：   admin .
 * 日期：   2020/1/3 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class ImageCache {
    LruCache<String,Bitmap> lruCache;

    public ImageCache() {
        initImageCache();
    }

    private void initImageCache() {
       int macMemory= (int) (Runtime.getRuntime().maxMemory()/1024);
       int cacheSize=macMemory/4;
       lruCache=new LruCache<String, Bitmap>(cacheSize){
           @Override
           protected int sizeOf(String key, Bitmap value) {
               return value.getByteCount()/1024;
           }
       };
    }

    public  void  put(String url,Bitmap bitmap){
        lruCache.put(url,bitmap);
    }
    public Bitmap get(String url){
        return lruCache.get(url);
    }
}
