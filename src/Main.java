public class Main {
    private static final double EPS = 1e-5;

//@Efimov DA
    public static void main(String[] args) {


        Func1_1 f1 = new F1();
        System.out.println("inner class: "+ math(f1, 0.01, 2, EPS));


        Func1_1 f2 = new Func1_1() {
            public double f(double x) {
                return Math.sin(x) - 0.75;
            }
        };
        System.out.println("anon class: "+math(f2, 2, 3, EPS));

        Func1_1 f3 = Func1_1::staticMeth;
        System.out.println("static method: "+math(f3, 1, 3, EPS));

        Func1 func14 = new Func1();
        Func1_1 f4 = func14::tang;
        System.out.println("method reference: "+math(f4, 2, 4, EPS));


    }

    public static double math(Func1_1 func11, double l, double r, double eps) {
        while((r - l) > eps) {
            double a = (l + r) / 2;
            if(func11.f(a) == 0)
                return a;
            if(func11.f(l) < 0 && func11.f(a) < 0
                    || func11.f(l) > 0 && func11.f(a) > 0)
                l = a;
            else if(func11.f(a) < 0 && func11.f(r) < 0
                    || func11.f(a) > 0 && func11.f(r) > 0)
                r = a;
        }
        return l;
    }
    }


     class F1 implements Func1_1 {
        @Override
        public double f(double x) {
            return Math.exp(-x) - 0.5;
        }
    }

