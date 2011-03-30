package cz.cvut.fel.vyhliluk.tjv.internetbanking.sessionbean;

import cz.cvut.fel.vyhliluk.tjv.internetbanking.entity.Account;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lucky
 */
@Stateless
public class AccountSessionBean implements AccountSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addAccount(Account a) {
        System.out.println(a.getBalance());
        this.em.persist(a);
    }

    @Override
    public List<Account> getAllAccounts() {
        Query q = this.em.createNamedQuery("Account.findAll");
        return q.getResultList();
    }

    @Override
    public void updateAccount(Account a) {
        this.em.merge(a);
        this.em.flush();
    }
 
}
