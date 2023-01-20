package e.b.a.q;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import e.b.a.d;
import e.b.a.p.m.d.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class p implements Handler.Callback {
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    public static final String f9848j = "com.bumptech.glide.manager";

    /* renamed from: k  reason: collision with root package name */
    private static final String f9849k = "RMRetriever";

    /* renamed from: l  reason: collision with root package name */
    private static final int f9850l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f9851m = 2;
    private static final String n = "key";
    private static final b o = new a();
    private volatile e.b.a.j a;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f9853d;

    /* renamed from: e  reason: collision with root package name */
    private final b f9854e;

    /* renamed from: i  reason: collision with root package name */
    private final k f9858i;
    @VisibleForTesting
    public final Map<FragmentManager, o> b = new HashMap();
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, s> f9852c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayMap<View, Fragment> f9855f = new ArrayMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f9856g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f9857h = new Bundle();

    /* loaded from: classes.dex */
    public class a implements b {
        @Override // e.b.a.q.p.b
        @NonNull
        public e.b.a.j a(@NonNull e.b.a.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
            return new e.b.a.j(cVar, lVar, qVar, context);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        @NonNull
        e.b.a.j a(@NonNull e.b.a.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context);
    }

    public p(@Nullable b bVar, e.b.a.f fVar) {
        this.f9854e = bVar == null ? o : bVar;
        this.f9853d = new Handler(Looper.getMainLooper(), this);
        this.f9858i = b(fVar);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static k b(e.b.a.f fVar) {
        if (u.f9785i && u.f9784h) {
            if (fVar.b(d.f.class)) {
                return new i();
            }
            return new j();
        }
        return new g();
    }

    @Nullable
    private static Activity c(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    d(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        e(fragmentManager, arrayMap);
    }

    @Deprecated
    private void e(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f9857h.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f9857h, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    d(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i2 = i3;
        }
    }

    private static void f(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                f(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private android.app.Fragment g(@NonNull View view, @NonNull Activity activity) {
        this.f9856g.clear();
        d(activity.getFragmentManager(), this.f9856g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f9856g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f9856g.clear();
        return fragment;
    }

    @Nullable
    private Fragment h(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f9855f.clear();
        f(fragmentActivity.getSupportFragmentManager().getFragments(), this.f9855f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f9855f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f9855f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private e.b.a.j i(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        o r = r(fragmentManager, fragment);
        e.b.a.j e2 = r.e();
        if (e2 == null) {
            e2 = this.f9854e.a(e.b.a.c.e(context), r.c(), r.f(), context);
            if (z) {
                e2.onStart();
            }
            r.k(e2);
        }
        return e2;
    }

    @NonNull
    private e.b.a.j p(@NonNull Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = this.f9854e.a(e.b.a.c.e(context.getApplicationContext()), new e.b.a.q.b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.a;
    }

    @NonNull
    private o r(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment) {
        o oVar = (o) fragmentManager.findFragmentByTag(f9848j);
        if (oVar == null) {
            o oVar2 = this.b.get(fragmentManager);
            if (oVar2 == null) {
                o oVar3 = new o();
                oVar3.j(fragment);
                this.b.put(fragmentManager, oVar3);
                fragmentManager.beginTransaction().add(oVar3, f9848j).commitAllowingStateLoss();
                this.f9853d.obtainMessage(1, fragmentManager).sendToTarget();
                return oVar3;
            }
            return oVar2;
        }
        return oVar;
    }

    @NonNull
    private s t(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment) {
        s sVar = (s) fragmentManager.findFragmentByTag(f9848j);
        if (sVar == null) {
            s sVar2 = this.f9852c.get(fragmentManager);
            if (sVar2 == null) {
                s sVar3 = new s();
                sVar3.z(fragment);
                this.f9852c.put(fragmentManager, sVar3);
                fragmentManager.beginTransaction().add(sVar3, f9848j).commitAllowingStateLoss();
                this.f9853d.obtainMessage(2, fragmentManager).sendToTarget();
                return sVar3;
            }
            return sVar2;
        }
        return sVar;
    }

    private static boolean u(Context context) {
        Activity c2 = c(context);
        return c2 == null || !c2.isFinishing();
    }

    @NonNull
    private e.b.a.j v(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        s t = t(fragmentManager, fragment);
        e.b.a.j t2 = t.t();
        if (t2 == null) {
            t2 = this.f9854e.a(e.b.a.c.e(context), t.r(), t.u(), context);
            if (z) {
                t2.onStart();
            }
            t.A(t2);
        }
        return t2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.b.remove(obj);
        } else if (i2 == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f9852c.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable(f9849k, 5)) {
                Log.w(f9849k, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w(f9849k, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    @NonNull
    public e.b.a.j j(@NonNull Activity activity) {
        if (e.b.a.v.n.t()) {
            return l(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return o((FragmentActivity) activity);
        }
        a(activity);
        this.f9858i.a(activity);
        return i(activity, activity.getFragmentManager(), null, u(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public e.b.a.j k(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!e.b.a.v.n.t() && Build.VERSION.SDK_INT >= 17) {
                if (fragment.getActivity() != null) {
                    this.f9858i.a(fragment.getActivity());
                }
                return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return l(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    public e.b.a.j l(@NonNull Context context) {
        if (context != null) {
            if (e.b.a.v.n.u() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return o((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return j((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return l(contextWrapper.getBaseContext());
                    }
                }
            }
            return p(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public e.b.a.j m(@NonNull View view) {
        if (e.b.a.v.n.t()) {
            return l(view.getContext().getApplicationContext());
        }
        e.b.a.v.l.d(view);
        e.b.a.v.l.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c2 = c(view.getContext());
        if (c2 == null) {
            return l(view.getContext().getApplicationContext());
        }
        if (c2 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) c2;
            Fragment h2 = h(view, fragmentActivity);
            return h2 != null ? n(h2) : o(fragmentActivity);
        }
        android.app.Fragment g2 = g(view, c2);
        if (g2 == null) {
            return j(c2);
        }
        return k(g2);
    }

    @NonNull
    public e.b.a.j n(@NonNull Fragment fragment) {
        e.b.a.v.l.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (e.b.a.v.n.t()) {
            return l(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.f9858i.a(fragment.getActivity());
        }
        return v(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public e.b.a.j o(@NonNull FragmentActivity fragmentActivity) {
        if (e.b.a.v.n.t()) {
            return l(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.f9858i.a(fragmentActivity);
        return v(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, u(fragmentActivity));
    }

    @NonNull
    @Deprecated
    public o q(Activity activity) {
        return r(activity.getFragmentManager(), null);
    }

    @NonNull
    public s s(androidx.fragment.app.FragmentManager fragmentManager) {
        return t(fragmentManager, null);
    }
}
