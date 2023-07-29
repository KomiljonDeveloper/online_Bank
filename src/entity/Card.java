package entity;

import java.math.BigDecimal;

public class Card {
    public Integer getId_1() {
        return id_1;
    }

    public void setId_1(Integer id_1) {
        this.id_1 = id_1;
    }

    private Integer id;
    private Integer id_1;
    private String number;
    private String expireDate;
    private BigDecimal balance;
    private Integer history_id;
    private Integer usar_id;

    public Integer getUsar_id() {
        return usar_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsar_id(Integer usar_id) {
        this.usar_id = usar_id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getHistory_id() {
        return history_id;
    }

    public void setHistory_id(Integer history_id) {
        this.history_id = history_id;
    }
}
