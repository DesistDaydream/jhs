package h.p2.a0;

import androidx.exifinterface.media.ExifInterface;
import h.k2.g;
import h.k2.v.f0;
import h.o;
import h.s0;
import h.x1;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import kotlin.Metadata;

@g(name = "KAnnotatedElements")
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¨\u0006\u0007"}, d2 = {"findAnnotation", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "hasAnnotation", "", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class a {
    @s0(version = "1.1")
    public static final /* synthetic */ <T extends Annotation> T a(h.p2.b bVar) {
        Object obj;
        Iterator<T> it = bVar.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((Annotation) obj) instanceof Annotation) {
                break;
            }
        }
        f0.y(1, "T?");
        return (T) obj;
    }

    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    public static final /* synthetic */ <T extends Annotation> boolean b(h.p2.b bVar) {
        Object obj;
        Iterator<T> it = bVar.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((Annotation) obj) instanceof Annotation) {
                break;
            }
        }
        f0.y(1, "T?");
        return ((Annotation) obj) != null;
    }
}
