package ss13.controller;


import ss13.entity.Spend;
import ss13.service.SpendService;
import java.util.Collection;
import java.util.Map;

public class SpendController {
    SpendService service = new SpendService();

    public void delete(int code) {
        service.delete(code);
    }
    public void update(int code, Spend spend) {
        service.update(code, spend);
    }

    public Collection<Spend> getAll() {
        return service.getAll();
    }

    public Spend searchByCode(int code) {
       return service.searchByCode(code);
    }

    public Map<Integer, Spend> searchByName(String name) {
       return service.searchByName(name);
    }

    public Boolean isCodeExist(int code) {
        return service.isCodeExist(code);
    }

    public Spend add(Spend spend) {
       return service.addSpend(spend);
    }
}
