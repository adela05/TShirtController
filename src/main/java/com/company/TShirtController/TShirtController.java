package com.company.TShirtController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TShirtController {
    private int id;
    List<TShirt> shirtList;

    public TShirtController(){
        // creating an Array List for Tshirts inventory
        shirtList = new ArrayList<>();
        id = 1; // creating a unique number for each product

        shirtList.add(new TShirt(id++, "White", 2, true));
        shirtList.add(new TShirt(id++, "Red", 5, true));
        shirtList.add(new TShirt(id++, "Blue", 1, true));
        shirtList.add(new TShirt(id++, "Black", 8, true));
        shirtList.add(new TShirt(id++, "Pink", 3, true));
    }

    // creating the Mapping Routes methods
    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    public List <TShirt> getTShirt (){
        return shirtList;
    }

    // Getting a single Tshirt by id
    @RequestMapping(value = "/tshirts/{id}", method = RequestMethod.GET)
    public TShirt getTShirtById(@PathVariable int id){
        for (int count = 0; count < shirtList.size(); count++){
            if (shirtList.get(count).getId() == id){
                return shirtList.get(count);
            }
        }
        return null;
    }

    // creating a update (POST) method for new inventory
    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody TShirt tShirt){
        tShirt.setId(this.id++);
        this.shirtList.add(tShirt);
        return tShirt;
    }

    // creating a delete route when the product is not available
    @RequestMapping(value = "/tshirts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id){
        for (int count = 0; count < this.shirtList.size(); count++) {
            if (this.shirtList.get(count).getId() == id) {
                this.shirtList.remove(count);
                break;
            }
        }
    }

    // creating a (PUT) route to update product info
    @RequestMapping(value = "/tshirts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable int id, @RequestBody TShirt tShirt){
        for (int count = 0; count < this.shirtList.size(); count++) {
            if (this.shirtList.get(count).getId() == id) {
                this.shirtList.set(count, tShirt);
                break;
            }
        }
    }

    // creating a (PATCH) route to update a specified product item
    @RequestMapping(value = "/tshirts/{id}", method = RequestMethod.PATCH)
    public void patchTShirt(@PathVariable int id, @RequestBody TShirt tShirt){
        /* not sure if this is the right code to add for this method
        tShirt.setId(this.id++);
        this.shirtList.add(tShirt);
        return tShirt; */
    }
}
