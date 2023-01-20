package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aigestudio.wheelpicker.R;
import com.aigestudio.wheelpicker.WheelPicker;
import com.xiaomi.mipush.sdk.Constants;
import e.a.a.b;
import e.a.a.c;
import e.a.a.d.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class WheelDatePicker extends LinearLayout implements WheelPicker.a, b, c, e.a.a.d.a, d, e.a.a.d.c, e.a.a.d.b {

    /* renamed from: k  reason: collision with root package name */
    private static final SimpleDateFormat f1389k = new SimpleDateFormat("yyyy-M-d", Locale.getDefault());
    private WheelYearPicker a;
    private WheelMonthPicker b;

    /* renamed from: c  reason: collision with root package name */
    private WheelDayPicker f1390c;

    /* renamed from: d  reason: collision with root package name */
    private a f1391d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f1392e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f1393f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f1394g;

    /* renamed from: h  reason: collision with root package name */
    private int f1395h;

    /* renamed from: i  reason: collision with root package name */
    private int f1396i;

    /* renamed from: j  reason: collision with root package name */
    private int f1397j;

    /* loaded from: classes.dex */
    public interface a {
        void a(WheelDatePicker wheelDatePicker, Date date);
    }

    public WheelDatePicker(Context context) {
        this(context, null);
    }

    private void j() {
        List data = this.a.getData();
        String valueOf = String.valueOf(data.get(data.size() - 1));
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < valueOf.length(); i2++) {
            sb.append("0");
        }
        this.a.setMaximumWidthText(sb.toString());
    }

    @Override // e.a.a.c
    @Deprecated
    public boolean a() {
        throw new UnsupportedOperationException("You don't need to set same width forWheelDatePicker");
    }

    @Override // e.a.a.c
    public boolean b() {
        return this.a.b() && this.b.b() && this.f1390c.b();
    }

    @Override // e.a.a.c
    public boolean c() {
        return this.a.c() && this.b.c() && this.f1390c.c();
    }

    @Override // e.a.a.d.b
    public void d(int i2, int i3) {
        this.f1395h = i2;
        this.f1396i = i3;
        this.a.setSelectedYear(i2);
        this.b.setSelectedMonth(i3);
        this.f1390c.d(i2, i3);
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker.a
    public void e(WheelPicker wheelPicker, Object obj, int i2) {
        if (wheelPicker.getId() == R.id.wheel_date_picker_year) {
            int intValue = ((Integer) obj).intValue();
            this.f1395h = intValue;
            this.f1390c.setYear(intValue);
        } else if (wheelPicker.getId() == R.id.wheel_date_picker_month) {
            int intValue2 = ((Integer) obj).intValue();
            this.f1396i = intValue2;
            this.f1390c.setMonth(intValue2);
        }
        this.f1397j = this.f1390c.getCurrentDay();
        String str = this.f1395h + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1396i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1397j;
        a aVar = this.f1391d;
        if (aVar != null) {
            try {
                aVar.a(this, f1389k.parse(str));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // e.a.a.d.d
    public void f(int i2, int i3) {
        this.a.f(i2, i3);
    }

    @Override // e.a.a.c
    public boolean g() {
        return this.a.g() && this.b.g() && this.f1390c.g();
    }

    @Override // e.a.a.d.a
    public Date getCurrentDate() {
        try {
            return f1389k.parse(this.f1395h + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1396i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f1397j);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // e.a.a.d.b
    public int getCurrentDay() {
        return this.f1390c.getCurrentDay();
    }

    @Override // e.a.a.c
    @Deprecated
    public int getCurrentItemPosition() {
        throw new UnsupportedOperationException("You can not get position of current item fromWheelDatePicker");
    }

    @Override // e.a.a.d.c
    public int getCurrentMonth() {
        return this.b.getCurrentMonth();
    }

    @Override // e.a.a.d.d
    public int getCurrentYear() {
        return this.a.getCurrentYear();
    }

    @Override // e.a.a.c
    public int getCurtainColor() {
        if (this.a.getCurtainColor() == this.b.getCurtainColor() && this.b.getCurtainColor() == this.f1390c.getCurtainColor()) {
            return this.a.getCurtainColor();
        }
        throw new RuntimeException("Can not get curtain color correctly from WheelDatePicker!");
    }

    @Override // e.a.a.c
    @Deprecated
    public List getData() {
        throw new UnsupportedOperationException("You can not get data source from WheelDatePicker");
    }

    @Override // e.a.a.c
    public int getIndicatorColor() {
        if (this.a.getCurtainColor() == this.b.getCurtainColor() && this.b.getCurtainColor() == this.f1390c.getCurtainColor()) {
            return this.a.getCurtainColor();
        }
        throw new RuntimeException("Can not get indicator color correctly from WheelDatePicker!");
    }

    @Override // e.a.a.c
    public int getIndicatorSize() {
        if (this.a.getIndicatorSize() == this.b.getIndicatorSize() && this.b.getIndicatorSize() == this.f1390c.getIndicatorSize()) {
            return this.a.getIndicatorSize();
        }
        throw new RuntimeException("Can not get indicator size correctly from WheelDatePicker!");
    }

    @Override // e.a.a.c
    @Deprecated
    public int getItemAlign() {
        throw new UnsupportedOperationException("You can not get item align from WheelDatePicker");
    }

    @Override // e.a.a.d.a
    public int getItemAlignDay() {
        return this.f1390c.getItemAlign();
    }

    @Override // e.a.a.d.a
    public int getItemAlignMonth() {
        return this.b.getItemAlign();
    }

    @Override // e.a.a.d.a
    public int getItemAlignYear() {
        return this.a.getItemAlign();
    }

    @Override // e.a.a.c
    public int getItemSpace() {
        if (this.a.getItemSpace() == this.b.getItemSpace() && this.b.getItemSpace() == this.f1390c.getItemSpace()) {
            return this.a.getItemSpace();
        }
        throw new RuntimeException("Can not get item space correctly from WheelDatePicker!");
    }

    @Override // e.a.a.c
    public int getItemTextColor() {
        if (this.a.getItemTextColor() == this.b.getItemTextColor() && this.b.getItemTextColor() == this.f1390c.getItemTextColor()) {
            return this.a.getItemTextColor();
        }
        throw new RuntimeException("Can not get color of item text correctly fromWheelDatePicker!");
    }

    @Override // e.a.a.c
    public int getItemTextSize() {
        if (this.a.getItemTextSize() == this.b.getItemTextSize() && this.b.getItemTextSize() == this.f1390c.getItemTextSize()) {
            return this.a.getItemTextSize();
        }
        throw new RuntimeException("Can not get size of item text correctly fromWheelDatePicker!");
    }

    @Override // e.a.a.c
    @Deprecated
    public String getMaximumWidthText() {
        throw new UnsupportedOperationException("You can not get maximum width text fromWheelDatePicker");
    }

    @Override // e.a.a.c
    @Deprecated
    public int getMaximumWidthTextPosition() {
        throw new UnsupportedOperationException("You can not get maximum width text positionfrom WheelDatePicker");
    }

    @Override // e.a.a.d.b
    public int getMonth() {
        return getSelectedMonth();
    }

    @Override // e.a.a.d.b
    public int getSelectedDay() {
        return this.f1390c.getSelectedDay();
    }

    @Override // e.a.a.c
    @Deprecated
    public int getSelectedItemPosition() {
        throw new UnsupportedOperationException("You can not get position of selected item fromWheelDatePicker");
    }

    @Override // e.a.a.c
    public int getSelectedItemTextColor() {
        if (this.a.getSelectedItemTextColor() == this.b.getSelectedItemTextColor() && this.b.getSelectedItemTextColor() == this.f1390c.getSelectedItemTextColor()) {
            return this.a.getSelectedItemTextColor();
        }
        throw new RuntimeException("Can not get color of selected item text correctly fromWheelDatePicker!");
    }

    @Override // e.a.a.d.c
    public int getSelectedMonth() {
        return this.b.getSelectedMonth();
    }

    @Override // e.a.a.d.d
    public int getSelectedYear() {
        return this.a.getSelectedYear();
    }

    @Override // e.a.a.d.a
    public TextView getTextViewDay() {
        return this.f1394g;
    }

    @Override // e.a.a.d.a
    public TextView getTextViewMonth() {
        return this.f1393f;
    }

    @Override // e.a.a.d.a
    public TextView getTextViewYear() {
        return this.f1392e;
    }

    @Override // e.a.a.c
    public Typeface getTypeface() {
        if (this.a.getTypeface().equals(this.b.getTypeface()) && this.b.getTypeface().equals(this.f1390c.getTypeface())) {
            return this.a.getTypeface();
        }
        throw new RuntimeException("Can not get typeface correctly from WheelDatePicker!");
    }

    @Override // e.a.a.c
    public int getVisibleItemCount() {
        if (this.a.getVisibleItemCount() == this.b.getVisibleItemCount() && this.b.getVisibleItemCount() == this.f1390c.getVisibleItemCount()) {
            return this.a.getVisibleItemCount();
        }
        throw new ArithmeticException("Can not get visible item count correctly fromWheelDatePicker!");
    }

    @Override // e.a.a.d.a
    public WheelDayPicker getWheelDayPicker() {
        return this.f1390c;
    }

    @Override // e.a.a.d.a
    public WheelMonthPicker getWheelMonthPicker() {
        return this.b;
    }

    @Override // e.a.a.d.a
    public WheelYearPicker getWheelYearPicker() {
        return this.a;
    }

    @Override // e.a.a.d.b
    public int getYear() {
        return getSelectedYear();
    }

    @Override // e.a.a.d.d
    public int getYearEnd() {
        return this.a.getYearEnd();
    }

    @Override // e.a.a.d.d
    public int getYearStart() {
        return this.a.getYearStart();
    }

    @Override // e.a.a.c
    public boolean h() {
        return this.a.h() && this.b.h() && this.f1390c.h();
    }

    @Override // e.a.a.c
    public boolean i() {
        return this.a.i() && this.b.i() && this.f1390c.i();
    }

    @Override // e.a.a.c
    public void setAtmospheric(boolean z) {
        this.a.setAtmospheric(z);
        this.b.setAtmospheric(z);
        this.f1390c.setAtmospheric(z);
    }

    @Override // e.a.a.c
    public void setCurtain(boolean z) {
        this.a.setCurtain(z);
        this.b.setCurtain(z);
        this.f1390c.setCurtain(z);
    }

    @Override // e.a.a.c
    public void setCurtainColor(int i2) {
        this.a.setCurtainColor(i2);
        this.b.setCurtainColor(i2);
        this.f1390c.setCurtainColor(i2);
    }

    @Override // e.a.a.c
    public void setCurved(boolean z) {
        this.a.setCurved(z);
        this.b.setCurved(z);
        this.f1390c.setCurved(z);
    }

    @Override // e.a.a.c
    public void setCyclic(boolean z) {
        this.a.setCyclic(z);
        this.b.setCyclic(z);
        this.f1390c.setCyclic(z);
    }

    @Override // e.a.a.c
    @Deprecated
    public void setData(List list) {
        throw new UnsupportedOperationException("You don't need to set data source forWheelDatePicker");
    }

    @Override // e.a.a.b
    public void setDebug(boolean z) {
        this.a.setDebug(z);
        this.b.setDebug(z);
        this.f1390c.setDebug(z);
    }

    @Override // e.a.a.c
    public void setIndicator(boolean z) {
        this.a.setIndicator(z);
        this.b.setIndicator(z);
        this.f1390c.setIndicator(z);
    }

    @Override // e.a.a.c
    public void setIndicatorColor(int i2) {
        this.a.setIndicatorColor(i2);
        this.b.setIndicatorColor(i2);
        this.f1390c.setIndicatorColor(i2);
    }

    @Override // e.a.a.c
    public void setIndicatorSize(int i2) {
        this.a.setIndicatorSize(i2);
        this.b.setIndicatorSize(i2);
        this.f1390c.setIndicatorSize(i2);
    }

    @Override // e.a.a.c
    @Deprecated
    public void setItemAlign(int i2) {
        throw new UnsupportedOperationException("You don't need to set item align forWheelDatePicker");
    }

    @Override // e.a.a.d.a
    public void setItemAlignDay(int i2) {
        this.f1390c.setItemAlign(i2);
    }

    @Override // e.a.a.d.a
    public void setItemAlignMonth(int i2) {
        this.b.setItemAlign(i2);
    }

    @Override // e.a.a.d.a
    public void setItemAlignYear(int i2) {
        this.a.setItemAlign(i2);
    }

    @Override // e.a.a.c
    public void setItemSpace(int i2) {
        this.a.setItemSpace(i2);
        this.b.setItemSpace(i2);
        this.f1390c.setItemSpace(i2);
    }

    @Override // e.a.a.c
    public void setItemTextColor(int i2) {
        this.a.setItemTextColor(i2);
        this.b.setItemTextColor(i2);
        this.f1390c.setItemTextColor(i2);
    }

    @Override // e.a.a.c
    public void setItemTextSize(int i2) {
        this.a.setItemTextSize(i2);
        this.b.setItemTextSize(i2);
        this.f1390c.setItemTextSize(i2);
    }

    @Override // e.a.a.c
    @Deprecated
    public void setMaximumWidthText(String str) {
        throw new UnsupportedOperationException("You don't need to set maximum width text forWheelDatePicker");
    }

    @Override // e.a.a.c
    @Deprecated
    public void setMaximumWidthTextPosition(int i2) {
        throw new UnsupportedOperationException("You don't need to set maximum width textposition for WheelDatePicker");
    }

    @Override // e.a.a.d.b
    public void setMonth(int i2) {
        this.f1396i = i2;
        this.b.setSelectedMonth(i2);
        this.f1390c.setMonth(i2);
    }

    @Override // e.a.a.d.a
    public void setOnDateSelectedListener(a aVar) {
        this.f1391d = aVar;
    }

    @Override // e.a.a.c
    @Deprecated
    public void setOnItemSelectedListener(WheelPicker.a aVar) {
        throw new UnsupportedOperationException("You can not set OnItemSelectedListener forWheelDatePicker");
    }

    @Override // e.a.a.c
    @Deprecated
    public void setOnWheelChangeListener(WheelPicker.b bVar) {
        throw new UnsupportedOperationException("WheelDatePicker unsupport setOnWheelChangeListener");
    }

    @Override // e.a.a.c
    @Deprecated
    public void setSameWidth(boolean z) {
        throw new UnsupportedOperationException("You don't need to set same width forWheelDatePicker");
    }

    @Override // e.a.a.d.b
    public void setSelectedDay(int i2) {
        this.f1397j = i2;
        this.f1390c.setSelectedDay(i2);
    }

    @Override // e.a.a.c
    @Deprecated
    public void setSelectedItemPosition(int i2) {
        throw new UnsupportedOperationException("You can not set position of selected item forWheelDatePicker");
    }

    @Override // e.a.a.c
    public void setSelectedItemTextColor(int i2) {
        this.a.setSelectedItemTextColor(i2);
        this.b.setSelectedItemTextColor(i2);
        this.f1390c.setSelectedItemTextColor(i2);
    }

    @Override // e.a.a.d.c
    public void setSelectedMonth(int i2) {
        this.f1396i = i2;
        this.b.setSelectedMonth(i2);
        this.f1390c.setMonth(i2);
    }

    @Override // e.a.a.d.d
    public void setSelectedYear(int i2) {
        this.f1395h = i2;
        this.a.setSelectedYear(i2);
        this.f1390c.setYear(i2);
    }

    @Override // e.a.a.c
    public void setTypeface(Typeface typeface) {
        this.a.setTypeface(typeface);
        this.b.setTypeface(typeface);
        this.f1390c.setTypeface(typeface);
    }

    @Override // e.a.a.c
    public void setVisibleItemCount(int i2) {
        this.a.setVisibleItemCount(i2);
        this.b.setVisibleItemCount(i2);
        this.f1390c.setVisibleItemCount(i2);
    }

    @Override // e.a.a.d.b
    public void setYear(int i2) {
        this.f1395h = i2;
        this.a.setSelectedYear(i2);
        this.f1390c.setYear(i2);
    }

    @Override // e.a.a.d.d
    public void setYearEnd(int i2) {
        this.a.setYearEnd(i2);
    }

    @Override // e.a.a.d.d
    public void setYearStart(int i2) {
        this.a.setYearStart(i2);
    }

    public WheelDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.view_wheel_date_picker, this);
        this.a = (WheelYearPicker) findViewById(R.id.wheel_date_picker_year);
        this.b = (WheelMonthPicker) findViewById(R.id.wheel_date_picker_month);
        this.f1390c = (WheelDayPicker) findViewById(R.id.wheel_date_picker_day);
        this.a.setOnItemSelectedListener(this);
        this.b.setOnItemSelectedListener(this);
        this.f1390c.setOnItemSelectedListener(this);
        j();
        this.b.setMaximumWidthText("00");
        this.f1390c.setMaximumWidthText("00");
        this.f1392e = (TextView) findViewById(R.id.wheel_date_picker_year_tv);
        this.f1393f = (TextView) findViewById(R.id.wheel_date_picker_month_tv);
        this.f1394g = (TextView) findViewById(R.id.wheel_date_picker_day_tv);
        this.f1395h = this.a.getCurrentYear();
        this.f1396i = this.b.getCurrentMonth();
        this.f1397j = this.f1390c.getCurrentDay();
    }
}
