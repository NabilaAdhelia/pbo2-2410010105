/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 *
 * @author user
 */
public class NilaiTableModel {
    private static final Locale INDONESIA = Locale.forLanguageTag("id-ID");
    private final String[] namaKolom = {"NPM", "Nama", "Tugas", "UTS", "UAS", "Akhir", "Huruf"};
    private final List<Nilai> daftar = new ArrayList<>();

    public int getRowCount() { return daftar.size(); }

    public int getColumnCount() { return namaKolom.length; }

    public String getColumnName(int column) { return namaKolom[column]; }

    public Object getValueAt(int baris, int kolom) {
        Nilai m = daftar.get(baris);
        return switch (kolom) {
            case 0 -> m.getNpm();
            case 1 -> m.getNama();
            case 2 -> m.getTugas();
            case 3 -> m.getUts();
            case 4 -> m.getUas();
            case 5 -> String.format(INDONESIA, "%.2f", m.getNilaiAkhir());
            default -> m.getHuruf();
        };
    }

    
    public void tambah(Nilai m) {
        daftar.add(m);
        fireTableRowsInserted(daftar.size() - 1, daftar.size() - 1);
    }

    public boolean adaNpm(String npm) {
        for (Nilai m : daftar) {
            if (m.getNpm().equals(npm)) return true;
        }
        return false;
    }

    public int getJumlah() { return daftar.size(); }

    public double getRataRata() {
        if (daftar.isEmpty()) return 0;
        double total = 0;
        for (Nilai m : daftar) total += m.getNilaiAkhir();
        return total / daftar.size();
    }

    private void fireTableRowsInserted(int i0, int par1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

