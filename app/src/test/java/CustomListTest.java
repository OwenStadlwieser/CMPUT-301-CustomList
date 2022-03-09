import static org.junit.Assert.assertEquals;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private CustomList mockCityList() {
        CustomList cityList = new CustomList(null,new ArrayList<City>() );
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }


    @Test
    public void testHasCity() {
        CustomList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertEquals(cityList.hasCity(city), true);
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.add(new City("", ""));
        assertEquals(list.getCount(), listSize + 1);
    }

}
