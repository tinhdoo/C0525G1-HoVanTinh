package ss12.controller;


import ss12.entity.Fruits;
import ss12.service.FruitService;

import java.util.Collection;
import java.util.Map;

public class FruitsController {
    FruitService service = new FruitService();

    public Fruits add(Fruits fruit){
       return service.add(fruit);
    }
    public Fruits update(int id, Fruits fruit){
        return service.update(id, fruit);
    }
    public void delete(int id){
        service.delete(id);
    }
    public Collection<Fruits> getAllFruits(){
        return service.getAllFruits();
    }
}




