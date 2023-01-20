package com.moor.imkf.lib.jsoup.select;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class Selector {

    /* loaded from: classes2.dex */
    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector() {
    }

    public static Elements filterOut(Collection<Element> collection, Collection<Element> collection2) {
        Elements elements = new Elements();
        for (Element element : collection) {
            boolean z = false;
            Iterator<Element> it = collection2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (element.equals(it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                elements.add(element);
            }
        }
        return elements;
    }

    public static Elements select(String str, Element element) {
        Validate.notEmpty(str);
        return select(QueryParser.parse(str), element);
    }

    public static Element selectFirst(String str, Element element) {
        Validate.notEmpty(str);
        return Collector.findFirst(QueryParser.parse(str), element);
    }

    public static Elements select(Evaluator evaluator, Element element) {
        Validate.notNull(evaluator);
        Validate.notNull(element);
        return Collector.collect(evaluator, element);
    }

    public static Elements select(String str, Iterable<Element> iterable) {
        Validate.notEmpty(str);
        Validate.notNull(iterable);
        Evaluator parse = QueryParser.parse(str);
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        for (Element element : iterable) {
            Iterator<Element> it = select(parse, element).iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (!identityHashMap.containsKey(next)) {
                    arrayList.add(next);
                    identityHashMap.put(next, Boolean.TRUE);
                }
            }
        }
        return new Elements((List<Element>) arrayList);
    }
}
