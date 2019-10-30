package ba.unsa.etf.rpr.tutorijal02;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Interval {

    private double pocetak, kraj;
    private boolean pripada1, pripada2;

    public Interval(double int1, double int2, boolean pripada1, boolean priprada2) {
        pocetak=int1;
        kraj=int2;
        if(int1>int2) throw new IllegalArgumentException("Pocetna tacka veca od kajnje");
        this.pripada1=pripada1;
        this.pripada2=priprada2;
    }
    public Interval() {
        pocetak=0;
        kraj=0;
        pripada1=false;
        pripada2=false;
    }
    public boolean isNull () {
        if(pocetak==0 && kraj==0 && pripada1==false && pripada2==false) return true;
        return false;

    }
    public boolean isIn(double tacka) {
        if(pripada1 && pripada2)
            if(tacka>=pocetak && tacka<=kraj) return true;
        if(pripada1 && !pripada2)
            if(tacka>=pocetak && tacka<kraj) return true;
        if(!pripada1 && pripada2)
            if(tacka>pocetak && tacka<=kraj) return true;
        if(!pripada1 && !pripada2)
            if(tacka>pocetak && tacka<kraj) return true;
        return false;
    }
    public Interval intersect(Interval interval) {
        Interval rezultat = new Interval();
        if(pocetak <= interval.pocetak) {
            rezultat.pocetak=interval.pocetak;
            rezultat.pripada1 = interval.pripada1;
        }
        if(pocetak > interval.pocetak) {
            rezultat.pocetak=pocetak;
            rezultat.pripada1 = pripada1;
        }
        if(kraj >= interval.kraj) {
            rezultat.kraj=interval.kraj;
            rezultat.pripada2 = interval.pripada2;
        }
        if(kraj < interval.kraj) {
            rezultat.kraj=kraj;
            rezultat.pripada2 = pripada2;
        }
        return rezultat;
    }
    public static Interval intersect (Interval interval1, Interval interval2) {
        Interval rez = new Interval();
        if(interval1.pocetak <= interval2.pocetak) {
            rez.pocetak=interval2.pocetak;
            rez.pripada1=interval2.pripada1;
        }
        if(interval1.pocetak > interval2.pocetak) {
            rez.pocetak = interval1.pocetak;
            rez.pripada1 = interval1.pripada1;
        }
        if(interval1.kraj >= interval2.kraj) {
            rez.kraj = interval2.kraj;
            rez.pripada2 = interval2.pripada2;
        }
        if(interval1.kraj < interval2.kraj) {
            rez.kraj = interval1.kraj;
            rez.pripada2 = interval1.pripada2;
        }
        return rez;
    }


    @Override
    public String toString() {

        if(pripada1 && pripada2) return "[" + pocetak + "," + kraj + "]";
        else if(!pripada1 && pripada2) return "(" + pocetak + "," + kraj + "]";
        else if(pripada1 && !pripada2) return "[" + pocetak + "," + kraj + ")";
        else  return "(" + pocetak + "," + kraj + ")";

    }
    @Override
    public boolean equals ( Object objekat) {
        if(pocetak==(((Interval)objekat).pocetak) && kraj==(((Interval)objekat).kraj) &&
                pripada1==(((Interval)objekat).pripada1) && pripada2==(((Interval)objekat).pripada2))
        return true;
        else return false;

    }


}
