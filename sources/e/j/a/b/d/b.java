package e.j.a.b.d;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import e.j.a.b.d.c;

@e.j.a.b.c.m.a
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class b extends c.a {
    private Fragment b;

    private b(Fragment fragment) {
        this.b = fragment;
    }

    @e.j.a.b.c.m.a
    public static b c(Fragment fragment) {
        if (fragment != null) {
            return new b(fragment);
        }
        return null;
    }

    @Override // e.j.a.b.d.c
    public final d A() {
        return f.b0(this.b.getResources());
    }

    @Override // e.j.a.b.d.c
    public final c B() {
        return c(this.b.getTargetFragment());
    }

    @Override // e.j.a.b.d.c
    public final d D() {
        return f.b0(this.b.getActivity());
    }

    @Override // e.j.a.b.d.c
    public final c F() {
        return c(this.b.getParentFragment());
    }

    @Override // e.j.a.b.d.c
    public final void G(d dVar) {
        this.b.unregisterForContextMenu((View) f.c(dVar));
    }

    @Override // e.j.a.b.d.c
    public final boolean H() {
        return this.b.isAdded();
    }

    @Override // e.j.a.b.d.c
    public final void I(d dVar) {
        this.b.registerForContextMenu((View) f.c(dVar));
    }

    @Override // e.j.a.b.d.c
    public final int J() {
        return this.b.getTargetRequestCode();
    }

    @Override // e.j.a.b.d.c
    public final d K() {
        return f.b0(this.b.getView());
    }

    @Override // e.j.a.b.d.c
    public final void M(boolean z) {
        this.b.setRetainInstance(z);
    }

    @Override // e.j.a.b.d.c
    public final void N(boolean z) {
        this.b.setHasOptionsMenu(z);
    }

    @Override // e.j.a.b.d.c
    public final boolean O() {
        return this.b.isDetached();
    }

    @Override // e.j.a.b.d.c
    public final boolean P() {
        return this.b.getRetainInstance();
    }

    @Override // e.j.a.b.d.c
    public final boolean S() {
        return this.b.isInLayout();
    }

    @Override // e.j.a.b.d.c
    public final boolean U() {
        return this.b.isRemoving();
    }

    @Override // e.j.a.b.d.c
    public final boolean V() {
        return this.b.isResumed();
    }

    @Override // e.j.a.b.d.c
    public final int getId() {
        return this.b.getId();
    }

    @Override // e.j.a.b.d.c
    public final boolean isVisible() {
        return this.b.isVisible();
    }

    @Override // e.j.a.b.d.c
    public final void startActivity(Intent intent) {
        this.b.startActivity(intent);
    }

    @Override // e.j.a.b.d.c
    public final void startActivityForResult(Intent intent, int i2) {
        this.b.startActivityForResult(intent, i2);
    }

    @Override // e.j.a.b.d.c
    public final Bundle u() {
        return this.b.getArguments();
    }

    @Override // e.j.a.b.d.c
    public final String v() {
        return this.b.getTag();
    }

    @Override // e.j.a.b.d.c
    public final boolean w() {
        return this.b.isHidden();
    }

    @Override // e.j.a.b.d.c
    public final boolean x() {
        return this.b.getUserVisibleHint();
    }

    @Override // e.j.a.b.d.c
    public final void y(boolean z) {
        this.b.setUserVisibleHint(z);
    }

    @Override // e.j.a.b.d.c
    public final void z(boolean z) {
        this.b.setMenuVisibility(z);
    }
}
