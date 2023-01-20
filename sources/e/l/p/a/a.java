package e.l.p.a;

import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.q.c.p0.c;
import h.k2.v.u;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class a {
    @d
    public static final C0394a b = new C0394a(null);
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final String f14121c = "shop";
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final String f14122d = "chat";
    @d

    /* renamed from: e  reason: collision with root package name */
    public static final String f14123e = "me";
    @d
    private final List<c> a;

    /* renamed from: e.l.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0394a {
        private C0394a() {
        }

        public /* synthetic */ C0394a(u uVar) {
            this();
        }
    }

    public a() {
        Res res = Res.a;
        this.a = CollectionsKt__CollectionsKt.P(new c(f14121c, R.drawable.ic_svg_shop, R.drawable.ic_svg_shop_, 0, Res.w(res, R.string.tab_shop, null, 2, null), 0, R.color.common_color_1, false, false, 0, 936, null), new c(f14122d, R.drawable.ic_svg_message, R.drawable.ic_svg_message_, 0, Res.w(res, R.string.tab_message, null, 2, null), 0, R.color.common_color_1, false, false, 0, 936, null), new c(f14123e, R.drawable.ic_svg_me, R.drawable.ic_svg_me_, 0, Res.w(res, R.string.tab_me, null, 2, null), 0, R.color.common_color_1, false, false, 0, 936, null));
    }

    @d
    public final List<c> a() {
        return this.a;
    }
}
