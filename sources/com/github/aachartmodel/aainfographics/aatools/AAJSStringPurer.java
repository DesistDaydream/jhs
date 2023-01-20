package com.github.aachartmodel.aainfographics.aatools;

import h.t2.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AAJSStringPurer;", "", "", "JSStr", "pureJavaScriptFunctionString", "(Ljava/lang/String;)Ljava/lang/String;", "pureAnonymousJSFunctionString", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAJSStringPurer {
    public static final AAJSStringPurer INSTANCE = new AAJSStringPurer();

    private AAJSStringPurer() {
    }

    @e
    public final String pureAnonymousJSFunctionString(@e String str) {
        return pureJavaScriptFunctionString('(' + str + ')');
    }

    @d
    public final String pureJavaScriptFunctionString(@d String str) {
        return u.k2(u.k2(u.k2(u.k2(u.k2(u.k2(u.k2(u.k2(u.k2(u.k2(str, "'", "\"", false, 4, null), "\u0000", "", false, 4, null), "\n", "", false, 4, null), "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "'", "\\'", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\u2028", "\\u2028", false, 4, null), "\u2029", "\\u2029", false, 4, null);
    }
}
