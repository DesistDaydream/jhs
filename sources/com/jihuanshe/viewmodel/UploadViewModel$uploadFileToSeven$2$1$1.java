package com.jihuanshe.viewmodel;

import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import com.eth.model.NetException;
import com.jihuanshe.model.UploadInfo;
import com.jihuanshe.net.api.FileInfo;
import e.l.h.k.b;
import e.l.r.l0;
import e.l.r.v;
import e.t.a;
import h.e2.c;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.b1;
import i.b.i;
import i.b.n;
import i.b.n0;
import java.io.File;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class UploadViewModel$uploadFileToSeven$2$1$1 extends Lambda implements l<UploadInfo, t1> {
    public final /* synthetic */ n<FileInfo> $continuation;
    public final /* synthetic */ File $file;
    public final /* synthetic */ UploadViewModel this$0;

    /* renamed from: com.jihuanshe.viewmodel.UploadViewModel$uploadFileToSeven$2$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public final /* synthetic */ n<FileInfo> $continuation;
        public final /* synthetic */ File $file;
        public final /* synthetic */ UploadInfo $it;
        public int label;
        public final /* synthetic */ UploadViewModel this$0;

        /* renamed from: com.jihuanshe.viewmodel.UploadViewModel$uploadFileToSeven$2$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01411 extends Lambda implements l<String, t1> {
            public final /* synthetic */ n<FileInfo> $continuation;
            public final /* synthetic */ File $file;
            public final /* synthetic */ UploadInfo $it;
            public final /* synthetic */ UploadViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C01411(UploadViewModel uploadViewModel, n<? super FileInfo> nVar, File file, UploadInfo uploadInfo) {
                super(1);
                this.this$0 = uploadViewModel;
                this.$continuation = nVar;
                this.$file = file;
                this.$it = uploadInfo;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(String str) {
                invoke2(str);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e String str) {
                if (str == null || str.length() == 0) {
                    b.a.b(this.this$0.b, "qiniu result is null");
                    n<FileInfo> nVar = this.$continuation;
                    NetException netException = new NetException("", "上传失败");
                    Result.a aVar = Result.Companion;
                    nVar.resumeWith(Result.m106constructorimpl(r0.a(netException)));
                    return;
                }
                n<FileInfo> nVar2 = this.$continuation;
                Uri a = v.a(a.b(), this.$file);
                UploadInfo uploadInfo = this.$it;
                FileInfo fileInfo = new FileInfo("", str, a, uploadInfo == null ? null : uploadInfo.getShowPath());
                Result.a aVar2 = Result.Companion;
                nVar2.resumeWith(Result.m106constructorimpl(fileInfo));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(File file, UploadInfo uploadInfo, UploadViewModel uploadViewModel, n<? super FileInfo> nVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$file = file;
            this.$it = uploadInfo;
            this.this$0 = uploadViewModel;
            this.$continuation = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass1(this.$file, this.$it, this.this$0, this.$continuation, cVar);
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass1) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            h.e2.j.b.h();
            if (this.label == 0) {
                r0.n(obj);
                l0 l0Var = l0.a;
                File file = this.$file;
                UploadInfo uploadInfo = this.$it;
                String url = uploadInfo == null ? null : uploadInfo.getUrl();
                if (url == null) {
                    url = "";
                }
                UploadInfo uploadInfo2 = this.$it;
                String token = uploadInfo2 != null ? uploadInfo2.getToken() : null;
                l0Var.d(file, url, token != null ? token : "", new C01411(this.this$0, this.$continuation, this.$file, this.$it));
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadViewModel$uploadFileToSeven$2$1$1(UploadViewModel uploadViewModel, File file, n<? super FileInfo> nVar) {
        super(1);
        this.this$0 = uploadViewModel;
        this.$file = file;
        this.$continuation = nVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(UploadInfo uploadInfo) {
        invoke2(uploadInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e UploadInfo uploadInfo) {
        i.f(ViewModelKt.getViewModelScope(this.this$0), b1.c(), null, new AnonymousClass1(this.$file, uploadInfo, this.this$0, this.$continuation, null), 2, null);
    }
}
