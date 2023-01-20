package com.tencent.android.tpush.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h extends com.tencent.android.tpush.c.c {
    private String a = null;
    private String b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f6075c;

    public h(Context context) {
        this.f6075c = context;
        TLogger.dd("OtherPushXgSysImpl", "OtherPushXgSysImpl");
    }

    private void f(Context context) {
        if (this.b == null) {
            this.b = "";
            JSONObject g2 = g(context);
            if (g2 != null) {
                if (g2.optString(Constants.XG_SYS_KEY_SYS_PKG, "").equals(context.getPackageName())) {
                    TLogger.ii("OtherPushXgSysImpl", "Run in sys app, set pushinfo empty");
                } else {
                    this.b = g2.optString(Constants.XG_SYS_KEY_PUSHINFO, "");
                }
            }
        }
    }

    private JSONObject g(Context context) {
        try {
            String type = context.getContentResolver().getType(Uri.parse("content://com.tencent.tpns.syspush.auth"));
            TLogger.ii("OtherPushXgSysImpl", "sysPushInfo:" + type);
            if (type != null) {
                return new JSONObject(type);
            }
            return null;
        } catch (Throwable unused) {
            TLogger.ii("OtherPushXgSysImpl", "get sysPushInfo get throwable");
            return null;
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public void a(Context context) {
        this.a = null;
        PushPreferences.putString(context, Constants.XG_SYS_TOKEN_COL_NAME, "");
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.tpns.syspush.auth/register"), null, Long.toString(XGApiConfig.getAccessId(context)), null, null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(Constants.XG_SYS_TOKEN_COL_NAME));
                this.a = string;
                PushPreferences.putString(context, Constants.XG_SYS_TOKEN_COL_NAME, string);
                query.close();
            }
            TLogger.ii("OtherPushXgSysImpl", "registerPush ret otherToken:" + this.a);
        } catch (Throwable th) {
            TLogger.ee("OtherPushXgSysImpl", "registerPush throwable:", th);
        }
    }

    @Override // com.tencent.android.tpush.c.c
    public void b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.tpns.syspush.auth/unregister"), null, Long.toString(XGApiConfig.getAccessId(context)), null, null);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            TLogger.ee("OtherPushXgSysImpl", "unregisterPush throwable:", th);
        }
        this.a = null;
        PushPreferences.putString(context, Constants.XG_SYS_TOKEN_COL_NAME, "");
    }

    @Override // com.tencent.android.tpush.c.c
    public String c(Context context) {
        if (i.b(this.a)) {
            this.a = PushPreferences.getString(context, Constants.XG_SYS_TOKEN_COL_NAME, "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.c.c
    public boolean d(Context context) {
        f(context);
        boolean z = !i.b(this.b);
        TLogger.dd("OtherPushXgSysImpl", "isConfig: " + z);
        return z;
    }

    @Override // com.tencent.android.tpush.c.c
    public int e(Context context) {
        return 8;
    }

    @Override // com.tencent.android.tpush.c.c
    public String a() {
        f(this.f6075c);
        return this.b;
    }
}
