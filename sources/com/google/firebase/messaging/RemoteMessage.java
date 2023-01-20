package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.d.i.m;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@SafeParcelable.a(creator = "RemoteMessageCreator")
@SafeParcelable.f({1})
/* loaded from: classes2.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new m();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.c(id = 2)
    public Bundle zza;
    private Map<String, String> zzb;
    private c zzc;

    /* loaded from: classes2.dex */
    public static class a {
        private final Bundle a;
        private final Map<String, String> b;

        public a(String str) {
            Bundle bundle = new Bundle();
            this.a = bundle;
            this.b = new ArrayMap();
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid to: ".concat(valueOf) : new String("Invalid to: "));
            } else {
                bundle.putString("google.to", str);
            }
        }

        public a a(String str, String str2) {
            this.b.put(str, str2);
            return this;
        }

        public RemoteMessage b() {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            bundle.putAll(this.a);
            this.a.remove("from");
            return new RemoteMessage(bundle);
        }

        public a c() {
            this.b.clear();
            return this;
        }

        public a d(String str) {
            this.a.putString("collapse_key", str);
            return this;
        }

        public a e(Map<String, String> map) {
            this.b.clear();
            this.b.putAll(map);
            return this;
        }

        public a f(String str) {
            this.a.putString("google.message_id", str);
            return this;
        }

        public a g(String str) {
            this.a.putString("message_type", str);
            return this;
        }

        public a h(@IntRange(from = 0, to = 86400) int i2) {
            this.a.putString("google.ttl", String.valueOf(i2));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface b {
    }

    /* loaded from: classes2.dex */
    public static class c {
        private final String a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f3166c;

        /* renamed from: d  reason: collision with root package name */
        private final String f3167d;

        /* renamed from: e  reason: collision with root package name */
        private final String f3168e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f3169f;

        /* renamed from: g  reason: collision with root package name */
        private final String f3170g;

        /* renamed from: h  reason: collision with root package name */
        private final String f3171h;

        /* renamed from: i  reason: collision with root package name */
        private final String f3172i;

        /* renamed from: j  reason: collision with root package name */
        private final String f3173j;

        /* renamed from: k  reason: collision with root package name */
        private final String f3174k;

        /* renamed from: l  reason: collision with root package name */
        private final String f3175l;

        /* renamed from: m  reason: collision with root package name */
        private final String f3176m;
        private final Uri n;

        private c(Bundle bundle) {
            this.a = e.j.d.i.c.e(bundle, "gcm.n.title");
            this.b = e.j.d.i.c.m(bundle, "gcm.n.title");
            this.f3166c = o(bundle, "gcm.n.title");
            this.f3167d = e.j.d.i.c.e(bundle, "gcm.n.body");
            this.f3168e = e.j.d.i.c.m(bundle, "gcm.n.body");
            this.f3169f = o(bundle, "gcm.n.body");
            this.f3170g = e.j.d.i.c.e(bundle, "gcm.n.icon");
            this.f3172i = e.j.d.i.c.l(bundle);
            this.f3173j = e.j.d.i.c.e(bundle, "gcm.n.tag");
            this.f3174k = e.j.d.i.c.e(bundle, "gcm.n.color");
            this.f3175l = e.j.d.i.c.e(bundle, "gcm.n.click_action");
            this.f3176m = e.j.d.i.c.e(bundle, "gcm.n.android_channel_id");
            this.n = e.j.d.i.c.o(bundle);
            this.f3171h = e.j.d.i.c.e(bundle, "gcm.n.image");
        }

        private static String[] o(Bundle bundle, String str) {
            Object[] k2 = e.j.d.i.c.k(bundle, str);
            if (k2 == null) {
                return null;
            }
            String[] strArr = new String[k2.length];
            for (int i2 = 0; i2 < k2.length; i2++) {
                strArr[i2] = String.valueOf(k2[i2]);
            }
            return strArr;
        }

        @Nullable
        public String a() {
            return this.f3167d;
        }

        @Nullable
        public String[] b() {
            return this.f3169f;
        }

        @Nullable
        public String c() {
            return this.f3168e;
        }

        @Nullable
        public String d() {
            return this.f3176m;
        }

        @Nullable
        public String e() {
            return this.f3175l;
        }

        @Nullable
        public String f() {
            return this.f3174k;
        }

        @Nullable
        public String g() {
            return this.f3170g;
        }

        @Nullable
        public Uri h() {
            String str = this.f3171h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        @Nullable
        public Uri i() {
            return this.n;
        }

        @Nullable
        public String j() {
            return this.f3172i;
        }

        @Nullable
        public String k() {
            return this.f3173j;
        }

        @Nullable
        public String l() {
            return this.a;
        }

        @Nullable
        public String[] m() {
            return this.f3166c;
        }

        @Nullable
        public String n() {
            return this.b;
        }
    }

    @SafeParcelable.b
    public RemoteMessage(@SafeParcelable.e(id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    private static int zza(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return PrerollVideoResponse.NORMAL.equals(str) ? 2 : 0;
    }

    @Nullable
    public final String getCollapseKey() {
        return this.zza.getString("collapse_key");
    }

    public final Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle bundle = this.zza;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    @Nullable
    public final String getFrom() {
        return this.zza.getString("from");
    }

    @Nullable
    public final String getMessageId() {
        String string = this.zza.getString("google.message_id");
        return string == null ? this.zza.getString("message_id") : string;
    }

    @Nullable
    public final String getMessageType() {
        return this.zza.getString("message_type");
    }

    @Nullable
    public final c getNotification() {
        if (this.zzc == null && e.j.d.i.c.j(this.zza)) {
            this.zzc = new c(this.zza);
        }
        return this.zzc;
    }

    public final int getOriginalPriority() {
        String string = this.zza.getString("google.original_priority");
        if (string == null) {
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final int getPriority() {
        String string = this.zza.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.zza.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final long getSentTime() {
        Object obj = this.zza.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid sent time: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
                return 0L;
            }
        }
        return 0L;
    }

    @Nullable
    public final String getTo() {
        return this.zza.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.zza.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
                sb.append("Invalid TTL: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
                return 0;
            }
        }
        return 0;
    }

    @e.j.a.b.c.m.a
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.zza);
        return intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.k(parcel, 2, this.zza, false);
        e.j.a.b.c.r.i0.a.b(parcel, a2);
    }
}
