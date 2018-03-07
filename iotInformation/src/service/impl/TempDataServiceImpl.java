package service.impl;

import dao.TempDataDao;
import dao.impl.TempDataDaoImpl;
import domain.TempData;
import service.TempDataService;

import java.util.Date;
import java.util.List;

public class TempDataServiceImpl implements TempDataService {
    private TempDataDao dao = new TempDataDaoImpl();

    @Override
    public void save(TempData tempData) {
        dao.save(tempData);
    }

    @Override
    public TempData findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<TempData> findAllData() {
        return dao.findAllData();
    }

    @Override
    public List<TempData> findAllData(Date startDate, Date endDate, boolean isInverse) {
        return dao.findAllData(startDate, endDate, isInverse);
    }
}
