package com.moor.imkf.lib.http.request;

import com.moor.imkf.lib.http.MoorBaseHttpUtils;
import com.moor.imkf.lib.http.callback.MoorCallback;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class MoorRequestCall {
    private Call call;
    private OkHttpClient clone;
    private long connTimeOut;
    private MoorHttpRequest okHttpRequest;
    private long readTimeOut;
    private Request request;
    private long writeTimeOut;

    public MoorRequestCall(MoorHttpRequest moorHttpRequest) {
        this.okHttpRequest = moorHttpRequest;
    }

    private Request generateRequest(MoorCallback moorCallback) {
        return this.okHttpRequest.generateRequest(moorCallback);
    }

    public Call buildCall(MoorCallback moorCallback) {
        this.request = generateRequest(moorCallback);
        long j2 = this.readTimeOut;
        if (j2 <= 0 && this.writeTimeOut <= 0 && this.connTimeOut <= 0) {
            this.call = MoorBaseHttpUtils.getInstance().getmOkHttpClient().newCall(this.request);
        } else {
            if (j2 <= 0) {
                j2 = 15;
            }
            this.readTimeOut = j2;
            long j3 = this.writeTimeOut;
            if (j3 <= 0) {
                j3 = 15;
            }
            this.writeTimeOut = j3;
            long j4 = this.connTimeOut;
            this.connTimeOut = j4 > 0 ? j4 : 15L;
            OkHttpClient.Builder newBuilder = MoorBaseHttpUtils.getInstance().getmOkHttpClient().newBuilder();
            long j5 = this.readTimeOut;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient build = newBuilder.readTimeout(j5, timeUnit).writeTimeout(this.writeTimeOut, timeUnit).connectTimeout(this.connTimeOut, timeUnit).build();
            this.clone = build;
            this.call = build.newCall(this.request);
        }
        return this.call;
    }

    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    public MoorRequestCall connTimeOut(long j2) {
        this.connTimeOut = j2;
        return this;
    }

    public void execute(MoorCallback moorCallback) {
        buildCall(moorCallback);
        if (moorCallback != null) {
            moorCallback.onBefore(this.request, getOkHttpRequest().getId());
        }
        MoorBaseHttpUtils.getInstance().execute(this, moorCallback);
    }

    public Call getCall() {
        return this.call;
    }

    public MoorHttpRequest getOkHttpRequest() {
        return this.okHttpRequest;
    }

    public Request getRequest() {
        return this.request;
    }

    public MoorRequestCall readTimeOut(long j2) {
        this.readTimeOut = j2;
        return this;
    }

    public MoorRequestCall writeTimeOut(long j2) {
        this.writeTimeOut = j2;
        return this;
    }

    public Response execute() throws IOException {
        buildCall(null);
        return this.call.execute();
    }
}
