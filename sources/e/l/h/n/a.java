package e.l.h.n;

import com.jihuanshe.base.wheelview.WheelDatePicker;
import com.jihuanshe.base.wheelview.WheelDayPicker;
import com.jihuanshe.base.wheelview.WheelMonthPicker;
import com.jihuanshe.base.wheelview.WheelYearPicker;
import java.util.Date;

/* loaded from: classes2.dex */
public interface a {
    Date getCurrentDate();

    int getItemAlignDay();

    int getItemAlignMonth();

    int getItemAlignYear();

    WheelDayPicker getWheelDayPicker();

    WheelMonthPicker getWheelMonthPicker();

    WheelYearPicker getWheelYearPicker();

    void setItemAlignDay(int i2);

    void setItemAlignMonth(int i2);

    void setItemAlignYear(int i2);

    void setOnDateSelectedListener(WheelDatePicker.a aVar);
}
