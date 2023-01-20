package kotlin.reflect.jvm.internal.impl.types.model;

import com.moor.imkf.YKFConstants;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum TypeVariance {
    IN(YKFConstants.INVESTIGATE_TYPE_IN),
    OUT(YKFConstants.INVESTIGATE_TYPE_OUT),
    INV("");
    
    @d
    private final String presentation;

    TypeVariance(String str) {
        this.presentation = str;
    }

    @Override // java.lang.Enum
    @d
    public String toString() {
        return this.presentation;
    }
}
