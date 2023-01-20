package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import h.a2.c0;
import h.q2.m;
import h.q2.q;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class SlidingWindowKt {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a implements m<List<? extends T>> {
        public final /* synthetic */ m a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16330c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f16331d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f16332e;

        public a(m mVar, int i2, int i3, boolean z, boolean z2) {
            this.a = mVar;
            this.b = i2;
            this.f16330c = i3;
            this.f16331d = z;
            this.f16332e = z2;
        }

        @Override // h.q2.m
        @d
        public Iterator<List<? extends T>> iterator() {
            return SlidingWindowKt.b(this.a.iterator(), this.b, this.f16330c, this.f16331d, this.f16332e);
        }
    }

    public static final void a(int i2, int i3) {
        String str;
        if (i2 > 0 && i3 > 0) {
            return;
        }
        if (i2 != i3) {
            str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
        } else {
            str = "size " + i2 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @d
    public static final <T> Iterator<List<T>> b(@d Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        return !it.hasNext() ? c0.a : q.d(new SlidingWindowKt$windowedIterator$1(i2, i3, it, z2, z, null));
    }

    @d
    public static final <T> m<List<T>> c(@d m<? extends T> mVar, int i2, int i3, boolean z, boolean z2) {
        a(i2, i3);
        return new a(mVar, i2, i3, z, z2);
    }
}
