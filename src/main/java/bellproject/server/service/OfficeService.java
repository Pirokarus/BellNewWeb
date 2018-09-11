package bellproject.server.service;



import bellproject.view.OfficeView;

import java.util.List;

public interface OfficeService {

    void saveOffice(OfficeView officeEntity);

    List<OfficeView> findAllOffice();

    OfficeView findOfficeById(long id);

    void update(OfficeView officeEntity);

}
