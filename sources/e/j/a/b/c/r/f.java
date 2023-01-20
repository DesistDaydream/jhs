package e.j.a.b.c.r;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import e.j.a.b.c.n.i;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@e.j.a.b.c.m.a
@e.j.a.b.c.x.d0
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: l */
    public static final String f10398l = "com.google.android.gms.common.internal.ClientSettings.sessionId";
    private final Account a;
    private final Set<Scope> b;

    /* renamed from: c */
    private final Set<Scope> f10399c;

    /* renamed from: d */
    private final Map<e.j.a.b.c.n.a<?>, b> f10400d;

    /* renamed from: e */
    private final int f10401e;

    /* renamed from: f */
    private final View f10402f;

    /* renamed from: g */
    private final String f10403g;

    /* renamed from: h */
    private final String f10404h;

    /* renamed from: i */
    private final e.j.a.b.h.a f10405i;

    /* renamed from: j */
    private final boolean f10406j;

    /* renamed from: k */
    private Integer f10407k;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static final class a {
        private Account a;
        private ArraySet<Scope> b;

        /* renamed from: c */
        private Map<e.j.a.b.c.n.a<?>, b> f10408c;

        /* renamed from: e */
        private View f10410e;

        /* renamed from: f */
        private String f10411f;

        /* renamed from: g */
        private String f10412g;

        /* renamed from: i */
        private boolean f10414i;

        /* renamed from: d */
        private int f10409d = 0;

        /* renamed from: h */
        private e.j.a.b.h.a f10413h = e.j.a.b.h.a.f10509i;

        public final a a(Collection<Scope> collection) {
            if (this.b == null) {
                this.b = new ArraySet<>();
            }
            this.b.addAll(collection);
            return this;
        }

        public final a b(Scope scope) {
            if (this.b == null) {
                this.b = new ArraySet<>();
            }
            this.b.add(scope);
            return this;
        }

        @e.j.a.b.c.m.a
        public final f c() {
            return new f(this.a, this.b, this.f10408c, this.f10409d, this.f10410e, this.f10411f, this.f10412g, this.f10413h, this.f10414i);
        }

        public final a d() {
            this.f10414i = true;
            return this;
        }

        public final a e(Account account) {
            this.a = account;
            return this;
        }

        public final a f(int i2) {
            this.f10409d = i2;
            return this;
        }

        public final a g(Map<e.j.a.b.c.n.a<?>, b> map) {
            this.f10408c = map;
            return this;
        }

        public final a h(String str) {
            this.f10412g = str;
            return this;
        }

        @e.j.a.b.c.m.a
        public final a i(String str) {
            this.f10411f = str;
            return this;
        }

        public final a j(e.j.a.b.h.a aVar) {
            this.f10413h = aVar;
            return this;
        }

        public final a k(View view) {
            this.f10410e = view;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final Set<Scope> a;

        public b(Set<Scope> set) {
            a0.k(set);
            this.a = Collections.unmodifiableSet(set);
        }
    }

    @e.j.a.b.c.m.a
    public f(Account account, Set<Scope> set, Map<e.j.a.b.c.n.a<?>, b> map, int i2, View view, String str, String str2, e.j.a.b.h.a aVar) {
        this(account, set, map, i2, view, str, str2, aVar, false);
    }

    @e.j.a.b.c.m.a
    public static f a(Context context) {
        return new i.a(context).j();
    }

    @e.j.a.b.c.m.a
    @Nullable
    public final Account b() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    @Nullable
    @Deprecated
    public final String c() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @e.j.a.b.c.m.a
    public final Account d() {
        Account account = this.a;
        return account != null ? account : new Account("<<default account>>", e.j.a.b.c.r.b.a);
    }

    @e.j.a.b.c.m.a
    public final Set<Scope> e() {
        return this.f10399c;
    }

    @e.j.a.b.c.m.a
    public final Set<Scope> f(e.j.a.b.c.n.a<?> aVar) {
        b bVar = this.f10400d.get(aVar);
        if (bVar != null && !bVar.a.isEmpty()) {
            HashSet hashSet = new HashSet(this.b);
            hashSet.addAll(bVar.a);
            return hashSet;
        }
        return this.b;
    }

    @Nullable
    public final Integer g() {
        return this.f10407k;
    }

    @e.j.a.b.c.m.a
    public final int h() {
        return this.f10401e;
    }

    public final Map<e.j.a.b.c.n.a<?>, b> i() {
        return this.f10400d;
    }

    @Nullable
    public final String j() {
        return this.f10404h;
    }

    @e.j.a.b.c.m.a
    @Nullable
    public final String k() {
        return this.f10403g;
    }

    @e.j.a.b.c.m.a
    public final Set<Scope> l() {
        return this.b;
    }

    @Nullable
    public final e.j.a.b.h.a m() {
        return this.f10405i;
    }

    @e.j.a.b.c.m.a
    @Nullable
    public final View n() {
        return this.f10402f;
    }

    public final boolean o() {
        return this.f10406j;
    }

    public final void p(Integer num) {
        this.f10407k = num;
    }

    public f(Account account, Set<Scope> set, Map<e.j.a.b.c.n.a<?>, b> map, int i2, View view, String str, String str2, e.j.a.b.h.a aVar, boolean z) {
        this.a = account;
        Set<Scope> unmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.b = unmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f10400d = map;
        this.f10402f = view;
        this.f10401e = i2;
        this.f10403g = str;
        this.f10404h = str2;
        this.f10405i = aVar;
        this.f10406j = z;
        HashSet hashSet = new HashSet(unmodifiableSet);
        for (b bVar : map.values()) {
            hashSet.addAll(bVar.a);
        }
        this.f10399c = Collections.unmodifiableSet(hashSet);
    }
}
