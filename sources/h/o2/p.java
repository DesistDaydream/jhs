package h.o2;

import androidx.exifinterface.media.ExifInterface;
import h.s0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\n*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\u0087\n¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u000f*\u0002H\u00072\u0006\u0010\u0010\u001a\u0002H\u0007H\u0086\u0002¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0013H\u0087\u0002\u001a\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0014H\u0087\u0002¨\u0006\u0015"}, d2 = {"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", ExifInterface.GPS_DIRECTION_TRUE, "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes3.dex */
public class p {
    public static final void a(boolean z, @k.e.a.d Number number) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lh/o2/g<TT;>;>(TR;TT;)Z */
    @h.g2.f
    @s0(version = "1.3")
    private static final boolean b(Iterable iterable, Object obj) {
        return obj != null && ((g) iterable).contains((Comparable) obj);
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final f<Double> c(double d2, double d3) {
        return new d(d2, d3);
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final f<Float> d(float f2, float f3) {
        return new e(f2, f3);
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> g<T> e(@k.e.a.d T t, @k.e.a.d T t2) {
        return new h(t, t2);
    }
}
