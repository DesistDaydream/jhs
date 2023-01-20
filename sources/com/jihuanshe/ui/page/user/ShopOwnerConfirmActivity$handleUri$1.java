package com.jihuanshe.ui.page.user;

import android.net.Uri;
import com.jihuanshe.net.api.FileInfo;
import e.n.f;
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
public final class ShopOwnerConfirmActivity$handleUri$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ ShopOwnerConfirmActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public int label;
        public final /* synthetic */ ShopOwnerConfirmActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShopOwnerConfirmActivity shopOwnerConfirmActivity, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = shopOwnerConfirmActivity;
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
                hVar = this.this$0.w;
                if (hVar == null) {
                    return null;
                }
                hVar.n();
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public int label;
        public final /* synthetic */ ShopOwnerConfirmActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ShopOwnerConfirmActivity shopOwnerConfirmActivity, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = shopOwnerConfirmActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass2(this.this$0, cVar);
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
                hVar = this.this$0.w;
                if (hVar == null) {
                    return null;
                }
                hVar.n();
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public final /* synthetic */ FileInfo $fileInfo;
        public int label;
        public final /* synthetic */ ShopOwnerConfirmActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ShopOwnerConfirmActivity shopOwnerConfirmActivity, FileInfo fileInfo, c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.this$0 = shopOwnerConfirmActivity;
            this.$fileInfo = fileInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass3(this.this$0, this.$fileInfo, cVar);
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass3) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            h hVar;
            int i2;
            b.h();
            if (this.label == 0) {
                r0.n(obj);
                hVar = this.this$0.w;
                if (hVar != null) {
                    hVar.n();
                }
                i2 = this.this$0.y;
                if (i2 == 0) {
                    f<String> I0 = ((e.l.s.o.b) this.this$0.L()).I0();
                    FileInfo fileInfo = this.$fileInfo;
                    I0.r(fileInfo != null ? fileInfo.getUrl() : null);
                } else if (i2 != 1) {
                    e.n.p Z0 = ((e.l.s.o.b) this.this$0.L()).Z0();
                    FileInfo fileInfo2 = this.$fileInfo;
                    Z0.r(fileInfo2 != null ? fileInfo2.getUrl() : null);
                } else {
                    f<String> C0 = ((e.l.s.o.b) this.this$0.L()).C0();
                    FileInfo fileInfo3 = this.$fileInfo;
                    C0.r(fileInfo3 != null ? fileInfo3.getUrl() : null);
                }
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopOwnerConfirmActivity$handleUri$1(Uri uri, ShopOwnerConfirmActivity shopOwnerConfirmActivity, c<? super ShopOwnerConfirmActivity$handleUri$1> cVar) {
        super(2, cVar);
        this.$uri = uri;
        this.this$0 = shopOwnerConfirmActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        return new ShopOwnerConfirmActivity$handleUri$1(this.$uri, this.this$0, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
        return ((ShopOwnerConfirmActivity$handleUri$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r8.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L35
            if (r1 == r6) goto L31
            if (r1 == r5) goto L2d
            if (r1 == r4) goto L29
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            h.r0.n(r9)
            goto La4
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            h.r0.n(r9)
            goto L8e
        L29:
            h.r0.n(r9)
            goto L7a
        L2d:
            h.r0.n(r9)
            goto L5b
        L31:
            h.r0.n(r9)
            goto L43
        L35:
            h.r0.n(r9)
            android.net.Uri r9 = r8.$uri
            r8.label = r6
            java.lang.Object r9 = com.jihuanshe.ext.UriExtKt.a(r9, r8)
            if (r9 != r0) goto L43
            return r0
        L43:
            java.io.File r9 = (java.io.File) r9
            if (r9 != 0) goto L5e
            i.b.l2 r9 = i.b.b1.e()
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$1 r1 = new com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$1
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity r2 = r8.this$0
            r1.<init>(r2, r7)
            r8.label = r5
            java.lang.Object r9 = i.b.g.i(r9, r1, r8)
            if (r9 != r0) goto L5b
            return r0
        L5b:
            h.t1 r9 = h.t1.a
            return r9
        L5e:
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity r1 = r8.this$0
            android.net.Uri r9 = e.l.r.v.a(r1, r9)
            if (r9 != 0) goto L7d
            i.b.l2 r9 = i.b.b1.e()
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$2 r1 = new com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$2
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity r2 = r8.this$0
            r1.<init>(r2, r7)
            r8.label = r4
            java.lang.Object r9 = i.b.g.i(r9, r1, r8)
            if (r9 != r0) goto L7a
            return r0
        L7a:
            h.t1 r9 = h.t1.a
            return r9
        L7d:
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity r1 = r8.this$0
            e.t.k.b.a r1 = r1.L()
            e.l.s.o.b r1 = (e.l.s.o.b) r1
            r8.label = r3
            java.lang.Object r9 = r1.r0(r9, r8)
            if (r9 != r0) goto L8e
            return r0
        L8e:
            com.jihuanshe.net.api.FileInfo r9 = (com.jihuanshe.net.api.FileInfo) r9
            i.b.l2 r1 = i.b.b1.e()
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$3 r3 = new com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1$3
            com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity r4 = r8.this$0
            r3.<init>(r4, r9, r7)
            r8.label = r2
            java.lang.Object r9 = i.b.g.i(r1, r3, r8)
            if (r9 != r0) goto La4
            return r0
        La4:
            h.t1 r9 = h.t1.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity$handleUri$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
