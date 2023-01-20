package e.b.a.q;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class o extends Fragment {

    /* renamed from: g */
    private static final String f9843g = "RMFragment";
    private final e.b.a.q.a a;
    private final q b;

    /* renamed from: c */
    private final Set<o> f9844c;
    @Nullable

    /* renamed from: d */
    private e.b.a.j f9845d;
    @Nullable

    /* renamed from: e */
    private o f9846e;
    @Nullable

    /* renamed from: f */
    private Fragment f9847f;

    /* loaded from: classes.dex */
    public class a implements q {
        public a() {
            o.this = r1;
        }

        @Override // e.b.a.q.q
        @NonNull
        public Set<e.b.a.j> a() {
            Set<o> b = o.this.b();
            HashSet hashSet = new HashSet(b.size());
            for (o oVar : b) {
                if (oVar.e() != null) {
                    hashSet.add(oVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new e.b.a.q.a());
    }

    private void a(o oVar) {
        this.f9844c.add(oVar);
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f9847f;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        o q = e.b.a.c.e(activity).n().q(activity);
        this.f9846e = q;
        if (equals(q)) {
            return;
        }
        this.f9846e.a(this);
    }

    private void i(o oVar) {
        this.f9844c.remove(oVar);
    }

    private void l() {
        o oVar = this.f9846e;
        if (oVar != null) {
            oVar.i(this);
            this.f9846e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    public Set<o> b() {
        if (equals(this.f9846e)) {
            return Collections.unmodifiableSet(this.f9844c);
        }
        if (this.f9846e != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (o oVar : this.f9846e.b()) {
                if (g(oVar.getParentFragment())) {
                    hashSet.add(oVar);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    @NonNull
    public e.b.a.q.a c() {
        return this.a;
    }

    @Nullable
    public e.b.a.j e() {
        return this.f9845d;
    }

    @NonNull
    public q f() {
        return this.b;
    }

    public void j(@Nullable Fragment fragment) {
        this.f9847f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@Nullable e.b.a.j jVar) {
        this.f9845d = jVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(f9843g, 5)) {
                Log.w(f9843g, "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public o(@NonNull e.b.a.q.a aVar) {
        this.b = new a();
        this.f9844c = new HashSet();
        this.a = aVar;
    }
}
