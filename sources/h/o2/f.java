package h.o2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.s0;
import java.lang.Comparable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", am.av, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.1")
/* loaded from: classes3.dex */
public interface f<T extends Comparable<? super T>> extends g<T> {

    @Metadata(k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@k.e.a.d f<T> fVar, @k.e.a.d T t) {
            return fVar.a(fVar.getStart(), t) && fVar.a(t, fVar.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean b(@k.e.a.d f<T> fVar) {
            return !fVar.a(fVar.getStart(), fVar.getEndInclusive());
        }
    }

    boolean a(@k.e.a.d T t, @k.e.a.d T t2);

    @Override // h.o2.g
    boolean contains(@k.e.a.d T t);

    @Override // h.o2.g
    boolean isEmpty();
}
