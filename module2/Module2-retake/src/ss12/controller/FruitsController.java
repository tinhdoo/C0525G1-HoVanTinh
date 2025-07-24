package ss12.controller;


import ss12.entity.Fruits;
import ss12.service.FruitService;

import java.util.Map;

public class FruitsController {
    FruitService service = new FruitService();

    public Fruits add(int id){
       return service.add(id);
    }
    public Fruits update(int id){
        return service.update(id);
    }
    public void delete(id){
        return service.delete(id);
    }
    public Map<Integer, Fruits> getAll(){
        return service.getAllFruits();
    }
}




