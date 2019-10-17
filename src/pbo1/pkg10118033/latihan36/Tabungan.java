package pbo1.pkg10118033.latihan36;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Tabungan {

    double saldoAwal, saldoTarget, bunga;
    int bulan;

    public Tabungan(double saldoAwal, double saldoTarget, double bunga) {
        this.saldoAwal = saldoAwal;
        this.saldoTarget = saldoTarget;
        this.bunga = bunga;
    }

    public String formatting(double saldo) {
        DecimalFormat Idr = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols RP = new DecimalFormatSymbols();
        RP.setCurrencySymbol("Rp. ");
        RP.setMonetaryDecimalSeparator(',');
        RP.setGroupingSeparator('.');
        Idr.setDecimalFormatSymbols(RP);
        return Idr.format((int) saldo).replaceAll(",00", "");
    }

    public void hitung() {
        while (saldoAwal < saldoTarget) {
            saldoAwal += saldoAwal * bunga;
            System.out.println("Saldo di bulan ke-" + (++bulan) + formatting(saldoAwal));
        }
    }
}
