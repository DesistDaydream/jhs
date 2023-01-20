package e.j.a.c.f0;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: classes2.dex */
public class e implements ClockHandView.d, TimePickerView.g, TimePickerView.f, ClockHandView.c, g {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f10658f = {"12", "1", "2", "3", PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f10659g = {"00", "2", PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f10660h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: i  reason: collision with root package name */
    private static final int f10661i = 30;

    /* renamed from: j  reason: collision with root package name */
    private static final int f10662j = 6;
    private TimePickerView a;
    private TimeModel b;

    /* renamed from: c  reason: collision with root package name */
    private float f10663c;

    /* renamed from: d  reason: collision with root package name */
    private float f10664d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10665e = false;

    public e(TimePickerView timePickerView, TimeModel timeModel) {
        this.a = timePickerView;
        this.b = timeModel;
        a();
    }

    private int g() {
        return this.b.format == 1 ? 15 : 30;
    }

    private String[] h() {
        return this.b.format == 1 ? f10659g : f10658f;
    }

    private void i(int i2, int i3) {
        TimeModel timeModel = this.b;
        if (timeModel.minute == i3 && timeModel.hour == i2) {
            return;
        }
        this.a.performHapticFeedback(Build.VERSION.SDK_INT >= 21 ? 4 : 1);
    }

    private void k() {
        TimePickerView timePickerView = this.a;
        TimeModel timeModel = this.b;
        timePickerView.b(timeModel.period, timeModel.getHourForDisplay(), this.b.minute);
    }

    private void l() {
        m(f10658f, TimeModel.NUMBER_FORMAT);
        m(f10659g, TimeModel.NUMBER_FORMAT);
        m(f10660h, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void m(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = TimeModel.formatText(this.a.getResources(), strArr[i2], str);
        }
    }

    @Override // e.j.a.c.f0.g
    public void a() {
        if (this.b.format == 0) {
            this.a.t();
        }
        this.a.i(this);
        this.a.q(this);
        this.a.p(this);
        this.a.n(this);
        l();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void b(float f2, boolean z) {
        this.f10665e = true;
        TimeModel timeModel = this.b;
        int i2 = timeModel.minute;
        int i3 = timeModel.hour;
        if (timeModel.selection == 10) {
            this.a.k(this.f10664d, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.a.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                j(12, true);
            }
        } else {
            int round = Math.round(f2);
            if (!z) {
                this.b.setMinute(((round + 15) / 30) * 5);
                this.f10663c = this.b.minute * 6;
            }
            this.a.k(this.f10663c, z);
        }
        this.f10665e = false;
        k();
        i(i3, i2);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void c(int i2) {
        this.b.setPeriod(i2);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void d(int i2) {
        j(i2, true);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void e(float f2, boolean z) {
        if (this.f10665e) {
            return;
        }
        TimeModel timeModel = this.b;
        int i2 = timeModel.hour;
        int i3 = timeModel.minute;
        int round = Math.round(f2);
        TimeModel timeModel2 = this.b;
        if (timeModel2.selection == 12) {
            timeModel2.setMinute((round + 3) / 6);
            this.f10663c = (float) Math.floor(this.b.minute * 6);
        } else {
            this.b.setHour((round + (g() / 2)) / g());
            this.f10664d = this.b.getHourForDisplay() * g();
        }
        if (z) {
            return;
        }
        k();
        i(i2, i3);
    }

    @Override // e.j.a.c.f0.g
    public void f() {
        this.a.setVisibility(8);
    }

    @Override // e.j.a.c.f0.g
    public void invalidate() {
        this.f10664d = this.b.getHourForDisplay() * g();
        TimeModel timeModel = this.b;
        this.f10663c = timeModel.minute * 6;
        j(timeModel.selection, false);
        k();
    }

    public void j(int i2, boolean z) {
        boolean z2 = i2 == 12;
        this.a.j(z2);
        this.b.selection = i2;
        this.a.c(z2 ? f10660h : h(), z2 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.a.k(z2 ? this.f10663c : this.f10664d, z);
        this.a.a(i2);
        this.a.m(new a(this.a.getContext(), R.string.material_hour_selection));
        this.a.l(new a(this.a.getContext(), R.string.material_minute_selection));
    }

    @Override // e.j.a.c.f0.g
    public void show() {
        this.a.setVisibility(0);
    }
}
