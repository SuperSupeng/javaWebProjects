package dao;

import domain.TempData;

import java.util.Date;
import java.util.List;

public interface TempDataDao {

    void save(TempData tempData);

    TempData findById(String id);

    List<TempData> findAllData();

    List<TempData> findAllData(Date startDate, Date endDate, boolean isInverse);
}
