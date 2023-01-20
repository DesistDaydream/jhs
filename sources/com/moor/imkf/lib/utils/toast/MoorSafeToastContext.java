package com.moor.imkf.lib.utils.toast;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.utils.MoorLogUtils;

/* loaded from: classes2.dex */
public final class MoorSafeToastContext extends ContextWrapper {
    @Nullable
    private MoorBadTokenListener moorBadTokenListener;
    @NonNull
    private Toast toast;

    /* loaded from: classes2.dex */
    public final class ApplicationContextWrapper extends ContextWrapper {
        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(@NonNull String str) {
            if ("window".equals(str)) {
                return new WindowManagerWrapper((WindowManager) getBaseContext().getSystemService(str));
            }
            return super.getSystemService(str);
        }

        private ApplicationContextWrapper(@NonNull Context context) {
            super(context);
        }
    }

    /* loaded from: classes2.dex */
    public final class WindowManagerWrapper implements WindowManager {
        private static final String TAG = "WindowManagerWrapper";
        @NonNull
        private final WindowManager base;

        @Override // android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                MoorLogUtils.d(TAG, "WindowManager's addView(view, params) has been hooked.");
                this.base.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e2) {
                MoorLogUtils.i(TAG, e2.getMessage());
                if (MoorSafeToastContext.this.moorBadTokenListener != null) {
                    MoorSafeToastContext.this.moorBadTokenListener.onBadTokenCaught(MoorSafeToastContext.this.toast);
                }
            } catch (Throwable th) {
                MoorLogUtils.e(TAG, "[addView]", th);
            }
        }

        @Override // android.view.WindowManager
        public Display getDefaultDisplay() {
            return this.base.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public void removeView(View view) {
            this.base.removeView(view);
        }

        @Override // android.view.WindowManager
        public void removeViewImmediate(View view) {
            this.base.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.base.updateViewLayout(view, layoutParams);
        }

        private WindowManagerWrapper(@NonNull WindowManager windowManager) {
            this.base = windowManager;
        }
    }

    public MoorSafeToastContext(@NonNull Context context, @NonNull Toast toast) {
        super(context);
        this.toast = toast;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return new ApplicationContextWrapper(getBaseContext().getApplicationContext());
    }

    public void setBadTokenListener(@NonNull MoorBadTokenListener moorBadTokenListener) {
        this.moorBadTokenListener = moorBadTokenListener;
    }
}
