package e.a.a.d;

import android.widget.TextView;
import com.aigestudio.wheelpicker.widgets.WheelDatePicker;
import com.aigestudio.wheelpicker.widgets.WheelDayPicker;
import com.aigestudio.wheelpicker.widgets.WheelMonthPicker;
import com.aigestudio.wheelpicker.widgets.WheelYearPicker;
import java.util.Date;

/* loaded from: classes.dex */
public interface a {
    Date getCurrentDate();

    int getItemAlignDay();

    int getItemAlignMonth();

    int getItemAlignYear();

    TextView getTextViewDay();

    TextView getTextViewMonth();

    TextView getTextViewYear();

    WheelDayPicker getWheelDayPicker();

    WheelMonthPicker getWheelMonthPicker();

    WheelYearPicker getWheelYearPicker();

    void setItemAlignDay(int i2);

    void setItemAlignMonth(int i2);

    void setItemAlignYear(int i2);

    void setOnDateSelectedListener(WheelDatePicker.a aVar);
}
