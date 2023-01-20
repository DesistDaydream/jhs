package e.l.s.p;

import android.net.Uri;
import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.vector.util.Res;
import com.vector.util.UIUtil;
import e.l.h.l.b;
import e.n.i;
import e.n.l;
import e.n.p;
import e.t.o.d;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class a extends b {
    @d
    public static final C0401a p = new C0401a(null);
    @d
    public static final String q = "navBarVisible";
    @d
    public static final String r = "1";
    private final int b = UIUtil.c();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final i f14366c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final i f14367d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final p f14368e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final p f14369f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final p f14370g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final i f14371h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final i f14372i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final l f14373j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final i f14374k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final l f14375l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final l f14376m;
    @d
    private final i n;
    @d
    private final i o;

    /* renamed from: e.l.s.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0401a {
        private C0401a() {
        }

        public /* synthetic */ C0401a(u uVar) {
            this();
        }
    }

    public a() {
        Boolean bool = Boolean.FALSE;
        this.f14366c = new i(bool);
        Boolean bool2 = Boolean.TRUE;
        this.f14367d = new i(bool2);
        this.f14368e = new p(null, 1, null);
        this.f14369f = new p(null, 1, null);
        this.f14370g = new p(null, 1, null);
        this.f14371h = new i(bool);
        this.f14372i = new i(bool);
        this.f14373j = new l(Integer.valueOf(Res.k(R.color.black)));
        this.f14374k = new i(bool);
        this.f14375l = new l(Integer.valueOf((int) R.drawable.icon_back));
        this.f14376m = new l(Integer.valueOf((int) R.drawable.svg_close));
        this.n = new i(bool);
        this.o = new i(bool2);
    }

    public final int A0() {
        return this.b;
    }

    @d
    public final i B0() {
        return this.f14366c;
    }

    @d
    public final p C0() {
        return this.f14368e;
    }

    @d
    public final l D0() {
        return this.f14373j;
    }

    @e
    public final User E0() {
        return UserKV.f3913c.w();
    }

    @d
    public final i F0() {
        return this.o;
    }

    public final boolean p0(@d String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(q);
            if (queryParameter == null) {
                return true;
            }
            return StringsKt__StringsKt.S2(queryParameter, "1", true);
        } catch (Exception unused) {
            return true;
        }
    }

    @d
    public final i q0() {
        return this.f14367d;
    }

    @d
    public final l r0() {
        return this.f14375l;
    }

    @d
    public final l s0() {
        return this.f14376m;
    }

    @d
    public final i t0() {
        return this.n;
    }

    public final int u0(int i2) {
        return d.a.c(e.t.o.d.a, null, 1, null).d(i2);
    }

    @k.e.a.d
    public final i v0() {
        return this.f14374k;
    }

    @k.e.a.d
    public final i w0() {
        return this.f14372i;
    }

    @k.e.a.d
    public final p x0() {
        return this.f14369f;
    }

    @k.e.a.d
    public final i y0() {
        return this.f14371h;
    }

    @k.e.a.d
    public final p z0() {
        return this.f14370g;
    }
}
