package com.rajendarreddyj.bank.response;

import com.rajendarreddyj.bank.enums.CardType;

/**
 * @author rajendarreddy.jagapathi
 */
public class CustomerResponse {
    private String fname;
    private String lname;
    private CardType cardType;
    private double amount;
    private boolean transactionStatus;

    public CustomerResponse() {
    }

    public CustomerResponse(final String fname, final String lname, final CardType cardType, final double amount, final boolean transactionStatus) {
        this.fname = fname;
        this.lname = lname;
        this.cardType = cardType;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return this.fname;
    }

    /**
     * @param fname
     *            the fname to set
     */
    public void setFname(final String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return this.lname;
    }

    /**
     * @param lname
     *            the lname to set
     */
    public void setLname(final String lname) {
        this.lname = lname;
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

    /**
     * @return the transactionStatus
     */
    public boolean isTransactionStatus() {
        return this.transactionStatus;
    }

    /**
     * @param transactionStatus
     *            the transactionStatus to set
     */
    public void setTransactionStatus(final boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

}
