package com.m7.imkfsdk.view.pickerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.view.pickerview.view.BasePickerView;
import com.m7.imkfsdk.view.pickerview.view.WheelTime;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
public class TimePickerView extends BasePickerView implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private View btnCancel;
    private View btnSubmit;
    private OnTimeSelectListener timeSelectListener;
    private TextView tvTitle;
    public WheelTime wheelTime;

    /* loaded from: classes2.dex */
    public interface OnTimeSelectListener {
        void onTimeSelect(Date date);
    }

    /* loaded from: classes2.dex */
    public enum Type {
        ALL,
        YEAR_MONTH_DAY,
        HOURS_MINS,
        MONTH_DAY_HOUR_MIN,
        YEAR_MONTH
    }

    public TimePickerView(Context context, Type type) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_pickerview_time, this.contentContainer);
        View findViewById = findViewById(R.id.btnSubmit);
        this.btnSubmit = findViewById;
        findViewById.setTag(TAG_SUBMIT);
        View findViewById2 = findViewById(R.id.btnCancel);
        this.btnCancel = findViewById2;
        findViewById2.setTag(TAG_CANCEL);
        this.btnSubmit.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.wheelTime = new WheelTime(findViewById(R.id.timepicker), type);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        this.wheelTime.setPicker(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals(TAG_CANCEL)) {
            dismiss();
            return;
        }
        if (this.timeSelectListener != null) {
            try {
                this.timeSelectListener.onTimeSelect(WheelTime.dateFormat.parse(this.wheelTime.getTime()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        dismiss();
    }

    public void setCyclic(boolean z) {
        this.wheelTime.setCyclic(z);
    }

    public void setOnTimeSelectListener(OnTimeSelectListener onTimeSelectListener) {
        this.timeSelectListener = onTimeSelectListener;
    }

    public void setRange(int i2, int i3) {
        this.wheelTime.setStartYear(i2);
        this.wheelTime.setEndYear(i3);
    }

    public void setTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
        } else {
            calendar.setTime(date);
        }
        this.wheelTime.setPicker(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12));
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }
}
