package com.jihuanshe.ui.page.login;

import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ext.UriExtKt;
import com.jihuanshe.model.User;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.yalantis.ucrop.UCrop;
import e.g.d.a;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.b1;
import i.b.g;
import i.b.l2;
import i.b.n0;
import java.io.File;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$onActivityResult$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Intent $data;
    public int label;
    public final /* synthetic */ LoginActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.login.LoginActivity$onActivityResult$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public final /* synthetic */ File $file;
        public int label;
        public final /* synthetic */ LoginActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.login.LoginActivity$onActivityResult$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01071 extends Lambda implements l<FileInfo, t1> {
            public final /* synthetic */ LoginActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01071(LoginActivity loginActivity) {
                super(1);
                this.this$0 = loginActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(FileInfo fileInfo) {
                invoke2(fileInfo);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e FileInfo fileInfo) {
                ((LoginViewModel) this.this$0.L()).D0().setValue(fileInfo == null ? null : fileInfo.getUri());
                this.this$0.u = fileInfo != null ? fileInfo.getUrl() : null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoginActivity loginActivity, File file, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = loginActivity;
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$file, cVar);
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass1) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            User user;
            b.h();
            if (this.label == 0) {
                r0.n(obj);
                UploadViewModel uploadViewModel = (UploadViewModel) this.this$0.L();
                File file = this.$file;
                user = this.this$0.y;
                BinderKt.p(BinderKt.k(a.j(a.h(FlowKt.c(UploadViewModel.y0(uploadViewModel, file, user == null ? null : user.getToken(), null, 4, null)), LifecycleOwnerKt.getLifecycleScope(this.this$0), null, 2, null), null, new C01071(this.this$0), 1, null), this.this$0, false, 2, null));
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onActivityResult$1(Intent intent, LoginActivity loginActivity, c<? super LoginActivity$onActivityResult$1> cVar) {
        super(2, cVar);
        this.$data = intent;
        this.this$0 = loginActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        return new LoginActivity$onActivityResult$1(this.$data, this.this$0, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
        return ((LoginActivity$onActivityResult$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            Uri output = UCrop.getOutput(this.$data);
            if (output == null) {
                return t1.a;
            }
            this.label = 1;
            obj = UriExtKt.a(output, this);
            if (obj == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r0.n(obj);
            return t1.a;
        } else {
            r0.n(obj);
        }
        File file = (File) obj;
        if (file == null) {
            return t1.a;
        }
        l2 e2 = b1.e();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, file, null);
        this.label = 2;
        if (g.i(e2, anonymousClass1, this) == h2) {
            return h2;
        }
        return t1.a;
    }
}
