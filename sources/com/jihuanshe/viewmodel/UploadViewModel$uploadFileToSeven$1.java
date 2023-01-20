package com.jihuanshe.viewmodel;

import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.ext.UriExtKt;
import com.jihuanshe.net.api.FileInfo;
import e.l.n.a;
import e.l.n.c.v;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.o;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class UploadViewModel$uploadFileToSeven$1 extends SuspendLambda implements p<f<? super FileInfo>, c<? super t1>, Object> {
    public final /* synthetic */ String $token;
    public final /* synthetic */ String $type;
    public final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public final /* synthetic */ UploadViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadViewModel$uploadFileToSeven$1(Uri uri, String str, String str2, UploadViewModel uploadViewModel, c<? super UploadViewModel$uploadFileToSeven$1> cVar) {
        super(2, cVar);
        this.$uri = uri;
        this.$token = str;
        this.$type = str2;
        this.this$0 = uploadViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        UploadViewModel$uploadFileToSeven$1 uploadViewModel$uploadFileToSeven$1 = new UploadViewModel$uploadFileToSeven$1(this.$uri, this.$token, this.$type, this.this$0, cVar);
        uploadViewModel$uploadFileToSeven$1.L$0 = obj;
        return uploadViewModel$uploadFileToSeven$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d f<? super FileInfo> fVar, @e c<? super t1> cVar) {
        return ((UploadViewModel$uploadFileToSeven$1) create(fVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        f fVar;
        Object B;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            fVar = (f) this.L$0;
            Uri uri = this.$uri;
            String str = this.$token;
            String str2 = this.$type;
            UploadViewModel uploadViewModel = this.this$0;
            this.L$0 = uri;
            this.L$1 = str;
            this.L$2 = str2;
            this.L$3 = uploadViewModel;
            this.L$4 = fVar;
            this.label = 1;
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(this), 1);
            oVar.G();
            v vVar = (v) a.d(v.class, true, false, false, 60L, true);
            String b = UriExtKt.b(uri);
            if (str2 == null) {
                str2 = "avatar";
            }
            e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(vVar.d(b, str, str2)), null, new UploadViewModel$uploadFileToSeven$1$1$1(uploadViewModel, uri, oVar), 1, null), null, new UploadViewModel$uploadFileToSeven$1$1$2(uploadViewModel, oVar), 1, null), ViewModelKt.getViewModelScope(uploadViewModel), null, 2, null);
            B = oVar.B();
            if (B == b.h()) {
                h.e2.k.a.f.c(this);
            }
            if (B == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r0.n(obj);
            return t1.a;
        } else {
            fVar = (f) this.L$4;
            UploadViewModel uploadViewModel2 = (UploadViewModel) this.L$3;
            String str3 = (String) this.L$2;
            String str4 = (String) this.L$1;
            Uri uri2 = (Uri) this.L$0;
            r0.n(obj);
            B = obj;
        }
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.label = 2;
        if (fVar.emit(B, this) == h2) {
            return h2;
        }
        return t1.a;
    }
}
