package com.epam.task.fourth.parser;

import com.epam.task.fourth.parser.JAXB.JAXBParser;
import com.epam.task.fourth.parser.SAX.SAXParser;
import com.epam.task.fourth.parser.StAX.StAXParser;

public class ParserFactory {

    public AbstractParser createParser(TypeParser type) {
        switch (type) {
            case SAX:
                return new SAXParser();
            case StAX:
                return new StAXParser();
            case JAXB:
                return new JAXBParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

}
