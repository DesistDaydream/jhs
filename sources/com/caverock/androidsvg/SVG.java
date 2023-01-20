package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class SVG {
    public static final long A = 8192;
    public static final long B = 16384;
    public static final long C = 32768;
    public static final long D = 65536;
    public static final long E = 131072;
    public static final long F = 262144;
    public static final long G = 524288;
    public static final long H = 1048576;
    public static final long I = 2097152;
    public static final long J = 4194304;
    public static final long K = 8388608;
    public static final long L = 16777216;
    public static final long M = 33554432;
    public static final long N = 67108864;
    public static final long O = 134217728;
    public static final long P = 268435456;
    public static final long Q = 536870912;
    public static final long R = 1073741824;
    public static final long S = 2147483648L;
    public static final long T = 4294967296L;
    public static final long U = 8589934592L;
    public static final long V = 17179869184L;
    public static final long W = 34359738368L;
    public static final long X = 68719476736L;
    public static final long Y = -1;
    public static final long Z = 68133849088L;

    /* renamed from: g  reason: collision with root package name */
    private static final String f2472g = "AndroidSVG";

    /* renamed from: h  reason: collision with root package name */
    private static final String f2473h = "1.2.1";

    /* renamed from: i  reason: collision with root package name */
    public static final String f2474i = "1.2";

    /* renamed from: j  reason: collision with root package name */
    private static final int f2475j = 512;

    /* renamed from: k  reason: collision with root package name */
    private static final int f2476k = 512;

    /* renamed from: l  reason: collision with root package name */
    private static final double f2477l = 1.414213562373095d;

    /* renamed from: m  reason: collision with root package name */
    private static final List<k0> f2478m = new ArrayList(0);
    public static final long n = 1;
    public static final long o = 2;
    public static final long p = 4;
    public static final long q = 8;
    public static final long r = 16;
    public static final long s = 32;
    public static final long t = 64;
    public static final long u = 128;
    public static final long v = 256;
    public static final long w = 512;
    public static final long x = 1024;
    public static final long y = 2048;
    public static final long z = 4096;
    private c0 a = null;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f2479c = "";

    /* renamed from: d  reason: collision with root package name */
    private e.d.a.c f2480d = null;

    /* renamed from: e  reason: collision with root package name */
    private float f2481e = 96.0f;

    /* renamed from: f  reason: collision with root package name */
    private CSSParser.d f2482f = new CSSParser.d();

    /* loaded from: classes.dex */
    public enum GradientSpread {
        pad,
        reflect,
        repeat;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static GradientSpread[] valuesCustom() {
            GradientSpread[] valuesCustom = values();
            int length = valuesCustom.length;
            GradientSpread[] gradientSpreadArr = new GradientSpread[length];
            System.arraycopy(valuesCustom, 0, gradientSpreadArr, 0, length);
            return gradientSpreadArr;
        }
    }

    /* loaded from: classes.dex */
    public static class Style implements Cloneable {
        public static final int M = 400;
        public static final int N = 700;
        public static final int O = -1;
        public static final int P = 1;
        public Boolean A;
        public Boolean B;
        public l0 C;
        public Float D;
        public String E;
        public FillRule F;
        public String G;
        public l0 H;
        public Float I;
        public l0 J;
        public Float K;
        public VectorEffect L;
        public long a = 0;
        public l0 b;

        /* renamed from: c  reason: collision with root package name */
        public FillRule f2483c;

        /* renamed from: d  reason: collision with root package name */
        public Float f2484d;

        /* renamed from: e  reason: collision with root package name */
        public l0 f2485e;

        /* renamed from: f  reason: collision with root package name */
        public Float f2486f;

        /* renamed from: g  reason: collision with root package name */
        public n f2487g;

        /* renamed from: h  reason: collision with root package name */
        public LineCaps f2488h;

        /* renamed from: i  reason: collision with root package name */
        public LineJoin f2489i;

        /* renamed from: j  reason: collision with root package name */
        public Float f2490j;

        /* renamed from: k  reason: collision with root package name */
        public n[] f2491k;

        /* renamed from: l  reason: collision with root package name */
        public n f2492l;

        /* renamed from: m  reason: collision with root package name */
        public Float f2493m;
        public e n;
        public List<String> o;
        public n p;
        public Integer q;
        public FontStyle r;
        public TextDecoration s;
        public TextDirection t;
        public TextAnchor u;
        public Boolean v;
        public b w;
        public String x;
        public String y;
        public String z;

        /* loaded from: classes.dex */
        public enum FillRule {
            NonZero,
            EvenOdd;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static FillRule[] valuesCustom() {
                FillRule[] valuesCustom = values();
                int length = valuesCustom.length;
                FillRule[] fillRuleArr = new FillRule[length];
                System.arraycopy(valuesCustom, 0, fillRuleArr, 0, length);
                return fillRuleArr;
            }
        }

        /* loaded from: classes.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static FontStyle[] valuesCustom() {
                FontStyle[] valuesCustom = values();
                int length = valuesCustom.length;
                FontStyle[] fontStyleArr = new FontStyle[length];
                System.arraycopy(valuesCustom, 0, fontStyleArr, 0, length);
                return fontStyleArr;
            }
        }

        /* loaded from: classes.dex */
        public enum LineCaps {
            Butt,
            Round,
            Square;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static LineCaps[] valuesCustom() {
                LineCaps[] valuesCustom = values();
                int length = valuesCustom.length;
                LineCaps[] lineCapsArr = new LineCaps[length];
                System.arraycopy(valuesCustom, 0, lineCapsArr, 0, length);
                return lineCapsArr;
            }
        }

        /* loaded from: classes.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static LineJoin[] valuesCustom() {
                LineJoin[] valuesCustom = values();
                int length = valuesCustom.length;
                LineJoin[] lineJoinArr = new LineJoin[length];
                System.arraycopy(valuesCustom, 0, lineJoinArr, 0, length);
                return lineJoinArr;
            }
        }

        /* loaded from: classes.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static TextAnchor[] valuesCustom() {
                TextAnchor[] valuesCustom = values();
                int length = valuesCustom.length;
                TextAnchor[] textAnchorArr = new TextAnchor[length];
                System.arraycopy(valuesCustom, 0, textAnchorArr, 0, length);
                return textAnchorArr;
            }
        }

        /* loaded from: classes.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static TextDecoration[] valuesCustom() {
                TextDecoration[] valuesCustom = values();
                int length = valuesCustom.length;
                TextDecoration[] textDecorationArr = new TextDecoration[length];
                System.arraycopy(valuesCustom, 0, textDecorationArr, 0, length);
                return textDecorationArr;
            }
        }

        /* loaded from: classes.dex */
        public enum TextDirection {
            LTR,
            RTL;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static TextDirection[] valuesCustom() {
                TextDirection[] valuesCustom = values();
                int length = valuesCustom.length;
                TextDirection[] textDirectionArr = new TextDirection[length];
                System.arraycopy(valuesCustom, 0, textDirectionArr, 0, length);
                return textDirectionArr;
            }
        }

        /* loaded from: classes.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static VectorEffect[] valuesCustom() {
                VectorEffect[] valuesCustom = values();
                int length = valuesCustom.length;
                VectorEffect[] vectorEffectArr = new VectorEffect[length];
                System.arraycopy(valuesCustom, 0, vectorEffectArr, 0, length);
                return vectorEffectArr;
            }
        }

        public static Style a() {
            Style style = new Style();
            style.a = -1L;
            e eVar = e.b;
            style.b = eVar;
            FillRule fillRule = FillRule.NonZero;
            style.f2483c = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.f2484d = valueOf;
            style.f2485e = null;
            style.f2486f = valueOf;
            style.f2487g = new n(1.0f);
            style.f2488h = LineCaps.Butt;
            style.f2489i = LineJoin.Miter;
            style.f2490j = Float.valueOf(4.0f);
            style.f2491k = null;
            style.f2492l = new n(0.0f);
            style.f2493m = valueOf;
            style.n = eVar;
            style.o = null;
            style.p = new n(12.0f, Unit.pt);
            style.q = 400;
            style.r = FontStyle.Normal;
            style.s = TextDecoration.None;
            style.t = TextDirection.LTR;
            style.u = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.v = bool;
            style.w = null;
            style.x = null;
            style.y = null;
            style.z = null;
            style.A = bool;
            style.B = bool;
            style.C = eVar;
            style.D = valueOf;
            style.E = null;
            style.F = fillRule;
            style.G = null;
            style.H = null;
            style.I = valueOf;
            style.J = null;
            style.K = valueOf;
            style.L = VectorEffect.None;
            return style;
        }

        public void b() {
            c(false);
        }

        public void c(boolean z) {
            Boolean bool = Boolean.TRUE;
            this.A = bool;
            if (!z) {
                bool = Boolean.FALSE;
            }
            this.v = bool;
            this.w = null;
            this.E = null;
            this.f2493m = Float.valueOf(1.0f);
            this.C = e.b;
            this.D = Float.valueOf(1.0f);
            this.G = null;
            this.H = null;
            this.I = Float.valueOf(1.0f);
            this.J = null;
            this.K = Float.valueOf(1.0f);
            this.L = VectorEffect.None;
        }

        public Object clone() {
            try {
                Style style = (Style) super.clone();
                n[] nVarArr = this.f2491k;
                if (nVarArr != null) {
                    style.f2491k = (n[]) nVarArr.clone();
                }
                return style;
            } catch (CloneNotSupportedException e2) {
                throw new InternalError(e2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Unit[] valuesCustom() {
            Unit[] valuesCustom = values();
            int length = valuesCustom.length;
            Unit[] unitArr = new Unit[length];
            System.arraycopy(valuesCustom, 0, unitArr, 0, length);
            return unitArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a implements Cloneable {
        public float a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f2494c;

        /* renamed from: d  reason: collision with root package name */
        public float f2495d;

        public a(float f2, float f3, float f4, float f5) {
            this.a = f2;
            this.b = f3;
            this.f2494c = f4;
            this.f2495d = f5;
        }

        public static a a(float f2, float f3, float f4, float f5) {
            return new a(f2, f3, f4 - f2, f5 - f3);
        }

        public float b() {
            return this.a + this.f2494c;
        }

        public float c() {
            return this.b + this.f2495d;
        }

        public RectF e() {
            return new RectF(this.a, this.b, b(), c());
        }

        public void f(a aVar) {
            float f2 = aVar.a;
            if (f2 < this.a) {
                this.a = f2;
            }
            float f3 = aVar.b;
            if (f3 < this.b) {
                this.b = f3;
            }
            if (aVar.b() > b()) {
                this.f2494c = aVar.b() - this.a;
            }
            if (aVar.c() > c()) {
                this.f2495d = aVar.c() - this.b;
            }
        }

        public String toString() {
            return "[" + this.a + ExpandableTextView.N + this.b + ExpandableTextView.N + this.f2494c + ExpandableTextView.N + this.f2495d + "]";
        }
    }

    /* loaded from: classes.dex */
    public static class a0 extends i0 implements g0 {

        /* renamed from: h  reason: collision with root package name */
        public n f2496h;

        /* renamed from: i  reason: collision with root package name */
        public n f2497i;

        @Override // com.caverock.androidsvg.SVG.g0
        public List<k0> k() {
            return SVG.f2478m;
        }

        @Override // com.caverock.androidsvg.SVG.g0
        public void l(k0 k0Var) throws SAXException {
        }
    }

    /* loaded from: classes.dex */
    public static class a1 extends k {
        public String p;
        public n q;
        public n r;
        public n s;
        public n t;
    }

    /* loaded from: classes.dex */
    public static class b {
        public n a;
        public n b;

        /* renamed from: c  reason: collision with root package name */
        public n f2498c;

        /* renamed from: d  reason: collision with root package name */
        public n f2499d;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.a = nVar;
            this.b = nVar2;
            this.f2498c = nVar3;
            this.f2499d = nVar4;
        }
    }

    /* loaded from: classes.dex */
    public static class b0 extends i0 implements g0 {

        /* renamed from: h  reason: collision with root package name */
        public Float f2500h;

        @Override // com.caverock.androidsvg.SVG.g0
        public List<k0> k() {
            return SVG.f2478m;
        }

        @Override // com.caverock.androidsvg.SVG.g0
        public void l(k0 k0Var) throws SAXException {
        }
    }

    /* loaded from: classes.dex */
    public static class b1 extends o0 implements r {
    }

    /* loaded from: classes.dex */
    public static class c extends j {
        public n o;
        public n p;
        public n q;
    }

    /* loaded from: classes.dex */
    public static class c0 extends o0 {
        public n q;
        public n r;
        public n s;
        public n t;
        public String u;
    }

    /* loaded from: classes.dex */
    public static class d extends k implements r {
        public Boolean p;
    }

    /* loaded from: classes.dex */
    public interface d0 {
        Set<String> a();

        Set<String> b();

        String c();

        void d(Set<String> set);

        void f(Set<String> set);

        void g(Set<String> set);

        void h(Set<String> set);

        void i(String str);

        Set<String> n();

        Set<String> o();
    }

    /* loaded from: classes.dex */
    public static class e extends l0 {
        public static final e b = new e(0);
        public int a;

        public e(int i2) {
            this.a = i2;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.a));
        }
    }

    /* loaded from: classes.dex */
    public static class e0 extends h0 implements g0, d0 {

        /* renamed from: i  reason: collision with root package name */
        public List<k0> f2501i = new ArrayList();

        /* renamed from: j  reason: collision with root package name */
        public Set<String> f2502j = null;

        /* renamed from: k  reason: collision with root package name */
        public String f2503k = null;

        /* renamed from: l  reason: collision with root package name */
        public Set<String> f2504l = null;

        /* renamed from: m  reason: collision with root package name */
        public Set<String> f2505m = null;
        public Set<String> n = null;

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> a() {
            return this.f2502j;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> b() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public String c() {
            return this.f2503k;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void d(Set<String> set) {
            this.n = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void f(Set<String> set) {
            this.f2502j = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void g(Set<String> set) {
            this.f2504l = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void h(Set<String> set) {
            this.f2505m = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void i(String str) {
            this.f2503k = str;
        }

        @Override // com.caverock.androidsvg.SVG.g0
        public List<k0> k() {
            return this.f2501i;
        }

        @Override // com.caverock.androidsvg.SVG.g0
        public void l(k0 k0Var) throws SAXException {
            this.f2501i.add(k0Var);
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> n() {
            return this.f2505m;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> o() {
            return this.n;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends l0 {
        private static f a = new f();

        private f() {
        }

        public static f a() {
            return a;
        }
    }

    /* loaded from: classes.dex */
    public static class f0 extends h0 implements d0 {

        /* renamed from: i  reason: collision with root package name */
        public Set<String> f2506i = null;

        /* renamed from: j  reason: collision with root package name */
        public String f2507j = null;

        /* renamed from: k  reason: collision with root package name */
        public Set<String> f2508k = null;

        /* renamed from: l  reason: collision with root package name */
        public Set<String> f2509l = null;

        /* renamed from: m  reason: collision with root package name */
        public Set<String> f2510m = null;

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> a() {
            return this.f2506i;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> b() {
            return this.f2508k;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public String c() {
            return this.f2507j;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void d(Set<String> set) {
            this.f2510m = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void f(Set<String> set) {
            this.f2506i = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void g(Set<String> set) {
            this.f2508k = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void h(Set<String> set) {
            this.f2509l = set;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public void i(String str) {
            this.f2507j = str;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> n() {
            return this.f2509l;
        }

        @Override // com.caverock.androidsvg.SVG.d0
        public Set<String> o() {
            return this.f2510m;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends k implements r {
    }

    /* loaded from: classes.dex */
    public interface g0 {
        List<k0> k();

        void l(k0 k0Var) throws SAXException;
    }

    /* loaded from: classes.dex */
    public static class h extends j {
        public n o;
        public n p;
        public n q;
        public n r;
    }

    /* loaded from: classes.dex */
    public static class h0 extends i0 {

        /* renamed from: h  reason: collision with root package name */
        public a f2511h = null;
    }

    /* loaded from: classes.dex */
    public static class i extends i0 implements g0 {

        /* renamed from: h  reason: collision with root package name */
        public List<k0> f2512h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public Boolean f2513i;

        /* renamed from: j  reason: collision with root package name */
        public Matrix f2514j;

        /* renamed from: k  reason: collision with root package name */
        public GradientSpread f2515k;

        /* renamed from: l  reason: collision with root package name */
        public String f2516l;

        @Override // com.caverock.androidsvg.SVG.g0
        public List<k0> k() {
            return this.f2512h;
        }

        @Override // com.caverock.androidsvg.SVG.g0
        public void l(k0 k0Var) throws SAXException {
            if (k0Var instanceof b0) {
                this.f2512h.add(k0Var);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + k0Var + " elements.");
        }
    }

    /* loaded from: classes.dex */
    public static class i0 extends k0 {

        /* renamed from: c  reason: collision with root package name */
        public String f2517c = null;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f2518d = null;

        /* renamed from: e  reason: collision with root package name */
        public Style f2519e = null;

        /* renamed from: f  reason: collision with root package name */
        public Style f2520f = null;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f2521g = null;
    }

    /* loaded from: classes.dex */
    public static abstract class j extends f0 implements l {
        public Matrix n;

        @Override // com.caverock.androidsvg.SVG.l
        public void m(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* loaded from: classes.dex */
    public static class j0 extends i {

        /* renamed from: m  reason: collision with root package name */
        public n f2522m;
        public n n;
        public n o;
        public n p;
    }

    /* loaded from: classes.dex */
    public static class k extends e0 implements l {
        public Matrix o;

        @Override // com.caverock.androidsvg.SVG.l
        public void m(Matrix matrix) {
            this.o = matrix;
        }
    }

    /* loaded from: classes.dex */
    public static class k0 {
        public SVG a;
        public g0 b;

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        void m(Matrix matrix);
    }

    /* loaded from: classes.dex */
    public static abstract class l0 implements Cloneable {
    }

    /* loaded from: classes.dex */
    public static class m extends m0 implements l {
        public String p;
        public n q;
        public n r;
        public n s;
        public n t;
        public Matrix u;

        @Override // com.caverock.androidsvg.SVG.l
        public void m(Matrix matrix) {
            this.u = matrix;
        }
    }

    /* loaded from: classes.dex */
    public static class m0 extends e0 {
        public PreserveAspectRatio o = null;
    }

    /* loaded from: classes.dex */
    public static class n0 extends i {

        /* renamed from: m  reason: collision with root package name */
        public n f2524m;
        public n n;
        public n o;
        public n p;
        public n q;
    }

    /* loaded from: classes.dex */
    public static class o extends j {
        public n o;
        public n p;
        public n q;
        public n r;
    }

    /* loaded from: classes.dex */
    public static class o0 extends m0 {
        public a p;
    }

    /* loaded from: classes.dex */
    public static class p extends o0 implements r {
        public boolean q;
        public n r;
        public n s;
        public n t;
        public n u;
        public Float v;
    }

    /* loaded from: classes.dex */
    public static class p0 extends k {
    }

    /* loaded from: classes.dex */
    public static class q extends e0 implements r {
        public Boolean o;
        public Boolean p;
        public n q;
        public n r;
        public n s;
        public n t;
    }

    /* loaded from: classes.dex */
    public static class q0 extends o0 implements r {
    }

    /* loaded from: classes.dex */
    public interface r {
    }

    /* loaded from: classes.dex */
    public static class r0 extends v0 implements u0 {
        public String o;
        private y0 p;

        @Override // com.caverock.androidsvg.SVG.u0
        public y0 e() {
            return this.p;
        }

        @Override // com.caverock.androidsvg.SVG.u0
        public void j(y0 y0Var) {
            this.p = y0Var;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends l0 {
        public String a;
        public l0 b;

        public s(String str, l0 l0Var) {
            this.a = str;
            this.b = l0Var;
        }

        public String toString() {
            return String.valueOf(this.a) + ExpandableTextView.N + this.b;
        }
    }

    /* loaded from: classes.dex */
    public static class s0 extends x0 implements u0 {
        private y0 s;

        @Override // com.caverock.androidsvg.SVG.u0
        public y0 e() {
            return this.s;
        }

        @Override // com.caverock.androidsvg.SVG.u0
        public void j(y0 y0Var) {
            this.s = y0Var;
        }
    }

    /* loaded from: classes.dex */
    public static class t extends j {
        public u o;
        public Float p;
    }

    /* loaded from: classes.dex */
    public static class t0 extends x0 implements y0, l {
        public Matrix s;

        @Override // com.caverock.androidsvg.SVG.l
        public void m(Matrix matrix) {
            this.s = matrix;
        }
    }

    /* loaded from: classes.dex */
    public static class u implements v {

        /* renamed from: c  reason: collision with root package name */
        private static final byte f2525c = 0;

        /* renamed from: d  reason: collision with root package name */
        private static final byte f2526d = 1;

        /* renamed from: e  reason: collision with root package name */
        private static final byte f2527e = 2;

        /* renamed from: f  reason: collision with root package name */
        private static final byte f2528f = 3;

        /* renamed from: g  reason: collision with root package name */
        private static final byte f2529g = 4;

        /* renamed from: h  reason: collision with root package name */
        private static final byte f2530h = 8;
        private List<Byte> a;
        private List<Float> b;

        public u() {
            this.a = null;
            this.b = null;
            this.a = new ArrayList();
            this.b = new ArrayList();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f2, float f3, float f4, float f5) {
            this.a.add((byte) 3);
            this.b.add(Float.valueOf(f2));
            this.b.add(Float.valueOf(f3));
            this.b.add(Float.valueOf(f4));
            this.b.add(Float.valueOf(f5));
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f2, float f3) {
            this.a.add((byte) 0);
            this.b.add(Float.valueOf(f2));
            this.b.add(Float.valueOf(f3));
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void c(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.a.add((byte) 2);
            this.b.add(Float.valueOf(f2));
            this.b.add(Float.valueOf(f3));
            this.b.add(Float.valueOf(f4));
            this.b.add(Float.valueOf(f5));
            this.b.add(Float.valueOf(f6));
            this.b.add(Float.valueOf(f7));
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.a.add((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void d(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            this.a.add(Byte.valueOf((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0))));
            this.b.add(Float.valueOf(f2));
            this.b.add(Float.valueOf(f3));
            this.b.add(Float.valueOf(f4));
            this.b.add(Float.valueOf(f5));
            this.b.add(Float.valueOf(f6));
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void e(float f2, float f3) {
            this.a.add((byte) 1);
            this.b.add(Float.valueOf(f2));
            this.b.add(Float.valueOf(f3));
        }

        public void f(v vVar) {
            Iterator<Float> it = this.b.iterator();
            for (Byte b : this.a) {
                byte byteValue = b.byteValue();
                if (byteValue == 0) {
                    vVar.b(it.next().floatValue(), it.next().floatValue());
                } else if (byteValue == 1) {
                    vVar.e(it.next().floatValue(), it.next().floatValue());
                } else if (byteValue == 2) {
                    vVar.c(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                } else if (byteValue == 3) {
                    vVar.a(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                } else if (byteValue != 8) {
                    vVar.d(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), (byteValue & 2) != 0, (byteValue & 1) != 0, it.next().floatValue(), it.next().floatValue());
                } else {
                    vVar.close();
                }
            }
        }

        public boolean g() {
            return this.a.isEmpty();
        }
    }

    /* loaded from: classes.dex */
    public interface u0 {
        y0 e();

        void j(y0 y0Var);
    }

    /* loaded from: classes.dex */
    public interface v {
        void a(float f2, float f3, float f4, float f5);

        void b(float f2, float f3);

        void c(float f2, float f3, float f4, float f5, float f6, float f7);

        void close();

        void d(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6);

        void e(float f2, float f3);
    }

    /* loaded from: classes.dex */
    public static class v0 extends e0 {
        @Override // com.caverock.androidsvg.SVG.e0, com.caverock.androidsvg.SVG.g0
        public void l(k0 k0Var) throws SAXException {
            if (k0Var instanceof u0) {
                this.f2501i.add(k0Var);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + k0Var + " elements.");
        }
    }

    /* loaded from: classes.dex */
    public static class w extends o0 implements r {
        public Boolean q;
        public Boolean r;
        public Matrix s;
        public n t;
        public n u;
        public n v;
        public n w;
        public String x;
    }

    /* loaded from: classes.dex */
    public static class w0 extends v0 implements u0 {
        public String o;
        public n p;
        private y0 q;

        @Override // com.caverock.androidsvg.SVG.u0
        public y0 e() {
            return this.q;
        }

        @Override // com.caverock.androidsvg.SVG.u0
        public void j(y0 y0Var) {
            this.q = y0Var;
        }
    }

    /* loaded from: classes.dex */
    public static class x extends j {
        public float[] o;
    }

    /* loaded from: classes.dex */
    public static class x0 extends v0 {
        public List<n> o;
        public List<n> p;
        public List<n> q;
        public List<n> r;
    }

    /* loaded from: classes.dex */
    public static class y extends x {
    }

    /* loaded from: classes.dex */
    public interface y0 {
    }

    /* loaded from: classes.dex */
    public static class z extends j {
        public n o;
        public n p;
        public n q;
        public n r;
        public n s;
        public n t;
    }

    /* loaded from: classes.dex */
    public static class z0 extends k0 implements u0 {

        /* renamed from: c  reason: collision with root package name */
        public String f2531c;

        /* renamed from: d  reason: collision with root package name */
        private y0 f2532d;

        public z0(String str) {
            this.f2531c = str;
        }

        @Override // com.caverock.androidsvg.SVG.u0
        public y0 e() {
            return this.f2532d;
        }

        @Override // com.caverock.androidsvg.SVG.u0
        public void j(y0 y0Var) {
            this.f2532d = y0Var;
        }

        @Override // com.caverock.androidsvg.SVG.k0
        public String toString() {
            return String.valueOf(getClass().getSimpleName()) + " '" + this.f2531c + "'";
        }
    }

    private a f(float f2) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        Unit unit4;
        float f3;
        Unit unit5;
        c0 c0Var = this.a;
        n nVar = c0Var.s;
        n nVar2 = c0Var.t;
        if (nVar != null && !nVar.k() && (unit = nVar.b) != (unit2 = Unit.percent) && unit != (unit3 = Unit.em) && unit != (unit4 = Unit.ex)) {
            float c2 = nVar.c(f2);
            if (nVar2 != null) {
                if (!nVar2.k() && (unit5 = nVar2.b) != unit2 && unit5 != unit3 && unit5 != unit4) {
                    f3 = nVar2.c(f2);
                } else {
                    return new a(-1.0f, -1.0f, -1.0f, -1.0f);
                }
            } else {
                a aVar = this.a.p;
                f3 = aVar != null ? (aVar.f2495d * c2) / aVar.f2494c : c2;
            }
            return new a(0.0f, 0.0f, c2, f3);
        }
        return new a(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    private i0 m(g0 g0Var, String str) {
        i0 m2;
        i0 i0Var = (i0) g0Var;
        if (str.equals(i0Var.f2517c)) {
            return i0Var;
        }
        for (k0 k0Var : g0Var.k()) {
            if (k0Var instanceof i0) {
                i0 i0Var2 = (i0) k0Var;
                if (str.equals(i0Var2.f2517c)) {
                    return i0Var2;
                }
                if ((k0Var instanceof g0) && (m2 = m((g0) k0Var, str)) != null) {
                    return m2;
                }
            }
        }
        return null;
    }

    private List<k0> o(g0 g0Var, Class cls) {
        ArrayList arrayList = new ArrayList();
        if (g0Var.getClass() == cls) {
            arrayList.add((k0) g0Var);
        }
        for (k0 k0Var : g0Var.k()) {
            if (k0Var.getClass() == cls) {
                arrayList.add(k0Var);
            }
            if (k0Var instanceof g0) {
                o((g0) k0Var, cls);
            }
        }
        return arrayList;
    }

    public static SVG r(AssetManager assetManager, String str) throws SVGParseException, IOException {
        SVGParser sVGParser = new SVGParser();
        InputStream open = assetManager.open(str);
        SVG n2 = sVGParser.n(open);
        open.close();
        return n2;
    }

    public static SVG s(InputStream inputStream) throws SVGParseException {
        return new SVGParser().n(inputStream);
    }

    public static SVG t(Context context, int i2) throws SVGParseException {
        return u(context.getResources(), i2);
    }

    public static SVG u(Resources resources, int i2) throws SVGParseException {
        return new SVGParser().n(resources.openRawResource(i2));
    }

    public static SVG v(String str) throws SVGParseException {
        return new SVGParser().n(new ByteArrayInputStream(str.getBytes()));
    }

    public static String y() {
        return f2473h;
    }

    public boolean A() {
        return !this.f2482f.d();
    }

    public void B(e.d.a.c cVar) {
        this.f2480d = cVar;
    }

    public void C(Canvas canvas) {
        D(canvas, null);
    }

    public void D(Canvas canvas, RectF rectF) {
        a aVar;
        if (rectF != null) {
            aVar = a.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        } else {
            aVar = new a(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new e.d.a.b(canvas, aVar, this.f2481e).K0(this, null, null, true);
    }

    public Picture E() {
        float c2;
        n nVar = this.a.s;
        if (nVar != null) {
            float c3 = nVar.c(this.f2481e);
            c0 c0Var = this.a;
            a aVar = c0Var.p;
            if (aVar != null) {
                c2 = (aVar.f2495d * c3) / aVar.f2494c;
            } else {
                n nVar2 = c0Var.t;
                c2 = nVar2 != null ? nVar2.c(this.f2481e) : c3;
            }
            return F((int) Math.ceil(c3), (int) Math.ceil(c2));
        }
        return F(512, 512);
    }

    public Picture F(int i2, int i3) {
        Picture picture = new Picture();
        new e.d.a.b(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.f2481e).K0(this, null, null, false);
        picture.endRecording();
        return picture;
    }

    public void G(String str, Canvas canvas) {
        H(str, canvas, null);
    }

    public void H(String str, Canvas canvas, RectF rectF) {
        a aVar;
        k0 n2 = n(str);
        if (n2 != null && (n2 instanceof b1)) {
            b1 b1Var = (b1) n2;
            if (b1Var.p == null) {
                Log.w(f2472g, "View element is missing a viewBox attribute.");
                return;
            }
            if (rectF != null) {
                aVar = a.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                aVar = new a(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            }
            new e.d.a.b(canvas, aVar, this.f2481e).K0(this, b1Var.p, b1Var.o, true);
        }
    }

    public Picture I(String str, int i2, int i3) {
        k0 n2 = n(str);
        if (n2 != null && (n2 instanceof b1)) {
            b1 b1Var = (b1) n2;
            if (b1Var.p == null) {
                Log.w(f2472g, "View element is missing a viewBox attribute.");
                return null;
            }
            Picture picture = new Picture();
            new e.d.a.b(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.f2481e).K0(this, b1Var.p, b1Var.o, false);
            picture.endRecording();
            return picture;
        }
        return null;
    }

    public k0 J(String str) {
        if (str != null && str.length() > 1 && str.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            return n(str.substring(1));
        }
        return null;
    }

    public void K(String str) {
        this.f2479c = str;
    }

    public void L(float f2) {
        c0 c0Var = this.a;
        if (c0Var != null) {
            c0Var.t = new n(f2);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void M(String str) throws SVGParseException {
        c0 c0Var = this.a;
        if (c0Var != null) {
            try {
                c0Var.t = SVGParser.c0(str);
                return;
            } catch (SAXException e2) {
                throw new SVGParseException(e2.getMessage());
            }
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void N(PreserveAspectRatio preserveAspectRatio) {
        c0 c0Var = this.a;
        if (c0Var != null) {
            c0Var.o = preserveAspectRatio;
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void O(float f2, float f3, float f4, float f5) {
        c0 c0Var = this.a;
        if (c0Var != null) {
            c0Var.p = new a(f2, f3, f4, f5);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void P(float f2) {
        c0 c0Var = this.a;
        if (c0Var != null) {
            c0Var.s = new n(f2);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void Q(String str) throws SVGParseException {
        c0 c0Var = this.a;
        if (c0Var != null) {
            try {
                c0Var.s = SVGParser.c0(str);
                return;
            } catch (SAXException e2) {
                throw new SVGParseException(e2.getMessage());
            }
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void R(float f2) {
        this.f2481e = f2;
    }

    public void S(c0 c0Var) {
        this.a = c0Var;
    }

    public void T(String str) {
        this.b = str;
    }

    public void b(CSSParser.d dVar) {
        this.f2482f.b(dVar);
    }

    public List<CSSParser.c> c() {
        return this.f2482f.c();
    }

    public float d() {
        c0 c0Var = this.a;
        if (c0Var != null) {
            n nVar = c0Var.s;
            n nVar2 = c0Var.t;
            if (nVar != null && nVar2 != null) {
                Unit unit = nVar.b;
                Unit unit2 = Unit.percent;
                if (unit != unit2 && nVar2.b != unit2) {
                    if (nVar.k() || nVar2.k()) {
                        return -1.0f;
                    }
                    return nVar.c(this.f2481e) / nVar2.c(this.f2481e);
                }
            }
            a aVar = c0Var.p;
            if (aVar != null) {
                float f2 = aVar.f2494c;
                if (f2 != 0.0f) {
                    float f3 = aVar.f2495d;
                    if (f3 != 0.0f) {
                        return f2 / f3;
                    }
                }
            }
            return -1.0f;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String e() {
        if (this.a != null) {
            return this.f2479c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float g() {
        if (this.a != null) {
            return f(this.f2481e).f2495d;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public PreserveAspectRatio h() {
        c0 c0Var = this.a;
        if (c0Var != null) {
            PreserveAspectRatio preserveAspectRatio = c0Var.o;
            if (preserveAspectRatio == null) {
                return null;
            }
            return preserveAspectRatio;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String i() {
        c0 c0Var = this.a;
        if (c0Var != null) {
            return c0Var.u;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String j() {
        if (this.a != null) {
            return this.b;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF k() {
        c0 c0Var = this.a;
        if (c0Var != null) {
            a aVar = c0Var.p;
            if (aVar == null) {
                return null;
            }
            return aVar.e();
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float l() {
        if (this.a != null) {
            return f(this.f2481e).f2494c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public k0 n(String str) {
        if (str.equals(this.a.f2517c)) {
            return this.a;
        }
        return m(this.a, str);
    }

    public List<k0> p(Class cls) {
        return o(this.a, cls);
    }

    public e.d.a.c q() {
        return this.f2480d;
    }

    public float w() {
        return this.f2481e;
    }

    public c0 x() {
        return this.a;
    }

    public Set<String> z() {
        if (this.a != null) {
            List<k0> p2 = p(b1.class);
            HashSet hashSet = new HashSet(p2.size());
            Iterator<k0> it = p2.iterator();
            while (it.hasNext()) {
                String str = ((b1) it.next()).f2517c;
                if (str != null) {
                    hashSet.add(str);
                } else {
                    Log.w(f2472g, "getViewList(): found a <view> without an id attribute");
                }
            }
            return hashSet;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* loaded from: classes.dex */
    public static class n implements Cloneable {

        /* renamed from: c  reason: collision with root package name */
        private static /* synthetic */ int[] f2523c;
        public float a;
        public Unit b;

        public n(float f2, Unit unit) {
            this.a = 0.0f;
            this.b = Unit.px;
            this.a = f2;
            this.b = unit;
        }

        public static /* synthetic */ int[] a() {
            int[] iArr = f2523c;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[Unit.valuesCustom().length];
            try {
                iArr2[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            f2523c = iArr2;
            return iArr2;
        }

        public float b() {
            return this.a;
        }

        public float c(float f2) {
            int i2 = a()[this.b.ordinal()];
            if (i2 != 1) {
                switch (i2) {
                    case 4:
                        return this.a * f2;
                    case 5:
                        return (this.a * f2) / 2.54f;
                    case 6:
                        return (this.a * f2) / 25.4f;
                    case 7:
                        return (this.a * f2) / 72.0f;
                    case 8:
                        return (this.a * f2) / 6.0f;
                    default:
                        return this.a;
                }
            }
            return this.a;
        }

        public float e(e.d.a.b bVar) {
            if (this.b == Unit.percent) {
                a a0 = bVar.a0();
                if (a0 == null) {
                    return this.a;
                }
                float f2 = a0.f2494c;
                float f3 = a0.f2495d;
                if (f2 == f3) {
                    return (this.a * f2) / 100.0f;
                }
                return (this.a * ((float) (Math.sqrt((f2 * f2) + (f3 * f3)) / SVG.f2477l))) / 100.0f;
            }
            return g(bVar);
        }

        public float f(e.d.a.b bVar, float f2) {
            if (this.b == Unit.percent) {
                return (this.a * f2) / 100.0f;
            }
            return g(bVar);
        }

        public float g(e.d.a.b bVar) {
            switch (a()[this.b.ordinal()]) {
                case 1:
                    return this.a;
                case 2:
                    return this.a * bVar.Y();
                case 3:
                    return this.a * bVar.Z();
                case 4:
                    return this.a * bVar.b0();
                case 5:
                    return (this.a * bVar.b0()) / 2.54f;
                case 6:
                    return (this.a * bVar.b0()) / 25.4f;
                case 7:
                    return (this.a * bVar.b0()) / 72.0f;
                case 8:
                    return (this.a * bVar.b0()) / 6.0f;
                case 9:
                    a a0 = bVar.a0();
                    if (a0 == null) {
                        return this.a;
                    }
                    return (this.a * a0.f2494c) / 100.0f;
                default:
                    return this.a;
            }
        }

        public float h(e.d.a.b bVar) {
            if (this.b == Unit.percent) {
                a a0 = bVar.a0();
                if (a0 == null) {
                    return this.a;
                }
                return (this.a * a0.f2495d) / 100.0f;
            }
            return g(bVar);
        }

        public boolean j() {
            return this.a < 0.0f;
        }

        public boolean k() {
            return this.a == 0.0f;
        }

        public String toString() {
            return String.valueOf(String.valueOf(this.a)) + this.b;
        }

        public n(float f2) {
            this.a = 0.0f;
            Unit unit = Unit.px;
            this.b = unit;
            this.a = f2;
            this.b = unit;
        }
    }
}
