package c.b.d;

import android.view.PixelCopy;
import androidx.camera.view.SurfaceViewImplementation;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements PixelCopy.OnPixelCopyFinishedListener {
    public static final /* synthetic */ o a = new o();

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i2) {
        SurfaceViewImplementation.a(i2);
    }
}
