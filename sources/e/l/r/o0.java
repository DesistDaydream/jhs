package e.l.r;

import com.jihuanshe.model.GlobalConfig;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.vector.util.SpEx;

/* loaded from: classes2.dex */
public final class o0 extends SpEx {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final o0 f14291c = new o0();
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14292d = TUIConfig.GLOBAL_CONFIG;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private static GlobalConfig f14293e;

    private o0() {
    }

    @Override // com.vector.util.SpEx
    @k.e.a.d
    public String e() {
        return TUIConfig.COMMON_SP;
    }

    @k.e.a.d
    public final String t() {
        return f14292d;
    }

    @k.e.a.e
    public final GlobalConfig u() {
        if (f14293e == null) {
            String o = o(f14292d);
            f14293e = (GlobalConfig) (o == null ? null : i().n(o, GlobalConfig.class));
        }
        return f14293e;
    }

    public final void v(@k.e.a.d GlobalConfig globalConfig) {
        f14293e = globalConfig;
        q(f14292d, f0.a.d(globalConfig));
    }
}
