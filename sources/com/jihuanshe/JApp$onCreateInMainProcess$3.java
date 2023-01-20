package com.jihuanshe;

import com.jihuanshe.JApp;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class JApp$onCreateInMainProcess$3 extends Lambda implements l<String, t1> {
    public final /* synthetic */ JApp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JApp$onCreateInMainProcess$3(JApp jApp) {
        super(1);
        this.this$0 = jApp;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e String str) {
        boolean z;
        if (f0.g(str, "401") || f0.g(str, BinderKt.b)) {
            if (UserKV.f3913c.u().length() > 0) {
                z = this.this$0.f3743f;
                if (!z) {
                    JApp.f3735g.b();
                    return;
                }
                JApp.a aVar = JApp.f3735g;
                JApp.f3739k = true;
            }
        }
    }
}
