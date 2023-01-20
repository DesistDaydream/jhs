package h.o2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import java.lang.Comparable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/ClosedRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", MessageKey.MSG_ACCEPT_TIME_START, "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public interface g<T extends Comparable<? super T>> {

    @Metadata(k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@k.e.a.d g<T> gVar, @k.e.a.d T t) {
            return t.compareTo(gVar.getStart()) >= 0 && t.compareTo(gVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@k.e.a.d g<T> gVar) {
            return gVar.getStart().compareTo(gVar.getEndInclusive()) > 0;
        }
    }

    boolean contains(@k.e.a.d T t);

    @k.e.a.d
    T getEndInclusive();

    @k.e.a.d
    T getStart();

    boolean isEmpty();
}
