package com.ctetin.expandabletextviewlibrary;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.PatternsCompat;
import com.ctetin.expandabletextviewlibrary.app.LinkType;
import com.ctetin.expandabletextviewlibrary.app.StatusType;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.e.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ExpandableTextView extends AppCompatTextView {
    private static final int K = 4;
    public static String L = "收起";
    public static String M = "更多";
    public static final String N = " ";
    public static String O = "Web Link";
    public static final String P = "I";
    public static final String Q = "                                                                                                                                                                                                                                                                                                                           ";
    private static int R = 0;
    public static final String S = "@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}:";
    public static final String T = "\\[([^\\[]*)\\]\\(([^\\(]*)\\)";
    private int A;
    private int B;
    private int C;
    private String D;
    private String E;
    private String F;
    private int G;
    private boolean H;
    public boolean I;
    private k J;
    private String a;
    private TextPaint b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2545c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2546d;

    /* renamed from: e  reason: collision with root package name */
    private e.e.a.a.a f2547e;

    /* renamed from: f  reason: collision with root package name */
    private DynamicLayout f2548f;

    /* renamed from: g  reason: collision with root package name */
    private int f2549g;

    /* renamed from: h  reason: collision with root package name */
    private int f2550h;

    /* renamed from: i  reason: collision with root package name */
    private int f2551i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f2552j;

    /* renamed from: k  reason: collision with root package name */
    private l f2553k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2554l;

    /* renamed from: m  reason: collision with root package name */
    private j f2555m;
    private boolean n;
    private e.e.a.a.b o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private CharSequence x;
    private int y;
    private int z;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (!ExpandableTextView.this.H) {
                ExpandableTextView.this.H();
            }
            ExpandableTextView.this.H = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExpandableTextView.s();
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.setContent(expandableTextView.x.toString());
        }
    }

    /* loaded from: classes.dex */
    public class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (ExpandableTextView.this.f2554l) {
                if (ExpandableTextView.this.f2547e != null) {
                    ExpandableTextView.this.f2547e.a(StatusType.STATUS_CONTRACT);
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.B(expandableTextView.f2547e.getStatus());
                } else {
                    ExpandableTextView.this.A();
                }
            }
            if (ExpandableTextView.this.f2555m != null) {
                ExpandableTextView.this.f2555m.a(StatusType.STATUS_EXPAND);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ExpandableTextView.this.y);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes.dex */
    public class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (ExpandableTextView.this.f2547e != null) {
                ExpandableTextView.this.f2547e.a(StatusType.STATUS_EXPAND);
                ExpandableTextView expandableTextView = ExpandableTextView.this;
                expandableTextView.B(expandableTextView.f2547e.getStatus());
            } else {
                ExpandableTextView.this.A();
            }
            if (ExpandableTextView.this.f2555m != null) {
                ExpandableTextView.this.f2555m.a(StatusType.STATUS_CONTRACT);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ExpandableTextView.this.C);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes.dex */
    public class e extends ClickableSpan {
        public final /* synthetic */ b.a a;

        public e(b.a aVar) {
            this.a = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (ExpandableTextView.this.f2553k != null) {
                ExpandableTextView.this.f2553k.a(LinkType.SELF, this.a.b(), this.a.c());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.B);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes.dex */
    public class f extends ClickableSpan {
        public final /* synthetic */ b.a a;

        public f(b.a aVar) {
            this.a = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (ExpandableTextView.this.f2553k != null) {
                ExpandableTextView.this.f2553k.a(LinkType.MENTION_TYPE, this.a.e(), null);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.z);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes.dex */
    public class g extends ClickableSpan {
        public final /* synthetic */ b.a a;

        public g(b.a aVar) {
            this.a = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (ExpandableTextView.this.f2553k != null) {
                ExpandableTextView.this.f2553k.a(LinkType.LINK_TYPE, this.a.e(), null);
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(this.a.e()));
            ExpandableTextView.this.f2546d.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.A);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ boolean a;

        public h(boolean z) {
            this.a = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f2 = (Float) valueAnimator.getAnimatedValue();
            if (!this.a) {
                if (ExpandableTextView.this.n) {
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.f2550h = expandableTextView.f2549g + ((int) ((ExpandableTextView.this.w - ExpandableTextView.this.f2549g) * (1.0f - f2.floatValue())));
                }
            } else {
                ExpandableTextView expandableTextView2 = ExpandableTextView.this;
                expandableTextView2.f2550h = expandableTextView2.f2549g + ((int) ((ExpandableTextView.this.w - ExpandableTextView.this.f2549g) * f2.floatValue()));
            }
            ExpandableTextView expandableTextView3 = ExpandableTextView.this;
            expandableTextView3.setText(expandableTextView3.U(expandableTextView3.x));
        }
    }

    /* loaded from: classes.dex */
    public static class i extends LinkMovementMethod {
        public static i a;

        public static i a() {
            if (a == null) {
                a = new i();
            }
            return a;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                if (textView instanceof ExpandableTextView) {
                    ((ExpandableTextView) textView).f2545c = true;
                }
                return true;
            }
            Selection.removeSelection(spannable);
            Touch.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(StatusType statusType);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(int i2, boolean z);
    }

    /* loaded from: classes.dex */
    public interface l {
        void a(LinkType linkType, String str, String str2);
    }

    /* loaded from: classes.dex */
    public class m extends ImageSpan {
        private Drawable a;

        public m(Drawable drawable, int i2) {
            super(drawable, i2);
            this.a = drawable;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
        public Drawable getDrawable() {
            return this.a;
        }
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        B(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(StatusType statusType) {
        int i2 = this.f2550h;
        int i3 = this.w;
        boolean z = i2 < i3;
        if (statusType != null) {
            this.v = false;
        }
        if (this.v) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new h(z));
            ofFloat.setDuration(100L);
            ofFloat.start();
            return;
        }
        if (z) {
            int i4 = this.f2549g;
            this.f2550h = i4 + (i3 - i4);
        } else if (this.n) {
            this.f2550h = this.f2549g;
        }
        setText(U(this.x));
    }

    private void C(SpannableStringBuilder spannableStringBuilder, b.a aVar, int i2) {
        spannableStringBuilder.setSpan(new f(aVar), aVar.d(), i2, 17);
    }

    private void D(SpannableStringBuilder spannableStringBuilder, b.a aVar, int i2) {
        spannableStringBuilder.setSpan(new e(aVar), aVar.d(), i2, 17);
    }

    private void E(SpannableStringBuilder spannableStringBuilder, b.a aVar, int i2) {
        spannableStringBuilder.setSpan(new g(aVar), aVar.d() + 1, i2, 17);
    }

    private SpannableStringBuilder G(e.e.a.a.b bVar, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        e.e.a.a.a aVar = this.f2547e;
        if (aVar != null && aVar.getStatus() != null) {
            if (this.f2547e.getStatus() != null && this.f2547e.getStatus().equals(StatusType.STATUS_CONTRACT)) {
                int i2 = this.f2549g;
                this.f2550h = i2 + (this.w - i2);
            } else if (this.n) {
                this.f2550h = this.f2549g;
            }
        }
        if (z) {
            int i3 = this.f2550h;
            if (i3 < this.w) {
                int i4 = i3 - 1;
                int lineEnd = this.f2548f.getLineEnd(i4);
                int lineStart = this.f2548f.getLineStart(i4);
                float lineWidth = this.f2548f.getLineWidth(i4);
                String hideEndContent = getHideEndContent();
                String substring = bVar.a().substring(0, J(hideEndContent, lineEnd, lineStart, lineWidth, this.b.measureText(hideEndContent), 0.0f));
                if (substring.endsWith("\n")) {
                    substring = substring.substring(0, substring.length() - 1);
                }
                spannableStringBuilder.append((CharSequence) substring);
                if (this.u) {
                    float f2 = 0.0f;
                    for (int i5 = 0; i5 < i4; i5++) {
                        f2 += this.f2548f.getLineWidth(i5);
                    }
                    float measureText = ((f2 / i4) - lineWidth) - this.b.measureText(hideEndContent);
                    if (measureText > 0.0f) {
                        int i6 = 0;
                        while (i6 * this.b.measureText(N) < measureText) {
                            i6++;
                        }
                        int i7 = i6 - 1;
                        for (int i8 = 0; i8 < i7; i8++) {
                            spannableStringBuilder.append(N);
                        }
                    }
                }
                spannableStringBuilder.append((CharSequence) hideEndContent);
                spannableStringBuilder.setSpan(new c(), (spannableStringBuilder.length() - this.D.length()) - (TextUtils.isEmpty(this.F) ? 0 : this.F.length() + 2), spannableStringBuilder.length(), 17);
            } else {
                spannableStringBuilder.append(bVar.a());
                if (this.n) {
                    String expandEndContent = getExpandEndContent();
                    if (this.u) {
                        int lineCount = this.f2548f.getLineCount() - 1;
                        float lineWidth2 = this.f2548f.getLineWidth(lineCount);
                        float f3 = 0.0f;
                        for (int i9 = 0; i9 < lineCount; i9++) {
                            f3 += this.f2548f.getLineWidth(i9);
                        }
                        float measureText2 = ((f3 / lineCount) - lineWidth2) - this.b.measureText(expandEndContent);
                        if (measureText2 > 0.0f) {
                            int i10 = 0;
                            while (i10 * this.b.measureText(N) < measureText2) {
                                i10++;
                            }
                            int i11 = i10 - 1;
                            for (int i12 = 0; i12 < i11; i12++) {
                                spannableStringBuilder.append(N);
                            }
                        }
                    }
                    spannableStringBuilder.append((CharSequence) expandEndContent);
                    spannableStringBuilder.setSpan(new d(), (spannableStringBuilder.length() - this.E.length()) - (TextUtils.isEmpty(this.F) ? 0 : this.F.length() + 2), spannableStringBuilder.length(), 17);
                } else if (!TextUtils.isEmpty(this.F)) {
                    spannableStringBuilder.append(this.F);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.G), spannableStringBuilder.length() - this.F.length(), spannableStringBuilder.length(), 17);
                }
            }
        } else {
            spannableStringBuilder.append(bVar.a());
            if (!TextUtils.isEmpty(this.F)) {
                spannableStringBuilder.append(this.F);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.G), spannableStringBuilder.length() - this.F.length(), spannableStringBuilder.length(), 17);
            }
        }
        for (b.a aVar2 : bVar.b()) {
            if (spannableStringBuilder.length() >= aVar2.a()) {
                if (aVar2.getType().equals(LinkType.LINK_TYPE)) {
                    if (this.p && z) {
                        int length = spannableStringBuilder.length() - getHideEndContent().length();
                        if (aVar2.d() < length) {
                            spannableStringBuilder.setSpan(new m(this.f2552j, 1), aVar2.d(), aVar2.d() + 1, 18);
                            int a2 = aVar2.a();
                            if (this.f2550h < this.w && length > aVar2.d() + 1 && length < aVar2.a()) {
                                a2 = length;
                            }
                            if (aVar2.d() + 1 < length) {
                                E(spannableStringBuilder, aVar2, a2);
                            }
                        }
                    } else {
                        spannableStringBuilder.setSpan(new m(this.f2552j, 1), aVar2.d(), aVar2.d() + 1, 18);
                        E(spannableStringBuilder, aVar2, aVar2.a());
                    }
                } else if (aVar2.getType().equals(LinkType.MENTION_TYPE)) {
                    if (this.p && z) {
                        int length2 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (aVar2.d() < length2) {
                            int a3 = aVar2.a();
                            if (this.f2550h >= this.w || length2 >= aVar2.a()) {
                                length2 = a3;
                            }
                            C(spannableStringBuilder, aVar2, length2);
                        }
                    } else {
                        C(spannableStringBuilder, aVar2, aVar2.a());
                    }
                } else if (aVar2.getType().equals(LinkType.SELF)) {
                    if (this.p && z) {
                        int length3 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (aVar2.d() < length3) {
                            int a4 = aVar2.a();
                            if (this.f2550h >= this.w || length3 >= aVar2.a()) {
                                length3 = a4;
                            }
                            D(spannableStringBuilder, aVar2, length3);
                        }
                    } else {
                        D(spannableStringBuilder, aVar2, aVar2.a());
                    }
                }
            }
        }
        setHighlightColor(0);
        setText(spannableStringBuilder);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.x == null) {
            return;
        }
        this.f2550h = this.f2549g;
        if (this.f2551i <= 0 && getWidth() > 0) {
            this.f2551i = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        if (this.f2551i <= 0) {
            if (R > 10) {
                setText(Q);
            }
            post(new b());
            return;
        }
        U(this.x.toString());
    }

    @SuppressLint({"RestrictedApi"})
    private e.e.a.a.b I(CharSequence charSequence) {
        int i2;
        int i3;
        e.e.a.a.b bVar = new e.e.a.a.b();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(T, 2).matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        HashMap hashMap = new HashMap();
        if (this.t) {
            ArrayList arrayList2 = new ArrayList();
            i2 = 0;
            int i4 = 0;
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                stringBuffer.append(charSequence.toString().substring(i4, start));
                String group = matcher.group();
                if (!TextUtils.isEmpty(group)) {
                    String substring = group.substring(group.indexOf("[") + 1, group.indexOf("]"));
                    String substring2 = group.substring(group.indexOf("(") + 1, group.indexOf(")"));
                    String b2 = e.e.a.a.c.b(substring.length());
                    arrayList2.add(new b.a(stringBuffer.length() + 1, stringBuffer.length() + 2 + substring.length(), substring, substring2, LinkType.SELF));
                    hashMap.put(b2, substring);
                    stringBuffer.append(N + b2 + N);
                    i4 = end;
                }
                i2 = end;
            }
            arrayList.addAll(arrayList2);
        } else {
            i2 = 0;
        }
        stringBuffer.append(charSequence.toString().substring(i2, charSequence.toString().length()));
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        if (this.s) {
            Matcher matcher2 = PatternsCompat.AUTOLINK_WEB_URL.matcher(stringBuffer2);
            i3 = 0;
            int i5 = 0;
            while (matcher2.find()) {
                int start2 = matcher2.start();
                int end2 = matcher2.end();
                stringBuffer3.append(stringBuffer2.toString().substring(i5, start2));
                if (this.q) {
                    arrayList.add(new b.a(stringBuffer3.length() + 1, stringBuffer3.length() + 2 + this.a.length(), matcher2.group(), LinkType.LINK_TYPE));
                    stringBuffer3.append(N + this.a + N);
                } else {
                    String group2 = matcher2.group();
                    String b3 = e.e.a.a.c.b(group2.length());
                    arrayList.add(new b.a(stringBuffer3.length(), stringBuffer3.length() + 2 + b3.length(), group2, LinkType.LINK_TYPE));
                    hashMap.put(b3, group2);
                    stringBuffer3.append(N + b3 + N);
                }
                i3 = end2;
                i5 = i3;
            }
        } else {
            i3 = 0;
        }
        stringBuffer3.append(stringBuffer2.toString().substring(i3, stringBuffer2.toString().length()));
        if (this.r) {
            Matcher matcher3 = Pattern.compile(S, 2).matcher(stringBuffer3.toString());
            ArrayList arrayList3 = new ArrayList();
            while (matcher3.find()) {
                arrayList3.add(new b.a(matcher3.start(), matcher3.end(), matcher3.group(), LinkType.MENTION_TYPE));
            }
            arrayList.addAll(0, arrayList3);
        }
        if (!hashMap.isEmpty()) {
            String stringBuffer4 = stringBuffer3.toString();
            for (Map.Entry entry : hashMap.entrySet()) {
                stringBuffer4 = stringBuffer4.replaceAll((String) entry.getKey(), (String) entry.getValue());
            }
            stringBuffer3 = new StringBuffer(stringBuffer4);
        }
        bVar.c(stringBuffer3.toString());
        bVar.d(arrayList);
        return bVar;
    }

    private int J(String str, int i2, int i3, float f2, float f3, float f4) {
        int i4 = (int) (((f2 - (f3 + f4)) * (i2 - i3)) / f2);
        if (i4 <= str.length()) {
            return i2;
        }
        int i5 = i4 + i3;
        return this.b.measureText(this.o.a().substring(i3, i5)) <= f2 - f3 ? i5 : J(str, i2, i3, f2, f3, f4 + this.b.measureText(N));
    }

    private int K(float f2, float f3) {
        int i2 = 0;
        while ((i2 * this.b.measureText(N)) + f3 < f2) {
            i2++;
        }
        return i2 - 1;
    }

    private void L(Context context, AttributeSet attributeSet, int i2) {
        this.a = P + O;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView, i2, 0);
            this.f2549g = obtainStyledAttributes.getInt(7, 4);
            this.p = obtainStyledAttributes.getBoolean(13, true);
            this.n = obtainStyledAttributes.getBoolean(11, false);
            this.v = obtainStyledAttributes.getBoolean(10, true);
            this.t = obtainStyledAttributes.getBoolean(16, false);
            this.r = obtainStyledAttributes.getBoolean(15, true);
            this.s = obtainStyledAttributes.getBoolean(14, true);
            this.u = obtainStyledAttributes.getBoolean(9, false);
            this.q = obtainStyledAttributes.getBoolean(12, true);
            this.E = obtainStyledAttributes.getString(1);
            String string = obtainStyledAttributes.getString(4);
            this.D = string;
            if (TextUtils.isEmpty(string)) {
                this.D = M;
            }
            if (TextUtils.isEmpty(this.E)) {
                this.E = L;
            }
            this.y = obtainStyledAttributes.getColor(3, Res.k(R.color.black_99999a));
            this.G = obtainStyledAttributes.getColor(3, Res.k(R.color.black_99999a));
            this.C = obtainStyledAttributes.getColor(0, Res.k(R.color.black_99999a));
            this.A = obtainStyledAttributes.getColor(5, Color.parseColor("#FF6200"));
            this.B = obtainStyledAttributes.getColor(17, Color.parseColor("#FF6200"));
            this.z = obtainStyledAttributes.getColor(8, Color.parseColor("#FF6200"));
            this.f2552j = ResourcesCompat.getDrawable(getResources(), obtainStyledAttributes.getResourceId(6, R.drawable.ic_link), null);
            this.f2550h = this.f2549g;
            obtainStyledAttributes.recycle();
        } else {
            this.f2552j = Res.a.p(context, R.drawable.ic_link);
        }
        this.f2546d = context;
        TextPaint paint = getPaint();
        this.b = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f2552j.setBounds(0, 0, 30, 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder U(CharSequence charSequence) {
        this.o = I(charSequence);
        DynamicLayout dynamicLayout = new DynamicLayout(this.o.a(), this.b, this.f2551i, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        this.f2548f = dynamicLayout;
        int lineCount = dynamicLayout.getLineCount();
        this.w = lineCount;
        k kVar = this.J;
        if (kVar != null) {
            kVar.a(lineCount, lineCount > this.f2549g);
        }
        if (this.p && this.w > this.f2549g) {
            return G(this.o, true);
        }
        return G(this.o, false);
    }

    private String getExpandEndContent() {
        return TextUtils.isEmpty(this.F) ? String.format(Locale.getDefault(), "  %s", this.E) : String.format(Locale.getDefault(), "  %s  %s", this.F, this.E);
    }

    private String getHideEndContent() {
        if (TextUtils.isEmpty(this.F)) {
            return String.format(Locale.getDefault(), this.u ? "  %s" : "...  %s", this.D);
        }
        return String.format(Locale.getDefault(), this.u ? "  %s  %s" : "...  %s  %s", this.F, this.D);
    }

    public static /* synthetic */ int s() {
        int i2 = R;
        R = i2 + 1;
        return i2;
    }

    public void F(e.e.a.a.a aVar) {
        this.f2547e = aVar;
    }

    public boolean M() {
        return this.u;
    }

    public boolean N() {
        return this.v;
    }

    public boolean O() {
        return this.n;
    }

    public boolean P() {
        return this.p;
    }

    public boolean Q() {
        return this.s;
    }

    public boolean R() {
        return this.t;
    }

    public boolean S() {
        return this.r;
    }

    public void T(j jVar, boolean z) {
        this.f2555m = jVar;
        this.f2554l = z;
    }

    public String getContractString() {
        return this.E;
    }

    public int getContractTextColor() {
        return this.C;
    }

    public int getEndExpandTextColor() {
        return this.G;
    }

    public j getExpandOrContractClickListener() {
        return this.f2555m;
    }

    public String getExpandString() {
        return this.D;
    }

    public int getExpandTextColor() {
        return this.y;
    }

    public int getExpandableLineCount() {
        return this.w;
    }

    public int getExpandableLinkTextColor() {
        return this.A;
    }

    public l getLinkClickListener() {
        return this.f2553k;
    }

    public Drawable getLinkDrawable() {
        return this.f2552j;
    }

    public k getOnGetLineCountListener() {
        return this.J;
    }

    public int getSelfTextColor() {
        return this.B;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.f2545c = false;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.I) {
            return this.f2545c;
        }
        if (action == 1) {
            setTextIsSelectable(false);
        }
        return onTouchEvent;
    }

    public void setContent(String str) {
        this.x = str;
        if (this.H) {
            H();
        }
    }

    public void setContractString(String str) {
        this.E = str;
    }

    public void setContractTextColor(int i2) {
        this.C = i2;
    }

    public void setCurrStatus(StatusType statusType) {
        B(statusType);
    }

    public void setEndExpandTextColor(int i2) {
        this.G = i2;
    }

    public void setEndExpendContent(String str) {
        this.F = str;
    }

    public void setExpandOrContractClickListener(j jVar) {
        this.f2555m = jVar;
    }

    public void setExpandString(String str) {
        this.D = str;
    }

    public void setExpandTextColor(int i2) {
        this.y = i2;
    }

    public void setExpandableLineCount(int i2) {
        this.w = i2;
    }

    public void setExpandableLinkTextColor(int i2) {
        this.A = i2;
    }

    public void setLinkClickListener(l lVar) {
        this.f2553k = lVar;
    }

    public void setLinkDrawable(Drawable drawable) {
        this.f2552j = drawable;
    }

    public void setNeedAlwaysShowRight(boolean z) {
        this.u = z;
    }

    public void setNeedAnimation(boolean z) {
        this.v = z;
    }

    public void setNeedContract(boolean z) {
        this.n = z;
    }

    public void setNeedExpend(boolean z) {
        this.p = z;
    }

    public void setNeedLink(boolean z) {
        this.s = z;
    }

    public void setNeedMention(boolean z) {
        this.r = z;
    }

    public void setNeedSelf(boolean z) {
        this.t = z;
    }

    public void setOnGetLineCountListener(k kVar) {
        this.J = kVar;
    }

    public void setSelfTextColor(int i2) {
        this.B = i2;
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2552j = null;
        this.f2554l = true;
        this.n = true;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = false;
        this.u = false;
        this.v = true;
        this.I = true;
        L(context, attributeSet, i2);
        setMovementMethod(i.a());
        addOnAttachStateChangeListener(new a());
    }
}
