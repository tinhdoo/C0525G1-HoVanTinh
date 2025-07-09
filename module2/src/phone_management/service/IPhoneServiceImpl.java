package phone_management.service;

import phone_management.model.Phone;
import phone_management.repository.PhoneRepository;

import java.util.List;

public class IPhoneServiceImpl implements IPhoneService {
    private PhoneRepository phoneRepository = new PhoneRepository();

    @Override
    public void addPhone(Phone phone) {
        phoneRepository.addPhone(phone);
    }

    @Override
    public List<Phone> getAll() {
        return phoneRepository.getAll();
    }

    @Override
    public List<Phone> searchByName(String keyword) {
        return phoneRepository.searchByName(keyword);
    }

    @Override
    public boolean removeById(int id) {
        return phoneRepository.removeById(id);
    }

    @Override
    public Phone findById(int id) {
        return phoneRepository.findById(id);
    }
}

