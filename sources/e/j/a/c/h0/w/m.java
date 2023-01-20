package e.j.a.c.h0.w;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes2.dex */
public class m extends SharedElementCallback {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<View> f10807f;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Rect f10809d;
    private boolean a = true;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10808c = false;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private d f10810e = new e();

    /* loaded from: classes2.dex */
    public class a extends u {
        public final /* synthetic */ Window a;

        public a(Window window) {
            this.a = window;
        }

        @Override // e.j.a.c.h0.w.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            m.i(this.a);
        }

        @Override // e.j.a.c.h0.w.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.h(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends u {
        public final /* synthetic */ Activity a;

        public b(Activity activity) {
            this.a = activity;
        }

        @Override // e.j.a.c.h0.w.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            View view;
            if (m.f10807f != null && (view = (View) m.f10807f.get()) != null) {
                view.setAlpha(1.0f);
                WeakReference unused = m.f10807f = null;
            }
            this.a.finish();
            this.a.overridePendingTransition(0, 0);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends u {
        public final /* synthetic */ Window a;

        public c(Window window) {
            this.a = window;
        }

        @Override // e.j.a.c.h0.w.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.h(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        @Nullable
        e.j.a.c.z.o a(@NonNull View view);
    }

    /* loaded from: classes2.dex */
    public static class e implements d {
        @Override // e.j.a.c.h0.w.m.d
        @Nullable
        public e.j.a.c.z.o a(@NonNull View view) {
            if (view instanceof e.j.a.c.z.s) {
                return ((e.j.a.c.z.s) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private void m(Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof l) {
            l lVar = (l) sharedElementEnterTransition;
            if (!this.f10808c) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.b) {
                o(window, lVar);
                lVar.addListener(new a(window));
            }
        }
    }

    private void n(Activity activity, Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof l) {
            l lVar = (l) sharedElementReturnTransition;
            lVar.X(true);
            lVar.addListener(new b(activity));
            if (this.b) {
                o(window, lVar);
                lVar.addListener(new c(window));
            }
        }
    }

    private static void o(Window window, l lVar) {
        if (lVar.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(lVar.getDuration());
        }
    }

    @Nullable
    public d e() {
        return this.f10810e;
    }

    public boolean f() {
        return this.f10808c;
    }

    public boolean g() {
        return this.b;
    }

    public void j(@Nullable d dVar) {
        this.f10810e = dVar;
    }

    public void k(boolean z) {
        this.f10808c = z;
    }

    public void l(boolean z) {
        this.b = z;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View view, @NonNull Matrix matrix, @NonNull RectF rectF) {
        f10807f = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context context, @Nullable Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        e.j.a.c.z.o a2;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (onCreateSnapshotView != null && (weakReference = f10807f) != null && this.f10810e != null && (view = weakReference.get()) != null && (a2 = this.f10810e.a(view)) != null) {
            onCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, a2);
        }
        return onCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> list, @NonNull Map<String, View> map) {
        View view;
        Activity activity;
        if (list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activity = e.j.a.c.s.b.getActivity(view.getContext())) == null) {
            return;
        }
        Window window = activity.getWindow();
        if (this.a) {
            m(window);
        } else {
            n(activity, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty()) {
            int i2 = R.id.mtrl_motion_snapshot_view;
            if (list2.get(0).getTag(i2) instanceof View) {
                list2.get(0).setTag(i2, null);
            }
        }
        if (!this.a && !list2.isEmpty()) {
            this.f10809d = v.k(list2.get(0));
        }
        this.a = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.a || list2.isEmpty() || this.f10809d == null) {
            return;
        }
        View view = list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f10809d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f10809d.height(), 1073741824));
        Rect rect = this.f10809d;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
