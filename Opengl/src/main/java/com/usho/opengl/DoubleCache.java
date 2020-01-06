package com.usho.opengl;

import android.graphics.Bitmap;

/**
 * 项目名称：PACKAGE_NAME
 * 类描述：
 * 作者：   admin .
 * 日期：   2020/1/6 .
 * 公司： Usho Network Tech. Co., Ltd&lt;br&gt;
 */
public class DoubleCache {
    ImageCache imageCache = new ImageCache();
    DiskCache diskCache = new DiskCache();

    public Bitmap get(String url) {
        Bitmap bitmap = imageCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    public void put(String url,Bitmap bitmap) {
        imageCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }
}
