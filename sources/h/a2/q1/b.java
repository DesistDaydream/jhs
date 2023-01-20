package h.a2.q1;

import h.b1;
import h.c1;
import h.f1;
import h.g1;
import h.g2.f;
import h.j0;
import h.j1;
import h.k1;
import h.k2.g;
import h.k2.u.l;
import h.p;
import h.p1;
import h.q1;
import h.s0;
import h.v1;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020**\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a.\u0010)\u001a\u00020/*\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a.\u0010)\u001a\u00020**\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00102\u001a.\u0010)\u001a\u00020/*\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00103\u001a.\u0010)\u001a\u00020**\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00104\u001a.\u0010)\u001a\u00020/*\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00105\u001a.\u0010)\u001a\u00020**\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00106\u001a.\u0010)\u001a\u00020/*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00107\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, pn = "kotlin.collections", xi = 1, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes3.dex */
public class b {

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\b\u0010\u0014\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0017"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "Lkotlin/UInt;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-WZ4Q5Ns", "(I)Z", "get", "index", "get-pVg5ArA", "(I)I", "indexOf", "indexOf-WZ4Q5Ns", "isEmpty", "lastIndexOf", "lastIndexOf-WZ4Q5Ns", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a extends h.a2.c<f1> implements RandomAccess {
        public final /* synthetic */ int[] b;

        public a(int[] iArr) {
            this.b = iArr;
        }

