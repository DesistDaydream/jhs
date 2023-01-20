package com.jihuanshe.ui.page.common.card;

import android.net.Uri;
import com.eth.ext.FlowKt;
import com.jihuanshe.ext.UriExtKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.net.api.FileInfo;
import e.g.d.a;
import e.t.k.a.f.h;
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
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ProductManagerHeaderImpl$handleUri$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ ProductManagerHeaderImpl this$0;

    /* renamed from: com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl$handleUri$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public int label;
        public final /* synthetic */ ProductManagerHeaderImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ProductManagerHeaderImpl productManagerHeaderImpl, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = productManagerHeaderImpl;
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
                hVar = this.this$0.f4011f;
                if (hVar == null) {
                    return null;
                }
                hVar.n();
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.jihuanshe.ui.page.common.card.ProductManagerHeaderImpl$handleUri$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<FileInfo, t1> {
        public final /* synthetic */ ProductManagerHeaderImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ProductManagerHeaderImpl productManagerHeaderImpl) {
            super(1);
            this.this$0 = productManagerHeaderImpl;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(FileInfo fileInfo) {
            invoke2(fileInfo);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e FileInfo fileInfo) {
            h hVar;
            CardProductNew cardProductNew;
            CardProductNew cardProductNew2;
            hVar = this.this$0.f4011f;
            if (hVar != null) {
                hVar.n();
            }
            cardProductNew = this.this$0.f4012g;
            cardProductNew.setUserUploadPhotoPath(fileInfo == null ? null : fileInfo.getShowPath());
            ProductManagerHeaderImpl productManagerHeaderImpl = this.this$0;
            cardProductNew2 = productManagerHeaderImpl.f4012g;
            productManagerHeaderImpl.s(cardProductNew2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductManagerHeaderImpl$handleUri$1(Uri uri, ProductManagerHeaderImpl productManagerHeaderImpl, c<? super ProductManagerHeaderImpl$handleUri$1> cVar) {
        super(2, cVar);
        this.$uri = uri;
        this.this$0 = productManagerHeaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        return new ProductManagerHeaderImpl$handleUri$1(this.$uri, this.this$0, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
        return ((ProductManagerHeaderImpl$handleUri$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            Uri uri = this.$uri;
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
            r0.n(obj);
        }
        File file = (File) obj;
        if (file == null) {
            l2 e2 = b1.e();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 2;
            if (g.i(e2, anonymousClass1, this) == h2) {
                return h2;
            }
            return t1.a;
        }
        Flow<FileInfo> w = this.this$0.w(file);
        if (w == null) {
            return t1.a;
        }
        a.j(a.h(FlowKt.c(w), this.this$0.o(), null, 2, null), null, new AnonymousClass2(this.this$0), 1, null);
        return t1.a;
    }
}
