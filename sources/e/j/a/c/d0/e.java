package e.j.a.c.d0;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes2.dex */
public abstract class e {
    public TextInputLayout a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public CheckableImageButton f10616c;

    public e(@NonNull TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.f10616c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i2) {
        return true;
    }

    public void c(boolean z) {
    }

    public boolean d() {
        return false;
    }
}
