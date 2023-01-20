package com.moor.imkf.lib.jsoup.nodes;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.moor.imkf.lib.jsoup.Connection;
import com.moor.imkf.lib.jsoup.Jsoup;
import com.moor.imkf.lib.jsoup.helper.HttpConnection;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.parser.Tag;
import com.moor.imkf.lib.jsoup.select.Elements;
import i.b.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    public Elements elements() {
        return this.elements;
    }

    public List<Connection.KeyVal> formData() {
        Element first;
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = this.elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.tag().isFormSubmittable() && !next.hasAttr("disabled")) {
                String attr = next.attr("name");
                if (attr.length() != 0) {
                    String attr2 = next.attr("type");
                    if (!attr2.equalsIgnoreCase("button")) {
                        if ("select".equals(next.normalName())) {
                            boolean z = false;
                            Iterator<Element> it2 = next.select("option[selected]").iterator();
                            while (it2.hasNext()) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, it2.next().val()));
                                z = true;
                            }
                            if (!z && (first = next.select("option").first()) != null) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, first.val()));
                            }
                        } else if (!"checkbox".equalsIgnoreCase(attr2) && !"radio".equalsIgnoreCase(attr2)) {
                            arrayList.add(HttpConnection.KeyVal.create(attr, next.val()));
                        } else if (next.hasAttr("checked")) {
                            arrayList.add(HttpConnection.KeyVal.create(attr, next.val().length() > 0 ? next.val() : q0.f15781d));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    public Connection submit() {
        String absUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(absUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.connect(absUrl).data(formData()).method(attr(PushConstants.MZ_PUSH_MESSAGE_METHOD).toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Element, com.moor.imkf.lib.jsoup.nodes.Node
    public FormElement clone() {
        return (FormElement) super.clone();
    }
}
