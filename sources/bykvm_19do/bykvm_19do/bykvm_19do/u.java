package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class u implements Cloneable {

    /* renamed from: h  reason: collision with root package name */
    private static final SimpleDateFormat f165h = new SimpleDateFormat(b0.a.f14658i, Locale.US);
    public long a = System.currentTimeMillis();
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f166c;

    /* renamed from: d  reason: collision with root package name */
    public String f167d;

    /* renamed from: e  reason: collision with root package name */
    public String f168e;

    /* renamed from: f  reason: collision with root package name */
    public String f169f;

    /* renamed from: g  reason: collision with root package name */
    public String f170g;

    public static u a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return v.f173e.get(jSONObject.optString("k_cls", "")).clone().b(jSONObject);
        } catch (Throwable th) {
            l0.a(th);
            return null;
        }
    }

    public static String a(long j2) {
        return f165h.format(new Date(j2));
    }

    public abstract u a(Cursor cursor);

    public abstract void a(ContentValues contentValues);

    public abstract void a(JSONObject jSONObject);

    public abstract String[] a();

    public final ContentValues b(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        a(contentValues);
        return contentValues;
    }

    public abstract u b(JSONObject jSONObject);

    public abstract JSONObject b();

    public final String c() {
        String[] a = a();
        if (a != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("create table if not exists ");
            sb.append(d());
            sb.append("(");
            for (int i2 = 0; i2 < a.length; i2 += 2) {
                sb.append(a[i2]);
                sb.append(ExpandableTextView.N);
                sb.append(a[i2 + 1]);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            return sb.toString();
        }
        return null;
    }

    public abstract String d();

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", d());
            a(jSONObject);
        } catch (JSONException e2) {
            l0.a(e2);
        }
        return jSONObject;
    }

    public final JSONObject f() {
        try {
            this.f170g = a(this.a);
            return b();
        } catch (JSONException e2) {
            l0.a(e2);
            return null;
        }
    }

    /* renamed from: g */
    public u clone() {
        try {
            return (u) super.clone();
        } catch (CloneNotSupportedException e2) {
            l0.a(e2);
            return null;
        }
    }

    public String h() {
        return "sid:" + this.f166c;
    }

    public String toString() {
        if (l0.a) {
            String d2 = d();
            if (!getClass().getSimpleName().equalsIgnoreCase(d2)) {
                d2 = d2 + ", " + getClass().getSimpleName();
            }
            String str = this.f166c;
            if (str != null) {
                int indexOf = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (indexOf >= 0) {
                    str = str.substring(0, indexOf);
                }
            } else {
                str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return "{" + d2 + ", " + h() + ", " + str + ", " + this.a + "}";
        }
        return super.toString();
    }
}
