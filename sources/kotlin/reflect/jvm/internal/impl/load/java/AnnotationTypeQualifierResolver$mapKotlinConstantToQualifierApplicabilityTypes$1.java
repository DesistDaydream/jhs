package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.p;
import h.p2.b0.g.t.k.n.i;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1 extends Lambda implements p<i, AnnotationQualifierApplicabilityType, Boolean> {
    public final /* synthetic */ AnnotationTypeQualifierResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(2);
        this.this$0 = annotationTypeQualifierResolver;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(i iVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(iVar, annotationQualifierApplicabilityType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d i iVar, @d AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        List p;
        p = this.this$0.p(annotationQualifierApplicabilityType.getJavaTarget());
        return p.contains(iVar.b().getIdentifier());
    }
}
