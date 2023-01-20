package com.moor.imkf.lib.http;

import androidx.annotation.NonNull;
import com.moor.imkf.lib.http.callback.MoorCallback;
import com.moor.imkf.lib.http.https.MoorHttpsUtils;
import com.moor.imkf.lib.http.log.MoorHttpLoggingInterceptor;
import com.moor.imkf.lib.http.request.MoorRequestCall;
import com.moor.imkf.lib.http.utils.MoorPlatform;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class MoorBaseHttpUtils {
    public static final long DEFAULT_SECONDS = 15;
    private static volatile MoorBaseHttpUtils mInstance;
    private final OkHttpClient mOkHttpClient;
    private final MoorPlatform mPlatform;

    public MoorBaseHttpUtils(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            MoorHttpsUtils.SSLParams sslSocketFactory = MoorHttpsUtils.getSslSocketFactory(null, null, null);
            OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(new MoorHttpLoggingInterceptor());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.mOkHttpClient = addInterceptor.connectTimeout(15L, timeUnit).readTimeout(15L, timeUnit).hostnameVerifier(new HostnameVerifier() { // from class: com.moor.imkf.lib.http.MoorBaseHttpUtils.1
                {
                    MoorBaseHttpUtils.this = this;
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            }).sslSocketFactory(sslSocketFactory.sSLSocketFactory, sslSocketFactory.trustManager).build();
        } else {
            this.mOkHttpClient = okHttpClient;
        }
        this.mPlatform = MoorPlatform.get();
    }

    public static MoorBaseHttpUtils getInstance() {
        return initClient(null);
    }

    public static MoorBaseHttpUtils initClient(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (MoorBaseHttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new MoorBaseHttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public void cancelAll() {
        for (Call call : this.mOkHttpClient.dispatcher().queuedCalls()) {
            call.cancel();
        }
        for (Call call2 : this.mOkHttpClient.dispatcher().runningCalls()) {
            call2.cancel();
        }
    }

    public void cancelTag(Object obj) {
        for (Call call : this.mOkHttpClient.dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : this.mOkHttpClient.dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public void execute(MoorRequestCall moorRequestCall, final MoorCallback moorCallback) {
        if (moorCallback == null) {
            moorCallback = MoorCallback.CALLBACK_DEFAULT;
        }
        final int id = moorRequestCall.getOkHttpRequest().getId();
        moorRequestCall.getCall().enqueue(new Callback() { // from class: com.moor.imkf.lib.http.MoorBaseHttpUtils.2
            {
                MoorBaseHttpUtils.this = this;
            }

            @Override // okhttp3.Callback
            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                MoorBaseHttpUtils.this.sendFailResultCallback(call, iOException, moorCallback, id);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                try {
                    try {
                    } catch (Exception e2) {
                        MoorBaseHttpUtils.this.sendFailResultCallback(call, e2, moorCallback, id);
                        if (response.body() == null) {
                            return;
                        }
                    }
                    if (call.isCanceled()) {
                        MoorBaseHttpUtils.this.sendFailResultCallback(call, new IOException("Canceled!"), moorCallback, id);
                        if (response.body() != null) {
                            response.body().close();
                        }
                    } else if (!moorCallback.validateReponse(response, id)) {
                        MoorBaseHttpUtils moorBaseHttpUtils = MoorBaseHttpUtils.this;
                        moorBaseHttpUtils.sendFailResultCallback(call, new IOException("request failed , response's code is : " + response.code()), moorCallback, id);
                        if (response.body() != null) {
                            response.body().close();
                        }
                    } else {
                        MoorBaseHttpUtils.this.sendSuccessResultCallback(moorCallback.parseNetworkResponse(response, id), moorCallback, id);
                        if (response.body() == null) {
                            return;
                        }
                        response.body().close();
                    }
                } catch (Throwable th) {
                    if (response.body() != null) {
                        response.body().close();
                    }
                    throw th;
                }
            }
        });
    }

    public OkHttpClient getmOkHttpClient() {
        return this.mOkHttpClient;
    }

    public MoorPlatform getmPlatform() {
        return this.mPlatform;
    }

    public void sendFailResultCallback(final Call call, final Exception exc, final MoorCallback moorCallback, final int i2) {
        if (moorCallback == null) {
            return;
        }
        getInstance().getmPlatform().execute(new Runnable() { // from class: com.moor.imkf.lib.http.MoorBaseHttpUtils.3
            {
                MoorBaseHttpUtils.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                moorCallback.onError(call, exc, i2);
                moorCallback.onAfter(i2);
            }
        });
    }

    public void sendSuccessResultCallback(final Object obj, final MoorCallback moorCallback, final int i2) {
        if (moorCallback == null) {
            return;
        }
        getInstance().getmPlatform().execute(new Runnable() { // from class: com.moor.imkf.lib.http.MoorBaseHttpUtils.4
            {
                MoorBaseHttpUtils.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                moorCallback.onResponse(obj, i2);
                moorCallback.onAfter(i2);
            }
        });
    }
}
