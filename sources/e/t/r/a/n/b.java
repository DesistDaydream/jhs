package e.t.r.a.n;

import android.graphics.Bitmap;
import com.qiniu.android.collect.ReportItem;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.vector.ext.BitmapKt;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016R,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/vector/network/image/interceptor/FetchInterceptor;", "Lcom/vector/network/image/interceptor/Interceptor;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "", "(Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", UMModuleRegister.PROCESS, "srcBmp", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements c {
    @k.e.a.d
    private final l<Bitmap, t1> a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k.e.a.d l<? super Bitmap, t1> lVar) {
        this.a = lVar;
    }

    @Override // e.t.r.a.n.c
    @k.e.a.d
    public Bitmap a(@k.e.a.d Bitmap bitmap) {
        this.a.invoke(BitmapKt.l(bitmap, null, 1, null));
        return bitmap;
    }

    @k.e.a.d
    public final l<Bitmap, t1> b() {
        return this.a;
    }
}
