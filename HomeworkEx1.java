import java.security.PublicKey;

public class HomeworkEx1 {
   public int kReductibil;
   public int Numar;
   public int a;
   public int b;
   public  String list;
   //A number is k-reductible if it can be reduced to the value k by adding each of its digits, multiplied by itself, repeatedly. For example 13 is 1-reductible since 1*1 + 3*3 = 10 and 1*1 + 0*0=1.
    public HomeworkEx1(int kReductibil,int Numar){
        this.kReductibil=kReductibil;
        this.Numar=Numar;
    }
    public HomeworkEx1(int kReductibil,int a,int b){
        this.kReductibil=kReductibil;
        this.a=a;
        this.b=b;
    }
    public boolean esteReductibil(){
        int rezultat=0;
         while (Numar != 0){
             rezultat=0;
             while(Numar!=0){
                 rezultat += (Numar%10) * (Numar%10);
                 Numar=Numar/10;
             }
             if(rezultat >= 9){
                 Numar=rezultat;
             }
         }
        // System.out.println(rez);
        return rezultat == kReductibil;
     }
//    Write a program that finds all k-reductible numbers in a given interval [a,b]. The values a,b,k are given as command line argumens. Validate them.

    public void esteValid(){

        while(a<=b){
            HomeworkEx1 ex = new HomeworkEx1(kReductibil,a);

            boolean valid = ex.esteReductibil();
            System.out.println("Numarul " + a + " este " + valid);

//    Create a String that contains the identified numbers and display it on the screen.
            if(list == null){
                list = String.valueOf(a);
            }else {
                list = list + " " + String.valueOf(a);
            }
            a++;
        }

    }

}
