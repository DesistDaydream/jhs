package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.IOException;

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class f extends e.b.a.p.m.a<Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9753d = "BitmapImageDecoder";

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.k.x.e f9754c = new e.b.a.p.k.x.f();

    @Override // e.b.a.p.m.a
    public e.b.a.p.k.s<Bitmap> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(f9753d, 2)) {
            Log.v(f9753d, "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]");
        }
        return new g(decodeBitmap, this.f9754c);
    }
}
