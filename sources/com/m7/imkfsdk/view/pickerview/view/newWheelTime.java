package com.m7.imkfsdk.view.pickerview.view;

import android.view.View;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.adapter.ArrayWheelAdapter;
import com.m7.imkfsdk.view.pickerview.adapter.NumericWheelAdapter;
import com.m7.imkfsdk.view.pickerview.lib.newWheelView;
import com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener;
import com.m7.imkfsdk.view.pickerview.utils.ChinaDate;
import com.m7.imkfsdk.view.pickerview.utils.LunarCalendar;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import e.t.u.b0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class newWheelTime {
    private static final int DEFAULT_END_DAY = 31;
    private static final int DEFAULT_END_MONTH = 11;
    private static final int DEFAULT_END_YEAR = 2050;
    private static final int DEFAULT_START_DAY = 1;
    private static final int DEFAULT_START_MONTH = 0;
    private static final int DEFAULT_START_YEAR = 2013;
    public static DateFormat dateFormat = new SimpleDateFormat(b0.a.f14658i);
    private int currentYear;
    public int dividerColor;
    private newWheelView.DividerType dividerType;
    private int endDay;
    private int endMonth;
    private int endYear;
    private int gravity;
    private boolean isLunarCalendar;
    public float lineSpacingMultiplier;
    private int startDay;
    private int startMonth;
    private int startYear;
    public int textColorCenter;
    public int textColorOut;
    private int textSize;
    private boolean[] type;
    private View view;
    private newWheelView wv_day;
    private newWheelView wv_hours;
    private newWheelView wv_mins;
    private newWheelView wv_month;
    private newWheelView wv_seconds;
    private newWheelView wv_year;

    public newWheelTime(View view) {
        this.startYear = DEFAULT_START_YEAR;
        this.endYear = 2050;
        this.startMonth = 0;
        this.endMonth = 11;
        this.startDay = 1;
        this.endDay = 31;
        this.textSize = 18;
        this.lineSpacingMultiplier = 1.6f;
        this.isLunarCalendar = false;
        this.view = view;
        this.type = new boolean[]{true, true, true, true, true, true};
        setView(view);
    }

    private String getLunarTime() {
        int currentItem;
        boolean z;
        int currentItem2;
        StringBuffer stringBuffer = new StringBuffer();
        int currentItem3 = this.wv_year.getCurrentItem() + this.startYear;
        if (ChinaDate.leapMonth(currentItem3) == 0) {
            currentItem2 = this.wv_month.getCurrentItem();
        } else if ((this.wv_month.getCurrentItem() + 1) - ChinaDate.leapMonth(currentItem3) <= 0) {
            currentItem2 = this.wv_month.getCurrentItem();
        } else if ((this.wv_month.getCurrentItem() + 1) - ChinaDate.leapMonth(currentItem3) == 1) {
            currentItem = this.wv_month.getCurrentItem();
            z = true;
            int[] lunarToSolar = LunarCalendar.lunarToSolar(currentItem3, currentItem, this.wv_day.getCurrentItem() + 1, z);
            stringBuffer.append(lunarToSolar[0]);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(lunarToSolar[1]);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(lunarToSolar[2]);
            stringBuffer.append(ExpandableTextView.N);
            stringBuffer.append(this.wv_hours.getCurrentItem());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(this.wv_mins.getCurrentItem());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(this.wv_seconds.getCurrentItem());
            return stringBuffer.toString();
        } else {
            currentItem = this.wv_month.getCurrentItem();
            z = false;
            int[] lunarToSolar2 = LunarCalendar.lunarToSolar(currentItem3, currentItem, this.wv_day.getCurrentItem() + 1, z);
            stringBuffer.append(lunarToSolar2[0]);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(lunarToSolar2[1]);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(lunarToSolar2[2]);
            stringBuffer.append(ExpandableTextView.N);
            stringBuffer.append(this.wv_hours.getCurrentItem());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(this.wv_mins.getCurrentItem());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(this.wv_seconds.getCurrentItem());
            return stringBuffer.toString();
        }
        currentItem = currentItem2 + 1;
        z = false;
        int[] lunarToSolar22 = LunarCalendar.lunarToSolar(currentItem3, currentItem, this.wv_day.getCurrentItem() + 1, z);
        stringBuffer.append(lunarToSolar22[0]);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(lunarToSolar22[1]);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(lunarToSolar22[2]);
        stringBuffer.append(ExpandableTextView.N);
        stringBuffer.append(this.wv_hours.getCurrentItem());
        stringBuffer.append(Constants.COLON_SEPARATOR);
        stringBuffer.append(this.wv_mins.getCurrentItem());
        stringBuffer.append(Constants.COLON_SEPARATOR);
        stringBuffer.append(this.wv_seconds.getCurrentItem());
        return stringBuffer.toString();
    }

    private void setContentTextSize() {
        this.wv_day.setTextSize(this.textSize);
        this.wv_month.setTextSize(this.textSize);
        this.wv_year.setTextSize(this.textSize);
        this.wv_hours.setTextSize(this.textSize);
        this.wv_mins.setTextSize(this.textSize);
        this.wv_seconds.setTextSize(this.textSize);
    }

    private void setDividerColor() {
        this.wv_day.setDividerColor(this.dividerColor);
        this.wv_month.setDividerColor(this.dividerColor);
        this.wv_year.setDividerColor(this.dividerColor);
        this.wv_hours.setDividerColor(this.dividerColor);
        this.wv_mins.setDividerColor(this.dividerColor);
        this.wv_seconds.setDividerColor(this.dividerColor);
    }

    private void setDividerType() {
        this.wv_day.setDividerType(this.dividerType);
        this.wv_month.setDividerType(this.dividerType);
        this.wv_year.setDividerType(this.dividerType);
        this.wv_hours.setDividerType(this.dividerType);
        this.wv_mins.setDividerType(this.dividerType);
        this.wv_seconds.setDividerType(this.dividerType);
    }

    private void setLineSpacingMultiplier() {
        this.wv_day.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_month.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_year.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_hours.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_mins.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_seconds.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    private void setLunar(int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        newWheelView newwheelview = (newWheelView) this.view.findViewById(R.id.year);
        this.wv_year = newwheelview;
        newwheelview.setAdapter(new ArrayWheelAdapter(ChinaDate.getYears(this.startYear, this.endYear)));
        this.wv_year.setLabel("");
        this.wv_year.setCurrentItem(i2 - this.startYear);
        this.wv_year.setGravity(this.gravity);
        newWheelView newwheelview2 = (newWheelView) this.view.findViewById(R.id.month);
        this.wv_month = newwheelview2;
        newwheelview2.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(i2)));
        this.wv_month.setLabel("");
        this.wv_month.setCurrentItem(i3);
        this.wv_month.setGravity(this.gravity);
        this.wv_day = (newWheelView) this.view.findViewById(R.id.day);
        if (ChinaDate.leapMonth(i2) == 0) {
            this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i2, i3))));
        } else {
            this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(i2))));
        }
        this.wv_day.setLabel("");
        this.wv_day.setCurrentItem(i4 - 1);
        this.wv_day.setGravity(this.gravity);
        newWheelView newwheelview3 = (newWheelView) this.view.findViewById(R.id.hour);
        this.wv_hours = newwheelview3;
        newwheelview3.setAdapter(new NumericWheelAdapter(0, 23));
        this.wv_hours.setCurrentItem(i5);
        this.wv_hours.setGravity(this.gravity);
        newWheelView newwheelview4 = (newWheelView) this.view.findViewById(R.id.min);
        this.wv_mins = newwheelview4;
        newwheelview4.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_mins.setCurrentItem(i6);
        this.wv_mins.setGravity(this.gravity);
        newWheelView newwheelview5 = (newWheelView) this.view.findViewById(R.id.second);
        this.wv_seconds = newwheelview5;
        newwheelview5.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_seconds.setCurrentItem(i6);
        this.wv_seconds.setGravity(this.gravity);
        OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newWheelTime.1
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i8) {
                int monthDays;
                int i9 = i8 + newWheelTime.this.startYear;
                newWheelTime.this.wv_month.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(i9)));
                if (ChinaDate.leapMonth(i9) == 0 || newWheelTime.this.wv_month.getCurrentItem() <= ChinaDate.leapMonth(i9) - 1) {
                    newWheelTime.this.wv_month.setCurrentItem(newWheelTime.this.wv_month.getCurrentItem());
                } else {
                    newWheelTime.this.wv_month.setCurrentItem(newWheelTime.this.wv_month.getCurrentItem() + 1);
                }
                if (ChinaDate.leapMonth(i9) == 0 || newWheelTime.this.wv_month.getCurrentItem() <= ChinaDate.leapMonth(i9) - 1) {
                    newWheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i9, newWheelTime.this.wv_month.getCurrentItem() + 1))));
                    monthDays = ChinaDate.monthDays(i9, newWheelTime.this.wv_month.getCurrentItem() + 1);
                } else if (newWheelTime.this.wv_month.getCurrentItem() == ChinaDate.leapMonth(i9) + 1) {
                    newWheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(i9))));
                    monthDays = ChinaDate.leapDays(i9);
                } else {
                    newWheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i9, newWheelTime.this.wv_month.getCurrentItem()))));
                    monthDays = ChinaDate.monthDays(i9, newWheelTime.this.wv_month.getCurrentItem());
                }
                int i10 = monthDays - 1;
                if (newWheelTime.this.wv_day.getCurrentItem() > i10) {
                    newWheelTime.this.wv_day.setCurrentItem(i10);
                }
            }
        };
        OnItemSelectedListener onItemSelectedListener2 = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newWheelTime.2
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i8) {
                int monthDays;
                int currentItem = newWheelTime.this.wv_year.getCurrentItem() + newWheelTime.this.startYear;
                if (ChinaDate.leapMonth(currentItem) == 0 || i8 <= ChinaDate.leapMonth(currentItem) - 1) {
                    int i9 = i8 + 1;
                    newWheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i9))));
                    monthDays = ChinaDate.monthDays(currentItem, i9);
                } else if (newWheelTime.this.wv_month.getCurrentItem() == ChinaDate.leapMonth(currentItem) + 1) {
                    newWheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(currentItem))));
                    monthDays = ChinaDate.leapDays(currentItem);
                } else {
                    newWheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i8))));
                    monthDays = ChinaDate.monthDays(currentItem, i8);
                }
                int i10 = monthDays - 1;
                if (newWheelTime.this.wv_day.getCurrentItem() > i10) {
                    newWheelTime.this.wv_day.setCurrentItem(i10);
                }
            }
        };
        this.wv_year.setOnItemSelectedListener(onItemSelectedListener);
        this.wv_month.setOnItemSelectedListener(onItemSelectedListener2);
        boolean[] zArr = this.type;
        if (zArr.length == 6) {
            this.wv_year.setVisibility(zArr[0] ? 0 : 8);
            this.wv_month.setVisibility(this.type[1] ? 0 : 8);
            this.wv_day.setVisibility(this.type[2] ? 0 : 8);
            this.wv_hours.setVisibility(this.type[3] ? 0 : 8);
            this.wv_mins.setVisibility(this.type[4] ? 0 : 8);
            this.wv_seconds.setVisibility(this.type[5] ? 0 : 8);
            setContentTextSize();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReDay(int i2, int i3, int i4, int i5, List<String> list, List<String> list2) {
        int currentItem = this.wv_day.getCurrentItem();
        if (list.contains(String.valueOf(i3))) {
            if (i5 > 31) {
                i5 = 31;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i4, i5));
        } else if (list2.contains(String.valueOf(i3))) {
            if (i5 > 30) {
                i5 = 30;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i4, i5));
        } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
            if (i5 > 29) {
                i5 = 29;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i4, i5));
        } else {
            if (i5 > 28) {
                i5 = 28;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i4, i5));
        }
        if (currentItem > this.wv_day.getAdapter().getItemsCount() - 1) {
            this.wv_day.setCurrentItem(this.wv_day.getAdapter().getItemsCount() - 1);
        }
    }

    private void setSolar(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        String[] strArr = {PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "6", "9", "11"};
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList(strArr);
        this.currentYear = i2;
        newWheelView newwheelview = (newWheelView) this.view.findViewById(R.id.year);
        this.wv_year = newwheelview;
        newwheelview.setAdapter(new NumericWheelAdapter(this.startYear, this.endYear));
        this.wv_year.setCurrentItem(i2 - this.startYear);
        this.wv_year.setGravity(this.gravity);
        newWheelView newwheelview2 = (newWheelView) this.view.findViewById(R.id.month);
        this.wv_month = newwheelview2;
        int i10 = this.startYear;
        int i11 = this.endYear;
        if (i10 == i11) {
            newwheelview2.setAdapter(new NumericWheelAdapter(this.startMonth, this.endMonth));
            this.wv_month.setCurrentItem((i3 + 1) - this.startMonth);
        } else if (i2 == i10) {
            newwheelview2.setAdapter(new NumericWheelAdapter(this.startMonth, 12));
            this.wv_month.setCurrentItem((i3 + 1) - this.startMonth);
        } else if (i2 == i11) {
            newwheelview2.setAdapter(new NumericWheelAdapter(1, this.endMonth));
            this.wv_month.setCurrentItem(i3);
        } else {
            newwheelview2.setAdapter(new NumericWheelAdapter(1, 12));
            this.wv_month.setCurrentItem(i3);
        }
        this.wv_month.setGravity(this.gravity);
        this.wv_day = (newWheelView) this.view.findViewById(R.id.day);
        int i12 = this.startYear;
        int i13 = this.endYear;
        if (i12 == i13 && this.startMonth == this.endMonth) {
            int i14 = i3 + 1;
            if (asList.contains(String.valueOf(i14))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            } else if (asList2.contains(String.valueOf(i14))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            } else {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            }
            this.wv_day.setCurrentItem(i4 - this.startDay);
        } else if (i2 == i12 && (i9 = i3 + 1) == this.startMonth) {
            if (asList.contains(String.valueOf(i9))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, 31));
            } else if (asList2.contains(String.valueOf(i9))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, 30));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, 29));
            } else {
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, 28));
            }
            this.wv_day.setCurrentItem(i4 - this.startDay);
        } else if (i2 == i13 && (i8 = i3 + 1) == this.endMonth) {
            if (asList.contains(String.valueOf(i8))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            } else if (asList2.contains(String.valueOf(i8))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            } else {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            }
            this.wv_day.setCurrentItem(i4 - 1);
        } else {
            int i15 = i3 + 1;
            if (asList.contains(String.valueOf(i15))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(1, 31));
            } else if (asList2.contains(String.valueOf(i15))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(1, 30));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                this.wv_day.setAdapter(new NumericWheelAdapter(1, 29));
            } else {
                this.wv_day.setAdapter(new NumericWheelAdapter(1, 28));
            }
            this.wv_day.setCurrentItem(i4 - 1);
        }
        this.wv_day.setGravity(this.gravity);
        newWheelView newwheelview3 = (newWheelView) this.view.findViewById(R.id.hour);
        this.wv_hours = newwheelview3;
        newwheelview3.setAdapter(new NumericWheelAdapter(0, 23));
        this.wv_hours.setCurrentItem(i5);
        this.wv_hours.setGravity(this.gravity);
        newWheelView newwheelview4 = (newWheelView) this.view.findViewById(R.id.min);
        this.wv_mins = newwheelview4;
        newwheelview4.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_mins.setCurrentItem(i6);
        this.wv_mins.setGravity(this.gravity);
        newWheelView newwheelview5 = (newWheelView) this.view.findViewById(R.id.second);
        this.wv_seconds = newwheelview5;
        newwheelview5.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_seconds.setCurrentItem(i7);
        this.wv_seconds.setGravity(this.gravity);
        OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newWheelTime.3
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i16) {
                int i17 = i16 + newWheelTime.this.startYear;
                newWheelTime.this.currentYear = i17;
                int currentItem = newWheelTime.this.wv_month.getCurrentItem();
                if (newWheelTime.this.startYear == newWheelTime.this.endYear) {
                    newWheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(newWheelTime.this.startMonth, newWheelTime.this.endMonth));
                    if (currentItem > newWheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        currentItem = newWheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        newWheelTime.this.wv_month.setCurrentItem(currentItem);
                    }
                    int i18 = currentItem + newWheelTime.this.startMonth;
                    if (newWheelTime.this.startMonth != newWheelTime.this.endMonth) {
                        if (i18 != newWheelTime.this.startMonth) {
                            newWheelTime.this.setReDay(i17, i18, 1, 31, asList, asList2);
                            return;
                        }
                        newWheelTime newwheeltime = newWheelTime.this;
                        newwheeltime.setReDay(i17, i18, newwheeltime.startDay, 31, asList, asList2);
                        return;
                    }
                    newWheelTime newwheeltime2 = newWheelTime.this;
                    newwheeltime2.setReDay(i17, i18, newwheeltime2.startDay, newWheelTime.this.endDay, asList, asList2);
                } else if (i17 == newWheelTime.this.startYear) {
                    newWheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(newWheelTime.this.startMonth, 12));
                    if (currentItem > newWheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        currentItem = newWheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        newWheelTime.this.wv_month.setCurrentItem(currentItem);
                    }
                    int i19 = currentItem + newWheelTime.this.startMonth;
                    if (i19 != newWheelTime.this.startMonth) {
                        newWheelTime.this.setReDay(i17, i19, 1, 31, asList, asList2);
                        return;
                    }
                    newWheelTime newwheeltime3 = newWheelTime.this;
                    newwheeltime3.setReDay(i17, i19, newwheeltime3.startDay, 31, asList, asList2);
                } else if (i17 == newWheelTime.this.endYear) {
                    newWheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(1, newWheelTime.this.endMonth));
                    if (currentItem > newWheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        currentItem = newWheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        newWheelTime.this.wv_month.setCurrentItem(currentItem);
                    }
                    int i20 = 1 + currentItem;
                    if (i20 != newWheelTime.this.endMonth) {
                        newWheelTime.this.setReDay(i17, i20, 1, 31, asList, asList2);
                        return;
                    }
                    newWheelTime newwheeltime4 = newWheelTime.this;
                    newwheeltime4.setReDay(i17, i20, 1, newwheeltime4.endDay, asList, asList2);
                } else {
                    newWheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(1, 12));
                    newWheelTime newwheeltime5 = newWheelTime.this;
                    newwheeltime5.setReDay(i17, 1 + newwheeltime5.wv_month.getCurrentItem(), 1, 31, asList, asList2);
                }
            }
        };
        OnItemSelectedListener onItemSelectedListener2 = new OnItemSelectedListener() { // from class: com.m7.imkfsdk.view.pickerview.view.newWheelTime.4
            @Override // com.m7.imkfsdk.view.pickerview.listener.OnItemSelectedListener
            public void onItemSelected(int i16) {
                int i17 = i16 + 1;
                if (newWheelTime.this.startYear == newWheelTime.this.endYear) {
                    int i18 = (i17 + newWheelTime.this.startMonth) - 1;
                    if (newWheelTime.this.startMonth != newWheelTime.this.endMonth) {
                        if (newWheelTime.this.startMonth != i18) {
                            if (newWheelTime.this.endMonth == i18) {
                                newWheelTime newwheeltime = newWheelTime.this;
                                newwheeltime.setReDay(newwheeltime.currentYear, i18, 1, newWheelTime.this.endDay, asList, asList2);
                                return;
                            }
                            newWheelTime newwheeltime2 = newWheelTime.this;
                            newwheeltime2.setReDay(newwheeltime2.currentYear, i18, 1, 31, asList, asList2);
                            return;
                        }
                        newWheelTime newwheeltime3 = newWheelTime.this;
                        newwheeltime3.setReDay(newwheeltime3.currentYear, i18, newWheelTime.this.startDay, 31, asList, asList2);
                        return;
                    }
                    newWheelTime newwheeltime4 = newWheelTime.this;
                    newwheeltime4.setReDay(newwheeltime4.currentYear, i18, newWheelTime.this.startDay, newWheelTime.this.endDay, asList, asList2);
                } else if (newWheelTime.this.currentYear == newWheelTime.this.startYear) {
                    int i19 = (i17 + newWheelTime.this.startMonth) - 1;
                    if (i19 == newWheelTime.this.startMonth) {
                        newWheelTime newwheeltime5 = newWheelTime.this;
                        newwheeltime5.setReDay(newwheeltime5.currentYear, i19, newWheelTime.this.startDay, 31, asList, asList2);
                        return;
                    }
                    newWheelTime newwheeltime6 = newWheelTime.this;
                    newwheeltime6.setReDay(newwheeltime6.currentYear, i19, 1, 31, asList, asList2);
                } else if (newWheelTime.this.currentYear == newWheelTime.this.endYear) {
                    if (i17 == newWheelTime.this.endMonth) {
                        newWheelTime newwheeltime7 = newWheelTime.this;
                        newwheeltime7.setReDay(newwheeltime7.currentYear, newWheelTime.this.wv_month.getCurrentItem() + 1, 1, newWheelTime.this.endDay, asList, asList2);
                        return;
                    }
                    newWheelTime newwheeltime8 = newWheelTime.this;
                    newwheeltime8.setReDay(newwheeltime8.currentYear, newWheelTime.this.wv_month.getCurrentItem() + 1, 1, 31, asList, asList2);
                } else {
                    newWheelTime newwheeltime9 = newWheelTime.this;
                    newwheeltime9.setReDay(newwheeltime9.currentYear, i17, 1, 31, asList, asList2);
                }
            }
        };
        this.wv_year.setOnItemSelectedListener(onItemSelectedListener);
        this.wv_month.setOnItemSelectedListener(onItemSelectedListener2);
        boolean[] zArr = this.type;
        if (zArr.length == 6) {
            this.wv_year.setVisibility(zArr[0] ? 0 : 8);
            this.wv_month.setVisibility(this.type[1] ? 0 : 8);
            this.wv_day.setVisibility(this.type[2] ? 0 : 8);
            this.wv_hours.setVisibility(this.type[3] ? 0 : 8);
            this.wv_mins.setVisibility(this.type[4] ? 0 : 8);
            this.wv_seconds.setVisibility(this.type[5] ? 0 : 8);
            setContentTextSize();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    private void setTextColorCenter() {
        this.wv_day.setTextColorCenter(this.textColorCenter);
        this.wv_month.setTextColorCenter(this.textColorCenter);
        this.wv_year.setTextColorCenter(this.textColorCenter);
        this.wv_hours.setTextColorCenter(this.textColorCenter);
        this.wv_mins.setTextColorCenter(this.textColorCenter);
        this.wv_seconds.setTextColorCenter(this.textColorCenter);
    }

    private void setTextColorOut() {
        this.wv_day.setTextColorOut(this.textColorOut);
        this.wv_month.setTextColorOut(this.textColorOut);
        this.wv_year.setTextColorOut(this.textColorOut);
        this.wv_hours.setTextColorOut(this.textColorOut);
        this.wv_mins.setTextColorOut(this.textColorOut);
        this.wv_seconds.setTextColorOut(this.textColorOut);
    }

    public int getEndYear() {
        return this.endYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public String getTime() {
        if (this.isLunarCalendar) {
            return getLunarTime();
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.currentYear == this.startYear) {
            int currentItem = this.wv_month.getCurrentItem();
            int i2 = this.startMonth;
            if (currentItem + i2 == i2) {
                stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_month.getCurrentItem() + this.startMonth);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_day.getCurrentItem() + this.startDay);
                stringBuffer.append(ExpandableTextView.N);
                stringBuffer.append(this.wv_hours.getCurrentItem());
                stringBuffer.append(Constants.COLON_SEPARATOR);
                stringBuffer.append(this.wv_mins.getCurrentItem());
                stringBuffer.append(Constants.COLON_SEPARATOR);
                stringBuffer.append(this.wv_seconds.getCurrentItem());
            } else {
                stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_month.getCurrentItem() + this.startMonth);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(this.wv_day.getCurrentItem() + 1);
                stringBuffer.append(ExpandableTextView.N);
                stringBuffer.append(this.wv_hours.getCurrentItem());
                stringBuffer.append(Constants.COLON_SEPARATOR);
                stringBuffer.append(this.wv_mins.getCurrentItem());
                stringBuffer.append(Constants.COLON_SEPARATOR);
                stringBuffer.append(this.wv_seconds.getCurrentItem());
            }
        } else {
            stringBuffer.append(this.wv_year.getCurrentItem() + this.startYear);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(this.wv_month.getCurrentItem() + 1);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(this.wv_day.getCurrentItem() + 1);
            stringBuffer.append(ExpandableTextView.N);
            stringBuffer.append(this.wv_hours.getCurrentItem());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(this.wv_mins.getCurrentItem());
            stringBuffer.append(Constants.COLON_SEPARATOR);
            stringBuffer.append(this.wv_seconds.getCurrentItem());
        }
        return stringBuffer.toString();
    }

    public View getView() {
        return this.view;
    }

    public void isCenterLabel(Boolean bool) {
        this.wv_day.isCenterLabel(bool);
        this.wv_month.isCenterLabel(bool);
        this.wv_year.isCenterLabel(bool);
        this.wv_hours.isCenterLabel(bool);
        this.wv_mins.isCenterLabel(bool);
        this.wv_seconds.isCenterLabel(bool);
    }

    public boolean isLunarCalendar() {
        return this.isLunarCalendar;
    }

    public void setCyclic(boolean z) {
        this.wv_year.setCyclic(z);
        this.wv_month.setCyclic(z);
        this.wv_day.setCyclic(z);
        this.wv_hours.setCyclic(z);
        this.wv_mins.setCyclic(z);
        this.wv_seconds.setCyclic(z);
    }

    public void setEndYear(int i2) {
        this.endYear = i2;
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.isLunarCalendar) {
            return;
        }
        if (str != null) {
            this.wv_year.setLabel(str);
        } else {
            this.wv_year.setLabel(this.view.getContext().getString(R.string.ykfsdk_pickerview_year));
        }
        if (str2 != null) {
            this.wv_month.setLabel(str2);
        } else {
            this.wv_month.setLabel(this.view.getContext().getString(R.string.ykfsdk_pickerview_month));
        }
        if (str3 != null) {
            this.wv_day.setLabel(str3);
        } else {
            this.wv_day.setLabel(this.view.getContext().getString(R.string.ykfsdk_pickerview_day));
        }
        if (str4 != null) {
            this.wv_hours.setLabel(str4);
        } else {
            this.wv_hours.setLabel(this.view.getContext().getString(R.string.ykfsdk_pickerview_hours));
        }
        if (str5 != null) {
            this.wv_mins.setLabel(str5);
        } else {
            this.wv_mins.setLabel(this.view.getContext().getString(R.string.ykfsdk_pickerview_minutes));
        }
        if (str6 != null) {
            this.wv_seconds.setLabel(str6);
        } else {
            this.wv_seconds.setLabel(this.view.getContext().getString(R.string.ykfsdk_pickerview_seconds));
        }
    }

    public void setLunarCalendar(boolean z) {
        this.isLunarCalendar = z;
    }

    public void setPicker(int i2, int i3, int i4) {
        setPicker(i2, i3, i4, 0, 0, 0);
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i2 = calendar2.get(1);
            int i3 = calendar2.get(2) + 1;
            int i4 = calendar2.get(5);
            int i5 = this.startYear;
            if (i2 > i5) {
                this.endYear = i2;
                this.endMonth = i3;
                this.endDay = i4;
            } else if (i2 == i5) {
                int i6 = this.startMonth;
                if (i3 > i6) {
                    this.endYear = i2;
                    this.endMonth = i3;
                    this.endDay = i4;
                } else if (i3 != i6 || i4 <= this.startDay) {
                } else {
                    this.endYear = i2;
                    this.endMonth = i3;
                    this.endDay = i4;
                }
            }
        } else if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.startMonth = calendar.get(2) + 1;
            this.endMonth = calendar2.get(2) + 1;
            this.startDay = calendar.get(5);
            this.endDay = calendar2.get(5);
        } else {
            int i7 = calendar.get(1);
            int i8 = calendar.get(2) + 1;
            int i9 = calendar.get(5);
            int i10 = this.endYear;
            if (i7 < i10) {
                this.startMonth = i8;
                this.startDay = i9;
                this.startYear = i7;
            } else if (i7 == i10) {
                int i11 = this.endMonth;
                if (i8 < i11) {
                    this.startMonth = i8;
                    this.startDay = i9;
                    this.startYear = i7;
                } else if (i8 != i11 || i9 >= this.endDay) {
                } else {
                    this.startMonth = i8;
                    this.startDay = i9;
                    this.startYear = i7;
                }
            }
        }
    }

    public void setStartYear(int i2) {
        this.startYear = i2;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setPicker(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.isLunarCalendar) {
            int[] solarToLunar = LunarCalendar.solarToLunar(i2, i3 + 1, i4);
            setLunar(solarToLunar[0], solarToLunar[1], solarToLunar[2], solarToLunar[3] == 1, i5, i6, i7);
            return;
        }
        setSolar(i2, i3, i4, i5, i6, i7);
    }

    public void setDividerColor(int i2) {
        this.dividerColor = i2;
        setDividerColor();
    }

    public void setDividerType(newWheelView.DividerType dividerType) {
        this.dividerType = dividerType;
        setDividerType();
    }

    public void setLineSpacingMultiplier(float f2) {
        this.lineSpacingMultiplier = f2;
        setLineSpacingMultiplier();
    }

    public void setTextColorCenter(int i2) {
        this.textColorCenter = i2;
        setTextColorCenter();
    }

    public void setTextColorOut(int i2) {
        this.textColorOut = i2;
        setTextColorOut();
    }

    public newWheelTime(View view, boolean[] zArr, int i2, int i3) {
        this.startYear = DEFAULT_START_YEAR;
        this.endYear = 2050;
        this.startMonth = 0;
        this.endMonth = 11;
        this.startDay = 1;
        this.endDay = 31;
        this.textSize = 18;
        this.lineSpacingMultiplier = 1.6f;
        this.isLunarCalendar = false;
        this.view = view;
        this.type = zArr;
        this.gravity = i2;
        this.textSize = i3;
        setView(view);
    }
}
