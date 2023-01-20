package e.j.a.c.f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import e.j.a.c.s.l;
import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes2.dex */
public class i implements TimePickerView.g, g {
    private final LinearLayout a;
    private final TimeModel b;

    /* renamed from: c  reason: collision with root package name */
    private final TextWatcher f10668c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f10669d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final ChipTextInputComboView f10670e;

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f10671f;

    /* renamed from: g  reason: collision with root package name */
    private final h f10672g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f10673h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f10674i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialButtonToggleGroup f10675j;

    /* loaded from: classes2.dex */
    public class a extends l {
        public a() {
        }

        @Override // e.j.a.c.s.l, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    i.this.b.setMinute(0);
                    return;
                }
                i.this.b.setMinute(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends l {
        public b() {
        }

        @Override // e.j.a.c.s.l, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    i.this.b.setHour(0);
                    return;
                }
                i.this.b.setHour(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.d(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements MaterialButtonToggleGroup.e {
        public d() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
            i.this.b.setPeriod(i2 == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public i(LinearLayout linearLayout, TimeModel timeModel) {
        this.a = linearLayout;
        this.b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f10670e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f10671f = chipTextInputComboView2;
        int i2 = R.id.material_label;
        ((TextView) chipTextInputComboView.findViewById(i2)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(i2)).setText(resources.getString(R.string.material_timepicker_hour));
        int i3 = R.id.selection_type;
        chipTextInputComboView.setTag(i3, 12);
        chipTextInputComboView2.setTag(i3, 10);
        if (timeModel.format == 0) {
            k();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.getHourInputValidator());
        chipTextInputComboView.c(timeModel.getMinuteInputValidator());
        EditText editText = chipTextInputComboView2.e().getEditText();
        this.f10673h = editText;
        EditText editText2 = chipTextInputComboView.e().getEditText();
        this.f10674i = editText2;
        if (Build.VERSION.SDK_INT < 21) {
            int d2 = e.j.a.c.l.a.d(linearLayout, R.attr.colorPrimary);
            i(editText, d2);
            i(editText2, d2);
        }
        this.f10672g = new h(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new e.j.a.c.f0.a(linearLayout.getContext(), R.string.material_hour_selection));
        chipTextInputComboView.f(new e.j.a.c.f0.a(linearLayout.getContext(), R.string.material_minute_selection));
        a();
    }

    private void c() {
        this.f10673h.addTextChangedListener(this.f10669d);
        this.f10674i.addTextChangedListener(this.f10668c);
    }

    private void g() {
        this.f10673h.removeTextChangedListener(this.f10669d);
        this.f10674i.removeTextChangedListener(this.f10668c);
    }

    private static void i(EditText editText, @ColorInt int i2) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable drawable = AppCompatResources.getDrawable(context, i3);
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{drawable, drawable});
        } catch (Throwable unused) {
        }
    }

    private void j(TimeModel timeModel) {
        g();
        Locale locale = this.a.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.minute));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.getHourForDisplay()));
        this.f10670e.i(format);
        this.f10671f.i(format2);
        c();
        l();
    }

    private void k() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.a.findViewById(R.id.material_clock_period_toggle);
        this.f10675j = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new d());
        this.f10675j.setVisibility(0);
        l();
    }

    private void l() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f10675j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.j(this.b.period == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
    }

    @Override // e.j.a.c.f0.g
    public void a() {
        c();
        j(this.b);
        this.f10672g.a();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void d(int i2) {
        this.b.selection = i2;
        this.f10670e.setChecked(i2 == 12);
        this.f10671f.setChecked(i2 == 10);
        l();
    }

    public void e() {
        this.f10670e.setChecked(false);
        this.f10671f.setChecked(false);
    }

    @Override // e.j.a.c.f0.g
    public void f() {
        View focusedChild = this.a.getFocusedChild();
        if (focusedChild == null) {
            this.a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.a.setVisibility(8);
    }

    public void h() {
        this.f10670e.setChecked(this.b.selection == 12);
        this.f10671f.setChecked(this.b.selection == 10);
    }

    @Override // e.j.a.c.f0.g
    public void invalidate() {
        j(this.b);
    }

    @Override // e.j.a.c.f0.g
    public void show() {
        this.a.setVisibility(0);
    }
}
