package kotlin.reflect.jvm.internal.impl.types;

import com.moor.imkf.YKFConstants;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE(YKFConstants.INVESTIGATE_TYPE_IN, true, false, -1),
    OUT_VARIANCE(YKFConstants.INVESTIGATE_TYPE_OUT, false, true, 1);
    
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    @d
    private final String label;
    private final int superpositionFactor;

    Variance(String str, boolean z, boolean z2, int i2) {
        this.label = str;
        this.allowsInPosition = z;
        this.allowsOutPosition = z2;
        this.superpositionFactor = i2;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @d
    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    @d
    public String toString() {
        return this.label;
    }
}
