package e.a.a;

import android.graphics.Typeface;
import com.aigestudio.wheelpicker.WheelPicker;
import java.util.List;

/* loaded from: classes.dex */
public interface c {
    boolean a();

    boolean b();

    boolean c();

    boolean g();

    int getCurrentItemPosition();

    int getCurtainColor();

    List getData();

    int getIndicatorColor();

    int getIndicatorSize();

    int getItemAlign();

    int getItemSpace();

    int getItemTextColor();

    int getItemTextSize();

    String getMaximumWidthText();

    int getMaximumWidthTextPosition();

    int getSelectedItemPosition();

    int getSelectedItemTextColor();

    Typeface getTypeface();

    int getVisibleItemCount();

    boolean h();

    boolean i();

    void setAtmospheric(boolean z);

    void setCurtain(boolean z);

    void setCurtainColor(int i2);

    void setCurved(boolean z);

    void setCyclic(boolean z);

    void setData(List list);

    void setIndicator(boolean z);

    void setIndicatorColor(int i2);

    void setIndicatorSize(int i2);

    void setItemAlign(int i2);

    void setItemSpace(int i2);

    void setItemTextColor(int i2);

    void setItemTextSize(int i2);

    void setMaximumWidthText(String str);

    void setMaximumWidthTextPosition(int i2);

    void setOnItemSelectedListener(WheelPicker.a aVar);

    void setOnWheelChangeListener(WheelPicker.b bVar);

    void setSameWidth(boolean z);

    void setSelectedItemPosition(int i2);

    void setSelectedItemTextColor(int i2);

    void setTypeface(Typeface typeface);

    void setVisibleItemCount(int i2);
}