        @Override // h.a2.c, kotlin.collections.AbstractCollection
        public int a() {
            return g1.t(this.b);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof f1) {
                return d(((f1) obj).m0());
            }
            return false;
        }

        public boolean d(int i2) {
            return g1.i(this.b, i2);
        }

        public int f(int i2) {
            return g1.r(this.b, i2);
        }

        public int g(int i2) {
            return ArraysKt___ArraysKt.df(this.b, i2);
        }

        @Override // h.a2.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return f1.b(f(i2));
        }

        public int h(int i2) {
            return ArraysKt___ArraysKt.hh(this.b, i2);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof f1) {
                return g(((f1) obj).m0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return g1.w(this.b);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof f1) {
                return h(((f1) obj).m0());
            }
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-VKZWuLQ", "(J)Z", "get", "index", "get-s-VKNKU", "(I)J", "indexOf", "indexOf-VKZWuLQ", "(J)I", "isEmpty", "lastIndexOf", "lastIndexOf-VKZWuLQ", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: h.a2.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0421b extends h.a2.c<j1> implements RandomAccess {
        public final /* synthetic */ long[] b;

        public C0421b(long[] jArr) {
            this.b = jArr;
        }

        @Override // h.a2.c, kotlin.collections.AbstractCollection
        public int a() {
            return k1.t(this.b);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof j1) {
                return d(((j1) obj).m0());
            }
            return false;
        }

        public boolean d(long j2) {
            return k1.i(this.b, j2);
        }

        public long f(int i2) {
            return k1.r(this.b, i2);
        }

        public int g(long j2) {
            return ArraysKt___ArraysKt.ef(this.b, j2);
        }

        @Override // h.a2.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return j1.b(f(i2));
        }

        public int h(long j2) {
            return ArraysKt___ArraysKt.ih(this.b, j2);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof j1) {
                return g(((j1) obj).m0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return k1.w(this.b);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof j1) {
                return h(((j1) obj).m0());
            }
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-7apg3OU", "(B)Z", "get", "index", "get-w2LRezQ", "(I)B", "indexOf", "indexOf-7apg3OU", "(B)I", "isEmpty", "lastIndexOf", "lastIndexOf-7apg3OU", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class c extends h.a2.c<b1> implements RandomAccess {
        public final /* synthetic */ byte[] b;

        public c(byte[] bArr) {
            this.b = bArr;
        }

        @Override // h.a2.c, kotlin.collections.AbstractCollection
        public int a() {
            return c1.t(this.b);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof b1) {
                return d(((b1) obj).k0());
            }
            return false;
        }

        public boolean d(byte b) {
            return c1.i(this.b, b);
        }

        public byte f(int i2) {
            return c1.r(this.b, i2);
        }

        public int g(byte b) {
            return ArraysKt___ArraysKt.Ze(this.b, b);
        }

        @Override // h.a2.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return b1.b(f(i2));
        }

        public int h(byte b) {
            return ArraysKt___ArraysKt.dh(this.b, b);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof b1) {
                return g(((b1) obj).k0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return c1.w(this.b);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof b1) {
                return h(((b1) obj).k0());
            }
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$4", "Lkotlin/collections/AbstractList;", "Lkotlin/UShort;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-xj2QHRw", "(S)Z", "get", "index", "get-Mh2AYeg", "(I)S", "indexOf", "indexOf-xj2QHRw", "(S)I", "isEmpty", "lastIndexOf", "lastIndexOf-xj2QHRw", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class d extends h.a2.c<p1> implements RandomAccess {
        public final /* synthetic */ short[] b;

        public d(short[] sArr) {
            this.b = sArr;
        }

        @Override // h.a2.c, kotlin.collections.AbstractCollection
        public int a() {
            return q1.t(this.b);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof p1) {
                return d(((p1) obj).k0());
            }
            return false;
        }

        public boolean d(short s) {
            return q1.i(this.b, s);
        }

        public short f(int i2) {
            return q1.r(this.b, i2);
        }

        public int g(short s) {
            return ArraysKt___ArraysKt.gf(this.b, s);
        }

        @Override // h.a2.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i2) {
            return p1.b(f(i2));
        }

        public int h(short s) {
            return ArraysKt___ArraysKt.kh(this.b, s);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof p1) {
                return g(((p1) obj).k0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return q1.w(this.b);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof p1) {
                return h(((p1) obj).k0());
            }
            return -1;
        }
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final List<f1> a(@k.e.a.d int[] iArr) {
        return new a(iArr);
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final List<b1> b(@k.e.a.d byte[] bArr) {
        return new c(bArr);
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final List<j1> c(@k.e.a.d long[] jArr) {
        return new C0421b(jArr);
    }

    @p
    @s0(version = "1.3")
    @k.e.a.d
    public static final List<p1> d(@k.e.a.d short[] sArr) {
        return new d(sArr);
    }

    @p
    @s0(version = "1.3")
    public static final int e(@k.e.a.d int[] iArr, int i2, int i3, int i4) {
        h.a2.c.a.d(i3, i4, g1.t(iArr));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int c2 = v1.c(iArr[i6], i2);
            if (c2 < 0) {
                i3 = i6 + 1;
            } else if (c2 <= 0) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static /* synthetic */ int f(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = g1.t(iArr);
        }
        return e(iArr, i2, i3, i4);
    }

    @p
    @s0(version = "1.3")
    public static final int g(@k.e.a.d short[] sArr, short s, int i2, int i3) {
        h.a2.c.a.d(i2, i3, q1.t(sArr));
        int i4 = s & 65535;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int c2 = v1.c(sArr[i6], i4);
            if (c2 < 0) {
                i2 = i6 + 1;
            } else if (c2 <= 0) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int h(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = q1.t(sArr);
        }
        return g(sArr, s, i2, i3);
    }

    @p
    @s0(version = "1.3")
    public static final int i(@k.e.a.d long[] jArr, long j2, int i2, int i3) {
        h.a2.c.a.d(i2, i3, k1.t(jArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int g2 = v1.g(jArr[i5], j2);
            if (g2 < 0) {
                i2 = i5 + 1;
            } else if (g2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int j(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = k1.t(jArr);
        }
        return i(jArr, j2, i2, i3);
    }

    @p
    @s0(version = "1.3")
    public static final int k(@k.e.a.d byte[] bArr, byte b, int i2, int i3) {
        h.a2.c.a.d(i2, i3, c1.t(bArr));
        int i4 = b & 255;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int c2 = v1.c(bArr[i6], i4);
            if (c2 < 0) {
                i2 = i6 + 1;
            } else if (c2 <= 0) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int l(byte[] bArr, byte b, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = c1.t(bArr);
        }
        return k(bArr, b, i2, i3);
    }

    @p
    @f
    @s0(version = "1.3")
    private static final byte m(byte[] bArr, int i2) {
        return c1.r(bArr, i2);
    }

    @p
    @f
    @s0(version = "1.3")
    private static final short n(short[] sArr, int i2) {
        return q1.r(sArr, i2);
    }

    @p
    @f
    @s0(version = "1.3")
    private static final int o(int[] iArr, int i2) {
        return g1.r(iArr, i2);
    }

    @p
    @f
    @s0(version = "1.3")
    private static final long p(long[] jArr, int i2) {
        return k1.r(jArr, i2);
    }

    @p
    @g(name = "sumOfBigDecimal")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigDecimal q(byte[] bArr, l<? super b1, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        for (byte b : bArr) {
            valueOf = valueOf.add(lVar.invoke(b1.b(b)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigDecimal")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigDecimal r(int[] iArr, l<? super f1, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        for (int i2 : iArr) {
            valueOf = valueOf.add(lVar.invoke(f1.b(i2)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigDecimal")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigDecimal s(long[] jArr, l<? super j1, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        for (long j2 : jArr) {
            valueOf = valueOf.add(lVar.invoke(j1.b(j2)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigDecimal")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigDecimal t(short[] sArr, l<? super p1, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        for (short s : sArr) {
            valueOf = valueOf.add(lVar.invoke(p1.b(s)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigInteger")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigInteger u(byte[] bArr, l<? super b1, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        for (byte b : bArr) {
            valueOf = valueOf.add(lVar.invoke(b1.b(b)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigInteger")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigInteger v(int[] iArr, l<? super f1, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        for (int i2 : iArr) {
            valueOf = valueOf.add(lVar.invoke(f1.b(i2)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigInteger")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigInteger w(long[] jArr, l<? super j1, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        for (long j2 : jArr) {
            valueOf = valueOf.add(lVar.invoke(j1.b(j2)));
        }
        return valueOf;
    }

    @p
    @g(name = "sumOfBigInteger")
    @j0
    @s0(version = "1.4")
    @f
    private static final BigInteger x(short[] sArr, l<? super p1, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        for (short s : sArr) {
            valueOf = valueOf.add(lVar.invoke(p1.b(s)));
        }
        return valueOf;
    }
}
