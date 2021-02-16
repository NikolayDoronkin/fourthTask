package com.epam.task.fourth.entitity;

public class PeopleOldCard extends OldCards {

    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public PeopleOldCard(Address inputAddress, String inputAuthor, String word) {
        super(inputAddress, inputAuthor);
        keyWord = word;
    }

    public PeopleOldCard() {
    }
}
