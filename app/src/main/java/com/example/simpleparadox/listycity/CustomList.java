package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }

    public int getCount() {
        return this.cities.size();
    }
    public void add(City city) {
        cities.add(city);
        return;
    }
    /**
     * This returns whether or not a list has a city
     * @param c
     * The city to look for
     * @return
     * Return true if the list has the city, false otherwise
     */
    public Boolean hasCity(City c) {
        int index = this.cities.indexOf(c);
        return index != -1;
    }

    /**
     * This returns whether or not a list has a city
     * @param c
     * The city to delete
     * @throws
     * IllegalArgumentException
     */
    public void deleteCity(City c) throws IllegalArgumentException {
        int index = this.cities.indexOf(c);
        if(index == -1) {
            throw new IllegalArgumentException("City not in list");
        }
        this.cities.remove(index);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
}
