package e.n;

import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0011\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002J\u0011\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\r\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/live/LiveFloat;", "Lcom/live/Live;", "", "default", "(Ljava/lang/Float;)V", "minus", "other", "", "minusAssign", "", "plus", "plusAssign", "requireValue", "()Ljava/lang/Float;", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class k extends f<Float> {
    public k() {
        this(null, 1, null);
    }

    public k(@k.e.a.e Float f2) {
        super(f2);
    }

    @Override // e.n.f
    @k.e.a.d
    /* renamed from: A */
    public Float o() {
        Float value = getValue();
        return Float.valueOf(value == null ? 0.0f : value.floatValue());
    }

    public final float s(float f2) {
        return o().floatValue() - f2;
    }

    public final float t(int i2) {
        return o().floatValue() - i2;
    }

    public final void u(float f2) {
        setValue(Float.valueOf(s(f2)));
    }

    public final void v(int i2) {
        setValue(Float.valueOf(t(i2)));
    }

    public final float w(float f2) {
        return o().floatValue() + f2;
    }

    public final float x(int i2) {
        return o().floatValue() + i2;
    }

    public final void y(float f2) {
        setValue(Float.valueOf(w(f2)));
    }

    public final void z(int i2) {
        setValue(Float.valueOf(x(i2)));
    }

    public /* synthetic */ k(Float f2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : f2);
    }
}
