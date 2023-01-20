package com.jihuanshe.viewmodel;

import com.eth.model.NetException;
import com.jihuanshe.net.api.FileInfo;
import e.g.e.a;
import e.l.h.k.b;
import h.k2.u.l;
import h.r0;
import h.t1;
import i.b.n;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class UploadViewModel$uploadFileToSeven$2$1$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ n<FileInfo> $continuation;
    public final /* synthetic */ UploadViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadViewModel$uploadFileToSeven$2$1$2(UploadViewModel uploadViewModel, n<? super FileInfo> nVar) {
        super(1);
        this.this$0 = uploadViewModel;
        this.$continuation = nVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        b bVar = b.a;
        String str = this.this$0.b;
        String h2 = aVar.h();
        if (h2 == null) {
            h2 = "";
        }
        bVar.b(str, h2);
        n<FileInfo> nVar = this.$continuation;
        String h3 = aVar.h();
        if (h3 == null) {
            h3 = "";
        }
        NetException netException = new NetException("", h3);
        Result.a aVar2 = Result.Companion;
        nVar.resumeWith(Result.m106constructorimpl(r0.a(netException)));
    }
}
