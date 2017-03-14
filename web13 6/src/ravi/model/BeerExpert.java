package ravi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raviagrawal on 29/01/17.
 */
public class BeerExpert {

    public List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();
        if(color.equalsIgnoreCase("red")){
            brands.add("red beer 1");
            brands.add("red beer 2");
        }else if(color.equalsIgnoreCase("brown")){
            brands.add("brown beer 1");
            brands.add("brown beer 2");
            brands.add("brown beer 3");
        }else{
            brands.add("other beer 1");
            brands.add("other beer 2");
        }
        return brands;
    }
}
