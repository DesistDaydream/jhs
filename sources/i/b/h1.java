package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Li/b/h1;", "Li/b/v1;", "", "toString", "()Ljava/lang/String;", "", am.av, "Z", "j", "()Z", "isActive", "Li/b/m2;", "c", "()Li/b/m2;", "list", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class h1 implements v1 {
    private final boolean a;

    public h1(boolean z) {
        this.a = z;
    }

    @Override // i.b.v1
    @k.e.a.e
    public m2 c() {
        return null;
    }

    @Override // i.b.v1
    public boolean j() {
        return this.a;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(j() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
