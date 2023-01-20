package com.effective.android.panel;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.annotation.IdRes;
import com.effective.android.panel.interfaces.ContentScrollMeasurer;
import com.effective.android.panel.interfaces.ContentScrollMeasurerBuilder;
import com.effective.android.panel.interfaces.PanelHeightMeasurer;
import com.effective.android.panel.interfaces.PanelHeightMeasurerBuilder;
import com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener;
import com.effective.android.panel.interfaces.listener.OnEditFocusChangeListenerBuilder;
import com.effective.android.panel.interfaces.listener.OnKeyboardStateListener;
import com.effective.android.panel.interfaces.listener.OnKeyboardStateListenerBuilder;
import com.effective.android.panel.interfaces.listener.OnPanelChangeListener;
import com.effective.android.panel.interfaces.listener.OnPanelChangeListenerBuilder;
import com.effective.android.panel.interfaces.listener.OnViewClickListener;
import com.effective.android.panel.interfaces.listener.OnViewClickListenerBuilder;
import com.effective.android.panel.log.LogTracker;
import com.effective.android.panel.view.PanelSwitchLayout;
import e.j.a.b.c.r.c0;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B\u0019\b\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/effective/android/panel/PanelSwitchHelper;", "", "Landroid/widget/EditText;", "editText", "Lh/t1;", "addSecondaryInputView", "(Landroid/widget/EditText;)V", "removeSecondaryInputView", "", "hookSystemBackByPanelSwitcher", "()Z", "isPanelState", "isKeyboardState", "isResetState", "enable", "setContentScrollOutsideEnable", "(Z)V", "isContentScrollOutsizeEnable", "async", "toKeyboardState", "", "triggerViewId", "toPanelState", "(I)V", "resetState", "()V", "Lcom/effective/android/panel/view/PanelSwitchLayout;", "mPanelSwitchLayout", "Lcom/effective/android/panel/view/PanelSwitchLayout;", "Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "builder", "showKeyboard", "<init>", "(Lcom/effective/android/panel/PanelSwitchHelper$Builder;Z)V", "Builder", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PanelSwitchHelper {
    private final PanelSwitchLayout mPanelSwitchLayout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010_\u001a\u00020^¢\u0006\u0004\b`\u0010aB\u0011\b\u0016\u0012\u0006\u0010c\u001a\u00020b¢\u0006\u0004\b`\u0010dB\u001b\u0012\b\u0010X\u001a\u0004\u0018\u00010W\u0012\b\u0010e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b`\u0010fB\u0011\b\u0016\u0012\u0006\u0010h\u001a\u00020g¢\u0006\u0004\b`\u0010iJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\t\u001a\u00020\u00002\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\t\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0011\u001a\u00020\u00002\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0015\u001a\u00020\u00002\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u0015\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u0019\u001a\u00020\u00002\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u0019\u0010\u000fJ&\u0010\u001d\u001a\u00020\u00002\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u001d\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001d\u0010 J&\u0010\"\u001a\u00020\u00002\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\"\u0010\u000fJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b\"\u0010%J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b)\u0010(J\u0019\u0010,\u001a\u00020+2\b\b\u0002\u0010*\u001a\u00020&H\u0007¢\u0006\u0004\b,\u0010-R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0006R(\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b;\u00102\"\u0004\b<\u00104R(\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00180.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u00100\u001a\u0004\b>\u00102\"\u0004\b?\u00104R(\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001e0.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u00100\u001a\u0004\bA\u00102\"\u0004\bB\u00104R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u00100\u001a\u0004\bD\u00102\"\u0004\bE\u00104R(\u0010F\u001a\b\u0012\u0004\u0012\u00020#0.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u00100\u001a\u0004\bG\u00102\"\u0004\bH\u00104R\"\u0010)\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010'\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010I\u001a\u0004\bN\u0010K\"\u0004\bO\u0010MR$\u0010Q\u001a\u0004\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006j"}, d2 = {"Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "", "Landroid/view/View;", "view", "Lh/t1;", "findSwitchLayout", "(Landroid/view/View;)V", "Lcom/effective/android/panel/interfaces/listener/OnViewClickListener;", c0.a.a, "addViewClickListener", "(Lcom/effective/android/panel/interfaces/listener/OnViewClickListener;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "Lkotlin/Function1;", "Lcom/effective/android/panel/interfaces/listener/OnViewClickListenerBuilder;", "Lh/q;", "function", "(Lh/k2/u/l;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListener;", "addPanelChangeListener", "(Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListener;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListenerBuilder;", "Lcom/effective/android/panel/interfaces/listener/OnKeyboardStateListener;", "addKeyboardStateListener", "(Lcom/effective/android/panel/interfaces/listener/OnKeyboardStateListener;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "Lcom/effective/android/panel/interfaces/listener/OnKeyboardStateListenerBuilder;", "Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListener;", "addEditTextFocusChangeListener", "(Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListener;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListenerBuilder;", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurerBuilder;", "addContentScrollMeasurer", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;", "scrollMeasurer", "(Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "Lcom/effective/android/panel/interfaces/PanelHeightMeasurerBuilder;", "addPanelHeightMeasurer", "Lcom/effective/android/panel/interfaces/PanelHeightMeasurer;", "panelHeightMeasurer", "(Lcom/effective/android/panel/interfaces/PanelHeightMeasurer;)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "", "contentScrollOutsideEnable", "(Z)Lcom/effective/android/panel/PanelSwitchHelper$Builder;", "logTrack", "showKeyboard", "Lcom/effective/android/panel/PanelSwitchHelper;", "build", "(Z)Lcom/effective/android/panel/PanelSwitchHelper;", "", "viewClickListeners", "Ljava/util/List;", "getViewClickListeners$panel_release", "()Ljava/util/List;", "setViewClickListeners$panel_release", "(Ljava/util/List;)V", "rootView", "Landroid/view/View;", "getRootView$panel_release", "()Landroid/view/View;", "setRootView$panel_release", "keyboardStatusListeners", "getKeyboardStatusListeners$panel_release", "setKeyboardStatusListeners$panel_release", "editFocusChangeListeners", "getEditFocusChangeListeners$panel_release", "setEditFocusChangeListeners$panel_release", "contentScrollMeasurers", "getContentScrollMeasurers$panel_release", "setContentScrollMeasurers$panel_release", "panelChangeListeners", "getPanelChangeListeners$panel_release", "setPanelChangeListeners$panel_release", "panelHeightMeasurers", "getPanelHeightMeasurers$panel_release", "setPanelHeightMeasurers$panel_release", "Z", "getLogTrack$panel_release", "()Z", "setLogTrack$panel_release", "(Z)V", "getContentScrollOutsideEnable$panel_release", "setContentScrollOutsideEnable$panel_release", "Lcom/effective/android/panel/view/PanelSwitchLayout;", "panelSwitchLayout", "Lcom/effective/android/panel/view/PanelSwitchLayout;", "getPanelSwitchLayout$panel_release", "()Lcom/effective/android/panel/view/PanelSwitchLayout;", "setPanelSwitchLayout$panel_release", "(Lcom/effective/android/panel/view/PanelSwitchLayout;)V", "Landroid/view/Window;", "window", "Landroid/view/Window;", "getWindow$panel_release", "()Landroid/view/Window;", "setWindow$panel_release", "(Landroid/view/Window;)V", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroid/support/v4/app/Fragment;)V", "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "(Landroid/support/v4/app/DialogFragment;)V", "root", "(Landroid/view/Window;Landroid/view/View;)V", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)V", "panel_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Builder {
        @d
        private List<ContentScrollMeasurer> contentScrollMeasurers;
        private boolean contentScrollOutsideEnable;
        @d
        private List<OnEditFocusChangeListener> editFocusChangeListeners;
        @d
        private List<OnKeyboardStateListener> keyboardStatusListeners;
        private boolean logTrack;
        @d
        private List<OnPanelChangeListener> panelChangeListeners;
        @d
        private List<PanelHeightMeasurer> panelHeightMeasurers;
        @e
        private PanelSwitchLayout panelSwitchLayout;
        @d
        private View rootView;
        @d
        private List<OnViewClickListener> viewClickListeners;
        @d
        private Window window;

        public Builder(@e Window window, @e View view) {
            this.viewClickListeners = new ArrayList();
            this.panelChangeListeners = new ArrayList();
            this.keyboardStatusListeners = new ArrayList();
            this.editFocusChangeListeners = new ArrayList();
            this.contentScrollMeasurers = new ArrayList();
            this.panelHeightMeasurers = new ArrayList();
            this.contentScrollOutsideEnable = true;
            if (window != null) {
                this.window = window;
                if (view != null) {
                    this.rootView = view;
                    return;
                }
                throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : rootView can't be null!please set value by call #Builder".toString());
            }
            throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : window can't be null!please set value by call #Builder".toString());
        }

        public static /* synthetic */ PanelSwitchHelper build$default(Builder builder, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            return builder.build(z);
        }

        private final void findSwitchLayout(View view) {
            if (view instanceof PanelSwitchLayout) {
                if ((this.panelSwitchLayout == null ? 1 : 0) != 0) {
                    this.panelSwitchLayout = (PanelSwitchLayout) view;
                    return;
                }
                throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : rootView has one more panelSwitchLayout!".toString());
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                while (r1 < childCount) {
                    findSwitchLayout(viewGroup.getChildAt(r1));
                    r1++;
                }
            }
        }

        @d
        public final Builder addContentScrollMeasurer(@d l<? super ContentScrollMeasurerBuilder, t1> lVar) {
            List<ContentScrollMeasurer> list = this.contentScrollMeasurers;
            ContentScrollMeasurerBuilder contentScrollMeasurerBuilder = new ContentScrollMeasurerBuilder();
            lVar.invoke(contentScrollMeasurerBuilder);
            list.add(contentScrollMeasurerBuilder);
            return this;
        }

        @d
        public final Builder addEditTextFocusChangeListener(@d OnEditFocusChangeListener onEditFocusChangeListener) {
            if (!this.editFocusChangeListeners.contains(onEditFocusChangeListener)) {
                this.editFocusChangeListeners.add(onEditFocusChangeListener);
            }
            return this;
        }

        @d
        public final Builder addKeyboardStateListener(@d OnKeyboardStateListener onKeyboardStateListener) {
            if (!this.keyboardStatusListeners.contains(onKeyboardStateListener)) {
                this.keyboardStatusListeners.add(onKeyboardStateListener);
            }
            return this;
        }

        @d
        public final Builder addPanelChangeListener(@d OnPanelChangeListener onPanelChangeListener) {
            if (!this.panelChangeListeners.contains(onPanelChangeListener)) {
                this.panelChangeListeners.add(onPanelChangeListener);
            }
            return this;
        }

        @d
        public final Builder addPanelHeightMeasurer(@d l<? super PanelHeightMeasurerBuilder, t1> lVar) {
            List<PanelHeightMeasurer> list = this.panelHeightMeasurers;
            PanelHeightMeasurerBuilder panelHeightMeasurerBuilder = new PanelHeightMeasurerBuilder();
            lVar.invoke(panelHeightMeasurerBuilder);
            list.add(panelHeightMeasurerBuilder);
            return this;
        }

        @d
        public final Builder addViewClickListener(@d OnViewClickListener onViewClickListener) {
            if (!this.viewClickListeners.contains(onViewClickListener)) {
                this.viewClickListeners.add(onViewClickListener);
            }
            return this;
        }

        @h
        @d
        public final PanelSwitchHelper build() {
            return build$default(this, false, 1, null);
        }

        @h
        @d
        public final PanelSwitchHelper build(boolean z) {
            findSwitchLayout(this.rootView);
            if (this.panelSwitchLayout != null) {
                return new PanelSwitchHelper(this, z, null);
            }
            throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : not found PanelSwitchLayout!".toString());
        }

        @d
        public final Builder contentScrollOutsideEnable(boolean z) {
            this.contentScrollOutsideEnable = z;
            return this;
        }

        @d
        public final List<ContentScrollMeasurer> getContentScrollMeasurers$panel_release() {
            return this.contentScrollMeasurers;
        }

        public final boolean getContentScrollOutsideEnable$panel_release() {
            return this.contentScrollOutsideEnable;
        }

        @d
        public final List<OnEditFocusChangeListener> getEditFocusChangeListeners$panel_release() {
            return this.editFocusChangeListeners;
        }

        @d
        public final List<OnKeyboardStateListener> getKeyboardStatusListeners$panel_release() {
            return this.keyboardStatusListeners;
        }

        public final boolean getLogTrack$panel_release() {
            return this.logTrack;
        }

        @d
        public final List<OnPanelChangeListener> getPanelChangeListeners$panel_release() {
            return this.panelChangeListeners;
        }

        @d
        public final List<PanelHeightMeasurer> getPanelHeightMeasurers$panel_release() {
            return this.panelHeightMeasurers;
        }

        @e
        public final PanelSwitchLayout getPanelSwitchLayout$panel_release() {
            return this.panelSwitchLayout;
        }

        @d
        public final View getRootView$panel_release() {
            return this.rootView;
        }

        @d
        public final List<OnViewClickListener> getViewClickListeners$panel_release() {
            return this.viewClickListeners;
        }

        @d
        public final Window getWindow$panel_release() {
            return this.window;
        }

        @d
        public final Builder logTrack(boolean z) {
            this.logTrack = z;
            return this;
        }

        public final void setContentScrollMeasurers$panel_release(@d List<ContentScrollMeasurer> list) {
            this.contentScrollMeasurers = list;
        }

        public final void setContentScrollOutsideEnable$panel_release(boolean z) {
            this.contentScrollOutsideEnable = z;
        }

        public final void setEditFocusChangeListeners$panel_release(@d List<OnEditFocusChangeListener> list) {
            this.editFocusChangeListeners = list;
        }

        public final void setKeyboardStatusListeners$panel_release(@d List<OnKeyboardStateListener> list) {
            this.keyboardStatusListeners = list;
        }

        public final void setLogTrack$panel_release(boolean z) {
            this.logTrack = z;
        }

        public final void setPanelChangeListeners$panel_release(@d List<OnPanelChangeListener> list) {
            this.panelChangeListeners = list;
        }

        public final void setPanelHeightMeasurers$panel_release(@d List<PanelHeightMeasurer> list) {
            this.panelHeightMeasurers = list;
        }

        public final void setPanelSwitchLayout$panel_release(@e PanelSwitchLayout panelSwitchLayout) {
            this.panelSwitchLayout = panelSwitchLayout;
        }

        public final void setRootView$panel_release(@d View view) {
            this.rootView = view;
        }

        public final void setViewClickListeners$panel_release(@d List<OnViewClickListener> list) {
            this.viewClickListeners = list;
        }

        public final void setWindow$panel_release(@d Window window) {
            this.window = window;
        }

        @d
        public final Builder addContentScrollMeasurer(@d ContentScrollMeasurer contentScrollMeasurer) {
            if (!this.contentScrollMeasurers.contains(contentScrollMeasurer)) {
                this.contentScrollMeasurers.add(contentScrollMeasurer);
            }
            return this;
        }

        @d
        public final Builder addPanelHeightMeasurer(@d PanelHeightMeasurer panelHeightMeasurer) {
            if (!this.panelHeightMeasurers.contains(panelHeightMeasurer)) {
                this.panelHeightMeasurers.add(panelHeightMeasurer);
            }
            return this;
        }

        @d
        public final Builder addEditTextFocusChangeListener(@d l<? super OnEditFocusChangeListenerBuilder, t1> lVar) {
            List<OnEditFocusChangeListener> list = this.editFocusChangeListeners;
            OnEditFocusChangeListenerBuilder onEditFocusChangeListenerBuilder = new OnEditFocusChangeListenerBuilder();
            lVar.invoke(onEditFocusChangeListenerBuilder);
            list.add(onEditFocusChangeListenerBuilder);
            return this;
        }

        @d
        public final Builder addKeyboardStateListener(@d l<? super OnKeyboardStateListenerBuilder, t1> lVar) {
            List<OnKeyboardStateListener> list = this.keyboardStatusListeners;
            OnKeyboardStateListenerBuilder onKeyboardStateListenerBuilder = new OnKeyboardStateListenerBuilder();
            lVar.invoke(onKeyboardStateListenerBuilder);
            list.add(onKeyboardStateListenerBuilder);
            return this;
        }

        @d
        public final Builder addPanelChangeListener(@d l<? super OnPanelChangeListenerBuilder, t1> lVar) {
            List<OnPanelChangeListener> list = this.panelChangeListeners;
            OnPanelChangeListenerBuilder onPanelChangeListenerBuilder = new OnPanelChangeListenerBuilder();
            lVar.invoke(onPanelChangeListenerBuilder);
            list.add(onPanelChangeListenerBuilder);
            return this;
        }

        @d
        public final Builder addViewClickListener(@d l<? super OnViewClickListenerBuilder, t1> lVar) {
            List<OnViewClickListener> list = this.viewClickListeners;
            OnViewClickListenerBuilder onViewClickListenerBuilder = new OnViewClickListenerBuilder();
            lVar.invoke(onViewClickListenerBuilder);
            list.add(onViewClickListenerBuilder);
            return this;
        }

        public Builder(@d Activity activity) {
            this(activity.getWindow(), activity.getWindow().getDecorView().findViewById(16908290));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Builder(@k.e.a.d androidx.fragment.app.Fragment r2) {
            /*
                r1 = this;
                androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
                if (r0 == 0) goto Lb
                android.view.Window r0 = r0.getWindow()
                goto Lc
            Lb:
                r0 = 0
            Lc:
                android.view.View r2 = r2.getView()
                r1.<init>(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.effective.android.panel.PanelSwitchHelper.Builder.<init>(androidx.fragment.app.Fragment):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Builder(@k.e.a.d androidx.fragment.app.DialogFragment r2) {
            /*
                r1 = this;
                androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
                if (r0 == 0) goto Lb
                android.view.Window r0 = r0.getWindow()
                goto Lc
            Lb:
                r0 = 0
            Lc:
                android.view.View r2 = r2.getView()
                r1.<init>(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.effective.android.panel.PanelSwitchHelper.Builder.<init>(androidx.fragment.app.DialogFragment):void");
        }
    }

    private PanelSwitchHelper(Builder builder, boolean z) {
        Constants.DEBUG = builder.getLogTrack$panel_release();
        if (builder.getLogTrack$panel_release()) {
            List<OnViewClickListener> viewClickListeners$panel_release = builder.getViewClickListeners$panel_release();
            LogTracker logTracker = LogTracker.INSTANCE;
            viewClickListeners$panel_release.add(logTracker);
            builder.getPanelChangeListeners$panel_release().add(logTracker);
            builder.getKeyboardStatusListeners$panel_release().add(logTracker);
            builder.getEditFocusChangeListeners$panel_release().add(logTracker);
        }
        PanelSwitchLayout panelSwitchLayout$panel_release = builder.getPanelSwitchLayout$panel_release();
        if (panelSwitchLayout$panel_release == null) {
            f0.L();
        }
        this.mPanelSwitchLayout = panelSwitchLayout$panel_release;
        panelSwitchLayout$panel_release.setContentScrollOutsizeEnable$panel_release(builder.getContentScrollOutsideEnable$panel_release());
        panelSwitchLayout$panel_release.setScrollMeasurers$panel_release(builder.getContentScrollMeasurers$panel_release());
        panelSwitchLayout$panel_release.setPanelHeightMeasurers$panel_release(builder.getPanelHeightMeasurers$panel_release());
        panelSwitchLayout$panel_release.bindListener$panel_release(builder.getViewClickListeners$panel_release(), builder.getPanelChangeListeners$panel_release(), builder.getKeyboardStatusListeners$panel_release(), builder.getEditFocusChangeListeners$panel_release());
        panelSwitchLayout$panel_release.bindWindow$panel_release(builder.getWindow$panel_release());
        if (z) {
            panelSwitchLayout$panel_release.toKeyboardState$panel_release(true);
        }
    }

    public static /* synthetic */ void toKeyboardState$default(PanelSwitchHelper panelSwitchHelper, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        panelSwitchHelper.toKeyboardState(z);
    }

    public final void addSecondaryInputView(@d EditText editText) {
        this.mPanelSwitchLayout.getContentContainer$panel_release().getInputActionImpl().addSecondaryInputView(editText);
    }

    public final boolean hookSystemBackByPanelSwitcher() {
        return this.mPanelSwitchLayout.hookSystemBackByPanelSwitcher$panel_release();
    }

    public final boolean isContentScrollOutsizeEnable() {
        return this.mPanelSwitchLayout.isContentScrollOutsizeEnable$panel_release();
    }

    public final boolean isKeyboardState() {
        return this.mPanelSwitchLayout.isKeyboardState$panel_release();
    }

    public final boolean isPanelState() {
        return this.mPanelSwitchLayout.isPanelState$panel_release();
    }

    public final boolean isResetState() {
        return this.mPanelSwitchLayout.isResetState$panel_release();
    }

    public final void removeSecondaryInputView(@d EditText editText) {
        this.mPanelSwitchLayout.getContentContainer$panel_release().getInputActionImpl().removeSecondaryInputView(editText);
    }

    public final void resetState() {
        PanelSwitchLayout.checkoutPanel$panel_release$default(this.mPanelSwitchLayout, -1, false, 2, null);
    }

    public final void setContentScrollOutsideEnable(boolean z) {
        this.mPanelSwitchLayout.setContentScrollOutsizeEnable$panel_release(z);
    }

    @h
    public final void toKeyboardState() {
        toKeyboardState$default(this, false, 1, null);
    }

    @h
    public final void toKeyboardState(boolean z) {
        this.mPanelSwitchLayout.toKeyboardState$panel_release(z);
    }

    public final void toPanelState(@IdRes int i2) {
        this.mPanelSwitchLayout.findViewById(i2).performClick();
    }

    public /* synthetic */ PanelSwitchHelper(Builder builder, boolean z, u uVar) {
        this(builder, z);
    }
}
