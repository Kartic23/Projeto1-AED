package aed.collections;

import java.util.Iterator;


public class ULLQueue<T>  implements IQueue<T> {

    No<T> primeiro; // o primeiro elemento será um nó
    No<T> ultimo;  // o ultimo elemento será um nó
    int tamanho; // tamanho da lista

    public ULLQueue(){
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;}


    //Coloca um item no início da fila
    public void enqueue(T item){
        No<T> K = new No<T>(item);
        if(this.primeiro == null )
        {
            this.primeiro = K;
            this.ultimo = K;
        }
        else {
            K.seguinte = primeiro;
            this.primeiro = K;
        }
        tamanho++;
    }

    //Remove e retorna o item no fim da fila.
    // Caso a fila esteja vazia deverá retornar null
    public T dequeue(){
        T item = null;
        if(this.tamanho > 2) {
            No<T> K = this.primeiro;
            item = this.ultimo.item; // é o nosso ultimo element
            for (int i = 0; i < this.tamanho - 2; i++) {
                K = K.seguinte;
            }
            this.ultimo.item = K.item;
            this.ultimo.seguinte = null;
            tamanho--;
        }
        else if(tamanho == 1){
            item = this.primeiro.item;
            this.primeiro = null;
            this.ultimo = null;
            tamanho--;
        }
        else if(tamanho == 2){
            item = this.ultimo.item;
            this.primeiro.seguinte = null;
            this.ultimo = null;
            tamanho--;
        }

        return item;
    }

    public void print(){
        No K = this.primeiro;
        for (int i = 0; i < this.tamanho; i++){
            if(K.seguinte != null) {
                System.out.println(K.item);
                K = K.seguinte;
            }
            else if(K.seguinte == null){
                System.out.println(K.item);
            }
        }
    }

    //Devolve o tamanho (número de elementos) da fila
    public int size(){return this.tamanho;}




    //Retorna true se a fila estiver vazia e false caso contrário
    public boolean isEmpty(){
        boolean A = false;
        if(tamanho == 0){A = true;}
        return A;
    }

    //Retorna o item no fim da fila, mas não o remove.
    //Retorna null caso a fila esteja vazia
    public T peek(){
        T item = null;
        if(this.tamanho > 0){
            item = this.ultimo.item;
        }
        return item;
    }

    public void enqueue_for_copy(T item) {
        No<T> K = new No<T>(item);
        K.seguinte = null;
        if(this.primeiro == null) {
            this.primeiro = K;
            this.ultimo = K;
        }
        else {
            this.ultimo.seguinte = K;
            this.ultimo = K;
        }
        tamanho++;
    }



    public IQueue<T> shallowCopy() {
        ULLQueue<T> copy = new ULLQueue<>();
        No<T> K = primeiro;
        for (int i = 0; i < this.tamanho; i++){
            if(K.seguinte != null){
                copy.enqueue_for_copy(K.item);
                K =  K.seguinte;
            }
            else {
                copy.enqueue_for_copy(K.item);
            }
        }
        return copy;
    }


    public Iterator<T> iterator() {
        return new QueueuIterator();
    }

    private class QueueuIterator implements Iterator<T>{
        No<T> iterator;
        int size;
        QueueuIterator(){
            this.iterator = primeiro;
            this.size = tamanho;
        }

        public boolean hasNext(){
            return (this.iterator != null);
        }

        public T next(){
            int i = 0;
            while (i < size-1) { // Vai até ao último elemento do size-2
                this.iterator = this.iterator.seguinte;
                i++;
            }
            T result = iterator.item;
            this.iterator = primeiro;
            size--;
           if(size == 0){iterator = ultimo.seguinte;}
           return result;
        }
    }

    class No<T> {
        T item;
        No<T> seguinte;
        public No(T novoItem) {
            this.item = novoItem;
            this.seguinte = null;
        }
    }


}

/*
    public static void main(String[] args) {
        ULLQueue K = new ULLQueue();


        /*  //---------------------- Enqueue()- Inicio    -------------------------------------//


        K.enqueue(809);
        K.enqueue(810);
        K.enqueue(811);
        K.enqueue(812);
        //K.enqueue(813);
        //K.enqueue(26);
         //K.enqueue(815);
         //K.enqueue(816);



        /*  //---------------------- Enqueue()- Fim    -------------------------------------//

       /*  //---------------------- Dequeue()- Inicio   -------------------------------------//

       //System.out.println("dequeue: " + K.dequeue());
       //System.out.println("dequeue: " + K.dequeue());
         */


       /*  //---------------------- Dequeue()- Fim    -------------------------------------//



        /*  //---------------------- Peek()- Inicio    -------------------------------------//

        //System.out.println("Peek: " + K.peek());



      /*  //---------------------- Peek()- Fim    -------------------------------------//


      /*  //---------------------- Iterador()- Inicio-------------------------------------//

        Iterator M = K.iterator();
        while(M.hasNext() ){
            System.out.println("Iterator: " + M.next());
        }


      /*  //---------------------- Iterador()- Fim    -------------------------------------//

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












