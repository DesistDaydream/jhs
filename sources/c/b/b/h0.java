package c.b.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageReaderProxy;

/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements ImageReaderProxy.OnImageAvailableListener {
    public static final /* synthetic */ h0 a = new h0();

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageCapture.g(imageReaderProxy);
    }
}
