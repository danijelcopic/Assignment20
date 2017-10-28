package com.example.android.glumci.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.glumci.R;
import com.example.android.glumci.model.Film;
import com.example.android.glumci.provider.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;
import java.security.Provider;
import java.util.List;

public class DetailFragment extends Fragment{


        private static int NOTIFICATION_ID = 1;

        private int position = 0;

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {

            super.onActivityCreated(savedInstanceState);

            if (savedInstanceState != null) {
                position = savedInstanceState.getInt("position", 0);
            }

            // glumac - slika
            ImageView ivGlumacImage = (ImageView) getView().findViewById(R.id.slika_glumac);
            InputStream is = null;
            try {
                is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getFotografija());
                Drawable drawable = Drawable.createFromStream(is, null);
                ivGlumacImage.setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // glumac -ime
            TextView glumacIme = (TextView) getView().findViewById(R.id.ime_glumac);
            glumacIme.setText(GlumacProvider.getGlumacById(position).getIme());


            // glumac -godina rodjenja
            TextView glumacRodjenje = (TextView) getView().findViewById(R.id.rodjenje_glumac);
            glumacRodjenje.setText(GlumacProvider.getGlumacById(position).getDatumRodjenja());

            // glumac -godina smrti
            TextView glumacSmrt = (TextView) getView().findViewById(R.id.smrt_glumac);
            glumacSmrt.setText(GlumacProvider.getGlumacById(position).getDatumSmrti());

            // glumac -ocena
            TextView glumacOcena = (TextView) getView().findViewById(R.id.ocena_glumac);
            String stringdouble = Double.toString(GlumacProvider.getGlumacById(position).getOcena());
            glumacOcena.setText(stringdouble);

            // glumac -biografija
            TextView glumacBiografija = (TextView) getView().findViewById(R.id.biografija_opis_glumac);
            glumacBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());

            // lista filmova
            List<Film> films = (GlumacProvider.getGlumacById(position).getFilmovi());
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter(getActivity(), R.layout.mylist, films);
            ListView listView = (ListView) getView().findViewById(R.id.lista_filmova_glumac);
            listView.setAdapter(itemsAdapter);

        }


        @Override
        public void onSaveInstanceState(Bundle savedInstanceState) {
            super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putInt("position", position);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_detail, container, false);
            return view;
        }


        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }


        public void setContent(final int position) {

            this.position = position;
        }


        public void updateContent(final int position) {

            this.position = position;

            // glumac - slika
            ImageView ivGlumacImage = (ImageView) getView().findViewById(R.id.slika_glumac);
            InputStream is = null;
            try {
                is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getFotografija());
                Drawable drawable = Drawable.createFromStream(is, null);
                ivGlumacImage.setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // glumac -ime
            TextView glumacIme = (TextView) getView().findViewById(R.id.ime_glumac);
            glumacIme.setText(GlumacProvider.getGlumacById(position).getIme());


            // glumac -godina rodjenja
            TextView glumacRodjenje = (TextView) getView().findViewById(R.id.rodjenje_glumac);
            glumacRodjenje.setText(GlumacProvider.getGlumacById(position).getDatumRodjenja());

            // glumac -godina smrti
            TextView glumacSmrt = (TextView) getView().findViewById(R.id.smrt_glumac);
            glumacSmrt.setText(GlumacProvider.getGlumacById(position).getDatumSmrti());

            // glumac -ocena
            TextView glumacOcena = (TextView) getView().findViewById(R.id.ocena_glumac);
            String stringdouble = Double.toString(GlumacProvider.getGlumacById(position).getOcena());
            glumacOcena.setText(stringdouble);

            // glumac -biografija
            TextView glumacBiografija = (TextView) getView().findViewById(R.id.biografija_opis_glumac);
            glumacBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());

            // lista filmova
            List<Film> films = (GlumacProvider.getGlumacById(position).getFilmovi());
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, films);
            ListView listView = (ListView) getView().findViewById(R.id.lista_filmova_glumac);
            listView.setAdapter(itemsAdapter);

        }
}
