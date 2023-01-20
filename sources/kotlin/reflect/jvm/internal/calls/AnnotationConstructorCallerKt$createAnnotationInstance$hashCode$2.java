package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2 extends Lambda implements a<Integer> {
    public final /* synthetic */ Map $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(Map map) {
        super(0);
        this.$values = map;
    }

    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // h.k2.u.a
    public final Integer invoke() {
        int hashCode;
        ?? r1 = 0;
        for (Map.Entry entry : this.$values.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof boolean[]) {
                hashCode = Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                hashCode = Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                hashCode = Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                hashCode = Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                hashCode = Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                hashCode = Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                hashCode = Arrays.hashCode((double[]) value);
            } else {
                hashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
            }
            r1 += hashCode ^ (str.hashCode() * 127);
        }
        return r1;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }
}
