package e.t.o;

import androidx.annotation.DimenRes;
import com.effective.android.panel.Constants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/vector/fitter/DpComputer;", "", Constants.DIMEN, "", "id", "dp", "", "toInt", "value", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface c {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        public static int a(@k.e.a.d c cVar, float f2) {
            if (f2 == 0.0f) {
                return 0;
            }
            return Math.round(f2);
        }
    }

    int a(float f2);

    int b(@DimenRes int i2);

    int c(float f2);

    int d(int i2);
}
