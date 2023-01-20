package e.t.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.StringRes;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.vector.util.Res;
import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/vector/ext/Toaster;", "", "()V", "keeper", "Landroid/widget/Toast;", "getKeeper", "()Landroid/widget/Toast;", "setKeeper", "(Landroid/widget/Toast;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", TTLogUtil.TAG_EVENT_SHOW, "", "context", "Landroid/content/Context;", "id", "", "duration", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    @k.e.a.d
    public static final y a = new y();
    @k.e.a.e
    private static Toast b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private static String f14600c;

    private y() {
    }

    public static /* synthetic */ void g(y yVar, Context context, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        yVar.e(context, i2, i3);
    }

    public static /* synthetic */ void h(y yVar, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        yVar.f(str, i2);
    }

    @k.e.a.e
    public final Toast a() {
        return b;
    }

    @k.e.a.e
    public final String b() {
        return f14600c;
    }

    public final void c(@k.e.a.e Toast toast) {
        b = toast;
    }

    public final void d(@k.e.a.e String str) {
        f14600c = str;
    }

    public final void e(@k.e.a.d Context context, @StringRes int i2, int i3) {
        f(Res.a.u(i2, context), i3);
    }

    @SuppressLint({"ShowToast"})
    public final void f(@k.e.a.e String str, int i2) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (b == null || !f0.g(str, f14600c)) {
            b = Toast.makeText(e.t.a.b(), str, i2);
            f14600c = str;
        }
        Toast toast = b;
        if (toast == null) {
            return;
        }
        toast.show();
    }
}
