package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* loaded from: classes3.dex */
public class a extends Dialog {
    private TextView a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f5276c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5277d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f5278e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f5279f;

    /* renamed from: g  reason: collision with root package name */
    private ClipImageView f5280g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f5281h;

    /* renamed from: i  reason: collision with root package name */
    private Activity f5282i;

    /* renamed from: j  reason: collision with root package name */
    private final long f5283j;

    /* renamed from: k  reason: collision with root package name */
    private long f5284k;

    /* renamed from: l  reason: collision with root package name */
    private final com.ss.android.downloadlib.addownload.b.b f5285l;

    public a(@NonNull Activity activity, long j2) {
        super(activity);
        this.f5282i = activity;
        this.f5283j = j2;
        this.f5285l = c.a().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.c.a(this.f5282i);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f5285l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f5284k = this.f5285l.b;
        a();
        e.b("lp_app_dialog_show", this.f5284k);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                e.a("lp_app_dialog_cancel", a.this.f5284k);
            }
        });
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.tv_app_name);
        this.b = (TextView) findViewById(R.id.tv_app_version);
        this.f5276c = (TextView) findViewById(R.id.tv_app_developer);
        this.f5277d = (TextView) findViewById(R.id.tv_app_detail);
        this.f5278e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f5279f = (TextView) findViewById(R.id.tv_give_up);
        this.f5280g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f5281h = (LinearLayout) findViewById(R.id.ll_download);
        this.a.setText(l.a(this.f5285l.f5239e, "--"));
        TextView textView = this.b;
        textView.setText("????????????" + l.a(this.f5285l.f5240f, "--"));
        TextView textView2 = this.f5276c;
        textView2.setText("????????????" + l.a(this.f5285l.f5241g, "???????????????????????????"));
        this.f5280g.setRoundRadius(l.a(j.getContext(), 8.0f));
        this.f5280g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.f5283j, new d.a() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.f5280g.setImageBitmap(bitmap);
                } else {
                    e.a(8, a.this.f5284k);
                }
            }
        });
        this.f5277d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f5282i);
                AppDetailInfoActivity.a(a.this.f5282i, a.this.f5283j);
                e.a("lp_app_dialog_click_detail", a.this.f5284k);
            }
        });
        this.f5278e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f5282i);
                AppPrivacyPolicyActivity.a(a.this.f5282i, a.this.f5283j);
                e.a("lp_app_dialog_click_privacy", a.this.f5284k);
            }
        });
        this.f5279f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                e.a("lp_app_dialog_click_giveup", a.this.f5284k);
            }
        });
        this.f5281h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_dialog_click_download", a.this.f5284k);
                b.a().b(a.this.f5284k);
                a.this.dismiss();
            }
        });
    }
}
