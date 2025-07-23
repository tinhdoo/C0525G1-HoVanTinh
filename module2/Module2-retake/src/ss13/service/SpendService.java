package ss13.service;

import ss13.entity.Spend;
import ss13.repository.SpendRepo;
import java.util.Collection;


public class SpendService implements ISpend{
    private SpendRepo repo = new SpendRepo();
    @Override
    public void addSpend(Spend spend) {
        repo.add(spend);
    }

    @Override
    public void delete(int code) {
        repo.delete(code);
    }

    @Override
    public void update(int code) {
        repo.update(code);
    }

    @Override
    public Collection<Spend> getAll() {
        return repo.getAll();
    }

    @Override
    public void searchByCode(int code) {
        repo.searchByCode(code);
    }

    @Override
    public void searchByName(String name) {
        repo.searchByName(name);
    }

    @Override
    public Boolean isCodeExist(int code) {
        return true;
    }
}