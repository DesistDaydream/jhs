package e.b.a.p.m.e;

import androidx.annotation.NonNull;
import e.b.a.p.k.s;
import e.b.a.v.l;

/* loaded from: classes.dex */
public class b implements s<byte[]> {
    private final byte[] a;

    public b(byte[] bArr) {
        this.a = (byte[]) l.d(bArr);
    }

    @Override // e.b.a.p.k.s
    @NonNull
    /* renamed from: a */
    public byte[] get() {
        return this.a;
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return this.a.length;
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
    }
}
