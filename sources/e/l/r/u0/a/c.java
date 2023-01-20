package e.l.r.u0.a;

import android.text.InputFilter;
import android.text.Spanned;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class c implements InputFilter {
    private int a = 1;
    private int b = Integer.MAX_VALUE;

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final void c(int i2) {
        this.b = i2;
    }

    public final void d(int i2) {
        this.a = i2;
    }

    @Override // android.text.InputFilter
    @e
    public CharSequence filter(@e CharSequence charSequence, int i2, int i3, @e Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            int parseInt = Integer.parseInt(sb.toString());
            int i6 = this.a;
            boolean z = false;
            if (parseInt <= this.b && i6 <= parseInt) {
                z = true;
            }
            if (z) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
