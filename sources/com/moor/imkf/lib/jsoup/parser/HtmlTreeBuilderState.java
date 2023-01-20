package com.moor.imkf.lib.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Attribute;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.DocumentType;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.FormElement;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.parser.Token;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import com.vector.util.IntentAction;
import e.t.u.b0;
import h.t2.y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public enum HtmlTreeBuilderState {
    Initial { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.1
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype asDoctype = token.asDoctype();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(asDoctype.getName()), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier());
                documentType.setPubSysKey(asDoctype.getPubSysKey());
                htmlTreeBuilder.getDocument().appendChild(documentType);
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
            } else {
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.2
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag(a.f1401f);
            htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.process(token);
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (!token.isComment()) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    htmlTreeBuilder.insert(token.asCharacter());
                    return true;
                } else if (token.isStartTag() && token.asStartTag().normalName().equals(a.f1401f)) {
                    htmlTreeBuilder.insert(token.asStartTag());
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
        }
    },
    BeforeHead { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.3
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals(a.f1401f)) {
                return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
            } else {
                if (token.isStartTag() && token.asStartTag().normalName().equals("head")) {
                    htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                } else if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InHead { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.4
        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i2 = AnonymousClass24.$SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i2 == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i2 == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals(a.f1401f)) {
                    return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(normalName, Constants.InHeadEmpty)) {
                    Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                    if (normalName.equals("base") && insertEmpty.hasAttr("href")) {
                        htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                    }
                } else if (normalName.equals(TTDownloadField.TT_META)) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (normalName.equals("title")) {
                    HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                } else if (StringUtil.inSorted(normalName, Constants.InHeadRaw)) {
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                } else if (normalName.equals("noscript")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InHeadNoscript);
                } else if (normalName.equals("script")) {
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                    htmlTreeBuilder.insert(asStartTag);
                } else if (normalName.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (i2 != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("head")) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterHead);
                } else if (StringUtil.inSorted(normalName2, Constants.InHeadEnd)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }
    },
    InHeadNoscript { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.5
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals(a.f1401f)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().normalName().equals("noscript")) {
                    if (!HtmlTreeBuilderState.isWhitespace(token) && !token.isComment() && (!token.isStartTag() || !StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoScriptHead))) {
                        if (token.isEndTag() && token.asEndTag().normalName().equals(BrightRemindSetting.BRIGHT_REMIND)) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) || token.isEndTag()) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                return true;
            }
        }
    },
    AfterHead { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.6
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals(a.f1401f)) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                }
                if (normalName.equals("body")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                    return true;
                } else if (normalName.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InFrameset);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                    htmlTreeBuilder.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder.push(headElement);
                    htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                    htmlTreeBuilder.removeFromStack(headElement);
                    return true;
                } else if (normalName.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
            } else if (token.isEndTag()) {
                if (StringUtil.inSorted(token.asEndTag().normalName(), Constants.AfterHeadBody)) {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
                htmlTreeBuilder.error(this);
                return false;
            } else {
                anythingElse(token, htmlTreeBuilder);
                return true;
            }
        }
    },
    InBody { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.7
        private boolean inBodyEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.EndTag asEndTag = token.asEndTag();
            String normalName = asEndTag.normalName();
            normalName.hashCode();
            char c2 = 65535;
            switch (normalName.hashCode()) {
                case 112:
                    if (normalName.equals(am.ax)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3152:
                    if (normalName.equals(BrightRemindSetting.BRIGHT_REMIND)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3200:
                    if (normalName.equals(b0.a.f14655f)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3273:
                    if (normalName.equals("h1")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3274:
                    if (normalName.equals("h2")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3275:
                    if (normalName.equals("h3")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3276:
                    if (normalName.equals("h4")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3277:
                    if (normalName.equals("h5")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 3278:
                    if (normalName.equals("h6")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3453:
                    if (normalName.equals(AppIconSetting.LARGE_ICON_URL)) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 3029410:
                    if (normalName.equals("body")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 3213227:
                    if (normalName.equals(a.f1401f)) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 3536714:
                    if (normalName.equals("span")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1869063452:
                    if (normalName.equals("sarcasm")) {
                        c2 = 15;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (!htmlTreeBuilder.inButtonScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(normalName);
                        return htmlTreeBuilder.process(asEndTag);
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    break;
                case 1:
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag(BrightRemindSetting.BRIGHT_REMIND);
                    return false;
                case 2:
                case 3:
                    if (!htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                    String[] strArr = Constants.Headings;
                    if (!htmlTreeBuilder.inScope(strArr)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strArr);
                    break;
                case '\n':
                    if (!htmlTreeBuilder.inListItemScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    break;
                case 11:
                    if (!htmlTreeBuilder.inScope("body")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterBody);
                    break;
                case '\f':
                    FormElement formElement = htmlTreeBuilder.getFormElement();
                    htmlTreeBuilder.setFormElement(null);
                    if (formElement != null && htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case '\r':
                    if (htmlTreeBuilder.processEndTag("body")) {
                        return htmlTreeBuilder.process(asEndTag);
                    }
                    break;
                case 14:
                case 15:
                    return anyOtherEndTag(token, htmlTreeBuilder);
                default:
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndAdoptionFormatters)) {
                        return inBodyEndTagAdoption(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndClosers)) {
                        if (!htmlTreeBuilder.inScope(normalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(normalName);
                        break;
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                        if (!htmlTreeBuilder.inScope("name")) {
                            if (!htmlTreeBuilder.inScope(normalName)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                                htmlTreeBuilder.error(this);
                            }
                            htmlTreeBuilder.popStackToClose(normalName);
                            htmlTreeBuilder.clearFormattingElementsToLastMarker();
                            break;
                        }
                    } else {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    break;
            }
            return true;
        }

        private boolean inBodyEndTagAdoption(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String normalName = token.asEndTag().normalName();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            for (int i2 = 0; i2 < 8; i2++) {
                Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(normalName);
                if (activeFormattingElement == null) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                } else if (!htmlTreeBuilder.inScope(activeFormattingElement.normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                        htmlTreeBuilder.error(this);
                    }
                    int size = stack.size();
                    Element element = null;
                    Element element2 = null;
                    int i3 = 0;
                    boolean z = false;
                    while (true) {
                        if (i3 >= size || i3 >= 64) {
                            break;
                        }
                        Element element3 = stack.get(i3);
                        if (element3 == activeFormattingElement) {
                            element2 = stack.get(i3 - 1);
                            z = true;
                        } else if (z && htmlTreeBuilder.isSpecial(element3)) {
                            element = element3;
                            break;
                        }
                        i3++;
                    }
                    if (element == null) {
                        htmlTreeBuilder.popStackToClose(activeFormattingElement.normalName());
                        htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                        return true;
                    }
                    Element element4 = element;
                    Node node = element4;
                    for (int i4 = 0; i4 < 3; i4++) {
                        if (htmlTreeBuilder.onStack(element4)) {
                            element4 = htmlTreeBuilder.aboveOnStack(element4);
                        }
                        if (!htmlTreeBuilder.isInActiveFormattingElements(element4)) {
                            htmlTreeBuilder.removeFromStack(element4);
                        } else if (element4 == activeFormattingElement) {
                            break;
                        } else {
                            Element element5 = new Element(Tag.valueOf(element4.nodeName(), ParseSettings.preserveCase), htmlTreeBuilder.getBaseUri());
                            htmlTreeBuilder.replaceActiveFormattingElement(element4, element5);
                            htmlTreeBuilder.replaceOnStack(element4, element5);
                            if (node.parent() != null) {
                                node.remove();
                            }
                            element5.appendChild(node);
                            element4 = element5;
                            node = element4;
                        }
                    }
                    if (StringUtil.inSorted(element2.normalName(), Constants.InBodyEndTableFosters)) {
                        if (node.parent() != null) {
                            node.remove();
                        }
                        htmlTreeBuilder.insertInFosterParent(node);
                    } else {
                        if (node.parent() != null) {
                            node.remove();
                        }
                        element2.appendChild(node);
                    }
                    Element element6 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                    element6.attributes().addAll(activeFormattingElement.attributes());
                    for (Node node2 : (Node[]) element.childNodes().toArray(new Node[0])) {
                        element6.appendChild(node2);
                    }
                    element.appendChild(element6);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    htmlTreeBuilder.removeFromStack(activeFormattingElement);
                    htmlTreeBuilder.insertOnStackAfter(element, element6);
                }
            }
            return true;
        }

        private boolean inBodyStartTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.StartTag asStartTag = token.asStartTag();
            String normalName = asStartTag.normalName();
            normalName.hashCode();
            char c2 = 65535;
            switch (normalName.hashCode()) {
                case -1644953643:
                    if (normalName.equals("frameset")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1377687758:
                    if (normalName.equals("button")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1191214428:
                    if (normalName.equals(FromToMessage.MSG_TYPE_IFRAME)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1010136971:
                    if (normalName.equals("option")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1003243718:
                    if (normalName.equals("textarea")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -906021636:
                    if (normalName.equals("select")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -80773204:
                    if (normalName.equals("optgroup")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 97:
                    if (normalName.equals(am.av)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3200:
                    if (normalName.equals(b0.a.f14655f)) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3273:
                    if (normalName.equals("h1")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 3274:
                    if (normalName.equals("h2")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 3275:
                    if (normalName.equals("h3")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 3276:
                    if (normalName.equals("h4")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 3277:
                    if (normalName.equals("h5")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 3278:
                    if (normalName.equals("h6")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 3338:
                    if (normalName.equals("hr")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 3453:
                    if (normalName.equals(AppIconSetting.LARGE_ICON_URL)) {
                        c2 = 17;
                        break;
                    }
                    break;
                case 3646:
                    if (normalName.equals("rp")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case 3650:
                    if (normalName.equals("rt")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case 111267:
                    if (normalName.equals("pre")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case 114276:
                    if (normalName.equals("svg")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 118811:
                    if (normalName.equals("xmp")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 3029410:
                    if (normalName.equals("body")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case 3213227:
                    if (normalName.equals(a.f1401f)) {
                        c2 = 25;
                        break;
                    }
                    break;
                case 3344136:
                    if (normalName.equals("math")) {
                        c2 = 26;
                        break;
                    }
                    break;
                case 3386833:
                    if (normalName.equals("nobr")) {
                        c2 = 27;
                        break;
                    }
                    break;
                case 3536714:
                    if (normalName.equals("span")) {
                        c2 = 28;
                        break;
                    }
                    break;
                case 100313435:
                    if (normalName.equals(FromToMessage.MSG_TYPE_IMAGE)) {
                        c2 = 29;
                        break;
                    }
                    break;
                case 100358090:
                    if (normalName.equals("input")) {
                        c2 = 30;
                        break;
                    }
                    break;
                case 110115790:
                    if (normalName.equals("table")) {
                        c2 = 31;
                        break;
                    }
                    break;
                case 181975684:
                    if (normalName.equals("listing")) {
                        c2 = ' ';
                        break;
                    }
                    break;
                case 1973234167:
                    if (normalName.equals("plaintext")) {
                        c2 = '!';
                        break;
                    }
                    break;
                case 2091304424:
                    if (normalName.equals("isindex")) {
                        c2 = y.a;
                        break;
                    }
                    break;
                case 2115613112:
                    if (normalName.equals("noembed")) {
                        c2 = '#';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    if (stack.size() == 1 || ((stack.size() > 2 && !stack.get(1).normalName().equals("body")) || !htmlTreeBuilder.framesetOk())) {
                        return false;
                    }
                    Element element = stack.get(1);
                    if (element.parent() != null) {
                        element.remove();
                    }
                    while (stack.size() > 1) {
                        stack.remove(stack.size() - 1);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InFrameset);
                    return true;
                case 1:
                    if (htmlTreeBuilder.inButtonScope("button")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("button");
                        htmlTreeBuilder.process(asStartTag);
                        return true;
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 2:
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    break;
                case 3:
                case 6:
                    if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 4:
                    htmlTreeBuilder.insert(asStartTag);
                    if (!asStartTag.isSelfClosing()) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                        break;
                    }
                    break;
                case 5:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState state = htmlTreeBuilder.state();
                    if (!state.equals(HtmlTreeBuilderState.InTable) && !state.equals(HtmlTreeBuilderState.InCaption) && !state.equals(HtmlTreeBuilderState.InTableBody) && !state.equals(HtmlTreeBuilderState.InRow) && !state.equals(HtmlTreeBuilderState.InCell)) {
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InSelect);
                        break;
                    } else {
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InSelectInTable);
                        break;
                    }
                case 7:
                    if (htmlTreeBuilder.getActiveFormattingElement(am.av) != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag(am.av);
                        Element fromStack = htmlTreeBuilder.getFromStack(am.av);
                        if (fromStack != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    break;
                case '\b':
                case '\t':
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                    int size = stack2.size() - 1;
                    while (true) {
                        if (size > 0) {
                            Element element2 = stack2.get(size);
                            if (StringUtil.inSorted(element2.normalName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element2.normalName());
                            } else if (!htmlTreeBuilder.isSpecial(element2) || StringUtil.inSorted(element2.normalName(), Constants.InBodyStartLiBreakers)) {
                                size--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.pop();
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 16:
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insertEmpty(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    break;
                case 17:
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                    int size2 = stack3.size() - 1;
                    while (true) {
                        if (size2 > 0) {
                            Element element3 = stack3.get(size2);
                            if (element3.normalName().equals(AppIconSetting.LARGE_ICON_URL)) {
                                htmlTreeBuilder.processEndTag(AppIconSetting.LARGE_ICON_URL);
                            } else if (!htmlTreeBuilder.isSpecial(element3) || StringUtil.inSorted(element3.normalName(), Constants.InBodyStartLiBreakers)) {
                                size2--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 18:
                case 19:
                    if (htmlTreeBuilder.inScope("ruby")) {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().normalName().equals("ruby")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.popStackToBefore("ruby");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    }
                    break;
                case 20:
                case ' ':
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.reader.matchConsume("\n");
                    htmlTreeBuilder.framesetOk(false);
                    break;
                case 21:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 22:
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    break;
                case 23:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                    if (stack4.size() != 1 && (stack4.size() <= 2 || stack4.get(1).normalName().equals("body"))) {
                        htmlTreeBuilder.framesetOk(false);
                        Element element4 = stack4.get(1);
                        Iterator<Attribute> it = asStartTag.getAttributes().iterator();
                        while (it.hasNext()) {
                            Attribute next = it.next();
                            if (!element4.hasAttr(next.getKey())) {
                                element4.attributes().put(next);
                            }
                        }
                        break;
                    } else {
                        return false;
                    }
                case 24:
                    if (htmlTreeBuilder.getFormElement() != null) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insertForm(asStartTag, true);
                    break;
                case 25:
                    htmlTreeBuilder.error(this);
                    Element element5 = htmlTreeBuilder.getStack().get(0);
                    Iterator<Attribute> it2 = asStartTag.getAttributes().iterator();
                    while (it2.hasNext()) {
                        Attribute next2 = it2.next();
                        if (!element5.hasAttr(next2.getKey())) {
                            element5.attributes().put(next2);
                        }
                    }
                    break;
                case 26:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 27:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.inScope("nobr")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("nobr");
                        htmlTreeBuilder.reconstructFormattingElements();
                    }
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    break;
                case 28:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 29:
                    if (htmlTreeBuilder.getFromStack("svg") == null) {
                        return htmlTreeBuilder.process(asStartTag.name(IntentAction.o.f7891j));
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 30:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (!htmlTreeBuilder.insertEmpty(asStartTag).attr("type").equalsIgnoreCase("hidden")) {
                        htmlTreeBuilder.framesetOk(false);
                        break;
                    }
                    break;
                case 31:
                    if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                    break;
                case '!':
                    if (htmlTreeBuilder.inButtonScope(am.ax)) {
                        htmlTreeBuilder.processEndTag(am.ax);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    break;
                case '\"':
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.getFormElement() == null) {
                        htmlTreeBuilder.processStartTag("form");
                        if (asStartTag.attributes.hasKey("action")) {
                            htmlTreeBuilder.getFormElement().attr("action", asStartTag.attributes.get("action"));
                        }
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processStartTag(TTDownloadField.TT_LABEL);
                        htmlTreeBuilder.process(new Token.Character().data(asStartTag.attributes.hasKey("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                        Attributes attributes = new Attributes();
                        Iterator<Attribute> it3 = asStartTag.attributes.iterator();
                        while (it3.hasNext()) {
                            Attribute next3 = it3.next();
                            if (!StringUtil.inSorted(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                                attributes.put(next3);
                            }
                        }
                        attributes.put("name", "isindex");
                        htmlTreeBuilder.processStartTag("input", attributes);
                        htmlTreeBuilder.processEndTag(TTDownloadField.TT_LABEL);
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processEndTag("form");
                        break;
                    } else {
                        return false;
                    }
                case '#':
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    break;
                default:
                    if (StringUtil.inSorted(normalName, Constants.InBodyStartEmptyFormatters)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartPClosers)) {
                        if (htmlTreeBuilder.inButtonScope(am.ax)) {
                            htmlTreeBuilder.processEndTag(am.ax);
                        }
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                        return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                    } else {
                        if (StringUtil.inSorted(normalName, Constants.Formatters)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.insertMarkerToFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartMedia)) {
                            htmlTreeBuilder.insertEmpty(asStartTag);
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartDrop)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        }
                    }
                    break;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean anyOtherEndTag(com.moor.imkf.lib.jsoup.parser.Token r6, com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilder r7) {
            /*
                r5 = this;
                com.moor.imkf.lib.jsoup.parser.Token$EndTag r6 = r6.asEndTag()
                java.lang.String r6 = r6.normalName
                java.util.ArrayList r0 = r7.getStack()
                int r1 = r0.size()
                r2 = 1
                int r1 = r1 - r2
            L10:
                if (r1 < 0) goto L48
                java.lang.Object r3 = r0.get(r1)
                com.moor.imkf.lib.jsoup.nodes.Element r3 = (com.moor.imkf.lib.jsoup.nodes.Element) r3
                java.lang.String r4 = r3.normalName()
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L3a
                r7.generateImpliedEndTags(r6)
                com.moor.imkf.lib.jsoup.nodes.Element r0 = r7.currentElement()
                java.lang.String r0 = r0.normalName()
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L36
                r7.error(r5)
            L36:
                r7.popStackToClose(r6)
                goto L48
            L3a:
                boolean r3 = r7.isSpecial(r3)
                if (r3 == 0) goto L45
                r7.error(r5)
                r6 = 0
                return r6
            L45:
                int r1 = r1 + (-1)
                goto L10
            L48:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.anyOtherEndTag(com.moor.imkf.lib.jsoup.parser.Token, com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i2 = AnonymousClass24.$SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i2 == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i2 == 3) {
                return inBodyStartTag(token, htmlTreeBuilder);
            } else {
                if (i2 == 4) {
                    return inBodyEndTag(token, htmlTreeBuilder);
                }
                if (i2 == 5) {
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (htmlTreeBuilder.framesetOk() && HtmlTreeBuilderState.isWhitespace(asCharacter)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                        htmlTreeBuilder.framesetOk(false);
                    }
                }
            }
            return true;
        }
    },
    Text { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.8
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (token.isEndTag()) {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return true;
            } else {
                return true;
            }
        }
    },
    InTable { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.9
        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                htmlTreeBuilder.setFosterInserts(true);
                boolean process = htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                htmlTreeBuilder.setFosterInserts(false);
                return process;
            }
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder.process(token);
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InCaption);
                } else if (normalName.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InColumnGroup);
                } else if (normalName.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                } else if (StringUtil.inSorted(normalName, Constants.InTableToBody)) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                } else if (StringUtil.inSorted(normalName, Constants.InTableAddBody)) {
                    htmlTreeBuilder.processStartTag("tbody");
                    return htmlTreeBuilder.process(token);
                } else if (normalName.equals("table")) {
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.processEndTag("table")) {
                        return htmlTreeBuilder.process(token);
                    }
                } else if (StringUtil.inSorted(normalName, Constants.InTableToHead)) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                } else {
                    if (normalName.equals("input")) {
                        if (!asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else if (normalName.equals("form")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder.insertForm(asStartTag, false);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
                return true;
            } else if (token.isEndTag()) {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("table")) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                } else if (StringUtil.inSorted(normalName2, Constants.InTableEndErr)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (token.isEOF()) {
                if (htmlTreeBuilder.currentElement().normalName().equals(a.f1401f)) {
                    htmlTreeBuilder.error(this);
                }
                return true;
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }
    },
    InTableText { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.10
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.type == Token.TokenType.Character) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (!HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                        }
                    } else {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.11
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().normalName().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().normalName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                return true;
            } else if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) || (token.isEndTag() && token.asEndTag().normalName().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag("caption")) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
        }
    },
    InColumnGroup { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.12
        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i2 = AnonymousClass24.$SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i2 == 2) {
                htmlTreeBuilder.error(this);
            } else if (i2 == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                normalName.hashCode();
                if (!normalName.equals("col")) {
                    if (!normalName.equals(a.f1401f)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                }
                htmlTreeBuilder.insertEmpty(asStartTag);
            } else if (i2 != 4) {
                if (i2 != 6) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.currentElement().normalName().equals(a.f1401f)) {
                    return true;
                }
                return anythingElse(token, htmlTreeBuilder);
            } else if (token.asEndTag().normalName.equals("colgroup")) {
                if (htmlTreeBuilder.currentElement().normalName().equals(a.f1401f)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InTableBody { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.13
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
            return htmlTreeBuilder.process(token);
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i2 = AnonymousClass24.$SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i2 != 3) {
                if (i2 != 4) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                String normalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName, Constants.InTableEndIgnore)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                    return true;
                } else if (normalName.equals("table")) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.inSorted(normalName, Constants.InTableBodyEndIgnore)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            }
            Token.StartTag asStartTag = token.asStartTag();
            String normalName2 = asStartTag.normalName();
            if (normalName2.equals("template")) {
                htmlTreeBuilder.insert(asStartTag);
                return true;
            } else if (normalName2.equals("tr")) {
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.insert(asStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                return true;
            } else if (StringUtil.inSorted(normalName2, Constants.InCellNames)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processStartTag("tr");
                return htmlTreeBuilder.process(asStartTag);
            } else if (StringUtil.inSorted(normalName2, Constants.InTableBodyExit)) {
                return exitTableBody(token, htmlTreeBuilder);
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }
    },
    InRow { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.14
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("template")) {
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InRowMissing)) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (token.isEndTag()) {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                    return true;
                } else if (normalName2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.inSorted(normalName2, Constants.InTableToBody)) {
                        if (!htmlTreeBuilder.inTableScope(normalName2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.processEndTag("tr");
                        return htmlTreeBuilder.process(token);
                    } else if (StringUtil.inSorted(normalName2, Constants.InRowIgnore)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }
    },
    InCell { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.15
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope(TimeDisplaySetting.TIME_DISPLAY)) {
                htmlTreeBuilder.processEndTag(TimeDisplaySetting.TIME_DISPLAY);
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String normalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (StringUtil.inSorted(normalName, Constants.InCellTable)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) {
                if (!htmlTreeBuilder.inTableScope(TimeDisplaySetting.TIME_DISPLAY) && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                closeCell(htmlTreeBuilder);
                return htmlTreeBuilder.process(token);
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }
    },
    InSelect { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.16
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }

        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    break;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String normalName = asStartTag.normalName();
                    if (normalName.equals(a.f1401f)) {
                        return htmlTreeBuilder.process(asStartTag, HtmlTreeBuilderState.InBody);
                    }
                    if (normalName.equals("option")) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (normalName.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (normalName.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag("select");
                    } else if (StringUtil.inSorted(normalName, Constants.InSelectEnd)) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.inSelectScope("select")) {
                            htmlTreeBuilder.processEndTag("select");
                            return htmlTreeBuilder.process(asStartTag);
                        }
                        return false;
                    } else if (normalName.equals("script")) {
                        return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                case 4:
                    String normalName2 = token.asEndTag().normalName();
                    normalName2.hashCode();
                    char c2 = 65535;
                    switch (normalName2.hashCode()) {
                        case -1010136971:
                            if (normalName2.equals("option")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -906021636:
                            if (normalName2.equals("select")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -80773204:
                            if (normalName2.equals("optgroup")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                                htmlTreeBuilder.pop();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                break;
                            }
                        case 1:
                            if (!htmlTreeBuilder.inSelectScope(normalName2)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.popStackToClose(normalName2);
                            htmlTreeBuilder.resetInsertionMode();
                            break;
                        case 2:
                            if (htmlTreeBuilder.currentElement().normalName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).normalName().equals("optgroup")) {
                                htmlTreeBuilder.processEndTag("option");
                            }
                            if (htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                                htmlTreeBuilder.pop();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                break;
                            }
                        default:
                            return anythingElse(token, htmlTreeBuilder);
                    }
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(asCharacter);
                    break;
                case 6:
                    if (!htmlTreeBuilder.currentElement().normalName().equals(a.f1401f)) {
                        htmlTreeBuilder.error(this);
                        break;
                    }
                    break;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InSelectInTable { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.17
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InSelecTableEnd)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InSelecTableEnd)) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.processEndTag("select");
                    return htmlTreeBuilder.process(token);
                }
                return false;
            } else {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InSelect);
            }
        }
    },
    AfterBody { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.18
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals(a.f1401f)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals(a.f1401f)) {
                    if (htmlTreeBuilder.isFragmentParsing()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterBody);
                    return true;
                } else if (token.isEOF()) {
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InFrameset { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.19
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                normalName.hashCode();
                char c2 = 65535;
                switch (normalName.hashCode()) {
                    case -1644953643:
                        if (normalName.equals("frameset")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3213227:
                        if (normalName.equals(a.f1401f)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 97692013:
                        if (normalName.equals(TypedValues.Attributes.S_FRAME)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (normalName.equals("noframes")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    case 1:
                        return htmlTreeBuilder.process(asStartTag, HtmlTreeBuilderState.InBody);
                    case 2:
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        break;
                    case 3:
                        return htmlTreeBuilder.process(asStartTag, HtmlTreeBuilderState.InHead);
                    default:
                        htmlTreeBuilder.error(this);
                        return false;
                }
            } else if (token.isEndTag() && token.asEndTag().normalName().equals("frameset")) {
                if (htmlTreeBuilder.currentElement().normalName().equals(a.f1401f)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().normalName().equals("frameset")) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterFrameset);
                }
            } else if (token.isEOF()) {
                if (!htmlTreeBuilder.currentElement().normalName().equals(a.f1401f)) {
                    htmlTreeBuilder.error(this);
                }
            } else {
                htmlTreeBuilder.error(this);
                return false;
            }
            return true;
        }
    },
    AfterFrameset { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.20
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals(a.f1401f)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals(a.f1401f)) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterFrameset);
                    return true;
                } else if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                } else {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.21
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (!token.isDoctype() && (!token.isStartTag() || !token.asStartTag().normalName().equals(a.f1401f))) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    Element popStackToClose = htmlTreeBuilder.popStackToClose(a.f1401f);
                    htmlTreeBuilder.insert(token.asCharacter());
                    htmlTreeBuilder.stack.add(popStackToClose);
                    htmlTreeBuilder.stack.add(popStackToClose.selectFirst("body"));
                    return true;
                } else if (token.isEOF()) {
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                    return htmlTreeBuilder.process(token);
                }
            } else {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
        }
    },
    AfterAfterFrameset { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.22
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (!token.isDoctype() && !HtmlTreeBuilderState.isWhitespace(token) && (!token.isStartTag() || !token.asStartTag().normalName().equals(a.f1401f))) {
                if (token.isEOF()) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                }
                htmlTreeBuilder.error(this);
                return false;
            } else {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
        }
    },
    ForeignContent { // from class: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState.23
        @Override // com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    private static final String nullString = String.valueOf((char) 0);

    /* renamed from: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass24 {
        public static final /* synthetic */ int[] $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Constants {
        public static final String[] InHeadEmpty = {"base", "basefont", "bgsound", b.y, "link"};
        public static final String[] InHeadRaw = {"noframes", "style"};
        public static final String[] InHeadEnd = {"body", BrightRemindSetting.BRIGHT_REMIND, a.f1401f};
        public static final String[] AfterHeadBody = {"body", a.f1401f};
        public static final String[] BeforeHtmlToHead = {"body", BrightRemindSetting.BRIGHT_REMIND, "head", a.f1401f};
        public static final String[] InHeadNoScriptHead = {"basefont", "bgsound", "link", TTDownloadField.TT_META, "noframes", "style"};
        public static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", b.y, "link", TTDownloadField.TT_META, "noframes", "script", "style", "title"};
        public static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", am.ax, "section", "summary", "ul"};
        public static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        public static final String[] InBodyStartLiBreakers = {"address", "div", am.ax};
        public static final String[] DdDt = {b0.a.f14655f, "dt"};
        public static final String[] Formatters = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, am.aH};
        public static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        public static final String[] InBodyStartEmptyFormatters = {"area", BrightRemindSetting.BRIGHT_REMIND, "embed", IntentAction.o.f7891j, "keygen", "wbr"};
        public static final String[] InBodyStartMedia = {RemoteMessageConst.MessageBody.PARAM, MessageKey.MSG_SOURCE, "track"};
        public static final String[] InBodyStartInputAttribs = {"action", "name", "prompt"};
        public static final String[] InBodyStartDrop = {"caption", "col", "colgroup", TypedValues.Attributes.S_FRAME, "head", "tbody", TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr"};
        public static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        public static final String[] InBodyEndAdoptionFormatters = {am.av, "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, am.aH};
        public static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InTableToBody = {"tbody", "tfoot", "thead"};
        public static final String[] InTableAddBody = {TimeDisplaySetting.TIME_DISPLAY, "th", "tr"};
        public static final String[] InTableToHead = {"script", "style"};
        public static final String[] InCellNames = {TimeDisplaySetting.TIME_DISPLAY, "th"};
        public static final String[] InCellBody = {"body", "caption", "col", "colgroup", a.f1401f};
        public static final String[] InCellTable = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InCellCol = {"caption", "col", "colgroup", "tbody", TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr"};
        public static final String[] InTableEndErr = {"body", "caption", "col", "colgroup", a.f1401f, "tbody", TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr"};
        public static final String[] InTableFoster = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InTableBodyExit = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        public static final String[] InTableBodyEndIgnore = {"body", "caption", "col", "colgroup", a.f1401f, TimeDisplaySetting.TIME_DISPLAY, "th", "tr"};
        public static final String[] InRowMissing = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        public static final String[] InRowIgnore = {"body", "caption", "col", "colgroup", a.f1401f, TimeDisplaySetting.TIME_DISPLAY, "th"};
        public static final String[] InSelectEnd = {"input", "keygen", "textarea"};
        public static final String[] InSelecTableEnd = {"caption", "table", "tbody", TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr"};
        public static final String[] InTableEndIgnore = {"tbody", "tfoot", "thead"};
        public static final String[] InHeadNoscriptIgnore = {"head", "noscript"};
        public static final String[] InCaptionIgnore = {"body", "col", "colgroup", a.f1401f, "tbody", TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return StringUtil.isBlank(token.asCharacter().getData());
        }
        return false;
    }

    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return StringUtil.isBlank(str);
    }
}
