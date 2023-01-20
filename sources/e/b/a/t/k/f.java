package e.b.a.t.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f<T extends View, Z> implements p<Z> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9901f = "CustomViewTarget";
    @IdRes

    /* renamed from: g  reason: collision with root package name */
    private static final int f9902g = R.id.glide_custom_view_target_tag;
    private final b a;
    public final T b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private View.OnAttachStateChangeListener f9903c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9904d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9905e;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.i();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.h();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        private static final int f9906e = 0;
        @Nullable
        @VisibleForTesting

        /* renamed from: f  reason: collision with root package name */
        public static Integer f9907f;
        private final View a;
        private final List<o> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public boolean f9908c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private a f9909d;

        /* loaded from: classes.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<b> a;

            public a(@NonNull b bVar) {
                this.a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(f.f9901f, 2)) {
                    Log.v(f.f9901f, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                b bVar = this.a.get();
                if (bVar != null) {
                    bVar.a();
                    return true;
                }
                return true;
            }
        }

        public b(@NonNull View view) {
            this.a = view;
        }

        private static int c(@NonNull Context context) {
            if (f9907f == null) {
                Display defaultDisplay = ((WindowManager) e.b.a.v.l.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f9907f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f9907f.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f9908c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable(f.f9901f, 4)) {
                Log.i(f.f9901f, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.a.getContext());
        }

        private int f() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean i(int i2, int i3) {
            return h(i2) && h(i3);
        }

        private void j(int i2, int i3) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).e(i2, i3);
            }
        }

        public void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int g2 = g();
            int f2 = f();
            if (i(g2, f2)) {
                j(g2, f2);
                b();
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f9909d);
            }
            this.f9909d = null;
            this.b.clear();
        }

        public void d(@NonNull o oVar) {
            int g2 = g();
            int f2 = f();
            if (i(g2, f2)) {
                oVar.e(g2, f2);
                return;
            }
            if (!this.b.contains(oVar)) {
                this.b.add(oVar);
            }
            if (this.f9909d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                a aVar = new a(this);
                this.f9909d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public void k(@NonNull o oVar) {
            this.b.remove(oVar);
        }
    }

    public f(@NonNull T t) {
        this.b = (T) e.b.a.v.l.d(t);
        this.a = new b(t);
    }

    @Nullable
    private Object b() {
        return this.b.getTag(f9902g);
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9903c;
        if (onAttachStateChangeListener == null || this.f9905e) {
            return;
        }
        this.b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f9905e = true;
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9903c;
        if (onAttachStateChangeListener == null || !this.f9905e) {
            return;
        }
        this.b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f9905e = false;
    }

    private void j(@Nullable Object obj) {
        this.b.setTag(f9902g, obj);
    }

    @NonNull
    public final f<T, Z> a() {
        if (this.f9903c != null) {
            return this;
        }
        this.f9903c = new a();
        d();
        return this;
    }

    @NonNull
    public final T c() {
        return this.b;
    }

    public abstract void f(@Nullable Drawable drawable);

    public void g(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.t.k.p
    @Nullable
    public final e.b.a.t.e getRequest() {
        Object b2 = b();
        if (b2 != null) {
            if (b2 instanceof e.b.a.t.e) {
                return (e.b.a.t.e) b2;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // e.b.a.t.k.p
    public final void getSize(@NonNull o oVar) {
        this.a.d(oVar);
    }

    public final void h() {
        e.b.a.t.e request = getRequest();
        if (request != null) {
            this.f9904d = true;
            request.clear();
            this.f9904d = false;
        }
    }

    public final void i() {
        e.b.a.t.e request = getRequest();
        if (request == null || !request.f()) {
            return;
        }
        request.d();
    }

    @Deprecated
    public final f<T, Z> k(@IdRes int i2) {
        return this;
    }

    @NonNull
    public final f<T, Z> l() {
        this.a.f9908c = true;
        return this;
    }

    @Override // e.b.a.q.m
    public void onDestroy() {
    }

    @Override // e.b.a.t.k.p
    public final void onLoadCleared(@Nullable Drawable drawable) {
        this.a.b();
        f(drawable);
        if (this.f9904d) {
            return;
        }
        e();
    }

    @Override // e.b.a.t.k.p
    public final void onLoadStarted(@Nullable Drawable drawable) {
        d();
        g(drawable);
    }

    @Override // e.b.a.q.m
    public void onStart() {
    }

    @Override // e.b.a.q.m
    public void onStop() {
    }

    @Override // e.b.a.t.k.p
    public final void removeCallback(@NonNull o oVar) {
        this.a.k(oVar);
    }

    @Override // e.b.a.t.k.p
    public final void setRequest(@Nullable e.b.a.t.e eVar) {
        j(eVar);
    }

    public String toString() {
        return "Target for: " + this.b;
    }
}
