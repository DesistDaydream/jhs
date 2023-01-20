package com.donkingliang.labels;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LabelsView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    private static final int D = R.id.tag_key_data;
    private static final int E = R.id.tag_key_position;
    private static final String F = "key_super_state";
    private static final String G = "key_text_color_state";
    private static final String H = "key_text_size_state";
    private static final String I = "key_bg_res_id_state";
    private static final String J = "key_padding_state";
    private static final String K = "key_word_margin_state";
    private static final String L = "key_line_margin_state";
    private static final String M = "key_select_type_state";
    private static final String N = "key_max_select_state";
    private static final String O = "key_min_select_state";
    private static final String P = "key_max_lines_state";
    private static final String Q = "key_max_columns_state";
    private static final String R = "key_indicator_state";
    private static final String S = "key_labels_state";
    private static final String T = "key_select_labels_state";
    private static final String U = "key_select_compulsory_state";
    private static final String V = "key_label_width_state";
    private static final String W = "key_label_height_state";
    private static final String a0 = "key_label_gravity_state";
    private static final String b0 = "key_single_line_state";
    private static final String c0 = "key_text_style_state";
    private d A;
    private e B;
    private f C;
    private Context a;
    private ColorStateList b;

    /* renamed from: c  reason: collision with root package name */
    private float f2556c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f2557d;

    /* renamed from: e  reason: collision with root package name */
    private int f2558e;

    /* renamed from: f  reason: collision with root package name */
    private int f2559f;

    /* renamed from: g  reason: collision with root package name */
    private int f2560g;

    /* renamed from: h  reason: collision with root package name */
    private int f2561h;

    /* renamed from: i  reason: collision with root package name */
    private int f2562i;

    /* renamed from: j  reason: collision with root package name */
    private int f2563j;

    /* renamed from: k  reason: collision with root package name */
    private int f2564k;

    /* renamed from: l  reason: collision with root package name */
    private int f2565l;

    /* renamed from: m  reason: collision with root package name */
    private int f2566m;
    private SelectType n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ArrayList<Object> v;
    private ArrayList<Integer> w;
    private ArrayList<Integer> x;
    private int y;
    private c z;

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public class a implements b<String> {
        public a() {
        }

        @Override // com.donkingliang.labels.LabelsView.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i2, String str) {
            return str.trim();
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        CharSequence a(TextView textView, int i2, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(TextView textView, Object obj, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(TextView textView, Object obj, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(TextView textView, Object obj, boolean z, int i2);
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean a(TextView textView, Object obj, boolean z, boolean z2, int i2);
    }

    /* loaded from: classes.dex */
    public interface g {
        boolean b();

        void c(boolean z);
    }

    public LabelsView(Context context) {
        super(context);
        this.f2558e = -2;
        this.f2559f = -2;
        this.f2560g = 17;
        this.s = false;
        this.t = false;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.a = context;
        s();
    }

    private <T> void a(T t, int i2, b<T> bVar) {
        TextView textView = new TextView(this.a);
        textView.setPadding(this.f2561h, this.f2562i, this.f2563j, this.f2564k);
        textView.setTextSize(0, this.f2556c);
        textView.setGravity(this.f2560g);
        textView.setTextColor(this.b);
        textView.setBackgroundDrawable(this.f2557d.getConstantState().newDrawable());
        textView.setTag(D, t);
        textView.setTag(E, Integer.valueOf(i2));
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
        textView.getPaint().setFakeBoldText(this.t);
        addView(textView, this.f2558e, this.f2559f);
        textView.setText(bVar.a(textView, i2, t));
    }

    private void d() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (!this.x.contains(Integer.valueOf(i2))) {
                p((TextView) getChildAt(i2), false);
                arrayList.add(Integer.valueOf(i2));
            }
        }
        this.w.removeAll(arrayList);
    }

    private int e(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private void f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setClickable((this.z == null && this.A == null && this.n == SelectType.NONE) ? false : true);
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelsView);
            this.n = SelectType.get(obtainStyledAttributes.getInt(R.styleable.LabelsView_selectType, 1));
            this.o = obtainStyledAttributes.getInteger(R.styleable.LabelsView_maxSelect, 0);
            this.p = obtainStyledAttributes.getInteger(R.styleable.LabelsView_minSelect, 0);
            this.q = obtainStyledAttributes.getInteger(R.styleable.LabelsView_maxLines, 0);
            this.r = obtainStyledAttributes.getInteger(R.styleable.LabelsView_maxColumns, 0);
            this.u = obtainStyledAttributes.getBoolean(R.styleable.LabelsView_isIndicator, false);
            this.f2560g = obtainStyledAttributes.getInt(R.styleable.LabelsView_labelGravity, this.f2560g);
            this.f2558e = obtainStyledAttributes.getLayoutDimension(R.styleable.LabelsView_labelTextWidth, this.f2558e);
            this.f2559f = obtainStyledAttributes.getLayoutDimension(R.styleable.LabelsView_labelTextHeight, this.f2559f);
            int i2 = R.styleable.LabelsView_labelTextColor;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.b = obtainStyledAttributes.getColorStateList(i2);
            } else {
                this.b = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f2556c = obtainStyledAttributes.getDimension(R.styleable.LabelsView_labelTextSize, t(14.0f));
            int i3 = R.styleable.LabelsView_labelTextPadding;
            if (obtainStyledAttributes.hasValue(i3)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i3, 0);
                this.f2564k = dimensionPixelOffset;
                this.f2563j = dimensionPixelOffset;
                this.f2562i = dimensionPixelOffset;
                this.f2561h = dimensionPixelOffset;
            } else {
                this.f2561h = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingLeft, e(10.0f));
                this.f2562i = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingTop, e(5.0f));
                this.f2563j = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingRight, e(10.0f));
                this.f2564k = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_labelTextPaddingBottom, e(5.0f));
            }
            this.f2566m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_lineMargin, e(5.0f));
            this.f2565l = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelsView_wordMargin, e(5.0f));
            int i4 = R.styleable.LabelsView_labelBackground;
            if (obtainStyledAttributes.hasValue(i4)) {
                int resourceId = obtainStyledAttributes.getResourceId(i4, 0);
                if (resourceId != 0) {
                    this.f2557d = getResources().getDrawable(resourceId);
                } else {
                    this.f2557d = new ColorDrawable(obtainStyledAttributes.getColor(i4, 0));
                }
            } else {
                this.f2557d = getResources().getDrawable(R.drawable.default_label_bg);
            }
            this.s = obtainStyledAttributes.getBoolean(R.styleable.LabelsView_singleLine, false);
            this.t = obtainStyledAttributes.getBoolean(R.styleable.LabelsView_isTextBold, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            p((TextView) getChildAt(i2), false);
        }
        this.w.clear();
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
            if (childAt.getMeasuredWidth() + i5 > size || ((i4 = this.r) > 0 && i6 == i4)) {
                i10++;
                int i12 = this.q;
                if (i12 > 0 && i10 > i12) {
                    i10--;
                    break;
                }
                i8 = i8 + this.f2566m + i7;
                i9 = Math.max(i9, i5);
                i5 = 0;
                i6 = 0;
                i7 = 0;
            }
            i5 += childAt.getMeasuredWidth();
            i6++;
            i7 = Math.max(i7, childAt.getMeasuredHeight());
            if (i11 != childCount - 1) {
                int i13 = this.f2565l;
                if (i5 + i13 > size) {
                    i10++;
                    int i14 = this.q;
                    if (i14 > 0 && i10 > i14) {
                        i10--;
                        break;
                    }
                    i8 = i8 + this.f2566m + i7;
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
        this.y = childCount > 0 ? i10 : 0;
    }

    private void m(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int i7 = this.r;
            if (i7 > 0 && i6 == i7) {
                break;
            }
            View childAt = getChildAt(i6);
            measureChild(childAt, i2, i3);
            i4 += childAt.getMeasuredWidth();
            if (i6 != childCount - 1) {
                i4 += this.f2565l;
            }
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(n(i2, i4 + getPaddingLeft() + getPaddingRight()), n(i3, i5 + getPaddingTop() + getPaddingBottom()));
        this.y = childCount > 0 ? 1 : 0;
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

    private boolean o(TextView textView) {
        f fVar = this.C;
        return fVar != null && fVar.a(textView, textView.getTag(D), textView.isSelected(), textView.isSelected() ^ true, ((Integer) textView.getTag(E)).intValue());
    }

    private void p(TextView textView, boolean z) {
        if (textView.isSelected() != z) {
            textView.setSelected(z);
            if (z) {
                this.w.add((Integer) textView.getTag(E));
            } else {
                this.w.remove((Integer) textView.getTag(E));
            }
            e eVar = this.B;
            if (eVar != null) {
                eVar.a(textView, textView.getTag(D), z, ((Integer) textView.getTag(E)).intValue());
            }
        }
    }

    private void s() {
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

    private int t(float f2) {
        return (int) TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }

    public void b() {
        SelectType selectType = this.n;
        if (selectType != SelectType.SINGLE_IRREVOCABLY) {
            if (selectType == SelectType.MULTI && !this.x.isEmpty()) {
                d();
            } else {
                h();
            }
        }
    }

    public void c() {
        if (this.n != SelectType.MULTI || this.x.isEmpty()) {
            return;
        }
        this.x.clear();
        h();
    }

    public List<Integer> getCompulsorys() {
        return this.x;
    }

    public int getLabelGravity() {
        return this.f2560g;
    }

    public ColorStateList getLabelTextColor() {
        return this.b;
    }

    public float getLabelTextSize() {
        return this.f2556c;
    }

    public <T> List<T> getLabels() {
        return this.v;
    }

    public int getLineMargin() {
        return this.f2566m;
    }

    public int getLines() {
        return this.y;
    }

    public int getMaxColumns() {
        return this.r;
    }

    public int getMaxLines() {
        return this.q;
    }

    public int getMaxSelect() {
        return this.o;
    }

    public int getMinSelect() {
        return this.p;
    }

    public <T> List<T> getSelectLabelDatas() {
        ArrayList arrayList = new ArrayList();
        int size = this.w.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object tag = getChildAt(this.w.get(i2).intValue()).getTag(D);
            if (tag != null) {
                arrayList.add(tag);
            }
        }
        return arrayList;
    }

    public List<Integer> getSelectLabels() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.w);
        return arrayList;
    }

    public SelectType getSelectType() {
        return this.n;
    }

    public int getTextPaddingBottom() {
        return this.f2564k;
    }

    public int getTextPaddingLeft() {
        return this.f2561h;
    }

    public int getTextPaddingRight() {
        return this.f2563j;
    }

    public int getTextPaddingTop() {
        return this.f2562i;
    }

    public int getWordMargin() {
        return this.f2565l;
    }

    public boolean i() {
        return this.u;
    }

    public boolean j() {
        return this.s;
    }

    public boolean k() {
        return this.t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.u && this.n != SelectType.NONE) {
                boolean z = true;
                if (textView.isSelected()) {
                    SelectType selectType = this.n;
                    SelectType selectType2 = SelectType.MULTI;
                    if (!((selectType == selectType2 && this.x.contains((Integer) textView.getTag(E))) || (this.n == selectType2 && this.w.size() <= this.p)) && this.n != SelectType.SINGLE_IRREVOCABLY) {
                        z = false;
                    }
                    if (!z && !o(textView)) {
                        p(textView, false);
                    }
                } else {
                    SelectType selectType3 = this.n;
                    if (selectType3 != SelectType.SINGLE && selectType3 != SelectType.SINGLE_IRREVOCABLY) {
                        if (selectType3 == SelectType.MULTI && (((i2 = this.o) <= 0 || i2 > this.w.size()) && !o(textView))) {
                            p(textView, true);
                        }
                    } else if (!o(textView)) {
                        h();
                        p(textView, true);
                    }
                }
            }
            c cVar = this.z;
            if (cVar != null) {
                cVar.a(textView, textView.getTag(D), ((Integer) textView.getTag(E)).intValue());
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
            if (!this.s && (i8 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight() || ((i7 = this.r) > 0 && i10 == i7))) {
                i9++;
                int i13 = this.q;
                if (i13 > 0 && i9 > i13) {
                    return;
                }
                paddingLeft = getPaddingLeft();
                paddingTop = paddingTop + this.f2566m + i11;
                i10 = 0;
                i11 = 0;
            }
            if (this.s && (i6 = this.r) > 0 && i10 == i6) {
                return;
            }
            childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.f2565l;
            i11 = Math.max(i11, childAt.getMeasuredHeight());
            i10++;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            d dVar = this.A;
            if (dVar != null) {
                return dVar.a(textView, textView.getTag(D), ((Integer) textView.getTag(E)).intValue());
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.s) {
            m(i2, i3);
        } else {
            l(i2, i3);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(F));
            ColorStateList colorStateList = (ColorStateList) bundle.getParcelable(G);
            if (colorStateList != null) {
                setLabelTextColor(colorStateList);
            }
            setLabelTextSize(bundle.getFloat(H, this.f2556c));
            this.f2558e = bundle.getInt(V, this.f2558e);
            this.f2559f = bundle.getInt(W, this.f2559f);
            setLabelGravity(bundle.getInt(a0, this.f2560g));
            int[] intArray = bundle.getIntArray(J);
            if (intArray != null && intArray.length == 4) {
                q(intArray[0], intArray[1], intArray[2], intArray[3]);
            }
            setWordMargin(bundle.getInt(K, this.f2565l));
            setLineMargin(bundle.getInt(L, this.f2566m));
            setSelectType(SelectType.get(bundle.getInt(M, this.n.value)));
            setMaxSelect(bundle.getInt(N, this.o));
            setMinSelect(bundle.getInt(O, this.p));
            setMaxLines(bundle.getInt(P, this.q));
            setMaxLines(bundle.getInt(Q, this.r));
            setIndicator(bundle.getBoolean(R, this.u));
            setSingleLine(bundle.getBoolean(b0, this.s));
            setTextBold(bundle.getBoolean(c0, this.t));
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(U);
            if (integerArrayList != null && !integerArrayList.isEmpty()) {
                setCompulsorys(integerArrayList);
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList(T);
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
        bundle.putParcelable(F, super.onSaveInstanceState());
        ColorStateList colorStateList = this.b;
        if (colorStateList != null) {
            bundle.putParcelable(G, colorStateList);
        }
        bundle.putFloat(H, this.f2556c);
        bundle.putInt(V, this.f2558e);
        bundle.putInt(W, this.f2559f);
        bundle.putInt(a0, this.f2560g);
        bundle.putIntArray(J, new int[]{this.f2561h, this.f2562i, this.f2563j, this.f2564k});
        bundle.putInt(K, this.f2565l);
        bundle.putInt(L, this.f2566m);
        bundle.putInt(M, this.n.value);
        bundle.putInt(N, this.o);
        bundle.putInt(O, this.p);
        bundle.putInt(P, this.q);
        bundle.putInt(Q, this.r);
        bundle.putBoolean(R, this.u);
        if (!this.w.isEmpty()) {
            bundle.putIntegerArrayList(T, this.w);
        }
        if (!this.x.isEmpty()) {
            bundle.putIntegerArrayList(U, this.x);
        }
        bundle.putBoolean(b0, this.s);
        bundle.putBoolean(c0, this.t);
        return bundle;
    }

    public void q(int i2, int i3, int i4, int i5) {
        if (this.f2561h == i2 && this.f2562i == i3 && this.f2563j == i4 && this.f2564k == i5) {
            return;
        }
        this.f2561h = i2;
        this.f2562i = i3;
        this.f2563j = i4;
        this.f2564k = i5;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ((TextView) getChildAt(i6)).setPadding(i2, i3, i4, i5);
        }
    }

    public <T> void r(List<T> list, b<T> bVar) {
        h();
        removeAllViews();
        this.v.clear();
        if (list != null) {
            this.v.addAll(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a(list.get(i2), i2, bVar);
            }
            f();
        }
        if (this.n == SelectType.SINGLE_IRREVOCABLY) {
            setSelects(0);
        }
    }

    public void setCompulsorys(List<Integer> list) {
        if (this.n != SelectType.MULTI || list == null) {
            return;
        }
        this.x.clear();
        this.x.addAll(list);
        h();
        setSelects(list);
    }

    public void setIndicator(boolean z) {
        this.u = z;
    }

    public void setLabelBackgroundColor(int i2) {
        setLabelBackgroundDrawable(new ColorDrawable(i2));
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        this.f2557d = drawable;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setBackgroundDrawable(this.f2557d.getConstantState().newDrawable());
        }
    }

    public void setLabelBackgroundResource(int i2) {
        setLabelBackgroundDrawable(getResources().getDrawable(i2));
    }

    public void setLabelGravity(int i2) {
        if (this.f2560g != i2) {
            this.f2560g = i2;
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
        if (this.f2556c != f2) {
            this.f2556c = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setTextSize(0, f2);
            }
        }
    }

    public void setLabels(List<String> list) {
        r(list, new a());
    }

    public void setLineMargin(int i2) {
        if (this.f2566m != i2) {
            this.f2566m = i2;
            requestLayout();
        }
    }

    public void setMaxColumns(int i2) {
        if (this.r != i2) {
            this.r = i2;
            requestLayout();
        }
    }

    public void setMaxLines(int i2) {
        if (this.q != i2) {
            this.q = i2;
            requestLayout();
        }
    }

    public void setMaxSelect(int i2) {
        if (this.o != i2) {
            this.o = i2;
            if (this.n == SelectType.MULTI) {
                h();
            }
        }
    }

    public void setMinSelect(int i2) {
        this.p = i2;
    }

    public void setOnLabelClickListener(c cVar) {
        this.z = cVar;
        f();
    }

    public void setOnLabelLongClickListener(d dVar) {
        this.A = dVar;
        f();
    }

    public void setOnLabelSelectChangeListener(e eVar) {
        this.B = eVar;
    }

    public void setOnSelectChangeIntercept(f fVar) {
        this.C = fVar;
    }

    public void setSelectType(SelectType selectType) {
        if (this.n != selectType) {
            this.n = selectType;
            h();
            if (this.n == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
            if (this.n != SelectType.MULTI) {
                this.x.clear();
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
        if (this.s != z) {
            this.s = z;
            requestLayout();
        }
    }

    public void setTextBold(boolean z) {
        if (this.t != z) {
            this.t = z;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                TextView textView = (TextView) getChildAt(i2);
                textView.getPaint().setFakeBoldText(this.t);
                textView.invalidate();
            }
        }
    }

    public void setWordMargin(int i2) {
        if (this.f2565l != i2) {
            this.f2565l = i2;
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
        if (this.n != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            SelectType selectType = this.n;
            int i2 = (selectType == SelectType.SINGLE || selectType == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.o;
            for (int i3 : iArr) {
                if (i3 < childCount) {
                    TextView textView = (TextView) getChildAt(i3);
                    if (!arrayList.contains(textView)) {
                        p(textView, true);
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
                    p(textView2, false);
                }
            }
        }
    }

    public void setCompulsorys(int... iArr) {
        if (this.n != SelectType.MULTI || iArr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        setCompulsorys(arrayList);
    }

    public LabelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2558e = -2;
        this.f2559f = -2;
        this.f2560g = 17;
        this.s = false;
        this.t = false;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.a = context;
        g(context, attributeSet);
        s();
    }

    public LabelsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2558e = -2;
        this.f2559f = -2;
        this.f2560g = 17;
        this.s = false;
        this.t = false;
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        this.a = context;
        g(context, attributeSet);
        s();
    }
}
