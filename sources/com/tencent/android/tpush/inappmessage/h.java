package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.ServiceStat;

/* loaded from: classes3.dex */
public abstract class h extends a {

    /* renamed from: d  reason: collision with root package name */
    public d f6131d;

    /* renamed from: e  reason: collision with root package name */
    public String f6132e;

    /* renamed from: f  reason: collision with root package name */
    public Intent f6133f;

    public h(Activity activity, d dVar, Intent intent) {
        super(activity);
        this.f6132e = "PopupMessageTemplate";
        this.f6131d = dVar;
        this.f6133f = intent;
        a();
    }

    private View d(Context context) {
        if (this.f6131d.f() == 1) {
            Button button = new Button(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeUtil.dipTopx(context, 48.0f));
            layoutParams.setMargins(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f));
            layoutParams.gravity = 1;
            button.setLayoutParams(layoutParams);
            button.setBackgroundColor(Color.parseColor(this.f6131d.I()));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(this.f6131d.l());
            gradientDrawable.setColor(Color.parseColor(this.f6131d.I()));
            button.setBackground(gradientDrawable);
            button.setText(this.f6131d.w());
            button.setTextColor(Color.parseColor(this.f6131d.J()));
            button.setTextSize(this.f6131d.k());
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.android.tpush.inappmessage.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.f6133f.putExtra(MessageKey.MSG_INAPP_CUSTOM_EVENT_ID, "INNER_MESSAGE");
                    h hVar = h.this;
                    hVar.f6133f.putExtra(MessageKey.MSG_INAPP_BUTTON_EVENT_ID, hVar.f6131d.m());
                    ServiceStat.appReportNotificationClicked(com.tencent.android.tpush.service.b.e(), h.this.f6133f);
                    String n = h.this.f6131d.n();
                    int d2 = h.this.f6131d.d();
                    if (d2 == 1) {
                        h.this.cancel();
                    } else if (d2 == 2) {
                        h.this.b(n);
                    } else if (d2 == 3) {
                        h.this.a(n);
                    } else if (d2 == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.b.finish();
                    h.this.b.overridePendingTransition(0, 0);
                }
            });
            return button;
        } else if (this.f6131d.f() == 2) {
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtil.dipTopx(context, 48.0f));
            layoutParams2.setMargins(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f));
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(0);
            Button button2 = new Button(context);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams3.gravity = 3;
            button2.setLayoutParams(layoutParams3);
            button2.setBackgroundColor(Color.parseColor(this.f6131d.I()));
            button2.setText(this.f6131d.w());
            button2.setTextColor(Color.parseColor(this.f6131d.J()));
            button2.setTextSize(this.f6131d.k());
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(this.f6131d.l());
            gradientDrawable2.setColor(Color.parseColor(this.f6131d.I()));
            button2.setBackground(gradientDrawable2);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.android.tpush.inappmessage.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String n = h.this.f6131d.n();
                    h.this.f6133f.putExtra(MessageKey.MSG_INAPP_CUSTOM_EVENT_ID, "INNER_MESSAGE");
                    h hVar = h.this;
                    hVar.f6133f.putExtra(MessageKey.MSG_INAPP_BUTTON_EVENT_ID, hVar.f6131d.m());
                    ServiceStat.appReportNotificationClicked(com.tencent.android.tpush.service.b.e(), h.this.f6133f);
                    int d2 = h.this.f6131d.d();
                    if (d2 == 1) {
                        h.this.cancel();
                    } else if (d2 == 2) {
                        h.this.b(n);
                    } else if (d2 == 3) {
                        h.this.a(n);
                    } else if (d2 == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.b.finish();
                    h.this.b.overridePendingTransition(0, 0);
                }
            });
            linearLayout.addView(button2);
            View view = new View(context);
            view.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.2f));
            linearLayout.addView(view);
            Button button3 = new Button(context);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams4.gravity = 5;
            button3.setLayoutParams(layoutParams4);
            button3.setBackgroundColor(Color.parseColor(this.f6131d.u()));
            button3.setText(this.f6131d.t());
            button3.setTextColor(Color.parseColor(this.f6131d.s()));
            button3.setTextSize(this.f6131d.r());
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius(this.f6131d.q());
            gradientDrawable3.setColor(Color.parseColor(this.f6131d.u()));
            button3.setBackground(gradientDrawable3);
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.android.tpush.inappmessage.h.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String o = h.this.f6131d.o();
                    h.this.f6133f.putExtra(MessageKey.MSG_INAPP_CUSTOM_EVENT_ID, "INNER_MESSAGE");
                    h hVar = h.this;
                    hVar.f6133f.putExtra(MessageKey.MSG_INAPP_BUTTON_EVENT_ID, hVar.f6131d.p());
                    ServiceStat.appReportNotificationClicked(com.tencent.android.tpush.service.b.e(), h.this.f6133f);
                    int c2 = h.this.f6131d.c();
                    if (c2 == 1) {
                        h.this.cancel();
                    } else if (c2 == 2) {
                        h.this.b(o);
                    } else if (c2 == 3) {
                        h.this.a(o);
                    } else if (c2 == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.b.finish();
                    h.this.b.overridePendingTransition(0, 0);
                }
            });
            linearLayout.addView(button3);
            return linearLayout;
        } else {
            return null;
        }
    }

    private TextView e(Context context) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int D = this.f6131d.D();
        if (D == 0) {
            layoutParams.gravity = 3;
        } else if (D == 1) {
            layoutParams.gravity = 1;
        } else if (D == 2) {
            layoutParams.gravity = 5;
        }
        textView.setLayoutParams(layoutParams);
        textView.setPadding(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), 0);
        textView.setText(this.f6131d.F());
        textView.setTextColor(Color.parseColor(this.f6131d.G()));
        textView.setTextSize(2, this.f6131d.C());
        textView.setMaxLines(8);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        int E = this.f6131d.E();
        if (E == 0) {
            textView.setTypeface(Typeface.DEFAULT);
        } else if (E == 1) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (E == 2) {
            textView.setTypeface(null, 2);
        } else if (E == 3) {
            textView.getPaint().setFlags(8);
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.b.getPackageName());
            intent.putExtra(NotificationCompat.EXTRA_CHANNEL_ID, this.b.getApplicationInfo().uid);
            intent.putExtra("app_package", this.b.getPackageName());
            intent.putExtra("app_uid", this.b.getApplicationInfo().uid);
            this.b.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", this.b.getPackageName(), null));
            this.b.startActivity(intent2);
        }
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    public boolean c() {
        return this.f6131d.e() == 1;
    }

    private RelativeLayout b(RelativeLayout relativeLayout) {
        if (this.f6131d.v() != null && !TextUtils.isEmpty(this.f6131d.v())) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(i.a(this.f6131d.g()));
            shapeDrawable.getPaint().setColor(Color.parseColor(this.f6131d.v()));
            relativeLayout.setBackground(shapeDrawable);
        }
        if (this.f6131d.H() != null && !TextUtils.isEmpty(this.f6131d.H())) {
            relativeLayout.setBackgroundColor(-1);
            new f(this.f6131d.H(), relativeLayout, this.b, this.f6131d.g()).execute(new Void[0]);
        }
        return relativeLayout;
    }

    private TextView c(Context context) {
        TextView textView = new TextView(context);
        textView.setPadding(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), 0);
        textView.setText(this.f6131d.x());
        textView.setTextColor(Color.parseColor(this.f6131d.y()));
        textView.setTextSize(2, this.f6131d.A());
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setSingleLine(true);
        int z = this.f6131d.z();
        if (z == 0) {
            textView.setTypeface(Typeface.DEFAULT);
        } else if (z == 1) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (z == 2) {
            textView.setTypeface(null, 2);
        } else if (z == 3) {
            textView.getPaint().setFlags(8);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int B = this.f6131d.B();
        if (B == 0) {
            layoutParams.gravity = 3;
        } else if (B == 1) {
            layoutParams.gravity = 1;
        } else if (B == 2) {
            layoutParams.gravity = 5;
        }
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    @RequiresApi(api = 23)
    public void a(RelativeLayout relativeLayout) {
        View d2;
        View d3;
        View d4;
        View d5;
        ScrollView scrollView = new ScrollView(this.b);
        scrollView.setVerticalScrollBarEnabled(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        String a = this.f6131d.a(1);
        if ("Title.Location".equals(a) && !TextUtils.isEmpty(this.f6131d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a) && !TextUtils.isEmpty(this.f6131d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a) && !TextUtils.isEmpty(this.f6131d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a) && this.f6131d.f() > 0 && (d2 = d(this.b)) != null) {
            linearLayout.addView(d2);
        }
        String a2 = this.f6131d.a(2);
        if ("Title.Location".equals(a2) && !TextUtils.isEmpty(this.f6131d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a2) && !TextUtils.isEmpty(this.f6131d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a2) && !TextUtils.isEmpty(this.f6131d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a2) && this.f6131d.f() > 0 && (d3 = d(this.b)) != null) {
            linearLayout.addView(d3);
        }
        String a3 = this.f6131d.a(3);
        if ("Title.Location".equals(a3) && !TextUtils.isEmpty(this.f6131d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a3) && !TextUtils.isEmpty(this.f6131d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a3) && !TextUtils.isEmpty(this.f6131d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a3) && this.f6131d.f() > 0 && (d4 = d(this.b)) != null) {
            linearLayout.addView(d4);
        }
        String a4 = this.f6131d.a(4);
        if ("Title.Location".equals(a4) && !TextUtils.isEmpty(this.f6131d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a4) && !TextUtils.isEmpty(this.f6131d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a4) && !TextUtils.isEmpty(this.f6131d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a4) && this.f6131d.f() > 0 && (d5 = d(this.b)) != null) {
            linearLayout.addView(d5);
        }
        b(relativeLayout);
        scrollView.addView(linearLayout);
        relativeLayout.addView(scrollView);
    }

    private ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f6131d.i(), this.f6131d.j());
        layoutParams.gravity = 1;
        layoutParams.topMargin = SizeUtil.dipTopx(context, 24.0f);
        layoutParams.leftMargin = SizeUtil.dipTopx(context, 24.0f);
        layoutParams.rightMargin = SizeUtil.dipTopx(context, 24.0f);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            Intent intent = new Intent();
            String str2 = this.f6132e;
            TLogger.i(str2, "jumpIntent targetActivity:" + str);
            Uri parse = Uri.parse(str);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            if (intent.resolveActivity(this.b.getPackageManager()) != null) {
                this.b.startActivity(intent);
            }
        } catch (Throwable th) {
            TLogger.e(this.f6132e, "jumpIntent error.", th);
        }
    }

    private ImageView a(Context context) {
        ImageView b = b(this.b);
        new f(this.f6131d.h(), b, this.b, 0).execute(new Void[0]);
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            String str2 = this.f6132e;
            TLogger.i(str2, "jumpUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.b.startActivity(intent);
        } catch (Throwable th) {
            TLogger.e(this.f6132e, "openUrl error.", th);
        }
    }
}
