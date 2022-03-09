import static org.junit.Assert.assertEquals;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    private CustomList list;
    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }


    @Test
    public void testHasCity() {
        City city = new City("Yellowknife", "Northwest Territories");
        list.add(city);
        assertEquals(list.hasCity(city), true);
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.add(new City("", ""));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void testDelete() {
        int listSize = list.getCount();
        City city = new City("Yellowknife", "Northwest Territories");
        list.add(city);
        list.deleteCity(city);
        assertEquals(listSize, list.getCount());
    }

}
