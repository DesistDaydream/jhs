package e.t.r.a.l;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/vector/network/image/glide/GlideDownloader;", "Lcom/vector/network/image/Downloader;", "()V", "downloadAsBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "", "width", "", "height", "downloadAsFile", "Ljava/io/File;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements e.t.r.a.c {
    @Override // e.t.r.a.c
    @k.e.a.d
    public Bitmap a(@k.e.a.d Context context, @k.e.a.d String str, int i2, int i3) {
        return a.j(context).m().v1(str).D1(i2, i3).get();
    }

    @Override // e.t.r.a.c
    @k.e.a.d
    public File b(@k.e.a.d Context context, @k.e.a.d String str, int i2, int i3) {
        return a.j(context).o().v1(str).D1(i2, i3).get();
    }
}
