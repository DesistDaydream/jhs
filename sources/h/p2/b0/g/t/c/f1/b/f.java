package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: classes3.dex */
public final class f {
    @k.e.a.e
    public static final b a(@k.e.a.d Annotation[] annotationArr, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
        Annotation annotation;
        int length = annotationArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i2];
            if (f0.g(ReflectClassUtilKt.a(h.k2.a.c(h.k2.a.a(annotation))).b(), cVar)) {
                break;
            }
            i2++;
        }
        if (annotation == null) {
            return null;
        }
        return new b(annotation);
    }

    @k.e.a.d
    public static final List<b> b(@k.e.a.d Annotation[] annotationArr) {
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new b(annotation));
        }
        return arrayList;
    }
}
