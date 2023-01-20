package e.b.a.t.k;

import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes.dex */
public abstract class n<Z> extends b<Z> {
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9921c;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // e.b.a.t.k.p
    public final void getSize(@NonNull o oVar) {
        if (e.b.a.v.n.w(this.b, this.f9921c)) {
            oVar.e(this.b, this.f9921c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.b + " and height: " + this.f9921c + ", either provide dimensions in the constructor or call override()");
    }

    @Override // e.b.a.t.k.p
    public void removeCallback(@NonNull o oVar) {
    }

    public n(int i2, int i3) {
        this.b = i2;
        this.f9921c = i3;
    }
}
