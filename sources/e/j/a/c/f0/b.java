package e.j.a.c.f0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import e.j.a.c.z.j;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b extends DialogFragment {
    public static final int r = 0;
    public static final int s = 1;
    public static final String t = "TIME_PICKER_TIME_MODEL";
    public static final String u = "TIME_PICKER_INPUT_MODE";
    public static final String v = "TIME_PICKER_TITLE_RES";
    public static final String w = "TIME_PICKER_TITLE_TEXT";
    public static final String x = "TIME_PICKER_OVERRIDE_THEME_RES_ID";

    /* renamed from: e  reason: collision with root package name */
    private TimePickerView f10646e;

    /* renamed from: f  reason: collision with root package name */
    private ViewStub f10647f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private e.j.a.c.f0.e f10648g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private i f10649h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private g f10650i;
    @DrawableRes

    /* renamed from: j  reason: collision with root package name */
    private int f10651j;
    @DrawableRes

    /* renamed from: k  reason: collision with root package name */
    private int f10652k;

    /* renamed from: m  reason: collision with root package name */
    private String f10654m;
    private MaterialButton n;
    private TimeModel p;
    private final Set<View.OnClickListener> a = new LinkedHashSet();
    private final Set<View.OnClickListener> b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<DialogInterface.OnCancelListener> f10644c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    private final Set<DialogInterface.OnDismissListener> f10645d = new LinkedHashSet();

    /* renamed from: l  reason: collision with root package name */
    private int f10653l = 0;
    private int o = 0;
    private int q = 0;

    /* loaded from: classes2.dex */
    public class a implements TimePickerView.e {
        public a() {
        }

        @Override // com.google.android.material.timepicker.TimePickerView.e
        public void a() {
            b.this.o = 1;
            b bVar = b.this;
            bVar.S(bVar.n);
            b.this.f10649h.h();
        }
    }

    /* renamed from: e.j.a.c.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0359b implements View.OnClickListener {
        public View$OnClickListenerC0359b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : b.this.a) {
                onClickListener.onClick(view);
            }
            b.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : b.this.b) {
                onClickListener.onClick(view);
            }
            b.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.o = bVar.o == 0 ? 1 : 0;
            b bVar2 = b.this;
            bVar2.S(bVar2.n);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {
        private int b;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f10656d;
        private TimeModel a = new TimeModel();

        /* renamed from: c  reason: collision with root package name */
        private int f10655c = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f10657e = 0;

        @NonNull
        public b f() {
            return b.M(this);
        }

        @NonNull
        public e g(@IntRange(from = 0, to = 23) int i2) {
            this.a.setHourOfDay(i2);
            return this;
        }

        @NonNull
        public e h(int i2) {
            this.b = i2;
            return this;
        }

        @NonNull
        public e i(@IntRange(from = 0, to = 60) int i2) {
            this.a.setMinute(i2);
            return this;
        }

        @NonNull
        public e j(@StyleRes int i2) {
            this.f10657e = i2;
            return this;
        }

        @NonNull
        public e k(int i2) {
            TimeModel timeModel = this.a;
            int i3 = timeModel.hour;
            int i4 = timeModel.minute;
            TimeModel timeModel2 = new TimeModel(i2);
            this.a = timeModel2;
            timeModel2.setMinute(i4);
            this.a.setHourOfDay(i3);
            return this;
        }

        @NonNull
        public e l(@StringRes int i2) {
            this.f10655c = i2;
            return this;
        }

        @NonNull
        public e m(@Nullable CharSequence charSequence) {
            this.f10656d = charSequence;
            return this;
        }
    }

    private Pair<Integer, Integer> F(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return new Pair<>(Integer.valueOf(this.f10652k), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
            }
            throw new IllegalArgumentException("no icon for mode: " + i2);
        }
        return new Pair<>(Integer.valueOf(this.f10651j), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
    }

    private int J() {
        int i2 = this.q;
        if (i2 != 0) {
            return i2;
        }
        TypedValue a2 = e.j.a.c.w.b.a(requireContext(), R.attr.materialTimePickerTheme);
        if (a2 == null) {
            return 0;
        }
        return a2.data;
    }

    private g L(int i2) {
        if (i2 == 0) {
            e.j.a.c.f0.e eVar = this.f10648g;
            if (eVar == null) {
                eVar = new e.j.a.c.f0.e(this.f10646e, this.p);
            }
            this.f10648g = eVar;
            return eVar;
        }
        if (this.f10649h == null) {
            this.f10649h = new i((LinearLayout) this.f10647f.inflate(), this.p);
        }
        this.f10649h.e();
        return this.f10649h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static b M(@NonNull e eVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable(t, eVar.a);
        bundle.putInt(u, eVar.b);
        bundle.putInt(v, eVar.f10655c);
        bundle.putInt(x, eVar.f10657e);
        if (eVar.f10656d != null) {
            bundle.putString(w, eVar.f10656d.toString());
        }
        bVar.setArguments(bundle);
        return bVar;
    }

    private void R(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable(t);
        this.p = timeModel;
        if (timeModel == null) {
            this.p = new TimeModel();
        }
        this.o = bundle.getInt(u, 0);
        this.f10653l = bundle.getInt(v, 0);
        this.f10654m = bundle.getString(w);
        this.q = bundle.getInt(x, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(MaterialButton materialButton) {
        g gVar = this.f10650i;
        if (gVar != null) {
            gVar.f();
        }
        g L = L(this.o);
        this.f10650i = L;
        L.show();
        this.f10650i.invalidate();
        Pair<Integer, Integer> F = F(this.o);
        materialButton.setIconResource(((Integer) F.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) F.second).intValue()));
    }

    public boolean A(@NonNull View.OnClickListener onClickListener) {
        return this.a.add(onClickListener);
    }

    public void B() {
        this.f10644c.clear();
    }

    public void C() {
        this.f10645d.clear();
    }

    public void D() {
        this.b.clear();
    }

    public void E() {
        this.a.clear();
    }

    @IntRange(from = 0, to = 23)
    public int G() {
        return this.p.hour % 24;
    }

    public int H() {
        return this.o;
    }

    @IntRange(from = 0, to = 60)
    public int I() {
        return this.p.minute;
    }

    @Nullable
    public e.j.a.c.f0.e K() {
        return this.f10648g;
    }

    public boolean N(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.f10644c.remove(onCancelListener);
    }

    public boolean O(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.f10645d.remove(onDismissListener);
    }

    public boolean P(@NonNull View.OnClickListener onClickListener) {
        return this.b.remove(onClickListener);
    }

    public boolean Q(@NonNull View.OnClickListener onClickListener) {
        return this.a.remove(onClickListener);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.f10644c) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        R(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), J());
        Context context = dialog.getContext();
        int g2 = e.j.a.c.w.b.g(context, R.attr.colorSurface, b.class.getCanonicalName());
        int i2 = R.attr.materialTimePickerStyle;
        int i3 = R.style.Widget_MaterialComponents_TimePicker;
        j jVar = new j(context, null, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, i2, i3);
        this.f10652k = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.f10651j = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        jVar.Y(context);
        jVar.n0(ColorStateList.valueOf(g2));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(jVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.f10646e = timePickerView;
        timePickerView.o(new a());
        this.f10647f = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.n = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.f10654m)) {
            textView.setText(this.f10654m);
        }
        int i2 = this.f10653l;
        if (i2 != 0) {
            textView.setText(i2);
        }
        S(this.n);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new View$OnClickListenerC0359b());
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new c());
        this.n.setOnClickListener(new d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.f10645d) {
            onDismissListener.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(t, this.p);
        bundle.putInt(u, this.o);
        bundle.putInt(v, this.f10653l);
        bundle.putString(w, this.f10654m);
        bundle.putInt(x, this.q);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f10650i = null;
        this.f10648g = null;
        this.f10649h = null;
        this.f10646e = null;
    }

    public boolean x(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.f10644c.add(onCancelListener);
    }

    public boolean y(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.f10645d.add(onDismissListener);
    }

    public boolean z(@NonNull View.OnClickListener onClickListener) {
        return this.b.add(onClickListener);
    }
}
