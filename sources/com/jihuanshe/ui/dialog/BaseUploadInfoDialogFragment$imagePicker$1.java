package com.jihuanshe.ui.dialog;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.ext.UriExtKt;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import e.g.e.a;
import e.t.k.a.f.h;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.b1;
import i.b.g;
import i.b.i;
import i.b.l2;
import i.b.n0;
import java.io.File;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BaseUploadInfoDialogFragment$imagePicker$1 extends Lambda implements l<Uri, t1> {
    public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

    /* renamed from: com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment$imagePicker$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public final /* synthetic */ Uri $it;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

        /* renamed from: com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment$imagePicker$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00971 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
            public int label;
            public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00971(BaseUploadInfoDialogFragment baseUploadInfoDialogFragment, c<? super C00971> cVar) {
                super(2, cVar);
                this.this$0 = baseUploadInfoDialogFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @d
            public final c<t1> create(@e Object obj, @d c<?> cVar) {
                return new C00971(this.this$0, cVar);
            }

            @Override // h.k2.u.p
            @e
            public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
                return ((C00971) create(n0Var, cVar)).invokeSuspend(t1.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @e
            public final Object invokeSuspend(@d Object obj) {
                h hVar;
                b.h();
                if (this.label == 0) {
                    r0.n(obj);
                    hVar = this.this$0.f3942f;
                    if (hVar == null) {
                        return null;
                    }
                    hVar.n();
                    return t1.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment$imagePicker$1$1$2  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends Lambda implements l<FileInfo, t1> {
            public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(BaseUploadInfoDialogFragment baseUploadInfoDialogFragment) {
                super(1);
                this.this$0 = baseUploadInfoDialogFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(FileInfo fileInfo) {
                invoke2(fileInfo);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e FileInfo fileInfo) {
                h hVar;
                hVar = this.this$0.f3942f;
                if (hVar != null) {
                    hVar.n();
                }
                this.this$0.I(fileInfo);
            }
        }

        /* renamed from: com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment$imagePicker$1$1$3  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass3 extends Lambda implements l<a, t1> {
            public final /* synthetic */ n0 $$this$launch;
            public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(BaseUploadInfoDialogFragment baseUploadInfoDialogFragment, n0 n0Var) {
                super(1);
                this.this$0 = baseUploadInfoDialogFragment;
                this.$$this$launch = n0Var;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
                invoke2(aVar);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d a aVar) {
                h hVar;
                hVar = this.this$0.f3942f;
                if (hVar != null) {
                    hVar.n();
                }
                e.l.h.j.b.e.f(this.$$this$launch, "上传失败", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, BaseUploadInfoDialogFragment baseUploadInfoDialogFragment, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$it = uri;
            this.this$0 = baseUploadInfoDialogFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$it, this.this$0, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass1) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            n0 n0Var;
            UploadViewModel Z;
            Object h2 = b.h();
            int i2 = this.label;
            if (i2 == 0) {
                r0.n(obj);
                n0Var = (n0) this.L$0;
                Uri uri = this.$it;
                this.L$0 = n0Var;
                this.label = 1;
                obj = UriExtKt.a(uri, this);
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
                n0Var = (n0) this.L$0;
                r0.n(obj);
            }
            File file = (File) obj;
            if (file != null) {
                Z = this.this$0.Z();
                e.g.d.a.o(e.g.d.a.j(e.g.d.a.h(FlowKt.c(Z.w0(file, null, "report_to_us")), LifecycleOwnerKt.getLifecycleScope(this.this$0), null, 2, null), null, new AnonymousClass2(this.this$0), 1, null), null, new AnonymousClass3(this.this$0, n0Var), 1, null);
                return t1.a;
            }
            l2 e2 = b1.e();
            C00971 c00971 = new C00971(this.this$0, null);
            this.L$0 = null;
            this.label = 2;
            if (g.i(e2, c00971, this) == h2) {
                return h2;
            }
            return t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUploadInfoDialogFragment$imagePicker$1(BaseUploadInfoDialogFragment baseUploadInfoDialogFragment) {
        super(1);
        this.this$0 = baseUploadInfoDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Uri uri) {
        invoke2(uri);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Uri uri) {
        h hVar;
        h hVar2;
        if (uri == null) {
            return;
        }
        hVar = this.this$0.f3942f;
        if (hVar != null) {
            hVar.n();
        }
        this.this$0.f3942f = new h(this.this$0.getActivity(), false, 2, null);
        hVar2 = this.this$0.f3942f;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this.this$0), b1.c(), null, new AnonymousClass1(uri, this.this$0, null), 2, null);
    }
}
