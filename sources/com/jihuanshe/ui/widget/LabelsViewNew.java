package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.jihuanshe.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class LabelsViewNew extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    private static final int E = 2131297709;
    private static final int F = 2131297710;
    private static final String G = "key_super_state";
    private static final String H = "key_text_color_state";
    private static final String I = "key_text_size_state";
    private static final String J = "key_bg_res_id_state";
    private static final String K = "key_padding_state";
    private static final String L = "key_word_margin_state";
    private static final String M = "key_line_margin_state";
    private static final String N = "key_select_type_state";
    private static final String O = "key_max_select_state";
    private static final String P = "key_min_select_state";
    private static final String Q = "key_max_lines_state";
    private static final String R = "key_max_columns_state";
    private static final String S = "key_indicator_state";
    private static final String T = "key_labels_state";
    private static final String U = "key_select_labels_state";
    private static final String V = "key_select_compulsory_state";
    private static final String W = "key_label_width_state";
    private static final String a0 = "key_label_height_state";
    private static final String b0 = "key_label_gravity_state";
    private static final String c0 = "key_single_line_state";
    private static final String d0 = "key_text_style_state";
    private c A;
    private d B;
    private e C;
    private f D;
    private Context a;
    private ColorStateList b;

    /* renamed from: c  reason: collision with root package name */
    private float f4131c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f4132d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f4133e;

    /* renamed from: f  reason: collision with root package name */
    private int f4134f;

    /* renamed from: g  reason: collision with root package name */
    private int f4135g;

    /* renamed from: h  reason: collision with root package name */
    private int f4136h;

    /* renamed from: i  reason: collision with root package name */
    private int f4137i;

    /* renamed from: j  reason: collision with root package name */
    private int f4138j;

    /* renamed from: k  reason: collision with root package name */
    private int f4139k;

    /* renamed from: l  reason: collision with root package name */
    private int f4140l;

    /* renamed from: m  reason: collision with root package name */
    private int f4141m;
    private int n;
    private SelectType o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private ArrayList<Object> w;
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private int z;

    /* loaded from: classes2.dex */
    public enum SelectType {
        NONE(1),
        SINGLE(2),
        SINGLE_IRREVOCABLY(3),
        MULTI(4);
        
        public int value;

        SelectType(int i2) {
            this.value = i2;
        }

        public static SelectType get(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return NONE;
                        }
                        return MULTI;
                    }
                    return SINGLE_IRREVOCABLY;
                }
                return SINGLE;
            }
            return NONE;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements b<String> {
        public a() {
        }

        @Override // com.jihuanshe.ui.widget.LabelsViewNew.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i2, String str) {
            return str.trim();
        }
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        CharSequence a(TextView textView, int i2, T t);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(TextView textView, Object obj, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d {
        boolean a(TextView textView, Object obj, int i2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(TextView textView, Object obj, boolean z, int i2);
    }

    /* loaded from: classes2.dex */
    public interface f {
        boolean a(TextView textView, Object obj, boolean z, boolean z2, int i2);
    }

    /* loaded from: classes2.dex */
    public interface g {
        boolean b();

        void c(boolean z);
    }

    public LabelsViewNew(Context context) {
        super(context);
        this.f4133e = Boolean.FALSE;
        this.f4134f = -2;
        this.f4135g = -2;
        this.f4136h = 17;
        this.t = false;
        this.u = false;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        this.a = context;
        t();
    }

    private <T> void a(T t, int i2, b<T> bVar) {
        TextView textView = new TextView(this.a);
        textView.setPadding(this.f4137i, this.f4138j, this.f4139k, this.f4140l);
        textView.setTextSize(0, this.f4131c);
        textView.setGravity(this.f4136h);
        textView.setTextColor(this.b);
        textView.setBackgroundDrawable(this.f4132d.getConstantState().newDrawable());
        textView.setTag(R.id.tag_key_data, t);
        textView.setTag(R.id.tag_key_position, Integer.valueOf(i2));
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
        textView.getPaint().setFakeBoldText(this.u);
        int i3 = this.f4134f;
        if (this.f4133e.booleanValue() && i2 == 0) {
            i3 = -1;
        }
        addView(textView, i3, this.f4135g);
        textView.setText(o(bVar.a(textView, i2, t), false));
    }

    private void d() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (!this.y.contains(Integer.valueOf(i2))) {
                q((TextView) getChildAt(i2), false);
                arrayList.add(Integer.valueOf(i2));
            }
        }
        this.x.removeAll(arrayList);
    }

    private int e(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private void f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setClickable((this.A == null && this.B == null && this.o == SelectType.NONE) ? false : true);
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelsView);
            this.o = SelectType.get(obtainStyledAttributes.getInt(18, 1));
            this.p = obtainStyledAttributes.getInteger(16, 0);
            this.q = obtainStyledAttributes.getInteger(17, 0);
            this.r = obtainStyledAttributes.getInteger(15, 0);
            this.s = obtainStyledAttributes.getInteger(14, 0);
            this.v = obtainStyledAttributes.getBoolean(0, false);
            this.f4136h = obtainStyledAttributes.getInt(3, this.f4136h);
            this.f4134f = obtainStyledAttributes.getLayoutDimension(12, this.f4134f);
            this.f4135g = obtainStyledAttributes.getLayoutDimension(5, this.f4135g);
            if (obtainStyledAttributes.hasValue(4)) {
                this.b = obtainStyledAttributes.getColorStateList(4);
            } else {
                this.b = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f4131c = obtainStyledAttributes.getDimension(11, u(14.0f));
            if (obtainStyledAttributes.hasValue(6)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
                this.f4140l = dimensionPixelOffset;
                this.f4139k = dimensionPixelOffset;
                this.f4138j = dimensionPixelOffset;
                this.f4137i = dimensionPixelOffset;
            } else {
                this.f4137i = obtainStyledAttributes.getDimensionPixelOffset(8, e(10.0f));
                this.f4138j = obtainStyledAttributes.getDimensionPixelOffset(10, e(5.0f));
                this.f4139k = obtainStyledAttributes.getDimensionPixelOffset(9, e(10.0f));
                this.f4140l = obtainStyledAttributes.getDimensionPixelOffset(7, e(5.0f));
            }
            this.n = obtainStyledAttributes.getDimensionPixelOffset(13, e(5.0f));
            this.f4141m = obtainStyledAttributes.getDimensionPixelOffset(20, e(5.0f));
            if (obtainStyledAttributes.hasValue(2)) {
                int resourceId = obtainStyledAttributes.getResourceId(2, 0);
                if (resourceId != 0) {
                    this.f4132d = getResources().getDrawable(resourceId);
                } else {
                    this.f4132d = new ColorDrawable(obtainStyledAttributes.getColor(2, 0));
                }
            } else {
                this.f4132d = getResources().getDrawable(R.drawable.default_label_bg);
            }
            this.t = obtainStyledAttributes.getBoolean(19, false);
            this.u = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            q((TextView) getChildAt(i2), false);
        }
        this.x.clear();
    }

    private void l(int i2, int i3) {
        int i4;
        int childCount = getChildCount();
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            measureChild(childAt, i2, i3);
            if (childAt.getMeasuredWidth() + i5 > size || ((i4 = this.s) > 0 && i6 == i4)) {
                i10++;
                int i12 = this.r;
                if (i12 > 0 && i10 > i12) {
                    i10--;
                    break;
                }
                i8 = i8 + this.n + i7;
                i9 = Math.max(i9, i5);
                i5 = 0;
                i6 = 0;
                i7 = 0;
            }
            i5 += childAt.getMeasuredWidth();
            i6++;
            i7 = Math.max(i7, childAt.getMeasuredHeight());
            if (i11 != childCount - 1) {
                int i13 = this.f4141m;
                if (i5 + i13 > size) {
                    i10++;
                    int i14 = this.r;
                    if (i14 > 0 && i10 > i14) {
                        i10--;
                        break;
                    }
                    i8 = i8 + this.n + i7;
                    i9 = Math.max(i9, i5);
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                } else {
                    i5 += i13;
                }
            }
        }
        setMeasuredDimension(n(i2, Math.max(i9, i5) + getPaddingLeft() + getPaddingRight()), n(i3, i8 + i7 + getPaddingTop() + getPaddingBottom()));
        this.z = childCount > 0 ? i10 : 0;
    }

    private void m(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int i7 = this.s;
            if (i7 > 0 && i6 == i7) {
                break;
            }
            View childAt = getChildAt(i6);
            measureChild(childAt, i2, i3);
            i4 += childAt.getMeasuredWidth();
            if (i6 != childCount - 1) {
                i4 += this.f4141m;
            }
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(n(i2, i4 + getPaddingLeft() + getPaddingRight()), n(i3, i5 + getPaddingTop() + getPaddingBottom()));
        this.z = childCount > 0 ? 1 : 0;
    }

    private int n(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            i3 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(i3, size);
        }
        return ViewGroup.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i2, 0);
    }

    private SpannableString o(CharSequence charSequence, boolean z) {
        SpannableString spannableString = new SpannableString(charSequence);
        String spannableString2 = spannableString.toString();
        if (spannableString2.contains("\n")) {
            int indexOf = spannableString2.indexOf("\n");
            spannableString.setSpan(new RelativeSizeSpan(0.83f), indexOf, spannableString.length(), 33);
            if (z) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), indexOf, spannableString.length(), 33);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#99999a")), indexOf, spannableString.length(), 33);
            }
        }
        return spannableString;
    }

    private boolean p(TextView textView) {
        f fVar = this.D;
        return fVar != null && fVar.a(textView, textView.getTag(R.id.tag_key_data), textView.isSelected(), textView.isSelected() ^ true, ((Integer) textView.getTag(R.id.tag_key_position)).intValue());
    }

    private void q(TextView textView, boolean z) {
        if (textView.isSelected() != z) {
            textView.setSelected(z);
            CharSequence charSequence = (CharSequence) textView.getTag(R.id.tag_key_data);
            if (z) {
                textView.setText(o(charSequence, true));
                this.x.add((Integer) textView.getTag(R.id.tag_key_position));
            } else {
                textView.setText(o(charSequence, false));
                this.x.remove((Integer) textView.getTag(R.id.tag_key_position));
            }
            e eVar = this.C;
            if (eVar != null) {
                eVar.a(textView, textView.getTag(R.id.tag_key_data), z, ((Integer) textView.getTag(R.id.tag_key_position)).intValue());
            }
        }
    }

    private void t() {
        if (isInEditMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Label 1");
            arrayList.add("Label 2");
            arrayList.add("Label 3");
            arrayList.add("Label 4");
            arrayList.add("Label 5");
            arrayList.add("Label 6");
            arrayList.add("Label 7");
            setLabels(arrayList);
        }
    }

    private int u(float f2) {
        return (int) TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }

    public void b() {
        SelectType selectType = this.o;
        if (selectType != SelectType.SINGLE_IRREVOCABLY) {
            if (selectType == SelectType.MULTI && !this.y.isEmpty()) {
                d();
            } else {
                h();
            }
        }
    }

    public void c() {
        if (this.o != SelectType.MULTI || this.y.isEmpty()) {
            return;
        }
        this.y.clear();
        h();
    }

    public List<Integer> getCompulsorys() {
        return this.y;
    }

    public int getLabelGravity() {
        return this.f4136h;
    }

    public ColorStateList getLabelTextColor() {
        return this.b;
    }

    public float getLabelTextSize() {
        return this.f4131c;
    }

    public <T> List<T> getLabels() {
        return this.w;
    }

    public int getLineMargin() {
        return this.n;
    }

    public int getLines() {
        return this.z;
    }

    public int getMaxColumns() {
        return this.s;
    }

    public int getMaxLines() {
        return this.r;
    }

    public int getMaxSelect() {
        return this.p;
    }

    public int getMinSelect() {
        return this.q;
    }

    public <T> List<T> getSelectLabelDatas() {
        ArrayList arrayList = new ArrayList();
        int size = this.x.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object tag = getChildAt(this.x.get(i2).intValue()).getTag(R.id.tag_key_data);
            if (tag != null) {
                arrayList.add(tag);
            }
        }
        return arrayList;
    }

    public List<Integer> getSelectLabels() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.x);
        return arrayList;
    }

    public SelectType getSelectType() {
        return this.o;
    }

    public int getTextPaddingBottom() {
        return this.f4140l;
    }

    public int getTextPaddingLeft() {
        return this.f4137i;
    }

    public int getTextPaddingRight() {
        return this.f4139k;
    }

    public int getTextPaddingTop() {
        return this.f4138j;
    }

    public int getWordMargin() {
        return this.f4141m;
    }

    public boolean i() {
        return this.v;
    }

    public boolean j() {
        return this.t;
    }

    public boolean k() {
        return this.u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.v && this.o != SelectType.NONE) {
                boolean z = true;
                if (textView.isSelected()) {
                    SelectType selectType = this.o;
                    SelectType selectType2 = SelectType.MULTI;
                    if (!((selectType == selectType2 && this.y.contains((Integer) textView.getTag(R.id.tag_key_position))) || (this.o == selectType2 && this.x.size() <= this.q)) && this.o != SelectType.SINGLE_IRREVOCABLY) {
                        z = false;
                    }
                    if (!z && !p(textView)) {
                        q(textView, false);
                    }
                } else {
                    SelectType selectType3 = this.o;
                    if (selectType3 != SelectType.SINGLE && selectType3 != SelectType.SINGLE_IRREVOCABLY) {
                        if (selectType3 == SelectType.MULTI && (((i2 = this.p) <= 0 || i2 > this.x.size()) && !p(textView))) {
                            q(textView, true);
                        }
                    } else if (!p(textView)) {
                        h();
                        q(textView, true);
                    }
                }
            }
            c cVar = this.A;
            if (cVar != null) {
                cVar.a(textView, textView.getTag(R.id.tag_key_data), ((Integer) textView.getTag(R.id.tag_key_position)).intValue());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i8 = i4 - i2;
        int childCount = getChildCount();
        int i9 = 1;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (!this.t && (i8 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight() || ((i7 = this.s) > 0 && i10 == i7))) {
                i9++;
                int i13 = this.r;
                if (i13 > 0 && i9 > i13) {
                    return;
                }
                paddingLeft = getPaddingLeft();
                paddingTop = paddingTop + this.n + i11;
                i10 = 0;
                i11 = 0;
            }
            if (this.t && (i6 = this.s) > 0 && i10 == i6) {
                return;
            }
            childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.f4141m;
            i11 = Math.max(i11, childAt.getMeasuredHeight());
            i10++;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            d dVar = this.B;
            if (dVar != null) {
                return dVar.a(textView, textView.getTag(R.id.tag_key_data), ((Integer) textView.getTag(R.id.tag_key_position)).intValue());
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.t) {
            m(i2, i3);
        } else {
            l(i2, i3);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(G));
            ColorStateList colorStateList = (ColorStateList) bundle.getParcelable(H);
            if (colorStateList != null) {
                setLabelTextColor(colorStateList);
            }
            setLabelTextSize(bundle.getFloat(I, this.f4131c));
            this.f4134f = bundle.getInt(W, this.f4134f);
            this.f4135g = bundle.getInt(a0, this.f4135g);
            setLabelGravity(bundle.getInt(b0, this.f4136h));
            int[] intArray = bundle.getIntArray(K);
            if (intArray != null && intArray.length == 4) {
                r(intArray[0], intArray[1], intArray[2], intArray[3]);
            }
            setWordMargin(bundle.getInt(L, this.f4141m));
            setLineMargin(bundle.getInt(M, this.n));
            setSelectType(SelectType.get(bundle.getInt(N, this.o.value)));
            setMaxSelect(bundle.getInt(O, this.p));
            setMinSelect(bundle.getInt(P, this.q));
            setMaxLines(bundle.getInt(Q, this.r));
            setMaxLines(bundle.getInt(R, this.s));
            setIndicator(bundle.getBoolean(S, this.v));
            setSingleLine(bundle.getBoolean(c0, this.t));
            setTextBold(bundle.getBoolean(d0, this.u));
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(V);
            if (integerArrayList != null && !integerArrayList.isEmpty()) {
                setCompulsorys(integerArrayList);
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList(U);
            if (integerArrayList2 == null || integerArrayList2.isEmpty()) {
                return;
            }
            int size = integerArrayList2.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = integerArrayList2.get(i2).intValue();
            }
            setSelects(iArr);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(G, super.onSaveInstanceState());
        ColorStateList colorStateList = this.b;
        if (colorStateList != null) {
            bundle.putParcelable(H, colorStateList);
        }
        bundle.putFloat(I, this.f4131c);
        bundle.putInt(W, this.f4134f);
        bundle.putInt(a0, this.f4135g);
        bundle.putInt(b0, this.f4136h);
        bundle.putIntArray(K, new int[]{this.f4137i, this.f4138j, this.f4139k, this.f4140l});
        bundle.putInt(L, this.f4141m);
        bundle.putInt(M, this.n);
        bundle.putInt(N, this.o.value);
        bundle.putInt(O, this.p);
        bundle.putInt(P, this.q);
        bundle.putInt(Q, this.r);
        bundle.putInt(R, this.s);
        bundle.putBoolean(S, this.v);
        if (!this.x.isEmpty()) {
            bundle.putIntegerArrayList(U, this.x);
        }
        if (!this.y.isEmpty()) {
            bundle.putIntegerArrayList(V, this.y);
        }
        bundle.putBoolean(c0, this.t);
        bundle.putBoolean(d0, this.u);
        return bundle;
    }

    public void r(int i2, int i3, int i4, int i5) {
        if (this.f4137i == i2 && this.f4138j == i3 && this.f4139k == i4 && this.f4140l == i5) {
            return;
        }
        this.f4137i = i2;
        this.f4138j = i3;
        this.f4139k = i4;
        this.f4140l = i5;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ((TextView) getChildAt(i6)).setPadding(i2, i3, i4, i5);
        }
    }

    public <T> void s(List<T> list, b<T> bVar) {
        h();
        removeAllViews();
        this.w.clear();
        if (list != null) {
            this.w.addAll(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a(list.get(i2), i2, bVar);
            }
            f();
        }
        if (this.o == SelectType.SINGLE_IRREVOCABLY) {
            setSelects(0);
        }
    }

    public void setCompulsorys(List<Integer> list) {
        if (this.o != SelectType.MULTI || list == null) {
            return;
        }
        this.y.clear();
        this.y.addAll(list);
        h();
        setSelects(list);
    }

    public void setFirstMatch(Boolean bool) {
        this.f4133e = bool;
    }

    public void setIndicator(boolean z) {
        this.v = z;
    }

    public void setLabelBackgroundColor(int i2) {
        setLabelBackgroundDrawable(new ColorDrawable(i2));
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        this.f4132d = drawable;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setBackgroundDrawable(this.f4132d.getConstantState().newDrawable());
        }
    }

    public void setLabelBackgroundResource(int i2) {
        setLabelBackgroundDrawable(getResources().getDrawable(i2));
    }

    public void setLabelGravity(int i2) {
        if (this.f4136h != i2) {
            this.f4136h = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ((TextView) getChildAt(i3)).setGravity(i2);
            }
        }
    }

    public void setLabelTextColor(int i2) {
        setLabelTextColor(ColorStateList.valueOf(i2));
    }

    public void setLabelTextSize(float f2) {
        if (this.f4131c != f2) {
            this.f4131c = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setTextSize(0, f2);
            }
        }
    }

    public void setLabels(List<String> list) {
        s(list, new a());
    }

    public void setLineMargin(int i2) {
        if (this.n != i2) {
            this.n = i2;
            requestLayout();
        }
    }

    public void setMaxColumns(int i2) {
        if (this.s != i2) {
            this.s = i2;
            requestLayout();
        }
    }

    public void setMaxLines(int i2) {
        if (this.r != i2) {
            this.r = i2;
            requestLayout();
        }
    }

    public void setMaxSelect(int i2) {
        if (this.p != i2) {
            this.p = i2;
            if (this.o == SelectType.MULTI) {
                h();
            }
        }
    }

    public void setMinSelect(int i2) {
        this.q = i2;
    }

    public void setOnLabelClickListener(c cVar) {
        this.A = cVar;
        f();
    }

    public void setOnLabelLongClickListener(d dVar) {
        this.B = dVar;
        f();
    }

    public void setOnLabelSelectChangeListener(e eVar) {
        this.C = eVar;
    }

    public void setOnSelectChangeIntercept(f fVar) {
        this.D = fVar;
    }

    public void setSelectType(SelectType selectType) {
        if (this.o != selectType) {
            this.o = selectType;
            h();
            if (this.o == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
            if (this.o != SelectType.MULTI) {
                this.y.clear();
            }
            f();
        }
    }

    public void setSelects(List<Integer> list) {
        if (list != null) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = list.get(i2).intValue();
            }
            setSelects(iArr);
        }
    }

    public void setSingleLine(boolean z) {
        if (this.t != z) {
            this.t = z;
            requestLayout();
        }
    }

    public void setTextBold(boolean z) {
        if (this.u != z) {
            this.u = z;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) getChildAt(i2);
                textView.getPaint().setFakeBoldText(this.u);
                textView.invalidate();
            }
        }
    }

    public void setWordMargin(int i2) {
        if (this.f4141m != i2) {
            this.f4141m = i2;
            requestLayout();
        }
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        this.b = colorStateList;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setTextColor(this.b);
        }
    }

    public void setSelects(int... iArr) {
        if (this.o != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            SelectType selectType = this.o;
            int i2 = (selectType == SelectType.SINGLE || selectType == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.p;
            for (int i3 : iArr) {
                if (i3 < childCount) {
                    TextView textView = (TextView) getChildAt(i3);
                    if (!arrayList.contains(textView)) {
                        q(textView, true);
                        arrayList.add(textView);
                    }
                    if (i2 > 0 && arrayList.size() == i2) {
                        break;
                    }
                }
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                TextView textView2 = (TextView) getChildAt(i4);
                if (!arrayList.contains(textView2)) {
                    q(textView2, false);
                }
            }
        }
    }

    public void setCompulsorys(int... iArr) {
        if (this.o != SelectType.MULTI || iArr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        setCompulsorys(arrayList);
    }

    public LabelsViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4133e = Boolean.FALSE;
        this.f4134f = -2;
        this.f4135g = -2;
        this.f4136h = 17;
        this.t = false;
        this.u = false;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        this.a = context;
        g(context, attributeSet);
        t();
    }

    public LabelsViewNew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4133e = Boolean.FALSE;
        this.f4134f = -2;
        this.f4135g = -2;
        this.f4136h = 17;
        this.t = false;
        this.u = false;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        this.a = context;
        g(context, attributeSet);
        t();
    }
}
