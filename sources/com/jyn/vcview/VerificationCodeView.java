package com.jyn.vcview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class VerificationCodeView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {
    private Context a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private int f4597c;

    /* renamed from: d  reason: collision with root package name */
    private VCInputType f4598d;

    /* renamed from: e  reason: collision with root package name */
    private int f4599e;

    /* renamed from: f  reason: collision with root package name */
    private int f4600f;

    /* renamed from: g  reason: collision with root package name */
    private float f4601g;

    /* renamed from: h  reason: collision with root package name */
    private int f4602h;

    /* renamed from: i  reason: collision with root package name */
    private int f4603i;

    /* renamed from: j  reason: collision with root package name */
    private int f4604j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4605k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4606l;

    /* renamed from: m  reason: collision with root package name */
    private int f4607m;
    private int n;
    private int o;

    /* loaded from: classes2.dex */
    public enum VCInputType {
        NUMBER,
        NUMBERPASSWORD,
        TEXT,
        TEXTPASSWORD
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VCInputType.values().length];
            a = iArr;
            try {
                iArr[VCInputType.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[VCInputType.NUMBERPASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[VCInputType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[VCInputType.TEXTPASSWORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, String str);

        void b(View view, String str);
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.vericationCodeView);
        this.f4597c = obtainStyledAttributes.getInteger(R.styleable.vericationCodeView_vcv_et_number, 4);
        this.f4598d = VCInputType.values()[obtainStyledAttributes.getInt(R.styleable.vericationCodeView_vcv_et_inputType, VCInputType.NUMBER.ordinal())];
        this.f4599e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.vericationCodeView_vcv_et_width, 120);
        this.f4600f = obtainStyledAttributes.getColor(R.styleable.vericationCodeView_vcv_et_text_color, ViewCompat.MEASURED_STATE_MASK);
        this.f4601g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.vericationCodeView_vcv_et_text_size, 16);
        this.f4602h = obtainStyledAttributes.getResourceId(R.styleable.vericationCodeView_vcv_et_bg, R.drawable.et_login_code);
        this.f4607m = obtainStyledAttributes.getResourceId(R.styleable.vericationCodeView_vcv_et_cursor, R.drawable.et_cursor);
        this.f4606l = obtainStyledAttributes.getBoolean(R.styleable.vericationCodeView_vcv_et_cursor_visible, true);
        int i2 = R.styleable.vericationCodeView_vcv_et_spacing;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        this.f4605k = hasValue;
        if (hasValue) {
            this.f4603i = obtainStyledAttributes.getDimensionPixelSize(i2, 0);
        }
        e();
        obtainStyledAttributes.recycle();
    }

    private void a() {
        for (int i2 = this.f4597c - 1; i2 >= 0; i2--) {
            EditText editText = (EditText) getChildAt(i2);
            if (editText.getText().length() >= 1) {
                editText.setText("");
                if (this.f4606l) {
                    editText.setCursorVisible(true);
                } else {
                    editText.setCursorVisible(false);
                }
                editText.requestFocus();
                return;
            }
        }
    }

    private void b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            EditText editText = (EditText) getChildAt(i2);
            if (editText.getText().length() < 1) {
                if (this.f4606l) {
                    editText.setCursorVisible(true);
                } else {
                    editText.setCursorVisible(false);
                }
                editText.requestFocus();
                return;
            }
            editText.setCursorVisible(false);
            if (i2 == childCount - 1) {
                editText.requestFocus();
            }
        }
    }

    @TargetApi(17)
    private void d(EditText editText, int i2) {
        editText.setLayoutParams(c(i2));
        editText.setTextAlignment(4);
        editText.setGravity(17);
        editText.setId(i2);
        editText.setCursorVisible(false);
        editText.setMaxEms(1);
        editText.setTextColor(this.f4600f);
        editText.setTextSize(this.f4601g);
        editText.setCursorVisible(this.f4606l);
        editText.setMaxLines(1);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        int i3 = a.a[this.f4598d.ordinal()];
        if (i3 == 1) {
            editText.setInputType(2);
        } else if (i3 == 2) {
            editText.setInputType(18);
            editText.setTransformationMethod(new e.m.a.a());
        } else if (i3 == 3) {
            editText.setInputType(1);
        } else if (i3 != 4) {
            editText.setInputType(2);
        } else {
            editText.setInputType(2);
        }
        editText.setPadding(0, 0, 0, 0);
        editText.setOnKeyListener(this);
        editText.setBackgroundResource(this.f4602h);
        setEditTextCursorDrawable(editText);
        editText.addTextChangedListener(this);
        editText.setOnKeyListener(this);
        editText.setOnFocusChangeListener(this);
    }

    @SuppressLint({"ResourceAsColor"})
    private void e() {
        for (int i2 = 0; i2 < this.f4597c; i2++) {
            EditText editText = new EditText(this.a);
            d(editText, i2);
            addView(editText);
            if (i2 == 0) {
                editText.setFocusable(true);
            }
        }
    }

    private void g() {
        for (int i2 = 0; i2 < this.f4597c; i2++) {
            ((EditText) getChildAt(i2)).setLayoutParams(c(i2));
        }
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f4597c; i2++) {
            sb.append((CharSequence) ((EditText) getChildAt(i2)).getText());
        }
        return sb.toString();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            b();
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(this, getResult());
            if (((EditText) getChildAt(this.f4597c - 1)).getText().length() > 0) {
                this.b.b(this, getResult());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public LinearLayout.LayoutParams c(int i2) {
        int i3 = this.f4599e;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        if (!this.f4605k) {
            int i4 = this.n;
            int i5 = this.f4597c;
            int i6 = (i4 - (this.f4599e * i5)) / (i5 + 1);
            this.f4604j = i6;
            if (i2 == 0) {
                layoutParams.leftMargin = i6;
                layoutParams.rightMargin = i6 / 2;
            } else if (i2 == i5 - 1) {
                layoutParams.leftMargin = i6 / 2;
                layoutParams.rightMargin = i6;
            } else {
                layoutParams.leftMargin = i6 / 2;
                layoutParams.rightMargin = i6 / 2;
            }
        } else {
            int i7 = this.f4603i;
            layoutParams.leftMargin = i7 / 2;
            layoutParams.rightMargin = i7 / 2;
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void f() {
        for (int i2 = this.f4597c - 1; i2 >= 0; i2--) {
            EditText editText = (EditText) getChildAt(i2);
            editText.setText("");
            if (i2 == 0) {
                if (this.f4606l) {
                    editText.setCursorVisible(true);
                } else {
                    editText.setCursorVisible(false);
                }
                editText.requestFocus();
            }
        }
    }

    public b getOnCodeFinishListener() {
        return this.b;
    }

    public int getmCursorDrawable() {
        return this.f4607m;
    }

    public VCInputType getmEtInputType() {
        return this.f4598d;
    }

    public int getmEtNumber() {
        return this.f4597c;
    }

    public int getmEtTextBg() {
        return this.f4602h;
    }

    public int getmEtTextColor() {
        return this.f4600f;
    }

    public float getmEtTextSize() {
        return this.f4601g;
    }

    public int getmEtWidth() {
        return this.f4599e;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            b();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (i2 == 67 && keyEvent.getAction() == 0) {
            a();
            return false;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.n = getMeasuredWidth();
        g();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void setEditTextCursorDrawable(EditText editText) {
        if (this.f4606l) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(this.f4607m));
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(z);
        }
    }

    public void setOnCodeFinishListener(b bVar) {
        this.b = bVar;
    }

    public void setmCursorDrawable(int i2) {
        this.f4607m = i2;
    }

    public void setmEtInputType(VCInputType vCInputType) {
        this.f4598d = vCInputType;
    }

    public void setmEtNumber(int i2) {
        this.f4597c = i2;
    }

    public void setmEtTextBg(int i2) {
        this.f4602h = i2;
    }

    public void setmEtTextColor(int i2) {
        this.f4600f = i2;
    }

    public void setmEtTextSize(float f2) {
        this.f4601g = f2;
    }

    public void setmEtWidth(int i2) {
        this.f4599e = i2;
    }
}
