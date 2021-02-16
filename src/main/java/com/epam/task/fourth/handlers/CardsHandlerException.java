package com.epam.task.fourth.handlers;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class CardsHandlerException extends DefaultHandler {

    public void warning(SAXParseException e) {
    }

    public void error(SAXParseException e) {
    }

    public void fatalError(SAXParseException e) {
    }

    private String getLineAddress(SAXParseException e) {

        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}