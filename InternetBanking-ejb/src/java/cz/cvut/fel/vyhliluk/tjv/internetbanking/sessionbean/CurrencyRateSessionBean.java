package cz.cvut.fel.vyhliluk.tjv.internetbanking.sessionbean;

import cz.cvut.fel.vyhliluk.tjv.internetbanking.entity.CurrencyRate;
import cz.cvut.fel.vyhliluk.tjv.internetbanking.entity.CurrentCurrencyRate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lucky
 */
@Stateless
public class CurrencyRateSessionBean implements CurrencyRateSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CurrencyRate> getAllRates() {
        Query q = this.em.createNamedQuery("CurrencyRate.findAll");
        return q.getResultList();
    }

    @Override
    public void update(CurrencyRate c) {
        this.em.merge(c);
    }

    @Override
    public void remove(Integer id) {
        CurrencyRate cr = this.em.find(CurrencyRate.class, id);
        if (cr != null) {
            this.em.remove(cr);
        }
    }

    @Override
    public CurrencyRate getByCurrencyCode(String code) {
        Query q = this.em.createNamedQuery("CurrencyRate.getByCurrencyCode");
        q.setParameter("code", code);
        try {
            return (CurrencyRate) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public CurrencyRate getById(Integer id) {
        return this.em.find(CurrencyRate.class, id);
    }

    @Override
    public void updateCurrentCurrency(CurrentCurrencyRate ccr) {
        this.em.merge(ccr);
    }

    @Override
    public CurrentCurrencyRate getCurrentRateByCurrencyCode(String code) {
        Query q = this.em.createNamedQuery("CurrentCurrencyRate.getByCurrencyCode");
        q.setParameter("code", code);
        try {
            return (CurrentCurrencyRate) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void removeCurrentCurrencyRate(Integer id) {
        CurrentCurrencyRate cr = this.em.find(CurrentCurrencyRate.class, id);
        if (cr != null) {
            this.em.remove(cr);
        }
    }
}
