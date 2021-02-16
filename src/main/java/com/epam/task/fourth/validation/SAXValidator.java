package com.epam.task.fourth.validation;

import com.epam.task.fourth.handlers.CardsHandlerException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class SAXValidator {

    private static final String SCHEMA_XSD = "src/main/resources/candiesSchema.xsd";

    public boolean isValid(String filename) {
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(SCHEMA_XSD));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);

            SAXParser parser = spf.newSAXParser();

            parser.parse(filename, new CardsHandlerException());
            return true;
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("I/O error: " + e.getMessage());
            return false;
        }

    }

}