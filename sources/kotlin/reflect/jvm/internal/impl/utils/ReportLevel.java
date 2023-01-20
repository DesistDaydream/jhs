package kotlin.reflect.jvm.internal.impl.utils;

import h.k2.v.u;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum ReportLevel {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    @d
    public static final a Companion = new a(null);
    @d
    private final String description;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    ReportLevel(String str) {
        this.description = str;
    }

    @d
    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
