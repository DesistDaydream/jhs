package kotlin.reflect.jvm.internal.impl.load.java;

import k.e.a.d;

/* loaded from: classes3.dex */
public enum AnnotationQualifierApplicabilityType {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");
    
    @d
    private final String javaTarget;

    AnnotationQualifierApplicabilityType(String str) {
        this.javaTarget = str;
    }

    @d
    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
