package com.yalantis.ucrop.callback;

import android.net.Uri;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(@NonNull Uri uri, int i2, int i3, int i4, int i5);

    void onCropFailure(@NonNull Throwable th);
}
