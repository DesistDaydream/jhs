package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.g2.f;
import h.k2.u.l;
import h.k2.u.p;
import h.q2.g;
import h.q2.i;
import h.q2.j;
import h.q2.m;
import h.q2.q;
import h.q2.r;
import h.q2.w;
import h.s0;
import h.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Sequence", "Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", MessageKey.MSG_SOURCE, "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes4.dex */
public class SequencesKt__SequencesKt extends r {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a implements m<T> {
        public final /* synthetic */ h.k2.u.a a;

        public a(h.k2.u.a aVar) {
            this.a = aVar;
        }

        @Override // h.q2.m
        @d
        public Iterator<T> iterator() {
            return (Iterator) this.a.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class b implements m<T> {
        public final /* synthetic */ Iterator a;

        public b(Iterator it) {
            this.a = it;
        }

        @Override // h.q2.m
        @d
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    @f
    private static final <T> m<T> g(h.k2.u.a<? extends Iterator<? extends T>> aVar) {
        return new a(aVar);
    }

    @d
    public static final <T> m<T> h(@d Iterator<? extends T> it) {
        return i(new b(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> m<T> i(@d m<? extends T> mVar) {
        return mVar instanceof h.q2.a ? mVar : new h.q2.a(mVar);
    }

    @d
    public static final <T> m<T> j() {
        return g.a;
    }

    @d
    public static final <T, C, R> m<R> k(@d m<? extends T> mVar, @d p<? super Integer, ? super T, ? extends C> pVar, @d l<? super C, ? extends Iterator<? extends R>> lVar) {
        return q.e(new SequencesKt__SequencesKt$flatMapIndexed$1(mVar, pVar, lVar, null));
    }

    @d
    public static final <T> m<T> l(@d m<? extends m<? extends T>> mVar) {
        return m(mVar, SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }

    private static final <T, R> m<R> m(m<? extends T> mVar, l<? super T, ? extends Iterator<? extends R>> lVar) {
        if (mVar instanceof w) {
            return ((w) mVar).e(lVar);
        }
        return new i(mVar, SequencesKt__SequencesKt$flatten$3.INSTANCE, lVar);
    }

    @h.k2.g(name = "flattenSequenceOfIterable")
    @d
    public static final <T> m<T> n(@d m<? extends Iterable<? extends T>> mVar) {
        return m(mVar, SequencesKt__SequencesKt$flatten$2.INSTANCE);
    }

    @h.g2.g
    @d
    public static final <T> m<T> o(@e T t, @d l<? super T, ? extends T> lVar) {
        if (t == null) {
            return g.a;
        }
        return new j(new SequencesKt__SequencesKt$generateSequence$2(t), lVar);
    }

    @d
    public static final <T> m<T> p(@d h.k2.u.a<? extends T> aVar) {
        return i(new j(aVar, new SequencesKt__SequencesKt$generateSequence$1(aVar)));
    }

    @d
    public static final <T> m<T> q(@d h.k2.u.a<? extends T> aVar, @d l<? super T, ? extends T> lVar) {
        return new j(aVar, lVar);
    }

    @s0(version = "1.3")
    @d
    public static final <T> m<T> r(@d m<? extends T> mVar, @d h.k2.u.a<? extends m<? extends T>> aVar) {
        return q.e(new SequencesKt__SequencesKt$ifEmpty$1(mVar, aVar, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s0(version = "1.3")
    private static final <T> m<T> s(m<? extends T> mVar) {
        return mVar != 0 ? mVar : j();
    }

    @d
    public static final <T> m<T> t(@d T... tArr) {
        return tArr.length == 0 ? j() : ArraysKt___ArraysKt.h5(tArr);
    }

    @s0(version = "1.4")
    @d
    public static final <T> m<T> u(@d m<? extends T> mVar) {
        return v(mVar, Random.Default);
    }

    @s0(version = "1.4")
    @d
    public static final <T> m<T> v(@d m<? extends T> mVar, @d Random random) {
        return q.e(new SequencesKt__SequencesKt$shuffled$1(mVar, random, null));
    }

    @d
    public static final <T, R> Pair<List<T>, List<R>> w(@d m<? extends Pair<? extends T, ? extends R>> mVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : mVar) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return z0.a(arrayList, arrayList2);
    }
}
