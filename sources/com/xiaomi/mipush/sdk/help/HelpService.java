package com.xiaomi.mipush.sdk.help;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.o;

/* loaded from: classes3.dex */
public class HelpService extends IntentService {
    public HelpService() {
        super("intentService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (TextUtils.isEmpty(intent.getStringExtra("awake_info"))) {
            return;
        }
        o.a(this, intent, null);
    }
}
