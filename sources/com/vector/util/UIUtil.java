package com.vector.util;

import h.k2.k;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\r\u0010\t\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/vector/util/UIUtil;", "", "()V", "navigationBarHeight", "", "getNavigationBarHeight$annotations", "getNavigationBarHeight", "()I", "navigationBarHeight$delegate", "Lkotlin/Lazy;", "statusBarHeight", "getStatusBarHeight$annotations", "getStatusBarHeight", "statusBarHeight$delegate", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIUtil {
    @d
    public static final UIUtil a = new UIUtil();
    @d
    private static final w b = z.c(UIUtil$statusBarHeight$2.INSTANCE);
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final w f7919c = z.c(UIUtil$navigationBarHeight$2.INSTANCE);

    private UIUtil() {
    }

    public static final int a() {
        return ((Number) f7919c.getValue()).intValue();
    }

    @k
    public static /* synthetic */ void b() {
    }

    public static final int c() {
        return ((Number) b.getValue()).intValue();
    }

    @k
    public static /* synthetic */ void d() {
    }
}
