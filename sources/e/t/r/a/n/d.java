package e.t.r.a.n;

import android.graphics.Bitmap;
import androidx.annotation.DrawableRes;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.vector.ext.BitmapKt;
import com.vector.util.Res;
import h.k2.v.u;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vector/network/image/interceptor/MultiplyInterceptor;", "Lcom/vector/network/image/interceptor/Interceptor;", "id", "", "useAlpha", "", "(IZ)V", "mask", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Z)V", "getId", "()I", "setId", "(I)V", UMModuleRegister.PROCESS, "srcBmp", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d implements c {
    @e
    private final Bitmap a;
    private final boolean b;
    @DrawableRes

    /* renamed from: c  reason: collision with root package name */
    private int f14636c;

    public d(@e Bitmap bitmap, boolean z) {
        this.a = bitmap;
        this.b = z;
    }

    @Override // e.t.r.a.n.c
    @k.e.a.d
    public Bitmap a(@k.e.a.d Bitmap bitmap) {
        Bitmap bitmap2 = this.a;
        if (bitmap2 != null) {
            return BitmapKt.o(bitmap, bitmap2, this.b);
        }
        Bitmap f2 = Res.f(Res.a, e.t.a.b(), this.f14636c, null, null, 12, null);
        Bitmap o = BitmapKt.o(bitmap, f2, this.b);
        if (f2 == null) {
            return o;
        }
        f2.recycle();
        return o;
    }

    public final int b() {
        return this.f14636c;
    }

    public final void c(int i2) {
        this.f14636c = i2;
    }

    public /* synthetic */ d(Bitmap bitmap, boolean z, int i2, u uVar) {
        this(bitmap, (i2 & 2) != 0 ? false : z);
    }

    public d(@DrawableRes int i2, boolean z) {
        this((Bitmap) null, z);
        this.f14636c = i2;
    }

    public /* synthetic */ d(int i2, boolean z, int i3, u uVar) {
        this(i2, (i3 & 2) != 0 ? false : z);
    }
}
