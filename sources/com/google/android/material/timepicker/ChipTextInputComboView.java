package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import e.j.a.c.s.l;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip a;
    private final TextInputLayout b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f3100c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f3101d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f3102e;

    /* loaded from: classes2.dex */
    public class b extends l {
        private static final String b = "00";

        private b() {
        }

        @Override // e.j.a.c.s.l, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.a.setText(ChipTextInputComboView.this.d(b));
            } else {
                ChipTextInputComboView.this.a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.formatText(getResources(), charSequence);
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3100c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f3100c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f3100c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.a, accessibilityDelegateCompat);
    }

    public void g(boolean z) {
        this.f3100c.setCursorVisible(z);
    }

    public void h(CharSequence charSequence) {
        this.f3102e.setText(charSequence);
    }

    public void i(CharSequence charSequence) {
        this.a.setText(d(charSequence));
        if (TextUtils.isEmpty(this.f3100c.getText())) {
            return;
        }
        this.f3100c.removeTextChangedListener(this.f3101d);
        this.f3100c.setText((CharSequence) null);
        this.f3100c.addTextChangedListener(this.f3101d);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.a.setChecked(z);
        this.f3100c.setVisibility(z ? 0 : 4);
        this.a.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            this.f3100c.requestFocus();
            if (TextUtils.isEmpty(this.f3100c.getText())) {
                return;
            }
            EditText editText = this.f3100c;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        this.a.setTag(i2, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f3100c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f3101d = bVar;
        editText.addTextChangedListener(bVar);
        j();
        addView(chip);
        addView(textInputLayout);
        this.f3102e = (TextView) findViewById(R.id.material_label);
        editText.setSaveEnabled(false);
    }
}
