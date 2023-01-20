package h.r2.a;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVG;
import h.a2.n;
import h.k2.g;
import h.q2.m;
import h.s0;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;

@g(name = "StreamsKt")
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.streams")
/* loaded from: classes4.dex */
public final class a {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: h.r2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0475a implements m<T> {
        public final /* synthetic */ Stream a;

        public C0475a(Stream stream) {
            this.a = stream;
        }

        @Override // h.q2.m
        @k.e.a.d
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class b implements m<Integer> {
        public final /* synthetic */ IntStream a;

        public b(IntStream intStream) {
            this.a = intStream;
        }

        @Override // h.q2.m
        @k.e.a.d
        public Iterator<Integer> iterator() {
            return this.a.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class c implements m<Long> {
        public final /* synthetic */ LongStream a;

        public c(LongStream longStream) {
            this.a = longStream;
        }

        @Override // h.q2.m
        @k.e.a.d
        public Iterator<Long> iterator() {
            return this.a.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class d implements m<Double> {
        public final /* synthetic */ DoubleStream a;

        public d(DoubleStream doubleStream) {
            this.a = doubleStream;
        }

        @Override // h.q2.m
        @k.e.a.d
        public Iterator<Double> iterator() {
            return this.a.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/Spliterator;", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "get"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class e<T> implements Supplier<Spliterator<T>> {
        public final /* synthetic */ m a;

        public e(m mVar) {
            this.a = mVar;
        }

        @Override // java.util.function.Supplier
        /* renamed from: a */
        public final Spliterator<T> get() {
            return Spliterators.spliteratorUnknownSize(this.a.iterator(), 16);
        }
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final m<Double> a(@k.e.a.d DoubleStream doubleStream) {
        return new d(doubleStream);
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final m<Integer> b(@k.e.a.d IntStream intStream) {
        return new b(intStream);
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final m<Long> c(@k.e.a.d LongStream longStream) {
        return new c(longStream);
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final <T> m<T> d(@k.e.a.d Stream<T> stream) {
        return new C0475a(stream);
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final <T> Stream<T> e(@k.e.a.d m<? extends T> mVar) {
        return StreamSupport.stream(new e(mVar), 16, false);
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final List<Double> f(@k.e.a.d DoubleStream doubleStream) {
        return n.p(doubleStream.toArray());
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final List<Integer> g(@k.e.a.d IntStream intStream) {
        return n.r(intStream.toArray());
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final List<Long> h(@k.e.a.d LongStream longStream) {
        return n.s(longStream.toArray());
    }

    @s0(version = SVG.f2474i)
    @k.e.a.d
    public static final <T> List<T> i(@k.e.a.d Stream<T> stream) {
        return (List) stream.collect(Collectors.toList());
    }
}
