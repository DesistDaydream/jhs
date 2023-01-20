package e.t.l;

import android.content.Context;
import androidx.annotation.StringRes;
import com.vector.util.Res;
import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a-\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\n\u001a(\u0010\u0000\u001a\u00020\u00012\f\b\u0001\u0010\u000b\u001a\u00020\f\"\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"toast", "", "context", "Landroid/content/Context;", "id", "", "duration", "texts", "", "", "([Ljava/lang/String;I)V", "ids", "", "text", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    public static final void a(@k.e.a.d Context context, @StringRes int i2, int i3) {
        y.a.e(context, i2, i3);
    }

    public static final void b(@k.e.a.e String str, int i2) {
        y.a.f(str, i2);
    }

    public static final void c(@StringRes @k.e.a.d int[] iArr, @k.e.a.d Context context, int i2) {
        if (iArr.length == 0) {
            return;
        }
        String str = new String();
        for (int i3 : iArr) {
            str = f0.C(str, Res.a.u(i3, context));
        }
        y.a.f(str, i2);
    }

    public static final void d(@k.e.a.d String[] strArr, int i2) {
        if (strArr.length == 0) {
            return;
        }
        String str = new String();
        for (String str2 : strArr) {
            str = f0.C(str, str2);
        }
        y.a.f(str, i2);
    }

    public static /* synthetic */ void e(Context context, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            context = e.t.a.b();
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        a(context, i2, i3);
    }

    public static /* synthetic */ void f(String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        b(str, i2);
    }

    public static /* synthetic */ void g(int[] iArr, Context context, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            context = e.t.a.b();
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        c(iArr, context, i2);
    }

    public static /* synthetic */ void h(String[] strArr, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        d(strArr, i2);
    }
}
