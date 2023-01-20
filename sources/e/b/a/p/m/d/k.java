package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class k implements e.b.a.p.g<ByteBuffer, Bitmap> {
    private final f a = new f();

    @Override // e.b.a.p.g
    @Nullable
    /* renamed from: c */
    public e.b.a.p.k.s<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        return this.a.b(ImageDecoder.createSource(byteBuffer), i2, i3, fVar);
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull e.b.a.p.f fVar) throws IOException {
        return true;
    }
}
