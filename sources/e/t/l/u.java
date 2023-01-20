package e.t.l;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.vector.fitter.Mode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\bH\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/vector/ext/ResourceContext;", "Landroid/content/ContextWrapper;", "mode", "Lcom/vector/fitter/Mode;", "base", "Landroid/content/Context;", "(Lcom/vector/fitter/Mode;Landroid/content/Context;)V", "res", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "getRes", "()Landroid/content/res/Resources;", "getResources", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class u extends ContextWrapper {
    private final Resources a;

    public u(@k.e.a.d Mode mode, @k.e.a.d Context context) {
        super(context);
        this.a = context.getResources();
    }

    public final Resources a() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @k.e.a.d
    public Resources getResources() {
        return this.a;
    }
}
