package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import e.j.c.a.a.a;
import java.util.Collections;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class SingleImageProxyBundle implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    public SingleImageProxyBundle(@NonNull ImageProxy imageProxy, @NonNull String str) {
        ImageInfo imageInfo = imageProxy.getImageInfo();
        if (imageInfo != null) {
            Integer num = (Integer) imageInfo.getTagBundle().getTag(str);
            if (num != null) {
                this.mCaptureId = num.intValue();
                this.mImageProxy = imageProxy;
                return;
            }
            throw new IllegalArgumentException("ImageProxy has no associated tag");
        }
        throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
    }

    public void close() {
        this.mImageProxy.close();
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public List<Integer> getCaptureIds() {
        return Collections.singletonList(Integer.valueOf(this.mCaptureId));
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public a<ImageProxy> getImageProxy(int i2) {
        if (i2 != this.mCaptureId) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("Capture id does not exist in the bundle"));
        }
        return Futures.immediateFuture(this.mImageProxy);
    }

    public SingleImageProxyBundle(@NonNull ImageProxy imageProxy, int i2) {
        this.mCaptureId = i2;
        this.mImageProxy = imageProxy;
    }
}
