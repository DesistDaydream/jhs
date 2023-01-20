package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: d  reason: collision with root package name */
    private String f5423d;

    /* renamed from: e  reason: collision with root package name */
    private String f5424e;

    public i(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, String str2, String str3) {
        super(context, aVar, str);
        this.f5423d = str2;
        this.f5424e = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String str;
        String c2 = this.b.c("s");
        String a = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ak"), c2);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("am"), c2);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("an"), c2);
        String str2 = null;
        if (!TextUtils.isEmpty(a3) && a3.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
            String[] split = a3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("al"), c2);
            String a5 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ao"), c2);
            if (!TextUtils.isEmpty(a5) && a5.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
                String[] split2 = a5.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                JSONObject d2 = this.b.d("download_dir");
                if (d2 != null) {
                    String optString = d2.optString("dir_name");
                    if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                        try {
                            str = String.format(optString, this.f5424e);
                        } catch (Throwable unused) {
                            str = this.f5424e;
                        }
                    } else {
                        str = this.f5424e;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = a4.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(a);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(a2, this.f5423d);
                intent.putExtra(a4, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
