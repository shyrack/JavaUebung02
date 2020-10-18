package florian.jahn.uebung;

public class Test {

    public static void main(String[] args) {

        Datum d0 = new Datum(29, 2, 2020);
        Datum d1 = new Datum(29, 2, 2020);
        Datum d2 = new Datum(1, 3, 2020);
        Datum d3 = new Datum(31, 12, 2020);

        System.out.println(d0.equals(d1));
        System.out.println(d2.gestern().toString());
        System.out.println(d3.morgen().toString());
    }

}