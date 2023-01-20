package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.h;
import java.lang.reflect.Member;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$fields$1 extends FunctionReference implements l<Member, Boolean> {
    public static final ReflectJavaClass$fields$1 INSTANCE = new ReflectJavaClass$fields$1();

    public ReflectJavaClass$fields$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "isSynthetic";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(Member.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
        return Boolean.valueOf(invoke2(member));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d Member member) {
        return member.isSynthetic();
    }
}
