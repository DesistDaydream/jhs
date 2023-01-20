package com.vector.databinding.adapter;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.tencent.android.tpush.common.MessageKey;
import com.vector.databinding.adapter.EditTextBinding;
import com.vector.ext.AnyKt;
import com.vector.ext.view.ViewKt;
import e.t.j.h.c;
import e.t.j.h.h;
import e.t.j.h.h0;
import e.t.j.i.b;
import h.k2.k;
import h.t1;
import i.b.q0;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001f\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u001bH\u0007J\u001a\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u001f\u0010+\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u000200H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/vector/databinding/adapter/EditTextBinding;", "", "()V", "AFTER", "", "BEFORE", "EDITOR_ACTION", "INPUT_FILTER", "LIMIT_COUNT", "ON", "SELECTION", "SHOW_KEYBOARD", "TEXT", "TEXT_WATCHER", "TRIGGER_CLEAR", "setEditorActionListener", "", "editText", "Landroid/widget/EditText;", "editorAction", "Lcom/vector/databinding/onBind/OnEditorActionBinding;", "setFilters", "inputFilter", "Landroid/text/InputFilter;", "setLimit", "view", "count", "", "(Landroid/widget/EditText;Ljava/lang/Integer;)V", "setOnTextChanged", "before", "Lcom/vector/databinding/onBind/BeforeTextChangedBinding;", q0.f15781d, "Lcom/vector/databinding/onBind/OnTextChangedBinding;", "after", "Lcom/vector/databinding/onBind/AfterTextChangedBinding;", "setSelection", "index", "setText", "text", "setWatcher", "watcher", "Landroid/text/TextWatcher;", "showKeyboard", TTLogUtil.TAG_EVENT_SHOW, "", "(Landroid/widget/EditText;Ljava/lang/Boolean;)V", "trigger", "Lcom/vector/databinding/trigger/EditClearTrigger;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class EditTextBinding {
    @d
    public static final EditTextBinding a = new EditTextBinding();
    @d
    private static final String b = "android:editText_beforeTextChanged";
    @d

    /* renamed from: c */
    private static final String f7667c = "android:editText_onTextChanged";
    @d

    /* renamed from: d */
    private static final String f7668d = "android:editText_afterTextChanged";
    @d

    /* renamed from: e */
    private static final String f7669e = "android:editText_selection";
    @d

    /* renamed from: f */
    private static final String f7670f = "android:editText_text";
    @d

    /* renamed from: g */
    private static final String f7671g = "android:editText_editorAction";
    @d

    /* renamed from: h */
    private static final String f7672h = "android:editText_inputFilter";
    @d

    /* renamed from: i */
    private static final String f7673i = "android:editText_trigger_clear";
    @d

    /* renamed from: j */
    private static final String f7674j = "android:editText_showKeyboard";
    @d

    /* renamed from: k */
    private static final String f7675k = "android:editText_limit";
    @d

    /* renamed from: l */
    private static final String f7676l = "android:editText_watcher";

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/vector/databinding/adapter/EditTextBinding$setOnTextChanged$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", MessageKey.MSG_ACCEPT_TIME_START, "", "count", "after", "onTextChanged", "before", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements TextWatcher {
        public final /* synthetic */ e.t.j.h.a a;
        public final /* synthetic */ c b;

        /* renamed from: c */
        public final /* synthetic */ h0 f7677c;

        public a(e.t.j.h.a aVar, c cVar, h0 h0Var) {
            this.a = aVar;
            this.b = cVar;
            this.f7677c = h0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@e Editable editable) {
            e.t.j.h.a aVar = this.a;
            if (aVar == null || editable == null) {
                return;
            }
            aVar.a().invoke(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
            c cVar = this.b;
            if (cVar == null || charSequence == null) {
                return;
            }
            cVar.a().invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
            h0 h0Var = this.f7677c;
            if (h0Var == null || charSequence == null) {
                return;
            }
            h0Var.a().invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
    }

    private EditTextBinding() {
    }

    @BindingAdapter({f7671g})
    @k
    public static final void c(@d EditText editText, @d final h hVar) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: e.t.j.g.e
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean d2;
                d2 = EditTextBinding.d(hVar, textView, i2, keyEvent);
                return d2;
            }
        });
    }

    public static final boolean d(h hVar, TextView textView, int i2, KeyEvent keyEvent) {
        if (textView == null) {
            return false;
        }
        return hVar.a().invoke(textView, Integer.valueOf(i2)).booleanValue();
    }

    @BindingAdapter({f7672h})
    @k
    public static final void e(@d EditText editText, @e InputFilter inputFilter) {
        if (inputFilter == null) {
            return;
        }
        editText.setFilters(new InputFilter[]{inputFilter});
    }

    @BindingAdapter({f7675k})
    @k
    public static final void f(@d EditText editText, @e Integer num) {
        if (num == null) {
            return;
        }
        num.intValue();
        e.t.u.d dVar = new e.t.u.d(num.intValue());
        t1 t1Var = t1.a;
        editText.setFilters(new e.t.u.d[]{dVar});
    }

    @BindingAdapter(requireAll = false, value = {b, f7667c, f7668d})
    @k
    public static final void g(@d EditText editText, @e c cVar, @e h0 h0Var, @e e.t.j.h.a aVar) {
        editText.addTextChangedListener(new a(aVar, cVar, h0Var));
    }

    @BindingAdapter({f7669e})
    @k
    public static final void h(@d EditText editText, int i2) {
        AnyKt.A(5L, TimeUnit.MILLISECONDS, null, new EditTextBinding$setSelection$1(i2, editText), 4, null);
    }

    @BindingAdapter(requireAll = false, value = {f7670f})
    @k
    public static final void i(@d EditText editText, @e String str) {
        if (str == null) {
            return;
        }
        editText.setText(str, TextView.BufferType.EDITABLE);
        editText.setSelection(str.length());
    }

    @BindingAdapter({f7676l})
    @k
    public static final void j(@d EditText editText, @e TextWatcher textWatcher) {
        if (textWatcher == null) {
            return;
        }
        editText.addTextChangedListener(textWatcher);
    }

    @BindingAdapter({f7674j})
    @k
    public static final void k(@d final EditText editText, @e Boolean bool) {
        if (bool == null) {
            return;
        }
        bool.booleanValue();
        if (bool.booleanValue()) {
            editText.postDelayed(new Runnable() { // from class: e.t.j.g.d
                @Override // java.lang.Runnable
                public final void run() {
                    EditTextBinding.l(editText);
                }
            }, 300L);
            return;
        }
        editText.clearFocus();
        ViewKt.p(editText);
    }

    public static final void l(EditText editText) {
        editText.requestFocus();
        Object systemService = editText.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    @BindingAdapter({f7673i})
    @k
    public static final void m(@d EditText editText, @d b bVar) {
        bVar.a(new EditTextBinding$trigger$1(editText));
    }
}
