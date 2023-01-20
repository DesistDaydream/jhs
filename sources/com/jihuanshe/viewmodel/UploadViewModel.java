package com.jihuanshe.viewmodel;

import android.net.Uri;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.net.api.FileInfo;
import e.l.r.b0;
import h.e2.c;
import h.e2.h;
import h.e2.k.a.f;
import h.k2.v.f0;
import h.r0;
import h.w;
import h.z;
import i.b.b1;
import i.b.g;
import j.m0;
import j.n;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.flow.Flow;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class UploadViewModel extends e.l.h.l.b {
    @d
    private final String b = "UploadViewModel";
    @d

    /* renamed from: c  reason: collision with root package name */
    private final w f4368c = z.c(UploadViewModel$fileLengthUnitM$2.INSTANCE);

    /* loaded from: classes2.dex */
    public static final class a implements Callback {
        public final /* synthetic */ c<Boolean> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(c<? super Boolean> cVar) {
            this.b = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@d Call call, @d IOException iOException) {
            e.l.h.k.b.a.b(UploadViewModel.this.b, f0.C("upload file failure,result = ", iOException.getMessage()));
            c<Boolean> cVar = this.b;
            Boolean bool = Boolean.FALSE;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(bool));
        }

        @Override // okhttp3.Callback
        public void onResponse(@d Call call, @d Response response) {
            e.l.h.k.b.a.b(UploadViewModel.this.b, f0.C("upload file result,response code: ", Integer.valueOf(response.code())));
            c<Boolean> cVar = this.b;
            Boolean valueOf = Boolean.valueOf(response.code() == 200);
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(valueOf));
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends RequestBody {
        public final /* synthetic */ File a;
        public final /* synthetic */ File b;

        public b(File file, File file2) {
            this.a = file;
            this.b = file2;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            File file = this.a;
            Long valueOf = file == null ? null : Long.valueOf(file.length());
            return valueOf == null ? this.b.length() : valueOf.longValue();
        }

        @Override // okhttp3.RequestBody
        @e
        public MediaType contentType() {
            return null;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(@d n nVar) {
            m0 m0Var = null;
            try {
                try {
                    File file = this.a;
                    m0 l2 = file == null ? null : j.z.l(file);
                    m0Var = l2 == null ? j.z.l(this.b) : l2;
                    while (m0Var.read(nVar.getBuffer(), SVG.A) != -1) {
                        nVar.z();
                    }
                    if (m0Var == null) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (m0Var == null) {
                        return;
                    }
                }
                m0Var.close();
            } catch (Throwable th) {
                if (m0Var != null) {
                    m0Var.close();
                }
                throw th;
            }
        }
    }

    private final int q0() {
        return ((Number) this.f4368c.getValue()).intValue();
    }

    public static /* synthetic */ Object u0(UploadViewModel uploadViewModel, String str, File file, boolean z, c cVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return uploadViewModel.t0(str, file, z, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
    }

    public static /* synthetic */ Flow x0(UploadViewModel uploadViewModel, Uri uri, String str, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            return uploadViewModel.v0(uri, str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFileToSeven");
    }

    public static /* synthetic */ Flow y0(UploadViewModel uploadViewModel, File file, String str, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            return uploadViewModel.w0(file, str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFileToSeven");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:10)(2:22|23))(6:24|25|(1:27)(1:32)|28|29|(1:31))|11|(2:13|(2:15|16)(2:18|19))(2:20|21)))|35|6|7|(0)(0)|11|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b1, code lost:
        r15 = kotlin.Result.Companion;
        kotlin.Result.m106constructorimpl(h.r0.a(r14));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092 A[Catch: all -> 0x00b0, TryCatch #2 {all -> 0x00b0, blocks: (B:11:0x0026, B:24:0x008a, B:26:0x0092, B:29:0x009b, B:31:0x00a3, B:16:0x0035, B:21:0x005c, B:20:0x005a, B:19:0x0055), top: B:41:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3 A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #2 {all -> 0x00b0, blocks: (B:11:0x0026, B:24:0x008a, B:26:0x0092, B:29:0x009b, B:31:0x00a3, B:16:0x0035, B:21:0x005c, B:20:0x005a, B:19:0x0055), top: B:41:0x0022 }] */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r0(@k.e.a.d android.net.Uri r14, @k.e.a.d h.e2.c<? super com.jihuanshe.net.api.FileInfo> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.jihuanshe.viewmodel.UploadViewModel$uploadFile$5
            if (r0 == 0) goto L13
            r0 = r15
            com.jihuanshe.viewmodel.UploadViewModel$uploadFile$5 r0 = (com.jihuanshe.viewmodel.UploadViewModel$uploadFile$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.jihuanshe.viewmodel.UploadViewModel$uploadFile$5 r0 = new com.jihuanshe.viewmodel.UploadViewModel$uploadFile$5
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            h.r0.n(r15)     // Catch: java.lang.Throwable -> Lb0
            goto L8a
        L2a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L32:
            h.r0.n(r15)
            kotlin.Result$a r15 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Lb0
            r9 = 60
            java.lang.Class<e.l.n.c.k> r5 = e.l.n.c.k.class
            r6 = 1
            r7 = 0
            r8 = 0
            r11 = 1
            java.lang.Object r15 = e.l.n.a.d(r5, r6, r7, r8, r9, r11)     // Catch: java.lang.Throwable -> Lb0
            e.l.n.c.k r15 = (e.l.n.c.k) r15     // Catch: java.lang.Throwable -> Lb0
            android.content.Context r2 = e.t.a.b()     // Catch: java.lang.Throwable -> Lb0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> Lb0
            java.io.InputStream r2 = r2.openInputStream(r14)     // Catch: java.lang.Throwable -> Lb0
            if (r2 != 0) goto L55
            r7 = r4
            goto L5a
        L55:
            byte[] r5 = h.h2.a.p(r2)     // Catch: java.lang.Throwable -> La9
            r7 = r5
        L5a:
            h.t1 r5 = h.t1.a     // Catch: java.lang.Throwable -> La9
            h.h2.b.a(r2, r4)     // Catch: java.lang.Throwable -> Lb0
            okhttp3.RequestBody$Companion r2 = okhttp3.RequestBody.Companion     // Catch: java.lang.Throwable -> Lb0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 7
            r12 = 0
            r6 = r2
            okhttp3.RequestBody r5 = okhttp3.RequestBody.Companion.create$default(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lb0
            okhttp3.MultipartBody$Part$Companion r6 = okhttp3.MultipartBody.Part.Companion     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r7 = "file"
            android.content.Context r8 = e.t.a.b()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r14 = e.t.l.z.g(r14, r8)     // Catch: java.lang.Throwable -> Lb0
            okhttp3.MultipartBody$Part r14 = r6.createFormData(r7, r14, r5)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r5 = "ecommerce"
            okhttp3.RequestBody r2 = okhttp3.RequestBody.Companion.create$default(r2, r5, r4, r3, r4)     // Catch: java.lang.Throwable -> Lb0
            r0.label = r3     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r15 = r15.u(r14, r2, r0)     // Catch: java.lang.Throwable -> Lb0
            if (r15 != r1) goto L8a
            return r1
        L8a:
            l.r r15 = (l.r) r15     // Catch: java.lang.Throwable -> Lb0
            boolean r14 = r15.g()     // Catch: java.lang.Throwable -> Lb0
            if (r14 == 0) goto La3
            java.lang.Object r14 = r15.a()     // Catch: java.lang.Throwable -> Lb0
            com.jihuanshe.base.model.Result r14 = (com.jihuanshe.base.model.Result) r14     // Catch: java.lang.Throwable -> Lb0
            if (r14 != 0) goto L9b
            goto La2
        L9b:
            java.lang.Object r14 = r14.getData()     // Catch: java.lang.Throwable -> Lb0
            com.jihuanshe.net.api.FileInfo r14 = (com.jihuanshe.net.api.FileInfo) r14     // Catch: java.lang.Throwable -> Lb0
            r4 = r14
        La2:
            return r4
        La3:
            h.t1 r14 = h.t1.a     // Catch: java.lang.Throwable -> Lb0
            kotlin.Result.m106constructorimpl(r14)     // Catch: java.lang.Throwable -> Lb0
            goto Lba
        La9:
            r14 = move-exception
            throw r14     // Catch: java.lang.Throwable -> Lab
        Lab:
            r15 = move-exception
            h.h2.b.a(r2, r14)     // Catch: java.lang.Throwable -> Lb0
            throw r15     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r14 = move-exception
            kotlin.Result$a r15 = kotlin.Result.Companion
            java.lang.Object r14 = h.r0.a(r14)
            kotlin.Result.m106constructorimpl(r14)
        Lba:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.UploadViewModel.r0(android.net.Uri, h.e2.c):java.lang.Object");
    }

    @e
    public final Object s0(@d String str, @d Uri uri, @d c<? super Boolean> cVar) {
        return g.i(b1.c(), new UploadViewModel$uploadFile$4(uri, str, this, null), cVar);
    }

    @e
    public final Object t0(@d String str, @d File file, boolean z, @d c<? super Boolean> cVar) {
        File file2 = (!z || file.length() <= ((long) (q0() * 2))) ? null : new File(b0.a.c(file.getPath(), 60));
        h hVar = new h(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        try {
            Request build = new Request.Builder().url(str).put(new b(file2, file)).build();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build().newCall(build).enqueue(new a(hVar));
        } catch (Exception e2) {
            e.l.h.k.b.a.b(this.b, String.valueOf(e2.getMessage()));
            Result.a aVar = Result.Companion;
            hVar.resumeWith(Result.m106constructorimpl(r0.a(e2)));
        }
        Object b2 = hVar.b();
        if (b2 == h.e2.j.b.h()) {
            f.c(cVar);
        }
        return b2;
    }

    @d
    public final Flow<FileInfo> v0(@d Uri uri, @e String str, @e String str2) {
        return i.b.v3.h.N0(new UploadViewModel$uploadFileToSeven$1(uri, str, str2, this, null));
    }

    @d
    public final Flow<FileInfo> w0(@d File file, @e String str, @e String str2) {
        return i.b.v3.h.N0(new UploadViewModel$uploadFileToSeven$2(file, str, str2, this, null));
    }
}
