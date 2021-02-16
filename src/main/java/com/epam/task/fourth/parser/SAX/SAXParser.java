package com.epam.task.fourth.parser.SAX;

import com.epam.task.fourth.XmlException;
import com.epam.task.fourth.entitity.OldCards;
import com.epam.task.fourth.handlers.CardsHandler;
import com.epam.task.fourth.parser.AbstractParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SAXParser extends AbstractParser {

    private List<OldCards> cards;
    private CardsHandler cardsHandler = new CardsHandler();
    private XMLReader reader;

    @Override
    public List<OldCards> buildCards(String fileName) throws XmlException {
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(cardsHandler);
            reader.parse(fileName);
            cards = cardsHandler.getCardsList();
            return cards;
        } catch (IOException | SAXException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }
}
