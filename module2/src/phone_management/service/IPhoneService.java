package phone_management.service;

import phone_management.model.Phone;

import java.util.List;

public interface IPhoneService {
        void addPhone(Phone phone);
        List<Phone> getAll();
        List<Phone> searchByName(String keyword);
        boolean removeById(int id);
        Phone findById(int id);
    }

