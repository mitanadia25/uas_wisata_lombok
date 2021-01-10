package com.mitanadia.wisatalombok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mitanadia.wisatalombok.model.WisataLombok;

import java.util.List;

public class DaftarWisataAdapter extends ArrayAdapter<WisataLombok> {
    Context context;

    public DaftarWisataAdapter(@NonNull Context context, @NonNull List<WisataLombok> objects) {
        super(context, R.layout.row_wisata, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txNama;
        TextView txDaerah;
        TextView txDeskripsi;
        TextView txKategori;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WisataLombok tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_wisata, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txNama = convertView.findViewById(R.id.row_nama_destinasi);
            viewHolder.txDaerah = convertView.findViewById(R.id.row_daerah);
            viewHolder.txDeskripsi = convertView.findViewById(R.id.row_deskripsi);
            viewHolder.txKategori = convertView.findViewById(R.id.row_kategori);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txDeskripsi.setText(tr.getDeskripsi());
        viewHolder.txDaerah.setText(tr.getDaerah());
        viewHolder.txNama.setText(tr.getNamaDestinasi());
        if (tr.getKategori().equals(WisataLombok.AIRTERJUN)) {
            viewHolder.txKategori.setText("AIR TERJUN");
        } else if (tr.getKategori().equals(WisataLombok.BUDAYA)) {
            viewHolder.txKategori.setText("BUDAYA");
        } else if (tr.getKategori().equals(WisataLombok.PANTAI)) {
            viewHolder.txKategori.setText("PANTAI / LAUT");
        } else if (tr.getKategori().equals(WisataLombok.PEGUNUNGAN)) {
            viewHolder.txKategori.setText("PEGUNUNGAN");
        } else if (tr.getKategori().equals(WisataLombok.PEMANDIAN)) {
            viewHolder.txKategori.setText("PEMANDIAN");
        } else if (tr.getKategori().equals(WisataLombok.SEJARAH)) {
            viewHolder.txKategori.setText("SEJARAH");
        } else if (tr.getKategori().equals(WisataLombok.DESA)) {
            viewHolder.txKategori.setText("DESA WISATA");
        } else {
            viewHolder.txKategori.setText("UMUM");
        }
        return convertView;
    }
}