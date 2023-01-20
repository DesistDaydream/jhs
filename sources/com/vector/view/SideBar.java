package com.vector.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.ColorInt;
import androidx.databinding.ObservableField;
import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import e.j.a.b.c.r.c0;
import e.t.o.d;
import e.t.u.h;
import h.k2.u.q;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 ^2\u00020\u0001:\u0002]^B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010M\u001a\u00020#H\u0002J\b\u0010N\u001a\u00020\u000eH\u0002J\u0010\u0010O\u001a\u00020#2\u0006\u0010P\u001a\u00020QH\u0014J\u0018\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u000eH\u0014J\u0010\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020WH\u0017JW\u0010X\u001a\u00020#2O\u0010\u001b\u001aK\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001cj\u0002`$J \u0010Y\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010\u001b\u001aO\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001cj\u0004\u0018\u0001`$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R2\u00109\u001a\b\u0012\u0004\u0012\u00020 082\f\u00107\u001a\b\u0012\u0004\u0012\u00020 08@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010?\u001a\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010 0 0@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010\u0014R\u001a\u0010I\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0012\"\u0004\bK\u0010\u0014R\u000e\u0010L\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/vector/view/SideBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "align", "Lcom/vector/view/SideBar$Align;", "getAlign", "()Lcom/vector/view/SideBar$Align;", "setAlign", "(Lcom/vector/view/SideBar$Align;)V", "areaHeight", "", "choose", "color", "getColor", "()I", "setColor", "(I)V", "colorFocus", "getColorFocus", "setColorFocus", "isGL", "", "lastSelect", c0.a.a, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "", "s", "isFocus", "", "Lcom/vector/view/OnTouchLetterListener;", "paint", "Landroid/graphics/Paint;", "popHeight", "getPopHeight", "setPopHeight", "popupViewBinding", "Lcom/vector/databinding/LayoutSideBarPopBinding;", "getPopupViewBinding", "()Lcom/vector/databinding/LayoutSideBarPopBinding;", "popupViewBinding$delegate", "Lkotlin/Lazy;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "popupWindow$delegate", "screenX", "screenY", "value", "", "selections", "getSelections", "()[Ljava/lang/String;", "setSelections", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "showWord", "Landroidx/databinding/ObservableField;", "kotlin.jvm.PlatformType", "getShowWord", "()Landroidx/databinding/ObservableField;", "setShowWord", "(Landroidx/databinding/ObservableField;)V", "textGap", "getTextGap", "setTextGap", "textSize", "getTextSize", "setTextSize", "totalHeight", "getLocation", "measureHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setOnTouchLetterChangeListener", "updatePop", "x", "", "y", "Align", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SideBar extends View {
    @d
    private static final String u = "SideBar";
    private static final int x = 11;
    private static final int y = 5;
    private static final int z = 58;
    @ColorInt
    private int a;
    @ColorInt
    private int b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private q<? super Integer, ? super String, ? super Boolean, t1> f7938c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Paint f7939d;

    /* renamed from: e  reason: collision with root package name */
    private int f7940e;

    /* renamed from: f  reason: collision with root package name */
    private int f7941f;

    /* renamed from: g  reason: collision with root package name */
    private int f7942g;

    /* renamed from: h  reason: collision with root package name */
    private int f7943h;

    /* renamed from: i  reason: collision with root package name */
    private int f7944i;

    /* renamed from: j  reason: collision with root package name */
    private int f7945j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private Align f7946k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7947l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private String[] f7948m;
    @d
    private ObservableField<String> n;
    @d
    private final w o;
    @d
    private final w p;
    private int q;
    private int r;
    private boolean s;
    @d
    public static final a t = new a(null);
    private static final int v = Color.parseColor("#3A3F5C");
    private static final int w = Color.parseColor("#0091FF");
    @d
    private static final String[] A = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", ExpandableTextView.P, "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "*"};

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vector/view/SideBar$Align;", "", "(Ljava/lang/String;I)V", "TOP", "CENTER", "BOTTOM", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Align {
        TOP,
        CENTER,
        BOTTOM
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/vector/view/SideBar$Companion;", "", "()V", "COLOR_FOCUS", "", "COLOR_NORMAL", "POP_HEIGHT", "SELECTIONS", "", "", "[Ljava/lang/String;", "TAG", "TEXT_GAP", "TEXT_SIZE_DP", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public SideBar(@d Context context, @d AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = v;
        this.b = w;
        this.f7939d = new Paint();
        this.f7940e = -1;
        this.f7946k = Align.TOP;
        this.f7948m = A;
        this.n = new ObservableField<>("");
        this.o = z.c(new SideBar$popupViewBinding$2(context, this));
        this.p = z.c(new SideBar$popupWindow$2(this));
        d.a aVar = e.t.o.d.a;
        this.f7943h = aVar.a(context).d(11);
        this.f7944i = aVar.a(context).d(5);
        this.f7945j = aVar.a(context).d(58) / 2;
    }

    private final int b() {
        int i2 = this.f7943h + this.f7944i;
        this.f7941f = i2;
        int length = i2 * this.f7948m.length;
        this.f7942g = length;
        return length;
    }

    private final void c(String str, float f2, float f3) {
        try {
            getLocation();
            this.n.set(str);
            if (getPopupWindow().isShowing()) {
                getPopupWindow().update(this.q - (getMeasuredWidth() * 4), this.r - ((this.f7945j - ((int) f3)) + (this.f7941f / 4)), -1, -1);
            } else {
                getPopupWindow().showAtLocation(this, 0, this.q - (getMeasuredWidth() * 4), this.r - ((this.f7945j - ((int) f3)) + (this.f7941f / 4)));
            }
        } catch (Exception e2) {
            Log.w(u, e2);
        }
    }

    private final void getLocation() {
        if (this.s) {
            return;
        }
        this.s = true;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.q = iArr[0];
        this.r = iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.t.j.d getPopupViewBinding() {
        return (e.t.j.d) this.o.getValue();
    }

    private final PopupWindow getPopupWindow() {
        return (PopupWindow) this.p.getValue();
    }

    @k.e.a.d
    public final Align getAlign() {
        return this.f7946k;
    }

    public final int getColor() {
        return this.a;
    }

    public final int getColorFocus() {
        return this.b;
    }

    public final int getPopHeight() {
        return this.f7945j;
    }

    @k.e.a.d
    public final String[] getSelections() {
        return this.f7948m;
    }

    @k.e.a.d
    public final ObservableField<String> getShowWord() {
        return this.n;
    }

    public final int getTextGap() {
        return this.f7944i;
    }

    public final int getTextSize() {
        return this.f7943h;
    }

    @Override // android.view.View
    public void onDraw(@k.e.a.d Canvas canvas) {
        float width = getWidth() / 2.0f;
        String[] strArr = this.f7948m;
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            int i4 = i3 + 1;
            this.f7939d.reset();
            this.f7939d.setTextSize(getTextSize());
            this.f7939d.setAntiAlias(true);
            if (i3 == this.f7940e) {
                this.f7939d.setColor(getColorFocus());
                this.f7939d.setFakeBoldText(true);
            } else {
                this.f7939d.setColor(getColor());
            }
            float f2 = this.f7941f * i3;
            h.a.h(canvas, str, width, f2, this.f7939d, Paint.Align.CENTER);
            if (i3 == this.f7940e) {
                c(str, width, f2);
            }
            i2++;
            i3 = i4;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i2), b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r7 != 3) goto L8;
     */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@k.e.a.d android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            float r2 = r7.getY()
            int r3 = r6.f7941f
            float r3 = (float) r3
            float r2 = r2 / r3
            int r2 = (int) r2
            int r3 = r6.f7940e
            int r7 = r7.getAction()
            r7 = r7 & 255(0xff, float:3.57E-43)
            r4 = 1
            if (r7 == 0) goto La1
            if (r7 == r4) goto L43
            r5 = 2
            if (r7 == r5) goto L22
            r0 = 3
            if (r7 == r0) goto L43
            goto Lbf
        L22:
            if (r3 == r2) goto Lbf
            if (r2 < 0) goto Lbf
            java.lang.String[] r7 = r6.f7948m
            int r7 = r7.length
            if (r2 >= r7) goto Lbf
            r6.f7940e = r2
            r6.invalidate()
            h.k2.u.q<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.Boolean, h.t1> r7 = r6.f7938c
            if (r7 != 0) goto L36
            goto Lbf
        L36:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String[] r3 = r6.f7948m
            r2 = r3[r2]
            r7.invoke(r1, r2, r0)
            goto Lbf
        L43:
            boolean r7 = r6.f7947l
            if (r7 != 0) goto L4a
            r7 = -1
            r6.f7940e = r7
        L4a:
            r6.invalidate()
            android.widget.PopupWindow r7 = r6.getPopupWindow()     // Catch: java.lang.Exception -> L55
            r7.dismiss()     // Catch: java.lang.Exception -> L55
            goto L5b
        L55:
            r7 = move-exception
            java.lang.String r0 = "SideBar"
            android.util.Log.w(r0, r7)
        L5b:
            if (r2 > 0) goto L6f
            h.k2.u.q<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.Boolean, h.t1> r7 = r6.f7938c
            if (r7 != 0) goto L62
            goto Lbf
        L62:
            r0 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.String[] r3 = r6.f7948m
            r0 = r3[r0]
            r7.invoke(r2, r0, r1)
            goto Lbf
        L6f:
            if (r2 < 0) goto L87
            java.lang.String[] r7 = r6.f7948m
            int r7 = r7.length
            if (r2 >= r7) goto L87
            h.k2.u.q<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.Boolean, h.t1> r7 = r6.f7938c
            if (r7 != 0) goto L7b
            goto Lbf
        L7b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String[] r3 = r6.f7948m
            r2 = r3[r2]
            r7.invoke(r0, r2, r1)
            goto Lbf
        L87:
            java.lang.String[] r7 = r6.f7948m
            int r0 = r7.length
            if (r2 < r0) goto Lbf
            h.k2.u.q<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.Boolean, h.t1> r0 = r6.f7938c
            if (r0 != 0) goto L91
            goto Lbf
        L91:
            int r7 = r7.length
            int r7 = r7 - r4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String[] r2 = r6.f7948m
            int r3 = r2.length
            int r3 = r3 - r4
            r2 = r2[r3]
            r0.invoke(r7, r2, r1)
            goto Lbf
        La1:
            if (r3 == r2) goto Lbf
            if (r2 < 0) goto Lbf
            java.lang.String[] r7 = r6.f7948m
            int r7 = r7.length
            if (r2 >= r7) goto Lbf
            r6.f7940e = r2
            r6.invalidate()
            h.k2.u.q<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.Boolean, h.t1> r7 = r6.f7938c
            if (r7 != 0) goto Lb4
            goto Lbf
        Lb4:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String[] r3 = r6.f7948m
            r2 = r3[r2]
            r7.invoke(r1, r2, r0)
        Lbf:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vector.view.SideBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setAlign(@k.e.a.d Align align) {
        this.f7946k = align;
    }

    public final void setColor(int i2) {
        this.a = i2;
    }

    public final void setColorFocus(int i2) {
        this.b = i2;
    }

    public final void setOnTouchLetterChangeListener(@k.e.a.d q<? super Integer, ? super String, ? super Boolean, t1> qVar) {
        this.f7938c = qVar;
    }

    public final void setPopHeight(int i2) {
        this.f7945j = i2;
    }

    public final void setSelections(@k.e.a.d String[] strArr) {
        this.f7948m = strArr;
        requestLayout();
    }

    public final void setShowWord(@k.e.a.d ObservableField<String> observableField) {
        this.n = observableField;
    }

    public final void setTextGap(int i2) {
        this.f7944i = i2;
    }

    public final void setTextSize(int i2) {
        this.f7943h = i2;
    }
}
