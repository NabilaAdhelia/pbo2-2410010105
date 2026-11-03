/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Nama: Nabila Adhelia
//NPM: 2410010105
package id.ac.uniska.pbo2.p08.uts.a;

/**
 *
 * @author user
 */
public class Nilai {
     private final String npm;
    private final String nama;
    private final int tugas;
    private final int uts;
    private final int uas;
    
    public Nilai(String npm, String nama, int tugas, int uts, int uas) {
        this.npm = npm;
        this.nama = nama;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
}
     public String getNpm() { return npm; }
    public String getNama() { return nama; }
    public int getTugas() { return tugas; }
    public int getUts() { return uts; }
    public int getUas() { return uas; }
    
    private int totalSkala10() {
        return 3 * tugas + 3 * uts + 4 * uas;
    }

    public double getNilaiAkhir() {
        return totalSkala10() / 10.0;
    }

    public String getHuruf() {
        int t = totalSkala10();
        if (t >= 800) return "A";
        if (t >= 750) return "B+";
        if (t >= 700) return "B";
        if (t >= 650) return "C+";
        if (t >= 600) return "C";
        if (t >= 400) return "D";
        return "E";
    }
}


