package service;

import domain.TempData;

import java.util.Date;
import java.util.List;

public interface TempDataService {

    void save(TempData tempData);

    TempData findById(String id);

    List<TempData> findAllData();

    List<TempData> findAllData(Date startDate, Date endDate, boolean isInverse);
}
