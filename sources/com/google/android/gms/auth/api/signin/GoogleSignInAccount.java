package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.b.a.a.c;
import e.j.a.b.b.a.a.d;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.b;
import e.j.a.b.c.x.d0;
import e.j.a.b.c.x.g;
import e.j.a.b.c.x.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.a(creator = "GoogleSignInAccountCreator")
/* loaded from: classes2.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new d();
    @d0
    private static g zae = k.d();
    @SafeParcelable.c(getter = "getId", id = 2)
    private String mId;
    @SafeParcelable.g(id = 1)
    private final int versionCode;
    @SafeParcelable.c(getter = "getIdToken", id = 3)
    private String zaf;
    @SafeParcelable.c(getter = "getEmail", id = 4)
    private String zag;
    @SafeParcelable.c(getter = "getDisplayName", id = 5)
    private String zah;
    @SafeParcelable.c(getter = "getPhotoUrl", id = 6)
    private Uri zai;
    @SafeParcelable.c(getter = "getServerAuthCode", id = 7)
    private String zaj;
    @SafeParcelable.c(getter = "getExpirationTimeSecs", id = 8)
    private long zak;
    @SafeParcelable.c(getter = "getObfuscatedIdentifier", id = 9)
    private String zal;
    @SafeParcelable.c(id = 10)
    private List<Scope> zam;
    @SafeParcelable.c(getter = "getGivenName", id = 11)
    private String zan;
    @SafeParcelable.c(getter = "getFamilyName", id = 12)
    private String zao;
    private Set<Scope> zap = new HashSet();

    @SafeParcelable.b
    public GoogleSignInAccount(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) String str2, @SafeParcelable.e(id = 4) String str3, @SafeParcelable.e(id = 5) String str4, @SafeParcelable.e(id = 6) Uri uri, @SafeParcelable.e(id = 7) String str5, @SafeParcelable.e(id = 8) long j2, @SafeParcelable.e(id = 9) String str6, @SafeParcelable.e(id = 10) List<Scope> list, @SafeParcelable.e(id = 11) String str7, @SafeParcelable.e(id = 12) String str8) {
        this.versionCode = i2;
        this.mId = str;
        this.zaf = str2;
        this.zag = str3;
        this.zah = str4;
        this.zai = uri;
        this.zaj = str5;
        this.zak = j2;
        this.zal = str6;
        this.zam = list;
        this.zan = str7;
        this.zao = str8;
    }

    @a
    public static GoogleSignInAccount createDefault() {
        Account account = new Account("<<default account>>", b.a);
        return zaa(null, null, account.name, null, null, null, null, 0L, account.name, new HashSet());
    }

    @Nullable
    public static GoogleSignInAccount zaa(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount zaa = zaa(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        zaa.zaj = jSONObject.optString("serverAuthCode", null);
        return zaa;
    }

    private final JSONObject zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zak);
            jSONObject.put("obfuscatedIdentifier", this.zal);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.zam;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, c.a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.zal.equals(this.zal) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
        }
        return false;
    }

    @Nullable
    public Account getAccount() {
        if (this.zag == null) {
            return null;
        }
        return new Account(this.zag, b.a);
    }

    @Nullable
    public String getDisplayName() {
        return this.zah;
    }

    @Nullable
    public String getEmail() {
        return this.zag;
    }

    @Nullable
    public String getFamilyName() {
        return this.zao;
    }

    @Nullable
    public String getGivenName() {
        return this.zan;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zam);
    }

    @Nullable
    public String getId() {
        return this.mId;
    }

    @Nullable
    public String getIdToken() {
        return this.zaf;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zai;
    }

    @NonNull
    @a
    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zam);
        hashSet.addAll(this.zap);
        return hashSet;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.zaj;
    }

    public int hashCode() {
        return ((this.zal.hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    @a
    public boolean isExpired() {
        return zae.a() / 1000 >= this.zak - 300;
    }

    @a
    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.zap, scopeArr);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.versionCode);
        e.j.a.b.c.r.i0.a.X(parcel, 2, getId(), false);
        e.j.a.b.c.r.i0.a.X(parcel, 3, getIdToken(), false);
        e.j.a.b.c.r.i0.a.X(parcel, 4, getEmail(), false);
        e.j.a.b.c.r.i0.a.X(parcel, 5, getDisplayName(), false);
        e.j.a.b.c.r.i0.a.S(parcel, 6, getPhotoUrl(), i2, false);
        e.j.a.b.c.r.i0.a.X(parcel, 7, getServerAuthCode(), false);
        e.j.a.b.c.r.i0.a.K(parcel, 8, this.zak);
        e.j.a.b.c.r.i0.a.X(parcel, 9, this.zal, false);
        e.j.a.b.c.r.i0.a.c0(parcel, 10, this.zam, false);
        e.j.a.b.c.r.i0.a.X(parcel, 11, getGivenName(), false);
        e.j.a.b.c.r.i0.a.X(parcel, 12, getFamilyName(), false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @NonNull
    public final String zab() {
        return this.zal;
    }

    public final String zac() {
        JSONObject zad = zad();
        zad.remove("serverAuthCode");
        return zad.toString();
    }

    private static GoogleSignInAccount zaa(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l2, @NonNull String str7, @NonNull Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l2 == null ? Long.valueOf(zae.a() / 1000) : l2).longValue(), a0.g(str7), new ArrayList((Collection) a0.k(set)), str5, str6);
    }
}
