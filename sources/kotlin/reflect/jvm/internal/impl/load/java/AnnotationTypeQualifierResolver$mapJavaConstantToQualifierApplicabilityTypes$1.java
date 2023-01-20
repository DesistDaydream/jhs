package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.p;
import h.k2.v.f0;
import h.p2.b0.g.t.k.n.i;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 extends Lambda implements p<i, AnnotationQualifierApplicabilityType, Boolean> {
    public static final AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 INSTANCE = new AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1();

    public AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1() {
        super(2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(i iVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(iVar, annotationQualifierApplicabilityType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d i iVar, @d AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return f0.g(iVar.b().getIdentifier(), annotationQualifierApplicabilityType.getJavaTarget());
    }
}
