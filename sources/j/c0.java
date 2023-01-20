package j;

import com.umeng.analytics.pro.am;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\tB!\b\u0002\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lj/c0;", "Lh/a2/c;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", "f", "(I)Lokio/ByteString;", am.av, "()I", "size", "", "b", "[Lokio/ByteString;", "g", "()[Lokio/ByteString;", "byteStrings", "", "c", "[I", "h", "()[I", "trie", "<init>", "([Lokio/ByteString;[I)V", e.j.a.b.c.f.f10128d, "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c0 extends h.a2.c<ByteString> implements RandomAccess {

    /* renamed from: d */
    public static final a f15959d = new a(null);
    @k.e.a.d
    private final ByteString[] b;
    @k.e.a.d

    /* renamed from: c */
    private final int[] f15960c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J[\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u00122\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0011\"\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0002*\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"j/c0$a", "", "", "nodeOffset", "Lj/m;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "Lh/t1;", am.av, "(JLj/m;ILjava/util/List;IILjava/util/List;)V", "", "Lj/c0;", e.j.a.b.c.f.f10128d, "([Lokio/ByteString;)Lj/c0;", "c", "(Lj/m;)J", "intCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        private final void a(long j2, m mVar, int i2, List<? extends ByteString> list, int i3, int i4, List<Integer> list2) {
            int i5;
            int i6;
            int i7;
            int i8;
            m mVar2;
            int i9 = i2;
            if (i3 < i4) {
                for (int i10 = i3; i10 < i4; i10++) {
                    if (!(list.get(i10).size() >= i9)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = list.get(i3);
                ByteString byteString2 = list.get(i4 - 1);
                if (i9 == byteString.size()) {
                    int i11 = i3 + 1;
                    i5 = i11;
                    i6 = list2.get(i3).intValue();
                    byteString = list.get(i11);
                } else {
                    i5 = i3;
                    i6 = -1;
                }
                if (byteString.getByte(i9) != byteString2.getByte(i9)) {
                    int i12 = 1;
                    for (int i13 = i5 + 1; i13 < i4; i13++) {
                        if (list.get(i13 - 1).getByte(i9) != list.get(i13).getByte(i9)) {
                            i12++;
                        }
                    }
                    long c2 = j2 + c(mVar) + 2 + (i12 * 2);
                    mVar.writeInt(i12);
                    mVar.writeInt(i6);
                    for (int i14 = i5; i14 < i4; i14++) {
                        byte b = list.get(i14).getByte(i9);
                        if (i14 == i5 || b != list.get(i14 - 1).getByte(i9)) {
                            mVar.writeInt(b & 255);
                        }
                    }
                    m mVar3 = new m();
                    while (i5 < i4) {
                        byte b2 = list.get(i5).getByte(i9);
                        int i15 = i5 + 1;
                        int i16 = i15;
                        while (true) {
                            if (i16 >= i4) {
                                i7 = i4;
                                break;
                            } else if (b2 != list.get(i16).getByte(i9)) {
                                i7 = i16;
                                break;
                            } else {
                                i16++;
                            }
                        }
                        if (i15 == i7 && i9 + 1 == list.get(i5).size()) {
                            mVar.writeInt(list2.get(i5).intValue());
                            i8 = i7;
                            mVar2 = mVar3;
                        } else {
                            mVar.writeInt(((int) (c2 + c(mVar3))) * (-1));
                            i8 = i7;
                            mVar2 = mVar3;
                            a(c2, mVar3, i9 + 1, list, i5, i7, list2);
                        }
                        mVar3 = mVar2;
                        i5 = i8;
                    }
                    mVar.E(mVar3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i17 = 0;
                for (int i18 = i9; i18 < min && byteString.getByte(i18) == byteString2.getByte(i18); i18++) {
                    i17++;
                }
                long c3 = j2 + c(mVar) + 2 + i17 + 1;
                mVar.writeInt(-i17);
                mVar.writeInt(i6);
                int i19 = i9 + i17;
                while (i9 < i19) {
                    mVar.writeInt(byteString.getByte(i9) & 255);
                    i9++;
                }
                if (i5 + 1 == i4) {
                    if (i19 == list.get(i5).size()) {
                        mVar.writeInt(list2.get(i5).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                m mVar4 = new m();
                mVar.writeInt(((int) (c(mVar4) + c3)) * (-1));
                a(c3, mVar4, i19, list, i5, i4, list2);
                mVar.E(mVar4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static /* synthetic */ void b(a aVar, long j2, m mVar, int i2, List list, int i3, int i4, List list2, int i5, Object obj) {
            aVar.a((i5 & 1) != 0 ? 0L : j2, mVar, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long c(m mVar) {
            return mVar.O0() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:117:0x00ec, code lost:
            continue;
         */
        @h.k2.k
        @k.e.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final j.c0 d(@k.e.a.d okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 318
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j.c0.a.d(okio.ByteString[]):j.c0");
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public /* synthetic */ c0(ByteString[] byteStringArr, int[] iArr, h.k2.v.u uVar) {
        this(byteStringArr, iArr);
    }

    @h.k2.k
    @k.e.a.d
    public static final c0 p(@k.e.a.d ByteString... byteStringArr) {
        return f15959d.d(byteStringArr);
    }

    @Override // h.a2.c, kotlin.collections.AbstractCollection
    public int a() {
        return this.b.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return d((ByteString) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // h.a2.c, java.util.List
    @k.e.a.d
    /* renamed from: f */
    public ByteString get(int i2) {
        return this.b[i2];
    }

    @k.e.a.d
    public final ByteString[] g() {
        return this.b;
    }

    @k.e.a.d
    public final int[] h() {
        return this.f15960c;
    }

    public /* bridge */ int i(ByteString byteString) {
        return super.indexOf(byteString);
    }

    @Override // h.a2.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return i((ByteString) obj);
        }
        return -1;
    }

    @Override // h.a2.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return m((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int m(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    private c0(ByteString[] byteStringArr, int[] iArr) {
        this.b = byteStringArr;
        this.f15960c = iArr;
    }
}
