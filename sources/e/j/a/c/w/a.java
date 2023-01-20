package e.j.a.c.w;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a extends f {
    private final Typeface a;
    private final InterfaceC0373a b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11060c;

    /* renamed from: e.j.a.c.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0373a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0373a interfaceC0373a, Typeface typeface) {
        this.a = typeface;
        this.b = interfaceC0373a;
    }

    private void d(Typeface typeface) {
        if (this.f11060c) {
            return;
        }
        this.b.a(typeface);
    }

    @Override // e.j.a.c.w.f
    public void a(int i2) {
        d(this.a);
    }

    @Override // e.j.a.c.w.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f11060c = true;
    }
}
