package com.jihuanshe.viewmodel.login;

import com.jihuanshe.model.User;
import com.jihuanshe.model.stat.STATConstant;
import e.l.n.a;
import e.l.n.c.i;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class LoginViewModel$login$1 extends SuspendLambda implements p<User, c<? super Flow<? extends User>>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$login$1(LoginViewModel loginViewModel, c<? super LoginViewModel$login$1> cVar) {
        super(2, cVar);
        this.this$0 = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        LoginViewModel$login$1 loginViewModel$login$1 = new LoginViewModel$login$1(this.this$0, cVar);
        loginViewModel$login$1.L$0 = obj;
        return loginViewModel$login$1;
    }

    @e
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(@d User user, @e c<? super Flow<User>> cVar) {
        return ((LoginViewModel$login$1) create(user, cVar)).invokeSuspend(t1.a);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Object invoke(User user, c<? super Flow<? extends User>> cVar) {
        return invoke2(user, (c<? super Flow<User>>) cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            final User user = (User) this.L$0;
            LoginViewModel.Q0(this.this$0, user, STATConstant.LOGINTYPE.WX, true, null, 8, null);
            final Flow<User> f2 = ((i) a.d(i.class, true, false, false, 60L, true)).f(user.getToken());
            return new Flow<User>() { // from class: com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1

                /* renamed from: com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1$2 */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements f<User> {
                    public final /* synthetic */ f a;
                    public final /* synthetic */ LoginViewModel$login$1$invokeSuspend$$inlined$map$1 b;

                    /* renamed from: com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1$2$1 */
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

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(c cVar) {
                            super(cVar);
                            AnonymousClass2.this = r1;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @e
                        public final Object invokeSuspend(@d Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(f fVar, LoginViewModel$login$1$invokeSuspend$$inlined$map$1 loginViewModel$login$1$invokeSuspend$$inlined$map$1) {
                        this.a = fVar;
                        this.b = loginViewModel$login$1$invokeSuspend$$inlined$map$1;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:29:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:33:0x0031  */
                    @Override // i.b.v3.f
                    @k.e.a.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(com.jihuanshe.model.User r5, @k.e.a.d h.e2.c r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = h.e2.j.b.h()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            h.r0.n(r6)
                            goto L57
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            h.r0.n(r6)
                            i.b.v3.f r6 = r4.a
                            com.jihuanshe.model.User r5 = (com.jihuanshe.model.User) r5
                            com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1 r2 = r4.b
                            com.jihuanshe.model.User r2 = r2
                            java.lang.String r2 = r2.getToken()
                            r5.setToken(r2)
                            com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1 r2 = r4.b
                            com.jihuanshe.model.User r2 = r2
                            java.lang.String r2 = r2.getSig()
                            r5.setSig(r2)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L57
                            return r1
                        L57:
                            h.t1 r5 = h.t1.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.login.LoginViewModel$login$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @e
                public Object e(@d f<? super User> fVar, @d c cVar) {
                    Object e2 = f2.e(new AnonymousClass2(fVar, this), cVar);
                    return e2 == b.h() ? e2 : t1.a;
                }
            };
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
