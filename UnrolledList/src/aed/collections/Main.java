package aed.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String args[]) {
        long tempoInicial = System.currentTimeMillis();
        UnrolledLinkedList List_K = new UnrolledLinkedList(512);


        int i = 0;
        while( i <= 100000){
            List_K.add(i);
            i++;
        }
        i = 587;
        while( i <= 687){
            List_K.get(i);
            i++;
        }

        i = 0;
        while( i <= 100){
            List_K.remove();
            i++;
        }



        System.out.println("Size: " + List_K.size);
        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);




        //Eu criei a função print, pois fiz tinha feito primeiro a add e depois é que fiz a get.
        /*public void print() {
            UnrolledLinkedList.block<T> K = first;
            int p = 0;
            while (K != null){
                System.out.print("Block: " + p + "\n");
                for (int i = 0; i< blocksize_a; i++){
                    System.out.print(K.itens[i]);
                    System.out.print(" ");
                }
                System.out.print("\n");
                K = K.next;
                p++;
            }
        }
        */

        //----------------------Add- Inicio-------------------------------------//



        List_K.add(0);
        List_K.add(1);
        //List_K.add(2);
        //List_K.add(3);
        //List_K.add(4);
        //List_K.add(5);
        //List_K.add(6);
        //List_K.add(7);
        //List_K.add(8);
        //List_K.add(9);
        //List_K.add(10);
        //List_K.add(11);
        //List_K.add(12);


        //----------------------Add- Fim-------------------------------------//

        //----------------------GetArraysBlock- Inicio-----------------------------//

       // System.out.println(Arrays.deepToString(List_K.getArrayOfBlocks()));

        //----------------------GetArraysBlock- Fim    -----------------------------//


        //----------------------AddAt- Inicio-------------------------------------//

/*
        List_K.addAt(6,22);
        System.out.println(Arrays.deepToString(List_K.getArrayOfBlocks()));

       // List_K.addAt(10,32);
        System.out.println(Arrays.deepToString(List_K.getArrayOfBlocks()));

       // List_K.addAt(10,38);
        System.out.println(Arrays.deepToString(List_K.getArrayOfBlocks()));
*/

        //----------------------AddAt- Fim-------------------------------------//


  /*      //----------------------Get- Inicio-------------------------------------//
        for (int i = 0; i < List_K.size; i++){
            System.out.print(List_K.get(i));
            System.out.print(" ");
        }
        System.out.print("\n");

   */     //----------------------Get- Fim -------------------------------------//



  /*      //----------------------Set- Inicio-------------------------------------//

         List_K.set(10,10);
         List_K.set(1,10);
         List_K.set(3,10);

  /*      //----------------------Set- Fim-------------------------------------//



  /*      //---------------------- Remove()- Inicio-------------------------------------//

        System.out.println("Remove: " +List_K.remove());
        System.out.println("Remove: " +List_K.remove());
        System.out.println("Remove: " +List_K.remove());
        System.out.println("Remove: " +List_K.remove());
        System.out.println("Remove: " +List_K.remove());

    /*      //---------------------- Remove()- Fim-------------------------------------//





  /*      //---------------------- Remove(int index)- Inicio-------------------------------------//


        //System.out.println("Remove: " +List_K.remove(2));
        //System.out.println("Remove: " +List_K.remove(4));
        //System.out.println("Remove: " +List_K.remove(2));
        //System.out.println("Remove: " +List_K.remove(5));
        //System.out.println("Remove: " +List_K.remove(6));
        //System.out.println("Remove: " +List_K.remove(7));


      /*  //---------------------- Remove(int index)- Fim-------------------------------------//



      /*  //---------------------- Iterador()- Inicio-------------------------------------//


        Iterator M = List_K.iterator();
        while(M.hasNext() ){
            System.out.println("Iterator: " + M.next());

      /*  //---------------------- Iterador()- Fim    -------------------------------------//

     /*  //---------------------- Variaveis gerais()- Inicio    -------------------------------------//


        System.out.println("\nBlocksize: " + List_K.blocksize_a);
        System.out.println("Numbers_of_block: " + List_K.numbersofblock);
        System.out.println("Size: " + List_K.size());


      //---------------------- Variaveis gerais()- Fim    -------------------------------------//

      //---------------------- ShallowCopy()- Inicio    -------------------------------------//
*//*
        System.out.println("Print copiada: ");
        UnrolledLinkedList B = (UnrolledLinkedList) List_K.shallowCopy();
        System.out.println(Arrays.deepToString(B.getArrayOfBlocks()));

        System.out.println(Arrays.deepToString(List_K.getArrayOfBlocks()));

*/



        //---------------------- ShallowCopy()- Fim    -------------------------------------//



}
}
