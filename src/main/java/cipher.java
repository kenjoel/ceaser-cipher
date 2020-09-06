public class cipher {
       private static StringBuilder ceaser(String characters, int shift){
        if(shift > 26){
            shift = shift%26;
        }else if(shift < 0){

            shift = (shift%26) + 26;
        }

       ;
        int characterLength = characters.length();
        StringBuilder holder = new StringBuilder();

        for(int i =0; i < characterLength; i++){
            char ch = characters.charAt(i);

            if(Character.isLetter(ch)){
                if( Character.isLowerCase(ch)){
                    char shiftedCharacter = (char)(ch + shift);
                    if(shiftedCharacter > 'z'){
                        holder.append((char) (ch - (26 - shift)));
                    }else{
                        holder.append(shiftedCharacter);
                    }
                }else if( Character.isUpperCase(ch)){
                    char shiftedCharacter = (char)(ch + shift);
                    if(shiftedCharacter > 'Z'){
                        holder.append((char) (ch - (26 - shift)));
                    }else {
                        holder.append(shiftedCharacter);

                    }
                }
            }else{
                holder.append(ch);
            }
        };
        return holder;
    };


    private static StringBuilder decipher(String characters, int shift){
        if(shift > 26){
            shift = shift%26;
        }else if(shift < 0){
            shift = (shift%26) + 26;
        }

        int characterLength = characters.length();
        StringBuilder holder = new StringBuilder();

        for(int i =0; i < characterLength; i++){
            char ch = characters.charAt(i);

            if(Character.isLetter(ch)){
                if( Character.isLowerCase(ch)){
                    char n = (char)(ch - shift);
                    if(n < 'a'){
                        holder.append((char) (ch + (26 - shift)));
                    }else{
                        holder.append(n);
                    }
                }else if( Character.isUpperCase(ch)){
                    char n = (char)(ch - shift);
                    if(n < 'A'){
                        holder.append((char) (ch + (26 - shift)));
                    }else {
                        holder.append(n);
                    }
                }
            }else{
                holder.append(ch);
            }
        };
        return holder;
    };

    public static void main(String[] args){
//        StringBuilder encrypted = ceaser( "Victor kuria ,Juliet Gisemba", 20);
//        System.out.println(encrypted);


        StringBuilder deciphered = decipher("Pcwnil eolcu ,Dofcyn Acmygvu", 20);
        System.out.println(deciphered);



    }



}



/*
BDD
We want to receive a string and cipher its characters by shifting it several characters to the right or left with regards to its position on the alphabet

1. Refractor a method to separate the main class from the rest of the code the method returns a string
2. The method takes two arguments, a string and an integer by which to cipher its characters.
3. Create a variable the will hold the final value of the cipher
4. Loop through the string characters, check whether they are all characters because if they are not characters then we don't need to shift them return them as they are
5. If they are all letters, lets check if they are uppercase or lowercase, this will give us a clarity of their position in the Ascii
6. if letter is lowercase, check if its < the last letter of the alphabet(z) if not, subtract 26 form the shift and cast it;
7. if the letter is uppercase, check if its within the range 65(A) and 90 (Z)
 */