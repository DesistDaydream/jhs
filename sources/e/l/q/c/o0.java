package e.l.q.c;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.jihuanshe.model.AtUserBean;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class o0 implements TextWatcher {
    @k.e.a.d
    private final EditText a;
    private final int b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final a f14170c;
    @k.e.a.e

    /* renamed from: g  reason: collision with root package name */
    private List<AtUserBean> f14174g;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14176i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14177j;

    /* renamed from: d  reason: collision with root package name */
    private final char f14171d = 8197;

    /* renamed from: e  reason: collision with root package name */
    private int f14172e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f14173f = -1;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final List<Object> f14175h = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void i();
    }

    public o0(@k.e.a.d EditText editText, int i2, @k.e.a.e a aVar) {
        this.a = editText;
        this.b = i2;
        this.f14170c = aVar;
    }

    private final boolean a(int i2, int i3) {
        List<AtUserBean> list = this.f14174g;
        if (list != null && !list.isEmpty()) {
            for (AtUserBean atUserBean : this.f14174g) {
                if (atUserBean.getRange().getStart() == i2 && atUserBean.getRange().getEnd() == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    private final AtUserBean c(int i2, int i3, long j2, String str) {
        if (this.f14174g == null) {
            this.f14174g = new ArrayList();
        }
        AtUserBean atUserBean = new AtUserBean(j2, str, i2, i3);
        this.f14174g.add(atUserBean);
        return atUserBean;
    }

    private final void d(int i2, int i3) {
        List<AtUserBean> list = this.f14174g;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AtUserBean> it = this.f14174g.iterator();
        while (it.hasNext()) {
            AtUserBean next = it.next();
            if (next != null && next.getRange() != null) {
                if (i3 > next.getRange().getStart() && i2 < next.getRange().getEnd()) {
                    it.remove();
                    this.f14176i = true;
                } else if (i2 < next.getRange().getEnd()) {
                    AtUserBean.AtRange range = next.getRange();
                    range.setStart(range.getStart() - (i3 - i2));
                }
            }
        }
    }

    private final void e(int i2, int i3) {
        List<AtUserBean> list = this.f14174g;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AtUserBean> it = this.f14174g.iterator();
        while (it.hasNext()) {
            AtUserBean next = it.next();
            if (next != null && next.getRange() != null) {
                if (i2 > next.getRange().getStart() && i2 < next.getRange().getEnd()) {
                    it.remove();
                    this.f14176i = true;
                } else if (i2 < next.getRange().getEnd()) {
                    AtUserBean.AtRange range = next.getRange();
                    range.setStart(range.getStart() + i3);
                }
            }
        }
    }

    private final void i(EditText editText, CharSequence charSequence, StringBuilder sb, long j2) {
        sb.append(charSequence);
        sb.append(this.f14171d);
        String sb2 = sb.toString();
        Editable text = editText.getText();
        int i2 = this.f14172e;
        int length = sb2.length() + 1;
        text.insert(this.f14172e + 1, sb2);
        c(i2, length, j2, sb2);
        j();
    }

    private final void j() {
        this.f14176i = false;
        if (this.b == 0) {
            return;
        }
        Editable text = this.a.getText();
        if (!this.f14175h.isEmpty()) {
            for (Object obj : this.f14175h) {
                text.removeSpan(obj);
            }
            this.f14175h.clear();
        }
        List<AtUserBean> list = this.f14174g;
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z = text instanceof SpannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder = z ? (SpannableStringBuilder) text : new SpannableStringBuilder(text);
        for (AtUserBean atUserBean : this.f14174g) {
            if (atUserBean != null) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.b);
                spannableStringBuilder.setSpan(foregroundColorSpan, atUserBean.getRange().getStart(), atUserBean.getRange().getEnd(), 33);
                this.f14175h.add(foregroundColorSpan);
            }
        }
        if (z) {
            return;
        }
        this.a.setText(spannableStringBuilder);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@k.e.a.d Editable editable) {
        int i2 = this.f14173f;
        if (i2 != -1) {
            do {
                i2--;
                if (i2 == -1) {
                    break;
                }
            } while (editable.charAt(i2) != '@');
            int i3 = this.f14173f;
            this.f14173f = -1;
            if (i2 != -1 && a(i2, i3 + 1)) {
                editable.delete(i2, i3);
            }
        }
        if (this.f14176i) {
            j();
        }
    }

    public final boolean b(long j2) {
        List<AtUserBean> list = this.f14174g;
        if (list != null && !list.isEmpty()) {
            Iterator<AtUserBean> it = this.f14174g.iterator();
            while (it.hasNext()) {
                if (it.next().getUserId() == j2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@k.e.a.d CharSequence charSequence, int i2, int i3, int i4) {
        if (i3 == 1 && charSequence.charAt(i2) == this.f14171d) {
            this.f14173f = i2;
            return;
        }
        if (i3 != 0) {
            d(i2, i3 + i2);
        }
        if (i4 != 0) {
            e(i2, i4);
        }
    }

    @k.e.a.e
    public final List<AtUserBean> f() {
        return this.f14174g;
    }

    public final void g(@k.e.a.d CharSequence charSequence, long j2) {
        if (this.f14172e == -1) {
            return;
        }
        b(j2);
        i(this.a, charSequence, new StringBuilder(), j2);
    }

    public final void h(@k.e.a.d CharSequence charSequence, long j2) {
        if (b(j2)) {
            return;
        }
        int selectionStart = this.a.getSelectionStart();
        int selectionEnd = this.a.getSelectionEnd();
        if (selectionEnd > selectionStart) {
            selectionStart = selectionEnd;
        }
        this.f14177j = true;
        this.a.getText().insert(selectionStart, TIMMentionEditText.TIM_MENTION_TAG);
        this.f14177j = false;
        this.f14172e = selectionStart;
        i(this.a, charSequence, new StringBuilder(), j2);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@k.e.a.d CharSequence charSequence, int i2, int i3, int i4) {
        if (i4 == 1 && charSequence.charAt(i2) == '@') {
            this.f14172e = i2;
            a aVar = this.f14170c;
            if (aVar == null || this.f14177j) {
                return;
            }
            aVar.i();
        }
    }
}
