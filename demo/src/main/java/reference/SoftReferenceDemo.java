package reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static void enoughMemory(){
        Object a = new Object();
        SoftReference<Object> b = new SoftReference<>(a);
        System.out.println(b.get());
        a = null;
        System.gc();

        try{

        }catch (Exception e){

        }finally {

        }

    }


}
