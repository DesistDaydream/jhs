package e.j.a.c.f0;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes2.dex */
public class c implements InputFilter {
    private int a;

    public c(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public void b(int i2) {
        this.a = i2;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            if (Integer.parseInt(sb.toString()) <= this.a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
