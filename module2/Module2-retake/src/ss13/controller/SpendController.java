package ss13.controller;

import ss13.entity.Spend;
import ss13.service.SpendService;

import java.util.Collection;
import java.util.Scanner;

public class SpendController {
    SpendService service = new SpendService();

    public Collection<Spend> getAll() { return service.getAll(); }

    public boolean add(Spend spend) { return service.addSpend(spend); }

    public boolean delete(int code) { return service.delete(code); }

    public boolean update(Spend spend) { return service.update(spend); }

    public Spend searchByCode(int code) { return service.searchByCode(code); }

    public Collection<Spend> searchByName(String name) { return service.searchByName(name); }

}
