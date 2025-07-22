package ss13.service;

import ss13.entity.Spend;

import java.util.Map;

public interface ISpend {
    void add(int code);
    void delete(int code);
    void update(int code);

    void getAll();

    void searchById(int code);
    void searchByname(String name);
    Boolean isCodeExist(int code);
}
