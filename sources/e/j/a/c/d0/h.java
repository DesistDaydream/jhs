package e.j.a.c.d0;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import e.j.a.c.s.l;

/* loaded from: classes2.dex */
public class h extends e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f10631d;

    /* renamed from: e  reason: collision with root package name */
    private final TextInputLayout.h f10632e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.i f10633f;

    /* loaded from: classes2.dex */
    public class a extends l {
        public a() {
        }

        @Override // e.j.a.c.s.l, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h hVar = h.this;
            hVar.f10616c.setChecked(!hVar.g());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TextInputLayout.h {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h hVar = h.this;
            hVar.f10616c.setChecked(!hVar.g());
            editText.removeTextChangedListener(h.this.f10631d);
            editText.addTextChangedListener(h.this.f10631d);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextInputLayout.i {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ EditText a;

            public a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(h.this.f10631d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = h.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (h.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            h.this.a.i0();
        }
    }

    public h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f10631d = new a();
        this.f10632e = new b();
        this.f10633f = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // e.j.a.c.d0.e
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.e(this.f10632e);
        this.a.f(this.f10633f);
        EditText editText = this.a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
