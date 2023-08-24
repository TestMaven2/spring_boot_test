package com.telran.spring_boot_test;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeController() {
        coffees.add(new Coffee("1", "Latte"));
        coffees.add(new Coffee("2", "Americano"));
        coffees.add(new Coffee("3", "Cappuccino"));
        coffees.add(new Coffee("4", "Mocha"));
    }

//    @RequestMapping(method = RequestMethod.GET)
    // localhost:8080/coffee
    @GetMapping
    public List<Coffee> getAllCoffee() {
        return coffees;
    }

    // localhost:8080/coffee/1/
    @GetMapping("/{id}")
    public Coffee getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffees) {
            if (id.equals(coffee.getId())) {
                System.out.println("User requested " + coffee);
                return coffee;
            }
        }
        System.out.println("There is no coffee with requested id " + id);
        return null;
    }

    @PostMapping
    public Coffee createNewCoffee(@RequestBody Coffee coffee) {
        System.out.println("New Coffee created - " + coffee);
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    public Coffee putCoffee(@PathVariable String id,
                            @RequestBody Coffee coffee) {
        for (Coffee currentCoffee : coffees) {
            if (currentCoffee.getId().equals(id)) {
                currentCoffee.setName(coffee.getName());
                return currentCoffee;
            }
        }
        coffees.add(coffee);
        return coffee;
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
