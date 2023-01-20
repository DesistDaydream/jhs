package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.android.tpush.common.Constants;
import e.j.a.b.b.a.a.e;
import e.j.a.b.b.a.a.f;
import e.j.a.b.c.k;
import e.j.a.b.c.n.a;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.b;
import e.j.a.b.c.x.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.a(creator = "GoogleSignInOptionsCreator")
/* loaded from: classes2.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d.f, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    private static Comparator<Scope> zaaf;
    @d0
    public static final Scope zar = new Scope(k.a);
    @d0
    public static final Scope zas = new Scope("email");
    @d0
    public static final Scope zat = new Scope(k.f10146c);
    @d0
    public static final Scope zau;
    @d0
    public static final Scope zav;
    @SafeParcelable.g(id = 1)
    private final int versionCode;
    @SafeParcelable.c(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean zaaa;
    @SafeParcelable.c(getter = "getServerClientId", id = 7)
    private String zaab;
    @SafeParcelable.c(getter = "getHostedDomain", id = 8)
    private String zaac;
    @SafeParcelable.c(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zaad;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaae;
    @SafeParcelable.c(getter = "getScopes", id = 2)
    private final ArrayList<Scope> zaw;
    @SafeParcelable.c(getter = "getAccount", id = 3)
    private Account zax;
    @SafeParcelable.c(getter = "isIdTokenRequested", id = 4)
    private boolean zay;
    @SafeParcelable.c(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean zaz;

    static {
        Scope scope = new Scope(k.f10150g);
        zau = scope;
        zav = new Scope(k.f10149f);
        DEFAULT_SIGN_IN = new a().d().f().b();
        DEFAULT_GAMES_SIGN_IN = new a().g(scope, new Scope[0]).b();
        CREATOR = new f();
        zaaf = new e();
    }

    @SafeParcelable.b
    public GoogleSignInOptions(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.e(id = 3) Account account, @SafeParcelable.e(id = 4) boolean z, @SafeParcelable.e(id = 5) boolean z2, @SafeParcelable.e(id = 6) boolean z3, @SafeParcelable.e(id = 7) String str, @SafeParcelable.e(id = 8) String str2, @SafeParcelable.e(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i2, arrayList, account, z, z2, z3, str, str2, zaa(arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> zaa(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    @Nullable
    public static GoogleSignInOptions zab(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.optString(Constants.FLAG_ACCOUNT_NAME, null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, b.a) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private final JSONObject zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zaw, zaaf);
            ArrayList<Scope> arrayList = this.zaw;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Scope scope = arrayList.get(i2);
                i2++;
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.zax;
            if (account != null) {
                jSONObject.put(Constants.FLAG_ACCOUNT_NAME, account.name);
            }
            jSONObject.put("idTokenRequested", this.zay);
            jSONObject.put("forceCodeForRefreshToken", this.zaaa);
            jSONObject.put("serverAuthRequested", this.zaz);
            if (!TextUtils.isEmpty(this.zaab)) {
                jSONObject.put("serverClientId", this.zaab);
            }
            if (!TextUtils.isEmpty(this.zaac)) {
                jSONObject.put("hostedDomain", this.zaac);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r1.equals(r4.getAccount()) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r3.zaab.equals(r4.getServerClientId()) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L82
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.zaad     // Catch: java.lang.ClassCastException -> L82
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L82
            if (r1 > 0) goto L82
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.zaad     // Catch: java.lang.ClassCastException -> L82
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L82
            if (r1 <= 0) goto L17
            goto L82
        L17:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zaw     // Catch: java.lang.ClassCastException -> L82
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L82
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L82
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L82
            if (r1 != r2) goto L82
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zaw     // Catch: java.lang.ClassCastException -> L82
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L82
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L82
            if (r1 != 0) goto L34
            goto L82
        L34:
            android.accounts.Account r1 = r3.zax     // Catch: java.lang.ClassCastException -> L82
            if (r1 != 0) goto L3f
            android.accounts.Account r1 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L82
            if (r1 != 0) goto L82
            goto L49
        L3f:
            android.accounts.Account r2 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L82
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L82
            if (r1 == 0) goto L82
        L49:
            java.lang.String r1 = r3.zaab     // Catch: java.lang.ClassCastException -> L82
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L82
            if (r1 == 0) goto L5c
            java.lang.String r1 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L82
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L82
            if (r1 == 0) goto L82
            goto L68
        L5c:
            java.lang.String r1 = r3.zaab     // Catch: java.lang.ClassCastException -> L82
            java.lang.String r2 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L82
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L82
            if (r1 == 0) goto L82
        L68:
            boolean r1 = r3.zaaa     // Catch: java.lang.ClassCastException -> L82
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch: java.lang.ClassCastException -> L82
            if (r1 != r2) goto L82
            boolean r1 = r3.zay     // Catch: java.lang.ClassCastException -> L82
            boolean r2 = r4.isIdTokenRequested()     // Catch: java.lang.ClassCastException -> L82
            if (r1 != r2) goto L82
            boolean r1 = r3.zaz     // Catch: java.lang.ClassCastException -> L82
            boolean r4 = r4.isServerAuthCodeRequested()     // Catch: java.lang.ClassCastException -> L82
            if (r1 != r4) goto L82
            r4 = 1
            return r4
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @e.j.a.b.c.m.a
    public Account getAccount() {
        return this.zax;
    }

    @e.j.a.b.c.m.a
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zaad;
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zaw;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @e.j.a.b.c.m.a
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zaw);
    }

    @e.j.a.b.c.m.a
    public String getServerClientId() {
        return this.zaab;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zaw;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.getScopeUri());
        }
        Collections.sort(arrayList);
        return new e.j.a.b.b.a.a.b.a().a(arrayList).a(this.zax).a(this.zaab).c(this.zaaa).c(this.zay).c(this.zaz).b();
    }

    @e.j.a.b.c.m.a
    public boolean isForceCodeForRefreshToken() {
        return this.zaaa;
    }

    @e.j.a.b.c.m.a
    public boolean isIdTokenRequested() {
        return this.zay;
    }

    @e.j.a.b.c.m.a
    public boolean isServerAuthCodeRequested() {
        return this.zaz;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.versionCode);
        e.j.a.b.c.r.i0.a.c0(parcel, 2, getScopes(), false);
        e.j.a.b.c.r.i0.a.S(parcel, 3, getAccount(), i2, false);
        e.j.a.b.c.r.i0.a.g(parcel, 4, isIdTokenRequested());
        e.j.a.b.c.r.i0.a.g(parcel, 5, isServerAuthCodeRequested());
        e.j.a.b.c.r.i0.a.g(parcel, 6, isForceCodeForRefreshToken());
        e.j.a.b.c.r.i0.a.X(parcel, 7, getServerClientId(), false);
        e.j.a.b.c.r.i0.a.X(parcel, 8, this.zaac, false);
        e.j.a.b.c.r.i0.a.c0(parcel, 9, getExtensions(), false);
        e.j.a.b.c.r.i0.a.b(parcel, a2);
    }

    public final String zae() {
        return zad().toString();
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private Set<Scope> a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2612c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2613d;

        /* renamed from: e  reason: collision with root package name */
        private String f2614e;

        /* renamed from: f  reason: collision with root package name */
        private Account f2615f;

        /* renamed from: g  reason: collision with root package name */
        private String f2616g;

        /* renamed from: h  reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f2617h;

        public a() {
            this.a = new HashSet();
            this.f2617h = new HashMap();
        }

        private final String l(String str) {
            a0.g(str);
            String str2 = this.f2614e;
            a0.b(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        public final a a(e.j.a.b.b.a.a.a aVar) {
            if (!this.f2617h.containsKey(Integer.valueOf(aVar.a()))) {
                if (aVar.b() != null) {
                    this.a.addAll(aVar.b());
                }
                this.f2617h.put(Integer.valueOf(aVar.a()), new GoogleSignInOptionsExtensionParcelable(aVar));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        public final GoogleSignInOptions b() {
            if (this.a.contains(GoogleSignInOptions.zav)) {
                Set<Scope> set = this.a;
                Scope scope = GoogleSignInOptions.zau;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.f2613d && (this.f2615f == null || !this.a.isEmpty())) {
                d();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f2615f, this.f2613d, this.b, this.f2612c, this.f2614e, this.f2616g, this.f2617h, null);
        }

        public final a c() {
            this.a.add(GoogleSignInOptions.zas);
            return this;
        }

        public final a d() {
            this.a.add(GoogleSignInOptions.zat);
            return this;
        }

        public final a e(String str) {
            this.f2613d = true;
            this.f2614e = l(str);
            return this;
        }

        public final a f() {
            this.a.add(GoogleSignInOptions.zar);
            return this;
        }

        public final a g(Scope scope, Scope... scopeArr) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final a h(String str) {
            return i(str, false);
        }

        public final a i(String str, boolean z) {
            this.b = true;
            this.f2614e = l(str);
            this.f2612c = z;
            return this;
        }

        public final a j(String str) {
            this.f2615f = new Account(a0.g(str), b.a);
            return this;
        }

        public final a k(String str) {
            this.f2616g = a0.g(str);
            return this;
        }

        public a(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.f2617h = new HashMap();
            a0.k(googleSignInOptions);
            this.a = new HashSet(googleSignInOptions.zaw);
            this.b = googleSignInOptions.zaz;
            this.f2612c = googleSignInOptions.zaaa;
            this.f2613d = googleSignInOptions.zay;
            this.f2614e = googleSignInOptions.zaab;
            this.f2615f = googleSignInOptions.zax;
            this.f2616g = googleSignInOptions.zaac;
            this.f2617h = GoogleSignInOptions.zaa(googleSignInOptions.zaad);
        }
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.versionCode = i2;
        this.zaw = arrayList;
        this.zax = account;
        this.zay = z;
        this.zaz = z2;
        this.zaaa = z3;
        this.zaab = str;
        this.zaac = str2;
        this.zaad = new ArrayList<>(map.values());
        this.zaae = map;
    }

    public /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, e eVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }
}
