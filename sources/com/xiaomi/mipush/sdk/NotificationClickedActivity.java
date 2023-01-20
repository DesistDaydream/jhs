package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes3.dex */
public final class NotificationClickedActivity extends Activity {
    private BroadcastReceiver a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f14a;

    private void a(Intent intent) {
        if (intent != null) {
            try {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    com.xiaomi.a.a.a.c.b("clicked activity start service.");
                    startService(intent2);
                }
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = BadgeDrawable.r;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f14a = handler;
        handler.postDelayed(new ac(this), 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        ad adVar = new ad(this);
        this.a = adVar;
        try {
            registerReceiver(adVar, intentFilter, d.a(this), null);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f14a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a(getIntent());
    }
}
