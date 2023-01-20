package com.moor.imkf.lib.jsoup.select;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.parser.TokenQueue;
import com.moor.imkf.lib.jsoup.select.CombiningEvaluator;
import com.moor.imkf.lib.jsoup.select.Evaluator;
import com.moor.imkf.lib.jsoup.select.Selector;
import com.moor.imkf.lib.jsoup.select.StructuralEvaluator;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class QueryParser {
    private List<Evaluator> evals = new ArrayList();
    private String query;
    private TokenQueue tq;
    private static final String[] combinators = {Constants.ACCEPT_TIME_SEPARATOR_SP, SimpleComparison.GREATER_THAN_OPERATION, "+", Constants.WAVE_SEPARATOR, ExpandableTextView.N};
    private static final String[] AttributeEvals = {"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern NTH_AB = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    private static final Pattern NTH_B = Pattern.compile("([+-])?(\\d+)");

    private QueryParser(String str) {
        Validate.notEmpty(str);
        String trim = str.trim();
        this.query = trim;
        this.tq = new TokenQueue(trim);
    }

    private void allElements() {
        this.evals.add(new Evaluator.AllElements());
    }

    private void byAttribute() {
        TokenQueue tokenQueue = new TokenQueue(this.tq.chompBalanced('[', ']'));
        String consumeToAny = tokenQueue.consumeToAny(AttributeEvals);
        Validate.notEmpty(consumeToAny);
        tokenQueue.consumeWhitespace();
        if (tokenQueue.isEmpty()) {
            if (consumeToAny.startsWith("^")) {
                this.evals.add(new Evaluator.AttributeStarting(consumeToAny.substring(1)));
            } else {
                this.evals.add(new Evaluator.Attribute(consumeToAny));
            }
        } else if (tokenQueue.matchChomp("=")) {
            this.evals.add(new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("!=")) {
            this.evals.add(new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("^=")) {
            this.evals.add(new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("$=")) {
            this.evals.add(new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("*=")) {
            this.evals.add(new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder()));
        } else if (tokenQueue.matchChomp("~=")) {
            this.evals.add(new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder())));
        } else {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.query, tokenQueue.remainder());
        }
    }

    private void byClass() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Class(consumeCssIdentifier.trim()));
    }

    private void byId() {
        String consumeCssIdentifier = this.tq.consumeCssIdentifier();
        Validate.notEmpty(consumeCssIdentifier);
        this.evals.add(new Evaluator.Id(consumeCssIdentifier));
    }

    private void byTag() {
        String normalize = Normalizer.normalize(this.tq.consumeElementSelector());
        Validate.notEmpty(normalize);
        if (normalize.startsWith("*|")) {
            this.evals.add(new CombiningEvaluator.Or(new Evaluator.Tag(normalize), new Evaluator.TagEndsWith(normalize.replace("*|", Constants.COLON_SEPARATOR))));
            return;
        }
        if (normalize.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
            normalize = normalize.replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, Constants.COLON_SEPARATOR);
        }
        this.evals.add(new Evaluator.Tag(normalize));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void combinator(char r11) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.select.QueryParser.combinator(char):void");
    }

    private int consumeIndex() {
        String trim = this.tq.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private String consumeSubQuery() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!this.tq.isEmpty()) {
            if (this.tq.matches("(")) {
                borrowBuilder.append("(");
                borrowBuilder.append(this.tq.chompBalanced('(', ')'));
                borrowBuilder.append(")");
            } else if (this.tq.matches("[")) {
                borrowBuilder.append("[");
                borrowBuilder.append(this.tq.chompBalanced('[', ']'));
                borrowBuilder.append("]");
            } else if (this.tq.matchesAny(combinators)) {
                break;
            } else {
                borrowBuilder.append(this.tq.consume());
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    private void contains(boolean z) {
        this.tq.consume(z ? ":containsOwn" : ":contains");
        String unescape = TokenQueue.unescape(this.tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":contains(text) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.ContainsOwnText(unescape));
        } else {
            this.evals.add(new Evaluator.ContainsText(unescape));
        }
    }

    private void containsData() {
        this.tq.consume(":containsData");
        String unescape = TokenQueue.unescape(this.tq.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":containsData(text) query must not be empty");
        this.evals.add(new Evaluator.ContainsData(unescape));
    }

    private void cssNthChild(boolean z, boolean z2) {
        String normalize = Normalizer.normalize(this.tq.chompTo(")"));
        Matcher matcher = NTH_AB.matcher(normalize);
        Matcher matcher2 = NTH_B.matcher(normalize);
        int i2 = 2;
        if ("odd".equals(normalize)) {
            r5 = 1;
        } else if (!"even".equals(normalize)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                r5 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i2 = parseInt;
            } else if (matcher2.matches()) {
                r5 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i2 = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", normalize);
            }
        }
        if (z2) {
            if (z) {
                this.evals.add(new Evaluator.IsNthLastOfType(i2, r5));
            } else {
                this.evals.add(new Evaluator.IsNthOfType(i2, r5));
            }
        } else if (z) {
            this.evals.add(new Evaluator.IsNthLastChild(i2, r5));
        } else {
            this.evals.add(new Evaluator.IsNthChild(i2, r5));
        }
    }

    private void findElements() {
        if (this.tq.matchChomp(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            byId();
        } else if (this.tq.matchChomp(".")) {
            byClass();
        } else if (!this.tq.matchesWord() && !this.tq.matches("*|")) {
            if (this.tq.matches("[")) {
                byAttribute();
            } else if (this.tq.matchChomp("*")) {
                allElements();
            } else if (this.tq.matchChomp(":lt(")) {
                indexLessThan();
            } else if (this.tq.matchChomp(":gt(")) {
                indexGreaterThan();
            } else if (this.tq.matchChomp(":eq(")) {
                indexEquals();
            } else if (this.tq.matches(":has(")) {
                has();
            } else if (this.tq.matches(":contains(")) {
                contains(false);
            } else if (this.tq.matches(":containsOwn(")) {
                contains(true);
            } else if (this.tq.matches(":containsData(")) {
                containsData();
            } else if (this.tq.matches(":matches(")) {
                matches(false);
            } else if (this.tq.matches(":matchesOwn(")) {
                matches(true);
            } else if (this.tq.matches(":not(")) {
                not();
            } else if (this.tq.matchChomp(":nth-child(")) {
                cssNthChild(false, false);
            } else if (this.tq.matchChomp(":nth-last-child(")) {
                cssNthChild(true, false);
            } else if (this.tq.matchChomp(":nth-of-type(")) {
                cssNthChild(false, true);
            } else if (this.tq.matchChomp(":nth-last-of-type(")) {
                cssNthChild(true, true);
            } else if (this.tq.matchChomp(":first-child")) {
                this.evals.add(new Evaluator.IsFirstChild());
            } else if (this.tq.matchChomp(":last-child")) {
                this.evals.add(new Evaluator.IsLastChild());
            } else if (this.tq.matchChomp(":first-of-type")) {
                this.evals.add(new Evaluator.IsFirstOfType());
            } else if (this.tq.matchChomp(":last-of-type")) {
                this.evals.add(new Evaluator.IsLastOfType());
            } else if (this.tq.matchChomp(":only-child")) {
                this.evals.add(new Evaluator.IsOnlyChild());
            } else if (this.tq.matchChomp(":only-of-type")) {
                this.evals.add(new Evaluator.IsOnlyOfType());
            } else if (this.tq.matchChomp(":empty")) {
                this.evals.add(new Evaluator.IsEmpty());
            } else if (this.tq.matchChomp(":root")) {
                this.evals.add(new Evaluator.IsRoot());
            } else if (this.tq.matchChomp(":matchText")) {
                this.evals.add(new Evaluator.MatchText());
            } else {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.query, this.tq.remainder());
            }
        } else {
            byTag();
        }
    }

    private void has() {
        this.tq.consume(":has");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":has(el) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Has(parse(chompBalanced)));
    }

    private void indexEquals() {
        this.evals.add(new Evaluator.IndexEquals(consumeIndex()));
    }

    private void indexGreaterThan() {
        this.evals.add(new Evaluator.IndexGreaterThan(consumeIndex()));
    }

    private void indexLessThan() {
        this.evals.add(new Evaluator.IndexLessThan(consumeIndex()));
    }

    private void matches(boolean z) {
        this.tq.consume(z ? ":matchesOwn" : ":matches");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            this.evals.add(new Evaluator.MatchesOwn(Pattern.compile(chompBalanced)));
        } else {
            this.evals.add(new Evaluator.Matches(Pattern.compile(chompBalanced)));
        }
    }

    private void not() {
        this.tq.consume(":not");
        String chompBalanced = this.tq.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":not(selector) subselect must not be empty");
        this.evals.add(new StructuralEvaluator.Not(parse(chompBalanced)));
    }

    public static Evaluator parse(String str) {
        try {
            return new QueryParser(str).parse();
        } catch (IllegalArgumentException e2) {
            throw new Selector.SelectorParseException(e2.getMessage(), new Object[0]);
        }
    }

    public Evaluator parse() {
        this.tq.consumeWhitespace();
        if (this.tq.matchesAny(combinators)) {
            this.evals.add(new StructuralEvaluator.Root());
            combinator(this.tq.consume());
        } else {
            findElements();
        }
        while (!this.tq.isEmpty()) {
            boolean consumeWhitespace = this.tq.consumeWhitespace();
            if (this.tq.matchesAny(combinators)) {
                combinator(this.tq.consume());
            } else if (consumeWhitespace) {
                combinator(' ');
            } else {
                findElements();
            }
        }
        if (this.evals.size() == 1) {
            return this.evals.get(0);
        }
        return new CombiningEvaluator.And(this.evals);
    }
}
