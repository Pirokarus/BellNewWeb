package bellproject.server.dao;

import bellproject.server.pojo.OfficeEntity;

import java.util.List;

public interface OfficeDAO {
    void saveOffice(OfficeEntity officeEntity);

    List<OfficeEntity> findAllOffices();

    OfficeEntity findOfficeById(long id);

    void update(OfficeEntity officeEntity);

}
