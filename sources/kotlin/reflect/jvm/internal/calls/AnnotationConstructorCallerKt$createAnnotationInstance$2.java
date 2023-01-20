package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import h.k2.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"equals", "", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$2 extends Lambda implements l<Object, Boolean> {
    public final /* synthetic */ Class $annotationClass;
    public final /* synthetic */ List $methods;
    public final /* synthetic */ Map $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$2(Class cls, List list, Map map) {
        super(1);
        this.$annotationClass = cls;
        this.$methods = list;
        this.$values = map;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@e Object obj) {
        boolean g2;
        boolean z;
        d a;
        Class cls = null;
        Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
        if (annotation != null && (a = a.a(annotation)) != null) {
            cls = a.c(a);
        }
        if (f0.g(cls, this.$annotationClass)) {
            List<Method> list = this.$methods;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Method method : list) {
                    Object obj2 = this.$values.get(method.getName());
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        g2 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                        continue;
                    } else if (obj2 instanceof char[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                        g2 = Arrays.equals((char[]) obj2, (char[]) invoke);
                        continue;
                    } else if (obj2 instanceof byte[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        g2 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                        continue;
                    } else if (obj2 instanceof short[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        g2 = Arrays.equals((short[]) obj2, (short[]) invoke);
                        continue;
                    } else if (obj2 instanceof int[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                        g2 = Arrays.equals((int[]) obj2, (int[]) invoke);
                        continue;
                    } else if (obj2 instanceof float[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        g2 = Arrays.equals((float[]) obj2, (float[]) invoke);
                        continue;
                    } else if (obj2 instanceof long[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                        g2 = Arrays.equals((long[]) obj2, (long[]) invoke);
                        continue;
                    } else if (obj2 instanceof double[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        g2 = Arrays.equals((double[]) obj2, (double[]) invoke);
                        continue;
                    } else if (obj2 instanceof Object[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        g2 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                        continue;
                    } else {
                        g2 = f0.g(obj2, invoke);
                        continue;
                    }
                    if (!g2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return 1;
            }
        }
        return null;
    }
}
