package e.j.a.b.c.r;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
public final class n0 extends i {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Fragment b;

    /* renamed from: c */
    private final /* synthetic */ int f10436c;

    public n0(Intent intent, Fragment fragment, int i2) {
        this.a = intent;
        this.b = fragment;
        this.f10436c = i2;
    }

    @Override // e.j.a.b.c.r.i
    public final void d() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.f10436c);
        }
    }
}
