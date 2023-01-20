package e.l.q.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.jihuanshe.R;
import h.r0;
import h.t1;
import kotlin.Result;

/* loaded from: classes2.dex */
public abstract class w extends DialogFragment {
    @k.e.a.d

    /* renamed from: c */
    public static final a f14144c = new a(null);
    @k.e.a.d

    /* renamed from: d */
    private static final String f14145d = "DialogFragment";
    private final int a = R.style.animate_dialog;
    @k.e.a.e
    private h.k2.u.a<t1> b;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    private final void A(Window window, int i2, boolean z) {
        int i3;
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes == null) {
            return;
        }
        if (z) {
            i3 = i2 | attributes.flags;
        } else {
            i3 = (~i2) & attributes.flags;
        }
        attributes.flags = i3;
        if (window == null) {
            return;
        }
        window.setAttributes(attributes);
    }

    public static final void x(w wVar, View view) {
        wVar.dismiss();
    }

    public abstract void d();

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            dismissAllowingStateLoss();
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(m106constructorimpl);
        if (m109exceptionOrNullimpl != null) {
            e.l.h.k.b.a.b(f14145d, h.k2.v.f0.C("dismiss fail. ", Log.getStackTraceString(m109exceptionOrNullimpl)));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@k.e.a.e Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @k.e.a.d
    public Dialog onCreateDialog(@k.e.a.e Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @k.e.a.e
    public View onCreateView(@k.e.a.d LayoutInflater layoutInflater, @k.e.a.e ViewGroup viewGroup, @k.e.a.e Bundle bundle) {
        y(getArguments());
        ViewDataBinding p = p(viewGroup);
        p.setLifecycleOwner(this);
        return p.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@k.e.a.d DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        h.k2.u.a<t1> aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View decorView;
        super.onStart();
        Dialog dialog = getDialog();
        Window window = dialog == null ? null : dialog.getWindow();
        if (window != null) {
            window.setDimAmount(t());
        }
        if (window != null) {
            window.setGravity(u());
        }
        if (window != null) {
            window.setWindowAnimations(q());
        }
        if (window != null) {
            window.setLayout(s(), r());
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        if (window != null) {
            window.setFlags(16777216, 16777216);
        }
        if (window != null) {
            WindowCompat.setDecorFitsSystemWindows(window, true);
        }
        A(window, 201326592, false);
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (window != null) {
            window.setStatusBarColor(0);
        }
        if (window == null) {
            return;
        }
        e.t.l.b0.k(window, ViewCompat.MEASURED_STATE_MASK);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k.e.a.d View view, @k.e.a.e Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (isCancelable()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.a.f
                {
                    w.this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    w.x(w.this, view2);
                }
            });
        }
        d();
    }

    @k.e.a.d
    public abstract ViewDataBinding p(@k.e.a.e ViewGroup viewGroup);

    public int q() {
        return this.a;
    }

    public int r() {
        return -1;
    }

    public int s() {
        return -1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@k.e.a.d FragmentManager fragmentManager, @k.e.a.e String str) {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            super.show(fragmentManager, str);
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(m106constructorimpl);
        if (m109exceptionOrNullimpl != null) {
            e.l.h.k.b.a.b(f14145d, h.k2.v.f0.C("show fail. ", Log.getStackTraceString(m109exceptionOrNullimpl)));
        }
    }

    public float t() {
        return 0.6f;
    }

    public int u() {
        return 17;
    }

    @k.e.a.e
    public final h.k2.u.a<t1> v() {
        return this.b;
    }

    public abstract void y(@k.e.a.e Bundle bundle);

    public final void z(@k.e.a.e h.k2.u.a<t1> aVar) {
        this.b = aVar;
    }
}
