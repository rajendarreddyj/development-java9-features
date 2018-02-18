package com.rajendarreddyj.bank.request;

import com.rajendarreddyj.bank.enums.CardType;

/**
 * @author rajendarreddy.jagapathi
 */
public class PaymentRequest {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private CardType cardType;
    private double amount;

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return this.cardNumber;
    }

    /**
     * @param cardNumber
     *            the cardNumber to set
     */
    public void setCardNumber(final String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the expiryDate
     */
    public String getExpiryDate() {
        return this.expiryDate;
    }

    /**
     * @param expiryDate
     *            the expiryDate to set
     */
    public void setExpiryDate(final String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the cvv
     */
    public String getCvv() {
        return this.cvv;
    }

    /**
     * @param cvv
     *            the cvv to set
     */
    public void setCvv(final String cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the cardType
     */
    public CardType getCardType() {
        return this.cardType;
    }

    /**
     * @param cardType
     *            the cardType to set
     */
    public void setCardType(final CardType cardType) {
        this.cardType = cardType;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(final double amount) {
        this.amount = amount;
    }

}
