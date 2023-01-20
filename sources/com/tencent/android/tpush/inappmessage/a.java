package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes3.dex */
public abstract class a extends Dialog {
    public RelativeLayout a;
    public Activity b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6108c;

    public a(Activity activity) {
        super(activity, i.a(activity));
        this.f6108c = false;
        this.b = activity;
        SizeUtil.init(activity);
    }

    private RelativeLayout g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private RelativeLayout h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setId(View.generateViewId());
        relativeLayout.setLayoutParams(b());
        i.a(relativeLayout, 0, !d());
        a(relativeLayout);
        return relativeLayout;
    }

    public void a() {
        this.a = g();
        RelativeLayout h2 = h();
        this.a.addView(h2);
        if (c()) {
            this.a.addView(a((View) h2));
        }
        RelativeLayout relativeLayout = this.a;
        setContentView(relativeLayout, relativeLayout.getLayoutParams());
        this.a.setAnimation(i.a(350L));
        e();
    }

    public abstract void a(RelativeLayout relativeLayout);

    public abstract RelativeLayout.LayoutParams b();

    public abstract boolean c();

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.f6108c) {
            return;
        }
        this.f6108c = true;
        f();
    }

    public abstract boolean d();

    public abstract void e();

    public void f() {
        super.cancel();
    }

    private e a(View view) {
        e eVar = new e(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (d()) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i2 = SizeUtil.dp5;
            layoutParams.setMargins(0, i2, i2, 0);
        } else {
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(7, view.getId());
            int i3 = SizeUtil.dp7;
            layoutParams.setMargins(0, -i3, -i3, 0);
        }
        eVar.setLayoutParams(layoutParams);
        eVar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.android.tpush.inappmessage.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.cancel();
                a.this.b.finish();
                a.this.b.overridePendingTransition(0, 0);
            }
        });
        return eVar;
    }
}
