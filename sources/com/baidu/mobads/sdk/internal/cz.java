package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;

/* loaded from: classes.dex */
public class cz {

    /* renamed from: f  reason: collision with root package name */
    private static final int f1582f = 5;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f1583c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f1584d;

    /* renamed from: e  reason: collision with root package name */
    private CountDownTimer f1585e;

    /* renamed from: g  reason: collision with root package name */
    private dc f1586g;

    /* renamed from: j  reason: collision with root package name */
    private Activity f1589j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f1590k;
    public final String a = "html5_intersitial";

    /* renamed from: h  reason: collision with root package name */
    private boolean f1587h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1588i = false;
    public final bj b = bj.a();

    public cz(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.f1585e = new db(this, 6000L, 1000L).start();
        return this.f1583c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.f1583c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f1583c.getParent()).removeView(this.f1583c);
        }
        if (this.f1585e != null) {
            this.b.a("cancel countDownTimer before it finished");
            try {
                this.f1585e.cancel();
            } catch (Exception e2) {
                this.b.a(e2);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public void a(int i2, int i3) {
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        return true;
    }

    public boolean b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    public void c() {
        Activity activity = this.f1589j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new da(this));
    }

    public boolean d() {
        return this.f1587h;
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.b.a("showInterstitialAdInit");
            boolean z = this.f1587h;
            if (z && !this.f1588i) {
                this.f1588i = true;
                this.f1587h = false;
                this.f1589j = activity;
                a();
                c();
            } else if (this.f1588i) {
                this.b.b("interstitial ad is showing now");
            } else if (z) {
            } else {
                this.b.b("interstitial ad is not ready");
            }
        } catch (Exception e2) {
            this.b.a(e2);
        }
    }
}
