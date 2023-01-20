package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import java.util.Map;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2 extends Lambda implements a<String> {
    public final /* synthetic */ Class $annotationClass;
    public final /* synthetic */ Map $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class cls, Map map) {
        super(0);
        this.$annotationClass = cls;
        this.$values = map;
    }

    @Override // h.k2.u.a
    @d
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(this.$annotationClass.getCanonicalName());
        CollectionsKt___CollectionsKt.W2(this.$values.entrySet(), sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1.INSTANCE);
        return sb.toString();
    }
}
