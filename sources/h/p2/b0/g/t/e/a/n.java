package h.p2.b0.g.t.e.a;

import java.util.EnumMap;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;

/* loaded from: classes3.dex */
public final class n {
    @k.e.a.d
    private final EnumMap<AnnotationQualifierApplicabilityType, k> a;

    public n(@k.e.a.d EnumMap<AnnotationQualifierApplicabilityType, k> enumMap) {
        this.a = enumMap;
    }

    @k.e.a.e
    public final k a(@k.e.a.e AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.a.get(annotationQualifierApplicabilityType);
    }

    @k.e.a.d
    public final EnumMap<AnnotationQualifierApplicabilityType, k> b() {
        return this.a;
    }
}
