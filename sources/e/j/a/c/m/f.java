package e.j.a.c.m;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.Month;
import com.google.android.material.datepicker.RangeDateSelector;
import com.google.android.material.datepicker.SingleDateSelector;
import com.google.android.material.internal.CheckableImageButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public final class f<S> extends DialogFragment {
    public static final int A = 0;
    public static final int B = 1;
    private static final String r = "OVERRIDE_THEME_RES_ID";
    private static final String s = "DATE_SELECTOR_KEY";
    private static final String t = "CALENDAR_CONSTRAINTS_KEY";
    private static final String u = "TITLE_TEXT_RES_ID_KEY";
    private static final String v = "TITLE_TEXT_KEY";
    private static final String w = "INPUT_MODE_KEY";
    public static final Object x = "CONFIRM_BUTTON_TAG";
    public static final Object y = "CANCEL_BUTTON_TAG";
    public static final Object z = "TOGGLE_BUTTON_TAG";
    private final LinkedHashSet<g<? super S>> a = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> b = new LinkedHashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f10890c = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f10891d = new LinkedHashSet<>();
    @StyleRes

    /* renamed from: e  reason: collision with root package name */
    private int f10892e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private DateSelector<S> f10893f;

    /* renamed from: g  reason: collision with root package name */
    private l<S> f10894g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private CalendarConstraints f10895h;

    /* renamed from: i  reason: collision with root package name */
    private MaterialCalendar<S> f10896i;
    @StringRes

    /* renamed from: j  reason: collision with root package name */
    private int f10897j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f10898k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10899l;

    /* renamed from: m  reason: collision with root package name */
    private int f10900m;
    private TextView n;
    private CheckableImageButton o;
    @Nullable
    private e.j.a.c.z.j p;
    private Button q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = f.this.a.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(f.this.J());
            }
            f.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = f.this.b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            f.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends k<S> {
        public c() {
        }

        @Override // e.j.a.c.m.k
        public void a() {
            f.this.q.setEnabled(false);
        }

        @Override // e.j.a.c.m.k
        public void b(S s) {
            f.this.X();
            f.this.q.setEnabled(f.this.f10893f.isSelectionComplete());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.q.setEnabled(f.this.f10893f.isSelectionComplete());
            f.this.o.toggle();
            f fVar = f.this;
            fVar.Y(fVar.o);
            f.this.U();
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<S> {
        public final DateSelector<S> a;

        /* renamed from: c  reason: collision with root package name */
        public CalendarConstraints f10901c;
        public int b = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f10902d = 0;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f10903e = null;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public S f10904f = null;

        /* renamed from: g  reason: collision with root package name */
        public int f10905g = 0;

        private e(DateSelector<S> dateSelector) {
            this.a = dateSelector;
        }

        private Month b() {
            long j2 = this.f10901c.getStart().timeInMillis;
            long j3 = this.f10901c.getEnd().timeInMillis;
            if (!this.a.getSelectedDays().isEmpty()) {
                long longValue = this.a.getSelectedDays().iterator().next().longValue();
                if (longValue >= j2 && longValue <= j3) {
                    return Month.create(longValue);
                }
            }
            long V = f.V();
            if (j2 <= V && V <= j3) {
                j2 = V;
            }
            return Month.create(j2);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> e<S> c(@NonNull DateSelector<S> dateSelector) {
            return new e<>(dateSelector);
        }

        @NonNull
        public static e<Long> d() {
            return new e<>(new SingleDateSelector());
        }

        @NonNull
        public static e<Pair<Long, Long>> e() {
            return new e<>(new RangeDateSelector());
        }

        @NonNull
        public f<S> a() {
            if (this.f10901c == null) {
                this.f10901c = new CalendarConstraints.b().a();
            }
            if (this.f10902d == 0) {
                this.f10902d = this.a.getDefaultTitleResId();
            }
            S s = this.f10904f;
            if (s != null) {
                this.a.setSelection(s);
            }
            if (this.f10901c.getOpenAt() == null) {
                this.f10901c.setOpenAt(b());
            }
            return f.O(this);
        }

        @NonNull
        public e<S> f(CalendarConstraints calendarConstraints) {
            this.f10901c = calendarConstraints;
            return this;
        }

        @NonNull
        public e<S> g(int i2) {
            this.f10905g = i2;
            return this;
        }

        @NonNull
        public e<S> h(S s) {
            this.f10904f = s;
            return this;
        }

        @NonNull
        public e<S> i(@StyleRes int i2) {
            this.b = i2;
            return this;
        }

        @NonNull
        public e<S> j(@StringRes int i2) {
            this.f10902d = i2;
            this.f10903e = null;
            return this;
        }

        @NonNull
        public e<S> k(@Nullable CharSequence charSequence) {
            this.f10903e = charSequence;
            this.f10902d = 0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: e.j.a.c.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public @interface InterfaceC0368f {
    }

    @NonNull
    private static Drawable F(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int G(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i2 = i.f10911f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int I(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = Month.current().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int K(Context context) {
        int i2 = this.f10892e;
        return i2 != 0 ? i2 : this.f10893f.getDefaultThemeResId(context);
    }

    private void L(Context context) {
        this.o.setTag(z);
        this.o.setImageDrawable(F(context));
        this.o.setChecked(this.f10900m != 0);
        ViewCompat.setAccessibilityDelegate(this.o, null);
        Y(this.o);
        this.o.setOnClickListener(new d());
    }

    public static boolean M(@NonNull Context context) {
        return P(context, 16843277);
    }

    public static boolean N(@NonNull Context context) {
        return P(context, R.attr.nestedScrollable);
    }

    @NonNull
    public static <S> f<S> O(@NonNull e<S> eVar) {
        f<S> fVar = new f<>();
        Bundle bundle = new Bundle();
        bundle.putInt(r, eVar.b);
        bundle.putParcelable(s, eVar.a);
        bundle.putParcelable(t, eVar.f10901c);
        bundle.putInt(u, eVar.f10902d);
        bundle.putCharSequence(v, eVar.f10903e);
        bundle.putInt(w, eVar.f10905g);
        fVar.setArguments(bundle);
        return fVar;
    }

    public static boolean P(@NonNull Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e.j.a.c.w.b.g(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        int K = K(requireContext());
        this.f10896i = MaterialCalendar.H(this.f10893f, K, this.f10895h);
        this.f10894g = this.o.isChecked() ? h.t(this.f10893f, K, this.f10895h) : this.f10896i;
        X();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mtrl_calendar_frame, this.f10894g);
        beginTransaction.commitNow();
        this.f10894g.p(new c());
    }

    public static long V() {
        return Month.current().timeInMillis;
    }

    public static long W() {
        return o.t().getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        String H = H();
        this.n.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), H));
        this.n.setText(H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.o.isChecked()) {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.o.setContentDescription(string);
    }

    public boolean A(g<? super S> gVar) {
        return this.a.add(gVar);
    }

    public void B() {
        this.f10890c.clear();
    }

    public void C() {
        this.f10891d.clear();
    }

    public void D() {
        this.b.clear();
    }

    public void E() {
        this.a.clear();
    }

    public String H() {
        return this.f10893f.getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S J() {
        return this.f10893f.getSelection();
    }

    public boolean Q(DialogInterface.OnCancelListener onCancelListener) {
        return this.f10890c.remove(onCancelListener);
    }

    public boolean R(DialogInterface.OnDismissListener onDismissListener) {
        return this.f10891d.remove(onDismissListener);
    }

    public boolean S(View.OnClickListener onClickListener) {
        return this.b.remove(onClickListener);
    }

    public boolean T(g<? super S> gVar) {
        return this.a.remove(gVar);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f10890c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10892e = bundle.getInt(r);
        this.f10893f = (DateSelector) bundle.getParcelable(s);
        this.f10895h = (CalendarConstraints) bundle.getParcelable(t);
        this.f10897j = bundle.getInt(u);
        this.f10898k = bundle.getCharSequence(v);
        this.f10900m = bundle.getInt(w);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), K(requireContext()));
        Context context = dialog.getContext();
        this.f10899l = M(context);
        int g2 = e.j.a.c.w.b.g(context, R.attr.colorSurface, f.class.getCanonicalName());
        e.j.a.c.z.j jVar = new e.j.a.c.z.j(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.p = jVar;
        jVar.Y(context);
        this.p.n0(ColorStateList.valueOf(g2));
        this.p.m0(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f10899l ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.f10899l) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(I(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(I(context), -1));
            findViewById2.setMinimumHeight(G(requireContext()));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.n = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.o = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.f10898k;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f10897j);
        }
        L(context);
        this.q = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.f10893f.isSelectionComplete()) {
            this.q.setEnabled(true);
        } else {
            this.q.setEnabled(false);
        }
        this.q.setTag(x);
        this.q.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(y);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f10891d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(r, this.f10892e);
        bundle.putParcelable(s, this.f10893f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f10895h);
        if (this.f10896i.E() != null) {
            bVar.c(this.f10896i.E().timeInMillis);
        }
        bundle.putParcelable(t, bVar.a());
        bundle.putInt(u, this.f10897j);
        bundle.putCharSequence(v, this.f10898k);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f10899l) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.p);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.p, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new e.j.a.c.n.a(requireDialog(), rect));
        }
        U();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f10894g.q();
        super.onStop();
    }

    public boolean x(DialogInterface.OnCancelListener onCancelListener) {
        return this.f10890c.add(onCancelListener);
    }

    public boolean y(DialogInterface.OnDismissListener onDismissListener) {
        return this.f10891d.add(onDismissListener);
    }

    public boolean z(View.OnClickListener onClickListener) {
        return this.b.add(onClickListener);
    }
}
