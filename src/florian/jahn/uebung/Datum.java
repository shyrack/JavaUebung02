package florian.jahn.uebung;

public class Datum {

    public static final int[] monatslaengen = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int tag, monat, jahr;

    public Datum(int tag, int monat, int jahr) {

        if ((monat < 1) || (monat > 12)) {

            throw new InvalidDateException("Der eingegebene Monat ist ungültig!");
        } else if ((tag < 1) || (tag > Datum.monatslaengen[monat - 1])) {
            if ((monat != 2)) {

                throw new InvalidDateException("Der eingegebene Tag ist ungültig!");
            } else if (tag > 29) {
                throw new InvalidDateException(("Der eingegebene Tag ist ungültig!"));
            }
        } else if ((jahr < 1800) || (jahr > 2100)) {

            throw new DateOutOfRangeException("Das eingegebene Jahr ist ungültig!");
        }

        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public static int getMonatslaenge(int monat, int jahr) {

        if ((monat < 1) || (monat > 12)) {

            throw new InvalidDateException("Der eingegebene Tag ist ungültig!");
        } else if ((jahr < 1800) || (jahr > 2100)) {

            throw new DateOutOfRangeException("Das eingegebene Jahr ist ungültig!");
        } else if ((monat == 2) && (Datum.isSchaltjahr(jahr))) {

            return 29;
        } else {

            return Datum.monatslaengen[monat - 1];
        }
    }

    public static boolean isSchaltjahr(int jahr) {

        if ((jahr < 1800) || (jahr > 2100)) {

            throw new DateOutOfRangeException("Das eingegebene Jahr ist ungültig!");
        }

        return (jahr % 4 == 0) && ((jahr % 100 != 0) || (jahr % 400 == 0));
    }

    public boolean equals(Datum a) {

        return ((this.tag == a.tag) && (this.monat == a.monat) && (this.jahr == a.jahr));
    }

    public boolean isGleicherTag(Datum a) {

        return ((this.tag == a.tag) && (this.monat == a.monat));
    }

    @Override
    public String toString() {

        return this.tag + "." + this.monat + "." + this.jahr;
    }

    public Datum morgen() {

        if (this.tag + 1 > Datum.monatslaengen[this.monat - 1]) {

            if ((this.monat == 2) && (Datum.isSchaltjahr(this.jahr))) {

                return new Datum(this.tag + 1, this.monat, this.jahr);
            }

            if (this.monat + 1 > 12) {

                if (this.jahr + 1 > 2100) {

                    throw new DateOutOfRangeException("Das Jahr ist zu groß geworden!");
                } else {

                    return new Datum(1, 1, this.jahr + 1);
                }
            } else {

                return new Datum(1, this.monat + 1, this.jahr);
            }
        } else {

            return new Datum(this.tag + 1, this.monat, this.jahr);
        }
    }

    public Datum gestern() {

        if (this.tag - 1 < 1) {

            if ((this.monat == 3) && (isSchaltjahr(this.jahr))) {

                return new Datum(Datum.monatslaengen[monat - 2] + 1, this.monat - 1, this.jahr);
            }

            if (this.monat - 1 < 1) {

                if (this.jahr - 1 < 1800) {

                    throw new DateOutOfRangeException("Das Jahr ist zu klein geworden!");
                } else {

                    return new Datum(Datum.monatslaengen[11], 12, this.jahr - 1);
                }
            } else {

                return new Datum(Datum.monatslaengen[this.monat - 2], this.monat - 1, this.jahr);
            }
        } else {

            return new Datum(this.tag - 1, this.monat, this.jahr);
        }
    }

}