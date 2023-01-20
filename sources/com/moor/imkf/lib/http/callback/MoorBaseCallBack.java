package com.moor.imkf.lib.http.callback;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONException;

/* loaded from: classes2.dex */
public abstract class MoorBaseCallBack<T> extends MoorCallback<T> {
    @Override // com.moor.imkf.lib.http.callback.MoorCallback
    public void onError(Call call, Exception exc, int i2) {
        if (!(exc instanceof JSONException) && !(exc instanceof JsonIOException) && !(exc instanceof JsonSyntaxException)) {
            exc.printStackTrace();
        } else {
            onParser(exc, i2);
        }
    }

    public void onParser(Exception exc, int i2) {
        exc.printStackTrace();
    }

    @Override // com.moor.imkf.lib.http.callback.MoorCallback
    public void onResponse(T t, int i2) {
        if (t != null) {
            onSuccess(t, i2);
        }
    }

    public abstract void onSuccess(T t, int i2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
    @Override // com.moor.imkf.lib.http.callback.MoorCallback
    public T parseNetworkResponse(Response response, int i2) throws Exception {
        ?? r3 = (T) unBunding(response.body().string());
        if (r3 == 0) {
            return null;
        }
        if (getClass().getGenericSuperclass() == MoorBaseCallBack.class || ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0] == String.class) {
            return r3;
        }
        return (T) new Gson().o(r3, C$Gson$Types.b(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
    }

    public String unBunding(String str) throws JSONException {
        return str;
    }
}
