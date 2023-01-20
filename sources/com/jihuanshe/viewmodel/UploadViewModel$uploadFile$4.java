package com.jihuanshe.viewmodel;

import android.net.Uri;
import e.l.h.k.b;
import h.e2.c;
import h.e2.h;
import h.e2.k.a.f;
import h.k2.u.p;
import h.k2.v.f0;
import h.r0;
import h.t1;
import i.b.n0;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class UploadViewModel$uploadFile$4 extends SuspendLambda implements p<n0, c<? super Boolean>, Object> {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ String $url;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ UploadViewModel this$0;

    /* loaded from: classes2.dex */
    public static final class a implements Callback {
        public final /* synthetic */ UploadViewModel a;
        public final /* synthetic */ c<Boolean> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(UploadViewModel uploadViewModel, c<? super Boolean> cVar) {
            this.a = uploadViewModel;
            this.b = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@d Call call, @d IOException iOException) {
            b.a.b(this.a.b, f0.C("upload file failure,result = ", iOException.getMessage()));
            c<Boolean> cVar = this.b;
            Boolean bool = Boolean.FALSE;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(bool));
        }

        @Override // okhttp3.Callback
        public void onResponse(@d Call call, @d Response response) {
            b.a.b(this.a.b, f0.C("upload file result,response code: ", Integer.valueOf(response.code())));
            c<Boolean> cVar = this.b;
            Boolean valueOf = Boolean.valueOf(response.code() == 200);
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(valueOf));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadViewModel$uploadFile$4(Uri uri, String str, UploadViewModel uploadViewModel, c<? super UploadViewModel$uploadFile$4> cVar) {
        super(2, cVar);
        this.$uri = uri;
        this.$url = str;
        this.this$0 = uploadViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        return new UploadViewModel$uploadFile$4(this.$uri, this.$url, this.this$0, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super Boolean> cVar) {
        return ((UploadViewModel$uploadFile$4) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = h.e2.j.b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            Uri uri = this.$uri;
            String str = this.$url;
            UploadViewModel uploadViewModel = this.this$0;
            this.L$0 = uri;
            this.L$1 = str;
            this.L$2 = uploadViewModel;
            this.label = 1;
            h hVar = new h(IntrinsicsKt__IntrinsicsJvmKt.d(this));
            try {
                InputStream openInputStream = e.t.a.b().getContentResolver().openInputStream(uri);
                byte[] p = openInputStream == null ? null : h.h2.a.p(openInputStream);
                t1 t1Var = t1.a;
                h.h2.b.a(openInputStream, null);
                Request build = new Request.Builder().url(str).put(RequestBody.Companion.create$default(RequestBody.Companion, p, (MediaType) null, 0, 0, 7, (Object) null)).build();
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build().newCall(build).enqueue(new a(uploadViewModel, hVar));
            } catch (Exception e2) {
                b.a.b(uploadViewModel.b, String.valueOf(e2.getMessage()));
                Result.a aVar = Result.Companion;
                hVar.resumeWith(Result.m106constructorimpl(r0.a(e2)));
            }
            obj = hVar.b();
            if (obj == h.e2.j.b.h()) {
                f.c(this);
            }
            if (obj == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            UploadViewModel uploadViewModel2 = (UploadViewModel) this.L$2;
            String str2 = (String) this.L$1;
            Uri uri2 = (Uri) this.L$0;
            r0.n(obj);
        }
        return obj;
    }
}
