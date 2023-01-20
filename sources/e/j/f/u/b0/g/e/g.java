package e.j.f.u.b0.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class g extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final int f11606d = 4;

    public g(e.j.f.q.a aVar) {
        super(aVar);
    }

    @Override // e.j.f.u.b0.g.e.j
    public String d() throws NotFoundException, FormatException {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(b().f(4, 4));
        g(sb, 8, length);
        return b().a(sb, 48);
    }
}
