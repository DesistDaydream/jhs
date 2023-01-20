package e.b.a.u;

import android.content.Context;
import androidx.annotation.NonNull;
import e.b.a.v.n;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class a implements e.b.a.p.c {

    /* renamed from: c  reason: collision with root package name */
    private final int f9935c;

    /* renamed from: d  reason: collision with root package name */
    private final e.b.a.p.c f9936d;

    private a(int i2, e.b.a.p.c cVar) {
        this.f9935c = i2;
        this.f9936d = cVar;
    }

    @NonNull
    public static e.b.a.p.c a(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f9935c == aVar.f9935c && this.f9936d.equals(aVar.f9936d);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return n.q(this.f9936d, this.f9935c);
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f9936d.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f9935c).array());
    }
}
