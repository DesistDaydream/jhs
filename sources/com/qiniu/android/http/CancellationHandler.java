package com.qiniu.android.http;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface CancellationHandler {

    /* loaded from: classes3.dex */
    public static class CancellationException extends IOException {
    }

    boolean isCancelled();
}
