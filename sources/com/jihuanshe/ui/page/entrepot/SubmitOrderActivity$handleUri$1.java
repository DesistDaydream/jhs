package com.jihuanshe.ui.page.entrepot;

import android.net.Uri;
import com.jihuanshe.model.WareCache;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import e.t.k.a.f.h;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$handleUri$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public int label;
        public final /* synthetic */ SubmitOrderActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubmitOrderActivity submitOrderActivity, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = submitOrderActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass1) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            h hVar;
            b.h();
            if (this.label == 0) {
                r0.n(obj);
                hVar = this.this$0.o;
                if (hVar == null) {
                    return null;
                }
                hVar.n();
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public final /* synthetic */ FileInfo $fileInfo;
        public int label;
        public final /* synthetic */ SubmitOrderActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SubmitOrderActivity submitOrderActivity, FileInfo fileInfo, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = submitOrderActivity;
            this.$fileInfo = fileInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass2(this.this$0, this.$fileInfo, cVar);
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass2) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            h hVar;
            b.h();
            if (this.label == 0) {
                r0.n(obj);
                hVar = this.this$0.o;
                if (hVar != null) {
                    hVar.n();
                }
                if (this.$fileInfo != null) {
                    WareCache value = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
                    if (value != null) {
                        value.setImageUrl(this.$fileInfo.getUrl());
                    }
                    ((SubmitOrderViewModel) this.this$0.L()).B0().n();
                }
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$handleUri$1(Uri uri, SubmitOrderActivity submitOrderActivity, c<? super SubmitOrderActivity$handleUri$1> cVar) {
        super(2, cVar);
        this.$uri = uri;
        this.this$0 = submitOrderActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        return new SubmitOrderActivity$handleUri$1(this.$uri, this.this$0, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
        return ((SubmitOrderActivity$handleUri$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0094 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r7.label
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2e
            if (r1 == r6) goto L2a
            if (r1 == r5) goto L26
            if (r1 == r4) goto L22
            if (r1 != r3) goto L1a
            h.r0.n(r8)
            goto L95
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            h.r0.n(r8)
            goto L7f
        L26:
            h.r0.n(r8)
            goto L54
        L2a:
            h.r0.n(r8)
            goto L3c
        L2e:
            h.r0.n(r8)
            android.net.Uri r8 = r7.$uri
            r7.label = r6
            java.lang.Object r8 = com.jihuanshe.ext.UriExtKt.a(r8, r7)
            if (r8 != r0) goto L3c
            return r0
        L3c:
            java.io.File r8 = (java.io.File) r8
            if (r8 != 0) goto L57
            i.b.l2 r8 = i.b.b1.e()
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1$1 r1 = new com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1$1
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity r3 = r7.this$0
            r1.<init>(r3, r2)
            r7.label = r5
            java.lang.Object r8 = i.b.g.i(r8, r1, r7)
            if (r8 != r0) goto L54
            return r0
        L54:
            h.t1 r8 = h.t1.a
            return r8
        L57:
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity r1 = r7.this$0
            android.net.Uri r8 = e.l.r.v.a(r1, r8)
            if (r8 != 0) goto L6e
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity r8 = r7.this$0
            e.t.k.a.f.h r8 = com.jihuanshe.ui.page.entrepot.SubmitOrderActivity.Y(r8)
            if (r8 != 0) goto L68
            goto L6b
        L68:
            r8.n()
        L6b:
            h.t1 r8 = h.t1.a
            return r8
        L6e:
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity r1 = r7.this$0
            e.t.k.b.a r1 = r1.L()
            com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel r1 = (com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel) r1
            r7.label = r4
            java.lang.Object r8 = r1.r0(r8, r7)
            if (r8 != r0) goto L7f
            return r0
        L7f:
            com.jihuanshe.net.api.FileInfo r8 = (com.jihuanshe.net.api.FileInfo) r8
            i.b.l2 r1 = i.b.b1.e()
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1$2 r4 = new com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1$2
            com.jihuanshe.ui.page.entrepot.SubmitOrderActivity r5 = r7.this$0
            r4.<init>(r5, r8, r2)
            r7.label = r3
            java.lang.Object r8 = i.b.g.i(r1, r4, r7)
            if (r8 != r0) goto L95
            return r0
        L95:
            h.t1 r8 = h.t1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$handleUri$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
