package ss13.service;

import ss13.entity.Spend;
import ss13.repository.SpendRepo;
import java.util.Collection;
import java.util.Map;


public class SpendService implements ISpend{
    private SpendRepo repo = new SpendRepo();
    @Override
    public Spend addSpend(Spend spend) {
        repo.add(spend);
        return spend;
    }

    @Override
    public void delete(int code) {
        repo.delete(code);
    }

    @Override
    public void update(int code, Spend spend) {
        repo.update(code,spend);
    }

    @Override
    public Collection<Spend> getAll() {
        return repo.getAll();
    }

    @Override
    public Spend searchByCode(int code) {
       return repo.searchByCode(code);
    }

    @Override
    public Map<Integer, Spend> searchByName(String name) {
       return repo.searchByName(name);
    }

    @Override
    public Boolean isCodeExist(int code) {
        return repo.isCodeExist(code);
    }
}