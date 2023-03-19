public class ShapeCleint {
    public static void main(String[] args) {


        Shape a = new Shape("0 0 0 1 1 1 1 0");
        Shape b = new Shape("10 10 10 11 11 11 11 10");
        Shape c = new Shape("0.5 0.5 0.5 -10 1.5 0");
        Shape d = new Shape("0.5 0.5 0.75 0.75 0.75 0.2");

        boolean check1 = a.crosses(b);
        boolean check2 = a.crosses(c);
        boolean check3 = a.crosses(d);

        System.out.println("a crosses b:" + check1);
        System.out.println("a crosses c:" + check2);
        System.out.println("a crosses d:" + check3);
        System.out.println("a encircles b:" + a.encircles(b));
        System.out.println("a encircles c:" + a.encircles(c));
        System.out.println("a encircles d:" + a.encircles(d));
    }



}
