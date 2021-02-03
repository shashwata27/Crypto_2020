import java.util.Scanner;

public class Crypto {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the DATA to be Encrypted ");
        String data=input.nextLine();
        System.out.print("Enter the Shift value to be used for Encryption ");
        int shift=input.nextInt();
        int actualshift=(int)(Math.sqrt(Math.pow(shift,Math.PI)+Math.sqrt(shift)));
        System.out.print("Enter the number in which grouping is to be done ");
        int breakinto=input.nextInt();

        String Ndata=NormalizeText(data);
        //System.out.println(Ndata);

        String Odata=Obify(Ndata);
        //System.out.println(Odata);

        String Edata=caesarify(Odata,actualshift);
        //System.out.println(Edata);

        String EGdata=groupify(Edata,breakinto);
        System.out.println();
        System.out.println("Encryption Sucessfull !!!");
        System.out.print(EGdata);

    }

    public static String NormalizeText(String data){

        String NoSpecialC=data.replaceAll("[^a-zA-Z0-9]", "");//replaces anything but a to z, A to Z,0to9 with empty string
        return NoSpecialC.toUpperCase();
    }

    public static String Obify(String Ndata) {
        String vowels = "AEIOUY";
        String Odata = "";//after obifying data

        for (int i = 0; i < Ndata.length(); i++) {
            if (vowels.contains(Character.toString(Ndata.charAt(i)))) {//charecter:another class in java just as Math
                Odata = Odata + "OB" + Character.toString(Ndata.charAt(i));//Returns a String type object which represents the specified character

            } else {
                Odata = Odata + Character.toString(Ndata.charAt(i));
            }
        }
        return Odata;
    }

    public static String caesarify(String Odata, int key){
        String Edata="";

        for (int i=0; i<Odata.length(); i++)
        {
            if (Character.isUpperCase(Odata.charAt(i)))//Determines whether the given character is an uppercase character or not.

            {
                char ch = (char)(((int)Odata.charAt(i) +
                        key - 65) % 26 + 65);//65 is value of A and 97 value of a
                Edata=Edata+ch;
            }
            else
            {
                char ch = (char)(((int)Odata.charAt(i) +
                        key - 97) % 26 + 97);
                Edata=Edata+ch;
            }
        }
        return Edata;
    }

    /*public static String caesarify(String Odata,int key){

        String Edata="";

        for(int i=0;i<Odata.length();i++)
        {
            int adshift=(int)Odata.charAt(i);
            int shift=adshift+key;
            char temp=shiftAlphabet(shift);


            Edata=Edata+temp;
        }
        return Edata;
    }

    public static char shiftAlphabet(int shift) {
        char result=(char) shift;
        return result;
    }*/

   public static String groupify(String Edata,int breakinto){
        int Xed=Edata.length()%breakinto;
        String EGdata="";
        for(int i=0;i<Xed;i++){
           Edata=Edata+'x';
       }
        for (int i=0;i<Edata.length();i++){

            if(i%breakinto==0 & i!=0){
                EGdata=EGdata+" ";
            }

            EGdata=EGdata+Edata.charAt(i);
        }

        return EGdata;
   }

}
