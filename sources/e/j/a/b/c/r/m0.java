package e.j.a.b.c.r;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class m0 extends i {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Activity b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f10433c;

    public m0(Intent intent, Activity activity, int i2) {
        this.a = intent;
        this.b = activity;
        this.f10433c = i2;
    }

    @Override // e.j.a.b.c.r.i
    public final void d() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.f10433c);
        }
    }
}
