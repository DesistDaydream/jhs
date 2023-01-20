package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* loaded from: classes3.dex */
public class d extends Dialog {
    private TextView a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f5220c;

    /* renamed from: d  reason: collision with root package name */
    private c f5221d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5222e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f5223f;

    /* renamed from: g  reason: collision with root package name */
    private String f5224g;

    /* renamed from: h  reason: collision with root package name */
    private String f5225h;

    /* renamed from: i  reason: collision with root package name */
    private String f5226i;

    /* loaded from: classes3.dex */
    public static class a {
        private Activity a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f5227c;

        /* renamed from: d  reason: collision with root package name */
        private String f5228d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5229e;

        /* renamed from: f  reason: collision with root package name */
        private c f5230f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.f5227c = str;
            return this;
        }

        public a c(String str) {
            this.f5228d = str;
            return this;
        }

        public a a(boolean z) {
            this.f5229e = z;
            return this;
        }

        public a a(c cVar) {
            this.f5230f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.b, this.f5227c, this.f5228d, this.f5229e, this.f5230f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f5223f = activity;
        this.f5221d = cVar;
        this.f5224g = str;
        this.f5225h = str2;
        this.f5226i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f5223f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.b = (TextView) findViewById(c());
        this.f5220c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.f5225h)) {
            this.a.setText(this.f5225h);
        }
        if (!TextUtils.isEmpty(this.f5226i)) {
            this.b.setText(this.f5226i);
        }
        if (!TextUtils.isEmpty(this.f5224g)) {
            this.f5220c.setText(this.f5224g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f5222e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    public int c() {
        return R.id.cancel_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f5223f.isFinishing()) {
            this.f5223f.finish();
        }
        if (this.f5222e) {
            this.f5221d.a();
        } else {
            this.f5221d.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }
}
