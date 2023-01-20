package com.tencent.qcloud.tuicore.component.imageEngine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public interface ImageEngine {
    void loadGifImage(Context context, int i2, int i3, ImageView imageView, Uri uri);

    void loadGifThumbnail(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri);

    void loadImage(Context context, int i2, int i3, ImageView imageView, Uri uri);

    void loadThumbnail(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri);

    boolean supportAnimatedGif();
}
