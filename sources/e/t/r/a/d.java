package e.t.r.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/vector/network/image/ImageDownloader;", "Lcom/vector/network/image/Downloader;", "()V", "downloadAsBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "", "width", "", "height", "downloadAsFile", "Ljava/io/File;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d implements c {
    @k.e.a.d
    public static final d b = new d();
    private final /* synthetic */ e.t.r.a.l.b a = new e.t.r.a.l.b();

    private d() {
    }

    @Override // e.t.r.a.c
    @k.e.a.d
    public Bitmap a(@k.e.a.d Context context, @k.e.a.d String str, int i2, int i3) {
        return this.a.a(context, str, i2, i3);
    }

    @Override // e.t.r.a.c
    @k.e.a.d
    public File b(@k.e.a.d Context context, @k.e.a.d String str, int i2, int i3) {
        return this.a.b(context, str, i2, i3);
    }
}
