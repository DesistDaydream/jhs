package e.t.u;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.f0;
import h.k2.v.n0;
import h.t1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/vector/util/IMMLeaks;", "", "()V", "fixFocusedViewLeak", "", "application", "Landroid/app/Application;", "ReferenceCleaner", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class k {
    @k.e.a.d
    public static final k a = new k();

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/vector/util/IMMLeaks$ReferenceCleaner;", "Landroid/os/MessageQueue$IdleHandler;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "mHField", "Ljava/lang/reflect/Field;", "mServedViewField", "finishInputLockedMethod", "Ljava/lang/reflect/Method;", "(Landroid/view/inputmethod/InputMethodManager;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Method;)V", "clearInputMethodManagerLeak", "", "extractActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "onGlobalFocusChanged", "oldFocus", "Landroid/view/View;", "newFocus", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "queueIdle", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements MessageQueue.IdleHandler, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalFocusChangeListener {
        @k.e.a.d
        private final InputMethodManager a;
        @k.e.a.d
        private final Field b;
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        private final Field f14666c;
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final Method f14667d;

        public a(@k.e.a.d InputMethodManager inputMethodManager, @k.e.a.d Field field, @k.e.a.d Field field2, @k.e.a.d Method method) {
            this.a = inputMethodManager;
            this.b = field;
            this.f14666c = field2;
            this.f14667d = method;
        }

        @TargetApi(19)
        private final void a() {
            try {
                Object obj = this.b.get(this.a);
                if (obj == null) {
                    obj = new Object();
                }
                synchronized (obj) {
                    Object obj2 = this.f14666c.get(this.a);
                    View view = obj2 instanceof View ? (View) obj2 : null;
                    if (view != null) {
                        boolean z = true;
                        if (view.getWindowVisibility() != 8) {
                            view.removeOnAttachStateChangeListener(this);
                            view.addOnAttachStateChangeListener(this);
                        } else {
                            Activity b = b(view.getContext());
                            if (b != null && b.getWindow() != null) {
                                View peekDecorView = b.getWindow().peekDecorView();
                                if (peekDecorView.getWindowVisibility() == 8) {
                                    z = false;
                                }
                                if (!z) {
                                    this.f14667d.invoke(this.a, new Object[0]);
                                } else {
                                    peekDecorView.requestFocusFromTouch();
                                }
                            }
                            this.f14667d.invoke(this.a, new Object[0]);
                        }
                    }
                    t1 t1Var = t1.a;
                }
            } catch (IllegalAccessException e2) {
                Log.e("IMMLeaks", "Unexpected reflection exception", e2);
            } catch (InvocationTargetException e3) {
                Log.e("IMMLeaks", "Unexpected reflection exception", e3);
            }
        }

        private final Activity b(Context context) {
            Context baseContext;
            while (!(context instanceof Application)) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
                    return null;
                }
                context = baseContext;
            }
            return null;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(@k.e.a.e View view, @k.e.a.e View view2) {
            if (view2 == null) {
                return;
            }
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            Looper.myQueue().removeIdleHandler(this);
            view2.addOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@k.e.a.d View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@k.e.a.d View view) {
            view.removeOnAttachStateChangeListener(this);
            Looper.myQueue().removeIdleHandler(this);
            Looper.myQueue().addIdleHandler(this);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            a();
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/vector/util/IMMLeaks$fixFocusedViewLeak$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ InputMethodManager a;
        public final /* synthetic */ Field b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Field f14668c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Method f14669d;

        public b(InputMethodManager inputMethodManager, Field field, Field field2, Method method) {
            this.a = inputMethodManager;
            this.b = field;
            this.f14668c = field2;
            this.f14669d = method;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@k.e.a.d Activity activity, @k.e.a.e Bundle bundle) {
            activity.getWindow().getDecorView().getRootView().getViewTreeObserver().addOnGlobalFocusChangeListener(new a(this.a, this.b, this.f14668c, this.f14669d));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@k.e.a.d Activity activity, @k.e.a.d Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@k.e.a.d Activity activity) {
        }
    }

    private k() {
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    @TargetApi(19)
    public final void a(@k.e.a.d Application application) {
        InputMethodManager inputMethodManager;
        if (Build.VERSION.SDK_INT > 23) {
            return;
        }
        h.p2.d d2 = n0.d(InputMethodManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = application.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = application.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = application.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = application.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = application.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = application.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = application.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = application.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = application.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = application.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService10;
        }
        try {
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField2.setAccessible(true);
            Method declaredMethod = InputMethodManager.class.getDeclaredMethod("finishInputLocked", new Class[0]);
            declaredMethod.setAccessible(true);
            InputMethodManager.class.getDeclaredMethod("focusIn", View.class).setAccessible(true);
            application.registerActivityLifecycleCallbacks(new b(inputMethodManager, declaredField2, declaredField, declaredMethod));
        } catch (NoSuchFieldException e2) {
            Log.e("IMMLeaks", "Unexpected reflection exception", e2);
        } catch (NoSuchMethodException e3) {
            Log.e("IMMLeaks", "Unexpected reflection exception", e3);
        }
    }
}
