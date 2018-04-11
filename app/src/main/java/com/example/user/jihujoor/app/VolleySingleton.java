package com.example.user.jihujoor.app;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
/**
 * Created by ADMIN on 11-04-2018.
 */
public class VolleySingleton {

    private static VolleySingleton sInstance;
    private ImageLoader imageLoader;
    private static RequestQueue requestQueue;

    private VolleySingleton()
    {
        RequestQueue mRequestQueue = AppController.getInstance().getRequestQueue();
        imageLoader=new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {

            private LruCache<String,Bitmap> cache=new LruCache((int)(Runtime.getRuntime().maxMemory()/1024/8));
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }
    public ImageLoader getImageLoader()
    {
        return this.imageLoader;
    }
    public static VolleySingleton getInstance(){
        if (sInstance==null)
            sInstance=new VolleySingleton();

        return sInstance;
    }

    public static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            requestQueue = new RequestQueue(cache, network);
        }
        return requestQueue;
    }

}