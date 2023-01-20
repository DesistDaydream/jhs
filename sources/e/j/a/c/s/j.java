package e.j.a.c.s;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private float f10998c;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private e.j.a.c.w.d f11001f;
    private final TextPaint a = new TextPaint(1);
    private final e.j.a.c.w.f b = new a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f10999d = true;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<b> f11000e = new WeakReference<>(null);

    /* loaded from: classes2.dex */
    public class a extends e.j.a.c.w.f {
        public a() {
        }

        @Override // e.j.a.c.w.f
        public void a(int i2) {
            j.this.f10999d = true;
            b bVar = (b) j.this.f11000e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // e.j.a.c.w.f
        public void b(@NonNull Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            j.this.f10999d = true;
            b bVar = (b) j.this.f11000e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public j(@Nullable b bVar) {
        h(bVar);
    }

    private float c(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public e.j.a.c.w.d d() {
        return this.f11001f;
    }

    @NonNull
    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.f10999d) {
            return this.f10998c;
        }
        float c2 = c(str);
        this.f10998c = c2;
        this.f10999d = false;
        return c2;
    }

    public boolean g() {
        return this.f10999d;
    }

    public void h(@Nullable b bVar) {
        this.f11000e = new WeakReference<>(bVar);
    }

    public void i(@Nullable e.j.a.c.w.d dVar, Context context) {
        if (this.f11001f != dVar) {
            this.f11001f = dVar;
            if (dVar != null) {
                dVar.k(context, this.a, this.b);
                b bVar = this.f11000e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.j(context, this.a, this.b);
                this.f10999d = true;
            }
            b bVar2 = this.f11000e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void j(boolean z) {
        this.f10999d = z;
    }

    public void k(Context context) {
        this.f11001f.j(context, this.a, this.b);
    }
}
