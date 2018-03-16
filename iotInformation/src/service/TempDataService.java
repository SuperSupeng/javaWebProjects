package service;

import domain.TempData;

import java.util.Date;
import java.util.List;

/**
 * @author super
 */
public interface TempDataService {

    /**
     * 保存
     * @param tempData
     */
    void save(TempData tempData);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    TempData findById(String id);


    /**
     * 查询所有数据
     * @param startDate
     * @param endDate
     * @param isInverse
     * @return
     */
    List<TempData> findAllData(Date startDate, Date endDate, boolean isInverse);

    /**
     * 查询所有数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<TempData> findAllData(Date startDate, Date endDate);
}
