package com.tencent.qcloud.tuicore.component.gatherimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* loaded from: classes3.dex */
public interface Synthesizer {
    boolean asyncLoadImageList(MultiImageData multiImageData);

    void drawDrawable(Canvas canvas, MultiImageData multiImageData);

    Bitmap synthesizeImageList(MultiImageData multiImageData);
}
