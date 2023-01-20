package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class j implements e.b.a.p.g<ByteBuffer, Bitmap> {
    private final o a;

    public j(o oVar) {
        this.a = oVar;
    }

    @Override // e.b.a.p.g
    /* renamed from: c */
    public e.b.a.p.k.s<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        return this.a.f(e.b.a.v.a.f(byteBuffer), i2, i3, fVar);
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull e.b.a.p.f fVar) {
        return this.a.q(byteBuffer);
    }
}
