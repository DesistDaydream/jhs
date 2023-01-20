package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import e.j.a.c.m.l;
import e.j.a.c.m.m;
import e.j.a.c.m.o;
import e.j.a.c.m.p;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class MaterialCalendar<S> extends l<S> {

    /* renamed from: l  reason: collision with root package name */
    private static final String f2865l = "THEME_RES_ID_KEY";

    /* renamed from: m  reason: collision with root package name */
    private static final String f2866m = "GRID_SELECTOR_KEY";
    private static final String n = "CALENDAR_CONSTRAINTS_KEY";
    private static final String o = "CURRENT_MONTH_KEY";
    private static final int p = 3;
    @VisibleForTesting
    public static final Object q = "MONTHS_VIEW_GROUP_TAG";
    @VisibleForTesting
    public static final Object r = "NAVIGATION_PREV_TAG";
    @VisibleForTesting
    public static final Object s = "NAVIGATION_NEXT_TAG";
    @VisibleForTesting
    public static final Object t = "SELECTOR_TOGGLE_TAG";
    @StyleRes
    private int b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private DateSelector<S> f2867c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f2868d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Month f2869e;

    /* renamed from: f  reason: collision with root package name */
    private CalendarSelector f2870f;

    /* renamed from: g  reason: collision with root package name */
    private e.j.a.c.m.b f2871g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f2872h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f2873i;

    /* renamed from: j  reason: collision with root package name */
    private View f2874j;

    /* renamed from: k  reason: collision with root package name */
    private View f2875k;

    /* loaded from: classes2.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f2873i.smoothScrollToPosition(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends m {
        public final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.b = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.b == 0) {
                iArr[0] = MaterialCalendar.this.f2873i.getWidth();
                iArr[1] = MaterialCalendar.this.f2873i.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.f2873i.getHeight();
            iArr[1] = MaterialCalendar.this.f2873i.getHeight();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements k {
        public d() {
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j2) {
            if (MaterialCalendar.this.f2868d.getDateValidator().isValid(j2)) {
                MaterialCalendar.this.f2867c.select(j2);
                Iterator<e.j.a.c.m.k<S>> it = MaterialCalendar.this.a.iterator();
                while (it.hasNext()) {
                    it.next().b((S) MaterialCalendar.this.f2867c.getSelection());
                }
                MaterialCalendar.this.f2873i.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f2872h != null) {
                    MaterialCalendar.this.f2872h.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends RecyclerView.ItemDecoration {
        private final Calendar a = o.v();
        private final Calendar b = o.v();

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int width;
            if ((recyclerView.getAdapter() instanceof p) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                p pVar = (p) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.this.f2867c.getSelectedRanges()) {
                    Long l2 = pair.first;
                    if (l2 != null && pair.second != null) {
                        this.a.setTimeInMillis(l2.longValue());
                        this.b.setTimeInMillis(pair.second.longValue());
                        int c2 = pVar.c(this.a.get(1));
                        int c3 = pVar.c(this.b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(c2);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(c3);
                        int spanCount = c2 / gridLayoutManager.getSpanCount();
                        int spanCount2 = c3 / gridLayoutManager.getSpanCount();
                        int i2 = spanCount;
                        while (i2 <= spanCount2) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + MaterialCalendar.this.f2871g.f10877d.e();
                                int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.f2871g.f10877d.b();
                                int left = i2 == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0;
                                if (i2 == spanCount2) {
                                    width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(left, top, width, bottom, MaterialCalendar.this.f2871g.f10881h);
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends AccessibilityDelegateCompat {
        public f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String string;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (MaterialCalendar.this.f2875k.getVisibility() == 0) {
                string = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
            } else {
                string = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
            }
            accessibilityNodeInfoCompat.setHintText(string);
        }
    }

    /* loaded from: classes2.dex */
    public class g extends RecyclerView.OnScrollListener {
        public final /* synthetic */ e.j.a.c.m.j a;
        public final /* synthetic */ MaterialButton b;

        public g(e.j.a.c.m.j jVar, MaterialButton materialButton) {
            this.a = jVar;
            this.b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            int findLastVisibleItemPosition;
            if (i2 < 0) {
                findLastVisibleItemPosition = MaterialCalendar.this.G().findFirstVisibleItemPosition();
            } else {
                findLastVisibleItemPosition = MaterialCalendar.this.G().findLastVisibleItemPosition();
            }
            MaterialCalendar.this.f2869e = this.a.b(findLastVisibleItemPosition);
            this.b.setText(this.a.c(findLastVisibleItemPosition));
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.L();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public final /* synthetic */ e.j.a.c.m.j a;

        public i(e.j.a.c.m.j jVar) {
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = MaterialCalendar.this.G().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.f2873i.getAdapter().getItemCount()) {
                MaterialCalendar.this.J(this.a.b(findFirstVisibleItemPosition));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public final /* synthetic */ e.j.a.c.m.j a;

        public j(e.j.a.c.m.j jVar) {
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = MaterialCalendar.this.G().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.J(this.a.b(findLastVisibleItemPosition));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface k {
        void a(long j2);
    }

    private void A(@NonNull View view, @NonNull e.j.a.c.m.j jVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(t);
        ViewCompat.setAccessibilityDelegate(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(r);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(s);
        this.f2874j = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f2875k = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        K(CalendarSelector.DAY);
        materialButton.setText(this.f2869e.getLongName(view.getContext()));
        this.f2873i.addOnScrollListener(new g(jVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(jVar));
        materialButton2.setOnClickListener(new j(jVar));
    }

    @NonNull
    private RecyclerView.ItemDecoration B() {
        return new e();
    }

    @Px
    public static int F(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    @NonNull
    public static <T> MaterialCalendar<T> H(@NonNull DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f2865l, i2);
        bundle.putParcelable(f2866m, dateSelector);
        bundle.putParcelable(n, calendarConstraints);
        bundle.putParcelable(o, calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void I(int i2) {
        this.f2873i.post(new a(i2));
    }

    @Nullable
    public CalendarConstraints C() {
        return this.f2868d;
    }

    public e.j.a.c.m.b D() {
        return this.f2871g;
    }

    @Nullable
    public Month E() {
        return this.f2869e;
    }

    @NonNull
    public LinearLayoutManager G() {
        return (LinearLayoutManager) this.f2873i.getLayoutManager();
    }

    public void J(Month month) {
        e.j.a.c.m.j jVar = (e.j.a.c.m.j) this.f2873i.getAdapter();
        int d2 = jVar.d(month);
        int d3 = d2 - jVar.d(this.f2869e);
        boolean z = Math.abs(d3) > 3;
        boolean z2 = d3 > 0;
        this.f2869e = month;
        if (z && z2) {
            this.f2873i.scrollToPosition(d2 - 3);
            I(d2);
        } else if (z) {
            this.f2873i.scrollToPosition(d2 + 3);
            I(d2);
        } else {
            I(d2);
        }
    }

    public void K(CalendarSelector calendarSelector) {
        this.f2870f = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f2872h.getLayoutManager().scrollToPosition(((p) this.f2872h.getAdapter()).c(this.f2869e.year));
            this.f2874j.setVisibility(0);
            this.f2875k.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.f2874j.setVisibility(8);
            this.f2875k.setVisibility(0);
            J(this.f2869e);
        }
    }

    public void L() {
        CalendarSelector calendarSelector = this.f2870f;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            K(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            K(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt(f2865l);
        this.f2867c = (DateSelector) bundle.getParcelable(f2866m);
        this.f2868d = (CalendarConstraints) bundle.getParcelable(n);
        this.f2869e = (Month) bundle.getParcelable(o);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.f2871g = new e.j.a.c.m.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month start = this.f2868d.getStart();
        if (e.j.a.c.m.f.M(contextThemeWrapper)) {
            i2 = R.layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R.layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b());
        gridView.setAdapter((ListAdapter) new e.j.a.c.m.e());
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.f2873i = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.f2873i.setLayoutManager(new c(getContext(), i3, false, i3));
        this.f2873i.setTag(q);
        e.j.a.c.m.j jVar = new e.j.a.c.m.j(contextThemeWrapper, this.f2867c, this.f2868d, new d());
        this.f2873i.setAdapter(jVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f2872h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f2872h.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f2872h.setAdapter(new p(this));
            this.f2872h.addItemDecoration(B());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            A(inflate, jVar);
        }
        if (!e.j.a.c.m.f.M(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f2873i);
        }
        this.f2873i.scrollToPosition(jVar.d(this.f2869e));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f2865l, this.b);
        bundle.putParcelable(f2866m, this.f2867c);
        bundle.putParcelable(n, this.f2868d);
        bundle.putParcelable(o, this.f2869e);
    }

    @Override // e.j.a.c.m.l
    public boolean p(@NonNull e.j.a.c.m.k<S> kVar) {
        return super.p(kVar);
    }

    @Override // e.j.a.c.m.l
    @Nullable
    public DateSelector<S> r() {
        return this.f2867c;
    }
}
