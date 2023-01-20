package e.j.a.c.f0;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;

/* loaded from: classes2.dex */
public class h implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView a;
    private final ChipTextInputComboView b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeModel f10666c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10667d = false;

    public h(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.a = chipTextInputComboView;
        this.b = chipTextInputComboView2;
        this.f10666c = timeModel;
    }

    private void b(int i2) {
        this.b.setChecked(i2 == 12);
        this.a.setChecked(i2 == 10);
        this.f10666c.selection = i2;
    }

    private boolean c(int i2, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i2 >= 7 && i2 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            b(12);
            return true;
        }
        return false;
    }

    private boolean d(int i2, KeyEvent keyEvent, EditText editText) {
        if (i2 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            b(10);
            return true;
        }
        return false;
    }

    public void a() {
        TextInputLayout e2 = this.a.e();
        TextInputLayout e3 = this.b.e();
        EditText editText = e2.getEditText();
        EditText editText2 = e3.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z = i2 == 5;
        if (z) {
            b(12);
        }
        return z;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        boolean c2;
        if (this.f10667d) {
            return false;
        }
        this.f10667d = true;
        EditText editText = (EditText) view;
        if (this.f10666c.selection == 12) {
            c2 = d(i2, keyEvent, editText);
        } else {
            c2 = c(i2, keyEvent, editText);
        }
        this.f10667d = false;
        return c2;
    }
}
