package ss13.service;

import ss13.entity.Spend;

import java.util.Map;

public interface ISpend {
    void addSpend(Spend spend);
    void delete(int code);
    void update(int code);
    void getAll();
    void searchByCode(int code);
    void searchByName(String name);
    Boolean isCodeExist(int code);
}
