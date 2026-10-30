
package id.ac.uniska.pbo2.p07.tabel.dan.menu;

/**
 * Kategori kontak.
 * Nilai toString() digunakan sebagai teks di ComboBox dan tabel.
 */
public enum Kategori {
    KELUARGA("Keluarga"),
    TEMAN("Teman"),
    KAMPUS("Kampus"),
    KERJA("Kerja");

    private final String label;

    Kategori(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
