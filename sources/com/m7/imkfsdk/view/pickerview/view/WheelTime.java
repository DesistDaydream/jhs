package com.m7.imkfsdk.view.pickerview.view;

import android.content.Context;
import android.view.View;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.TimePickerView;
import com.m7.imkfsdk.view.pickerview.adapter.NumericWheelAdapter;
import com.m7.imkfsdk.view.pickerview.lib.WheelView;
import com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class WheelTime {
    public static final int DEFULT_END_YEAR = 2100;
    public static final int DEFULT_START_YEAR = 1990;
    public static DateFormat dateFormat = new SimpleDateFormat(b0.a.f14659j);
    private int endYear;
    private int startYear;
    private TimePickerView.Type type;
    private View view;
    private WheelView wv_day;
    private WheelView wv_hours;
    private WheelView wv_mins;
    private WheelView wv_month;
    private WheelView wv_year;

    /* renamed from: com.m7.imkfsdk.view.pickerview.view.WheelTime$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type;

        static {
            int[] iArr = new int[TimePickerView.Type.values().length];
            $SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type = iArr;
            try {
                iArr[TimePickerView.Type.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type[TimePickerView.Type.YEAR_MONTH_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type[TimePickerView.Type.HOURS_MINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type[TimePickerView.Type.MONTH_DAY_HOUR_MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type[TimePickerView.Type.YEAR_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WheelTime(View view) {
        this.startYear = DEFULT_START_YEAR;
        this.endYear = 2100;
        this.view = view;
        this.type = TimePickerView.Type.ALL;
        setView(view);
    }

    public int getEndYear() {
        return this.endYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public String getTime() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.wv_month.getCurrentItem() + 1);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.wv_day.getCurrentItem() + 1);
        stringBuffer.append(ExpandableTextView.N);
        stringBuffer.append(this.wv_hours.getCurrentItem());
        stringBuffer.append(Constants.COLON_SEPARATOR);
        stringBuffer.append(this.wv_mins.getCurrentItem());
        return stringBuffer.toString();
    }

    public View getView() {
        return this.view;
    }

    public void setCyclic(boolean z) {
        this.wv_year.setCyclic(z);
        this.wv_month.setCyclic(z);
        this.wv_day.setCyclic(z);
        this.wv_hours.setCyclic(z);
        this.wv_mins.setCyclic(z);
    }

    public void setEndYear(int i2) {
        this.endYear = i2;
    }

    public void setPicker(int i2, int i3, int i4) {
        setPicker(i2, i3, i4, 0, 0);
    }

    public void setStartYear(int i2) {
        this.startYear = i2;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setPicker(int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "6", "9", "11"};
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList(strArr);
        Context context = this.view.getContext();
        WheelView wheelView = (WheelView) this.view.findViewById(R.id.year);
        this.wv_year = wheelView;
        wheelView.setAdapter(new NumericWheelAdapter(this.startYear, this.endYear));
        this.wv_year.setLabel(context.getString(R.string.ykfsdk_pickerview_year));
        this.wv_year.setCurrentItem(i2 - this.startYear);
        WheelView wheelView2 = (WheelView) this.view.findViewById(R.id.month);
        this.wv_month = wheelView2;
        wheelView2.setAdapter(new NumericWheelAdapter(1, 12));
        this.wv_month.setLabel(context.getString(R.string.ykfsdk_pickerview_month));
        this.wv_month.setCurrentItem(i3);
        this.wv_day = (WheelView) this.view.findViewById(R.id.day);
        int i7 = i3 + 1;
        if (asList.contains(String.valueOf(i7))) {
            this.wv_day.setAdapter(new NumericWheelAdapter(1, 31));
        } else if (asList2.contains(String.valueOf(i7))) {
            this.wv_day.setAdapter(new NumericWheelAdapter(1, 30));
        } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
            this.wv_day.setAdapter(new NumericWheelAdapter(1, 29));
        } else {
            this.wv_day.setAdapter(new NumericWheelAdapter(1, 28));
        }
        this.wv_day.setLabel(context.getString(R.string.ykfsdk_pickerview_day));
        this.wv_day.setCurrentItem(i4 - 1);
        WheelView wheelView3 = (WheelView) this.view.findViewById(R.id.hour);
        this.wv_hours = wheelView3;
        wheelView3.setAdapter(new NumericWheelAdapter(0, 23));
        this.wv_hours.setLabel(context.getString(R.string.ykfsdk_pickerview_hours));
        this.wv_hours.setCurrentItem(i5);
        WheelView wheelView4 = (WheelView) this.view.findViewById(R.id.min);
        this.wv_mins = wheelView4;
        wheelView4.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_mins.setLabel(context.getString(R.string.ykfsdk_pickerview_minutes));
        this.wv_mins.setCurrentItem(i6);
        OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.WheelTime.1
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i8) {
                int i9 = i8 + WheelTime.this.startYear;
                int i10 = 28;
                if (asList.contains(String.valueOf(WheelTime.this.wv_month.getCurrentItem() + 1))) {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                    i10 = 31;
                } else if (asList2.contains(String.valueOf(WheelTime.this.wv_month.getCurrentItem() + 1))) {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                    i10 = 30;
                } else if ((i9 % 4 != 0 || i9 % 100 == 0) && i9 % 400 != 0) {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                } else {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                    i10 = 29;
                }
                int i11 = i10 - 1;
                if (WheelTime.this.wv_day.getCurrentItem() > i11) {
                    WheelTime.this.wv_day.setCurrentItem(i11);
                }
            }
        };
        OnItemSelectedListener onItemSelectedListener2 = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.WheelTime.2
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i8) {
                int i9 = i8 + 1;
                int i10 = 28;
                if (asList.contains(String.valueOf(i9))) {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                    i10 = 31;
                } else if (asList2.contains(String.valueOf(i9))) {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                    i10 = 30;
                } else if (((WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear) % 4 != 0 || (WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear) % 100 == 0) && (WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear) % 400 != 0) {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                } else {
                    WheelTime.this.wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                    i10 = 29;
                }
                int i11 = i10 - 1;
                if (WheelTime.this.wv_day.getCurrentItem() > i11) {
                    WheelTime.this.wv_day.setCurrentItem(i11);
                }
            }
        };
        this.wv_year.setOnItemSelectedListener(onItemSelectedListener);
        this.wv_month.setOnItemSelectedListener(onItemSelectedListener2);
        int i8 = 6;
        int i9 = AnonymousClass3.$SwitchMap$com$m7$imkfsdk$view$pickerview$TimePickerView$Type[this.type.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                this.wv_hours.setVisibility(8);
                this.wv_mins.setVisibility(8);
            } else if (i9 == 3) {
                this.wv_year.setVisibility(8);
                this.wv_month.setVisibility(8);
                this.wv_day.setVisibility(8);
            } else if (i9 == 4) {
                this.wv_year.setVisibility(8);
            } else {
                if (i9 == 5) {
                    this.wv_day.setVisibility(8);
                    this.wv_hours.setVisibility(8);
                    this.wv_mins.setVisibility(8);
                }
                float f2 = i8;
                this.wv_day.setTextSize(f2);
                this.wv_month.setTextSize(f2);
                this.wv_year.setTextSize(f2);
                this.wv_hours.setTextSize(f2);
                this.wv_mins.setTextSize(f2);
            }
            i8 = 24;
            float f22 = i8;
            this.wv_day.setTextSize(f22);
            this.wv_month.setTextSize(f22);
            this.wv_year.setTextSize(f22);
            this.wv_hours.setTextSize(f22);
            this.wv_mins.setTextSize(f22);
        }
        i8 = 18;
        float f222 = i8;
        this.wv_day.setTextSize(f222);
        this.wv_month.setTextSize(f222);
        this.wv_year.setTextSize(f222);
        this.wv_hours.setTextSize(f222);
        this.wv_mins.setTextSize(f222);
    }

    public WheelTime(View view, TimePickerView.Type type) {
        this.startYear = DEFULT_START_YEAR;
        this.endYear = 2100;
        this.view = view;
        this.type = type;
        setView(view);
    }
}
