package com.moor.imkf.lib.jsoup.parser;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.DocumentType;
import com.moor.imkf.lib.jsoup.parser.Token;
import h.t2.y;
import k.b.a.a.n.l;

/* loaded from: classes2.dex */
public enum TokeniserState {
    Data { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.1
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                tokeniser.emit(characterReader.consume());
            } else if (current == '&') {
                tokeniser.advanceTransition(TokeniserState.CharacterReferenceInData);
            } else if (current == '<') {
                tokeniser.advanceTransition(TokeniserState.TagOpen);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeData());
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    },
    CharacterReferenceInData { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.2
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, TokeniserState.Data);
        }
    },
    Rcdata { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.3
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current == '&') {
                tokeniser.advanceTransition(TokeniserState.CharacterReferenceInRcdata);
            } else if (current == '<') {
                tokeniser.advanceTransition(TokeniserState.RcdataLessthanSign);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeData());
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    },
    CharacterReferenceInRcdata { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.4
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, TokeniserState.Rcdata);
        }
    },
    Rawtext { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.5
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readRawData(tokeniser, characterReader, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.6
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readRawData(tokeniser, characterReader, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.7
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeTo((char) 0));
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    },
    TagOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.8
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == '!') {
                tokeniser.advanceTransition(TokeniserState.MarkupDeclarationOpen);
            } else if (current == '/') {
                tokeniser.advanceTransition(TokeniserState.EndTagOpen);
            } else if (current != '?') {
                if (characterReader.matchesLetter()) {
                    tokeniser.createTagPending(true);
                    tokeniser.transition(TokeniserState.TagName);
                    return;
                }
                tokeniser.error(this);
                tokeniser.emit(y.f15691d);
                tokeniser.transition(TokeniserState.Data);
            } else {
                tokeniser.createBogusCommentPending();
                tokeniser.advanceTransition(TokeniserState.BogusComment);
            }
        }
    },
    EndTagOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.9
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.Data);
            } else if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(TokeniserState.TagName);
            } else if (characterReader.matches(y.f15692e)) {
                tokeniser.error(this);
                tokeniser.advanceTransition(TokeniserState.Data);
            } else {
                tokeniser.error(this);
                tokeniser.createBogusCommentPending();
                tokeniser.advanceTransition(TokeniserState.BogusComment);
            }
        }
    },
    TagName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.10
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendTagName(characterReader.consumeTagName());
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                return;
            }
            if (consume != ' ') {
                if (consume != '/') {
                    if (consume == '<') {
                        characterReader.unconsume();
                        tokeniser.error(this);
                    } else if (consume != '>') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            tokeniser.tagPending.appendTagName(consume);
                            return;
                        }
                    }
                    tokeniser.emitTagPending();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
                tokeniser.transition(TokeniserState.SelfClosingStartTag);
                return;
            }
            tokeniser.transition(TokeniserState.BeforeAttributeName);
        }
    },
    RcdataLessthanSign { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.11
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(Attributes.InternalPrefix)) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (characterReader.matchesLetter() && tokeniser.appropriateEndTagName() != null) {
                if (!characterReader.containsIgnoreCase("</" + tokeniser.appropriateEndTagName())) {
                    tokeniser.tagPending = tokeniser.createTagPending(false).name(tokeniser.appropriateEndTagName());
                    tokeniser.emitTagPending();
                    characterReader.unconsume();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
            }
            tokeniser.emit(SimpleComparison.LESS_THAN_OPERATION);
            tokeniser.transition(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.12
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(TokeniserState.RCDATAEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.13
        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit("</");
            tokeniser.emit(tokeniser.dataBuffer);
            characterReader.unconsume();
            tokeniser.transition(TokeniserState.Rcdata);
        }

        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                String consumeLetterSequence = characterReader.consumeLetterSequence();
                tokeniser.tagPending.appendTagName(consumeLetterSequence);
                tokeniser.dataBuffer.append(consumeLetterSequence);
                return;
            }
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(TokeniserState.BeforeAttributeName);
                } else {
                    anythingElse(tokeniser, characterReader);
                }
            } else if (consume == '/') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(TokeniserState.SelfClosingStartTag);
                } else {
                    anythingElse(tokeniser, characterReader);
                }
            } else if (consume != '>') {
                anythingElse(tokeniser, characterReader);
            } else if (tokeniser.isAppropriateEndTagToken()) {
                tokeniser.emitTagPending();
                tokeniser.transition(TokeniserState.Data);
            } else {
                anythingElse(tokeniser, characterReader);
            }
        }
    },
    RawtextLessthanSign { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.14
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(Attributes.InternalPrefix)) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RawtextEndTagOpen);
                return;
            }
            tokeniser.emit(y.f15691d);
            tokeniser.transition(TokeniserState.Rawtext);
        }
    },
    RawtextEndTagOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.15
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.16
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.17
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '!') {
                tokeniser.emit("<!");
                tokeniser.transition(TokeniserState.ScriptDataEscapeStart);
            } else if (consume == '/') {
                tokeniser.createTempBuffer();
                tokeniser.transition(TokeniserState.ScriptDataEndTagOpen);
            } else if (consume != 65535) {
                tokeniser.emit(SimpleComparison.LESS_THAN_OPERATION);
                characterReader.unconsume();
                tokeniser.transition(TokeniserState.ScriptData);
            } else {
                tokeniser.emit(SimpleComparison.LESS_THAN_OPERATION);
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataEndTagOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.18
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.19
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.20
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(l.f16189d)) {
                tokeniser.emit(l.f16189d);
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapeStartDash);
                return;
            }
            tokeniser.transition(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStartDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.21
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(l.f16189d)) {
                tokeniser.emit(l.f16189d);
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedDashDash);
                return;
            }
            tokeniser.transition(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscaped { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.22
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current == '-') {
                tokeniser.emit(l.f16189d);
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedDash);
            } else if (current != '<') {
                tokeniser.emit(characterReader.consumeToAny(l.f16189d, y.f15691d, 0));
            } else {
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.23
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataEscapedDashDash);
            } else if (consume != '<') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.transition(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.24
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
            } else if (consume == '<') {
                tokeniser.transition(TokeniserState.ScriptDataEscapedLessthanSign);
            } else if (consume != '>') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.25
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTempBuffer();
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.emit(SimpleComparison.LESS_THAN_OPERATION);
                tokeniser.emit(characterReader.current());
                tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapeStart);
            } else if (characterReader.matches(Attributes.InternalPrefix)) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedEndTagOpen);
            } else {
                tokeniser.emit(y.f15691d);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.26
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.27
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.28
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.29
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current == '-') {
                tokeniser.emit(current);
                tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (current == '<') {
                tokeniser.emit(current);
                tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeToAny(l.f16189d, y.f15691d, 0));
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.30
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (consume == '<') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (consume != 65535) {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.31
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
            } else if (consume == '<') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (consume == '>') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptData);
            } else if (consume != 65535) {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.32
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(Attributes.InternalPrefix)) {
                tokeniser.emit(Attributes.InternalPrefix);
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.33
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.34
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.transition(TokeniserState.AttributeName);
            } else if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    } else if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    } else {
                        switch (consume) {
                            case '<':
                                characterReader.unconsume();
                                tokeniser.error(this);
                                tokeniser.emitTagPending();
                                tokeniser.transition(TokeniserState.Data);
                                return;
                            case '=':
                                break;
                            case '>':
                                tokeniser.emitTagPending();
                                tokeniser.transition(TokeniserState.Data);
                                return;
                            default:
                                tokeniser.tagPending.newAttribute();
                                characterReader.unconsume();
                                tokeniser.transition(TokeniserState.AttributeName);
                                return;
                        }
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
                tokeniser.transition(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.35
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendAttributeName(characterReader.consumeToAnySorted(TokeniserState.attributeNameCharsSorted));
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '\'') {
                        if (consume == '/') {
                            tokeniser.transition(TokeniserState.SelfClosingStartTag);
                            return;
                        } else if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            switch (consume) {
                                case '<':
                                    break;
                                case '=':
                                    tokeniser.transition(TokeniserState.BeforeAttributeValue);
                                    return;
                                case '>':
                                    tokeniser.emitTagPending();
                                    tokeniser.transition(TokeniserState.Data);
                                    return;
                                default:
                                    tokeniser.tagPending.appendAttributeName(consume);
                                    return;
                            }
                        }
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName(consume);
                    return;
                }
                tokeniser.transition(TokeniserState.AfterAttributeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.appendAttributeName((char) 65533);
        }
    },
    AfterAttributeName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.36
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeName((char) 65533);
                tokeniser.transition(TokeniserState.AttributeName);
            } else if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    } else if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    } else {
                        switch (consume) {
                            case '<':
                                break;
                            case '=':
                                tokeniser.transition(TokeniserState.BeforeAttributeValue);
                                return;
                            case '>':
                                tokeniser.emitTagPending();
                                tokeniser.transition(TokeniserState.Data);
                                return;
                            default:
                                tokeniser.tagPending.newAttribute();
                                characterReader.unconsume();
                                tokeniser.transition(TokeniserState.AttributeName);
                                return;
                        }
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
                tokeniser.transition(TokeniserState.AttributeName);
            }
        }
    },
    BeforeAttributeValue { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.37
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533);
                tokeniser.transition(TokeniserState.AttributeValue_unquoted);
            } else if (consume != ' ') {
                if (consume != '\"') {
                    if (consume != '`') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.emitTagPending();
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        } else if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                            return;
                        } else {
                            if (consume == '&') {
                                characterReader.unconsume();
                                tokeniser.transition(TokeniserState.AttributeValue_unquoted);
                                return;
                            } else if (consume != '\'') {
                                switch (consume) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.error(this);
                                        tokeniser.emitTagPending();
                                        tokeniser.transition(TokeniserState.Data);
                                        return;
                                    default:
                                        characterReader.unconsume();
                                        tokeniser.transition(TokeniserState.AttributeValue_unquoted);
                                        return;
                                }
                            } else {
                                tokeniser.transition(TokeniserState.AttributeValue_singleQuoted);
                                return;
                            }
                        }
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(consume);
                    tokeniser.transition(TokeniserState.AttributeValue_unquoted);
                    return;
                }
                tokeniser.transition(TokeniserState.AttributeValue_doubleQuoted);
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.38
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeAttributeQuoted = characterReader.consumeAttributeQuoted(false);
            if (consumeAttributeQuoted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeAttributeQuoted);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533);
            } else if (consume == '\"') {
                tokeniser.transition(TokeniserState.AfterAttributeValue_quoted);
            } else if (consume != '&') {
                if (consume != 65535) {
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                }
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            } else {
                int[] consumeCharacterReference = tokeniser.consumeCharacterReference(Character.valueOf(y.a), true);
                if (consumeCharacterReference != null) {
                    tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                } else {
                    tokeniser.tagPending.appendAttributeValue(y.f15690c);
                }
            }
        }
    },
    AttributeValue_singleQuoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.39
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeAttributeQuoted = characterReader.consumeAttributeQuoted(true);
            if (consumeAttributeQuoted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeAttributeQuoted);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != '&') {
                if (consume != '\'') {
                    tokeniser.tagPending.appendAttributeValue(consume);
                } else {
                    tokeniser.transition(TokeniserState.AfterAttributeValue_quoted);
                }
            } else {
                int[] consumeCharacterReference = tokeniser.consumeCharacterReference('\'', true);
                if (consumeCharacterReference != null) {
                    tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                } else {
                    tokeniser.tagPending.appendAttributeValue(y.f15690c);
                }
            }
        }
    },
    AttributeValue_unquoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.40
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.attributeValueUnquoted);
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '`') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            if (consume == '&') {
                                int[] consumeCharacterReference = tokeniser.consumeCharacterReference(Character.valueOf(y.f15692e), true);
                                if (consumeCharacterReference != null) {
                                    tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                                    return;
                                } else {
                                    tokeniser.tagPending.appendAttributeValue(y.f15690c);
                                    return;
                                }
                            } else if (consume != '\'') {
                                switch (consume) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.emitTagPending();
                                        tokeniser.transition(TokeniserState.Data);
                                        return;
                                    default:
                                        tokeniser.tagPending.appendAttributeValue(consume);
                                        return;
                                }
                            }
                        }
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                }
                tokeniser.transition(TokeniserState.BeforeAttributeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.appendAttributeValue((char) 65533);
        }
    },
    AfterAttributeValue_quoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.41
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeAttributeName);
            } else if (consume == '/') {
                tokeniser.transition(TokeniserState.SelfClosingStartTag);
            } else if (consume == '>') {
                tokeniser.emitTagPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.BeforeAttributeName);
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    SelfClosingStartTag { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.42
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.tagPending.selfClosing = true;
                tokeniser.emitTagPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.BeforeAttributeName);
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BogusComment { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.43
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.unconsume();
            tokeniser.commentPending.append(characterReader.consumeTo(y.f15692e));
            char consume = characterReader.consume();
            if (consume == '>' || consume == 65535) {
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    MarkupDeclarationOpen { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.44
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchConsume("--")) {
                tokeniser.createCommentPending();
                tokeniser.transition(TokeniserState.CommentStart);
            } else if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniser.transition(TokeniserState.Doctype);
            } else if (characterReader.matchConsume("[CDATA[")) {
                tokeniser.createTempBuffer();
                tokeniser.transition(TokeniserState.CdataSection);
            } else {
                tokeniser.error(this);
                tokeniser.createBogusCommentPending();
                tokeniser.advanceTransition(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.45
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append((char) 65533);
                tokeniser.transition(TokeniserState.Comment);
            } else if (consume == '-') {
                tokeniser.transition(TokeniserState.CommentStartDash);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                characterReader.unconsume();
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentStartDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.46
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append((char) 65533);
                tokeniser.transition(TokeniserState.Comment);
            } else if (consume == '-') {
                tokeniser.transition(TokeniserState.CommentStartDash);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.commentPending.append(consume);
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    Comment { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.47
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.commentPending.append((char) 65533);
            } else if (current == '-') {
                tokeniser.advanceTransition(TokeniserState.CommentEndDash);
            } else if (current != 65535) {
                tokeniser.commentPending.append(characterReader.consumeToAny(l.f16189d, 0));
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentEndDash { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.48
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append(l.f16189d).append((char) 65533);
                tokeniser.transition(TokeniserState.Comment);
            } else if (consume == '-') {
                tokeniser.transition(TokeniserState.CommentEnd);
            } else if (consume != 65535) {
                tokeniser.commentPending.append(l.f16189d).append(consume);
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentEnd { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.49
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append("--").append((char) 65533);
                tokeniser.transition(TokeniserState.Comment);
            } else if (consume == '!') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.CommentEndBang);
            } else if (consume == '-') {
                tokeniser.error(this);
                tokeniser.commentPending.append(l.f16189d);
            } else if (consume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.commentPending.append("--").append(consume);
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentEndBang { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.50
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append("--!").append((char) 65533);
                tokeniser.transition(TokeniserState.Comment);
            } else if (consume == '-') {
                tokeniser.commentPending.append("--!");
                tokeniser.transition(TokeniserState.CommentEndDash);
            } else if (consume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.commentPending.append("--!").append(consume);
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    Doctype { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.51
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ') {
                if (consume != '>') {
                    if (consume != 65535) {
                        tokeniser.error(this);
                        tokeniser.transition(TokeniserState.BeforeDoctypeName);
                        return;
                    }
                    tokeniser.eofError(this);
                }
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            tokeniser.transition(TokeniserState.BeforeDoctypeName);
        }
    },
    BeforeDoctypeName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.52
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(TokeniserState.DoctypeName);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append((char) 65533);
                tokeniser.transition(TokeniserState.DoctypeName);
            } else if (consume != ' ') {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(TokeniserState.Data);
                } else if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                } else {
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.name.append(consume);
                    tokeniser.transition(TokeniserState.DoctypeName);
                }
            }
        }
    },
    DoctypeName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.53
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence());
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume == '>') {
                        tokeniser.emitDoctypePending();
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    } else if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniser.emitDoctypePending();
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                        tokeniser.doctypePending.name.append(consume);
                        return;
                    }
                }
                tokeniser.transition(TokeniserState.AfterDoctypeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.name.append((char) 65533);
        }
    },
    AfterDoctypeName { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.54
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (characterReader.matchesAny('\t', '\n', '\r', '\f', ' ')) {
                characterReader.advance();
            } else if (characterReader.matches(y.f15692e)) {
                tokeniser.emitDoctypePending();
                tokeniser.advanceTransition(TokeniserState.Data);
            } else if (characterReader.matchConsumeIgnoreCase(DocumentType.PUBLIC_KEY)) {
                tokeniser.doctypePending.pubSysKey = DocumentType.PUBLIC_KEY;
                tokeniser.transition(TokeniserState.AfterDoctypePublicKeyword);
            } else if (characterReader.matchConsumeIgnoreCase(DocumentType.SYSTEM_KEY)) {
                tokeniser.doctypePending.pubSysKey = DocumentType.SYSTEM_KEY;
                tokeniser.transition(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.advanceTransition(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.55
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeDoctypePublicIdentifier);
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
            } else if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_singleQuoted);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.56
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
            } else if (consume == '\'') {
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_singleQuoted);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.57
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append((char) 65533);
            } else if (consume == '\"') {
                tokeniser.transition(TokeniserState.AfterDoctypePublicIdentifier);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.doctypePending.publicIdentifier.append(consume);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.58
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append((char) 65533);
            } else if (consume == '\'') {
                tokeniser.transition(TokeniserState.AfterDoctypePublicIdentifier);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.doctypePending.publicIdentifier.append(consume);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    AfterDoctypePublicIdentifier { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.59
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.60
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.61
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeDoctypeSystemIdentifier);
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.62
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (consume == '\'') {
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.63
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append((char) 65533);
            } else if (consume == '\"') {
                tokeniser.transition(TokeniserState.AfterDoctypeSystemIdentifier);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.doctypePending.systemIdentifier.append(consume);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.64
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append((char) 65533);
            } else if (consume == '\'') {
                tokeniser.transition(TokeniserState.AfterDoctypeSystemIdentifier);
            } else if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.doctypePending.systemIdentifier.append(consume);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemIdentifier { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.65
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BogusDoctype { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.66
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
            } else {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CdataSection { // from class: com.moor.imkf.lib.jsoup.parser.TokeniserState.67
        @Override // com.moor.imkf.lib.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.dataBuffer.append(characterReader.consumeTo("]]>"));
            if (characterReader.matchConsume("]]>") || characterReader.isEmpty()) {
                tokeniser.emit(new Token.CData(tokeniser.dataBuffer.toString()));
                tokeniser.transition(TokeniserState.Data);
            }
        }
    };
    
    private static final char eof = 65535;
    public static final char nullChar = 0;
    private static final char replacementChar = 65533;
    public static final char[] attributeNameCharsSorted = {0, '\t', '\n', '\f', '\r', ' ', y.a, '\'', Attributes.InternalPrefix, y.f15691d, '=', y.f15692e};
    public static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', '\r', ' ', y.a, y.f15690c, '\'', y.f15691d, '=', y.f15692e, '`'};
    private static final String replacementStr = String.valueOf((char) 65533);

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(consumeLetterSequence);
            tokeniser.emit(consumeLetterSequence);
            return;
        }
        char consume = characterReader.consume();
        if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ' && consume != '/' && consume != '>') {
            characterReader.unconsume();
            tokeniser.transition(tokeniserState2);
            return;
        }
        if (tokeniser.dataBuffer.toString().equals("script")) {
            tokeniser.transition(tokeniserState);
        } else {
            tokeniser.transition(tokeniserState2);
        }
        tokeniser.emit(consume);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.tagPending.appendTagName(consumeLetterSequence);
            tokeniser.dataBuffer.append(consumeLetterSequence);
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeAttributeName);
            } else if (consume == '/') {
                tokeniser.transition(SelfClosingStartTag);
            } else if (consume != '>') {
                tokeniser.dataBuffer.append(consume);
                z = true;
            } else {
                tokeniser.emitTagPending();
                tokeniser.transition(Data);
            }
            z2 = z;
        }
        if (z2) {
            tokeniser.emit("</");
            tokeniser.emit(tokeniser.dataBuffer);
            tokeniser.transition(tokeniserState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
        if (consumeCharacterReference == null) {
            tokeniser.emit(y.f15690c);
        } else {
            tokeniser.emit(consumeCharacterReference);
        }
        tokeniser.transition(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            tokeniser.createTagPending(false);
            tokeniser.transition(tokeniserState);
            return;
        }
        tokeniser.emit("</");
        tokeniser.transition(tokeniserState2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readRawData(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char current = characterReader.current();
        if (current == 0) {
            tokeniser.error(tokeniserState);
            characterReader.advance();
            tokeniser.emit((char) 65533);
        } else if (current == '<') {
            tokeniser.advanceTransition(tokeniserState2);
        } else if (current != 65535) {
            tokeniser.emit(characterReader.consumeRawData());
        } else {
            tokeniser.emit(new Token.EOF());
        }
    }

    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);
}
