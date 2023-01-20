package e.l.r.u0.a;

import android.text.InputFilter;
import android.text.Spanned;
import com.jihuanshe.utils.StringUtil;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class b implements InputFilter {
    @Override // android.text.InputFilter
    @e
    public CharSequence filter(@e CharSequence charSequence, int i2, int i3, @e Spanned spanned, int i4, int i5) {
        if (charSequence == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (i2 < i3) {
            while (true) {
                int i6 = i2 + 1;
                char charAt = charSequence.charAt(i2);
                if (StringUtil.a.j(charAt)) {
                    sb.append(charAt);
                }
                if (i6 >= i3) {
                    break;
                }
                i2 = i6;
            }
        }
        return sb;
    }
}
