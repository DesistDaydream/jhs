package e.j.a.c.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes2.dex */
public abstract class c extends e.j.a.c.s.l {

    /* renamed from: g  reason: collision with root package name */
    private static final int f10882g = 1000;
    @NonNull
    private final TextInputLayout a;
    private final DateFormat b;

    /* renamed from: c  reason: collision with root package name */
    private final CalendarConstraints f10883c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10884d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f10885e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f10886f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = c.this.a;
            DateFormat dateFormat = c.this.b;
            Context context = textInputLayout.getContext();
            String string = context.getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.a);
            String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(o.t().getTimeInMillis())));
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            c.this.e();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public final /* synthetic */ long a;

        public b(long j2) {
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a.setError(String.format(c.this.f10884d, d.c(this.a)));
            c.this.e();
        }
    }

    public c(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.b = dateFormat;
        this.a = textInputLayout;
        this.f10883c = calendarConstraints;
        this.f10884d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f10885e = new a(str);
    }

    private Runnable d(long j2) {
        return new b(j2);
    }

    public void e() {
    }

    public abstract void f(@Nullable Long l2);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // e.j.a.c.s.l, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        this.a.removeCallbacks(this.f10885e);
        this.a.removeCallbacks(this.f10886f);
        this.a.setError(null);
        f(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date parse = this.b.parse(charSequence.toString());
            this.a.setError(null);
            long time = parse.getTime();
            if (this.f10883c.getDateValidator().isValid(time) && this.f10883c.isWithinBounds(time)) {
                f(Long.valueOf(parse.getTime()));
                return;
            }
            Runnable d2 = d(time);
            this.f10886f = d2;
            g(this.a, d2);
        } catch (ParseException unused) {
            g(this.a, this.f10885e);
        }
    }
}
