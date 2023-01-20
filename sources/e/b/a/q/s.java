package e.b.a.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class s extends Fragment {

    /* renamed from: g */
    private static final String f9861g = "SupportRMFragment";
    private final e.b.a.q.a a;
    private final q b;

    /* renamed from: c */
    private final Set<s> f9862c;
    @Nullable

    /* renamed from: d */
    private s f9863d;
    @Nullable

    /* renamed from: e */
    private e.b.a.j f9864e;
    @Nullable

    /* renamed from: f */
    private Fragment f9865f;

    /* loaded from: classes.dex */
    public class a implements q {
        public a() {
            s.this = r1;
        }

        @Override // e.b.a.q.q
        @NonNull
        public Set<e.b.a.j> a() {
            Set<s> q = s.this.q();
            HashSet hashSet = new HashSet(q.size());
            for (s sVar : q) {
                if (sVar.t() != null) {
                    hashSet.add(sVar.t());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + s.this + "}";
        }
    }

    public s() {
        this(new e.b.a.q.a());
    }

    private void B() {
        s sVar = this.f9863d;
        if (sVar != null) {
            sVar.y(this);
            this.f9863d = null;
        }
    }

    private void p(s sVar) {
        this.f9862c.add(sVar);
    }

    @Nullable
    private Fragment s() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f9865f;
    }

    @Nullable
    private static FragmentManager v(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean w(@NonNull Fragment fragment) {
        Fragment s = s();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(s)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void x(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        B();
        s s = e.b.a.c.e(context).n().s(fragmentManager);
        this.f9863d = s;
        if (equals(s)) {
            return;
        }
        this.f9863d.p(this);
    }

    private void y(s sVar) {
        this.f9862c.remove(sVar);
    }

    public void A(@Nullable e.b.a.j jVar) {
        this.f9864e = jVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager v = v(this);
        if (v == null) {
            if (Log.isLoggable(f9861g, 5)) {
                Log.w(f9861g, "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            x(getContext(), v);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(f9861g, 5)) {
                Log.w(f9861g, "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        B();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9865f = null;
        B();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @NonNull
    public Set<s> q() {
        s sVar = this.f9863d;
        if (sVar == null) {
            return Collections.emptySet();
        }
        if (equals(sVar)) {
            return Collections.unmodifiableSet(this.f9862c);
        }
        HashSet hashSet = new HashSet();
        for (s sVar2 : this.f9863d.q()) {
            if (w(sVar2.s())) {
                hashSet.add(sVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public e.b.a.q.a r() {
        return this.a;
    }

    @Nullable
    public e.b.a.j t() {
        return this.f9864e;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + s() + "}";
    }

    @NonNull
    public q u() {
        return this.b;
    }

    public void z(@Nullable Fragment fragment) {
        FragmentManager v;
        this.f9865f = fragment;
        if (fragment == null || fragment.getContext() == null || (v = v(fragment)) == null) {
            return;
        }
        x(fragment.getContext(), v);
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public s(@NonNull e.b.a.q.a aVar) {
        this.b = new a();
        this.f9862c = new HashSet();
        this.a = aVar;
    }
}
