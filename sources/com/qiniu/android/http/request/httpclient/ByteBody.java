package com.qiniu.android.http.request.httpclient;

import j.n;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class ByteBody extends RequestBody {
    private static final int SEGMENT_SIZE = 16384;
    private final byte[] body;
    private final MediaType mediaType;

    public ByteBody(MediaType mediaType, byte[] bArr) {
        this.mediaType = mediaType;
        this.body = bArr;
    }

    private RequestBody getRequestBodyWithRange(int i2, int i3) {
        return RequestBody.create(contentType(), Arrays.copyOfRange(this.body, i2, i3 + i2));
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.body.length;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.mediaType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(n nVar) throws IOException {
        int i2 = 0;
        int i3 = 16384;
        while (true) {
            byte[] bArr = this.body;
            if (i2 >= bArr.length) {
                return;
            }
            i3 = Math.min(i3, bArr.length - i2);
            getRequestBodyWithRange(i2, i3).writeTo(nVar);
            nVar.flush();
            i2 += i3;
        }
    }
}
