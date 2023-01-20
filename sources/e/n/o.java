package e.n;

import h.k2.v.f0;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0086\u0002J\u0011\u0010\b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0086\u0002J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0086\u0002J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0086\u0002J\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002J\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\r\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002¨\u0006\u0010"}, d2 = {"Lcom/live/LiveLong;", "Lcom/live/Live;", "", "default", "(Ljava/lang/Long;)V", "compareTo", "", "other", "div", "", "", "minus", "plus", "requireValue", "()Ljava/lang/Long;", "times", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class o extends f<Long> {
    public o() {
        this(null, 1, null);
    }

    public o(@k.e.a.e Long l2) {
        super(l2);
    }

    public final long A(long j2) {
        return o().longValue() - j2;
    }

    public final double B(double d2) {
        return o().longValue() + d2;
    }

    public final float C(float f2) {
        return ((float) o().longValue()) + f2;
    }

    public final long D(int i2) {
        return o().longValue() + i2;
    }

    public final long E(long j2) {
        return o().longValue() + j2;
    }

    @Override // e.n.f
    @k.e.a.d
    /* renamed from: F */
    public Long o() {
        Long value = getValue();
        return Long.valueOf(value == null ? 0L : value.longValue());
    }

    public final double G(double d2) {
        return o().longValue() * d2;
    }

    public final float H(float f2) {
        return ((float) o().longValue()) * f2;
    }

    public final long I(int i2) {
        return o().longValue() * i2;
    }

    public final long J(long j2) {
        return o().longValue() * j2;
    }

    public final int s(int i2) {
        Long value = getValue();
        if (value == null) {
            return -1;
        }
        return f0.t((int) value.longValue(), i2);
    }

    public final double t(double d2) {
        return o().longValue() / d2;
    }

    public final float u(float f2) {
        return ((float) o().longValue()) / f2;
    }

    public final long v(int i2) {
        return o().longValue() / i2;
    }

    public final long w(long j2) {
        return o().longValue() / j2;
    }

    public final double x(double d2) {
        return o().longValue() - d2;
    }

    public final float y(float f2) {
        return ((float) o().longValue()) - f2;
    }

    public final long z(int i2) {
        return o().longValue() - i2;
    }

    public /* synthetic */ o(Long l2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : l2);
    }
}
