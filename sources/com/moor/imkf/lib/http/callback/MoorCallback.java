package com.moor.imkf.lib.http.callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public abstract class MoorCallback<T> {
    public static MoorCallback CALLBACK_DEFAULT = new MoorCallback() { // from class: com.moor.imkf.lib.http.callback.MoorCallback.1
        @Override // com.moor.imkf.lib.http.callback.MoorCallback
        public void onError(Call call, Exception exc, int i2) {
        }

        @Override // com.moor.imkf.lib.http.callback.MoorCallback
        public void onResponse(Object obj, int i2) {
        }

        @Override // com.moor.imkf.lib.http.callback.MoorCallback
        public Object parseNetworkResponse(Response response, int i2) throws Exception {
            return null;
        }
    };

    public void inProgress(float f2, long j2, int i2) {
    }

    public void onAfter(int i2) {
    }

    public void onBefore(Request request, int i2) {
    }

    public abstract void onError(Call call, Exception exc, int i2);

    public abstract void onResponse(T t, int i2);

    public abstract T parseNetworkResponse(Response response, int i2) throws Exception;

    public boolean validateReponse(Response response, int i2) {
        return response.isSuccessful();
    }
}
