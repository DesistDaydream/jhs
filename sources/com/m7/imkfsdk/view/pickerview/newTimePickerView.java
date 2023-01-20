package com.m7.imkfsdk.view.pickerview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.lib.newWheelView;
import com.m7.imkfsdk.view.pickerview.listener.CustomListener;
import com.m7.imkfsdk.view.pickerview.view.newBasePickerView;
import com.m7.imkfsdk.view.pickerview.view.newWheelTime;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
public class newTimePickerView extends newBasePickerView implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private int Color_Background_Title;
    private int Color_Background_Wheel;
    private int Color_Cancel;
    private int Color_Submit;
    private int Color_Title;
    private int Size_Content;
    private int Size_Submit_Cancel;
    private int Size_Title;
    private String Str_Cancel;
    private String Str_Submit;
    private String Str_Title;
    private int backgroundId;
    private Button btnCancel;
    private Button btnSubmit;
    private boolean cancelable;
    private CustomListener customListener;
    private boolean cyclic;
    private Calendar date;
    private int dividerColor;
    private newWheelView.DividerType dividerType;
    private Calendar endDate;
    private int endYear;
    private int gravity;
    private boolean isCenterLabel;
    private boolean isDialog;
    private boolean isLunarCalendar;
    private String label_day;
    private String label_hours;
    private String label_mins;
    private String label_month;
    private String label_seconds;
    private String label_year;
    private int layoutRes;
    private float lineSpacingMultiplier;
    private Calendar startDate;
    private int startYear;
    private int textColorCenter;
    private int textColorOut;
    private OnTimeSelectListener timeSelectListener;
    private TextView tvTitle;
    private boolean[] type;
    public newWheelTime wheelTime;

    /* loaded from: classes2.dex */
    public static class Builder {
        private int Color_Background_Title;
        private int Color_Background_Wheel;
        private int Color_Cancel;
        private int Color_Submit;
        private int Color_Title;
        private String Str_Cancel;
        private String Str_Submit;
        private String Str_Title;
        private int backgroundId;
        private Context context;
        private CustomListener customListener;
        public ViewGroup decorView;
        private int dividerColor;
        private newWheelView.DividerType dividerType;
        private Calendar endDate;
        private int endYear;
        private boolean isDialog;
        private String label_day;
        private String label_hours;
        private String label_mins;
        private String label_month;
        private String label_seconds;
        private String label_year;
        private Calendar startDate;
        private int startYear;
        private int textColorCenter;
        private int textColorOut;
        private int layoutRes = R.layout.ykfsdk_kf_newpickerview_time;
        private boolean[] type = {true, true, true, true, true, true};
        private int gravity = 17;
        private int Size_Submit_Cancel = 17;
        private int Size_Title = 18;
        private int Size_Content = 18;
        private Calendar date = Calendar.getInstance();
        private boolean cyclic = false;
        private boolean cancelable = true;
        private boolean isCenterLabel = true;
        private boolean isLunarCalendar = false;
        private float lineSpacingMultiplier = 1.6f;

        public Builder(Context context) {
            this.context = context;
        }

        public newTimePickerView build() {
            return new newTimePickerView(this);
        }

        public Builder gravity(int i2) {
            this.gravity = i2;
            return this;
        }

        public Builder isCenterLabel(boolean z) {
            this.isCenterLabel = z;
            return this;
        }

        public Builder isCyclic(boolean z) {
            this.cyclic = z;
            return this;
        }

        public Builder isDialog(boolean z) {
            this.isDialog = z;
            return this;
        }

        public Builder setBackgroundId(int i2) {
            this.backgroundId = i2;
            return this;
        }

        public Builder setBgColor(int i2) {
            this.Color_Background_Wheel = i2;
            return this;
        }

        public Builder setCancelColor(int i2) {
            this.Color_Cancel = i2;
            return this;
        }

        public Builder setCancelText(String str) {
            this.Str_Cancel = str;
            return this;
        }

        public Builder setContentSize(int i2) {
            this.Size_Content = i2;
            return this;
        }

        public Builder setDate(Calendar calendar) {
            this.date.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
            return this;
        }

        public Builder setDecorView(ViewGroup viewGroup) {
            this.decorView = viewGroup;
            return this;
        }

        public Builder setDividerColor(int i2) {
            this.dividerColor = i2;
            return this;
        }

        public Builder setDividerType(newWheelView.DividerType dividerType) {
            this.dividerType = dividerType;
            return this;
        }

        public Builder setLabel(String str, String str2, String str3, String str4, String str5, String str6) {
            this.label_year = str;
            this.label_month = str2;
            this.label_day = str3;
            this.label_hours = str4;
            this.label_mins = str5;
            this.label_seconds = str6;
            return this;
        }

        public Builder setLayoutRes(int i2, CustomListener customListener) {
            this.layoutRes = i2;
            this.customListener = customListener;
            return this;
        }

        public Builder setLineSpacingMultiplier(float f2) {
            this.lineSpacingMultiplier = f2;
            return this;
        }

        public Builder setLunarCalendar(boolean z) {
            this.isLunarCalendar = z;
            return this;
        }

        public Builder setOutSideCancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public Builder setRangDate(Calendar calendar, Calendar calendar2) {
            return this;
        }

        public Builder setRange(int i2, int i3) {
            this.startYear = i2;
            this.endYear = i3;
            return this;
        }

        public Builder setSubCalSize(int i2) {
            this.Size_Submit_Cancel = i2;
            return this;
        }

        public Builder setSubmitColor(int i2) {
            this.Color_Submit = i2;
            return this;
        }

        public Builder setSubmitText(String str) {
            this.Str_Submit = str;
            return this;
        }

        public Builder setTextColorCenter(int i2) {
            this.textColorCenter = i2;
            return this;
        }

        public Builder setTextColorOut(int i2) {
            this.textColorOut = i2;
            return this;
        }

        public Builder setTitleBgColor(int i2) {
            this.Color_Background_Title = i2;
            return this;
        }

        public Builder setTitleColor(int i2) {
            this.Color_Title = i2;
            return this;
        }

        public Builder setTitleSize(int i2) {
            this.Size_Title = i2;
            return this;
        }

        public Builder setTitleText(String str) {
            this.Str_Title = str;
            return this;
        }

        public Builder setType(boolean[] zArr) {
            this.type = zArr;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnTimeSelectListener {
        void onTimeSelect(Date date, View view);
    }

    public newTimePickerView(Builder builder) {
        super(builder.context);
        this.gravity = 17;
        this.lineSpacingMultiplier = 1.6f;
        this.gravity = builder.gravity;
        this.type = builder.type;
        this.Str_Submit = builder.Str_Submit;
        this.Str_Cancel = builder.Str_Cancel;
        this.Str_Title = builder.Str_Title;
        this.Color_Submit = builder.Color_Submit;
        this.Color_Cancel = builder.Color_Cancel;
        this.Color_Title = builder.Color_Title;
        this.Color_Background_Wheel = builder.Color_Background_Wheel;
        this.Color_Background_Title = builder.Color_Background_Title;
        this.Size_Submit_Cancel = builder.Size_Submit_Cancel;
        this.Size_Title = builder.Size_Title;
        this.Size_Content = builder.Size_Content;
        this.startYear = builder.startYear;
        this.endYear = builder.endYear;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.date = builder.date;
        this.cyclic = builder.cyclic;
        this.isCenterLabel = builder.isCenterLabel;
        this.isLunarCalendar = builder.isLunarCalendar;
        this.cancelable = builder.cancelable;
        this.label_year = builder.label_year;
        this.label_month = builder.label_month;
        this.label_day = builder.label_day;
        this.label_hours = builder.label_hours;
        this.label_mins = builder.label_mins;
        this.label_seconds = builder.label_seconds;
        this.textColorCenter = builder.textColorCenter;
        this.textColorOut = builder.textColorOut;
        this.dividerColor = builder.dividerColor;
        this.customListener = builder.customListener;
        this.layoutRes = builder.layoutRes;
        this.lineSpacingMultiplier = builder.lineSpacingMultiplier;
        this.isDialog = builder.isDialog;
        this.dividerType = builder.dividerType;
        this.backgroundId = builder.backgroundId;
        this.decorView = builder.decorView;
        initView(builder.context);
    }

    private void initView(Context context) {
        int i2;
        setDialogOutSideCancelable(this.cancelable);
        initViews(this.backgroundId);
        init();
        initEvents();
        CustomListener customListener = this.customListener;
        if (customListener == null) {
            LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_newpickerview_time, this.contentContainer);
            createDialog();
            this.tvTitle = (TextView) findViewById(R.id.tvTitle);
            this.btnSubmit = (Button) findViewById(R.id.btnSubmit);
            this.btnCancel = (Button) findViewById(R.id.btnCancel);
            this.btnSubmit.setTag(TAG_SUBMIT);
            this.btnCancel.setTag(TAG_CANCEL);
            this.btnSubmit.setOnClickListener(this);
            this.btnCancel.setOnClickListener(this);
            this.btnSubmit.setText(TextUtils.isEmpty(this.Str_Submit) ? context.getResources().getString(R.string.ykfsdk_ykf_confirm) : this.Str_Submit);
            this.btnCancel.setText(TextUtils.isEmpty(this.Str_Cancel) ? context.getResources().getString(R.string.ykfsdk_cancel) : this.Str_Cancel);
            this.tvTitle.setText(TextUtils.isEmpty(this.Str_Title) ? "" : this.Str_Title);
            Button button = this.btnSubmit;
            int i3 = this.Color_Submit;
            if (i3 == 0) {
                i3 = this.pickerview_timebtn_nor;
            }
            button.setTextColor(i3);
            Button button2 = this.btnCancel;
            int i4 = this.Color_Cancel;
            if (i4 == 0) {
                i4 = this.pickerview_timebtn_nor;
            }
            button2.setTextColor(i4);
            TextView textView = this.tvTitle;
            int i5 = this.Color_Title;
            if (i5 == 0) {
                i5 = this.pickerview_topbar_title;
            }
            textView.setTextColor(i5);
            this.btnSubmit.setTextSize(this.Size_Submit_Cancel);
            this.btnCancel.setTextSize(this.Size_Submit_Cancel);
            this.tvTitle.setTextSize(this.Size_Title);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            int i6 = this.Color_Background_Title;
            if (i6 == 0) {
                i6 = this.pickerview_bg_topbar;
            }
            relativeLayout.setBackgroundColor(i6);
        } else {
            customListener.customLayout(LayoutInflater.from(context).inflate(this.layoutRes, this.contentContainer));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        int i7 = this.Color_Background_Wheel;
        if (i7 == 0) {
            i7 = this.bgColor_default;
        }
        linearLayout.setBackgroundColor(i7);
        newWheelTime newwheeltime = new newWheelTime(linearLayout, this.type, this.gravity, this.Size_Content);
        this.wheelTime = newwheeltime;
        newwheeltime.setLunarCalendar(this.isLunarCalendar);
        int i8 = this.startYear;
        if (i8 != 0 && (i2 = this.endYear) != 0 && i8 <= i2) {
            setRange();
        }
        Calendar calendar = this.startDate;
        if (calendar != null && this.endDate != null) {
            if (calendar.getTimeInMillis() <= this.endDate.getTimeInMillis()) {
                setRangDate();
            }
        } else if (calendar != null && this.endDate == null) {
            setRangDate();
        } else if (calendar == null && this.endDate != null) {
            setRangDate();
        }
        setTime();
        this.wheelTime.setLabels(this.label_year, this.label_month, this.label_day, this.label_hours, this.label_mins, this.label_seconds);
        setOutSideCancelable(this.cancelable);
        this.wheelTime.setCyclic(this.cyclic);
        this.wheelTime.setDividerColor(this.dividerColor);
        this.wheelTime.setDividerType(this.dividerType);
        this.wheelTime.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wheelTime.setTextColorOut(this.textColorOut);
        this.wheelTime.setTextColorCenter(this.textColorCenter);
        this.wheelTime.isCenterLabel(Boolean.valueOf(this.isCenterLabel));
    }

    private void setRangDate() {
        this.wheelTime.setRangDate(this.startDate, this.endDate);
        Calendar calendar = this.startDate;
        if (calendar != null && this.endDate != null) {
            Calendar calendar2 = this.date;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.startDate.getTimeInMillis() || this.date.getTimeInMillis() > this.endDate.getTimeInMillis()) {
                this.date = this.startDate;
            }
        } else if (calendar != null) {
            this.date = calendar;
        } else {
            Calendar calendar3 = this.endDate;
            if (calendar3 != null) {
                this.date = calendar3;
            }
        }
    }

    private void setRange() {
        this.wheelTime.setStartYear(this.startYear);
        this.wheelTime.setEndYear(this.endYear);
    }

    private void setTime() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.date;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i2 = calendar.get(1);
            i3 = calendar.get(2);
            i4 = calendar.get(5);
            i5 = calendar.get(11);
            i6 = calendar.get(12);
            i7 = calendar.get(13);
        } else {
            i2 = calendar2.get(1);
            i3 = this.date.get(2);
            i4 = this.date.get(5);
            i5 = this.date.get(11);
            i6 = this.date.get(12);
            i7 = this.date.get(13);
        }
        int i8 = i5;
        int i9 = i4;
        int i10 = i3;
        newWheelTime newwheeltime = this.wheelTime;
        newwheeltime.setPicker(i2, i10, i9, i8, i6, i7);
    }

    public boolean isLunarCalendar() {
        return this.wheelTime.isLunarCalendar();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals(TAG_SUBMIT)) {
            returnData();
        }
        dismiss();
    }

    public void returnData() {
        if (this.timeSelectListener != null) {
            try {
                this.timeSelectListener.onTimeSelect(newWheelTime.dateFormat.parse(this.wheelTime.getTime()), this.clickView);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setDate(Calendar calendar) {
        this.date = calendar;
        setTime();
    }

    public newTimePickerView setListener(OnTimeSelectListener onTimeSelectListener) {
        this.timeSelectListener = onTimeSelectListener;
        return this;
    }

    public void setLunarCalendar(boolean z) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(newWheelTime.dateFormat.parse(this.wheelTime.getTime()));
            int i2 = calendar.get(1);
            int i3 = calendar.get(2);
            int i4 = calendar.get(5);
            int i5 = calendar.get(11);
            int i6 = calendar.get(12);
            int i7 = calendar.get(13);
            this.wheelTime.setLunarCalendar(z);
            this.wheelTime.setLabels(this.label_year, this.label_month, this.label_day, this.label_hours, this.label_mins, this.label_seconds);
            this.wheelTime.setPicker(i2, i3, i4, i5, i6, i7);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }
}
