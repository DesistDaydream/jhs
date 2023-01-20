package com.jihuanshe.viewmodel.exam;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.AnswerWrapper;
import com.jihuanshe.model.EtiquetteAnswer;
import com.jihuanshe.model.EtiquetteCommit;
import com.jihuanshe.model.EtiquetteExamResult;
import com.jihuanshe.model.EtiquetteQuestion;
import e.l.h.l.b;
import e.l.n.c.k;
import e.l.r.f0;
import e.n.f;
import e.n.i;
import e.n.l;
import e.n.p;
import h.e2.c;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public final class EtiquetteExamViewModel extends b {
    @d

    /* renamed from: l  reason: collision with root package name */
    public static final a f4449l = new a(null);

    /* renamed from: m  reason: collision with root package name */
    public static final int f4450m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    @d
    private final l b = new l(0);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final List<EtiquetteQuestion> f4451c = new ArrayList();
    @d

    /* renamed from: d  reason: collision with root package name */
    private final List<EtiquetteCommit> f4452d = new ArrayList();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final l f4453e = new l(-1);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final l f4454f = new l(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final f<EtiquetteQuestion> f4455g = new f<>(null, 1, null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final i f4456h = new i(Boolean.FALSE);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final p f4457i = new p(null, 1, null);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<List<Integer>> f4458j = new f<>(null, 1, null);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final f<CharSequence> f4459k = new f<>(null, 1, null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @d
    public final l A0() {
        return this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
        if (r1 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B0() {
        /*
            r7 = this;
            e.n.f<java.util.List<java.lang.Integer>> r0 = r7.f4458j
            java.lang.Object r0 = r0.getValue()
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L15
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            if (r0 == 0) goto L26
            e.n.l r0 = r7.f4453e
            java.lang.Object r0 = r0.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r0 = r0 + r2
            goto L5b
        L26:
            e.n.f<java.util.List<java.lang.Integer>> r0 = r7.f4458j
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L32:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Ld5
            java.lang.Object r3 = r0.next()
            java.lang.Number r3 = (java.lang.Number) r3
            int r4 = r3.intValue()
            e.n.l r5 = r7.s0()
            java.lang.Object r5 = r5.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r4 <= r5) goto L54
            r4 = 1
            goto L55
        L54:
            r4 = 0
        L55:
            if (r4 == 0) goto L32
            int r0 = r3.intValue()
        L5b:
            java.util.List<com.jihuanshe.model.EtiquetteQuestion> r3 = r7.f4451c
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.J2(r3, r0)
            com.jihuanshe.model.EtiquetteQuestion r3 = (com.jihuanshe.model.EtiquetteQuestion) r3
            if (r3 != 0) goto L66
            return
        L66:
            java.util.List<com.jihuanshe.model.EtiquetteQuestion> r4 = r7.f4451c
            int r4 = r4.size()
            int r4 = r4 - r2
            r5 = 2
            r6 = 0
            if (r0 >= r4) goto Lb1
            e.n.f<java.util.List<java.lang.Integer>> r4 = r7.f4458j
            java.lang.Object r4 = r4.getValue()
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L84
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L82
            goto L84
        L82:
            r4 = 0
            goto L85
        L84:
            r4 = 1
        L85:
            if (r4 != 0) goto La2
            e.n.f<java.util.List<java.lang.Integer>> r4 = r7.f4458j
            java.lang.Object r4 = r4.getValue()
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L92
            goto L9f
        L92:
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.c3(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r0 != r4) goto L9f
            r1 = 1
        L9f:
            if (r1 == 0) goto La2
            goto Lb1
        La2:
            e.n.p r1 = r7.f4457i
            com.vector.util.Res r2 = com.vector.util.Res.a
            r4 = 2131755940(0x7f1003a4, float:1.9142773E38)
            java.lang.String r2 = com.vector.util.Res.w(r2, r4, r6, r5, r6)
            r1.setValue(r2)
            goto Lbf
        Lb1:
            e.n.p r1 = r7.f4457i
            com.vector.util.Res r2 = com.vector.util.Res.a
            r4 = 2131755935(0x7f10039f, float:1.9142763E38)
            java.lang.String r2 = com.vector.util.Res.w(r2, r4, r6, r5, r6)
            r1.setValue(r2)
        Lbf:
            e.n.i r1 = r7.f4456h
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.setValue(r2)
            e.n.l r1 = r7.f4453e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.setValue(r0)
            e.n.f<com.jihuanshe.model.EtiquetteQuestion> r0 = r7.f4455g
            r0.setValue(r3)
            return
        Ld5:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.String r1 = "Collection contains no element matching the predicate."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel.B0():void");
    }

    public final void C0(int i2) {
        List<EtiquetteAnswer> answer;
        EtiquetteAnswer etiquetteAnswer;
        int intValue = this.f4453e.getValue().intValue();
        EtiquetteQuestion etiquetteQuestion = (EtiquetteQuestion) CollectionsKt___CollectionsKt.J2(this.f4451c, intValue);
        Integer num = null;
        Integer id = etiquetteQuestion == null ? null : etiquetteQuestion.getId();
        EtiquetteQuestion etiquetteQuestion2 = (EtiquetteQuestion) CollectionsKt___CollectionsKt.J2(this.f4451c, intValue);
        if (etiquetteQuestion2 != null && (answer = etiquetteQuestion2.getAnswer()) != null && (etiquetteAnswer = (EtiquetteAnswer) CollectionsKt___CollectionsKt.J2(answer, i2)) != null) {
            num = etiquetteAnswer.getId();
        }
        EtiquetteCommit etiquetteCommit = new EtiquetteCommit(id, num);
        if (intValue >= this.f4452d.size()) {
            this.f4452d.add(etiquetteCommit);
        } else {
            this.f4452d.set(intValue, etiquetteCommit);
        }
    }

    @d
    public final e.g.d.a<List<EtiquetteExamResult>> p0() {
        return e.g.d.a.h(e.g.d.a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).p(RequestBody.Companion.create(f0.a.d(new AnswerWrapper(this.f4452d)), MediaType.Companion.get("application/json; charset=utf-8")))), null, new EtiquetteExamViewModel$commitAnswer$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<List<EtiquetteQuestion>> q0() {
        final Flow<List<EtiquetteQuestion>> r = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).r();
        return e.g.d.a.h(e.g.d.a.j(FlowKt.c(new Flow<List<? extends EtiquetteQuestion>>() { // from class: com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<List<? extends EtiquetteQuestion>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ EtiquetteExamViewModel$fetchQuestion$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, EtiquetteExamViewModel$fetchQuestion$$inlined$map$1 etiquetteExamViewModel$fetchQuestion$$inlined$map$1) {
                    this.a = fVar;
                    this.b = etiquetteExamViewModel$fetchQuestion$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.util.List<? extends com.jihuanshe.model.EtiquetteQuestion> r9, @k.e.a.d h.e2.c r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r10)
                        goto L7f
                    L29:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L31:
                        h.r0.n(r10)
                        i.b.v3.f r10 = r8.a
                        java.util.List r9 = (java.util.List) r9
                        r2 = 0
                        java.util.Iterator r4 = r9.iterator()
                    L3d:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto L76
                        java.lang.Object r5 = r4.next()
                        int r6 = r2 + 1
                        if (r2 >= 0) goto L4e
                        kotlin.collections.CollectionsKt__CollectionsKt.W()
                    L4e:
                        java.lang.Integer r2 = h.e2.k.a.a.f(r2)
                        com.jihuanshe.model.EtiquetteQuestion r5 = (com.jihuanshe.model.EtiquetteQuestion) r5
                        int r2 = r2.intValue()
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        r7.<init>()
                        int r2 = r2 + r3
                        r7.append(r2)
                        java.lang.String r2 = ". "
                        r7.append(r2)
                        java.lang.String r2 = r5.getQuestion()
                        r7.append(r2)
                        java.lang.String r2 = r7.toString()
                        r5.setQuestion(r2)
                        r2 = r6
                        goto L3d
                    L76:
                        r0.label = r3
                        java.lang.Object r9 = r10.emit(r9, r0)
                        if (r9 != r1) goto L7f
                        return r1
                    L7f:
                        h.t1 r9 = h.t1.a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel$fetchQuestion$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super List<? extends EtiquetteQuestion>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new EtiquetteExamViewModel$fetchQuestion$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final List<EtiquetteCommit> r0() {
        return this.f4452d;
    }

    @d
    public final l s0() {
        return this.f4453e;
    }

    @d
    public final f<EtiquetteQuestion> t0() {
        return this.f4455g;
    }

    @d
    public final List<EtiquetteQuestion> u0() {
        return this.f4451c;
    }

    @d
    public final f<List<Integer>> v0() {
        return this.f4458j;
    }

    @d
    public final f<CharSequence> w0() {
        return this.f4459k;
    }

    @d
    public final i x0() {
        return this.f4456h;
    }

    @d
    public final p y0() {
        return this.f4457i;
    }

    @d
    public final l z0() {
        return this.f4454f;
    }
}
