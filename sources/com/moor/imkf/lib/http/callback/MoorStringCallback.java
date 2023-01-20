package com.moor.imkf.lib.http.callback;

import java.io.IOException;
import okhttp3.Response;

/* loaded from: classes2.dex */
public abstract class MoorStringCallback extends MoorCallback<String> {
    @Override // com.moor.imkf.lib.http.callback.MoorCallback
    public String parseNetworkResponse(Response response, int i2) throws IOException {
        return response.body().string();
    }
}
