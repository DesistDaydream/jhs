package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* loaded from: classes3.dex */
public class h extends a {
    public static final String a = "umeng_sp_oaid";
    public static final String b = "key_umeng_sp_oaid";

    /* renamed from: c  reason: collision with root package name */
    public static final String f7504c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d  reason: collision with root package name */
    private static final String f7505d = "oaid";

    /* renamed from: e  reason: collision with root package name */
    private Context f7506e;

    public h(Context context) {
        super(f7505d);
        this.f7506e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                SharedPreferences sharedPreferences = this.f7506e.getSharedPreferences(a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(b, "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
