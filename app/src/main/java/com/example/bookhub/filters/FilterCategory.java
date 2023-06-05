package com.example.bookhub.filters;

import android.widget.Filter;

import com.example.bookhub.adapters.AdapterCategory;
import com.example.bookhub.models.ModelCategory;

import java.util.ArrayList;

public class FilterCategory extends Filter {

    //arraylist in which we want to search
    ArrayList<ModelCategory> filterlist;
    //adapter in which filter need to be implemented
    AdapterCategory adapterCategory;

    //constructor
    public FilterCategory(ArrayList<ModelCategory> filterlist, AdapterCategory adapterCategory) {
        this.filterlist = filterlist;
        this.adapterCategory = adapterCategory;
    }


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value should not be null and empty
        if (constraint != null && constraint.length() > 0){
            //change to upper case, or lower case to avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategory> filteredModels = new ArrayList<>();
            for (int i=0; i< filterlist.size(); i++){
                //validate
                if (filterlist.get(i).getCategory().toUpperCase().contains(constraint)){
                    //add to filtered models
                    filteredModels.add(filterlist.get(i));
                }
            }

            results.count = filterlist.size();
            results.values = filteredModels;

        }
        else {
            results.count = filterlist.size();
            results.values = filterlist;
        }

        return results; //don't miss it
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        //apply filter changes
        adapterCategory.categoryArrayList = (ArrayList<ModelCategory>)results.values;

        //notify changes
        adapterCategory.notifyDataSetChanged();

    }
}
