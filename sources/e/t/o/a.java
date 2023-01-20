package e.t.o;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.effective.android.panel.Constants;
import e.t.o.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vector/fitter/ContextDpComputerImpl;", "Lcom/vector/fitter/DpComputer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ref", "Ljava/lang/ref/WeakReference;", Constants.DIMEN, "", "id", "dp", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements c {
    @k.e.a.d
    private final WeakReference<Context> a;

    public a(@k.e.a.d Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // e.t.o.c
    public int a(float f2) {
        return c.a.a(this, f2);
    }

    @Override // e.t.o.c
    public int b(int i2) {
        Resources resources;
        Context context = this.a.get();
        float f2 = 0.0f;
        if (context != null && (resources = context.getResources()) != null) {
            f2 = resources.getDimension(i2);
        }
        return a(f2);
    }

    @Override // e.t.o.c
    public int c(float f2) {
        Resources resources;
        Context context = this.a.get();
        DisplayMetrics displayMetrics = null;
        if (context != null && (resources = context.getResources()) != null) {
            displayMetrics = resources.getDisplayMetrics();
        }
        return a(TypedValue.applyDimension(1, f2, displayMetrics));
    }

    @Override // e.t.o.c
    public int d(int i2) {
        return c(i2);
    }
}
