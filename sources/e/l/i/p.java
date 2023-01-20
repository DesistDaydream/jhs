package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.LabelsViewNew;
import java.util.List;

/* loaded from: classes2.dex */
public final class p {
    @k.e.a.d
    public static final p a = new p();
    @k.e.a.d
    private static final String b = "android:labels_new_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12190c = "android:labels_new_click";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12191d = "android:labels_new_state_change";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12192e = "android:labels_new_maxLines";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12193f = "android:labels_new_selects";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12194g = "android:labels_new_type";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f12195h = "android:labels_first_match";

    private p() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12192e, f12190c, f12191d, f12193f, f12194g, f12195h})
    @h.k2.k
    public static final void a(@k.e.a.d LabelsViewNew labelsViewNew, @k.e.a.e List<String> list, @k.e.a.e Integer num, @k.e.a.e LabelsViewNew.c cVar, @k.e.a.e LabelsViewNew.e eVar, @k.e.a.e List<Integer> list2, @k.e.a.e Integer num2, @k.e.a.e Boolean bool) {
        if (bool != null) {
            labelsViewNew.setFirstMatch(Boolean.valueOf(bool.booleanValue()));
        }
        labelsViewNew.setLabels(list);
        if (num != null) {
            labelsViewNew.setMaxLines(num.intValue());
        }
        labelsViewNew.setOnLabelClickListener(cVar);
        labelsViewNew.setOnLabelSelectChangeListener(eVar);
        labelsViewNew.setSelectType(LabelsViewNew.SelectType.valueOf((num2 != null && num2.intValue() == 2) ? "MULTI" : "SINGLE"));
        if (list2 == null) {
            return;
        }
        labelsViewNew.setSelects(list2);
    }
}
