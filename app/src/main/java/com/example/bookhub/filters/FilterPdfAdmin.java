package com.example.bookhub.filters;

import android.widget.Filter;

import com.example.bookhub.adapters.AdapterCategory;
import com.example.bookhub.adapters.AdapterPdfAdmin;
import com.example.bookhub.models.ModelCategory;
import com.example.bookhub.models.ModelPdf;

import java.util.ArrayList;

public class FilterPdfAdmin extends Filter {

    //arraylist in which we want to search
    ArrayList<ModelPdf> filterlist;
    //adapter in which filter need to be implemented
    AdapterPdfAdmin adapterPdfAdmin;

    //constructor
    public FilterPdfAdmin(ArrayList<ModelPdf> filterlist, AdapterPdfAdmin adapterPdfAdmin) {
        this.filterlist = filterlist;
        this.adapterPdfAdmin = adapterPdfAdmin;
    }


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value should not be null and empty
        if (constraint != null && constraint.length() > 0){
            //change to upper case, or lower case to avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdf> filteredModels = new ArrayList<>();
            for (int i=0; i< filterlist.size(); i++){
                //validate
                if (filterlist.get(i).getTitle().toUpperCase().contains(constraint)){
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
        adapterPdfAdmin.pdfArrayList = (ArrayList<ModelPdf>)results.values;

        //notify changes
        adapterPdfAdmin.notifyDataSetChanged();

    }
}
