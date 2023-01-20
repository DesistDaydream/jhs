package com.qiniu.android.http.request.httpclient;

import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.utils.AsyncRun;
import j.k0;
import j.m;
import j.n;
import j.q;
import j.z;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public final class CountingRequestBody extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private final RequestBody body;
    private final CancellationHandler cancellationHandler;
    private final ProgressHandler progress;
    private final long totalSize;

    /* loaded from: classes3.dex */
    public final class CountingSink extends q {
        private int bytesWritten;

        public CountingSink(k0 k0Var) {
            super(k0Var);
            this.bytesWritten = 0;
        }

        @Override // j.q, j.k0
        public void write(m mVar, long j2) throws IOException {
            if (CountingRequestBody.this.cancellationHandler != null || CountingRequestBody.this.progress != null) {
                if (CountingRequestBody.this.cancellationHandler != null && CountingRequestBody.this.cancellationHandler.isCancelled()) {
                    throw new CancellationHandler.CancellationException();
                }
                super.write(mVar, j2);
                this.bytesWritten = (int) (this.bytesWritten + j2);
                if (CountingRequestBody.this.progress != null) {
                    AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.http.request.httpclient.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.progress.onProgress(CountingSink.this.bytesWritten, CountingRequestBody.this.totalSize);
                        }
                    });
                    return;
                }
                return;
            }
            super.write(mVar, j2);
        }
    }

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j2, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.progress = progressHandler;
        this.totalSize = j2;
        this.cancellationHandler = cancellationHandler;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.body.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.body.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(n nVar) throws IOException {
        n c2 = z.c(new CountingSink(nVar));
        this.body.writeTo(c2);
        c2.flush();
    }
}
