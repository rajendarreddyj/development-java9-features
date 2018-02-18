package com.rajendarreddyj.bank.enums;

/**
 * @author rajendarreddy.jagapathi
 */
public enum CardType {
    VISA, MASTER, DISCOVER, AMEX;

    public static CardType getCardType(final String cardType) {
        CardType return_cardtype = null;
        for (CardType type : values()) {
            if (type.toString().equals(cardType)) {
                return_cardtype = type;
            }
        }
        return return_cardtype;
    }
}
