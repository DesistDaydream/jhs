package kotlin.reflect.jvm.internal.impl.utils;

import h.a2.t0;
import h.k2.v.u;
import h.w;
import h.z;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public final class JavaTypeEnhancementState {
    @d

    /* renamed from: i  reason: collision with root package name */
    public static final a f16888i = new a(null);
    @h.k2.d
    @d

    /* renamed from: j  reason: collision with root package name */
    public static final ReportLevel f16889j;
    @h.k2.d
    @d

    /* renamed from: k  reason: collision with root package name */
    public static final JavaTypeEnhancementState f16890k;
    @h.k2.d
    @d

    /* renamed from: l  reason: collision with root package name */
    public static final JavaTypeEnhancementState f16891l;
    @h.k2.d
    @d

    /* renamed from: m  reason: collision with root package name */
    public static final JavaTypeEnhancementState f16892m;
    @d
    private final ReportLevel a;
    @e
    private final ReportLevel b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ReportLevel> f16893c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16894d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final ReportLevel f16895e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final w f16896f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f16897g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16898h;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        ReportLevel reportLevel = ReportLevel.WARN;
        f16889j = reportLevel;
        f16890k = new JavaTypeEnhancementState(reportLevel, null, t0.z(), false, null, 24, null);
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        f16891l = new JavaTypeEnhancementState(reportLevel2, reportLevel2, t0.z(), false, null, 24, null);
        ReportLevel reportLevel3 = ReportLevel.STRICT;
        f16892m = new JavaTypeEnhancementState(reportLevel3, reportLevel3, t0.z(), false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(@d ReportLevel reportLevel, @e ReportLevel reportLevel2, @d Map<String, ? extends ReportLevel> map, boolean z, @d ReportLevel reportLevel3) {
        this.a = reportLevel;
        this.b = reportLevel2;
        this.f16893c = map;
        this.f16894d = z;
        this.f16895e = reportLevel3;
        this.f16896f = z.c(new JavaTypeEnhancementState$description$2(this));
        ReportLevel reportLevel4 = ReportLevel.IGNORE;
        boolean z2 = true;
        boolean z3 = reportLevel == reportLevel4 && reportLevel2 == reportLevel4 && map.isEmpty();
        this.f16897g = z3;
        if (!z3 && reportLevel3 != reportLevel4) {
            z2 = false;
        }
        this.f16898h = z2;
    }

    public final boolean a() {
        return this.f16898h;
    }

    public final boolean b() {
        return this.f16897g;
    }

    public final boolean c() {
        return this.f16894d;
    }

    @d
    public final ReportLevel d() {
        return this.a;
    }

    @d
    public final ReportLevel e() {
        return this.f16895e;
    }

    @e
    public final ReportLevel f() {
        return this.b;
    }

    @d
    public final Map<String, ReportLevel> g() {
        return this.f16893c;
    }

    public /* synthetic */ JavaTypeEnhancementState(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, boolean z, ReportLevel reportLevel3, int i2, u uVar) {
        this(reportLevel, reportLevel2, map, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? f16889j : reportLevel3);
    }
}
