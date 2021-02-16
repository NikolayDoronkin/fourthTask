package com.epam.task.fourth.handlers;

import com.epam.task.fourth.entitity.Address;
import com.epam.task.fourth.entitity.OldCards;
import com.epam.task.fourth.entitity.PeopleOldCard;
import com.epam.task.fourth.parser.TagsParser;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CardsHandler extends DefaultHandler {

    private List<OldCards> cardsList = new ArrayList<OldCards>();
    private OldCards currentCard = new OldCards();
    private TagsParser tag = null;

    public List<OldCards> getCardsList() {
        return cardsList;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (localName) {
            case "oldCards":
                currentCard = new OldCards();
                tag = TagsParser.OLDCARDS;
                break;
            case "PeopleOldCard":
                currentCard = new PeopleOldCard();
                break;
            case "Address":
                Address address = new Address();
                currentCard.setAddress(address);
                break;
            default:
                tag = TagsParser.valueOf(localName.toUpperCase());
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("oldCards".equals(localName)) {
            cardsList.add(currentCard);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String elementString = new String(ch, start, length).trim();
        Address address = currentCard.getAddress();
        if (tag != null) {
            switch (tag) {
                case OLDCARDS:
                    break;
                case PEOPLEOLDCARD:
                    break;
                case ADDRESS:
                    address = new Address();
                    currentCard.setAddress(address);
                    break;
                case CARDS:
                    break;
                case AUTHOR:
                    currentCard.setAuthor(elementString);
                    break;
                case COUNTRY:
                    address.setCountry(elementString);
                    break;
                case CITY:
                    address.setCity(elementString);
                    break;
                case STREET:
                    address.setStreet(elementString);
                    break;
                case NUMBEROFBUILDING:
                    address.setNumberOfBuild(Integer.parseInt(elementString));
                    break;
                case KEYWORD:
                    PeopleOldCard peopleOldCard = new PeopleOldCard();
                    peopleOldCard.setKeyWord(elementString);
                    currentCard = peopleOldCard;
                    break;
                default:
                    throw new EnumConstantNotPresentException(tag.getDeclaringClass(), tag.name());
            }
        }
        tag = null;
    }


}
