package design;

/**
 * @desc：TODO
 * @date：2021/1/25 下午9:56
 * @author：Lujs
 */
public class Singel {

    public final static Singel a = new Singel();

    private Singel(){

    }

    public static void main(String[] args) {
        Singel a = Singel.a;
        Singel b = Singel.a;
        System.out.println(a==b);
    }
}
