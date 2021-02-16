package com.epam.task.fourth.parser;

import com.epam.task.fourth.XmlException;
import com.epam.task.fourth.parser.SAX.SAXParser;

public class SAXParserTest extends AbstractParserTest{
    private SAXParser parser = new SAXParser();

    @Override
    public void testParseShouldReturnParsedPlantsWhenValidXmlFileApplied() throws XmlException {
        setParser(parser);
        super.testParseShouldReturnParsedPlantsWhenValidXmlFileApplied();
    }
}
