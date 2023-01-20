package e.j.a.a;

import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public interface d {
    public static final int o0 = -1;

    void a(View view, int i2, int i3, f fVar);

    void addView(View view);

    void addView(View view, int i2);

    int b(int i2, int i3, int i4);

    View c(int i2);

    int d(int i2, int i3, int i4);

    int e(View view);

    void f(f fVar);

    View g(int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<f> getFlexLines();

    List<f> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void h(int i2, View view);

    int i(View view, int i2, int i3);

    boolean j();

    void removeAllViews();

    void removeViewAt(int i2);

    void setAlignContent(int i2);

    void setAlignItems(int i2);

    void setFlexDirection(int i2);

    void setFlexLines(List<f> list);

    void setFlexWrap(int i2);

    void setJustifyContent(int i2);

    void setMaxLine(int i2);
}
