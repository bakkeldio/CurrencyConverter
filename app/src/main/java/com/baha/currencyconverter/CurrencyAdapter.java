package com.baha.currencyconverter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CurrencyAdapter extends BaseAdapter implements SpinnerAdapter {

    private ArrayList<Currency> currencies = new ArrayList<>();
    private Context context;

    public CurrencyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return currencies.size();
    }

    @Override
    public Object getItem(int position) {
        return currencies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.currency_item, null);
        Currency currency = currencies.get(position);
        TextView name = view.findViewById(R.id.tvName);
        name.setText(currency.getName());
        ImageView imageView = view.findViewById(R.id.ivFlag);
        imageView.setImageResource(currency.getImage());
        return view;
    }

    public void updateData(ArrayList<Currency> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }
}

