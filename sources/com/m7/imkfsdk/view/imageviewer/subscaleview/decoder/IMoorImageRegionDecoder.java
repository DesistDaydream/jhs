package com.m7.imkfsdk.view.imageviewer.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface IMoorImageRegionDecoder {
    @NonNull
    Bitmap decodeRegion(@NonNull Rect rect, int i2);

    @NonNull
    Point init(Context context, @NonNull Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
