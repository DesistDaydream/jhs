package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.l;
import java.util.Arrays;
import java.util.Map;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "entry", "", "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 extends Lambda implements l<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 INSTANCE = new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1();

    public AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1() {
        super(1);
    }

    @d
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(@d Map.Entry<String, ? extends Object> entry) {
        String arrays;
        String key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            arrays = Arrays.toString((boolean[]) value);
        } else if (value instanceof char[]) {
            arrays = Arrays.toString((char[]) value);
        } else if (value instanceof byte[]) {
            arrays = Arrays.toString((byte[]) value);
        } else if (value instanceof short[]) {
            arrays = Arrays.toString((short[]) value);
        } else if (value instanceof int[]) {
            arrays = Arrays.toString((int[]) value);
        } else if (value instanceof float[]) {
            arrays = Arrays.toString((float[]) value);
        } else if (value instanceof long[]) {
            arrays = Arrays.toString((long[]) value);
        } else if (value instanceof double[]) {
            arrays = Arrays.toString((double[]) value);
        } else {
            arrays = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
        }
        return key + '=' + arrays;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
        return invoke2((Map.Entry<String, ? extends Object>) entry);
    }
}
