public class Lab1 {
    public static void main(String args[]) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
    }
    void compulsory() {
        //Display on the screen the message
        System.out.println("Hello World!");

        //Define an array of strings languages
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for(String i : languages)
            System.out.println(i);

        //Generate a random integer
        int n = (int) (Math.random() * 1_000_000);
        System.out.print("n=");
        System.out.println(n);

        //!!binar si hexa folosim cu parsari
        //multiply n by 3;
        int result;
        result=n*3;
        //add the binary number 10101 to the result;
        //result=result+0b10101;
        result = Integer.parseInt("0b10101",2);
        //add the hexadecimal number FF to the result;
        //result=result+0xFF;
        result = Integer.parseInt("0xFF",16);
        //multiply the result by 6;
        result=result*6;
        System.out.print("result=");
        System.out.println(result);

        //Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
        int sum=0;
        while(result>0 || sum>9) {
            if (result == 0) {
                result = sum;
                sum = 0;
            }
            sum += result % 10;
            result /= 10;
        }
        System.out.print("sum=");
        System.out.println(sum);

        //Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result]
        String sir="Willy-nilly, this semester I will learn ";
        sir=sir+languages[sum];
        System.out.println(sir);


    }
    void homework() {
//Do stuff
    }
    void bonus() {
//Do stuff
    }
}