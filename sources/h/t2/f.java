package h.t2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class f implements h.q2.m<h.o2.k> {
    private final CharSequence a;
    private final int b;

    /* renamed from: c */
    private final int f15684c;

    /* renamed from: d */
    private final h.k2.u.p<CharSequence, Integer, Pair<Integer, Integer>> f15685d;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<h.o2.k>, h.k2.v.x0.a {
        private int a = -1;
        private int b;

        /* renamed from: c */
        private int f15686c;
        @k.e.a.e

        /* renamed from: d */
        private h.o2.k f15687d;

        /* renamed from: e */
        private int f15688e;

        public a() {
            f.this = r3;
            int B = h.o2.q.B(r3.b, 0, r3.a.length());
            this.b = B;
            this.f15686c = B;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0021, code lost:
            if (r0 < h.t2.f.this.f15684c) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f15686c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.f15687d = r0
                goto L9e
            Lc:
                h.t2.f r0 = h.t2.f.this
                int r0 = h.t2.f.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f15688e
                int r0 = r0 + r3
                r6.f15688e = r0
                h.t2.f r4 = h.t2.f.this
                int r4 = h.t2.f.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f15686c
                h.t2.f r4 = h.t2.f.this
                java.lang.CharSequence r4 = h.t2.f.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.b
                h.o2.k r1 = new h.o2.k
                h.t2.f r4 = h.t2.f.this
                java.lang.CharSequence r4 = h.t2.f.d(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.i3(r4)
                r1.<init>(r0, r4)
                r6.f15687d = r1
                r6.f15686c = r2
                goto L9c
            L47:
                h.t2.f r0 = h.t2.f.this
                h.k2.u.p r0 = h.t2.f.c(r0)
                h.t2.f r4 = h.t2.f.this
                java.lang.CharSequence r4 = h.t2.f.d(r4)
                int r5 = r6.f15686c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                int r0 = r6.b
                h.o2.k r1 = new h.o2.k
                h.t2.f r4 = h.t2.f.this
                java.lang.CharSequence r4 = h.t2.f.d(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.i3(r4)
                r1.<init>(r0, r4)
                r6.f15687d = r1
                r6.f15686c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                h.o2.k r4 = h.o2.q.n1(r4, r2)
                r6.f15687d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f15686c = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.t2.f.a.a():void");
        }

        public final int d() {
            return this.f15688e;
        }

        public final int f() {
            return this.b;
        }

        @k.e.a.e
        public final h.o2.k g() {
            return this.f15687d;
        }

        public final int h() {
            return this.f15686c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        public final int i() {
            return this.a;
        }

        @Override // java.util.Iterator
        @k.e.a.d
        /* renamed from: j */
        public h.o2.k next() {
            if (this.a == -1) {
                a();
            }
            if (this.a != 0) {
                h.o2.k kVar = this.f15687d;
                Objects.requireNonNull(kVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f15687d = null;
                this.a = -1;
                return kVar;
            }
            throw new NoSuchElementException();
        }

        public final void l(int i2) {
            this.f15688e = i2;
        }

        public final void m(int i2) {
            this.b = i2;
        }

        public final void o(@k.e.a.e h.o2.k kVar) {
            this.f15687d = kVar;
        }

        public final void p(int i2) {
            this.f15686c = i2;
        }

        public final void q(int i2) {
            this.a = i2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@k.e.a.d CharSequence charSequence, int i2, int i3, @k.e.a.d h.k2.u.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> pVar) {
        this.a = charSequence;
        this.b = i2;
        this.f15684c = i3;
        this.f15685d = pVar;
    }

    @Override // h.q2.m
    @k.e.a.d
    public Iterator<h.o2.k> iterator() {
        return new a();
    }
}
