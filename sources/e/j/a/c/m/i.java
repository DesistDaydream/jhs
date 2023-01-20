package e.j.a.c.m;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class i extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public static final int f10911f = o.v().getMaximum(4);
    public final Month a;
    public final DateSelector<?> b;

    /* renamed from: c  reason: collision with root package name */
    private Collection<Long> f10912c;

    /* renamed from: d  reason: collision with root package name */
    public b f10913d;

    /* renamed from: e  reason: collision with root package name */
    public final CalendarConstraints f10914e;

    public i(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.a = month;
        this.b = dateSelector;
        this.f10914e = calendarConstraints;
        this.f10912c = dateSelector.getSelectedDays();
    }

    private void e(Context context) {
        if (this.f10913d == null) {
            this.f10913d = new b(context);
        }
    }

    private boolean h(long j2) {
        Iterator<Long> it = this.b.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (o.a(j2) == o.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(@Nullable TextView textView, long j2) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.f10914e.getDateValidator().isValid(j2)) {
            textView.setEnabled(true);
            if (h(j2)) {
                aVar = this.f10913d.b;
            } else if (o.t().getTimeInMillis() == j2) {
                aVar = this.f10913d.f10876c;
            } else {
                aVar = this.f10913d.a;
            }
        } else {
            textView.setEnabled(false);
            aVar = this.f10913d.f10880g;
        }
        aVar.f(textView);
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.create(j2).equals(this.a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(this.a.getDayOfMonth(j2)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    public int a(int i2) {
        return b() + (i2 - 1);
    }

    public int b() {
        return this.a.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: c */
    public Long getItem(int i2) {
        if (i2 < this.a.daysFromStartOfWeekToFirstOfMonth() || i2 > i()) {
            return null;
        }
        return Long.valueOf(this.a.getDay(j(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.a
            int r2 = r8.daysInMonth
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.a
            long r7 = r8.getDay(r7)
            com.google.android.material.datepicker.Month r3 = r5.a
            int r3 = r3.year
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.current()
            int r4 = r4.year
            if (r3 != r4) goto L67
            java.lang.String r7 = e.j.a.c.m.d.g(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = e.j.a.c.m.d.l(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.k(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.c.m.i.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public boolean f(int i2) {
        return i2 % this.a.daysInWeek == 0;
    }

    public boolean g(int i2) {
        return (i2 + 1) % this.a.daysInWeek == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.daysInMonth + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.a.daysInWeek;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public int i() {
        return (this.a.daysFromStartOfWeekToFirstOfMonth() + this.a.daysInMonth) - 1;
    }

    public int j(int i2) {
        return (i2 - this.a.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l2 : this.f10912c) {
            l(materialCalendarGridView, l2.longValue());
        }
        DateSelector<?> dateSelector = this.b;
        if (dateSelector != null) {
            for (Long l3 : dateSelector.getSelectedDays()) {
                l(materialCalendarGridView, l3.longValue());
            }
            this.f10912c = this.b.getSelectedDays();
        }
    }

    public boolean n(int i2) {
        return i2 >= b() && i2 <= i();
    }
}
