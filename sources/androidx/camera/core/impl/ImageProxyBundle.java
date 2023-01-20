package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import e.j.c.a.a.a;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ImageProxyBundle {
    @NonNull
    List<Integer> getCaptureIds();

    @NonNull
    a<ImageProxy> getImageProxy(int i2);
}
