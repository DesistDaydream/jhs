package h.b2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.k2.u.p;
import h.k2.v.f0;
import java.util.Comparator;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aZ\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a>\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aZ\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aR\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001aR\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001ap\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\bø\u0001\u0000\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"compareBy", "Ljava/util/Comparator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", am.av, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes3.dex */
public class b {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator<T> {
        public final /* synthetic */ h.k2.u.l[] a;

        public a(h.k2.u.l[] lVarArr) {
            this.a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.k(t, t2, this.a);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* renamed from: h.b2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0422b<T> implements Comparator<T> {
        public final /* synthetic */ h.k2.u.l a;

        public C0422b(h.k2.u.l lVar) {
            this.a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.g((Comparable) this.a.invoke(t), (Comparable) this.a.invoke(t2));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class c<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ h.k2.u.l b;

        public c(Comparator comparator, h.k2.u.l lVar) {
            this.a = comparator;
            this.b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.a.compare(this.b.invoke(t), this.b.invoke(t2));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class d<T> implements Comparator<T> {
        public final /* synthetic */ h.k2.u.l a;

        public d(h.k2.u.l lVar) {
            this.a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.g((Comparable) this.a.invoke(t2), (Comparable) this.a.invoke(t));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class e<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ h.k2.u.l b;

        public e(Comparator comparator, h.k2.u.l lVar) {
            this.a = comparator;
            this.b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.a.compare(this.b.invoke(t2), this.b.invoke(t));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", am.av, "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class f<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;

        public f(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@k.e.a.e T t, @k.e.a.e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.a.compare(t, t2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", am.av, "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class g<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;

        public g(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@k.e.a.e T t, @k.e.a.e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.a.compare(t, t2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class h<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Comparator b;

        public h(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : this.b.compare(t, t2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class i<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ h.k2.u.l b;

        public i(Comparator comparator, h.k2.u.l lVar) {
            this.a = comparator;
            this.b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : b.g((Comparable) this.b.invoke(t), (Comparable) this.b.invoke(t2));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class j<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Comparator b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h.k2.u.l f14856c;

        public j(Comparator comparator, Comparator comparator2, h.k2.u.l lVar) {
            this.a = comparator;
            this.b = comparator2;
            this.f14856c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : this.b.compare(this.f14856c.invoke(t), this.f14856c.invoke(t2));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class k<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ h.k2.u.l b;

        public k(Comparator comparator, h.k2.u.l lVar) {
            this.a = comparator;
            this.b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : b.g((Comparable) this.b.invoke(t2), (Comparable) this.b.invoke(t));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class l<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Comparator b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h.k2.u.l f14857c;

        public l(Comparator comparator, Comparator comparator2, h.k2.u.l lVar) {
            this.a = comparator;
            this.b = comparator2;
            this.f14857c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : this.b.compare(this.f14857c.invoke(t2), this.f14857c.invoke(t));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class m<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ p b;

        public m(Comparator comparator, p pVar) {
            this.a = comparator;
            this.b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : ((Number) this.b.invoke(t, t2)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, am.av, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class n<T> implements Comparator<T> {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Comparator b;

        public n(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.a.compare(t, t2);
            return compare != 0 ? compare : this.b.compare(t2, t);
        }
    }

    @h.g2.f
    private static final <T, K> Comparator<T> b(Comparator<? super K> comparator, h.k2.u.l<? super T, ? extends K> lVar) {
        return new c(comparator, lVar);
    }

    @h.g2.f
    private static final <T> Comparator<T> c(h.k2.u.l<? super T, ? extends Comparable<?>> lVar) {
        return new C0422b(lVar);
    }

    @k.e.a.d
    public static final <T> Comparator<T> d(@k.e.a.d h.k2.u.l<? super T, ? extends Comparable<?>>... lVarArr) {
        if (lVarArr.length > 0) {
            return new a(lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @h.g2.f
    private static final <T, K> Comparator<T> e(Comparator<? super K> comparator, h.k2.u.l<? super T, ? extends K> lVar) {
        return new e(comparator, lVar);
    }

    @h.g2.f
    private static final <T> Comparator<T> f(h.k2.u.l<? super T, ? extends Comparable<?>> lVar) {
        return new d(lVar);
    }

    public static final <T extends Comparable<?>> int g(@k.e.a.e T t, @k.e.a.e T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @h.g2.f
    private static final <T, K> int h(T t, T t2, Comparator<? super K> comparator, h.k2.u.l<? super T, ? extends K> lVar) {
        return comparator.compare((K) lVar.invoke(t), (K) lVar.invoke(t2));
    }

    @h.g2.f
    private static final <T> int i(T t, T t2, h.k2.u.l<? super T, ? extends Comparable<?>> lVar) {
        return g(lVar.invoke(t), lVar.invoke(t2));
    }

    public static final <T> int j(T t, T t2, @k.e.a.d h.k2.u.l<? super T, ? extends Comparable<?>>... lVarArr) {
        if (lVarArr.length > 0) {
            return k(t, t2, lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int k(T t, T t2, h.k2.u.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (h.k2.u.l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int g2 = g(lVar.invoke(t), lVar.invoke(t2));
            if (g2 != 0) {
                return g2;
            }
        }
        return 0;
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> Comparator<T> l() {
        h.b2.e eVar = h.b2.e.a;
        Objects.requireNonNull(eVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return eVar;
    }

    @h.g2.f
    private static final <T extends Comparable<? super T>> Comparator<T> m() {
        return n(l());
    }

    @k.e.a.d
    public static final <T> Comparator<T> n(@k.e.a.d Comparator<? super T> comparator) {
        return new f(comparator);
    }

    @h.g2.f
    private static final <T extends Comparable<? super T>> Comparator<T> o() {
        return p(l());
    }

    @k.e.a.d
    public static final <T> Comparator<T> p(@k.e.a.d Comparator<? super T> comparator) {
        return new g(comparator);
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> Comparator<T> q() {
        h.b2.f fVar = h.b2.f.a;
        Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return fVar;
    }

    @k.e.a.d
    public static final <T> Comparator<T> r(@k.e.a.d Comparator<T> comparator) {
        if (comparator instanceof h.b2.g) {
            return ((h.b2.g) comparator).a();
        }
        Comparator<T> comparator2 = h.b2.e.a;
        if (f0.g(comparator, comparator2)) {
            h.b2.f fVar = h.b2.f.a;
            Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
            return fVar;
        }
        if (f0.g(comparator, h.b2.f.a)) {
            Objects.requireNonNull(comparator2, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        } else {
            comparator2 = new h.b2.g<>(comparator);
        }
        return comparator2;
    }

    @k.e.a.d
    public static final <T> Comparator<T> s(@k.e.a.d Comparator<T> comparator, @k.e.a.d Comparator<? super T> comparator2) {
        return new h(comparator, comparator2);
    }

    @h.g2.f
    private static final <T, K> Comparator<T> t(Comparator<T> comparator, Comparator<? super K> comparator2, h.k2.u.l<? super T, ? extends K> lVar) {
        return new j(comparator, comparator2, lVar);
    }

    @h.g2.f
    private static final <T> Comparator<T> u(Comparator<T> comparator, h.k2.u.l<? super T, ? extends Comparable<?>> lVar) {
        return new i(comparator, lVar);
    }

    @h.g2.f
    private static final <T, K> Comparator<T> v(Comparator<T> comparator, Comparator<? super K> comparator2, h.k2.u.l<? super T, ? extends K> lVar) {
        return new l(comparator, comparator2, lVar);
    }

    @h.g2.f
    private static final <T> Comparator<T> w(Comparator<T> comparator, h.k2.u.l<? super T, ? extends Comparable<?>> lVar) {
        return new k(comparator, lVar);
    }

    @h.g2.f
    private static final <T> Comparator<T> x(Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
        return new m(comparator, pVar);
    }

    @k.e.a.d
    public static final <T> Comparator<T> y(@k.e.a.d Comparator<T> comparator, @k.e.a.d Comparator<? super T> comparator2) {
        return new n(comparator, comparator2);
    }
}
