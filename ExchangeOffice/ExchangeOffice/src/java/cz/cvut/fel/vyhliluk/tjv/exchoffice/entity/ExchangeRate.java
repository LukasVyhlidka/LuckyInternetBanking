package cz.cvut.fel.vyhliluk.tjv.exchoffice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Date: 18.4.2011
 * Time: 14:38:06
 * @author Lucky
 */
@Entity
@NamedQueries({
    @NamedQuery(name="ExchangeRate.findByCode", query="SELECT er FROM ExchangeRate er where er.currency = :code")
})
public class ExchangeRate implements Serializable {

    @Id
    @Column(length=3)
    private String currency;

    @Column(precision=10, scale=4, nullable=false)
    private BigDecimal rate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }



}
