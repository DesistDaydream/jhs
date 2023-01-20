package e.t.r.a.n;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.vector.ext.BitmapKt;
import h.k2.v.u;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/vector/network/image/interceptor/BlurInterceptor;", "Lcom/vector/network/image/interceptor/Interceptor;", "radius", "", "maskAlpha", "scale", "context", "Landroid/content/Context;", "(IIILandroid/content/Context;)V", UMModuleRegister.PROCESS, "Landroid/graphics/Bitmap;", "srcBmp", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements c {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final C0417a f14630e = new C0417a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final int f14631f = 15;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14632g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14633h = 1;
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14634c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private final Context f14635d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vector/network/image/interceptor/BlurInterceptor$Companion;", "", "()V", "DEFAULT_MASK_ALPHA", "", "DEFAULT_RADIUS", "DEFAULT_SCALE", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.r.a.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0417a {
        private C0417a() {
        }

        public /* synthetic */ C0417a(u uVar) {
            this();
        }
    }

    public a() {
        this(0, 0, 0, null, 15, null);
    }

    public a(int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 1, to = 10) int i4, @e Context context) {
        this.a = i2;
        this.b = i3;
        this.f14634c = i4;
        this.f14635d = context;
    }

    @Override // e.t.r.a.n.c
    @k.e.a.d
    public Bitmap a(@k.e.a.d Bitmap bitmap) {
        return BitmapKt.d(bitmap, this.f14634c, this.a, this.b);
    }

    public /* synthetic */ a(int i2, int i3, int i4, Context context, int i5, u uVar) {
        this((i5 & 1) != 0 ? 15 : i2, (i5 & 2) != 0 ? 0 : i3, (i5 & 4) != 0 ? 1 : i4, (i5 & 8) != 0 ? null : context);
    }
}
