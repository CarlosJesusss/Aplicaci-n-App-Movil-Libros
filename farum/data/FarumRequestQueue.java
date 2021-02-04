package com.teamcjz.farum.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class FarumRequestQueue {

    private static FarumRequestQueue instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private FarumRequestQueue(Context context){
        ctx = context;
        this.requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(this.requestQueue == null){
            this.requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }

        return this.requestQueue;
    }

    public static synchronized FarumRequestQueue getInstance(Context context){
        if(instance == null){
            instance = new FarumRequestQueue(context);
        }

        return instance;
    }


    public <T> void addToReqquestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

}
