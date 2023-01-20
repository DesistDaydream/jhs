package com.moor.imkf.http;

import com.moor.imkf.lib.http.MoorBaseHttpUtils;
import com.moor.imkf.lib.http.builder.MoorGetBuilder;
import com.moor.imkf.lib.http.builder.MoorPostFormBuilder;
import com.moor.imkf.lib.http.request.MoorRequestCall;
import java.util.concurrent.Executor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: classes2.dex */
public class MoorHttpUtils {
    private static volatile MoorHttpUtils mInstance;
    private MoorBaseHttpUtils mOkHttpClient = MoorBaseHttpUtils.getInstance();

    public static MoorRequestCall commonGet(Object obj, String str) {
        return get().url(str).tag(obj).build();
    }

    public static MoorRequestCall commonPost(Object obj, String str) {
        return post().url(str).tag(obj).build();
    }

    public static MoorGetBuilder get() {
        return new MoorGetBuilder(initBuilder());
    }

    public static MoorHttpUtils getInstance() {
        if (mInstance == null) {
            synchronized (MoorHttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new MoorHttpUtils();
                }
            }
        }
        return mInstance;
    }

    private static Request.Builder initBuilder() {
        return new Request.Builder();
    }

    public static MoorPostFormBuilder post() {
        return new MoorPostFormBuilder(initBuilder());
    }

    public void cancelAll() {
        MoorBaseHttpUtils.getInstance().cancelAll();
    }

    public void cancelTag(Object obj) {
        MoorBaseHttpUtils.getInstance().cancelTag(obj);
    }

    public Executor getDelivery() {
        return MoorBaseHttpUtils.getInstance().getmPlatform().defaultCallbackExecutor();
    }

    public OkHttpClient getOkHttpClient() {
        return MoorBaseHttpUtils.getInstance().getmOkHttpClient();
    }
}
