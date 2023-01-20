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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class r<T extends View, Z> extends e.b.a.t.k.b<Z> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9922g = "ViewTarget";

    /* renamed from: h  reason: collision with root package name */
    private static boolean f9923h;

    /* renamed from: i  reason: collision with root package name */
    private static int f9924i = R.id.glide_custom_view_target_tag;
    public final T b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9925c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View.OnAttachStateChangeListener f9926d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9927e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9928f;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.i();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.h();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        private static final int f9929e = 0;
        @Nullable
        @VisibleForTesting

        /* renamed from: f  reason: collision with root package name */
        public static Integer f9930f;
        private final View a;
        private final List<o> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public boolean f9931c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private a f9932d;

        /* loaded from: classes.dex */
        public static final class a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<b> a;

            public a(@NonNull b bVar) {
                this.a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(r.f9922g, 2)) {
                    Log.v(r.f9922g, "OnGlobalLayoutListener called attachStateListener=" + this);
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
            if (f9930f == null) {
                Display defaultDisplay = ((WindowManager) e.b.a.v.l.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f9930f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f9930f.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f9931c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable(r.f9922g, 4)) {
                Log.i(r.f9922g, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
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
                viewTreeObserver.removeOnPreDrawListener(this.f9932d);
            }
            this.f9932d = null;
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
            if (this.f9932d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                a aVar = new a(this);
                this.f9932d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public void k(@NonNull o oVar) {
            this.b.remove(oVar);
        }
    }

    public r(@NonNull T t) {
        this.b = (T) e.b.a.v.l.d(t);
        this.f9925c = new b(t);
    }

    @Nullable
    private Object e() {
        return this.b.getTag(f9924i);
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9926d;
        if (onAttachStateChangeListener == null || this.f9928f) {
            return;
        }
        this.b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f9928f = true;
    }

    private void g() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9926d;
        if (onAttachStateChangeListener == null || !this.f9928f) {
            return;
        }
        this.b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f9928f = false;
    }

    private void j(@Nullable Object obj) {
        f9923h = true;
        this.b.setTag(f9924i, obj);
    }

    @Deprecated
    public static void k(int i2) {
        if (!f9923h) {
            f9924i = i2;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @NonNull
    public T b() {
        return this.b;
    }

    @NonNull
    public final r<T, Z> d() {
        if (this.f9926d != null) {
            return this;
        }
        this.f9926d = new a();
        f();
        return this;
    }

    @Override // e.b.a.t.k.b, e.b.a.t.k.p
    @Nullable
    public e.b.a.t.e getRequest() {
        Object e2 = e();
        if (e2 != null) {
            if (e2 instanceof e.b.a.t.e) {
                return (e.b.a.t.e) e2;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // e.b.a.t.k.p
    @CallSuper
    public void getSize(@NonNull o oVar) {
        this.f9925c.d(oVar);
    }

    public void h() {
        e.b.a.t.e request = getRequest();
        if (request != null) {
            this.f9927e = true;
            request.clear();
            this.f9927e = false;
        }
    }

    public void i() {
        e.b.a.t.e request = getRequest();
        if (request == null || !request.f()) {
            return;
        }
        request.d();
    }

    @NonNull
    public final r<T, Z> l() {
        this.f9925c.f9931c = true;
        return this;
    }

    @Override // e.b.a.t.k.b, e.b.a.t.k.p
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f9925c.b();
        if (this.f9927e) {
            return;
        }
        g();
    }

    @Override // e.b.a.t.k.b, e.b.a.t.k.p
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        f();
    }

    @Override // e.b.a.t.k.p
    @CallSuper
    public void removeCallback(@NonNull o oVar) {
        this.f9925c.k(oVar);
    }

    @Override // e.b.a.t.k.b, e.b.a.t.k.p
    public void setRequest(@Nullable e.b.a.t.e eVar) {
        j(eVar);
    }

    public String toString() {
        return "Target for: " + this.b;
    }

    @Deprecated
    public r(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            l();
        }
    }
}
