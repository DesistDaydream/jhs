package com.vivo.push.b;

import com.baidu.mobads.sdk.internal.bc;
import com.qq.e.comm.constants.ErrorCode;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class a extends c {
    private ArrayList<String> a;

    public a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? ErrorCode.INNER_ERROR : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(bc.f1477l, this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(bc.f1477l);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
