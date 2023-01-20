package com.effective.android.panel.window;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.LayoutRes;
import com.effective.android.panel.PanelSwitchHelper;
import h.k2.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0010B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\r\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/effective/android/panel/window/PanelDialog;", "Landroid/app/Dialog;", "", "getDialogLayout", "()I", "Lcom/effective/android/panel/PanelSwitchHelper;", "helper", "Lcom/effective/android/panel/PanelSwitchHelper;", "Landroid/view/View;", "rootView", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "themeResId", "(Landroid/content/Context;I)V", "", "cancelable", "Landroid/content/DialogInterface$OnCancelListener;", "cancelListener", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class PanelDialog extends Dialog {
    @d
    @e
    public PanelSwitchHelper helper;
    @d
    @k.e.a.d
    public final View rootView;

    public PanelDialog(@k.e.a.d Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(getDialogLayout(), (ViewGroup) null, false);
        this.rootView = inflate;
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setSoftInputMode(16);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            window.setType(1000);
        }
    }

    @LayoutRes
    public abstract int getDialogLayout();

    public PanelDialog(@k.e.a.d Context context, int i2) {
        super(context, i2);
        View inflate = LayoutInflater.from(getContext()).inflate(getDialogLayout(), (ViewGroup) null, false);
        this.rootView = inflate;
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setSoftInputMode(16);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            window.setType(1000);
        }
    }

    public PanelDialog(@k.e.a.d Context context, boolean z, @e DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        View inflate = LayoutInflater.from(getContext()).inflate(getDialogLayout(), (ViewGroup) null, false);
        this.rootView = inflate;
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setSoftInputMode(16);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            window.setType(1000);
        }
    }
}
