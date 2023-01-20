package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.x.p;
import h.p2.b0.g.t.e.a.x.r;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements l<r, Boolean> {
    public final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.this$0 = classDeclaredMemberIndex;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(r rVar) {
        return Boolean.valueOf(invoke2(rVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d r rVar) {
        l lVar;
        lVar = this.this$0.b;
        return ((Boolean) lVar.invoke(rVar)).booleanValue() && !p.c(rVar);
    }
}
