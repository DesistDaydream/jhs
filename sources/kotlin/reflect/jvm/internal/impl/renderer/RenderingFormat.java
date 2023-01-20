package kotlin.reflect.jvm.internal.impl.renderer;

import com.j256.ormlite.stmt.query.SimpleComparison;
import h.t2.u;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @d
        public String escape(@d String str) {
            return str;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @d
        public String escape(@d String str) {
            return u.k2(u.k2(str, SimpleComparison.LESS_THAN_OPERATION, "&lt;", false, 4, null), SimpleComparison.GREATER_THAN_OPERATION, "&gt;", false, 4, null);
        }
    };

    /* synthetic */ RenderingFormat(h.k2.v.u uVar) {
        this();
    }

    @d
    public abstract String escape(@d String str);
}
