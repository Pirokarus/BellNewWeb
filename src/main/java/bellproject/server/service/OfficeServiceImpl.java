package bellproject.server.service;

import bellproject.server.dao.OfficeDAO;
import bellproject.server.pojo.OfficeEntity;
import bellproject.view.OfficeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("officeService")
@Transactional
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDAO officeDAO;

    public void saveOffice(OfficeView officeView) {
        officeDAO.saveOffice(officeView.parseOfficeEntity());
    }

    public List<OfficeView> findAllOffice() {
        return officeDAO.findAllOffices().stream().map(OfficeView::new).collect(Collectors.toList());
    }

    public OfficeView findOfficeById(long id) {
        return new OfficeView(officeDAO.findOfficeById(id));
    }

    @Override
    public void update(OfficeView officeView) {
        officeDAO.update(officeView.parseOfficeEntity());
    }

}
