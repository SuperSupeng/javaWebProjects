package dao;

/**
 * @author super
 */
public interface AccountDao {
    void increaseMoney(Integer id,Double money);
    void decreaseMoney(Integer id,Double money);
}
