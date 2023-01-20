package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.d;
import h.p2.h;
import k.e.a.e;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class AnnotationTypeQualifierResolver$resolvedNicknames$1 extends FunctionReference implements l<d, c> {
    public AnnotationTypeQualifierResolver$resolvedNicknames$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(1, annotationTypeQualifierResolver);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @k.e.a.d
    public final String getName() {
        return "computeTypeQualifierNickname";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @k.e.a.d
    public final h getOwner() {
        return n0.d(AnnotationTypeQualifierResolver.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @k.e.a.d
    public final String getSignature() {
        return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
    }

    @Override // h.k2.u.l
    @e
    public final c invoke(@k.e.a.d d dVar) {
        c c2;
        c2 = ((AnnotationTypeQualifierResolver) this.receiver).c(dVar);
        return c2;
    }
}
