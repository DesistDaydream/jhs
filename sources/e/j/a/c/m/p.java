package e.j.a.c.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.Month;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public class p extends RecyclerView.Adapter<b> {
    private final MaterialCalendar<?> a;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.a.J(p.this.a.C().clamp(Month.create(this.a, p.this.a.E().month)));
            p.this.a.K(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        public final TextView a;

        public b(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }

    public p(MaterialCalendar<?> materialCalendar) {
        this.a = materialCalendar;
    }

    @NonNull
    private View.OnClickListener b(int i2) {
        return new a(i2);
    }

    public int c(int i2) {
        return i2 - this.a.C().getStart().year;
    }

    public int d(int i2) {
        return this.a.C().getStart().year + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        int d2 = d(i2);
        String string = bVar.a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        bVar.a.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(d2)));
        bVar.a.setContentDescription(String.format(string, Integer.valueOf(d2)));
        e.j.a.c.m.b D = this.a.D();
        Calendar t = o.t();
        e.j.a.c.m.a aVar = t.get(1) == d2 ? D.f10879f : D.f10877d;
        for (Long l2 : this.a.r().getSelectedDays()) {
            t.setTimeInMillis(l2.longValue());
            if (t.get(1) == d2) {
                aVar = D.f10878e;
            }
        }
        aVar.f(bVar.a);
        bVar.a.setOnClickListener(b(d2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.C().getYearSpan();
    }
}
