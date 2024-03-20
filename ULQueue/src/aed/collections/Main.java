package aed.collections;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ULLQueue K = new ULLQueue();


          //---------------------- Enqueue()- Inicio    -------------------------------------//


        K.enqueue(809);
        K.enqueue(810);
        K.enqueue(811);
        K.enqueue(812);
        //K.enqueue(813);
        //K.enqueue(26);
         //K.enqueue(815);
         //K.enqueue(816);

        K.print();
        /*  //---------------------- Enqueue()- Fim    -------------------------------------//

       /*  //---------------------- Dequeue()- Inicio   -------------------------------------//

       //System.out.println("dequeue: " + K.dequeue());
       //System.out.println("dequeue: " + K.dequeue());
         */


       /*  //---------------------- Dequeue()- Fim    -------------------------------------//



        /*  //---------------------- Peek()- Inicio    -------------------------------------//

        //System.out.println("Peek: " + K.peek());



        //---------------------- Peek()- Fim    -------------------------------------//


*/        //---------------------- Iterador()- Inicio-------------------------------------//

        Iterator M = K.iterator();
        while(M.hasNext() ){
            System.out.println("Iterator: " + M.next());
        }


       //---------------------- Iterador()- Fim    -------------------------------------//

     /*  //---------------------- Variaveis gerais()- Inicio    -------------------------------------//

        System.out.println("Tamanho: " + K.size());

    /*  //---------------------- Variaveis gerais()- Fim    -------------------------------------//

     /*  //---------------------- ShallowCopy()- Inicio    -------------------------------------//


      ULLQueue B = (ULLQueue) K.shallowCopy();
        B.print();


     /*  //---------------------- ShallowCopy()- Fim    -------------------------------------//


/* ------------------- Forma de dar o print feita por mim
        System.out.print("Print: " );
        K.print();
*/





    }
}
