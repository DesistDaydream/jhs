package com.effective.android.panel.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.effective.android.panel.Constants;
import com.effective.android.panel.R;
import com.effective.android.panel.device.DeviceInfo;
import com.effective.android.panel.device.DeviceRuntime;
import com.effective.android.panel.interfaces.ContentScrollMeasurer;
import com.effective.android.panel.interfaces.PanelHeightMeasurer;
import com.effective.android.panel.interfaces.ViewAssertion;
import com.effective.android.panel.interfaces.listener.OnEditFocusChangeListener;
import com.effective.android.panel.interfaces.listener.OnKeyboardStateListener;
import com.effective.android.panel.interfaces.listener.OnPanelChangeListener;
import com.effective.android.panel.interfaces.listener.OnViewClickListener;
import com.effective.android.panel.log.LogFormatter;
import com.effective.android.panel.log.LogTracker;
import com.effective.android.panel.utils.DisplayUtil;
import com.effective.android.panel.utils.PanelUtil;
import com.effective.android.panel.view.content.IContentContainer;
import com.effective.android.panel.view.content.IInputAction;
import com.effective.android.panel.view.panel.IPanelView;
import com.effective.android.panel.view.panel.PanelContainer;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.k2.h;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¶\u00012\u00020\u00012\u00020\u0002:\u0004·\u0001¶\u0001B-\b\u0017\u0012\n\u0010²\u0001\u001a\u0005\u0018\u00010±\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0006\b³\u0001\u0010´\u0001B1\b\u0017\u0012\n\u0010²\u0001\u001a\u0005\u0018\u00010±\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0006\b³\u0001\u0010µ\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010'\u001a\u00020\u000bH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010,JA\u00104\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b7\u00108J'\u0010;\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u00108J/\u0010B\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010EJ\u0017\u0010G\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\bG\u0010EJ\u000f\u0010H\u001a\u00020\u000bH\u0002¢\u0006\u0004\bH\u0010IJ\u001f\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0005H\u0003¢\u0006\u0004\bK\u0010LJ\u000f\u0010P\u001a\u00020MH\u0000¢\u0006\u0004\bN\u0010OJ\u0017\u0010S\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u000bH\u0000¢\u0006\u0004\bR\u0010&J\u000f\u0010U\u001a\u00020\u000bH\u0000¢\u0006\u0004\bT\u0010IJ\u000f\u0010V\u001a\u00020\bH\u0014¢\u0006\u0004\bV\u0010\u0012J\u000f\u0010W\u001a\u00020\bH\u0014¢\u0006\u0004\bW\u0010\u0012J\r\u0010X\u001a\u00020\b¢\u0006\u0004\bX\u0010\u0012JG\u0010d\u001a\u00020\b2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0Y2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0Y2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020^0Y2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020`0YH\u0000¢\u0006\u0004\bb\u0010cJ\u001d\u0010i\u001a\u00020\b2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0YH\u0000¢\u0006\u0004\bg\u0010hJ\u001d\u0010l\u001a\u00020\b2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020j0YH\u0000¢\u0006\u0004\bk\u0010hJ\u0017\u0010o\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\bm\u0010nJ\u000f\u0010p\u001a\u00020\bH\u0014¢\u0006\u0004\bp\u0010\u0012J\u000f\u0010q\u001a\u00020\bH\u0016¢\u0006\u0004\bq\u0010\u0012J7\u0010s\u001a\u00020\b2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0014¢\u0006\u0004\bs\u0010tJ\u000f\u0010D\u001a\u00020\u000bH\u0000¢\u0006\u0004\bu\u0010IJ\u000f\u0010F\u001a\u00020\u000bH\u0000¢\u0006\u0004\bv\u0010IJ\u000f\u0010G\u001a\u00020\u000bH\u0000¢\u0006\u0004\bw\u0010IJ\u000f\u0010y\u001a\u00020\u000bH\u0000¢\u0006\u0004\bx\u0010IJ\u0019\u0010|\u001a\u00020\b2\b\b\u0002\u0010z\u001a\u00020\u000bH\u0001¢\u0006\u0004\b{\u0010&J!\u0010\u007f\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b}\u0010~R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010\u0080\u0001R\u0019\u0010\u0081\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0083\u0001\u001a\u00020M8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0082\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0086\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0082\u0001R7\u0010\u008c\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020j0\u008a\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020j`\u008b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0086\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b*\u0010\u0086\u0001R\u001f\u0010[\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010\u0095\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R*\u0010\u009f\u0001\u001a\u00030\u0098\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001f\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020e0Y8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u0095\u0001R\u001f\u0010a\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\ba\u0010\u0095\u0001R\u001f\u0010]\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010\u0095\u0001R\u0017\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0016\u0010¡\u0001R\u001e\u0010£\u0001\u001a\u00070¢\u0001R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010¦\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010¨\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u0086\u0001R\u0019\u0010©\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u0082\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0086\u0001R\u001f\u0010_\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b_\u0010\u0095\u0001R\u001a\u0010¬\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u0086\u0001R\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001¨\u0006¸\u0001"}, d2 = {"Lcom/effective/android/panel/view/PanelSwitchLayout;", "Landroid/widget/LinearLayout;", "Lcom/effective/android/panel/interfaces/ViewAssertion;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "Lh/t1;", "initView", "(Landroid/util/AttributeSet;II)V", "", "retry", "", "delay", "checkoutKeyboard", "(ZJ)V", "initListener", "()V", "Lcom/effective/android/panel/device/DeviceRuntime;", "runtime", "Landroid/view/Window;", "window", "getAndroidQNavHIfNavIsInvisible", "(Lcom/effective/android/panel/device/DeviceRuntime;Landroid/view/Window;)I", "deviceRuntime", "Lcom/effective/android/panel/device/DeviceInfo;", "deviceInfo", "getCurrentNavigationHeight", "(Lcom/effective/android/panel/device/DeviceRuntime;Lcom/effective/android/panel/device/DeviceInfo;)I", "getCurrentStatusBarHeight", "(Lcom/effective/android/panel/device/DeviceInfo;)I", "Landroid/view/View;", "view", "notifyViewClick", "(Landroid/view/View;)V", "visible", "notifyKeyboardState", "(Z)V", "hasFocus", "notifyEditFocusChange", "(Landroid/view/View;Z)V", "panelId", "notifyPanelChange", "(I)V", "Lcom/effective/android/panel/view/panel/IPanelView;", "panelView", "portrait", "oldWidth", "oldHeight", "width", "height", "notifyPanelSizeChange", "(Lcom/effective/android/panel/view/panel/IPanelView;ZIIII)V", "scrollOutsideHeight", "getContentContainerTop", "(I)I", "allHeight", "paddingTop", "getContentContainerHeight", "(III)I", "getCompatPanelHeight", NotifyType.LIGHTS, am.aI, "r", "b", "isBoundChange", "(IIII)Z", "isPanelState", "(I)Z", "isKeyboardState", "isResetState", "reverseResetState", "()Z", "duration", "setTransition", "(JI)V", "Lcom/effective/android/panel/view/content/IContentContainer;", "getContentContainer$panel_release", "()Lcom/effective/android/panel/view/content/IContentContainer;", "getContentContainer", "enable", "setContentScrollOutsizeEnable$panel_release", "setContentScrollOutsizeEnable", "isContentScrollOutsizeEnable$panel_release", "isContentScrollOutsizeEnable", "onDetachedFromWindow", "onAttachedToWindow", "recycle", "", "Lcom/effective/android/panel/interfaces/listener/OnViewClickListener;", "viewClickListeners", "Lcom/effective/android/panel/interfaces/listener/OnPanelChangeListener;", "panelChangeListeners", "Lcom/effective/android/panel/interfaces/listener/OnKeyboardStateListener;", "keyboardStatusListeners", "Lcom/effective/android/panel/interfaces/listener/OnEditFocusChangeListener;", "editFocusChangeListeners", "bindListener$panel_release", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "bindListener", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;", "mutableList", "setScrollMeasurers$panel_release", "(Ljava/util/List;)V", "setScrollMeasurers", "Lcom/effective/android/panel/interfaces/PanelHeightMeasurer;", "setPanelHeightMeasurers$panel_release", "setPanelHeightMeasurers", "bindWindow$panel_release", "(Landroid/view/Window;)V", "bindWindow", "onFinishInflate", "assertView", "changed", "onLayout", "(ZIIII)V", "isPanelState$panel_release", "isKeyboardState$panel_release", "isResetState$panel_release", "hookSystemBackByPanelSwitcher$panel_release", "hookSystemBackByPanelSwitcher", "async", "toKeyboardState$panel_release", "toKeyboardState", "checkoutPanel$panel_release", "(IZ)Z", "checkoutPanel", "Lcom/effective/android/panel/device/DeviceRuntime;", "hasAttachLister", "Z", "contentContainer", "Lcom/effective/android/panel/view/content/IContentContainer;", "animationSpeed", ExpandableTextView.P, "contentScrollOutsizeEnable", "lastKeyboardHeight", "doingCheckout", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "panelHeightMeasurers", "Ljava/util/HashMap;", "Landroid/graphics/Rect;", "realBounds", "Landroid/graphics/Rect;", "minLimitOpenKeyboardHeight", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Ljava/util/List;", "lastNavigationBarShow", "Ljava/lang/Boolean;", "", "TAG$1", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "TAG", "contentScrollMeasurers", "Landroid/view/Window;", "Lcom/effective/android/panel/view/PanelSwitchLayout$CheckoutKbRunnable;", "retryCheckoutKbRunnable", "Lcom/effective/android/panel/view/PanelSwitchLayout$CheckoutKbRunnable;", "Lcom/effective/android/panel/view/panel/PanelContainer;", "panelContainer", "Lcom/effective/android/panel/view/panel/PanelContainer;", "lastPanelId", "isKeyboardShowing", "lastPanelHeight", "Ljava/lang/Runnable;", "keyboardStateRunnable", "Ljava/lang/Runnable;", "minLimitCloseKeyboardHeight", "lastContentHeight", "Ljava/lang/Integer;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "CheckoutKbRunnable", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PanelSwitchLayout extends LinearLayout implements ViewAssertion {
    public static final Companion Companion = new Companion(null);
    @d
    private static final String TAG = PanelSwitchLayout.class.getSimpleName();
    private static long preClickTime;
    @d
    public String TAG$1;
    private HashMap _$_findViewCache;
    private int animationSpeed;
    private IContentContainer contentContainer;
    private final List<ContentScrollMeasurer> contentScrollMeasurers;
    private boolean contentScrollOutsizeEnable;
    private DeviceRuntime deviceRuntime;
    private boolean doingCheckout;
    private List<OnEditFocusChangeListener> editFocusChangeListeners;
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private boolean hasAttachLister;
    private boolean isKeyboardShowing;
    private Runnable keyboardStateRunnable;
    private List<OnKeyboardStateListener> keyboardStatusListeners;
    private Integer lastContentHeight;
    private int lastKeyboardHeight;
    private Boolean lastNavigationBarShow;
    private int lastPanelHeight;
    private int lastPanelId;
    private int minLimitCloseKeyboardHeight;
    private int minLimitOpenKeyboardHeight;
    private List<OnPanelChangeListener> panelChangeListeners;
    private PanelContainer panelContainer;
    private final HashMap<Integer, PanelHeightMeasurer> panelHeightMeasurers;
    private int panelId;
    private Rect realBounds;
    private final CheckoutKbRunnable retryCheckoutKbRunnable;
    private List<OnViewClickListener> viewClickListeners;
    private Window window;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/effective/android/panel/view/PanelSwitchLayout$CheckoutKbRunnable;", "Ljava/lang/Runnable;", "Lh/t1;", "run", "()V", "", "delay", "J", "getDelay", "()J", "setDelay", "(J)V", "", "retry", "Z", "getRetry", "()Z", "setRetry", "(Z)V", "<init>", "(Lcom/effective/android/panel/view/PanelSwitchLayout;)V", "panel_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public final class CheckoutKbRunnable implements Runnable {
        private long delay;
        private boolean retry;

        public CheckoutKbRunnable() {
            PanelSwitchLayout.this = r1;
        }

        public final long getDelay() {
            return this.delay;
        }

        public final boolean getRetry() {
            return this.retry;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!PanelSwitchLayout.checkoutPanel$panel_release$default(PanelSwitchLayout.this, 0, false, 2, null) && PanelSwitchLayout.this.panelId != 0 && this.retry) {
                PanelSwitchLayout.this.postDelayed(this, this.delay);
            }
            this.retry = false;
        }

        public final void setDelay(long j2) {
            this.delay = j2;
        }

        public final void setRetry(boolean z) {
            this.retry = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/effective/android/panel/view/PanelSwitchLayout$Companion;", "", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "", "preClickTime", "J", "<init>", "()V", "panel_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final String getTAG() {
            return PanelSwitchLayout.TAG;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @h
    public PanelSwitchLayout(@e Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public PanelSwitchLayout(@e Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @h
    public PanelSwitchLayout(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.contentScrollMeasurers = new ArrayList();
        this.panelHeightMeasurers = new HashMap<>();
        this.panelId = -1;
        this.lastPanelId = -1;
        this.lastPanelHeight = -1;
        this.animationSpeed = 200;
        this.contentScrollOutsizeEnable = true;
        this.keyboardStateRunnable = new Runnable() { // from class: com.effective.android.panel.view.PanelSwitchLayout$keyboardStateRunnable$1
            {
                PanelSwitchLayout.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PanelSwitchLayout.this.toKeyboardState$panel_release(false);
            }
        };
        this.retryCheckoutKbRunnable = new CheckoutKbRunnable();
        this.minLimitOpenKeyboardHeight = 300;
        initView(attributeSet, i2, 0);
    }

    private final void checkoutKeyboard(boolean z, long j2) {
        removeCallbacks(this.retryCheckoutKbRunnable);
        this.retryCheckoutKbRunnable.setRetry(z);
        this.retryCheckoutKbRunnable.setDelay(j2);
        this.retryCheckoutKbRunnable.run();
    }

    public static /* synthetic */ void checkoutKeyboard$default(PanelSwitchLayout panelSwitchLayout, boolean z, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            j2 = 200;
        }
        panelSwitchLayout.checkoutKeyboard(z, j2);
    }

    public static /* synthetic */ boolean checkoutPanel$panel_release$default(PanelSwitchLayout panelSwitchLayout, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        return panelSwitchLayout.checkoutPanel$panel_release(i2, z);
    }

    public final int getAndroidQNavHIfNavIsInvisible(DeviceRuntime deviceRuntime, Window window) {
        if (deviceRuntime.isNavigationBarShow() || Build.VERSION.SDK_INT < 29 || !DisplayUtil.INSTANCE.hasSystemUIFlag(window, 512)) {
            return 0;
        }
        WindowInsets rootWindowInsets = window.getDecorView().getRootView().getRootWindowInsets();
        LogTracker.log(this.TAG$1 + "#onGlobalLayout", " -> Android Q takes windowInset into calculation When nav is not shown and SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION flag is existed <-");
        LogTracker.log(this.TAG$1 + "#onGlobalLayout", "stableInsetTop is : " + rootWindowInsets.getStableInsetTop());
        LogTracker.log(this.TAG$1 + "#onGlobalLayout", "stableInsetBottom is : " + rootWindowInsets.getStableInsetBottom());
        LogTracker.log(this.TAG$1 + "#onGlobalLayout", "androidQCompatNavH is  " + rootWindowInsets.getStableInsetBottom());
        return rootWindowInsets.getStableInsetBottom();
    }

    private final int getCompatPanelHeight(int i2) {
        PanelHeightMeasurer panelHeightMeasurer;
        if (isPanelState(i2) && (panelHeightMeasurer = this.panelHeightMeasurers.get(Integer.valueOf(i2))) != null && (!PanelUtil.INSTANCE.hasMeasuredKeyboard$panel_release(getContext()) || !panelHeightMeasurer.synchronizeKeyboardHeight())) {
            int targetPanelDefaultHeight = panelHeightMeasurer.getTargetPanelDefaultHeight();
            LogTracker.log(this.TAG$1 + "#onLayout", " getCompatPanelHeight by default panel  :" + targetPanelDefaultHeight);
            return targetPanelDefaultHeight;
        }
        int keyBoardHeight = PanelUtil.getKeyBoardHeight(getContext());
        LogTracker.log(this.TAG$1 + "#onLayout", " getCompatPanelHeight  :" + keyBoardHeight);
        return keyBoardHeight;
    }

    private final int getContentContainerHeight(int i2, int i3, int i4) {
        return (i2 - i3) - ((this.contentScrollOutsizeEnable || isResetState$panel_release()) ? 0 : 0);
    }

    private final int getContentContainerTop(int i2) {
        int i3 = 0;
        if (this.contentScrollOutsizeEnable && !isResetState$panel_release()) {
            i3 = -i2;
        }
        LogTracker.log(this.TAG$1 + "#onLayout", " getContentContainerTop  :" + i3);
        return i3;
    }

    public final int getCurrentNavigationHeight(DeviceRuntime deviceRuntime, DeviceInfo deviceInfo) {
        if (deviceRuntime.isNavigationBarShow()) {
            return deviceInfo.getCurrentNavigationBarHeightWhenVisible(deviceRuntime.isPortrait(), deviceRuntime.isPad());
        }
        return 0;
    }

    public final int getCurrentStatusBarHeight(DeviceInfo deviceInfo) {
        return deviceInfo.getStatusBarH();
    }

    private final void initListener() {
        this.contentContainer.getInputActionImpl().setEditTextClickListener(new View.OnClickListener() { // from class: com.effective.android.panel.view.PanelSwitchLayout$initListener$1
            {
                PanelSwitchLayout.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PanelSwitchLayout.this.notifyViewClick(view);
                PanelSwitchLayout.checkoutKeyboard$default(PanelSwitchLayout.this, false, 0L, 3, null);
            }
        });
        this.contentContainer.getInputActionImpl().setEditTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.effective.android.panel.view.PanelSwitchLayout$initListener$2
            {
                PanelSwitchLayout.this = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PanelSwitchLayout.this.notifyEditFocusChange(view, z);
                PanelSwitchLayout.checkoutKeyboard$default(PanelSwitchLayout.this, false, 0L, 3, null);
            }
        });
        this.contentContainer.getResetActionImpl().setResetCallback(new Runnable() { // from class: com.effective.android.panel.view.PanelSwitchLayout$initListener$3
            {
                PanelSwitchLayout.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PanelSwitchLayout.this.hookSystemBackByPanelSwitcher$panel_release();
            }
        });
        SparseArray<IPanelView> panelSparseArray = this.panelContainer.getPanelSparseArray();
        int size = panelSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            final IPanelView iPanelView = panelSparseArray.get(panelSparseArray.keyAt(i2));
            View findTriggerView = this.contentContainer.findTriggerView(iPanelView.getBindingTriggerViewId());
            if (findTriggerView != null) {
                findTriggerView.setOnClickListener(new View.OnClickListener() { // from class: com.effective.android.panel.view.PanelSwitchLayout$initListener$4
                    {
                        PanelSwitchLayout.this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(@d View view) {
                        long j2;
                        PanelContainer panelContainer;
                        long j3;
                        long currentTimeMillis = System.currentTimeMillis();
                        j2 = PanelSwitchLayout.preClickTime;
                        if (currentTimeMillis - j2 > 500) {
                            PanelSwitchLayout.this.notifyViewClick(view);
                            panelContainer = PanelSwitchLayout.this.panelContainer;
                            int panelId = panelContainer.getPanelId(iPanelView);
                            if (PanelSwitchLayout.this.panelId == panelId && iPanelView.isTriggerViewCanToggle() && iPanelView.isShowing()) {
                                PanelSwitchLayout.checkoutKeyboard$default(PanelSwitchLayout.this, false, 0L, 2, null);
                            } else {
                                PanelSwitchLayout.checkoutPanel$panel_release$default(PanelSwitchLayout.this, panelId, false, 2, null);
                            }
                            PanelSwitchLayout.preClickTime = currentTimeMillis;
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("panelItem invalid click! preClickTime: ");
                        j3 = PanelSwitchLayout.preClickTime;
                        sb.append(j3);
                        sb.append(" currentClickTime: ");
                        sb.append(currentTimeMillis);
                        LogTracker.log(PanelSwitchLayout.this.getTAG() + "#initListener", sb.toString());
                    }
                });
            }
        }
    }

    private final void initView(AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PanelSwitchLayout, i2, 0);
        this.animationSpeed = obtainStyledAttributes.getInteger(R.styleable.PanelSwitchLayout_animationSpeed, this.animationSpeed);
        obtainStyledAttributes.recycle();
        this.TAG$1 = PanelSwitchLayout.class.getSimpleName() + '(' + hashCode() + ')';
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x001f, code lost:
        if (((r0.left == r5 && (r3 = r0.top) == r3 && r0.right == r7 && r0.bottom == r8) ? false : true) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isBoundChange(int r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            android.graphics.Rect r0 = r4.realBounds
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L21
            if (r0 != 0) goto Lb
            h.k2.v.f0.L()
        Lb:
            int r3 = r0.left
            if (r3 != r5) goto L1e
            int r3 = r0.top
            if (r3 != r3) goto L1e
            int r3 = r0.right
            if (r3 != r7) goto L1e
            int r0 = r0.bottom
            if (r0 == r8) goto L1c
            goto L1e
        L1c:
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r0 == 0) goto L22
        L21:
            r1 = 1
        L22:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r5, r6, r7, r8)
            r4.realBounds = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.effective.android.panel.view.PanelSwitchLayout.isBoundChange(int, int, int, int):boolean");
    }

    private final boolean isKeyboardState(int i2) {
        return i2 == 0;
    }

    private final boolean isPanelState(int i2) {
        return (isResetState(i2) || isKeyboardState(i2)) ? false : true;
    }

    private final boolean isResetState(int i2) {
        return i2 == -1;
    }

    public final void notifyEditFocusChange(View view, boolean z) {
        List<OnEditFocusChangeListener> list = this.editFocusChangeListeners;
        if (list != null) {
            for (OnEditFocusChangeListener onEditFocusChangeListener : list) {
                onEditFocusChangeListener.onFocusChange(view, z);
            }
        }
    }

    public final void notifyKeyboardState(boolean z) {
        List<OnKeyboardStateListener> list = this.keyboardStatusListeners;
        if (list != null) {
            for (OnKeyboardStateListener onKeyboardStateListener : list) {
                onKeyboardStateListener.onKeyboardChange(z, z ? PanelUtil.getKeyBoardHeight(getContext()) : 0);
            }
        }
    }

    private final void notifyPanelChange(int i2) {
        List<OnPanelChangeListener> list = this.panelChangeListeners;
        if (list != null) {
            for (OnPanelChangeListener onPanelChangeListener : list) {
                if (i2 == -1) {
                    onPanelChangeListener.onNone();
                } else if (i2 != 0) {
                    onPanelChangeListener.onPanel(this.panelContainer.getPanelView(i2));
                } else {
                    onPanelChangeListener.onKeyboard();
                }
            }
        }
    }

    private final void notifyPanelSizeChange(IPanelView iPanelView, boolean z, int i2, int i3, int i4, int i5) {
        List<OnPanelChangeListener> list = this.panelChangeListeners;
        if (list != null) {
            for (OnPanelChangeListener onPanelChangeListener : list) {
                onPanelChangeListener.onPanelSizeChange(iPanelView, z, i2, i3, i4, i5);
            }
        }
    }

    public final void notifyViewClick(View view) {
        List<OnViewClickListener> list = this.viewClickListeners;
        if (list != null) {
            for (OnViewClickListener onViewClickListener : list) {
                onViewClickListener.onClickBefore(view);
            }
        }
    }

    private final boolean reverseResetState() {
        return (isResetState(this.lastPanelId) && !isResetState(this.panelId)) || (!isResetState(this.lastPanelId) && isResetState(this.panelId));
    }

    @TargetApi(19)
    private final void setTransition(long j2, int i2) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(j2);
        TransitionManager.beginDelayedTransition(this, changeBounds);
    }

    public static /* synthetic */ void toKeyboardState$panel_release$default(PanelSwitchLayout panelSwitchLayout, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        panelSwitchLayout.toKeyboardState$panel_release(z);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.effective.android.panel.interfaces.ViewAssertion
    public void assertView() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(0);
            View childAt2 = getChildAt(1);
            if (childAt instanceof IContentContainer) {
                this.contentContainer = (IContentContainer) childAt;
                if (childAt2 instanceof PanelContainer) {
                    this.panelContainer = (PanelContainer) childAt2;
                    return;
                }
                throw new RuntimeException("PanelSwitchLayout -- the second view is a ContentContainer, but the other isn't a PanelContainer！");
            }
            throw new RuntimeException("PanelSwitchLayout -- the first view isn't a IContentContainer");
        }
        throw new RuntimeException("PanelSwitchLayout -- PanelSwitchLayout should has two children,the first is ContentContainer,the other is PanelContainer！");
    }

    public final void bindListener$panel_release(@d List<OnViewClickListener> list, @d List<OnPanelChangeListener> list2, @d List<OnKeyboardStateListener> list3, @d List<OnEditFocusChangeListener> list4) {
        this.viewClickListeners = list;
        this.panelChangeListeners = list2;
        this.keyboardStatusListeners = list3;
        this.editFocusChangeListeners = list4;
    }

    public final void bindWindow$panel_release(@d final Window window) {
        this.window = window;
        window.setSoftInputMode(19);
        final DeviceRuntime deviceRuntime = new DeviceRuntime(getContext(), window);
        this.deviceRuntime = deviceRuntime;
        if (deviceRuntime != null) {
            IInputAction inputActionImpl = this.contentContainer.getInputActionImpl();
            boolean isFullScreen = deviceRuntime.isFullScreen();
            int i2 = this.panelId;
            inputActionImpl.updateFullScreenParams(isFullScreen, i2, getCompatPanelHeight(i2));
            this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.effective.android.panel.view.PanelSwitchLayout$bindWindow$$inlined$let$lambda$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    int currentStatusBarHeight;
                    int currentNavigationHeight;
                    int androidQNavHIfNavIsInvisible;
                    int i3;
                    int i4;
                    int i5;
                    boolean z;
                    boolean z2;
                    int i6;
                    Integer num;
                    Boolean bool;
                    int i7;
                    boolean z3;
                    int i8;
                    int i9;
                    boolean z4;
                    LogFormatter up$default = LogFormatter.Companion.setUp$default(LogFormatter.Companion, 0, 1, null);
                    LogFormatter.addContent$default(up$default, null, "界面每一次变化的信息回调", 1, null);
                    up$default.addContent("windowSoftInputMode", String.valueOf(window.getAttributes().softInputMode));
                    up$default.addContent("currentPanelSwitchLayoutVisible", String.valueOf(this.getVisibility() == 0));
                    if (this.getVisibility() != 0) {
                        LogFormatter.addContent$default(up$default, null, "skip cal keyboard Height When window is invisible!", 1, null);
                    }
                    int screenRealHeight = DisplayUtil.INSTANCE.getScreenRealHeight(window);
                    int screenHeightWithoutSystemUI = DisplayUtil.getScreenHeightWithoutSystemUI(window);
                    DeviceInfo deviceInfoByOrientation = deviceRuntime.getDeviceInfoByOrientation(true);
                    currentStatusBarHeight = this.getCurrentStatusBarHeight(deviceInfoByOrientation);
                    currentNavigationHeight = this.getCurrentNavigationHeight(deviceRuntime, deviceInfoByOrientation);
                    androidQNavHIfNavIsInvisible = this.getAndroidQNavHIfNavIsInvisible(deviceRuntime, window);
                    int i10 = currentStatusBarHeight + currentNavigationHeight + androidQNavHIfNavIsInvisible;
                    up$default.addContent("screenHeight", String.valueOf(screenRealHeight));
                    up$default.addContent("contentHeight", String.valueOf(screenHeightWithoutSystemUI));
                    up$default.addContent("isFullScreen", String.valueOf(deviceRuntime.isFullScreen()));
                    up$default.addContent("isNavigationBarShown", String.valueOf(deviceRuntime.isNavigationBarShow()));
                    up$default.addContent("deviceStatusBarH", String.valueOf(deviceInfoByOrientation.getStatusBarH()));
                    up$default.addContent("deviceNavigationBarH", String.valueOf(deviceInfoByOrientation.getNavigationBarH()));
                    if (Build.VERSION.SDK_INT >= 23) {
                        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
                        up$default.addContent("systemInset", "left(" + rootWindowInsets.getSystemWindowInsetTop() + ") top(" + rootWindowInsets.getSystemWindowInsetLeft() + ") right(" + rootWindowInsets.getSystemWindowInsetRight() + ") bottom(" + rootWindowInsets.getSystemWindowInsetBottom() + ')');
                        up$default.addContent("inset", "left(" + rootWindowInsets.getStableInsetLeft() + ") top(" + rootWindowInsets.getStableInsetTop() + ") right(" + rootWindowInsets.getStableInsetRight() + ") bottom(" + rootWindowInsets.getStableInsetBottom() + ')');
                    }
                    up$default.addContent("currentSystemInfo", "statusBarH : " + currentStatusBarHeight + ", navigationBarH : " + currentNavigationHeight + " 全面屏手势虚拟栏H : " + androidQNavHIfNavIsInvisible);
                    up$default.addContent("currentSystemH", String.valueOf(i10));
                    this.lastNavigationBarShow = Boolean.valueOf(deviceRuntime.isNavigationBarShow());
                    int i11 = (screenRealHeight - screenHeightWithoutSystemUI) - i10;
                    int i12 = i11 + androidQNavHIfNavIsInvisible;
                    PanelSwitchLayout panelSwitchLayout = this;
                    if (deviceInfoByOrientation.getNavigationBarH() > androidQNavHIfNavIsInvisible) {
                        androidQNavHIfNavIsInvisible = deviceInfoByOrientation.getNavigationBarH();
                    }
                    panelSwitchLayout.minLimitCloseKeyboardHeight = androidQNavHIfNavIsInvisible;
                    i3 = this.minLimitCloseKeyboardHeight;
                    up$default.addContent("minLimitCloseKeyboardH", String.valueOf(i3));
                    i4 = this.minLimitOpenKeyboardHeight;
                    up$default.addContent("minLimitOpenKeyboardH", String.valueOf(i4));
                    i5 = this.lastKeyboardHeight;
                    up$default.addContent("lastKeyboardH", String.valueOf(i5));
                    StringBuilder sb = new StringBuilder();
                    sb.append("keyboardH : ");
                    sb.append(i11);
                    sb.append(", realKeyboardH : ");
                    sb.append(i12);
                    sb.append(", isShown : ");
                    z = this.isKeyboardShowing;
                    sb.append(z);
                    up$default.addContent("currentKeyboardInfo", sb.toString());
                    z2 = this.isKeyboardShowing;
                    if (z2) {
                        i8 = this.minLimitOpenKeyboardHeight;
                        if (i11 <= i8) {
                            this.isKeyboardShowing = false;
                            if (this.isKeyboardState$panel_release()) {
                                PanelSwitchLayout.checkoutPanel$panel_release$default(this, -1, false, 2, null);
                            }
                            this.notifyKeyboardState(false);
                        } else {
                            i9 = this.lastKeyboardHeight;
                            if (i11 != i9) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("try to set KeyBoardHeight : ");
                                sb2.append(i12);
                                sb2.append("，isShow ");
                                z4 = this.isKeyboardShowing;
                                sb2.append(z4);
                                LogTracker.log(this.getTAG() + "#onGlobalLayout", sb2.toString());
                                PanelUtil.setKeyBoardHeight(this.getContext(), i12);
                                this.requestLayout();
                            }
                        }
                    } else {
                        i6 = this.minLimitOpenKeyboardHeight;
                        if (i11 > i6) {
                            this.isKeyboardShowing = true;
                            i7 = this.lastKeyboardHeight;
                            if (i11 > i7) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("try to set KeyBoardHeight : ");
                                sb3.append(i12);
                                sb3.append("，isShow ");
                                z3 = this.isKeyboardShowing;
                                sb3.append(z3);
                                LogTracker.log(this.getTAG() + "#onGlobalLayout", sb3.toString());
                                PanelUtil.setKeyBoardHeight(this.getContext(), i12);
                                this.requestLayout();
                            }
                            if (!this.isKeyboardState$panel_release()) {
                                this.checkoutPanel$panel_release(0, false);
                            }
                            this.notifyKeyboardState(true);
                        } else {
                            num = this.lastContentHeight;
                            if (num != null) {
                                int intValue = num.intValue();
                                bool = this.lastNavigationBarShow;
                                if (bool != null) {
                                    boolean booleanValue = bool.booleanValue();
                                    if (intValue != screenHeightWithoutSystemUI && booleanValue != deviceRuntime.isNavigationBarShow()) {
                                        this.requestLayout();
                                        LogTracker.log(this.getTAG() + "#onGlobalLayout", "update layout by navigation visibility State change");
                                    }
                                }
                            }
                        }
                    }
                    this.lastKeyboardHeight = i11;
                    this.lastContentHeight = Integer.valueOf(screenHeightWithoutSystemUI);
                    up$default.log(this.getTAG() + "#onGlobalLayout");
                }
            };
            window.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            this.hasAttachLister = true;
        }
    }

    public final boolean checkoutPanel$panel_release(int i2, boolean z) {
        if (this.doingCheckout) {
            LogTracker.log(this.TAG$1 + "#checkoutPanel", "is checkouting,just ignore!");
            return false;
        }
        this.doingCheckout = true;
        if (i2 == this.panelId) {
            LogTracker.log(this.TAG$1 + "#checkoutPanel", "current panelId is " + i2 + " ,just ignore!");
            this.doingCheckout = false;
            return false;
        }
        if (i2 == -1) {
            this.contentContainer.getInputActionImpl().hideKeyboard(true);
            this.contentContainer.getResetActionImpl().enableReset(false);
        } else if (i2 != 0) {
            Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()), Integer.valueOf(getCompatPanelHeight(i2)));
            Pair<Integer, Integer> showPanel = this.panelContainer.showPanel(i2, pair);
            if ((!f0.g((Integer) pair.first, (Integer) showPanel.first)) || (!f0.g((Integer) pair.second, (Integer) showPanel.second))) {
                notifyPanelSizeChange(this.panelContainer.getPanelView(i2), DisplayUtil.isPortrait(getContext()), ((Number) showPanel.first).intValue(), ((Number) showPanel.second).intValue(), ((Number) pair.first).intValue(), ((Number) pair.second).intValue());
            }
            this.contentContainer.getInputActionImpl().hideKeyboard(false);
            this.contentContainer.getResetActionImpl().enableReset(true);
        } else if (z && !this.contentContainer.getInputActionImpl().showKeyboard()) {
            LogTracker.log(this.TAG$1 + "#checkoutPanel", "system show keyboard fail, just ignore!");
            this.doingCheckout = false;
            return false;
        } else {
            this.contentContainer.getResetActionImpl().enableReset(true);
        }
        this.lastPanelId = this.panelId;
        this.panelId = i2;
        LogTracker.log(this.TAG$1 + "#checkoutPanel", "checkout success ! lastPanel's id : " + this.lastPanelId + " , panel's id :" + i2);
        requestLayout();
        notifyPanelChange(this.panelId);
        this.doingCheckout = false;
        return true;
    }

    @d
    public final IContentContainer getContentContainer$panel_release() {
        return this.contentContainer;
    }

    @d
    public final String getTAG() {
        return this.TAG$1;
    }

    public final boolean hookSystemBackByPanelSwitcher$panel_release() {
        if (isResetState$panel_release()) {
            return false;
        }
        if (isKeyboardState$panel_release()) {
            if (this.isKeyboardShowing) {
                this.contentContainer.getInputActionImpl().hideKeyboard(true);
            } else {
                checkoutPanel$panel_release$default(this, -1, false, 2, null);
                return false;
            }
        } else {
            checkoutPanel$panel_release$default(this, -1, false, 2, null);
        }
        return true;
    }

    public final boolean isContentScrollOutsizeEnable$panel_release() {
        return this.contentScrollOutsizeEnable;
    }

    public final boolean isKeyboardState$panel_release() {
        return isKeyboardState(this.panelId);
    }

    public final boolean isPanelState$panel_release() {
        return isPanelState(this.panelId);
    }

    public final boolean isResetState$panel_release() {
        return isResetState(this.panelId);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        super.onAttachedToWindow();
        if (this.hasAttachLister || (onGlobalLayoutListener = this.globalLayoutListener) == null) {
            return;
        }
        this.window.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        this.hasAttachLister = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        assertView();
        initListener();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getVisibility() != 0) {
            LogTracker.log(this.TAG$1 + "#onLayout", "isGone，skip");
            return;
        }
        DeviceRuntime deviceRuntime = this.deviceRuntime;
        if (deviceRuntime != null) {
            LogFormatter up$default = LogFormatter.Companion.setUp$default(LogFormatter.Companion, 0, 1, null);
            DeviceInfo deviceInfoByOrientation$default = DeviceRuntime.getDeviceInfoByOrientation$default(deviceRuntime, false, 1, null);
            int compatPanelHeight = getCompatPanelHeight(this.panelId);
            int paddingTop = getPaddingTop();
            int screenH = deviceInfoByOrientation$default.getScreenH();
            if (deviceRuntime.isNavigationBarShow()) {
                screenH -= deviceInfoByOrientation$default.getCurrentNavigationBarHeightWhenVisible(deviceRuntime.isPortrait(), deviceRuntime.isPad());
            }
            int[] locationOnScreen = DisplayUtil.getLocationOnScreen(this);
            int i6 = screenH - locationOnScreen[1];
            int contentContainerTop = getContentContainerTop(compatPanelHeight) + paddingTop;
            int contentContainerHeight = getContentContainerHeight(i6, paddingTop, compatPanelHeight);
            int i7 = contentContainerTop + contentContainerHeight;
            if (Constants.DEBUG) {
                LogFormatter.addContent$default(up$default, null, "界面每一次 layout 的信息回调", 1, null);
                up$default.addContent("layoutInfo", "onLayout(changed : " + z + " , l : " + i2 + "  , t : " + i3 + " , r : " + i4 + " , b : " + i5 + ')');
                int i8 = this.panelId;
                up$default.addContent("currentPanelState", i8 != -1 ? i8 != 0 ? "显示面板输入" : "显示键盘输入" : "收起所有输入源");
                up$default.addContent("isPad", String.valueOf(deviceRuntime.isPad()));
                up$default.addContent("isFullScreen", String.valueOf(deviceRuntime.isFullScreen()));
                up$default.addContent("isPortrait", String.valueOf(deviceRuntime.isPortrait()));
                up$default.addContent("isNavigationShown", String.valueOf(deviceRuntime.isNavigationBarShow()));
                up$default.addContent("screenH (static,include SystemUI)", String.valueOf(deviceInfoByOrientation$default.getScreenH()));
                up$default.addContent("screenH (static,exclude SystemUI)", String.valueOf(deviceInfoByOrientation$default.getScreenWithoutNavigationH()));
                up$default.addContent("screenH (dynamic,exclude SystemUI)", String.valueOf(deviceInfoByOrientation$default.getScreenWithoutSystemUiH()));
                up$default.addContent("localLocation[y]", String.valueOf(locationOnScreen[1]));
                up$default.addContent("toolbarH", String.valueOf(deviceInfoByOrientation$default.getToolbarH()));
                up$default.addContent("StatusBarH", String.valueOf(deviceInfoByOrientation$default.getStatusBarH()));
                up$default.addContent("NavigationBarH", String.valueOf(deviceInfoByOrientation$default.getNavigationBarH()));
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                sb.append(locationOnScreen[0]);
                sb.append(',');
                sb.append(locationOnScreen[1]);
                sb.append(')');
                up$default.addContent("layout Location", sb.toString());
                up$default.addContent("paddingTop", String.valueOf(paddingTop));
                up$default.addContent("keyboardH", String.valueOf(PanelUtil.getKeyBoardHeight(getContext())));
                up$default.addContent("ContentContainerTop", String.valueOf(contentContainerTop));
                up$default.addContent("ContentContainerH", String.valueOf(contentContainerHeight));
                up$default.addContent("PanelContainerTop", String.valueOf(i7));
                up$default.addContent("PanelContainerH", String.valueOf(compatPanelHeight));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                boolean isBoundChange = isBoundChange(i2, contentContainerTop, i4, i7 + compatPanelHeight);
                up$default.addContent("changeBounds", String.valueOf(isBoundChange));
                if (isBoundChange) {
                    boolean reverseResetState = reverseResetState();
                    up$default.addContent("reverseResetState", String.valueOf(reverseResetState));
                    if (reverseResetState) {
                        setTransition(this.animationSpeed, this.panelId);
                    }
                } else {
                    int i9 = this.lastPanelHeight;
                    if (i9 != -1 && i9 != compatPanelHeight) {
                        setTransition(this.animationSpeed, this.panelId);
                    }
                }
            }
            this.contentContainer.layoutContainer(i2, contentContainerTop, i4, i7, this.contentScrollMeasurers, compatPanelHeight, this.contentScrollOutsizeEnable, isResetState$panel_release());
            StringBuilder sb2 = new StringBuilder();
            sb2.append('(');
            sb2.append(i2);
            sb2.append(',');
            sb2.append(contentContainerTop);
            sb2.append(',');
            sb2.append(i4);
            sb2.append(',');
            sb2.append(i7);
            sb2.append(')');
            up$default.addContent("contentContainer Layout", sb2.toString());
            this.contentContainer.changeContainerHeight(contentContainerHeight);
            int i10 = i7 + compatPanelHeight;
            this.panelContainer.layout(i2, i7, i4, i10);
            StringBuilder sb3 = new StringBuilder();
            sb3.append('(');
            sb3.append(i2);
            sb3.append(',');
            sb3.append(i7);
            sb3.append(',');
            sb3.append(i4);
            sb3.append(',');
            sb3.append(i10);
            sb3.append(')');
            up$default.addContent("panelContainer Layout", sb3.toString());
            this.panelContainer.changeContainerHeight(compatPanelHeight);
            this.lastPanelHeight = compatPanelHeight;
            this.contentContainer.getInputActionImpl().updateFullScreenParams(deviceRuntime.isFullScreen(), this.panelId, compatPanelHeight);
            up$default.log(this.TAG$1 + "#onLayout");
            return;
        }
        super.onLayout(z, i2, i3, i4, i5);
    }

    public final void recycle() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        removeCallbacks(this.retryCheckoutKbRunnable);
        removeCallbacks(this.keyboardStateRunnable);
        this.contentContainer.getInputActionImpl().recycler();
        if (!this.hasAttachLister || (onGlobalLayoutListener = this.globalLayoutListener) == null) {
            return;
        }
        this.window.getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        this.hasAttachLister = false;
    }

    public final void setContentScrollOutsizeEnable$panel_release(boolean z) {
        this.contentScrollOutsizeEnable = z;
    }

    public final void setPanelHeightMeasurers$panel_release(@d List<PanelHeightMeasurer> list) {
        for (PanelHeightMeasurer panelHeightMeasurer : list) {
            this.panelHeightMeasurers.put(Integer.valueOf(panelHeightMeasurer.getPanelTriggerId()), panelHeightMeasurer);
        }
    }

    public final void setScrollMeasurers$panel_release(@d List<ContentScrollMeasurer> list) {
        this.contentScrollMeasurers.addAll(list);
    }

    public final void setTAG(@d String str) {
        this.TAG$1 = str;
    }

    @h
    public final void toKeyboardState$panel_release() {
        toKeyboardState$panel_release$default(this, false, 1, null);
    }

    @h
    public final void toKeyboardState$panel_release(boolean z) {
        if (z) {
            post(this.keyboardStateRunnable);
        } else {
            this.contentContainer.getInputActionImpl().requestKeyboard();
        }
    }

    public /* synthetic */ PanelSwitchLayout(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @TargetApi(21)
    public PanelSwitchLayout(@e Context context, @e AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.contentScrollMeasurers = new ArrayList();
        this.panelHeightMeasurers = new HashMap<>();
        this.panelId = -1;
        this.lastPanelId = -1;
        this.lastPanelHeight = -1;
        this.animationSpeed = 200;
        this.contentScrollOutsizeEnable = true;
        this.keyboardStateRunnable = new Runnable() { // from class: com.effective.android.panel.view.PanelSwitchLayout$keyboardStateRunnable$1
            {
                PanelSwitchLayout.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PanelSwitchLayout.this.toKeyboardState$panel_release(false);
            }
        };
        this.retryCheckoutKbRunnable = new CheckoutKbRunnable();
        this.minLimitOpenKeyboardHeight = 300;
        initView(attributeSet, i2, i3);
    }
}
