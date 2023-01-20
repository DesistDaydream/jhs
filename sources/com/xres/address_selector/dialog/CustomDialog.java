package com.xres.address_selector.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.xres.address_selector.dialog.CustomDialog;
import e.u.a.e.c;
import e.u.a.f.b;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/xres/address_selector/dialog/CustomDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "builder", "Lcom/xres/address_selector/dialog/CustomDialog$Builder;", "context", "Landroid/content/Context;", "(Lcom/xres/address_selector/dialog/CustomDialog$Builder;Landroid/content/Context;)V", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "observer", "Lcom/xres/address_selector/dialog/DialogLifecycleObserver;", "onAttachedToWindow", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateCustomView", "Landroid/view/View;", "onStop", "Builder", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomDialog extends AppCompatDialog {
    @d
    private final a a;
    @d
    private final DialogLifecycleObserver b;
    @d

    /* renamed from: c */
    private final GradientDrawable f9226c;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010A\u001a\u00020BH\u0016J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0012\u0010 \u001a\u00020\u00002\n\u0010E\u001a\u00060\u001ej\u0002`\u001fJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'J\u0012\u0010+\u001a\u00020\u00002\n\u0010E\u001a\u00060\u001ej\u0002`\u001fJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020'J\b\u0010F\u001a\u00020GH\u0016J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0010J\u0010\u00103\u001a\u00020\u00002\b\b\u0001\u00103\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0010J\u0010\u00107\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\u0006J\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0010J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0006R \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR.\u0010 \u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f2\u000e\u0010\u0005\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\"\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0005\u001a\u0004\u0018\u00010#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020'@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R.\u0010+\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f2\u000e\u0010\u0005\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u001e\u0010-\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020'@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\"\u0010/\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0013R\"\u00101\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0013R \u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\tR\"\u00105\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0013R \u00107\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\tR\"\u00109\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0013R \u0010;\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\tR$\u0010=\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?¨\u0006H"}, d2 = {"Lcom/xres/address_selector/dialog/CustomDialog$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "bgColor", "getBgColor", "()I", "", "bottomWithRoundCorner", "getBottomWithRoundCorner", "()Z", "canBeCancelOutside", "getCanBeCancelOutside", "", "content", "getContent", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "fullScreenWidth", "getFullScreenWidth", "gravity", "getGravity", "Lcom/xres/address_selector/dialog/CustomViewInflater;", "inflater", "getInflater", "()Lcom/xres/address_selector/dialog/CustomViewInflater;", "Lcom/xres/address_selector/ext/OnDialogClickListener;", "Lcom/xres/address_selector/ext/DialogCallback;", "leftOnClickListener", "getLeftOnClickListener", "()Lcom/xres/address_selector/ext/OnDialogClickListener;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "", "ratioScreenHeight", "getRatioScreenHeight", "()F", "rightOnClickListener", "getRightOnClickListener", "roundCorner", "getRoundCorner", "subTitle", "getSubTitle", "textLeft", "getTextLeft", "textLeftColor", "getTextLeftColor", "textRight", "getTextRight", "textRightColor", "getTextRightColor", "title", "getTitle", "titleColor", "getTitleColor", "windowsAnimation", "getWindowsAnimation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "build", "Lcom/xres/address_selector/dialog/CustomDialog;", "canBeCancledOutside", "customView", "callback", TTLogUtil.TAG_EVENT_SHOW, "", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static class a {
        @d
        private final Context a;
        @e
        private String b;
        @e

        /* renamed from: c */
        private String f9227c;
        @e

        /* renamed from: e */
        private String f9229e;
        @e

        /* renamed from: f */
        private String f9230f;
        @e

        /* renamed from: g */
        private b f9231g;
        @e

        /* renamed from: h */
        private b f9232h;
        @e

        /* renamed from: i */
        private c f9233i;
        @e

        /* renamed from: k */
        private Integer f9235k;
        private boolean n;
        private float o;
        @e
        private LifecycleOwner u;
        @d

        /* renamed from: d */
        private String f9228d = "assert content not be empty";

        /* renamed from: j */
        private boolean f9234j = true;

        /* renamed from: l */
        private int f9236l = 17;

        /* renamed from: m */
        private boolean f9237m = true;
        @ColorInt
        private int p = Color.parseColor("#FF353535");
        @ColorInt
        private int q = Color.parseColor("#EEFFFFFF");
        @ColorInt
        private int r = Color.parseColor("#FF353535");
        @ColorInt
        private int s = Color.parseColor("#FF0096DF");
        private float t = 16.0f;

        public a(@d Context context) {
            this.a = context;
        }

        @e
        public final Integer A() {
            return this.f9235k;
        }

        @d
        public final a B(int i2) {
            this.f9236l = i2;
            return this;
        }

        @d
        public final a C(@d b bVar) {
            this.f9231g = bVar;
            return this;
        }

        @d
        public final a D(@d LifecycleOwner lifecycleOwner) {
            this.u = lifecycleOwner;
            return this;
        }

        @d
        public final a E(float f2) {
            this.o = f2;
            return this;
        }

        @d
        public final a F(@d b bVar) {
            this.f9232h = bVar;
            return this;
        }

        @d
        public final a G(float f2) {
            this.t = f2;
            return this;
        }

        public void H() {
            c().show();
        }

        @d
        public final a I(@d String str) {
            this.f9227c = str;
            return this;
        }

        @d
        public final a J(@d String str) {
            this.f9229e = str;
            return this;
        }

        @d
        public final a K(@ColorInt int i2) {
            this.r = i2;
            return this;
        }

        @d
        public final a L(@d String str) {
            this.f9230f = str;
            return this;
        }

        @d
        public final a M(@ColorInt int i2) {
            this.s = i2;
            return this;
        }

        @d
        public final a N(@d String str) {
            this.b = str;
            return this;
        }

        @d
        public final a O(int i2) {
            this.f9235k = Integer.valueOf(i2);
            return this;
        }

        @d
        public final a a(@ColorInt int i2) {
            this.q = i2;
            return this;
        }

        @d
        public final a b(boolean z) {
            this.f9237m = z;
            return this;
        }

        @d
        public CustomDialog c() {
            CustomDialog customDialog = new CustomDialog(this, this.a);
            customDialog.create();
            if (customDialog.getContext() instanceof ComponentActivity) {
                this.u = (ComponentActivity) customDialog.getContext();
            }
            return customDialog;
        }

        @d
        public final a d(boolean z) {
            this.f9234j = z;
            return this;
        }

        @d
        public final a e(@d String str) {
            this.f9228d = str;
            return this;
        }

        @d
        public final a f(@d c cVar) {
            this.f9233i = cVar;
            return this;
        }

        @d
        public final a g(boolean z) {
            this.n = z;
            return this;
        }

        @d
        public final Context getContext() {
            return this.a;
        }

        public final int h() {
            return this.q;
        }

        public final boolean i() {
            return this.f9237m;
        }

        public final boolean j() {
            return this.f9234j;
        }

        @d
        public final String k() {
            return this.f9228d;
        }

        public final boolean l() {
            return this.n;
        }

        public final int m() {
            return this.f9236l;
        }

        @e
        public final c n() {
            return this.f9233i;
        }

        @e
        public final b o() {
            return this.f9231g;
        }

        @e
        public final LifecycleOwner p() {
            return this.u;
        }

        public final float q() {
            return this.o;
        }

        @e
        public final b r() {
            return this.f9232h;
        }

        public final float s() {
            return this.t;
        }

        @e
        public final String t() {
            return this.f9227c;
        }

        @e
        public final String u() {
            return this.f9229e;
        }

        public final int v() {
            return this.r;
        }

        @e
        public final String w() {
            return this.f9230f;
        }

        public final int x() {
            return this.s;
        }

        @e
        public final String y() {
            return this.b;
        }

        public final int z() {
            return this.p;
        }
    }

    public CustomDialog(@d a aVar, @d Context context) {
        super(context);
        Lifecycle lifecycle;
        this.a = aVar;
        DialogLifecycleObserver dialogLifecycleObserver = new DialogLifecycleObserver(new CustomDialog$observer$1(this));
        this.b = dialogLifecycleObserver;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        t1 t1Var = t1.a;
        this.f9226c = gradientDrawable;
        setCanceledOnTouchOutside(aVar.j());
        Integer A = aVar.A();
        if (A != null) {
            int intValue = A.intValue();
            Window window = getWindow();
            if (window != null) {
                window.setWindowAnimations(intValue);
            }
        }
        LifecycleOwner p = aVar.p();
        if (p == null || (lifecycle = p.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(dialogLifecycleObserver);
    }

    public static /* synthetic */ void a(CustomDialog customDialog, View view) {
        d(customDialog, view);
    }

    public static /* synthetic */ void b(CustomDialog customDialog, View view) {
        c(customDialog, view);
    }

    public static final void c(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        b o = customDialog.a.o();
        if (o == null) {
            return;
        }
        o.a(customDialog);
    }

    public static final void d(CustomDialog customDialog, View view) {
        b r = customDialog.a.r();
        if (r == null) {
            return;
        }
        r.a(customDialog);
    }

    @e
    public View e(@d Context context) {
        return null;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
        window.setGravity(this.a.m());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = this.a.l() ? -1 : (int) (e.u.a.f.c.a(window.getContext()).x * 0.8f);
        float q = this.a.q();
        attributes.height = (q > 0.0f ? 1 : (q == 0.0f ? 0 : -1)) == 0 ? -2 : (int) (e.u.a.f.c.a(window.getContext()).y * q);
        t1 t1Var = t1.a;
        window.setAttributes(attributes);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@e Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        super.onCreate(bundle);
        float f2 = e.u.a.f.a.f(this.a.s());
        if (this.a.i()) {
            this.f9226c.setCornerRadius(f2);
        } else {
            this.f9226c.setCornerRadii(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(this.f9226c);
        t1 t1Var = t1.a;
        if (this.a.y() == null) {
            textView = null;
        } else {
            textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = e.u.a.f.a.f(25.0f);
            textView.setLayoutParams(layoutParams);
            textView.setText(this.a.y());
            textView.setGravity(1);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextSize(1, 17.0f);
        }
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, e.u.a.f.a.f(10.0f)));
        }
        View e2 = e(getContext());
        View view = e2;
        if (e2 == null) {
            c n = this.a.n();
            if (n == null) {
                TextView textView6 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(e.u.a.f.a.f(30.0f), e.u.a.f.a.f(10.0f), e.u.a.f.a.f(30.0f), e.u.a.f.a.f(20.0f));
                textView6.setLayoutParams(layoutParams2);
                textView6.setText(this.a.k());
                textView6.setMinHeight(e.u.a.f.a.f(56.0f));
                textView6.setGravity(16);
                textView6.setLineSpacing(e.u.a.f.a.f(6.0f), 1.0f);
                textView6.setTextColor(Color.parseColor("#353535"));
                textView6.setTextSize(1, 14.0f);
                view = textView6;
            } else {
                view = n.a(LayoutInflater.from(getContext()), linearLayout);
            }
        }
        linearLayout.addView(textView);
        linearLayout.addView(view);
        View view2 = new View(getContext());
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, e.u.a.f.a.f(1.0f)));
        view2.setBackgroundColor(Color.parseColor("#dedfe0"));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, e.u.a.f.a.f(45.0f)));
        if (this.a.i()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, f2, f2});
            linearLayout2.setBackground(gradientDrawable);
        }
        if (this.a.u() == null) {
            textView2 = null;
        } else {
            textView2 = new TextView(getContext());
            textView2.setText(this.a.u());
            textView2.setGravity(17);
            textView2.setTextSize(1, 16.0f);
            textView2.setTextColor(this.a.v());
            textView2.setTypeface(null, 1);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: e.u.a.e.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    CustomDialog.b(CustomDialog.this, view3);
                }
            });
        }
        String w = this.a.w();
        if (w == null) {
            textView4 = null;
            textView3 = null;
        } else {
            textView3 = new TextView(getContext());
            textView3.setText(w);
            textView3.setGravity(17);
            textView3.setTextSize(1, 16.0f);
            textView3.setTextColor(this.a.x());
            textView4 = null;
            textView3.setTypeface(null, 1);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: e.u.a.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    CustomDialog.a(CustomDialog.this, view3);
                }
            });
        }
        View view3 = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(e.u.a.f.a.f(1.0f), e.u.a.f.a.f(24.0f));
        layoutParams3.gravity = 17;
        view3.setLayoutParams(layoutParams3);
        view3.setBackgroundColor(Color.parseColor("#dedfe0"));
        if (textView2 == null) {
            textView2 = textView4;
        } else {
            linearLayout.addView(view2);
            linearLayout2.addView(textView2);
            if (textView3 != null) {
                linearLayout2.addView(view3);
                linearLayout2.addView(textView3);
            }
        }
        if (textView2 != null) {
            textView5 = textView2;
        } else if (textView3 == null) {
            textView5 = textView4;
        } else {
            linearLayout.addView(view2);
            linearLayout2.addView(textView3);
            textView5 = textView3;
        }
        if (textView5 != null) {
            linearLayout.addView(linearLayout2);
        }
        setContentView(linearLayout);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        Lifecycle lifecycle;
        super.onStop();
        LifecycleOwner p = this.a.p();
        if (p == null || (lifecycle = p.getLifecycle()) == null) {
            return;
        }
        lifecycle.removeObserver(this.b);
    }
}
