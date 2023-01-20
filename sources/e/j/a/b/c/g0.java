package e.j.a.b.c;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class g0 extends e0 {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakReference<byte[]> f10133d = new WeakReference<>(null);

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<byte[]> f10134c;

    public g0(byte[] bArr) {
        super(bArr);
        this.f10134c = f10133d;
    }

    @Override // e.j.a.b.c.e0
    public final byte[] b0() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f10134c.get();
            if (bArr == null) {
                bArr = d0();
                this.f10134c = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] d0();
}
