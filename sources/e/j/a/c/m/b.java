package e.j.a.c.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes2.dex */
public final class b {
    @NonNull
    public final a a;
    @NonNull
    public final a b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final a f10876c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final a f10877d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final a f10878e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final a f10879f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final a f10880g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Paint f10881h;

    public b(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e.j.a.c.w.b.g(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.a = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f10880g = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.b = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f10876c = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a = e.j.a.c.w.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f10877d = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f10878e = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f10879f = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f10881h = paint;
        paint.setColor(a.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
