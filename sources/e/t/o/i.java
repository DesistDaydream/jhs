package e.t.o;

import androidx.annotation.DimenRes;
import com.effective.android.panel.Constants;
import com.vector.fitter.Mode;
import e.t.o.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/vector/fitter/ScaleDpComputer;", "Lcom/vector/fitter/DpComputer;", "()V", "scale", "", "getScale$vector_release", "()F", Constants.DIMEN, "", "id", "dp", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class i implements c {
    @Override // e.t.o.c
    public int a(float f2) {
        return c.a.a(this, f2);
    }

    @Override // e.t.o.c
    public int b(@DimenRes int i2) {
        f fVar = f.a;
        return a((fVar.e().getDimension(i2) / fVar.f(Mode.DEFAULT).a()) * e());
    }

    @Override // e.t.o.c
    public int c(float f2) {
        return a(f2 * e());
    }

    @Override // e.t.o.c
    public int d(int i2) {
        return a(i2 * e());
    }

    public abstract float e();
}
