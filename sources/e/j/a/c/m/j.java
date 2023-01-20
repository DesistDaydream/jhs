package e.j.a.c.m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;

/* loaded from: classes2.dex */
public class j extends RecyclerView.Adapter<b> {
    private final Context a;
    @NonNull
    private final CalendarConstraints b;

    /* renamed from: c  reason: collision with root package name */
    private final DateSelector<?> f10915c;

    /* renamed from: d  reason: collision with root package name */
    private final MaterialCalendar.k f10916d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10917e;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ MaterialCalendarGridView a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (this.a.getAdapter2().n(i2)) {
                j.this.f10916d.a(this.a.getAdapter2().getItem(i2).longValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        public final TextView a;
        public final MaterialCalendarGridView b;

        public b(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public j(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.k kVar) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) <= 0) {
            if (openAt.compareTo(end) <= 0) {
                int F = i.f10911f * MaterialCalendar.F(context);
                int F2 = f.M(context) ? MaterialCalendar.F(context) : 0;
                this.a = context;
                this.f10917e = F + F2;
                this.b = calendarConstraints;
                this.f10915c = dateSelector;
                this.f10916d = kVar;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @NonNull
    public Month b(int i2) {
        return this.b.getStart().monthsLater(i2);
    }

    @NonNull
    public CharSequence c(int i2) {
        return b(i2).getLongName(this.a);
    }

    public int d(@NonNull Month month) {
        return this.b.getStart().monthsUntil(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        Month monthsLater = this.b.getStart().monthsLater(i2);
        bVar.a.setText(monthsLater.getLongName(bVar.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && monthsLater.equals(materialCalendarGridView.getAdapter2().a)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().m(materialCalendarGridView);
        } else {
            i iVar = new i(monthsLater, this.f10915c, this.b);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) iVar);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (f.M(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f10917e));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.b.getStart().monthsLater(i2).getStableId();
    }
}
