package com.moor.imkf.lib.jsoup.select;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.nodes.Comment;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.DocumentType;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.nodes.PseudoTextElement;
import com.moor.imkf.lib.jsoup.nodes.XmlDeclaration;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class Evaluator {

    /* loaded from: classes2.dex */
    public static final class AllElements extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* loaded from: classes2.dex */
    public static final class Attribute extends Evaluator {
        private String key;

        public Attribute(String str) {
            this.key = str;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key);
        }

        public String toString() {
            return String.format("[%s]", this.key);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class AttributeKeyPair extends Evaluator {
        public String key;
        public String value;

        public AttributeKeyPair(String str, String str2) {
            this(str, str2, true);
        }

        public AttributeKeyPair(String str, String str2, boolean z) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            this.key = Normalizer.normalize(str);
            boolean z2 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
            str2 = z2 ? str2.substring(1, str2.length() - 1) : str2;
            this.value = z ? Normalizer.normalize(str2) : Normalizer.normalize(str2, z2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeStarting extends Evaluator {
        private String keyPrefix;

        public AttributeStarting(String str) {
            Validate.notEmpty(str);
            this.keyPrefix = Normalizer.lowerCase(str);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (com.moor.imkf.lib.jsoup.nodes.Attribute attribute : element2.attributes().asList()) {
                if (Normalizer.lowerCase(attribute.getKey()).startsWith(this.keyPrefix)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.keyPrefix);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.value.equalsIgnoreCase(element2.attr(this.key).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).contains(this.value);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2, false);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).endsWith(this.value);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeWithValueMatching extends Evaluator {
        public String key;
        public Pattern pattern;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.key = Normalizer.normalize(str);
            this.pattern = pattern;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.pattern.matcher(element2.attr(this.key)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.key, this.pattern.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return !this.value.equalsIgnoreCase(element2.attr(this.key));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2, false);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).startsWith(this.value);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.key, this.value);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Class extends Evaluator {
        private String className;

        public Class(String str) {
            this.className = str;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasClass(this.className);
        }

        public String toString() {
            return String.format(".%s", this.className);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ContainsData extends Evaluator {
        private String searchText;

        public ContainsData(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.data()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.searchText);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ContainsOwnText extends Evaluator {
        private String searchText;

        public ContainsOwnText(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.ownText()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.searchText);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ContainsText extends Evaluator {
        private String searchText;

        public ContainsText(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.text()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":contains(%s)", this.searchText);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Id extends Evaluator {
        private String id;

        public Id(String str) {
            this.id = str;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.id.equals(element2.id());
        }

        public String toString() {
            return String.format("#%s", this.id);
        }
    }

    /* loaded from: classes2.dex */
    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i2) {
            super(i2);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() == this.index;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class IndexEvaluator extends Evaluator {
        public int index;

        public IndexEvaluator(int i2) {
            this.index = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i2) {
            super(i2);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() > this.index;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes2.dex */
    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i2) {
            super(i2);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element != element2 && element2.elementSiblingIndex() < this.index;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.index));
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsEmpty extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (Node node : element2.childNodes()) {
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && !(node instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsFirstChild extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2.elementSiblingIndex() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":first-of-type";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsLastChild extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || element2.elementSiblingIndex() != parent.children().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":last-of-type";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            return element2.elementSiblingIndex() + 1;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-child";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            return element2.parent().children().size() - element2.elementSiblingIndex();
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-last-child";
        }
    }

    /* loaded from: classes2.dex */
    public static class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            Elements children = element2.parent().children();
            int i2 = 0;
            for (int elementSiblingIndex = element2.elementSiblingIndex(); elementSiblingIndex < children.size(); elementSiblingIndex++) {
                if (children.get(elementSiblingIndex).tag().equals(element2.tag())) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-last-of-type";
        }
    }

    /* loaded from: classes2.dex */
    public static class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public int calculatePosition(Element element, Element element2) {
            Iterator<Element> it = element2.parent().children().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.tag().equals(element2.tag())) {
                    i2++;
                    continue;
                }
                if (next == element2) {
                    break;
                }
            }
            return i2;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator.CssNthEvaluator
        public String getPseudoClass() {
            return "nth-of-type";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsOnlyChild extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            return (parent == null || (parent instanceof Document) || !element2.siblingElements().isEmpty()) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsOnlyOfType extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null || (parent instanceof Document)) {
                return false;
            }
            Iterator<Element> it = parent.children().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().tag().equals(element2.tag())) {
                    i2++;
                }
            }
            return i2 == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* loaded from: classes2.dex */
    public static final class IsRoot extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.child(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    /* loaded from: classes2.dex */
    public static final class MatchText extends Evaluator {
        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element2 instanceof PseudoTextElement) {
                return true;
            }
            for (Node node : element2.textNodes()) {
                PseudoTextElement pseudoTextElement = new PseudoTextElement(com.moor.imkf.lib.jsoup.parser.Tag.valueOf(element2.tagName()), element2.baseUri(), element2.attributes());
                node.replaceWith(pseudoTextElement);
                pseudoTextElement.appendChild(node);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    /* loaded from: classes2.dex */
    public static final class Matches extends Evaluator {
        private Pattern pattern;

        public Matches(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.text()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.pattern);
        }
    }

    /* loaded from: classes2.dex */
    public static final class MatchesOwn extends Evaluator {
        private Pattern pattern;

        public MatchesOwn(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.ownText()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.pattern);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Tag extends Evaluator {
        private String tagName;

        public Tag(String str) {
            this.tagName = str;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.normalName().equals(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    /* loaded from: classes2.dex */
    public static final class TagEndsWith extends Evaluator {
        private String tagName;

        public TagEndsWith(String str) {
            this.tagName = str;
        }

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.normalName().endsWith(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    public abstract boolean matches(Element element, Element element2);

    /* loaded from: classes2.dex */
    public static abstract class CssNthEvaluator extends Evaluator {
        public final int a;
        public final int b;

        public CssNthEvaluator(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public abstract int calculatePosition(Element element, Element element2);

        public abstract String getPseudoClass();

        @Override // com.moor.imkf.lib.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent = element2.parent();
            if (parent == null || (parent instanceof Document)) {
                return false;
            }
            int calculatePosition = calculatePosition(element, element2);
            int i2 = this.a;
            if (i2 == 0) {
                return calculatePosition == this.b;
            }
            int i3 = this.b;
            return (calculatePosition - i3) * i2 >= 0 && (calculatePosition - i3) % i2 == 0;
        }

        public String toString() {
            return this.a == 0 ? String.format(":%s(%d)", getPseudoClass(), Integer.valueOf(this.b)) : this.b == 0 ? String.format(":%s(%dn)", getPseudoClass(), Integer.valueOf(this.a)) : String.format(":%s(%dn%+d)", getPseudoClass(), Integer.valueOf(this.a), Integer.valueOf(this.b));
        }

        public CssNthEvaluator(int i2) {
            this(0, i2);
        }
    }
}
