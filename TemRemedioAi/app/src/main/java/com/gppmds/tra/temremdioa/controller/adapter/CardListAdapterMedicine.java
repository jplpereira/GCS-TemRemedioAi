package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderMedicine;
import com.gppmds.tra.temremdioa.model.Remedio;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

public class CardListAdapterMedicine extends RecyclerView.Adapter<ViewHolderMedicine> implements Filterable{
    public static List<Remedio> dataMedicine;
    List<Remedio> filterDataMedicine;
    Context contextOpen;
    FilterSearchRemedio filter;
    private Boolean showButtonUBSs;

    public CardListAdapterMedicine(Context context, List<Remedio> dataMedicine) {
        this.contextOpen = context;
        this.dataMedicine = dataMedicine;
        this.filterDataMedicine = dataMedicine;
        setShowButtonUBSs(true);
    }

    @Override
    public ViewHolderMedicine onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_medicine, parent, false);
        return new ViewHolderMedicine(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderMedicine holder, int position) {
        Remedio rowData = this.dataMedicine.get(position);
        holder.textViewMedicineName.setText(rowData.getMedicineDescription());
        holder.textViewMedicineType.setText(rowData.getMedicineUnitExtended());
        holder.textViewMedicineDosage.setText(rowData.getMedicineDosage());
        holder.textViewMedicineAttentionLevel.setText(rowData.getMedicineAttentionLevelExtended());
        if (!getShowButtonUBSs()) {
            holder.buttonUbsSelect.setVisibility(View.GONE);
        }
    }

    @Override
    public Filter getFilter() {
        if(filter == null) {
            filter = new FilterSearchRemedio(filterDataMedicine, this );
        }

        return filter;
    }

    @Override
    public int getItemCount() {
        return dataMedicine.size();
    }

    public void setShowButtonUBSs(Boolean showButtonUBSs) {
        this.showButtonUBSs = showButtonUBSs;
    }

    private Boolean getShowButtonUBSs() {
        return this.showButtonUBSs;
    }
}
