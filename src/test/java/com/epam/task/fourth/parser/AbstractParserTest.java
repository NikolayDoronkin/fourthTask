package com.epam.task.fourth.parser;

import com.epam.task.fourth.XmlException;
import com.epam.task.fourth.entitity.Address;
import com.epam.task.fourth.entitity.OldCards;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParserTest {
    private AbstractParser parser;
    private final String VALID_XML_FILE = "./src/main/new 1.txt";

    private final List<OldCards> EXPECTED = Arrays.asList(new OldCards(
            new Address("Belarus", "Minsk", "Sovetsky", 45), "Nikolay Doronkin"),
            new OldCards(
                    new Address("Belarus", "Minsk", "Golden slide", 11), "test"));


    public void setParser(AbstractParser parser){
        this.parser = parser;
    }

    @Test
    public void testParseShouldReturnParsedPlantsWhenValidXmlFileApplied() throws XmlException {
        //when
        List<OldCards> actual = parser.buildCards(VALID_XML_FILE);

        //then
        System.out.println(actual);
        Assert.assertEquals(EXPECTED, actual);
    }

}
