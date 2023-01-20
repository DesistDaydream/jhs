package e.j.a.c.n;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.z.j;

/* loaded from: classes2.dex */
public class b extends AlertDialog.Builder {
    @AttrRes

    /* renamed from: c  reason: collision with root package name */
    private static final int f10921c = R.attr.alertDialogStyle;
    @StyleRes

    /* renamed from: d  reason: collision with root package name */
    private static final int f10922d = R.style.MaterialAlertDialog_MaterialComponents;
    @AttrRes

    /* renamed from: e  reason: collision with root package name */
    private static final int f10923e = R.attr.materialAlertDialogTheme;
    @Nullable
    private Drawable a;
    @NonNull
    @Dimension
    private final Rect b;

    public b(@NonNull Context context) {
        this(context, 0);
    }

    private static Context a(@NonNull Context context) {
        int c2 = c(context);
        Context c3 = e.j.a.c.e0.a.a.c(context, null, f10921c, f10922d);
        return c2 == 0 ? c3 : new ContextThemeWrapper(c3, c2);
    }

    private static int c(@NonNull Context context) {
        TypedValue a = e.j.a.c.w.b.a(context, f10923e);
        if (a == null) {
            return 0;
        }
        return a.data;
    }

    private static int d(@NonNull Context context, int i2) {
        return i2 == 0 ? c(context) : i2;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: A */
    public b setNeutralButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNeutralButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: B */
    public b setNeutralButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: C */
    public b setNeutralButtonIcon(@Nullable Drawable drawable) {
        return (b) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: D */
    public b setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        return (b) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: E */
    public b setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        return (b) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: F */
    public b setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (b) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: G */
    public b setOnKeyListener(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        return (b) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: H */
    public b setPositiveButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: I */
    public b setPositiveButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: J */
    public b setPositiveButtonIcon(@Nullable Drawable drawable) {
        return (b) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: K */
    public b setSingleChoiceItems(@ArrayRes int i2, int i3, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(i2, i3, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: L */
    public b setSingleChoiceItems(@Nullable Cursor cursor, int i2, @NonNull String str, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(cursor, i2, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: M */
    public b setSingleChoiceItems(@Nullable ListAdapter listAdapter, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(listAdapter, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: N */
    public b setSingleChoiceItems(@Nullable CharSequence[] charSequenceArr, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(charSequenceArr, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: O */
    public b setTitle(@StringRes int i2) {
        return (b) super.setTitle(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: P */
    public b setTitle(@Nullable CharSequence charSequence) {
        return (b) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: Q */
    public b setView(int i2) {
        return (b) super.setView(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: R */
    public b setView(@Nullable View view) {
        return (b) super.setView(view);
    }

    @Nullable
    public Drawable b() {
        return this.a;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.a;
        if (drawable instanceof j) {
            ((j) drawable).m0(ViewCompat.getElevation(decorView));
        }
        window.setBackgroundDrawable(c.b(this.a, this.b));
        decorView.setOnTouchListener(new a(create, this.b));
        return create;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: e */
    public b setAdapter(@Nullable ListAdapter listAdapter, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setAdapter(listAdapter, onClickListener);
    }

    @NonNull
    public b f(@Nullable Drawable drawable) {
        this.a = drawable;
        return this;
    }

    @NonNull
    public b g(@Px int i2) {
        this.b.bottom = i2;
        return this;
    }

    @NonNull
    public b h(@Px int i2) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.b.left = i2;
        } else {
            this.b.right = i2;
        }
        return this;
    }

    @NonNull
    public b i(@Px int i2) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.b.right = i2;
        } else {
            this.b.left = i2;
        }
        return this;
    }

    @NonNull
    public b j(@Px int i2) {
        this.b.top = i2;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: k */
    public b setCancelable(boolean z) {
        return (b) super.setCancelable(z);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: l */
    public b setCursor(@Nullable Cursor cursor, @Nullable DialogInterface.OnClickListener onClickListener, @NonNull String str) {
        return (b) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: m */
    public b setCustomTitle(@Nullable View view) {
        return (b) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: n */
    public b setIcon(@DrawableRes int i2) {
        return (b) super.setIcon(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: o */
    public b setIcon(@Nullable Drawable drawable) {
        return (b) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: p */
    public b setIconAttribute(@AttrRes int i2) {
        return (b) super.setIconAttribute(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: q */
    public b setItems(@ArrayRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setItems(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: r */
    public b setItems(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: s */
    public b setMessage(@StringRes int i2) {
        return (b) super.setMessage(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: t */
    public b setMessage(@Nullable CharSequence charSequence) {
        return (b) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: u */
    public b setMultiChoiceItems(@ArrayRes int i2, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.setMultiChoiceItems(i2, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: v */
    public b setMultiChoiceItems(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: w */
    public b setMultiChoiceItems(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: x */
    public b setNegativeButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: y */
    public b setNegativeButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    /* renamed from: z */
    public b setNegativeButtonIcon(@Nullable Drawable drawable) {
        return (b) super.setNegativeButtonIcon(drawable);
    }

    public b(@NonNull Context context, int i2) {
        super(a(context), d(context, i2));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i3 = f10921c;
        int i4 = f10922d;
        this.b = c.a(context2, i3, i4);
        int c2 = e.j.a.c.l.a.c(context2, R.attr.colorSurface, getClass().getCanonicalName());
        j jVar = new j(context2, null, i3, i4);
        jVar.Y(context2);
        jVar.n0(ColorStateList.valueOf(c2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                jVar.j0(dimension);
            }
        }
        this.a = jVar;
    }
}
