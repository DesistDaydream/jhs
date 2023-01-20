package e.n;

import h.k2.v.f0;
import h.k2.v.u;
import h.t2.s;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0013\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\u0002J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\r\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/live/LiveString;", "Lcom/live/Live;", "", "default", "(Ljava/lang/String;)V", "isNullOrEmpty", "", "plus", "other", "", "plusAssign", "", "requireValue", "toFloatOrNull", "", "()Ljava/lang/Float;", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class p extends f<String> {
    public p() {
        this(null, 1, null);
    }

    public p(@k.e.a.e String str) {
        super(str);
    }

    public final boolean s() {
        String value = getValue();
        return value == null || value.length() == 0;
    }

    @k.e.a.d
    public final String t(@k.e.a.e Object obj) {
        return f0.C(o(), obj);
    }

    public final void u(@k.e.a.e Object obj) {
        setValue(t(obj));
    }

    @Override // e.n.f
    @k.e.a.d
    /* renamed from: v */
    public String o() {
        String value = getValue();
        return value == null ? "" : value;
    }

    @k.e.a.e
    public final Float w() {
        String value = getValue();
        if (value == null) {
            return null;
        }
        return s.J0(value);
    }

    public /* synthetic */ p(String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str);
    }
}
