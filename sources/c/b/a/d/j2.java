package c.b.a.d;

import androidx.camera.core.SafeCloseImageReaderProxy;

/* loaded from: classes.dex */
public final /* synthetic */ class j2 implements Runnable {
    public final /* synthetic */ SafeCloseImageReaderProxy a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.safeClose();
    }
}
