package e.t.u;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0011\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/vector/util/IntRes;", "", "value", "", "(I)V", "getValue$vector_release", "()I", "getIntRelatedColor", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "ColorInt", "ColorRes", "DrawableRes", "Lcom/vector/util/IntRes$ColorInt;", "Lcom/vector/util/IntRes$ColorRes;", "Lcom/vector/util/IntRes$DrawableRes;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class m {
    private final int a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/util/IntRes$ColorInt;", "Lcom/vector/util/IntRes;", "value", "", "(I)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends m {
        public a(@ColorInt int i2) {
            super(i2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/util/IntRes$ColorRes;", "Lcom/vector/util/IntRes;", "value", "", "(I)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends m {
        public b(@ColorRes int i2) {
            super(i2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/util/IntRes$DrawableRes;", "Lcom/vector/util/IntRes;", "value", "", "(I)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends m {
        public c(@DrawableRes int i2) {
            super(i2, null);
        }
    }

    private m(int i2) {
        this.a = i2;
    }

    public /* synthetic */ m(int i2, h.k2.v.u uVar) {
        this(i2);
    }

    @k.e.a.e
    public final Integer a(@k.e.a.e Context context) {
        if (this instanceof a) {
            return Integer.valueOf(this.a);
        }
        if (this instanceof b) {
            return Integer.valueOf(w.g(this.a, context));
        }
        return null;
    }

    public final int b() {
        return this.a;
    }

    public /* synthetic */ m(int i2, int i3, h.k2.v.u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, null);
    }
}
