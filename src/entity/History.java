package entity;

import sun.util.calendar.LocalGregorianCalendar;

import java.math.BigDecimal;

public class History {
    private Integer id;
    private Integer card_id;
    private BigDecimal pul;
    private String createdDate;
    private String cardNumber;
    private boolean condition;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public Integer getId() {
        return id;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public BigDecimal getPul() {
        return pul;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPul(BigDecimal pul) {
        this.pul = pul;
    }






    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public void setId(Integer id) {
        this.id = id;

    }


}
