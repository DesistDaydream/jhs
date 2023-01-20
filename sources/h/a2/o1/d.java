package h.a2.o1;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.a2.n;
import h.k2.v.f0;
import h.k2.v.u;
import h.k2.v.x0.g;
import h.o2.q;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 v*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0006vwxyz{B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007BE\b\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0002\u00103J\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105J\r\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000207H\u0002J\u0019\u0010;\u001a\u00020\u001f2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0000¢\u0006\u0002\b>J!\u0010?\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u001f2\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010DJ\u0018\u0010G\u001a\u00020\u001f2\u000e\u0010H\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000305H\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0019\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010MH\u0000¢\u0006\u0002\bNJ\u0013\u0010O\u001a\u00020\u001f2\b\u0010H\u001a\u0004\u0018\u00010PH\u0096\u0002J\u0015\u0010Q\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u0015\u0010R\u001a\u00020\u00062\u0006\u0010F\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00101J\u0018\u0010S\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010TJ\u0015\u0010U\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\b\u0010V\u001a\u00020\u0006H\u0016J\b\u0010W\u001a\u00020\u001fH\u0016J\u0019\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010YH\u0000¢\u0006\u0002\bZJ\u001f\u0010[\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\\J\u001e\u0010]\u001a\u0002072\u0014\u0010^\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105H\u0016J\"\u0010_\u001a\u00020\u001f2\u0018\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A0=H\u0002J\u001c\u0010`\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0002J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u0006H\u0002J\u0010\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020\u0006H\u0002J\u0017\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010TJ!\u0010f\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0002\bgJ\u0010\u0010h\u001a\u0002072\u0006\u0010i\u001a\u00020\u0006H\u0002J\u0017\u0010j\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\bk\u00101J\u0010\u0010l\u001a\u0002072\u0006\u0010m\u001a\u00020\u0006H\u0002J\u0017\u0010n\u001a\u00020\u001f2\u0006\u0010o\u001a\u00028\u0001H\u0000¢\u0006\u0004\bp\u0010DJ\b\u0010q\u001a\u00020rH\u0016J\u0019\u0010s\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010tH\u0000¢\u0006\u0002\buR\u0014\u0010\u0011\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "isReadOnly", "", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "<set-?>", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", TTDownloadField.TT_HASHCODE, "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class d<K, V> implements Map<K, V>, h.k2.v.x0.g {
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    private static final int f14838m = -1640531527;
    @Deprecated
    private static final int n = 8;
    @Deprecated
    private static final int o = 2;
    @Deprecated
    private static final int p = -1;
    @k.e.a.d
    private static final a q = new a(null);
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private h.a2.o1.f<K> f14839c;

    /* renamed from: d  reason: collision with root package name */
    private g<V> f14840d;

    /* renamed from: e  reason: collision with root package name */
    private h.a2.o1.e<K, V> f14841e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14842f;

    /* renamed from: g  reason: collision with root package name */
    private K[] f14843g;

    /* renamed from: h  reason: collision with root package name */
    private V[] f14844h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f14845i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f14846j;

    /* renamed from: k  reason: collision with root package name */
    private int f14847k;

    /* renamed from: l  reason: collision with root package name */
    private int f14848l;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i2) {
            return Integer.highestOneBit(q.n(i2, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class b<K, V> extends C0420d<K, V> implements Iterator<Map.Entry<K, V>>, h.k2.v.x0.d {
        public b(@k.e.a.d d<K, V> dVar) {
            super(dVar);
        }

        @Override // java.util.Iterator
        @k.e.a.d
        /* renamed from: j */
        public c<K, V> next() {
            if (a() < ((d) f()).f14848l) {
                int a = a();
                h(a + 1);
                i(a);
                c<K, V> cVar = new c<>(f(), d());
                g();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void l(@k.e.a.d StringBuilder sb) {
            if (a() < ((d) f()).f14848l) {
                int a = a();
                h(a + 1);
                i(a);
                Object obj = ((d) f()).f14843g[d()];
                if (f0.g(obj, f())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object obj2 = ((d) f()).f14844h[d()];
                if (f0.g(obj2, f())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                g();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int m() {
            if (a() < ((d) f()).f14848l) {
                int a = a();
                h(a + 1);
                i(a);
                Object obj = ((d) f()).f14843g[d()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object obj2 = ((d) f()).f14844h[d()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                g();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class c<K, V> implements Map.Entry<K, V>, g.a {
        private final d<K, V> a;
        private final int b;

        public c(@k.e.a.d d<K, V> dVar, int i2) {
            this.a = dVar;
            this.b = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@k.e.a.e Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (f0.g(entry.getKey(), getKey()) && f0.g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((d) this.a).f14843g[this.b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) ((d) this.a).f14844h[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.r();
            Object[] p = this.a.p();
            int i2 = this.b;
            V v2 = (V) p[i2];
            p[i2] = v;
            return v2;
        }

        @k.e.a.d
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: h.a2.o1.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0420d<K, V> {
        private int a;
        private int b = -1;
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        private final d<K, V> f14849c;

        public C0420d(@k.e.a.d d<K, V> dVar) {
            this.f14849c = dVar;
            g();
        }

        public final int a() {
            return this.a;
        }

        public final int d() {
            return this.b;
        }

        @k.e.a.d
        public final d<K, V> f() {
            return this.f14849c;
        }

        public final void g() {
            while (this.a < ((d) this.f14849c).f14848l) {
                int[] iArr = ((d) this.f14849c).f14845i;
                int i2 = this.a;
                if (iArr[i2] >= 0) {
                    return;
                }
                this.a = i2 + 1;
            }
        }

        public final void h(int i2) {
            this.a = i2;
        }

        public final boolean hasNext() {
            return this.a < ((d) this.f14849c).f14848l;
        }

        public final void i(int i2) {
            this.b = i2;
        }

        public final void remove() {
            this.f14849c.r();
            this.f14849c.Q(this.b);
            this.b = -1;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class e<K, V> extends C0420d<K, V> implements Iterator<K>, h.k2.v.x0.d {
        public e(@k.e.a.d d<K, V> dVar) {
            super(dVar);
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < ((d) f()).f14848l) {
                int a = a();
                h(a + 1);
                i(a);
                K k2 = (K) ((d) f()).f14843g[d()];
                g();
                return k2;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class f<K, V> extends C0420d<K, V> implements Iterator<V>, h.k2.v.x0.d {
        public f(@k.e.a.d d<K, V> dVar) {
            super(dVar);
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < ((d) f()).f14848l) {
                int a = a();
                h(a + 1);
                i(a);
                V v = (V) ((d) f()).f14844h[d()];
                g();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    private d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.f14843g = kArr;
        this.f14844h = vArr;
        this.f14845i = iArr;
        this.f14846j = iArr2;
        this.f14847k = i2;
        this.f14848l = i3;
        this.a = q.d(D());
    }

    private final int A(V v) {
        int i2 = this.f14848l;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f14845i[i2] >= 0 && f0.g(this.f14844h[i2], v)) {
                return i2;
            }
        }
    }

    private final int B() {
        return this.f14843g.length;
    }

    private final int D() {
        return this.f14846j.length;
    }

    private final int H(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * f14838m) >>> this.a;
    }

    private final boolean J(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        x(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (K(entry)) {
                z = true;
            }
        }
        return z;
    }

    private final boolean K(Map.Entry<? extends K, ? extends V> entry) {
        int o2 = o(entry.getKey());
        V[] p2 = p();
        if (o2 >= 0) {
            p2[o2] = entry.getValue();
            return true;
        }
        int i2 = (-o2) - 1;
        if (!f0.g(entry.getValue(), p2[i2])) {
            p2[i2] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean L(int i2) {
        int H = H(this.f14843g[i2]);
        int i3 = this.f14847k;
        while (true) {
            int[] iArr = this.f14846j;
            if (iArr[H] == 0) {
                iArr[H] = i2 + 1;
                this.f14845i[i2] = H;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            H = H == 0 ? D() - 1 : H - 1;
        }
    }

    private final void M(int i2) {
        if (this.f14848l > size()) {
            s();
        }
        int i3 = 0;
        if (i2 != D()) {
            this.f14846j = new int[i2];
            this.a = q.d(i2);
        } else {
            n.l2(this.f14846j, 0, 0, D());
        }
        while (i3 < this.f14848l) {
            int i4 = i3 + 1;
            if (!L(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    private final void O(int i2) {
        int u = q.u(this.f14847k * 2, D() / 2);
        int i3 = 0;
        int i4 = i2;
        do {
            i2 = i2 == 0 ? D() - 1 : i2 - 1;
            i3++;
            if (i3 > this.f14847k) {
                this.f14846j[i4] = 0;
                return;
            }
            int[] iArr = this.f14846j;
            int i5 = iArr[i2];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((H(this.f14843g[i6]) - i2) & (D() - 1)) >= i3) {
                    this.f14846j[i4] = i5;
                    this.f14845i[i6] = i4;
                }
                u--;
            }
            i4 = i2;
            i3 = 0;
            u--;
        } while (u >= 0);
        this.f14846j[i4] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int i2) {
        h.a2.o1.c.f(this.f14843g, i2);
        O(this.f14845i[i2]);
        this.f14845i[i2] = -1;
        this.b = size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] p() {
        V[] vArr = this.f14844h;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) h.a2.o1.c.d(B());
        this.f14844h = vArr2;
        return vArr2;
    }

    private final void s() {
        int i2;
        V[] vArr = this.f14844h;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.f14848l;
            if (i3 >= i2) {
                break;
            }
            if (this.f14845i[i3] >= 0) {
                K[] kArr = this.f14843g;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        h.a2.o1.c.g(this.f14843g, i4, i2);
        if (vArr != null) {
            h.a2.o1.c.g(vArr, i4, this.f14848l);
        }
        this.f14848l = i4;
    }

    private final boolean v(Map<?, ?> map) {
        return size() == map.size() && t(map.entrySet());
    }

    private final void w(int i2) {
        if (i2 > B()) {
            int B = (B() * 3) / 2;
            if (i2 <= B) {
                i2 = B;
            }
            this.f14843g = (K[]) h.a2.o1.c.e(this.f14843g, i2);
            V[] vArr = this.f14844h;
            this.f14844h = vArr != null ? (V[]) h.a2.o1.c.e(vArr, i2) : null;
            this.f14845i = Arrays.copyOf(this.f14845i, i2);
            int c2 = q.c(i2);
            if (c2 > D()) {
                M(c2);
            }
        } else if ((this.f14848l + i2) - size() > B()) {
            M(D());
        }
    }

    private final void x(int i2) {
        w(this.f14848l + i2);
    }

    private final int z(K k2) {
        int H = H(k2);
        int i2 = this.f14847k;
        while (true) {
            int i3 = this.f14846j[H];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (f0.g(this.f14843g[i4], k2)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            H = H == 0 ? D() - 1 : H - 1;
        }
    }

    @k.e.a.d
    public Set<Map.Entry<K, V>> C() {
        h.a2.o1.e<K, V> eVar = this.f14841e;
        if (eVar == null) {
            h.a2.o1.e<K, V> eVar2 = new h.a2.o1.e<>(this);
            this.f14841e = eVar2;
            return eVar2;
        }
        return eVar;
    }

    @k.e.a.d
    public Set<K> E() {
        h.a2.o1.f<K> fVar = this.f14839c;
        if (fVar == null) {
            h.a2.o1.f<K> fVar2 = new h.a2.o1.f<>(this);
            this.f14839c = fVar2;
            return fVar2;
        }
        return fVar;
    }

    public int F() {
        return this.b;
    }

    @k.e.a.d
    public Collection<V> G() {
        g<V> gVar = this.f14840d;
        if (gVar == null) {
            g<V> gVar2 = new g<>(this);
            this.f14840d = gVar2;
            return gVar2;
        }
        return gVar;
    }

    @k.e.a.d
    public final e<K, V> I() {
        return new e<>(this);
    }

    public final boolean N(@k.e.a.d Map.Entry<? extends K, ? extends V> entry) {
        r();
        int z = z(entry.getKey());
        if (z >= 0 && !(!f0.g(this.f14844h[z], entry.getValue()))) {
            Q(z);
            return true;
        }
        return false;
    }

    public final int P(K k2) {
        r();
        int z = z(k2);
        if (z < 0) {
            return -1;
        }
        Q(z);
        return z;
    }

    public final boolean R(V v) {
        r();
        int A = A(v);
        if (A < 0) {
            return false;
        }
        Q(A);
        return true;
    }

    @k.e.a.d
    public final f<K, V> S() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        r();
        int i2 = this.f14848l - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f14845i;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.f14846j[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        h.a2.o1.c.g(this.f14843g, 0, this.f14848l);
        V[] vArr = this.f14844h;
        if (vArr != null) {
            h.a2.o1.c.g(vArr, 0, this.f14848l);
        }
        this.b = 0;
        this.f14848l = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return z(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return A(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return C();
    }

    @Override // java.util.Map
    public boolean equals(@k.e.a.e Object obj) {
        return obj == this || ((obj instanceof Map) && v((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @k.e.a.e
    public V get(Object obj) {
        int z = z(obj);
        if (z < 0) {
            return null;
        }
        return this.f14844h[z];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> y = y();
        int i2 = 0;
        while (y.hasNext()) {
            i2 += y.m();
        }
        return i2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return E();
    }

    public final int o(K k2) {
        r();
        while (true) {
            int H = H(k2);
            int u = q.u(this.f14847k * 2, D() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.f14846j[H];
                if (i3 <= 0) {
                    if (this.f14848l >= B()) {
                        x(1);
                    } else {
                        int i4 = this.f14848l;
                        int i5 = i4 + 1;
                        this.f14848l = i5;
                        this.f14843g[i4] = k2;
                        this.f14845i[i4] = H;
                        this.f14846j[H] = i5;
                        this.b = size() + 1;
                        if (i2 > this.f14847k) {
                            this.f14847k = i2;
                        }
                        return i4;
                    }
                } else if (f0.g(this.f14843g[i3 - 1], k2)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > u) {
                        M(D() * 2);
                        break;
                    }
                    H = H == 0 ? D() - 1 : H - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    @k.e.a.e
    public V put(K k2, V v) {
        r();
        int o2 = o(k2);
        V[] p2 = p();
        if (o2 < 0) {
            int i2 = (-o2) - 1;
            V v2 = p2[i2];
            p2[i2] = v;
            return v2;
        }
        p2[o2] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@k.e.a.d Map<? extends K, ? extends V> map) {
        r();
        J(map.entrySet());
    }

    @k.e.a.d
    public final Map<K, V> q() {
        r();
        this.f14842f = true;
        return this;
    }

    public final void r() {
        if (this.f14842f) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @k.e.a.e
    public V remove(Object obj) {
        int P = P(obj);
        if (P < 0) {
            return null;
        }
        V[] vArr = this.f14844h;
        V v = vArr[P];
        h.a2.o1.c.f(vArr, P);
        return v;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return F();
    }

    public final boolean t(@k.e.a.d Collection<?> collection) {
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!u((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> y = y();
        int i2 = 0;
        while (y.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            y.l(sb);
            i2++;
        }
        sb.append("}");
        return sb.toString();
    }

    public final boolean u(@k.e.a.d Map.Entry<? extends K, ? extends V> entry) {
        int z = z(entry.getKey());
        if (z < 0) {
            return false;
        }
        return f0.g(this.f14844h[z], entry.getValue());
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return G();
    }

    @k.e.a.d
    public final b<K, V> y() {
        return new b<>(this);
    }

    public d() {
        this(8);
    }

    public d(int i2) {
        this(h.a2.o1.c.d(i2), null, new int[i2], new int[q.c(i2)], 2, 0);
    }
}
