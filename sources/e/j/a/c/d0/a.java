package e.j.a.c.d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes2.dex */
public class a extends e.j.a.c.d0.e {

    /* renamed from: j  reason: collision with root package name */
    private static final int f10597j = 100;

    /* renamed from: k  reason: collision with root package name */
    private static final int f10598k = 150;

    /* renamed from: l  reason: collision with root package name */
    private static final float f10599l = 0.8f;

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f10600d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f10601e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.h f10602f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.i f10603g;

    /* renamed from: h  reason: collision with root package name */
    private AnimatorSet f10604h;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f10605i;

    /* renamed from: e.j.a.c.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0353a implements TextWatcher {
        public C0353a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.a.hasFocus() && a.l(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            a.this.i(((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z) ? false : false);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextInputLayout.h {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f10601e);
            editText.removeTextChangedListener(a.this.f10600d);
            editText.addTextChangedListener(a.this.f10600d);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements TextInputLayout.i {

        /* renamed from: e.j.a.c.d0.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0354a implements Runnable {
            public final /* synthetic */ EditText a;

            public RunnableC0354a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(a.this.f10600d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 2) {
                return;
            }
            editText.post(new RunnableC0354a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f10601e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.i0();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.a.setEndIconVisible(true);
        }
    }

    /* loaded from: classes2.dex */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.a.setEndIconVisible(false);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            a.this.f10616c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f10616c.setScaleX(floatValue);
            a.this.f10616c.setScaleY(floatValue);
        }
    }

    public a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f10600d = new C0353a();
        this.f10601e = new b();
        this.f10602f = new c();
        this.f10603g = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        boolean z2 = this.a.P() == z;
        if (z && !this.f10604h.isRunning()) {
            this.f10605i.cancel();
            this.f10604h.start();
            if (z2) {
                this.f10604h.end();
            }
        } else if (z) {
        } else {
            this.f10604h.cancel();
            this.f10605i.start();
            if (z2) {
                this.f10605i.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e.j.a.c.a.a.a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10599l, 1.0f);
        ofFloat.setInterpolator(e.j.a.c.a.a.f10552d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(@NonNull Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator k2 = k();
        ValueAnimator j2 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f10604h = animatorSet;
        animatorSet.playTogether(k2, j2);
        this.f10604h.addListener(new f());
        ValueAnimator j3 = j(1.0f, 0.0f);
        this.f10605i = j3;
        j3.addListener(new g());
    }

    @Override // e.j.a.c.d0.e
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.e(this.f10602f);
        this.a.f(this.f10603g);
        m();
    }

    @Override // e.j.a.c.d0.e
    public void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        i(z);
    }
}
