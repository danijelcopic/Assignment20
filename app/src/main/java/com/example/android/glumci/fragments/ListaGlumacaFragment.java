package com.example.android.glumci.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.glumci.R;
import com.example.android.glumci.provider.GlumacProvider;

import java.util.List;

public class ListaGlumacaFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> listaGlumaca = GlumacProvider.getGlumacIme();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, listaGlumaca);
        ListView list = (ListView) getActivity().findViewById(R.id.lista_glumaca_f);
        list.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_glumaca_fragment, container, false);

        return view;
    }
}
