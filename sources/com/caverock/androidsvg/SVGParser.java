package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.moor.imkf.event.VoiceToTextEvent;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.android.tpush.common.MessageKey;
import i.b.q0;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import k.b.a.a.n.l;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

/* loaded from: classes.dex */
public class SVGParser extends DefaultHandler2 {
    private static final String A = "mask";
    private static final String B = "path";
    private static final String C = "pattern";
    private static final String D = "polygon";
    private static final String E = "polyline";
    private static final String F = "radialGradient";
    private static final String G = "rect";
    private static final String H = "solidColor";
    private static final String I = "stop";
    private static final String J = "style";
    private static final String K = "switch";
    private static final String L = "symbol";
    private static final String M = "text";
    private static final String N = "textPath";
    private static final String O = "title";
    private static final String P = "tref";
    private static final String Q = "tspan";
    private static final String R = "use";
    private static final String S = "view";
    private static final String T = "none";
    private static final String U = "currentColor";
    private static final String V = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String W = "|visible|hidden|collapse|";
    private static HashMap<String, Integer> X = new HashMap<>();
    private static HashMap<String, SVG.n> Y = new HashMap<>(9);
    private static HashMap<String, Integer> Z = new HashMap<>(13);
    private static HashMap<String, SVG.Style.FontStyle> a0 = new HashMap<>(3);
    private static HashMap<String, PreserveAspectRatio.Alignment> b0 = new HashMap<>();
    public static HashSet<String> c0 = new HashSet<>();
    private static /* synthetic */ int[] d0 = null;

    /* renamed from: k  reason: collision with root package name */
    private static final String f2533k = "SVGParser";

    /* renamed from: l  reason: collision with root package name */
    private static final String f2534l = "http://www.w3.org/2000/svg";

    /* renamed from: m  reason: collision with root package name */
    private static final String f2535m = "http://www.w3.org/1999/xlink";
    private static final String n = "http://www.w3.org/TR/SVG11/feature#";
    private static final String o = "svg";
    private static final String p = "a";
    private static final String q = "circle";
    private static final String r = "clipPath";
    private static final String s = "defs";
    private static final String t = "desc";
    private static final String u = "ellipse";
    private static final String v = "g";
    private static final String w = "image";
    private static final String x = "line";
    private static final String y = "linearGradient";
    private static final String z = "marker";

    /* renamed from: d  reason: collision with root package name */
    private int f2537d;
    private SVG a = null;
    private SVG.g0 b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2536c = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2538e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f2539f = null;

    /* renamed from: g  reason: collision with root package name */
    private StringBuilder f2540g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2541h = false;

    /* renamed from: i  reason: collision with root package name */
    private StringBuilder f2542i = null;

    /* renamed from: j  reason: collision with root package name */
    private HashSet<String> f2543j = null;

