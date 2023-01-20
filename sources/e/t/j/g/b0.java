package e.t.j.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import com.vector.ext.view.ViewKt$findAll$1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0007J$\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/vector/databinding/adapter/RadioGroupBinding;", "", "()V", "CHECKED", "", "ON_CHECKED_CHANGED", "getChecked", "", "view", "Landroid/widget/RadioGroup;", "setChecked", "", "index", "setOnCheckedChanged", "binding", "Lcom/vector/databinding/onBind/OnRadioGroupCheckedChangedBinding;", "attrChange", "Landroidx/databinding/InverseBindingListener;", "getAllRadioButton", "", "Landroid/widget/RadioButton;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b0 {
    @k.e.a.d
    public static final b0 a = new b0();
    @k.e.a.d
    private static final String b = "android:radioGroup_onCheckedChanged";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14479c = "android:radioGroup_checked";

    private b0() {
    }

    private final List<RadioButton> a(RadioGroup radioGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(radioGroup);
        while (!arrayDeque.isEmpty()) {
            View view = (View) arrayDeque.getFirst();
            if (view instanceof ViewGroup) {
                e.t.l.d0.h.a((ViewGroup) view, new ViewKt$findAll$1(arrayDeque));
            }
            if (view instanceof RadioButton) {
                arrayList.add(view);
            }
            arrayDeque.pollFirst();
        }
        return arrayList;
    }

    @h.k2.k
    @InverseBindingAdapter(attribute = f14479c)
    public static final int b(@k.e.a.d RadioGroup radioGroup) {
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        List<RadioButton> a2 = a.a(radioGroup);
        int size = a2.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (a2.get(i2).getId() == checkedRadioButtonId) {
                    return i2;
                }
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        }
        return -1;
    }

    public static /* synthetic */ void c(InverseBindingListener inverseBindingListener, e.t.j.h.c0 c0Var, RadioGroup radioGroup, RadioGroup radioGroup2, int i2) {
        f(inverseBindingListener, c0Var, radioGroup, radioGroup2, i2);
    }

    @BindingAdapter({f14479c})
    @h.k2.k
    public static final void d(@k.e.a.d RadioGroup radioGroup, int i2) {
        List<RadioButton> a2 = a.a(radioGroup);
        if (i2 >= a2.size()) {
            return;
        }
        RadioButton radioButton = a2.get(i2);
        if (radioGroup.getCheckedRadioButtonId() != radioButton.getId()) {
            radioGroup.check(radioButton.getId());
        }
    }

    @BindingAdapter(requireAll = false, value = {b, "android:radioGroup_checkedAttrChanged"})
    @h.k2.k
    public static final void e(@k.e.a.d final RadioGroup radioGroup, @k.e.a.e final e.t.j.h.c0 c0Var, @k.e.a.e final InverseBindingListener inverseBindingListener) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: e.t.j.g.g
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                b0.c(InverseBindingListener.this, c0Var, radioGroup, radioGroup2, i2);
            }
        });
    }

    public static final void f(InverseBindingListener inverseBindingListener, e.t.j.h.c0 c0Var, RadioGroup radioGroup, RadioGroup radioGroup2, int i2) {
        if (inverseBindingListener != null) {
            inverseBindingListener.onChange();
        }
        if (c0Var == null) {
            return;
        }
        List<RadioButton> a2 = a.a(radioGroup);
        int i3 = 0;
        int size = a2.size();
        if (size <= 0) {
            return;
        }
        while (true) {
            int i4 = i3 + 1;
            if (a2.get(i3).getId() == i2) {
                c0Var.a().invoke(Integer.valueOf(i3), Integer.valueOf(i2));
                return;
            } else if (i4 >= size) {
                return;
            } else {
                i3 = i4;
            }
        }
    }
}
