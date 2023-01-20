package com.effective.android.panel.view.content;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.IdRes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.effective.android.panel.interfaces.ContentScrollMeasurer;
import com.effective.android.panel.interfaces.ViewAssertion;
import com.effective.android.panel.log.LogTracker;
import com.effective.android.panel.utils.PanelUtil;
import com.effective.android.panel.view.PanelSwitchLayout;
import com.effective.android.panel.view.content.ContentContainerImpl;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.k2.v.f0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001AB+\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010+\u001a\u00020\u0016\u0012\b\b\u0001\u00108\u001a\u00020\t\u0012\b\b\u0001\u0010/\u001a\u00020\t¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJU\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00106\u001a\n 5*\u0004\u0018\u000104048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00100R2\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:`;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00103¨\u0006B"}, d2 = {"Lcom/effective/android/panel/view/content/ContentContainerImpl;", "Lcom/effective/android/panel/view/content/IContentContainer;", "Lcom/effective/android/panel/interfaces/ViewAssertion;", "Lcom/effective/android/panel/view/content/IInputAction;", "getInputActionImpl", "()Lcom/effective/android/panel/view/content/IInputAction;", "Lcom/effective/android/panel/view/content/IResetAction;", "getResetActionImpl", "()Lcom/effective/android/panel/view/content/IResetAction;", "", "id", "Landroid/view/View;", "findTriggerView", "(I)Landroid/view/View;", NotifyType.LIGHTS, am.aI, "r", "b", "", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;", "contentScrollMeasurers", "defaultScrollHeight", "", "canScrollOutsize", "reset", "Lh/t1;", "layoutContainer", "(IIIILjava/util/List;IZZ)V", "targetHeight", "changeContainerHeight", "(I)V", "assertView", "()V", "Landroid/view/ViewGroup;", "mViewGroup", "Landroid/view/ViewGroup;", "mInputAction", "Lcom/effective/android/panel/view/content/IInputAction;", "mResetAction", "Lcom/effective/android/panel/view/content/IResetAction;", "", RemoteMessageConst.Notification.TAG, "Ljava/lang/String;", "autoReset", "Z", "mResetView", "Landroid/view/View;", "resetId", ExpandableTextView.P, "Landroid/widget/EditText;", "mPixelInputView", "Landroid/widget/EditText;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "editTextId", "Ljava/util/HashMap;", "Lcom/effective/android/panel/view/content/ContentContainerImpl$ViewPosition;", "Lkotlin/collections/HashMap;", "map", "Ljava/util/HashMap;", "mEditText", "<init>", "(Landroid/view/ViewGroup;ZII)V", "ViewPosition", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ContentContainerImpl implements IContentContainer, ViewAssertion {
    private final boolean autoReset;
    private final Context context;
    private final int editTextId;
    private final EditText mEditText;
    private final IInputAction mInputAction;
    private final EditText mPixelInputView;
    private final IResetAction mResetAction;
    private final View mResetView;
    private final ViewGroup mViewGroup;
    private final HashMap<Integer, ViewPosition> map;
    private final int resetId;
    private final String tag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0003\u0000-6\b\n\u0018\u00002\u00020\u0001:\u00029:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004R\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010(R\u0016\u0010,\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010(R\u001a\u0010.\u001a\u00060-R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010&R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00107\u001a\u000606R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"com/effective/android/panel/view/content/ContentContainerImpl$2", "Lcom/effective/android/panel/view/content/IInputAction;", "Lh/t1;", "giveUpFocusRight", "()V", "", "requestFocus", "resetSelection", "retrieveFocusRight", "(ZZ)V", "Landroid/widget/EditText;", "getFullScreenPixelInputView", "()Landroid/widget/EditText;", "recycler", "isFullScreen", "", "panelId", "panelHeight", "updateFullScreenParams", "(ZII)V", "editText", "addSecondaryInputView", "(Landroid/widget/EditText;)V", "removeSecondaryInputView", "Landroid/view/View$OnClickListener;", NotifyType.LIGHTS, "setEditTextClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnFocusChangeListener;", "setEditTextFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "clearFocus", "hideKeyboard", "(Z)V", "showKeyboard", "()Z", "requestKeyboard", "curPanelId", ExpandableTextView.P, "checkoutInputRight", "Z", "mainInputView", "Landroid/widget/EditText;", "realEditViewAttach", "secondaryViewRequestFocus", "com/effective/android/panel/view/content/ContentContainerImpl$2$ResetSelectionRunnable", "resetSelectionRunnable", "Lcom/effective/android/panel/view/content/ContentContainerImpl$2$ResetSelectionRunnable;", "mainFocusIndex", "Ljava/util/WeakHashMap;", "secondaryViews", "Ljava/util/WeakHashMap;", "onClickListener", "Landroid/view/View$OnClickListener;", "com/effective/android/panel/view/content/ContentContainerImpl$2$RequestFocusRunnable", "requestFocusRunnable", "Lcom/effective/android/panel/view/content/ContentContainerImpl$2$RequestFocusRunnable;", "RequestFocusRunnable", "ResetSelectionRunnable", "panel_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.effective.android.panel.view.content.ContentContainerImpl$2 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 implements IInputAction {
        private boolean checkoutInputRight;
        private int curPanelId;
        private int mainFocusIndex;
        private final EditText mainInputView;
        private View.OnClickListener onClickListener;
        private boolean realEditViewAttach;
        private final RequestFocusRunnable requestFocusRunnable;
        private final ResetSelectionRunnable resetSelectionRunnable;
        private boolean secondaryViewRequestFocus;
        private final WeakHashMap<Integer, EditText> secondaryViews;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\u008a\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"com/effective/android/panel/view/content/ContentContainerImpl$2.RequestFocusRunnable", "Ljava/lang/Runnable;", "Lh/t1;", "run", "()V", "", "resetSelection", "Z", "getResetSelection", "()Z", "setResetSelection", "(Z)V", "<init>", "(Lcom/effective/android/panel/view/content/ContentContainerImpl$2;)V", "panel_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.effective.android.panel.view.content.ContentContainerImpl$2$RequestFocusRunnable */
        /* loaded from: classes.dex */
        public final class RequestFocusRunnable implements Runnable {
            private boolean resetSelection;

            public RequestFocusRunnable() {
                AnonymousClass2.this = r1;
            }

            public final boolean getResetSelection() {
                return this.resetSelection;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.mainInputView.requestFocus();
                if (this.resetSelection) {
                    AnonymousClass2.this.mainInputView.postDelayed(AnonymousClass2.this.resetSelectionRunnable, 100L);
                } else {
                    AnonymousClass2.this.checkoutInputRight = false;
                }
            }

            public final void setResetSelection(boolean z) {
                this.resetSelection = z;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\u008a\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"com/effective/android/panel/view/content/ContentContainerImpl$2.ResetSelectionRunnable", "Ljava/lang/Runnable;", "Lh/t1;", "run", "()V", "<init>", "(Lcom/effective/android/panel/view/content/ContentContainerImpl$2;)V", "panel_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.effective.android.panel.view.content.ContentContainerImpl$2$ResetSelectionRunnable */
        /* loaded from: classes.dex */
        public final class ResetSelectionRunnable implements Runnable {
            public ResetSelectionRunnable() {
                AnonymousClass2.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AnonymousClass2.this.mainFocusIndex == -1 || AnonymousClass2.this.mainFocusIndex > AnonymousClass2.this.mainInputView.getText().length()) {
                    AnonymousClass2.this.mainInputView.setSelection(AnonymousClass2.this.mainInputView.getText().length());
                } else {
                    AnonymousClass2.this.mainInputView.setSelection(AnonymousClass2.this.mainFocusIndex);
                }
                AnonymousClass2.this.checkoutInputRight = false;
            }
        }

        public AnonymousClass2() {
            ContentContainerImpl.this = r3;
            EditText editText = r3.mEditText;
            if (editText == null) {
                f0.L();
            }
            this.mainInputView = editText;
            this.mainFocusIndex = -1;
            this.secondaryViews = new WeakHashMap<>();
            this.realEditViewAttach = true;
            this.curPanelId = Integer.MAX_VALUE;
            this.checkoutInputRight = true;
            this.requestFocusRunnable = new RequestFocusRunnable();
            this.resetSelectionRunnable = new ResetSelectionRunnable();
            editText.addTextChangedListener(new TextWatcher() { // from class: com.effective.android.panel.view.content.ContentContainerImpl.2.1
                {
                    AnonymousClass2.this = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@e Editable editable) {
                    if (AnonymousClass2.this.realEditViewAttach && AnonymousClass2.this.mainInputView.hasFocus() && !AnonymousClass2.this.checkoutInputRight) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        anonymousClass2.mainFocusIndex = anonymousClass2.mainInputView.getSelectionStart();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
            editText.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.effective.android.panel.view.content.ContentContainerImpl.2.2
                {
                    AnonymousClass2.this = this;
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(@e View view, int i2) {
                    super.sendAccessibilityEvent(view, i2);
                    if (i2 == 8192 && AnonymousClass2.this.realEditViewAttach && AnonymousClass2.this.mainInputView.hasFocus() && !AnonymousClass2.this.checkoutInputRight) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        anonymousClass2.mainFocusIndex = anonymousClass2.mainInputView.getSelectionStart();
                    }
                }
            });
        }

        public static final /* synthetic */ View.OnClickListener access$getOnClickListener$p(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.onClickListener;
        }

        public static final /* synthetic */ boolean access$getRealEditViewAttach$p(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.realEditViewAttach;
        }

        public static final /* synthetic */ void access$setSecondaryViewRequestFocus$p(AnonymousClass2 anonymousClass2, boolean z) {
            anonymousClass2.secondaryViewRequestFocus = z;
        }

        private final void giveUpFocusRight() {
            this.checkoutInputRight = true;
            this.realEditViewAttach = false;
            if (ContentContainerImpl.this.mPixelInputView.hasFocus()) {
                ContentContainerImpl.this.mPixelInputView.clearFocus();
            }
            this.checkoutInputRight = false;
        }

        private final void retrieveFocusRight(boolean z, boolean z2) {
            this.checkoutInputRight = true;
            this.realEditViewAttach = true;
            if (ContentContainerImpl.this.mPixelInputView.hasFocus()) {
                ContentContainerImpl.this.mPixelInputView.clearFocus();
            }
            recycler();
            if (z) {
                this.requestFocusRunnable.setResetSelection(z2);
                this.mainInputView.postDelayed(this.requestFocusRunnable, 200L);
            } else if (z2) {
                this.resetSelectionRunnable.run();
            } else {
                this.checkoutInputRight = false;
            }
        }

        public static /* synthetic */ void retrieveFocusRight$default(AnonymousClass2 anonymousClass2, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            anonymousClass2.retrieveFocusRight(z, z2);
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void addSecondaryInputView(@d EditText editText) {
            int hashCode = editText.hashCode();
            if (this.secondaryViews.containsKey(Integer.valueOf(hashCode))) {
                return;
            }
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.effective.android.panel.view.content.ContentContainerImpl$2$addSecondaryInputView$1
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ContentContainerImpl.AnonymousClass2.access$setSecondaryViewRequestFocus$p(ContentContainerImpl.AnonymousClass2.this, z);
                }
            });
            this.secondaryViews.put(Integer.valueOf(hashCode), editText);
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        @d
        public EditText getFullScreenPixelInputView() {
            ContentContainerImpl.this.mPixelInputView.setBackground(null);
            return ContentContainerImpl.this.mPixelInputView;
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void hideKeyboard(boolean z) {
            EditText editText = this.realEditViewAttach ? this.mainInputView : ContentContainerImpl.this.mPixelInputView;
            PanelUtil.hideKeyboard(ContentContainerImpl.this.context, editText);
            if (z) {
                editText.clearFocus();
            }
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void recycler() {
            this.mainInputView.removeCallbacks(this.requestFocusRunnable);
            this.mainInputView.removeCallbacks(this.resetSelectionRunnable);
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void removeSecondaryInputView(@d EditText editText) {
            int hashCode = editText.hashCode();
            if (this.secondaryViews.containsKey(Integer.valueOf(hashCode))) {
                this.secondaryViews.remove(Integer.valueOf(hashCode));
            }
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void requestKeyboard() {
            EditText editText = this.realEditViewAttach ? this.mainInputView : ContentContainerImpl.this.mPixelInputView;
            if (editText.hasFocus()) {
                editText.performClick();
            } else {
                editText.requestFocus();
            }
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void setEditTextClickListener(@d View.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            this.mainInputView.setOnClickListener(new View.OnClickListener() { // from class: com.effective.android.panel.view.content.ContentContainerImpl$2$setEditTextClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (ContentContainerImpl.AnonymousClass2.access$getRealEditViewAttach$p(ContentContainerImpl.AnonymousClass2.this)) {
                        View.OnClickListener access$getOnClickListener$p = ContentContainerImpl.AnonymousClass2.access$getOnClickListener$p(ContentContainerImpl.AnonymousClass2.this);
                        if (access$getOnClickListener$p != null) {
                            access$getOnClickListener$p.onClick(view);
                            return;
                        }
                        return;
                    }
                    ContentContainerImpl.access$getMPixelInputView$p(ContentContainerImpl.this).requestFocus();
                }
            });
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void setEditTextFocusChangeListener(@d final View.OnFocusChangeListener onFocusChangeListener) {
            this.mainInputView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.effective.android.panel.view.content.ContentContainerImpl$2$setEditTextFocusChangeListener$1
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    if (z) {
                        if (ContentContainerImpl.AnonymousClass2.access$getRealEditViewAttach$p(ContentContainerImpl.AnonymousClass2.this)) {
                            onFocusChangeListener.onFocusChange(view, z);
                        } else {
                            ContentContainerImpl.access$getMPixelInputView$p(ContentContainerImpl.this).requestFocus();
                        }
                    }
                }
            });
            ContentContainerImpl.this.mPixelInputView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.effective.android.panel.view.content.ContentContainerImpl$2$setEditTextFocusChangeListener$2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    if (z) {
                        onFocusChangeListener.onFocusChange(view, z);
                    }
                }
            });
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public boolean showKeyboard() {
            return PanelUtil.showKeyboard(ContentContainerImpl.this.context, this.realEditViewAttach ? this.mainInputView : ContentContainerImpl.this.mPixelInputView);
        }

        @Override // com.effective.android.panel.view.content.IInputAction
        public void updateFullScreenParams(boolean z, int i2, int i3) {
            if (i2 == this.curPanelId) {
                return;
            }
            this.curPanelId = i2;
            if (!this.secondaryViewRequestFocus) {
                ContentContainerImpl.this.mPixelInputView.setVisibility(z ? 0 : 8);
                if (ContentContainerImpl.this.mPixelInputView.getParent() instanceof ViewGroup) {
                    ViewParent parent = ContentContainerImpl.this.mPixelInputView.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).setFocusableInTouchMode(true);
                        ViewParent parent2 = ContentContainerImpl.this.mPixelInputView.getParent();
                        if (parent2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                        ((ViewGroup) parent2).setFocusable(true);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
                if (!z) {
                    retrieveFocusRight$default(this, false, false, 3, null);
                    return;
                } else if (i2 != 0) {
                    if (i2 != -1 && !PanelUtil.isPanelHeightBelowKeyboardHeight(ContentContainerImpl.this.context, i3)) {
                        retrieveFocusRight(false, true);
                        return;
                    } else {
                        giveUpFocusRight();
                        return;
                    }
                } else {
                    retrieveFocusRight(true, true);
                    return;
                }
            }
            this.secondaryViewRequestFocus = false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b6\u00107J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010JB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0010J\u001a\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010'R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b+\u0010\u0010R\"\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010$\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010'R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b/\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b0\u0010\u0010R\"\u00101\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010$\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010'R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b4\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b5\u0010\u0010¨\u00068"}, d2 = {"Lcom/effective/android/panel/view/content/ContentContainerImpl$ViewPosition;", "", "", "hasChange", "()Z", "", "newL", "newT", "newR", "newB", "Lh/t1;", "change", "(IIII)V", "reset", "()V", "component1", "()I", "component2", "component3", "component4", "component5", "id", NotifyType.LIGHTS, am.aI, "r", "b", "copy", "(IIIII)Lcom/effective/android/panel/view/content/ContentContainerImpl$ViewPosition;", "", "toString", "()Ljava/lang/String;", TTDownloadField.TT_HASHCODE, "other", "equals", "(Ljava/lang/Object;)Z", "changeL", ExpandableTextView.P, "getChangeL", "setChangeL", "(I)V", "changeR", "getChangeR", "setChangeR", "getB", "changeT", "getChangeT", "setChangeT", "getT", "getL", "changeB", "getChangeB", "setChangeB", "getR", "getId", "<init>", "(IIIII)V", "panel_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class ViewPosition {
        private final int b;
        private int changeB;
        private int changeL;
        private int changeR;
        private int changeT;
        private final int id;

        /* renamed from: l */
        private final int f2567l;
        private final int r;
        private final int t;

        public ViewPosition(int i2, int i3, int i4, int i5, int i6) {
            this.id = i2;
            this.f2567l = i3;
            this.t = i4;
            this.r = i5;
            this.b = i6;
            this.changeL = i3;
            this.changeT = i4;
            this.changeR = i5;
            this.changeB = i6;
        }

        public static /* synthetic */ ViewPosition copy$default(ViewPosition viewPosition, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i2 = viewPosition.id;
            }
            if ((i7 & 2) != 0) {
                i3 = viewPosition.f2567l;
            }
            int i8 = i3;
            if ((i7 & 4) != 0) {
                i4 = viewPosition.t;
            }
            int i9 = i4;
            if ((i7 & 8) != 0) {
                i5 = viewPosition.r;
            }
            int i10 = i5;
            if ((i7 & 16) != 0) {
                i6 = viewPosition.b;
            }
            return viewPosition.copy(i2, i8, i9, i10, i6);
        }

        public final void change(int i2, int i3, int i4, int i5) {
            this.changeL = i2;
            this.changeT = i3;
            this.changeR = i4;
            this.changeB = i5;
        }

        public final int component1() {
            return this.id;
        }

        public final int component2() {
            return this.f2567l;
        }

        public final int component3() {
            return this.t;
        }

        public final int component4() {
            return this.r;
        }

        public final int component5() {
            return this.b;
        }

        @d
        public final ViewPosition copy(int i2, int i3, int i4, int i5, int i6) {
            return new ViewPosition(i2, i3, i4, i5, i6);
        }

        public boolean equals(@e Object obj) {
            if (this != obj) {
                if (obj instanceof ViewPosition) {
                    ViewPosition viewPosition = (ViewPosition) obj;
                    return this.id == viewPosition.id && this.f2567l == viewPosition.f2567l && this.t == viewPosition.t && this.r == viewPosition.r && this.b == viewPosition.b;
                }
                return false;
            }
            return true;
        }

        public final int getB() {
            return this.b;
        }

        public final int getChangeB() {
            return this.changeB;
        }

        public final int getChangeL() {
            return this.changeL;
        }

        public final int getChangeR() {
            return this.changeR;
        }

        public final int getChangeT() {
            return this.changeT;
        }

        public final int getId() {
            return this.id;
        }

        public final int getL() {
            return this.f2567l;
        }

        public final int getR() {
            return this.r;
        }

        public final int getT() {
            return this.t;
        }

        public final boolean hasChange() {
            return (this.changeL == this.f2567l && this.changeT == this.t && this.changeR == this.r && this.changeB == this.b) ? false : true;
        }

        public int hashCode() {
            return (((((((this.id * 31) + this.f2567l) * 31) + this.t) * 31) + this.r) * 31) + this.b;
        }

        public final void reset() {
            this.changeL = this.f2567l;
            this.changeT = this.t;
            this.changeR = this.r;
            this.changeB = this.b;
        }

        public final void setChangeB(int i2) {
            this.changeB = i2;
        }

        public final void setChangeL(int i2) {
            this.changeL = i2;
        }

        public final void setChangeR(int i2) {
            this.changeR = i2;
        }

        public final void setChangeT(int i2) {
            this.changeT = i2;
        }

        @d
        public String toString() {
            return "ViewPosition(id=" + this.id + ", l=" + this.f2567l + ", t=" + this.t + ", r=" + this.r + ", b=" + this.b + ")";
        }
    }

    public ContentContainerImpl(@d ViewGroup viewGroup, boolean z, @IdRes int i2, @IdRes int i3) {
        this.mViewGroup = viewGroup;
        this.autoReset = z;
        this.editTextId = i2;
        this.resetId = i3;
        EditText editText = (EditText) viewGroup.findViewById(i2);
        this.mEditText = editText;
        this.context = viewGroup.getContext();
        this.mResetView = viewGroup.findViewById(i3);
        this.tag = ContentContainerImpl.class.getSimpleName();
        EditText editText2 = new EditText(editText != null ? editText.getContext() : null);
        this.mPixelInputView = editText2;
        assertView();
        Integer valueOf = editText != null ? Integer.valueOf(editText.getImeOptions()) : null;
        if (valueOf != null) {
            Integer valueOf2 = Integer.valueOf(valueOf.intValue() | 268435456);
            if (editText != null) {
                editText.setImeOptions(valueOf2.intValue());
            }
            editText2.setImeOptions(valueOf2.intValue());
        }
        this.mResetAction = new IResetAction() { // from class: com.effective.android.panel.view.content.ContentContainerImpl.1
            private Runnable action;
            private boolean enableReset;

            {
                ContentContainerImpl.this = this;
            }

            @Override // com.effective.android.panel.view.content.IResetAction
            public void enableReset(boolean z2) {
                this.enableReset = z2;
            }

            public final boolean eventInViewArea(@d View view, @e MotionEvent motionEvent) {
                if (motionEvent != null) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    return rawX >= ((float) rect.left) && rawX <= ((float) rect.right) && rawY >= ((float) rect.top) && rawY <= ((float) rect.bottom);
                }
                return false;
            }

            @Override // com.effective.android.panel.view.content.IResetAction
            public boolean hookDispatchTouchEvent(@e MotionEvent motionEvent, boolean z2) {
                Runnable runnable;
                if (motionEvent == null || motionEvent.getAction() != 1 || (runnable = this.action) == null || !ContentContainerImpl.this.autoReset || !this.enableReset || z2) {
                    return false;
                }
                if (ContentContainerImpl.this.mResetView == null || eventInViewArea(ContentContainerImpl.this.mResetView, motionEvent)) {
                    runnable.run();
                    LogTracker.log(ContentContainerImpl.this.tag + "#hookDispatchTouchEvent", "hook ACTION_UP");
                    return true;
                }
                return false;
            }

            @Override // com.effective.android.panel.view.content.IResetAction
            public boolean hookOnTouchEvent(@e MotionEvent motionEvent) {
                Runnable runnable;
                if (motionEvent != null && motionEvent.getAction() == 0 && (runnable = this.action) != null && ContentContainerImpl.this.autoReset && this.enableReset) {
                    if (ContentContainerImpl.this.mResetView == null || eventInViewArea(ContentContainerImpl.this.mResetView, motionEvent)) {
                        runnable.run();
                        LogTracker.log(ContentContainerImpl.this.tag + "#hookOnTouchEvent", "hook ACTION_DOWN");
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // com.effective.android.panel.view.content.IResetAction
            public void setResetCallback(@d Runnable runnable) {
                this.action = runnable;
            }
        };
        this.mInputAction = new AnonymousClass2();
        this.map = new HashMap<>();
    }

    public static final /* synthetic */ EditText access$getMPixelInputView$p(ContentContainerImpl contentContainerImpl) {
        return contentContainerImpl.mPixelInputView;
    }

    @Override // com.effective.android.panel.interfaces.ViewAssertion
    public void assertView() {
        if (this.mEditText == null) {
            throw new RuntimeException("ContentContainer should set edit_view to get the editText!");
        }
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    public void changeContainerHeight(int i2) {
        ViewGroup.LayoutParams layoutParams = this.mViewGroup.getLayoutParams();
        if (layoutParams == null || layoutParams.height == i2) {
            return;
        }
        layoutParams.height = i2;
        this.mViewGroup.setLayoutParams(layoutParams);
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    @e
    public View findTriggerView(int i2) {
        return this.mViewGroup.findViewById(i2);
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    @d
    public IInputAction getInputActionImpl() {
        return this.mInputAction;
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    @d
    public IResetAction getResetActionImpl() {
        return this.mResetAction;
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    public void layoutContainer(int i2, int i3, int i4, int i5, @d List<ContentScrollMeasurer> list, int i6, boolean z, boolean z2) {
        int i7;
        int i8;
        int i9;
        Iterator<ContentScrollMeasurer> it;
        View view;
        ContentContainerImpl contentContainerImpl = this;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        contentContainerImpl.mViewGroup.layout(i2, i10, i11, i12);
        if (z) {
            Iterator<ContentScrollMeasurer> it2 = list.iterator();
            while (it2.hasNext()) {
                ContentScrollMeasurer next = it2.next();
                int scrollViewId = next.getScrollViewId();
                if (scrollViewId != -1) {
                    View findViewById = contentContainerImpl.mViewGroup.findViewById(scrollViewId);
                    ViewPosition viewPosition = contentContainerImpl.map.get(Integer.valueOf(scrollViewId));
                    if (viewPosition == null) {
                        it = it2;
                        view = findViewById;
                        ViewPosition viewPosition2 = new ViewPosition(scrollViewId, findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
                        contentContainerImpl.map.put(Integer.valueOf(scrollViewId), viewPosition2);
                        viewPosition = viewPosition2;
                    } else {
                        it = it2;
                        view = findViewById;
                    }
                    if (z2) {
                        if (viewPosition.hasChange()) {
                            view.layout(viewPosition.getL(), viewPosition.getT(), viewPosition.getR(), viewPosition.getB());
                            viewPosition.reset();
                        }
                    } else {
                        int scrollDistance = next.getScrollDistance(i6);
                        if (scrollDistance > i6) {
                            return;
                        }
                        r7 = scrollDistance >= 0 ? scrollDistance : 0;
                        int i13 = i6 - r7;
                        viewPosition.change(viewPosition.getL(), viewPosition.getT() + i13, viewPosition.getR(), viewPosition.getB() + i13);
                        view.layout(viewPosition.getChangeL(), viewPosition.getChangeT(), viewPosition.getChangeR(), viewPosition.getChangeB());
                    }
                    StringBuilder sb = new StringBuilder();
                    PanelSwitchLayout.Companion companion = PanelSwitchLayout.Companion;
                    sb.append(companion.getTAG());
                    sb.append("#onLayout");
                    String sb2 = sb.toString();
                    LogTracker.log(sb2, "ContentScrollMeasurer(id " + scrollViewId + " , defaultScrollHeight " + i6 + " , scrollDistance " + r7 + " reset " + z2 + ") origin (l " + viewPosition.getL() + ",t " + viewPosition.getT() + ",r " + viewPosition.getL() + ", b " + viewPosition.getB() + ')');
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(companion.getTAG());
                    sb3.append("#onLayout");
                    String sb4 = sb3.toString();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ContentScrollMeasurer(id ");
                    sb5.append(scrollViewId);
                    sb5.append(" , defaultScrollHeight ");
                    sb5.append(i6);
                    sb5.append(" , scrollDistance ");
                    sb5.append(r7);
                    sb5.append(" reset ");
                    sb5.append(z2);
                    sb5.append(") layout parent(l ");
                    sb5.append(i2);
                    sb5.append(",t ");
                    i7 = i3;
                    sb5.append(i7);
                    sb5.append(",r ");
                    i8 = i4;
                    sb5.append(i8);
                    sb5.append(",b ");
                    i9 = i5;
                    sb5.append(i9);
                    sb5.append(") self(l ");
                    sb5.append(viewPosition.getChangeL());
                    sb5.append(",t ");
                    sb5.append(viewPosition.getChangeT());
                    sb5.append(",r ");
                    sb5.append(viewPosition.getChangeR());
                    sb5.append(", b");
                    sb5.append(viewPosition.getChangeB());
                    sb5.append(')');
                    LogTracker.log(sb4, sb5.toString());
                } else {
                    i7 = i10;
                    i8 = i11;
                    i9 = i12;
                    it = it2;
                }
                it2 = it;
                i10 = i7;
                i11 = i8;
                i12 = i9;
                contentContainerImpl = this;
            }
        }
    }
}