    /* loaded from: classes.dex */
    public enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        id,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        public static SVGAttr fromString(String str) {
            if (str.equals("class")) {
                return CLASS;
            }
            if (str.indexOf(95) != -1) {
                return UNSUPPORTED;
            }
            try {
                return valueOf(str.replace(l.f16189d, '_'));
            } catch (IllegalArgumentException unused) {
                return UNSUPPORTED;
            }
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SVGAttr[] valuesCustom() {
            SVGAttr[] valuesCustom = values();
            int length = valuesCustom.length;
            SVGAttr[] sVGAttrArr = new SVGAttr[length];
            System.arraycopy(valuesCustom, 0, sVGAttrArr, 0, length);
            return sVGAttrArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public int b = 0;

        public a(String str) {
            this.a = str.trim();
        }

        private int w() {
            int i2;
            if (g()) {
                return this.b;
            }
            int i3 = this.b;
            int charAt = this.a.charAt(i3);
            if (charAt == 45 || charAt == 43) {
                charAt = a();
            }
            if (Character.isDigit(charAt)) {
                i2 = this.b + 1;
                charAt = a();
                while (Character.isDigit(charAt)) {
                    i2 = this.b + 1;
                    charAt = a();
                }
            } else {
                i2 = i3;
            }
            if (charAt == 46) {
                i2 = this.b + 1;
                charAt = a();
                while (Character.isDigit(charAt)) {
                    i2 = this.b + 1;
                    charAt = a();
                }
            }
            if (charAt == 101 || charAt == 69) {
                int a = a();
                if (a == 45 || a == 43) {
                    a = a();
                }
                if (Character.isDigit(a)) {
                    int a2 = a();
                    i2 = this.b + 1;
                    while (Character.isDigit(a2)) {
                        i2 = this.b + 1;
                        a2 = a();
                    }
                }
            }
            this.b = i3;
            return i2;
        }

        private int x() {
            int i2;
            if (g()) {
                return this.b;
            }
            int i3 = this.b;
            int charAt = this.a.charAt(i3);
            if (charAt == 45 || charAt == 43) {
                charAt = a();
            }
            if (Character.isDigit(charAt)) {
                i2 = this.b + 1;
                int a = a();
                while (Character.isDigit(a)) {
                    i2 = this.b + 1;
                    a = a();
                }
            } else {
                i2 = i3;
            }
            this.b = i3;
            return i2;
        }

        public int a() {
            if (this.b == this.a.length()) {
                return -1;
            }
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 < this.a.length()) {
                return this.a.charAt(this.b);
            }
            return -1;
        }

        public String b() {
            int i2 = this.b;
            while (!g() && !j(this.a.charAt(this.b))) {
                this.b++;
            }
            String substring = this.a.substring(i2, this.b);
            this.b = i2;
            return substring;
        }

        public Boolean c(Object obj) {
            if (obj == null) {
                return null;
            }
            y();
            return l();
        }

        public Float d(Object obj) {
            if (obj == null) {
                return null;
            }
            y();
            return m();
        }

        public boolean e(char c2) {
            boolean z = this.b < this.a.length() && this.a.charAt(this.b) == c2;
            if (z) {
                this.b++;
            }
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean f(java.lang.String r5) {
            /*
                r4 = this;
                int r0 = r5.length()
                int r1 = r4.b
                java.lang.String r2 = r4.a
                int r2 = r2.length()
                int r2 = r2 - r0
                if (r1 > r2) goto L21
                java.lang.String r1 = r4.a
                int r2 = r4.b
                int r3 = r2 + r0
                java.lang.String r1 = r1.substring(r2, r3)
                boolean r5 = r1.equals(r5)
                if (r5 == 0) goto L21
                r5 = 1
                goto L22
            L21:
                r5 = 0
            L22:
                if (r5 == 0) goto L29
                int r1 = r4.b
                int r1 = r1 + r0
                r4.b = r1
            L29:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.a.f(java.lang.String):boolean");
        }

        public boolean g() {
            return this.b == this.a.length();
        }

        public boolean h() {
            if (this.b == this.a.length()) {
                return false;
            }
            char charAt = this.a.charAt(this.b);
            if (charAt < 'a' || charAt > 'z') {
                return charAt >= 'A' && charAt <= 'Z';
            }
            return true;
        }

        public boolean i(int i2) {
            return i2 == 10 || i2 == 13;
        }

        public boolean j(int i2) {
            return i2 == 32 || i2 == 10 || i2 == 13 || i2 == 9;
        }

        public Integer k() {
            if (this.b == this.a.length()) {
                return null;
            }
            String str = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return Integer.valueOf(str.charAt(i2));
        }

        public Boolean l() {
            if (this.b == this.a.length()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if (charAt == '0' || charAt == '1') {
                this.b++;
                return Boolean.valueOf(charAt == '1');
            }
            return null;
        }

        public Float m() {
            int w = w();
            int i2 = this.b;
            if (w == i2) {
                return null;
            }
            Float valueOf = Float.valueOf(Float.parseFloat(this.a.substring(i2, w)));
            this.b = w;
            return valueOf;
        }

        public String n() {
            if (g()) {
                return null;
            }
            int i2 = this.b;
            int charAt = this.a.charAt(i2);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = a();
            }
            int i3 = this.b;
            while (j(charAt)) {
                charAt = a();
            }
            if (charAt == 40) {
                this.b++;
                return this.a.substring(i2, i3);
            }
            this.b = i2;
            return null;
        }

        public Integer o() {
            int x = x();
            int i2 = this.b;
            if (x == i2) {
                return null;
            }
            Integer valueOf = Integer.valueOf(Integer.parseInt(this.a.substring(i2, x)));
            this.b = x;
            return valueOf;
        }

        public SVG.n p() {
            Float m2 = m();
            if (m2 == null) {
                return null;
            }
            SVG.Unit t = t();
            if (t == null) {
                return new SVG.n(m2.floatValue(), SVG.Unit.px);
            }
            return new SVG.n(m2.floatValue(), t);
        }

        public String q() {
            if (g()) {
                return null;
            }
            int i2 = this.b;
            char charAt = this.a.charAt(i2);
            if (charAt == '\'' || charAt == '\"') {
                int a = a();
                while (a != -1 && a != charAt) {
                    a = a();
                }
                if (a == -1) {
                    this.b = i2;
                    return null;
                }
                int i3 = this.b + 1;
                this.b = i3;
                return this.a.substring(i2 + 1, i3 - 1);
            }
            return null;
        }

        public String r() {
            return s(' ');
        }

        public String s(char c2) {
            if (g()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if (j(charAt) || charAt == c2) {
                return null;
            }
            int i2 = this.b;
            int a = a();
            while (a != -1 && a != c2 && !j(a)) {
                a = a();
            }
            return this.a.substring(i2, this.b);
        }

        public SVG.Unit t() {
            if (g()) {
                return null;
            }
            if (this.a.charAt(this.b) == '%') {
                this.b++;
                return SVG.Unit.percent;
            } else if (this.b > this.a.length() - 2) {
                return null;
            } else {
                try {
                    String str = this.a;
                    int i2 = this.b;
                    SVG.Unit valueOf = SVG.Unit.valueOf(str.substring(i2, i2 + 2).toLowerCase(Locale.US));
                    this.b += 2;
                    return valueOf;
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
        }

        public Float u() {
            int i2 = this.b;
            y();
            Float m2 = m();
            if (m2 != null) {
                return m2;
            }
            this.b = i2;
            return null;
        }

        public String v() {
            if (g()) {
                return null;
            }
            int i2 = this.b;
            this.b = this.a.length();
            return this.a.substring(i2);
        }

        public boolean y() {
            z();
            if (this.b != this.a.length() && this.a.charAt(this.b) == ',') {
                this.b++;
                z();
                return true;
            }
            return false;
        }

        public void z() {
            while (this.b < this.a.length() && j(this.a.charAt(this.b))) {
                this.b++;
            }
        }
    }

    static {
        X.put("aliceblue", 15792383);
        X.put("antiquewhite", 16444375);
        X.put("aqua", 65535);
        X.put("aquamarine", 8388564);
        X.put("azure", 15794175);
        X.put("beige", 16119260);
        X.put("bisque", 16770244);
        X.put("black", 0);
        X.put("blanchedalmond", 16772045);
        X.put("blue", 255);
        X.put("blueviolet", 9055202);
        X.put("brown", 10824234);
        X.put("burlywood", 14596231);
        X.put("cadetblue", 6266528);
        X.put("chartreuse", 8388352);
        X.put("chocolate", 13789470);
        X.put("coral", 16744272);
        X.put("cornflowerblue", 6591981);
        X.put("cornsilk", 16775388);
        X.put("crimson", 14423100);
        X.put("cyan", 65535);
        X.put("darkblue", 139);
        X.put("darkcyan", 35723);
        X.put("darkgoldenrod", 12092939);
        X.put("darkgray", 11119017);
        X.put("darkgreen", 25600);
        X.put("darkgrey", 11119017);
        X.put("darkkhaki", 12433259);
        X.put("darkmagenta", 9109643);
        X.put("darkolivegreen", 5597999);
        X.put("darkorange", 16747520);
        X.put("darkorchid", 10040012);
        X.put("darkred", 9109504);
        X.put("darksalmon", 15308410);
        X.put("darkseagreen", 9419919);
        X.put("darkslateblue", 4734347);
        X.put("darkslategray", 3100495);
        X.put("darkslategrey", 3100495);
        X.put("darkturquoise", 52945);
        X.put("darkviolet", 9699539);
        X.put("deeppink", 16716947);
        X.put("deepskyblue", 49151);
        X.put("dimgray", 6908265);
        X.put("dimgrey", 6908265);
        X.put("dodgerblue", 2003199);
        X.put("firebrick", 11674146);
        X.put("floralwhite", 16775920);
        X.put("forestgreen", 2263842);
        X.put("fuchsia", 16711935);
        X.put("gainsboro", 14474460);
        X.put("ghostwhite", 16316671);
        X.put("gold", 16766720);
        X.put("goldenrod", 14329120);
        X.put("gray", 8421504);
        X.put("green", 32768);
        X.put("greenyellow", 11403055);
        X.put("grey", 8421504);
        X.put("honeydew", 15794160);
        X.put("hotpink", 16738740);
        X.put("indianred", 13458524);
        X.put("indigo", 4915330);
        X.put("ivory", 16777200);
        X.put("khaki", 15787660);
        X.put("lavender", 15132410);
        X.put("lavenderblush", 16773365);
        X.put("lawngreen", 8190976);
        X.put("lemonchiffon", 16775885);
        X.put("lightblue", 11393254);
        X.put("lightcoral", 15761536);
        X.put("lightcyan", 14745599);
        X.put("lightgoldenrodyellow", 16448210);
        X.put("lightgray", 13882323);
        X.put("lightgreen", 9498256);
        X.put("lightgrey", 13882323);
        X.put("lightpink", 16758465);
        X.put("lightsalmon", 16752762);
        X.put("lightseagreen", 2142890);
        X.put("lightskyblue", 8900346);
        X.put("lightslategray", 7833753);
        X.put("lightslategrey", 7833753);
        X.put("lightsteelblue", 11584734);
        X.put("lightyellow", 16777184);
        X.put("lime", 65280);
        X.put("limegreen", 3329330);
        X.put("linen", 16445670);
        X.put("magenta", 16711935);
        X.put("maroon", 8388608);
        X.put("mediumaquamarine", 6737322);
        X.put("mediumblue", Integer.valueOf((int) AdEventType.VIDEO_STOP));
        X.put("mediumorchid", 12211667);
        X.put("mediumpurple", 9662683);
        X.put("mediumseagreen", 3978097);
        X.put("mediumslateblue", 8087790);
        X.put("mediumspringgreen", 64154);
        X.put("mediumturquoise", 4772300);
        X.put("mediumvioletred", 13047173);
        X.put("midnightblue", 1644912);
        X.put("mintcream", 16121850);
        X.put("mistyrose", 16770273);
        X.put("moccasin", 16770229);
        X.put("navajowhite", 16768685);
        X.put("navy", 128);
        X.put("oldlace", 16643558);
        X.put("olive", 8421376);
        X.put("olivedrab", 7048739);
        X.put("orange", 16753920);
        X.put("orangered", 16729344);
        X.put("orchid", 14315734);
        X.put("palegoldenrod", 15657130);
        X.put("palegreen", 10025880);
        X.put("paleturquoise", 11529966);
        X.put("palevioletred", 14381203);
        X.put("papayawhip", 16773077);
        X.put("peachpuff", 16767673);
        X.put("peru", 13468991);
        X.put("pink", 16761035);
        X.put("plum", 14524637);
        X.put("powderblue", 11591910);
        X.put("purple", 8388736);
        X.put("red", Integer.valueOf((int) ItemTouchHelper.ACTION_MODE_DRAG_MASK));
        X.put("rosybrown", 12357519);
        X.put("royalblue", 4286945);
        X.put("saddlebrown", 9127187);
        X.put("salmon", 16416882);
        X.put("sandybrown", 16032864);
        X.put("seagreen", 3050327);
        X.put("seashell", 16774638);
        X.put("sienna", 10506797);
        X.put("silver", 12632256);
        X.put("skyblue", 8900331);
        X.put("slateblue", 6970061);
        X.put("slategray", 7372944);
        X.put("slategrey", 7372944);
        X.put("snow", 16775930);
        X.put("springgreen", 65407);
        X.put("steelblue", 4620980);
        X.put("tan", 13808780);
        X.put("teal", 32896);
        X.put("thistle", 14204888);
        X.put("tomato", 16737095);
        X.put("turquoise", 4251856);
        X.put("violet", 15631086);
        X.put("wheat", 16113331);
        X.put("white", 16777215);
        X.put("whitesmoke", 16119285);
        X.put("yellow", 16776960);
        X.put("yellowgreen", 10145074);
        HashMap<String, SVG.n> hashMap = Y;
        SVG.Unit unit = SVG.Unit.pt;
        hashMap.put("xx-small", new SVG.n(0.694f, unit));
        Y.put("x-small", new SVG.n(0.833f, unit));
        Y.put("small", new SVG.n(10.0f, unit));
        Y.put("medium", new SVG.n(12.0f, unit));
        Y.put("large", new SVG.n(14.4f, unit));
        Y.put("x-large", new SVG.n(17.3f, unit));
        Y.put("xx-large", new SVG.n(20.7f, unit));
        HashMap<String, SVG.n> hashMap2 = Y;
        SVG.Unit unit2 = SVG.Unit.percent;
        hashMap2.put("smaller", new SVG.n(83.33f, unit2));
        Y.put("larger", new SVG.n(120.0f, unit2));
        Z.put(PrerollVideoResponse.NORMAL, 400);
        Z.put("bold", 700);
        Z.put("bolder", 1);
        Z.put("lighter", -1);
        Z.put("100", 100);
        Z.put(BasicPushStatus.SUCCESS_CODE, 200);
        Z.put("300", 300);
        Z.put("400", 400);
        Z.put(VoiceToTextEvent.STATUS_FAIL, 500);
        Z.put("600", 600);
        Z.put("700", 700);
        Z.put("800", 800);
        Z.put("900", Integer.valueOf((int) TypedValues.Custom.TYPE_INT));
        a0.put(PrerollVideoResponse.NORMAL, SVG.Style.FontStyle.Normal);
        a0.put("italic", SVG.Style.FontStyle.Italic);
        a0.put("oblique", SVG.Style.FontStyle.Oblique);
        b0.put("none", PreserveAspectRatio.Alignment.None);
        b0.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
        b0.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
        b0.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
        b0.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
        b0.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
        b0.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
        b0.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
        b0.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
        b0.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        c0.add("Structure");
        c0.add("BasicStructure");
        c0.add("ConditionalProcessing");
        c0.add("Image");
        c0.add("Style");
        c0.add("ViewportAttribute");
        c0.add("Shape");
        c0.add("BasicText");
        c0.add("PaintAttribute");
        c0.add("BasicPaintAttribute");
        c0.add("OpacityAttribute");
        c0.add("BasicGraphicsAttribute");
        c0.add("Marker");
        c0.add("Gradient");
        c0.add("Pattern");
        c0.add("Clip");
        c0.add("BasicClip");
        c0.add("Mask");
        c0.add("View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A(com.caverock.androidsvg.SVG.w r8, org.xml.sax.Attributes r9) throws org.xml.sax.SAXException {
        /*
            r7 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r2 = 0
        L5:
            int r3 = r9.getLength()
            if (r2 < r3) goto Lc
            return
        Lc:
            java.lang.String r3 = r9.getValue(r2)
            java.lang.String r3 = r3.trim()
            int[] r4 = a()
            java.lang.String r5 = r9.getLocalName(r2)
            com.caverock.androidsvg.SVGParser$SVGAttr r5 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r5)
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 26
            if (r4 == r5) goto Laa
            r5 = 27
            if (r4 == r5) goto L9a
            java.lang.String r5 = "userSpaceOnUse"
            java.lang.String r6 = "objectBoundingBox"
            switch(r4) {
                case 45: goto L80;
                case 46: goto L79;
                case 47: goto L5f;
                default: goto L35;
            }
        L35:
            switch(r4) {
                case 82: goto L4a;
                case 83: goto L42;
                case 84: goto L3a;
                default: goto L38;
            }
        L38:
            goto Lb6
        L3a:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r8.u = r3
            goto Lb6
        L42:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r8.t = r3
            goto Lb6
        L4a:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r8.v = r3
            boolean r3 = r3.j()
            if (r3 != 0) goto L57
            goto Lb6
        L57:
            org.xml.sax.SAXException r8 = new org.xml.sax.SAXException
            java.lang.String r9 = "Invalid <pattern> element. width cannot be negative"
            r8.<init>(r9)
            throw r8
        L5f:
            boolean r4 = r6.equals(r3)
            if (r4 == 0) goto L68
            r8.q = r1
            goto Lb6
        L68:
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L71
            r8.q = r0
            goto Lb6
        L71:
            org.xml.sax.SAXException r8 = new org.xml.sax.SAXException
            java.lang.String r9 = "Invalid value for attribute patternUnits"
            r8.<init>(r9)
            throw r8
        L79:
            android.graphics.Matrix r3 = r7.u0(r3)
            r8.s = r3
            goto Lb6
        L80:
            boolean r4 = r6.equals(r3)
            if (r4 == 0) goto L89
            r8.r = r1
            goto Lb6
        L89:
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L92
            r8.r = r0
            goto Lb6
        L92:
            org.xml.sax.SAXException r8 = new org.xml.sax.SAXException
            java.lang.String r9 = "Invalid value for attribute patternContentUnits"
            r8.<init>(r9)
            throw r8
        L9a:
            java.lang.String r4 = r9.getURI(r2)
            java.lang.String r5 = "http://www.w3.org/1999/xlink"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto La7
            goto Lb6
        La7:
            r8.x = r3
            goto Lb6
        Laa:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r8.w = r3
            boolean r3 = r3.j()
            if (r3 != 0) goto Lba
        Lb6:
            int r2 = r2 + 1
            goto L5
        Lba:
            org.xml.sax.SAXException r8 = new org.xml.sax.SAXException
            java.lang.String r9 = "Invalid <pattern> element. height cannot be negative"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.A(com.caverock.androidsvg.SVG$w, org.xml.sax.Attributes):void");
    }

    private void A0(Attributes attributes) throws SAXException {
        d("<polyline>", new Object[0]);
        if (this.b != null) {
            SVG.x xVar = new SVG.x();
            xVar.a = this.a;
            xVar.b = this.b;
            r(xVar, attributes);
            G(xVar, attributes);
            K(xVar, attributes);
            q(xVar, attributes);
            B(xVar, attributes, E);
            this.b.l(xVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void B(SVG.x xVar, Attributes attributes, String str) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.points) {
                a aVar = new a(attributes.getValue(i2));
                ArrayList<Float> arrayList = new ArrayList();
                aVar.z();
                while (!aVar.g()) {
                    Float m2 = aVar.m();
                    if (m2 != null) {
                        aVar.y();
                        Float m3 = aVar.m();
                        if (m3 != null) {
                            aVar.y();
                            arrayList.add(m2);
                            arrayList.add(m3);
                        } else {
                            throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                xVar.o = new float[arrayList.size()];
                int i3 = 0;
                for (Float f2 : arrayList) {
                    xVar.o[i3] = f2.floatValue();
                    i3++;
                }
            }
        }
    }

    public static void B0(SVG.Style style, String str, String str2) throws SAXException {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        int i2 = a()[SVGAttr.fromString(str).ordinal()];
        if (i2 == 2) {
            style.w = O(str2);
            style.a |= SVG.H;
        } else if (i2 == 3) {
            style.E = a0(str2, str);
            style.a |= SVG.P;
        } else if (i2 == 5) {
            style.F = T(str2);
            style.a |= SVG.Q;
        } else if (i2 == 6) {
            style.n = P(str2);
            style.a |= 4096;
        } else if (i2 == 9) {
            style.t = t0(str2);
            style.a |= SVG.X;
        } else if (i2 == 36) {
            style.G = a0(str2, str);
            style.a |= SVG.R;
        } else if (i2 == 41) {
            style.f2493m = Float.valueOf(f0(str2));
            style.a |= 2048;
        } else if (i2 == 43) {
            style.v = g0(str2);
            style.a |= SVG.G;
        } else if (i2 == 79) {
            style.L = v0(str2);
            style.a |= SVG.W;
        } else if (i2 == 59) {
            if (str2.equals(U)) {
                style.H = SVG.f.a();
            } else {
                style.H = P(str2);
            }
            style.a |= SVG.S;
        } else if (i2 == 60) {
            style.I = Float.valueOf(f0(str2));
            style.a |= SVG.T;
        } else if (i2 == 75) {
            style.u = r0(str2);
            style.a |= SVG.F;
        } else if (i2 != 76) {
            switch (i2) {
                case 15:
                    if (str2.indexOf(124) < 0) {
                        if (V.indexOf(String.valueOf('|') + str2 + '|') != -1) {
                            style.A = Boolean.valueOf(!str2.equals("none"));
                            style.a |= SVG.L;
                            return;
                        }
                    }
                    throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                case 16:
                    style.b = h0(str2, TTLogUtil.TAG_EVENT_FILL);
                    style.a |= 1;
                    return;
                case 17:
                    style.f2483c = T(str2);
                    style.a |= 2;
                    return;
                case 18:
                    style.f2484d = Float.valueOf(f0(str2));
                    style.a |= 4;
                    return;
                case 19:
                    V(style, str2);
                    return;
                case 20:
                    style.o = W(str2);
                    style.a |= SVG.A;
                    return;
                case 21:
                    style.p = X(str2);
                    style.a |= 16384;
                    return;
                case 22:
                    style.q = Z(str2);
                    style.a |= SVG.C;
                    return;
                case 23:
                    style.r = Y(str2);
                    style.a |= SVG.D;
                    return;
                default:
                    switch (i2) {
                        case 29:
                            String a02 = a0(str2, str);
                            style.x = a02;
                            style.y = a02;
                            style.z = a02;
                            style.a |= 14680064;
                            return;
                        case 30:
                            style.x = a0(str2, str);
                            style.a |= SVG.I;
                            return;
                        case 31:
                            style.y = a0(str2, str);
                            style.a |= SVG.J;
                            return;
                        case 32:
                            style.z = a0(str2, str);
                            style.a |= SVG.K;
                            return;
                        default:
                            switch (i2) {
                                case 63:
                                    if (str2.equals(U)) {
                                        style.C = SVG.f.a();
                                    } else {
                                        style.C = P(str2);
                                    }
                                    style.a |= SVG.N;
                                    return;
                                case 64:
                                    style.D = Float.valueOf(f0(str2));
                                    style.a |= SVG.O;
                                    return;
                                case 65:
                                    style.f2485e = h0(str2, "stroke");
                                    style.a |= 8;
                                    return;
                                case 66:
                                    if ("none".equals(str2)) {
                                        style.f2491k = null;
                                    } else {
                                        style.f2491k = m0(str2);
                                    }
                                    style.a |= 512;
                                    return;
                                case 67:
                                    style.f2492l = c0(str2);
                                    style.a |= 1024;
                                    return;
                                case 68:
                                    style.f2488h = n0(str2);
                                    style.a |= 64;
                                    return;
                                case 69:
                                    style.f2489i = o0(str2);
                                    style.a |= 128;
                                    return;
                                case 70:
                                    style.f2490j = Float.valueOf(U(str2));
                                    style.a |= 256;
                                    return;
                                case 71:
                                    style.f2486f = Float.valueOf(f0(str2));
                                    style.a |= 16;
                                    return;
                                case 72:
                                    style.f2487g = c0(str2);
                                    style.a |= 32;
                                    return;
                                default:
                                    switch (i2) {
                                        case 89:
                                            if (str2.equals(U)) {
                                                style.J = SVG.f.a();
                                            } else {
                                                style.J = P(str2);
                                            }
                                            style.a |= SVG.U;
                                            return;
                                        case 90:
                                            style.K = Float.valueOf(f0(str2));
                                            style.a |= SVG.V;
                                            return;
                                        case 91:
                                            if (str2.indexOf(124) < 0) {
                                                if (W.indexOf(String.valueOf('|') + str2 + '|') != -1) {
                                                    style.B = Boolean.valueOf(str2.equals("visible"));
                                                    style.a |= SVG.M;
                                                    return;
                                                }
                                            }
                                            throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        } else {
            style.s = s0(str2);
            style.a |= SVG.E;
        }
    }

    private void C(SVG.n0 n0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 7) {
                n0Var.f2524m = c0(trim);
            } else if (i3 == 8) {
                n0Var.n = c0(trim);
            } else if (i3 == 12) {
                n0Var.p = c0(trim);
            } else if (i3 == 13) {
                n0Var.q = c0(trim);
            } else if (i3 != 50) {
                continue;
            } else {
                SVG.n c02 = c0(trim);
                n0Var.o = c02;
                if (c02.j()) {
                    throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                }
            }
        }
    }

    private void C0(Attributes attributes) throws SAXException {
        d("<radialGradient>", new Object[0]);
        if (this.b != null) {
            SVG.n0 n0Var = new SVG.n0();
            n0Var.a = this.a;
            n0Var.b = this.b;
            r(n0Var, attributes);
            G(n0Var, attributes);
            t(n0Var, attributes);
            C(n0Var, attributes);
            this.b.l(n0Var);
            this.b = n0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D(com.caverock.androidsvg.SVG.z r5, org.xml.sax.Attributes r6) throws org.xml.sax.SAXException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 < r1) goto L8
            return
        L8:
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = a()
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 26
            if (r2 == r3) goto L7f
            r3 = 57
            if (r2 == r3) goto L6a
            r3 = 58
            if (r2 == r3) goto L55
            switch(r2) {
                case 82: goto L40;
                case 83: goto L39;
                case 84: goto L32;
                default: goto L31;
            }
        L31:
            goto L8b
        L32:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.p = r1
            goto L8b
        L39:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.o = r1
            goto L8b
        L40:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.q = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L4d
            goto L8b
        L4d:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <rect> element. width cannot be negative"
            r5.<init>(r6)
            throw r5
        L55:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.t = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L62
            goto L8b
        L62:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <rect> element. ry cannot be negative"
            r5.<init>(r6)
            throw r5
        L6a:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.s = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L77
            goto L8b
        L77:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <rect> element. rx cannot be negative"
            r5.<init>(r6)
            throw r5
        L7f:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.r = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L8f
        L8b:
            int r0 = r0 + 1
            goto L1
        L8f:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <rect> element. height cannot be negative"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.D(com.caverock.androidsvg.SVG$z, org.xml.sax.Attributes):void");
    }

    private void D0(Attributes attributes) throws SAXException {
        d("<rect>", new Object[0]);
        if (this.b != null) {
            SVG.z zVar = new SVG.z();
            zVar.a = this.a;
            zVar.b = this.b;
            r(zVar, attributes);
            G(zVar, attributes);
            K(zVar, attributes);
            q(zVar, attributes);
            D(zVar, attributes);
            this.b.l(zVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E(com.caverock.androidsvg.SVG.c0 r5, org.xml.sax.Attributes r6) throws org.xml.sax.SAXException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 < r1) goto L8
            return
        L8:
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = a()
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 26
            if (r2 == r3) goto L54
            r3 = 80
            if (r2 == r3) goto L51
            switch(r2) {
                case 82: goto L3c;
                case 83: goto L35;
                case 84: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L60
        L2e:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.r = r1
            goto L60
        L35:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.q = r1
            goto L60
        L3c:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.s = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L49
            goto L60
        L49:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <svg> element. width cannot be negative"
            r5.<init>(r6)
            throw r5
        L51:
            r5.u = r1
            goto L60
        L54:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.t = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L63
        L60:
            int r0 = r0 + 1
            goto L1
        L63:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <svg> element. height cannot be negative"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.E(com.caverock.androidsvg.SVG$c0, org.xml.sax.Attributes):void");
    }

    private void F(SVG.b0 b0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 40) {
                b0Var.f2500h = b0(trim);
            }
        }
    }

    private void F0(Attributes attributes) throws SAXException {
        d("<solidColor>", new Object[0]);
        if (this.b != null) {
            SVG.a0 a0Var = new SVG.a0();
            a0Var.a = this.a;
            a0Var.b = this.b;
            r(a0Var, attributes);
            G(a0Var, attributes);
            this.b.l(a0Var);
            this.b = a0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void G(SVG.i0 i0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (trim.length() != 0) {
                int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 1) {
                    i0Var.f2521g = CSSParser.f(trim);
                } else if (i3 != 73) {
                    if (i0Var.f2519e == null) {
                        i0Var.f2519e = new SVG.Style();
                    }
                    B0(i0Var.f2519e, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                } else {
                    p0(i0Var, trim);
                }
            }
        }
    }

    private void G0(Attributes attributes) throws SAXException {
        d("<stop>", new Object[0]);
        SVG.g0 g0Var = this.b;
        if (g0Var != null) {
            if (g0Var instanceof SVG.i) {
                SVG.b0 b0Var = new SVG.b0();
                b0Var.a = this.a;
                b0Var.b = this.b;
                r(b0Var, attributes);
                G(b0Var, attributes);
                F(b0Var, attributes);
                this.b.l(b0Var);
                this.b = b0Var;
                return;
            }
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void H(SVG.r0 r0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 27 && f2535m.equals(attributes.getURI(i2))) {
                r0Var.o = trim;
            }
        }
    }

    private void H0(Attributes attributes) throws SAXException {
        d("<style>", new Object[0]);
        if (this.b != null) {
            String str = "all";
            boolean z2 = true;
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 39) {
                    str = trim;
                } else if (i3 == 78) {
                    z2 = trim.equals("text/css");
                }
            }
            if (z2 && CSSParser.b(str, CSSParser.MediaType.screen)) {
                this.f2541h = true;
                return;
            }
            this.f2536c = true;
            this.f2537d = 1;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void I(SVG.w0 w0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 != 27) {
                if (i3 == 62) {
                    w0Var.p = c0(trim);
                }
            } else if (f2535m.equals(attributes.getURI(i2))) {
                w0Var.o = trim;
            }
        }
    }

    private void I0(Attributes attributes) throws SAXException {
        d("<svg>", new Object[0]);
        SVG.c0 c0Var = new SVG.c0();
        c0Var.a = this.a;
        c0Var.b = this.b;
        r(c0Var, attributes);
        G(c0Var, attributes);
        q(c0Var, attributes);
        M(c0Var, attributes);
        E(c0Var, attributes);
        SVG.g0 g0Var = this.b;
        if (g0Var == null) {
            this.a.S(c0Var);
        } else {
            g0Var.l(c0Var);
        }
        this.b = c0Var;
    }

    private void J(SVG.x0 x0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 10) {
                x0Var.q = d0(trim);
            } else if (i3 == 11) {
                x0Var.r = d0(trim);
            } else if (i3 == 83) {
                x0Var.o = d0(trim);
            } else if (i3 == 84) {
                x0Var.p = d0(trim);
            }
        }
    }

    private void J0(Attributes attributes) throws SAXException {
        d("<symbol>", new Object[0]);
        if (this.b != null) {
            SVG.o0 q0Var = new SVG.q0();
            q0Var.a = this.a;
            q0Var.b = this.b;
            r(q0Var, attributes);
            G(q0Var, attributes);
            q(q0Var, attributes);
            M(q0Var, attributes);
            this.b.l(q0Var);
            this.b = q0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void K(SVG.l lVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.transform) {
                lVar.m(u0(attributes.getValue(i2)));
            }
        }
    }

    private void K0(Attributes attributes) throws SAXException {
        d("<text>", new Object[0]);
        if (this.b != null) {
            SVG.t0 t0Var = new SVG.t0();
            t0Var.a = this.a;
            t0Var.b = this.b;
            r(t0Var, attributes);
            G(t0Var, attributes);
            K(t0Var, attributes);
            q(t0Var, attributes);
            J(t0Var, attributes);
            this.b.l(t0Var);
            this.b = t0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L(com.caverock.androidsvg.SVG.a1 r5, org.xml.sax.Attributes r6) throws org.xml.sax.SAXException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 < r1) goto L8
            return
        L8:
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = a()
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 26
            if (r2 == r3) goto L61
            r3 = 27
            if (r2 == r3) goto L51
            switch(r2) {
                case 82: goto L3c;
                case 83: goto L35;
                case 84: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L6d
        L2e:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.r = r1
            goto L6d
        L35:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.q = r1
            goto L6d
        L3c:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.s = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L49
            goto L6d
        L49:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <use> element. width cannot be negative"
            r5.<init>(r6)
            throw r5
        L51:
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L5e
            goto L6d
        L5e:
            r5.p = r1
            goto L6d
        L61:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.t = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L70
        L6d:
            int r0 = r0 + 1
            goto L1
        L70:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <use> element. height cannot be negative"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.L(com.caverock.androidsvg.SVG$a1, org.xml.sax.Attributes):void");
    }

    private void L0(Attributes attributes) throws SAXException {
        d("<textPath>", new Object[0]);
        if (this.b != null) {
            SVG.w0 w0Var = new SVG.w0();
            w0Var.a = this.a;
            w0Var.b = this.b;
            r(w0Var, attributes);
            G(w0Var, attributes);
            q(w0Var, attributes);
            I(w0Var, attributes);
            this.b.l(w0Var);
            this.b = w0Var;
            SVG.g0 g0Var = w0Var.b;
            if (g0Var instanceof SVG.y0) {
                w0Var.j((SVG.y0) g0Var);
                return;
            } else {
                w0Var.j(((SVG.u0) g0Var).e());
                return;
            }
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void M(SVG.o0 o0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 49) {
                j0(o0Var, trim);
            } else if (i3 == 81) {
                o0Var.p = w0(trim);
            }
        }
    }

    private void M0(Attributes attributes) throws SAXException {
        d("<tref>", new Object[0]);
        SVG.g0 g0Var = this.b;
        if (g0Var != null) {
            if (g0Var instanceof SVG.v0) {
                SVG.r0 r0Var = new SVG.r0();
                r0Var.a = this.a;
                r0Var.b = this.b;
                r(r0Var, attributes);
                G(r0Var, attributes);
                q(r0Var, attributes);
                H(r0Var, attributes);
                this.b.l(r0Var);
                SVG.g0 g0Var2 = r0Var.b;
                if (g0Var2 instanceof SVG.y0) {
                    r0Var.j((SVG.y0) g0Var2);
                    return;
                } else {
                    r0Var.j(((SVG.u0) g0Var2).e());
                    return;
                }
            }
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void N(String str) throws SAXException {
        this.a.b(new CSSParser(CSSParser.MediaType.screen).d(str));
    }

    private void N0(Attributes attributes) throws SAXException {
        d("<tspan>", new Object[0]);
        SVG.g0 g0Var = this.b;
        if (g0Var != null) {
            if (g0Var instanceof SVG.v0) {
                SVG.s0 s0Var = new SVG.s0();
                s0Var.a = this.a;
                s0Var.b = this.b;
                r(s0Var, attributes);
                G(s0Var, attributes);
                q(s0Var, attributes);
                J(s0Var, attributes);
                this.b.l(s0Var);
                this.b = s0Var;
                SVG.g0 g0Var2 = s0Var.b;
                if (g0Var2 instanceof SVG.y0) {
                    s0Var.j((SVG.y0) g0Var2);
                    return;
                } else {
                    s0Var.j(((SVG.u0) g0Var2).e());
                    return;
                }
            }
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static SVG.b O(String str) throws SAXException {
        if (q0.f15780c.equals(str)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).startsWith("rect(")) {
            a aVar = new a(str.substring(5));
            aVar.z();
            SVG.n e0 = e0(aVar);
            aVar.y();
            SVG.n e02 = e0(aVar);
            aVar.y();
            SVG.n e03 = e0(aVar);
            aVar.y();
            SVG.n e04 = e0(aVar);
            aVar.z();
            if (aVar.e(')')) {
                return new SVG.b(e0, e02, e03, e04);
            }
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
    }

    private void O0(Attributes attributes) throws SAXException {
        d("<use>", new Object[0]);
        if (this.b != null) {
            SVG.a1 a1Var = new SVG.a1();
            a1Var.a = this.a;
            a1Var.b = this.b;
            r(a1Var, attributes);
            G(a1Var, attributes);
            K(a1Var, attributes);
            q(a1Var, attributes);
            L(a1Var, attributes);
            this.b.l(a1Var);
            this.b = a1Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static SVG.e P(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            try {
                if (str.length() == 7) {
                    return new SVG.e(Integer.parseInt(str.substring(1), 16));
                }
                if (str.length() == 4) {
                    int parseInt = Integer.parseInt(str.substring(1), 16);
                    int i2 = parseInt & 3840;
                    int i3 = parseInt & 240;
                    int i4 = parseInt & 15;
                    return new SVG.e(i4 | (i2 << 12) | (i2 << 16) | (i3 << 8) | (i3 << 4) | (i4 << 4));
                }
                throw new SAXException("Bad hex colour value: " + str);
            } catch (NumberFormatException unused) {
                throw new SAXException("Bad colour value: " + str);
            }
        } else if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            a aVar = new a(str.substring(4));
            aVar.z();
            int Q2 = Q(aVar);
            aVar.y();
            int Q3 = Q(aVar);
            aVar.y();
            int Q4 = Q(aVar);
            aVar.z();
            if (aVar.e(')')) {
                return new SVG.e((Q2 << 16) | (Q3 << 8) | Q4);
            }
            throw new SAXException("Bad rgb() colour value: " + str);
        } else {
            return R(str);
        }
    }

    private void P0(Attributes attributes) throws SAXException {
        d("<view>", new Object[0]);
        if (this.b != null) {
            SVG.o0 b1Var = new SVG.b1();
            b1Var.a = this.a;
            b1Var.b = this.b;
            r(b1Var, attributes);
            q(b1Var, attributes);
            M(b1Var, attributes);
            this.b.l(b1Var);
            this.b = b1Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static int Q(a aVar) throws SAXException {
        float floatValue = aVar.m().floatValue();
        if (aVar.e('%')) {
            floatValue = (floatValue * 256.0f) / 100.0f;
        }
        if (floatValue < 0.0f) {
            return 0;
        }
        if (floatValue > 255.0f) {
            return 255;
        }
        return (int) floatValue;
    }

    private void Q0(Attributes attributes) throws SAXException {
        d("<switch>", new Object[0]);
        if (this.b != null) {
            SVG.p0 p0Var = new SVG.p0();
            p0Var.a = this.a;
            p0Var.b = this.b;
            r(p0Var, attributes);
            G(p0Var, attributes);
            K(p0Var, attributes);
            q(p0Var, attributes);
            this.b.l(p0Var);
            this.b = p0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static SVG.e R(String str) throws SAXException {
        Integer num = X.get(str.toLowerCase(Locale.US));
        if (num != null) {
            return new SVG.e(num.intValue());
        }
        throw new SAXException("Invalid colour keyword: " + str);
    }

    private static SVG.l0 S(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals(U)) {
            return SVG.f.a();
        }
        return P(str);
    }

    private static SVG.Style.FillRule T(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static float U(String str) throws SAXException {
        if (str.length() != 0) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e2) {
                throw new SAXException("Invalid float value: " + str, e2);
            }
        }
        throw new SAXException("Invalid float value (empty string)");
    }

    private static void V(SVG.Style style, String str) throws SAXException {
        String s2;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".indexOf(String.valueOf('|') + str + '|') != -1) {
            return;
        }
        a aVar = new a(str);
        Integer num = null;
        SVG.Style.FontStyle fontStyle = null;
        String str2 = null;
        while (true) {
            s2 = aVar.s(com.moor.imkf.lib.jsoup.nodes.Attributes.InternalPrefix);
            aVar.z();
            if (s2 == null) {
                throw new SAXException("Invalid font style attribute: missing font size and family");
            }
            if (num != null && fontStyle != null) {
                break;
            } else if (!s2.equals(PrerollVideoResponse.NORMAL) && (num != null || (num = Z.get(s2)) == null)) {
                if (fontStyle != null || (fontStyle = a0.get(s2)) == null) {
                    if (str2 != null || !s2.equals("small-caps")) {
                        break;
                    }
                    str2 = s2;
                }
            }
        }
        SVG.n X2 = X(s2);
        if (aVar.e(com.moor.imkf.lib.jsoup.nodes.Attributes.InternalPrefix)) {
            aVar.z();
            String r2 = aVar.r();
            if (r2 != null) {
                c0(r2);
                aVar.z();
            } else {
                throw new SAXException("Invalid font style attribute: missing line-height");
            }
        }
        style.o = W(aVar.v());
        style.p = X2;
        style.q = Integer.valueOf(num == null ? 400 : num.intValue());
        if (fontStyle == null) {
            fontStyle = SVG.Style.FontStyle.Normal;
        }
        style.r = fontStyle;
        style.a |= 122880;
    }

    private static List<String> W(String str) throws SAXException {
        a aVar = new a(str);
        ArrayList arrayList = null;
        do {
            String q2 = aVar.q();
            if (q2 == null) {
                q2 = aVar.s(',');
            }
            if (q2 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(q2);
            aVar.y();
        } while (!aVar.g());
        return arrayList;
    }

    private static SVG.n X(String str) throws SAXException {
        SVG.n nVar = Y.get(str);
        return nVar == null ? c0(str) : nVar;
    }

    private static SVG.Style.FontStyle Y(String str) throws SAXException {
        SVG.Style.FontStyle fontStyle = a0.get(str);
        if (fontStyle != null) {
            return fontStyle;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static Integer Z(String str) throws SAXException {
        Integer num = Z.get(str);
        if (num != null) {
            return num;
        }
        throw new SAXException("Invalid font-weight property: " + str);
    }

    public static /* synthetic */ int[] a() {
        int[] iArr = d0;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVGAttr.valuesCustom().length];
        try {
            iArr2[SVGAttr.CLASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVGAttr.UNSUPPORTED.ordinal()] = 92;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVGAttr.clip.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[SVGAttr.clipPathUnits.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[SVGAttr.clip_path.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[SVGAttr.clip_rule.ordinal()] = 5;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[SVGAttr.color.ordinal()] = 6;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[SVGAttr.cx.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[SVGAttr.cy.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[SVGAttr.d.ordinal()] = 14;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[SVGAttr.direction.ordinal()] = 9;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[SVGAttr.display.ordinal()] = 15;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[SVGAttr.dx.ordinal()] = 10;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[SVGAttr.dy.ordinal()] = 11;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[SVGAttr.fill.ordinal()] = 16;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[SVGAttr.fill_opacity.ordinal()] = 18;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[SVGAttr.fill_rule.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[SVGAttr.font.ordinal()] = 19;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[SVGAttr.font_family.ordinal()] = 20;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr2[SVGAttr.font_size.ordinal()] = 21;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr2[SVGAttr.font_style.ordinal()] = 23;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr2[SVGAttr.font_weight.ordinal()] = 22;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr2[SVGAttr.fx.ordinal()] = 12;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr2[SVGAttr.fy.ordinal()] = 13;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr2[SVGAttr.gradientTransform.ordinal()] = 24;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr2[SVGAttr.gradientUnits.ordinal()] = 25;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            iArr2[SVGAttr.height.ordinal()] = 26;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            iArr2[SVGAttr.href.ordinal()] = 27;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            iArr2[SVGAttr.id.ordinal()] = 28;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            iArr2[SVGAttr.marker.ordinal()] = 29;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            iArr2[SVGAttr.markerHeight.ordinal()] = 33;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            iArr2[SVGAttr.markerUnits.ordinal()] = 34;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            iArr2[SVGAttr.markerWidth.ordinal()] = 35;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            iArr2[SVGAttr.marker_end.ordinal()] = 32;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            iArr2[SVGAttr.marker_mid.ordinal()] = 31;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            iArr2[SVGAttr.marker_start.ordinal()] = 30;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            iArr2[SVGAttr.mask.ordinal()] = 36;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            iArr2[SVGAttr.maskContentUnits.ordinal()] = 37;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            iArr2[SVGAttr.maskUnits.ordinal()] = 38;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            iArr2[SVGAttr.media.ordinal()] = 39;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            iArr2[SVGAttr.offset.ordinal()] = 40;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            iArr2[SVGAttr.opacity.ordinal()] = 41;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            iArr2[SVGAttr.orient.ordinal()] = 42;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            iArr2[SVGAttr.overflow.ordinal()] = 43;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            iArr2[SVGAttr.pathLength.ordinal()] = 44;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            iArr2[SVGAttr.patternContentUnits.ordinal()] = 45;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            iArr2[SVGAttr.patternTransform.ordinal()] = 46;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            iArr2[SVGAttr.patternUnits.ordinal()] = 47;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            iArr2[SVGAttr.points.ordinal()] = 48;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            iArr2[SVGAttr.preserveAspectRatio.ordinal()] = 49;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            iArr2[SVGAttr.r.ordinal()] = 50;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            iArr2[SVGAttr.refX.ordinal()] = 51;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            iArr2[SVGAttr.refY.ordinal()] = 52;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            iArr2[SVGAttr.requiredExtensions.ordinal()] = 54;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            iArr2[SVGAttr.requiredFeatures.ordinal()] = 53;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            iArr2[SVGAttr.requiredFonts.ordinal()] = 56;
        } catch (NoSuchFieldError unused56) {
        }
        try {
            iArr2[SVGAttr.requiredFormats.ordinal()] = 55;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            iArr2[SVGAttr.rx.ordinal()] = 57;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            iArr2[SVGAttr.ry.ordinal()] = 58;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            iArr2[SVGAttr.solid_color.ordinal()] = 59;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            iArr2[SVGAttr.solid_opacity.ordinal()] = 60;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            iArr2[SVGAttr.spreadMethod.ordinal()] = 61;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            iArr2[SVGAttr.startOffset.ordinal()] = 62;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            iArr2[SVGAttr.stop_color.ordinal()] = 63;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            iArr2[SVGAttr.stop_opacity.ordinal()] = 64;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            iArr2[SVGAttr.stroke.ordinal()] = 65;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            iArr2[SVGAttr.stroke_dasharray.ordinal()] = 66;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            iArr2[SVGAttr.stroke_dashoffset.ordinal()] = 67;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            iArr2[SVGAttr.stroke_linecap.ordinal()] = 68;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            iArr2[SVGAttr.stroke_linejoin.ordinal()] = 69;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            iArr2[SVGAttr.stroke_miterlimit.ordinal()] = 70;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            iArr2[SVGAttr.stroke_opacity.ordinal()] = 71;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            iArr2[SVGAttr.stroke_width.ordinal()] = 72;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            iArr2[SVGAttr.style.ordinal()] = 73;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            iArr2[SVGAttr.systemLanguage.ordinal()] = 74;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            iArr2[SVGAttr.text_anchor.ordinal()] = 75;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            iArr2[SVGAttr.text_decoration.ordinal()] = 76;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            iArr2[SVGAttr.transform.ordinal()] = 77;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            iArr2[SVGAttr.type.ordinal()] = 78;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            iArr2[SVGAttr.vector_effect.ordinal()] = 79;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            iArr2[SVGAttr.version.ordinal()] = 80;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            iArr2[SVGAttr.viewBox.ordinal()] = 81;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            iArr2[SVGAttr.viewport_fill.ordinal()] = 89;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            iArr2[SVGAttr.viewport_fill_opacity.ordinal()] = 90;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            iArr2[SVGAttr.visibility.ordinal()] = 91;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            iArr2[SVGAttr.width.ordinal()] = 82;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            iArr2[SVGAttr.x.ordinal()] = 83;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            iArr2[SVGAttr.x1.ordinal()] = 85;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            iArr2[SVGAttr.x2.ordinal()] = 87;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            iArr2[SVGAttr.y.ordinal()] = 84;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            iArr2[SVGAttr.y1.ordinal()] = 86;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            iArr2[SVGAttr.y2.ordinal()] = 88;
        } catch (NoSuchFieldError unused92) {
        }
        d0 = iArr2;
        return iArr2;
    }

    private static String a0(String str, String str2) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.startsWith("url(") && str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
    }

    private void b(Attributes attributes) throws SAXException {
        d("<circle>", new Object[0]);
        if (this.b != null) {
            SVG.c cVar = new SVG.c();
            cVar.a = this.a;
            cVar.b = this.b;
            r(cVar, attributes);
            G(cVar, attributes);
            K(cVar, attributes);
            q(cVar, attributes);
            o(cVar, attributes);
            this.b.l(cVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private Float b0(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z2 = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z2 = false;
            }
            try {
                float parseFloat = Float.parseFloat(str.substring(0, length));
                float f2 = 100.0f;
                if (z2) {
                    parseFloat /= 100.0f;
                }
                if (parseFloat < 0.0f) {
                    f2 = 0.0f;
                } else if (parseFloat <= 100.0f) {
                    f2 = parseFloat;
                }
                return Float.valueOf(f2);
            } catch (NumberFormatException e2) {
                throw new SAXException("Invalid offset value in <stop>: " + str, e2);
            }
        }
        throw new SAXException("Invalid offset value in <stop> (empty string)");
    }

    private void c(Attributes attributes) throws SAXException {
        d("<clipPath>", new Object[0]);
        if (this.b != null) {
            SVG.d dVar = new SVG.d();
            dVar.a = this.a;
            dVar.b = this.b;
            r(dVar, attributes);
            G(dVar, attributes);
            K(dVar, attributes);
            q(dVar, attributes);
            p(dVar, attributes);
            this.b.l(dVar);
            this.b = dVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public static SVG.n c0(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.Unit unit = SVG.Unit.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                unit = SVG.Unit.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SAXException("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new SVG.n(Float.parseFloat(str.substring(0, length)), unit);
            } catch (NumberFormatException e2) {
                throw new SAXException("Invalid length value: " + str, e2);
            }
        }
        throw new SAXException("Invalid length value (empty string)");
    }

    private void d(String str, Object... objArr) {
    }

    private static List<SVG.n> d0(String str) throws SAXException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            a aVar = new a(str);
            aVar.z();
            while (!aVar.g()) {
                Float m2 = aVar.m();
                if (m2 != null) {
                    SVG.Unit t2 = aVar.t();
                    if (t2 == null) {
                        t2 = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.n(m2.floatValue(), t2));
                    aVar.y();
                } else {
                    throw new SAXException("Invalid length list value: " + aVar.b());
                }
            }
            return arrayList;
        }
        throw new SAXException("Invalid length list (empty string)");
    }

    private void e(Attributes attributes) throws SAXException {
        d("<defs>", new Object[0]);
        if (this.b != null) {
            SVG.g gVar = new SVG.g();
            gVar.a = this.a;
            gVar.b = this.b;
            r(gVar, attributes);
            G(gVar, attributes);
            K(gVar, attributes);
            this.b.l(gVar);
            this.b = gVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static SVG.n e0(a aVar) {
        if (aVar.f(q0.f15780c)) {
            return new SVG.n(0.0f);
        }
        return aVar.p();
    }

    private void f(SVG.k0 k0Var, String str) {
        Log.d(f2533k, String.valueOf(str) + k0Var);
        if (k0Var instanceof SVG.e0) {
            String str2 = String.valueOf(str) + "  ";
            for (SVG.k0 k0Var2 : ((SVG.e0) k0Var).f2501i) {
                f(k0Var2, str2);
            }
        }
    }

    private static float f0(String str) throws SAXException {
        float U2 = U(str);
        if (U2 < 0.0f) {
            return 0.0f;
        }
        if (U2 > 1.0f) {
            return 1.0f;
        }
        return U2;
    }

    private void g(Attributes attributes) throws SAXException {
        d("<ellipse>", new Object[0]);
        if (this.b != null) {
            SVG.h hVar = new SVG.h();
            hVar.a = this.a;
            hVar.b = this.b;
            r(hVar, attributes);
            G(hVar, attributes);
            K(hVar, attributes);
            q(hVar, attributes);
            s(hVar, attributes);
            this.b.l(hVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static Boolean g0(String str) throws SAXException {
        if (!"visible".equals(str) && !q0.f15780c.equals(str)) {
            if (!"hidden".equals(str) && !"scroll".equals(str)) {
                throw new SAXException("Invalid toverflow property: " + str);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void h(Attributes attributes) throws SAXException {
        d("<g>", new Object[0]);
        if (this.b != null) {
            SVG.k kVar = new SVG.k();
            kVar.a = this.a;
            kVar.b = this.b;
            r(kVar, attributes);
            G(kVar, attributes);
            K(kVar, attributes);
            q(kVar, attributes);
            this.b.l(kVar);
            this.b = kVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static SVG.l0 h0(String str, String str2) throws SAXException {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                return new SVG.s(trim, trim2.length() > 0 ? S(trim2) : null);
            }
            throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
        }
        return S(str);
    }

    private void i(Attributes attributes) throws SAXException {
        d("<image>", new Object[0]);
        if (this.b != null) {
            SVG.m mVar = new SVG.m();
            mVar.a = this.a;
            mVar.b = this.b;
            r(mVar, attributes);
            G(mVar, attributes);
            K(mVar, attributes);
            q(mVar, attributes);
            u(mVar, attributes);
            this.b.l(mVar);
            this.b = mVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x03ee, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.caverock.androidsvg.SVG.u i0(java.lang.String r20) throws org.xml.sax.SAXException {
        /*
            Method dump skipped, instructions count: 1090
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.i0(java.lang.String):com.caverock.androidsvg.SVG$u");
    }

    private void j(Attributes attributes) throws SAXException {
        d("<line>", new Object[0]);
        if (this.b != null) {
            SVG.o oVar = new SVG.o();
            oVar.a = this.a;
            oVar.b = this.b;
            r(oVar, attributes);
            G(oVar, attributes);
            K(oVar, attributes);
            q(oVar, attributes);
            v(oVar, attributes);
            this.b.l(oVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static void j0(SVG.m0 m0Var, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        a aVar = new a(str);
        aVar.z();
        String r2 = aVar.r();
        if ("defer".equals(r2)) {
            aVar.z();
            r2 = aVar.r();
        }
        PreserveAspectRatio.Alignment alignment = b0.get(r2);
        aVar.z();
        if (aVar.g()) {
            scale = null;
        } else {
            String r3 = aVar.r();
            if (r3.equals("meet")) {
                scale = PreserveAspectRatio.Scale.Meet;
            } else if (r3.equals("slice")) {
                scale = PreserveAspectRatio.Scale.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        m0Var.o = new PreserveAspectRatio(alignment, scale);
    }

    private void k(Attributes attributes) throws SAXException {
        d("<linearGradiant>", new Object[0]);
        if (this.b != null) {
            SVG.j0 j0Var = new SVG.j0();
            j0Var.a = this.a;
            j0Var.b = this.b;
            r(j0Var, attributes);
            G(j0Var, attributes);
            t(j0Var, attributes);
            w(j0Var, attributes);
            this.b.l(j0Var);
            this.b = j0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static Set<String> k0(String str) throws SAXException {
        a aVar = new a(str);
        HashSet hashSet = new HashSet();
        while (!aVar.g()) {
            String r2 = aVar.r();
            if (r2.startsWith(n)) {
                hashSet.add(r2.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            aVar.z();
        }
        return hashSet;
    }

    private void l(Attributes attributes) throws SAXException {
        d("<marker>", new Object[0]);
        if (this.b != null) {
            SVG.p pVar = new SVG.p();
            pVar.a = this.a;
            pVar.b = this.b;
            r(pVar, attributes);
            G(pVar, attributes);
            q(pVar, attributes);
            M(pVar, attributes);
            x(pVar, attributes);
            this.b.l(pVar);
            this.b = pVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static Set<String> l0(String str) throws SAXException {
        a aVar = new a(str);
        HashSet hashSet = new HashSet();
        while (!aVar.g()) {
            hashSet.add(aVar.r());
            aVar.z();
        }
        return hashSet;
    }

    private void m(Attributes attributes) throws SAXException {
        d("<mask>", new Object[0]);
        if (this.b != null) {
            SVG.q qVar = new SVG.q();
            qVar.a = this.a;
            qVar.b = this.b;
            r(qVar, attributes);
            G(qVar, attributes);
            q(qVar, attributes);
            y(qVar, attributes);
            this.b.l(qVar);
            this.b = qVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private static SVG.n[] m0(String str) throws SAXException {
        SVG.n p2;
        a aVar = new a(str);
        aVar.z();
        if (aVar.g() || (p2 = aVar.p()) == null) {
            return null;
        }
        if (!p2.j()) {
            float b = p2.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(p2);
            while (!aVar.g()) {
                aVar.y();
                SVG.n p3 = aVar.p();
                if (p3 != null) {
                    if (!p3.j()) {
                        arrayList.add(p3);
                        b += p3.b();
                    } else {
                        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                    }
                } else {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
            }
            if (b == 0.0f) {
                return null;
            }
            return (SVG.n[]) arrayList.toArray(new SVG.n[arrayList.size()]);
        }
        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
    }

    private static SVG.Style.LineCaps n0(String str) throws SAXException {
        if ("butt".equals(str)) {
            return SVG.Style.LineCaps.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCaps.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCaps.Square;
        }
        throw new SAXException("Invalid stroke-linecap property: " + str);
    }

    private void o(SVG.c cVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 7) {
                cVar.o = c0(trim);
            } else if (i3 == 8) {
                cVar.p = c0(trim);
            } else if (i3 != 50) {
                continue;
            } else {
                SVG.n c02 = c0(trim);
                cVar.q = c02;
                if (c02.j()) {
                    throw new SAXException("Invalid <circle> element. r cannot be negative");
                }
            }
        }
    }

    private static SVG.Style.LineJoin o0(String str) throws SAXException {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        throw new SAXException("Invalid stroke-linejoin property: " + str);
    }

    private void p(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 4) {
                if ("objectBoundingBox".equals(trim)) {
                    dVar.p = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    dVar.p = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private static void p0(SVG.i0 i0Var, String str) throws SAXException {
        a aVar = new a(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String s2 = aVar.s(':');
            aVar.z();
            if (!aVar.e(':')) {
                return;
            }
            aVar.z();
            String s3 = aVar.s(';');
            if (s3 == null) {
                return;
            }
            aVar.z();
            if (aVar.g() || aVar.e(';')) {
                if (i0Var.f2520f == null) {
                    i0Var.f2520f = new SVG.Style();
                }
                B0(i0Var.f2520f, s2, s3);
                aVar.z();
            }
        }
    }

    private void q(SVG.d0 d0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 != 74) {
                switch (i3) {
                    case 53:
                        d0Var.f(k0(trim));
                        continue;
                    case 54:
                        d0Var.i(trim);
                        continue;
                    case 55:
                        d0Var.h(l0(trim));
                        continue;
                    case 56:
                        List<String> W2 = W(trim);
                        d0Var.d(W2 != null ? new HashSet(W2) : new HashSet(0));
                        continue;
                }
            } else {
                d0Var.g(q0(trim));
            }
        }
    }

    private static Set<String> q0(String str) throws SAXException {
        a aVar = new a(str);
        HashSet hashSet = new HashSet();
        while (!aVar.g()) {
            String r2 = aVar.r();
            int indexOf = r2.indexOf(45);
            if (indexOf != -1) {
                r2 = r2.substring(0, indexOf);
            }
            hashSet.add(new Locale(r2, "", "").getLanguage());
            aVar.z();
        }
        return hashSet;
    }

    private void r(SVG.i0 i0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String qName = attributes.getQName(i2);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i2).trim();
                    if ("default".equals(trim)) {
                        i0Var.f2518d = Boolean.FALSE;
                        return;
                    } else if ("preserve".equals(trim)) {
                        i0Var.f2518d = Boolean.TRUE;
                        return;
                    } else {
                        throw new SAXException("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                i0Var.f2517c = attributes.getValue(i2).trim();
                return;
            }
        }
    }

    private static SVG.Style.TextAnchor r0(String str) throws SAXException {
        if (MessageKey.MSG_ACCEPT_TIME_START.equals(str)) {
            return SVG.Style.TextAnchor.Start;
        }
        if ("middle".equals(str)) {
            return SVG.Style.TextAnchor.Middle;
        }
        if (MessageKey.MSG_ACCEPT_TIME_END.equals(str)) {
            return SVG.Style.TextAnchor.End;
        }
        throw new SAXException("Invalid text-anchor property: " + str);
    }

    private void s(SVG.h hVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 7) {
                hVar.o = c0(trim);
            } else if (i3 == 8) {
                hVar.p = c0(trim);
            } else if (i3 == 57) {
                SVG.n c02 = c0(trim);
                hVar.q = c02;
                if (c02.j()) {
                    throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                }
            } else if (i3 != 58) {
                continue;
            } else {
                SVG.n c03 = c0(trim);
                hVar.r = c03;
                if (c03.j()) {
                    throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                }
            }
        }
    }

    private static SVG.Style.TextDecoration s0(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.TextDecoration.None;
        }
        if ("underline".equals(str)) {
            return SVG.Style.TextDecoration.Underline;
        }
        if ("overline".equals(str)) {
            return SVG.Style.TextDecoration.Overline;
        }
        if ("line-through".equals(str)) {
            return SVG.Style.TextDecoration.LineThrough;
        }
        if ("blink".equals(str)) {
            return SVG.Style.TextDecoration.Blink;
        }
        throw new SAXException("Invalid text-decoration property: " + str);
    }

    private void t(SVG.i iVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 24) {
                iVar.f2514j = u0(trim);
            } else if (i3 != 25) {
                if (i3 != 27) {
                    if (i3 != 61) {
                        continue;
                    } else {
                        try {
                            iVar.f2515k = SVG.GradientSpread.valueOf(trim);
                        } catch (IllegalArgumentException unused) {
                            throw new SAXException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                        }
                    }
                } else if (f2535m.equals(attributes.getURI(i2))) {
                    iVar.f2516l = trim;
                }
            } else if ("objectBoundingBox".equals(trim)) {
                iVar.f2513i = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                iVar.f2513i = Boolean.TRUE;
            } else {
                throw new SAXException("Invalid value for attribute gradientUnits");
            }
        }
    }

    private static SVG.Style.TextDirection t0(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void u(com.caverock.androidsvg.SVG.m r5, org.xml.sax.Attributes r6) throws org.xml.sax.SAXException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 < r1) goto L8
            return
        L8:
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = a()
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 26
            if (r2 == r3) goto L69
            r3 = 27
            if (r2 == r3) goto L59
            r3 = 49
            if (r2 == r3) goto L55
            switch(r2) {
                case 82: goto L40;
                case 83: goto L39;
                case 84: goto L32;
                default: goto L31;
            }
        L31:
            goto L75
        L32:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.r = r1
            goto L75
        L39:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.q = r1
            goto L75
        L40:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.s = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L4d
            goto L75
        L4d:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <use> element. width cannot be negative"
            r5.<init>(r6)
            throw r5
        L55:
            j0(r5, r1)
            goto L75
        L59:
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L66
            goto L75
        L66:
            r5.p = r1
            goto L75
        L69:
            com.caverock.androidsvg.SVG$n r1 = c0(r1)
            r5.t = r1
            boolean r1 = r1.j()
            if (r1 != 0) goto L78
        L75:
            int r0 = r0 + 1
            goto L1
        L78:
            org.xml.sax.SAXException r5 = new org.xml.sax.SAXException
            java.lang.String r6 = "Invalid <use> element. height cannot be negative"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.u(com.caverock.androidsvg.SVG$m, org.xml.sax.Attributes):void");
    }

    private Matrix u0(String str) throws SAXException {
        Matrix matrix = new Matrix();
        a aVar = new a(str);
        aVar.z();
        while (!aVar.g()) {
            String n2 = aVar.n();
            if (n2 != null) {
                if (n2.equals("matrix")) {
                    aVar.z();
                    Float m2 = aVar.m();
                    aVar.y();
                    Float m3 = aVar.m();
                    aVar.y();
                    Float m4 = aVar.m();
                    aVar.y();
                    Float m5 = aVar.m();
                    aVar.y();
                    Float m6 = aVar.m();
                    aVar.y();
                    Float m7 = aVar.m();
                    aVar.z();
                    if (m7 != null && aVar.e(')')) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setValues(new float[]{m2.floatValue(), m4.floatValue(), m6.floatValue(), m3.floatValue(), m5.floatValue(), m7.floatValue(), 0.0f, 0.0f, 1.0f});
                        matrix.preConcat(matrix2);
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n2.equals("translate")) {
                    aVar.z();
                    Float m8 = aVar.m();
                    Float u2 = aVar.u();
                    aVar.z();
                    if (m8 == null || !aVar.e(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    } else if (u2 == null) {
                        matrix.preTranslate(m8.floatValue(), 0.0f);
                    } else {
                        matrix.preTranslate(m8.floatValue(), u2.floatValue());
                    }
                } else if (n2.equals("scale")) {
                    aVar.z();
                    Float m9 = aVar.m();
                    Float u3 = aVar.u();
                    aVar.z();
                    if (m9 == null || !aVar.e(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    } else if (u3 == null) {
                        matrix.preScale(m9.floatValue(), m9.floatValue());
                    } else {
                        matrix.preScale(m9.floatValue(), u3.floatValue());
                    }
                } else if (n2.equals("rotate")) {
                    aVar.z();
                    Float m10 = aVar.m();
                    Float u4 = aVar.u();
                    Float u5 = aVar.u();
                    aVar.z();
                    if (m10 == null || !aVar.e(')')) {
                        throw new SAXException("Invalid transform list: " + str);
                    } else if (u4 == null) {
                        matrix.preRotate(m10.floatValue());
                    } else if (u5 != null) {
                        matrix.preRotate(m10.floatValue(), u4.floatValue(), u5.floatValue());
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n2.equals("skewX")) {
                    aVar.z();
                    Float m11 = aVar.m();
                    aVar.z();
                    if (m11 != null && aVar.e(')')) {
                        matrix.preSkew((float) Math.tan(Math.toRadians(m11.floatValue())), 0.0f);
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n2.equals("skewY")) {
                    aVar.z();
                    Float m12 = aVar.m();
                    aVar.z();
                    if (m12 != null && aVar.e(')')) {
                        matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(m12.floatValue())));
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n2 != null) {
                    throw new SAXException("Invalid transform list fn: " + n2 + ")");
                }
                if (aVar.g()) {
                    break;
                }
                aVar.y();
            } else {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    private void v(SVG.o oVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 85:
                    oVar.o = c0(trim);
                    break;
                case 86:
                    oVar.p = c0(trim);
                    break;
                case 87:
                    oVar.q = c0(trim);
                    break;
                case 88:
                    oVar.r = c0(trim);
                    break;
            }
        }
    }

    private static SVG.Style.VectorEffect v0(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private void w(SVG.j0 j0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 85:
                    j0Var.f2522m = c0(trim);
                    break;
                case 86:
                    j0Var.n = c0(trim);
                    break;
                case 87:
                    j0Var.o = c0(trim);
                    break;
                case 88:
                    j0Var.p = c0(trim);
                    break;
            }
        }
    }

    private static SVG.a w0(String str) throws SAXException {
        a aVar = new a(str);
        aVar.z();
        Float m2 = aVar.m();
        aVar.y();
        Float m3 = aVar.m();
        aVar.y();
        Float m4 = aVar.m();
        aVar.y();
        Float m5 = aVar.m();
        if (m2 != null && m3 != null && m4 != null && m5 != null) {
            if (m4.floatValue() >= 0.0f) {
                if (m5.floatValue() >= 0.0f) {
                    return new SVG.a(m2.floatValue(), m3.floatValue(), m4.floatValue(), m5.floatValue());
                }
                throw new SAXException("Invalid viewBox. height cannot be negative");
            }
            throw new SAXException("Invalid viewBox. width cannot be negative");
        }
        throw new SAXException("Invalid viewBox definition - should have four numbers");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void x(com.caverock.androidsvg.SVG.p r6, org.xml.sax.Attributes r7) throws org.xml.sax.SAXException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r7.getLength()
            if (r1 < r2) goto L9
            return
        L9:
            java.lang.String r2 = r7.getValue(r1)
            java.lang.String r2 = r2.trim()
            int[] r3 = a()
            java.lang.String r4 = r7.getLocalName(r1)
            com.caverock.androidsvg.SVGParser$SVGAttr r4 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r4)
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r4 = 42
            if (r3 == r4) goto L8b
            r4 = 51
            if (r3 == r4) goto L84
            r4 = 52
            if (r3 == r4) goto L7d
            switch(r3) {
                case 33: goto L68;
                case 34: goto L49;
                case 35: goto L34;
                default: goto L32;
            }
        L32:
            goto La6
        L34:
            com.caverock.androidsvg.SVG$n r2 = c0(r2)
            r6.t = r2
            boolean r2 = r2.j()
            if (r2 != 0) goto L41
            goto La6
        L41:
            org.xml.sax.SAXException r6 = new org.xml.sax.SAXException
            java.lang.String r7 = "Invalid <marker> element. markerWidth cannot be negative"
            r6.<init>(r7)
            throw r6
        L49:
            java.lang.String r3 = "strokeWidth"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L54
            r6.q = r0
            goto La6
        L54:
            java.lang.String r3 = "userSpaceOnUse"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L60
            r2 = 1
            r6.q = r2
            goto La6
        L60:
            org.xml.sax.SAXException r6 = new org.xml.sax.SAXException
            java.lang.String r7 = "Invalid value for attribute markerUnits"
            r6.<init>(r7)
            throw r6
        L68:
            com.caverock.androidsvg.SVG$n r2 = c0(r2)
            r6.u = r2
            boolean r2 = r2.j()
            if (r2 != 0) goto L75
            goto La6
        L75:
            org.xml.sax.SAXException r6 = new org.xml.sax.SAXException
            java.lang.String r7 = "Invalid <marker> element. markerHeight cannot be negative"
            r6.<init>(r7)
            throw r6
        L7d:
            com.caverock.androidsvg.SVG$n r2 = c0(r2)
            r6.s = r2
            goto La6
        L84:
            com.caverock.androidsvg.SVG$n r2 = c0(r2)
            r6.r = r2
            goto La6
        L8b:
            java.lang.String r3 = "auto"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L9c
            r2 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r6.v = r2
            goto La6
        L9c:
            float r2 = U(r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r6.v = r2
        La6:
            int r1 = r1 + 1
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.x(com.caverock.androidsvg.SVG$p, org.xml.sax.Attributes):void");
    }

    private void x0(Attributes attributes) throws SAXException {
        d("<path>", new Object[0]);
        if (this.b != null) {
            SVG.t tVar = new SVG.t();
            tVar.a = this.a;
            tVar.b = this.b;
            r(tVar, attributes);
            G(tVar, attributes);
            K(tVar, attributes);
            q(tVar, attributes);
            z(tVar, attributes);
            this.b.l(tVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x009d, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void y(com.caverock.androidsvg.SVG.q r9, org.xml.sax.Attributes r10) throws org.xml.sax.SAXException {
        /*
            r8 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r2 = 0
        L5:
            int r3 = r10.getLength()
            if (r2 < r3) goto Lc
            return
        Lc:
            java.lang.String r3 = r10.getValue(r2)
            java.lang.String r3 = r3.trim()
            int[] r4 = a()
            java.lang.String r5 = r10.getLocalName(r2)
            com.caverock.androidsvg.SVGParser$SVGAttr r5 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r5)
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 26
            if (r4 == r5) goto L91
            r5 = 37
            java.lang.String r6 = "userSpaceOnUse"
            java.lang.String r7 = "objectBoundingBox"
            if (r4 == r5) goto L77
            r5 = 38
            if (r4 == r5) goto L5d
            switch(r4) {
                case 82: goto L48;
                case 83: goto L41;
                case 84: goto L3a;
                default: goto L39;
            }
        L39:
            goto L9d
        L3a:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r9.r = r3
            goto L9d
        L41:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r9.q = r3
            goto L9d
        L48:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r9.s = r3
            boolean r3 = r3.j()
            if (r3 != 0) goto L55
            goto L9d
        L55:
            org.xml.sax.SAXException r9 = new org.xml.sax.SAXException
            java.lang.String r10 = "Invalid <mask> element. width cannot be negative"
            r9.<init>(r10)
            throw r9
        L5d:
            boolean r4 = r7.equals(r3)
            if (r4 == 0) goto L66
            r9.o = r1
            goto L9d
        L66:
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L6f
            r9.o = r0
            goto L9d
        L6f:
            org.xml.sax.SAXException r9 = new org.xml.sax.SAXException
            java.lang.String r10 = "Invalid value for attribute maskUnits"
            r9.<init>(r10)
            throw r9
        L77:
            boolean r4 = r7.equals(r3)
            if (r4 == 0) goto L80
            r9.p = r1
            goto L9d
        L80:
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L89
            r9.p = r0
            goto L9d
        L89:
            org.xml.sax.SAXException r9 = new org.xml.sax.SAXException
            java.lang.String r10 = "Invalid value for attribute maskContentUnits"
            r9.<init>(r10)
            throw r9
        L91:
            com.caverock.androidsvg.SVG$n r3 = c0(r3)
            r9.t = r3
            boolean r3 = r3.j()
            if (r3 != 0) goto La1
        L9d:
            int r2 = r2 + 1
            goto L5
        La1:
            org.xml.sax.SAXException r9 = new org.xml.sax.SAXException
            java.lang.String r10 = "Invalid <mask> element. height cannot be negative"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.y(com.caverock.androidsvg.SVG$q, org.xml.sax.Attributes):void");
    }

    private void y0(Attributes attributes) throws SAXException {
        d("<pattern>", new Object[0]);
        if (this.b != null) {
            SVG.w wVar = new SVG.w();
            wVar.a = this.a;
            wVar.b = this.b;
            r(wVar, attributes);
            G(wVar, attributes);
            q(wVar, attributes);
            M(wVar, attributes);
            A(wVar, attributes);
            this.b.l(wVar);
            this.b = wVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    private void z(SVG.t tVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a()[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 14) {
                tVar.o = i0(trim);
            } else if (i3 != 44) {
                continue;
            } else {
                Float valueOf = Float.valueOf(U(trim));
                tVar.p = valueOf;
                if (valueOf.floatValue() < 0.0f) {
                    throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void z0(Attributes attributes) throws SAXException {
        d("<polygon>", new Object[0]);
        if (this.b != null) {
            SVG.x yVar = new SVG.y();
            yVar.a = this.a;
            yVar.b = this.b;
            r(yVar, attributes);
            G(yVar, attributes);
            K(yVar, attributes);
            q(yVar, attributes);
            B(yVar, attributes, D);
            this.b.l(yVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public void E0(String[] strArr) {
        HashSet<String> hashSet = new HashSet<>(strArr.length);
        this.f2543j = hashSet;
        Collections.addAll(hashSet, strArr);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i2, int i3) throws SAXException {
        if (this.f2536c) {
            return;
        }
        if (this.f2538e) {
            if (this.f2540g == null) {
                this.f2540g = new StringBuilder(i3);
            }
            this.f2540g.append(cArr, i2, i3);
        } else if (this.f2541h) {
            if (this.f2542i == null) {
                this.f2542i = new StringBuilder(i3);
            }
            this.f2542i.append(cArr, i2, i3);
        } else {
            SVG.g0 g0Var = this.b;
            if (g0Var instanceof SVG.v0) {
                SVG.e0 e0Var = (SVG.e0) g0Var;
                int size = e0Var.f2501i.size();
                SVG.k0 k0Var = size == 0 ? null : e0Var.f2501i.get(size - 1);
                if (k0Var instanceof SVG.z0) {
                    SVG.z0 z0Var = (SVG.z0) k0Var;
                    z0Var.f2531c = String.valueOf(z0Var.f2531c) + new String(cArr, i2, i3);
                    return;
                }
                ((SVG.e0) this.b).l(new SVG.z0(new String(cArr, i2, i3)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i2, int i3) throws SAXException {
        if (!this.f2536c && this.f2541h) {
            if (this.f2542i == null) {
                this.f2542i = new StringBuilder(i3);
            }
            this.f2542i.append(cArr, i2, i3);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        StringBuilder sb;
        super.endElement(str, str2, str3);
        if (this.f2536c) {
            int i2 = this.f2537d - 1;
            this.f2537d = i2;
            if (i2 == 0) {
                this.f2536c = false;
                return;
            }
        }
        if (f2534l.equals(str) || "".equals(str)) {
            if (!str2.equals("title") && !str2.equals(t)) {
                if (str2.equals(J) && (sb = this.f2542i) != null) {
                    this.f2541h = false;
                    N(sb.toString());
                    this.f2542i.setLength(0);
                    return;
                } else if (str2.equals(o) || str2.equals(s) || str2.equals(v) || str2.equals(R) || str2.equals("image") || str2.equals("text") || str2.equals(Q) || str2.equals(K) || str2.equals(L) || str2.equals(z) || str2.equals(y) || str2.equals(F) || str2.equals(I) || str2.equals(r) || str2.equals(N) || str2.equals(C) || str2.equals(S) || str2.equals(A) || str2.equals(H)) {
                    this.b = ((SVG.k0) this.b).b;
                    return;
                } else {
                    return;
                }
            }
            this.f2538e = false;
            if (this.f2539f.equals("title")) {
                this.a.T(this.f2540g.toString());
            } else if (this.f2539f.equals(t)) {
                this.a.K(this.f2540g.toString());
            }
            this.f2540g.setLength(0);
        }
    }

    public SVG n(InputStream inputStream) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new GZIPInputStream(inputStream);
            }
        } catch (IOException unused) {
        }
        try {
            try {
                try {
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this);
                    xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                    xMLReader.parse(new InputSource(inputStream));
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        Log.e(f2533k, "Exception thrown closing input stream");
                    }
                    return this.a;
                } catch (IOException e2) {
                    throw new SVGParseException("File error", e2);
                } catch (ParserConfigurationException e3) {
                    throw new SVGParseException("XML Parser problem", e3);
                }
            } catch (SAXException e4) {
                throw new SVGParseException("SVG parse error: " + e4.getMessage(), e4);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused3) {
                Log.e(f2533k, "Exception thrown closing input stream");
            }
            throw th;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        super.startDocument();
        this.a = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        super.startElement(str, str2, str3, attributes);
        if (this.f2536c) {
            this.f2537d++;
        } else if (f2534l.equals(str) || "".equals(str)) {
            if (str2.equals(o)) {
                I0(attributes);
            } else if (str2.equals(v)) {
                h(attributes);
            } else if (str2.equals(s)) {
                e(attributes);
            } else if (str2.equals(R)) {
                O0(attributes);
            } else if (str2.equals(B)) {
                x0(attributes);
            } else if (str2.equals(G)) {
                D0(attributes);
            } else if (str2.equals(q)) {
                b(attributes);
            } else if (str2.equals(u)) {
                g(attributes);
            } else if (str2.equals(x)) {
                j(attributes);
            } else if (str2.equals(E)) {
                A0(attributes);
            } else if (str2.equals(D)) {
                z0(attributes);
            } else if (str2.equals("text")) {
                K0(attributes);
            } else if (str2.equals(Q)) {
                N0(attributes);
            } else if (str2.equals(P)) {
                M0(attributes);
            } else if (str2.equals(K)) {
                Q0(attributes);
            } else if (str2.equals(L)) {
                J0(attributes);
            } else if (str2.equals(z)) {
                l(attributes);
            } else if (str2.equals(y)) {
                k(attributes);
            } else if (str2.equals(F)) {
                C0(attributes);
            } else if (str2.equals(I)) {
                G0(attributes);
            } else if (str2.equals("a")) {
                h(attributes);
            } else if (!str2.equals("title") && !str2.equals(t)) {
                if (str2.equals(r)) {
                    c(attributes);
                } else if (str2.equals(N)) {
                    L0(attributes);
                } else if (str2.equals(C)) {
                    y0(attributes);
                } else if (str2.equals("image")) {
                    i(attributes);
                } else if (str2.equals(S)) {
                    P0(attributes);
                } else if (str2.equals(A)) {
                    m(attributes);
                } else if (str2.equals(J)) {
                    H0(attributes);
                } else if (str2.equals(H)) {
                    F0(attributes);
                } else {
                    this.f2536c = true;
                    this.f2537d = 1;
                }
            } else {
                this.f2538e = true;
                this.f2539f = str2;
            }
        }
    }
}
