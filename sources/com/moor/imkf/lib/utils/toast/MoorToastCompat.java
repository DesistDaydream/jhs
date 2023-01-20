package com.moor.imkf.lib.utils.toast;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class MoorToastCompat extends Toast {
    @NonNull
    private final Toast toast;

    private MoorToastCompat(Context context, @NonNull Toast toast) {
        super(context);
        this.toast = toast;
    }

    public static MoorToastCompat makeText(Context context, CharSequence charSequence, int i2) {
        Toast makeText = Toast.makeText(context, charSequence, i2);
        setContextCompat(makeText.getView(), new MoorSafeToastContext(context, makeText));
        return new MoorToastCompat(context, makeText);
    }

    private static void setContextCompat(@NonNull View view, @NonNull Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @NonNull
    public Toast getBaseToast() {
        return this.toast;
    }

    @Override // android.widget.Toast
    public int getDuration() {
        return this.toast.getDuration();
    }

    @Override // android.widget.Toast
    public int getGravity() {
        return this.toast.getGravity();
    }

    @Override // android.widget.Toast
    public float getHorizontalMargin() {
        return this.toast.getHorizontalMargin();
    }

    @Override // android.widget.Toast
    public float getVerticalMargin() {
        return this.toast.getVerticalMargin();
    }

    @Override // android.widget.Toast
    public View getView() {
        return this.toast.getView();
    }

    @Override // android.widget.Toast
    public int getXOffset() {
        return this.toast.getXOffset();
    }

    @Override // android.widget.Toast
    public int getYOffset() {
        return this.toast.getYOffset();
    }

    @NonNull
    public MoorToastCompat setBadTokenListener(@NonNull MoorBadTokenListener moorBadTokenListener) {
        Context context = getView().getContext();
        if (context instanceof MoorSafeToastContext) {
            ((MoorSafeToastContext) context).setBadTokenListener(moorBadTokenListener);
        }
        return this;
    }

    @Override // android.widget.Toast
    public void setDuration(int i2) {
        this.toast.setDuration(i2);
    }

    @Override // android.widget.Toast
    public void setGravity(int i2, int i3, int i4) {
        this.toast.setGravity(i2, i3, i4);
    }

    @Override // android.widget.Toast
    public void setMargin(float f2, float f3) {
        this.toast.setMargin(f2, f3);
    }

    @Override // android.widget.Toast
    public void setText(int i2) {
        this.toast.setText(i2);
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        this.toast.setView(view);
        setContextCompat(view, new MoorSafeToastContext(view.getContext(), this));
    }

    @Override // android.widget.Toast
    public void show() {
        this.toast.show();
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.toast.setText(charSequence);
    }

    public static Toast makeText(Context context, @StringRes int i2, int i3) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i2), i3);
    }
}
