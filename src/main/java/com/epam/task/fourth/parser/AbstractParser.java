package com.epam.task.fourth.parser;

import com.epam.task.fourth.XmlException;
import com.epam.task.fourth.entitity.OldCards;

import java.util.List;

public abstract class AbstractParser {


    abstract public List<OldCards> buildCards(String fileName) throws XmlException;

}
