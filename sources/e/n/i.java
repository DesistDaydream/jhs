package e.n;

import h.k2.v.f0;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002J\u0006\u0010\b\u001a\u00020\tJ\t\u0010\n\u001a\u00020\u0002H\u0086\u0002J\r\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/live/LiveBool;", "Lcom/live/Live;", "", "default", "(Ljava/lang/Boolean;)V", "compareTo", "", "other", "inverse", "", "not", "requireValue", "()Ljava/lang/Boolean;", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class i extends f<Boolean> {
    public i() {
        this(null, 1, null);
    }

    public i(@k.e.a.e Boolean bool) {
        super(bool);
    }

    public final int s(boolean z) {
        Boolean value = getValue();
        if (value == null) {
            return -1;
        }
        boolean booleanValue = value.booleanValue();
        return f0.t(booleanValue ? 1 : 0, z ? 1 : 0);
    }

    public final void t() {
        setValue(Boolean.valueOf(u()));
    }

    public final boolean u() {
        Boolean value = getValue();
        if (value == null) {
            return false;
        }
        return !value.booleanValue();
    }

    @Override // e.n.f
    @k.e.a.d
    /* renamed from: v */
    public Boolean o() {
        Boolean value = getValue();
        return Boolean.valueOf(value == null ? false : value.booleanValue());
    }

    public /* synthetic */ i(Boolean bool, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : bool);
    }
}
