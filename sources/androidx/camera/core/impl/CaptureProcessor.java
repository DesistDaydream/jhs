package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e.j.c.a.a.a;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CaptureProcessor {
    void close();

    @NonNull
    a<Void> getCloseFuture();

    void onOutputSurface(Surface surface, int i2);

    void onResolutionUpdate(Size size);

    void process(ImageProxyBundle imageProxyBundle);
}
