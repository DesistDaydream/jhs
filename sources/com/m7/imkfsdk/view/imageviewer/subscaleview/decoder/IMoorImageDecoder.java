package com.m7.imkfsdk.view.imageviewer.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface IMoorImageDecoder {
    @NonNull
    Bitmap decode(Context context, @NonNull Uri uri) throws Exception;
}
