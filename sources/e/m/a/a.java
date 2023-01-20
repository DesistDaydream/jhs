package e.m.a;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import h.t2.y;

/* loaded from: classes2.dex */
public class a extends PasswordTransformationMethod {

    /* renamed from: e.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0402a implements CharSequence {
        private CharSequence a;

        public C0402a(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i2) {
            return y.D;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.a.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i2, int i3) {
            return this.a.subSequence(i2, i3);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new C0402a(charSequence);
    }
}
