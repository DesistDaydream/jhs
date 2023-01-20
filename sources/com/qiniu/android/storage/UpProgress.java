package com.qiniu.android.storage;

import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.LogUtil;

/* loaded from: classes3.dex */
public class UpProgress {
    private final UpProgressHandler handler;
    private volatile long maxProgressUploadBytes = -1;
    private volatile long previousUploadBytes = 0;

    public UpProgress(UpProgressHandler upProgressHandler) {
        this.handler = upProgressHandler;
    }

    public void notifyDone(final String str, final long j2) {
        UpProgressHandler upProgressHandler = this.handler;
        if (upProgressHandler == null) {
            return;
        }
        if (upProgressHandler instanceof UpProgressBytesHandler) {
            AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.3
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("key:" + str + " progress uploadBytes:" + j2 + " totalBytes:" + j2);
                    String str2 = str;
                    long j3 = j2;
                    ((UpProgressBytesHandler) UpProgress.this.handler).progress(str2, j3, j3);
                }
            });
        } else {
            AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.4
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("key:" + str + " progress:1");
                    UpProgress.this.handler.progress(str, 1.0d);
                }
            });
        }
    }

    public void progress(final String str, final long j2, final long j3) {
        if (this.handler == null || j2 < 0) {
            return;
        }
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i2 <= 0 || j2 <= j3) {
            if (i2 > 0) {
                if (this.maxProgressUploadBytes < 0) {
                    this.maxProgressUploadBytes = (long) (j3 * 0.95d);
                }
                if (j2 > this.maxProgressUploadBytes) {
                    return;
                }
            }
            if (j2 > this.previousUploadBytes) {
                this.previousUploadBytes = j2;
                if (this.handler instanceof UpProgressBytesHandler) {
                    AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LogUtil.i("key:" + str + " progress uploadBytes:" + j2 + " totalBytes:" + j3);
                            ((UpProgressBytesHandler) UpProgress.this.handler).progress(str, j2, j3);
                        }
                    });
                } else if (i2 < 0) {
                } else {
                    final double d2 = j2 / j3;
                    AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.2
                        @Override // java.lang.Runnable
                        public void run() {
                            LogUtil.i("key:" + str + " progress:" + d2);
                            UpProgress.this.handler.progress(str, d2);
                        }
                    });
                }
            }
        }
    }
}
