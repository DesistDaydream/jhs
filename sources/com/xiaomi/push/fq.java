package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class fq implements fu {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f8596c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f8597d;

    /* renamed from: e  reason: collision with root package name */
    private String f8598e;

    /* renamed from: f  reason: collision with root package name */
    private List<fq> f8599f;

    public fq(String str, String str2, String[] strArr, String[] strArr2) {
        this.f8596c = null;
        this.f8597d = null;
        this.f8599f = null;
        this.a = str;
        this.b = str2;
        this.f8596c = strArr;
        this.f8597d = strArr2;
    }

    public fq(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fq> list) {
        this.f8596c = null;
        this.f8597d = null;
        this.f8599f = null;
        this.a = str;
        this.b = str2;
        this.f8596c = strArr;
        this.f8597d = strArr2;
        this.f8598e = str3;
        this.f8599f = list;
    }

    public static fq a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i2 = 0;
        for (String str : keySet) {
            strArr[i2] = str;
            strArr2[i2] = bundle2.getString(str);
            i2++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fq(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<fq> list) {
        return a((fq[]) list.toArray(new fq[list.size()]));
    }

    public static Parcelable[] a(fq[] fqVarArr) {
        if (fqVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fqVarArr.length];
        for (int i2 = 0; i2 < fqVarArr.length; i2++) {
            parcelableArr[i2] = fqVarArr[i2].f();
        }
        return parcelableArr;
    }

    public String a() {
        return this.a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f8596c == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.f8596c;
            if (i2 >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i2])) {
                return this.f8597d[i2];
            }
            i2++;
        }
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = ge.a(str);
        }
        this.f8598e = str;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f8598e) ? ge.b(this.f8598e) : this.f8598e;
    }

    @Override // com.xiaomi.push.fu
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(ExpandableTextView.N);
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f8596c;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < this.f8596c.length; i2++) {
                if (!TextUtils.isEmpty(this.f8597d[i2])) {
                    sb.append(ExpandableTextView.N);
                    sb.append(this.f8596c[i2]);
                    sb.append("=\"");
                    sb.append(ge.a(this.f8597d[i2]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f8598e)) {
            List<fq> list = this.f8599f;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            for (fq fqVar : this.f8599f) {
                sb.append(fqVar.d());
            }
        } else {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(this.f8598e);
        }
        sb.append("</");
        sb.append(this.a);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.f8598e);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f8596c;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.f8596c;
                if (i2 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i2], this.f8597d[i2]);
                i2++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fq> list = this.f8599f;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f8599f));
        }
        return bundle;
    }

    public Parcelable f() {
        return e();
    }

    public String toString() {
        return d();
    }
}
