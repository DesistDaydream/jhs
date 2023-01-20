package e.j.a.c.m;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class h<S> extends l<S> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f10906e = "THEME_RES_ID_KEY";

    /* renamed from: f  reason: collision with root package name */
    private static final String f10907f = "DATE_SELECTOR_KEY";

    /* renamed from: g  reason: collision with root package name */
    private static final String f10908g = "CALENDAR_CONSTRAINTS_KEY";
    @StyleRes
    private int b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private DateSelector<S> f10909c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f10910d;

    /* loaded from: classes2.dex */
    public class a extends k<S> {
        public a() {
        }

        @Override // e.j.a.c.m.k
        public void a() {
            Iterator<k<S>> it = h.this.a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // e.j.a.c.m.k
        public void b(S s) {
            Iterator<k<S>> it = h.this.a.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    @NonNull
    public static <T> h<T> t(DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f10906e, i2);
        bundle.putParcelable(f10907f, dateSelector);
        bundle.putParcelable(f10908g, calendarConstraints);
        hVar.setArguments(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt(f10906e);
        this.f10909c = (DateSelector) bundle.getParcelable(f10907f);
        this.f10910d = (CalendarConstraints) bundle.getParcelable(f10908g);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f10909c.onCreateTextInputView(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.b)), viewGroup, bundle, this.f10910d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f10906e, this.b);
        bundle.putParcelable(f10907f, this.f10909c);
        bundle.putParcelable(f10908g, this.f10910d);
    }

    @Override // e.j.a.c.m.l
    @NonNull
    public DateSelector<S> r() {
        DateSelector<S> dateSelector = this.f10909c;
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }
}
