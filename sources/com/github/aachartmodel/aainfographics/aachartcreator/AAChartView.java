package com.github.aachartmodel.aainfographics.aachartcreator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import h.k2.h;
import h.k2.v.f0;
import h.t2.u;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0004\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001`B\u0011\b\u0016\u0012\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bY\u0010ZB\u001b\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\bY\u0010]B#\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\u0006\u0010^\u001a\u00020,¢\u0006\u0004\bY\u0010_J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\bJ\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\bJ\u001b\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0004\b#\u0010$J#\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b#\u0010'J\u001d\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020%¢\u0006\u0004\b*\u0010+J)\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020%H\u0007¢\u0006\u0004\b/\u00100J5\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020%2\u0006\u0010.\u001a\u00020%2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b/\u00101J\u0015\u00102\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b4\u00103J\u0015\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020!¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b8\u00103J\u0015\u0010:\u001a\u00020\u00022\u0006\u00109\u001a\u00020\r¢\u0006\u0004\b:\u0010\u0015R.\u0010<\u001a\u0004\u0018\u00010%2\b\u0010;\u001a\u0004\u0018\u00010%8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b<\u0010>\"\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR.\u0010D\u001a\u0004\u0018\u00010C2\b\u0010;\u001a\u0004\u0018\u00010C8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR.\u0010J\u001a\u0004\u0018\u00010%2\b\u0010;\u001a\u0004\u0018\u00010%8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010=\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R.\u0010M\u001a\u0004\u0018\u00010C2\b\u0010;\u001a\u0004\u0018\u00010C8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010E\u001a\u0004\bN\u0010G\"\u0004\bO\u0010IR$\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006a"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;", "Landroid/webkit/WebView;", "Lh/t1;", "setupBasicContent", "()V", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "aaOptions", "loadLocalFilesAndDrawChart", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;)V", "chartOptions", "configureChartOptionsAndDrawChart", "showJavaScriptAlertView", "", "", "", "messageBody", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "getEventMessageModel", "(Ljava/util/Map;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "javaScriptString", "safeEvaluateJavaScriptString", "(Ljava/lang/String;)V", "message", "androidMethod", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "chartModel", "aa_drawChartWithChartModel", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;)V", "aa_refreshChartWithChartModel", "aa_drawChartWithChartOptions", "aa_refreshChartWithChartOptions", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "seriesElementsArr", "aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;)V", "", "animation", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;Z)V", "options", "redraw", "aa_updateChartWithOptions", "(Ljava/lang/Object;Z)V", "", "elementIndex", "shift", "aa_addPointToChartSeriesElement", "(ILjava/lang/Object;Z)V", "(ILjava/lang/Object;ZZZ)V", "aa_showTheSeriesElementContent", "(I)V", "aa_hideTheSeriesElementContent", "aaSeriesElement", "aa_addElementToChartSeries", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;)V", "aa_removeElementFromChartSeries", "jsFunctionStr", "aa_evaluateTheJavaScriptStringFunction", "value", "isClearBackgroundColor", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setClearBackgroundColor", "(Ljava/lang/Boolean;)V", "optionsJson", "Ljava/lang/String;", "", "contentHeight", "Ljava/lang/Number;", "getContentHeight", "()Ljava/lang/Number;", "setContentHeight", "(Ljava/lang/Number;)V", "chartSeriesHidden", "getChartSeriesHidden", "setChartSeriesHidden", "contentWidth", "getContentWidth", "setContentWidth", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "callBack", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "getCallBack", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "setCallBack", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AAChartViewCallBack", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAChartView extends WebView {
    private HashMap _$_findViewCache;
    @e
    private AAChartViewCallBack callBack;
    @e
    private Boolean chartSeriesHidden;
    @e
    private Number contentHeight;
    @e
    private Number contentWidth;
    @e
    private Boolean isClearBackgroundColor;
    private String optionsJson;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;", "aaChartView", "Lh/t1;", "chartViewDidFinishLoad", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;)V", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "messageModel", "chartViewMoveOverEventMessage", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;)V", "charts_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public interface AAChartViewCallBack {
        void chartViewDidFinishLoad(@d AAChartView aAChartView);

        void chartViewMoveOverEventMessage(@d AAChartView aAChartView, @d AAMoveOverEventMessageModel aAMoveOverEventMessageModel);
    }

    public AAChartView(@d Context context) {
        super(context);
        setupBasicContent();
    }

    public static /* synthetic */ void aa_addPointToChartSeriesElement$default(AAChartView aAChartView, int i2, Object obj, boolean z, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        aAChartView.aa_addPointToChartSeriesElement(i2, obj, z);
    }

    public final void configureChartOptionsAndDrawChart(AAOptions aAOptions) {
        if (this.isClearBackgroundColor.booleanValue()) {
            aAOptions.getChart().backgroundColor("rgba(0,0,0,0)");
        }
        String z = new Gson().z(aAOptions);
        this.optionsJson = z;
        safeEvaluateJavaScriptString("loadTheHighChartView('" + z + "','" + this.contentWidth + "','" + this.contentHeight + "')");
    }

    private final AAMoveOverEventMessageModel getEventMessageModel(Map<String, ? extends Object> map) {
        AAMoveOverEventMessageModel aAMoveOverEventMessageModel = new AAMoveOverEventMessageModel();
        aAMoveOverEventMessageModel.setName(String.valueOf(map.get("name")));
        aAMoveOverEventMessageModel.setX((Double) map.get("x"));
        aAMoveOverEventMessageModel.setY((Double) map.get("y"));
        aAMoveOverEventMessageModel.setCategory(String.valueOf(map.get("category")));
        aAMoveOverEventMessageModel.setOffset((LinkedTreeMap) map.get("offset"));
        Double d2 = (Double) map.get("index");
        aAMoveOverEventMessageModel.setIndex(d2 != null ? Integer.valueOf((int) d2.doubleValue()) : null);
        return aAMoveOverEventMessageModel;
    }

    private final void loadLocalFilesAndDrawChart(final AAOptions aAOptions) {
        loadUrl("file:///android_asset/AAChartView.html");
        setWebViewClient(new WebViewClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$loadLocalFilesAndDrawChart$1
            {
                AAChartView.this = this;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(@d WebView webView, @d String str) {
                AAChartView.this.configureChartOptionsAndDrawChart(aAOptions);
                AAChartView.AAChartViewCallBack callBack = AAChartView.this.getCallBack();
                if (callBack != null) {
                    callBack.chartViewDidFinishLoad(AAChartView.this);
                }
            }
        });
    }

    private final void safeEvaluateJavaScriptString(String str) {
        if (isInEditMode()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript("javascript:" + str, AAChartView$safeEvaluateJavaScriptString$1.INSTANCE);
            return;
        }
        loadUrl("javascript:" + str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupBasicContent() {
        if (isInEditMode()) {
            return;
        }
        setContentWidth(Float.valueOf(420.0f));
        setContentHeight(Float.valueOf(580.0f));
        setClearBackgroundColor(Boolean.FALSE);
        getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        addJavascriptInterface(this, "androidObject");
    }

    private final void showJavaScriptAlertView() {
        setWebChromeClient(new WebChromeClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$showJavaScriptAlertView$1
            {
                AAChartView.this = this;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(@d WebView webView, @d String str, @d String str2, @d JsResult jsResult) {
                super.onJsAlert(webView, str, str2, jsResult);
                new AlertDialog.Builder(AAChartView.this.getContext()).setTitle("JavaScript alert Information").setMessage(("url --->" + str + "\n\n\n") + ("message --->" + str2 + "\n\n\n") + ("result --->" + jsResult)).setNeutralButton("sure", (DialogInterface.OnClickListener) null).show();
                return true;
            }
        });
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

    public final void aa_addElementToChartSeries(@d AASeriesElement aASeriesElement) {
        String z = new Gson().z(aASeriesElement);
        safeEvaluateJavaScriptString("addElementToChartSeriesWithElement('" + z + "')");
    }

    @h
    public final void aa_addPointToChartSeriesElement(int i2, @d Object obj) {
        aa_addPointToChartSeriesElement$default(this, i2, obj, false, 4, null);
    }

    @h
    public final void aa_addPointToChartSeriesElement(int i2, @d Object obj, boolean z) {
        aa_addPointToChartSeriesElement(i2, obj, true, z, true);
    }

    public final void aa_drawChartWithChartModel(@d AAChartModel aAChartModel) {
        aa_drawChartWithChartOptions(AAChartModelKt.aa_toAAOptions(aAChartModel));
    }

    public final void aa_drawChartWithChartOptions(@d AAOptions aAOptions) {
        if (this.optionsJson != null) {
            aa_refreshChartWithChartOptions(aAOptions);
            return;
        }
        loadLocalFilesAndDrawChart(aAOptions);
        showJavaScriptAlertView();
    }

    public final void aa_evaluateTheJavaScriptStringFunction(@d String str) {
        String pureJavaScriptFunctionString = AAJSStringPurer.INSTANCE.pureJavaScriptFunctionString(str);
        safeEvaluateJavaScriptString("evaluateTheJavaScriptStringFunction('" + pureJavaScriptFunctionString + "')");
    }

    public final void aa_hideTheSeriesElementContent(int i2) {
        safeEvaluateJavaScriptString("hideTheSeriesElementContentWithIndex('" + i2 + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@d AASeriesElement[] aASeriesElementArr) {
        aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(aASeriesElementArr, true);
    }

    public final void aa_refreshChartWithChartModel(@d AAChartModel aAChartModel) {
        aa_refreshChartWithChartOptions(AAChartModelKt.aa_toAAOptions(aAChartModel));
    }

    public final void aa_refreshChartWithChartOptions(@d AAOptions aAOptions) {
        configureChartOptionsAndDrawChart(aAOptions);
    }

    public final void aa_removeElementFromChartSeries(int i2) {
        safeEvaluateJavaScriptString("removeElementFromChartSeriesWithElementIndex('" + i2 + "')");
    }

    public final void aa_showTheSeriesElementContent(int i2) {
        safeEvaluateJavaScriptString("showTheSeriesElementContentWithIndex('" + i2 + "')");
    }

    public final void aa_updateChartWithOptions(@d Object obj, boolean z) {
        String z2;
        if (obj instanceof AAOptions) {
            z2 = new Gson().z(obj);
        } else {
            String k2 = u.k2(obj.getClass().getSimpleName(), "AA", "", false, 4, null);
            Objects.requireNonNull(k2, "null cannot be cast to non-null type java.lang.String");
            String substring = k2.substring(0, 1);
            Locale locale = Locale.ROOT;
            Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(locale);
            Objects.requireNonNull(k2, "null cannot be cast to non-null type java.lang.String");
            String str = lowerCase + k2.substring(1);
            HashMap hashMap = new HashMap();
            hashMap.put(str, obj);
            z2 = new Gson().z(hashMap);
        }
        safeEvaluateJavaScriptString("updateChart('" + z2 + "','" + z + "')");
    }

    @JavascriptInterface
    @d
    public final String androidMethod(@e String str) {
        AAMoveOverEventMessageModel eventMessageModel = getEventMessageModel((HashMap) new Gson().n(str, new HashMap().getClass()));
        AAChartViewCallBack aAChartViewCallBack = this.callBack;
        if (aAChartViewCallBack != null) {
            aAChartViewCallBack.chartViewMoveOverEventMessage(this, eventMessageModel);
            return "";
        }
        return "";
    }

    @e
    public final AAChartViewCallBack getCallBack() {
        return this.callBack;
    }

    @e
    public final Boolean getChartSeriesHidden() {
        return this.chartSeriesHidden;
    }

    @Override // android.webkit.WebView
    @e
    public final Number getContentHeight() {
        return this.contentHeight;
    }

    @e
    public final Number getContentWidth() {
        return this.contentWidth;
    }

    @e
    public final Boolean isClearBackgroundColor() {
        return this.isClearBackgroundColor;
    }

    public final void setCallBack(@e AAChartViewCallBack aAChartViewCallBack) {
        this.callBack = aAChartViewCallBack;
    }

    public final void setChartSeriesHidden(@e Boolean bool) {
        this.chartSeriesHidden = bool;
        safeEvaluateJavaScriptString("setChartSeriesHidden('" + this.chartSeriesHidden + "')");
    }

    public final void setClearBackgroundColor(@e Boolean bool) {
        this.isClearBackgroundColor = bool;
        if (f0.g(bool, Boolean.TRUE)) {
            setBackgroundColor(0);
            Drawable background = getBackground();
            if (background != null) {
                background.setAlpha(0);
                return;
            }
            return;
        }
        setBackgroundColor(1);
        Drawable background2 = getBackground();
        if (background2 != null) {
            background2.setAlpha(255);
        }
    }

    public final void setContentHeight(@e Number number) {
        this.contentHeight = number;
        safeEvaluateJavaScriptString("setTheChartViewContentHeight('" + this.contentHeight + "')");
    }

    public final void setContentWidth(@e Number number) {
        this.contentWidth = number;
        safeEvaluateJavaScriptString("setTheChartViewContentWidth('" + this.contentWidth + "')");
    }

    public final void aa_addPointToChartSeriesElement(int i2, @d Object obj, boolean z, boolean z2, boolean z3) {
        String obj2;
        if (!(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double)) {
            obj2 = new Gson().z(obj);
        } else {
            obj2 = obj.toString();
        }
        safeEvaluateJavaScriptString("addPointToChartSeries('" + i2 + "','" + obj2 + "','" + z + "','" + z2 + "','" + z3 + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@d AASeriesElement[] aASeriesElementArr, boolean z) {
        String z2 = new Gson().z(aASeriesElementArr);
        safeEvaluateJavaScriptString("onlyRefreshTheChartDataWithSeries('" + z2 + "','" + z + "')");
    }

    public AAChartView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setupBasicContent();
    }

    public AAChartView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setupBasicContent();
    }
}
