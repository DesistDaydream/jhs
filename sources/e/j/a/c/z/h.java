package e.j.a.c.z;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class h {
    private View a;
    private j b;

    /* renamed from: c  reason: collision with root package name */
    private ScrollView f11106c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f11107d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    private final int[] f11108e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f11109f = new a();

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            h.this.e();
        }
    }

    public h(View view, j jVar, ScrollView scrollView) {
        this.a = view;
        this.b = jVar;
        this.f11106c = scrollView;
    }

    public void a(ScrollView scrollView) {
        this.f11106c = scrollView;
    }

    public void b(j jVar) {
        this.b = jVar;
    }

    public void c(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f11109f);
    }

    public void d(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f11109f);
    }

    public void e() {
        ScrollView scrollView = this.f11106c;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() != 0) {
            this.f11106c.getLocationInWindow(this.f11107d);
            this.f11106c.getChildAt(0).getLocationInWindow(this.f11108e);
            int top = (this.a.getTop() - this.f11107d[1]) + this.f11108e[1];
            int height = this.a.getHeight();
            int height2 = this.f11106c.getHeight();
            if (top < 0) {
                this.b.o0(Math.max(0.0f, Math.min(1.0f, (top / height) + 1.0f)));
                this.a.invalidate();
                return;
            }
            int i2 = top + height;
            if (i2 > height2) {
                this.b.o0(Math.max(0.0f, Math.min(1.0f, 1.0f - ((i2 - height2) / height))));
                this.a.invalidate();
                return;
            } else if (this.b.z() != 1.0f) {
                this.b.o0(1.0f);
                this.a.invalidate();
                return;
            } else {
                return;
            }
        }
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}
