package aed.collections;

import java.util.Iterator;
import java.util.Random;

public class UnrolledLinkedList<T> implements IList<T> {

    block<T> first;
    block<T> last;
    int size;
    int blocksize_a;
    int numbersofblock;


    public UnrolledLinkedList() {
        first = new block<>(null,blocksize_a);
        this.size = 0;
    }

    public UnrolledLinkedList(int blocksize) {
        this.blocksize_a = blocksize;
        first = new block<>(null,blocksize_a);
        last =  new block<>(null,blocksize_a);
        this.size = 0;
        this.numbersofblock =0 ;
    }

    @SuppressWarnings("unchecked")
    public T[][] getArrayOfBlocks(){
        T[][] K = (T[][]) new Object[numbersofblock+1][blocksize_a]; // T[colunas][linhas]
        block<T> M = first;
        int j = 0;
        while(M != null){
            for (int i = 0; i < M.contador; i++){
                K[j][i] = M.itens[i];
            }
            j++;
            M = M.next;
        }
        return K;
    }

    public boolean check(block<T> K){
        return K.contador == blocksize_a;
    }

    public block<T> mover(block<T> K){
        block<T> M = new block<>(null,blocksize_a);
        int i = blocksize_a/2;
        int p = 0;
        while(i < blocksize_a){
            M.itens[p] = (T) K.itens[i];
            K.itens[i] = null;
            K.contador--;
            i++;p++;
        }
        M.contador = p;
        return M;
    }

    @Override
    public void add(T item) {
        block<T> K = last;
        if(check(K)){
            K.next = new block<>(null,blocksize_a);
            K.next = mover(K);
            K = K.next;
            numbersofblock++;
        }
        if(size < blocksize_a){
            K.itens[K.contador] = item;
            K.contador++;
            first = K;
            last = K;
        } else{
            last = K;
            K.itens[K.contador] = item;
            K.contador++;
        }
        size++;
    }

    public void print() {
        block<T>K = first;
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

    @Override
    public void addAt(int index, T item) {
        block<T> K = first;
        if(index > size){}
        else if(size < blocksize_a){
            T result = null;
            int i = size+1;
            while(i > index){
                K.itens[i] = K.itens[i-1];
                i--;
            }
            result = K.itens[index];
            K.itens[index] = item;
            K.itens[index+1] = result;
            K.contador++;
            size++;
        }
        else if(index == size){add(item);}
    }


    @Override
    public T remove() {
        T result = null;
        if(size != 0){
            result =  last.itens[last.contador-1];
            last.itens[last.contador-1] = null;
            last.contador--;
            if(last.contador == 0){
                block<T> K = first;
                while(K.next != last) {
                    K = K.next;
                }
                last.contador = K.contador;
                last = K;
                last.next = null;
            }
            size--;
        }
        return result;
    }

    public void mover_para_esquerda(int A, block K){
        for(int i = A; i < K.contador-1;i++){
            K.itens[i] = K.itens[i+1];
        }
        K.itens[K.contador-1] = null;
    }

    public int descobrir_index(int K){
        block<T> M =first;
        int v = 0;
        int result = 0;
        return  result;
    }

    @Override
    public T remove(int index) {
        block<T> K = first;
        block<T> P = first; // Vai ser o bloco anterior ao K, vamos utilizar se o bloco estar vazio
        block<T> Y = first;
        block<T> M = first;
        int m = blocksize_a/2; // 2
        T result = null;
        int v = 0;
        int r = 0;
        if(index < size) {
            while(M != null ){
                for (int i = 0; i < M.contador;i++){
                    if(v == index){
                        P = Y;
                        K = M;
                        r = i;}
                    if(M.itens[i] != null){v++;}
                }
                Y = M;
                M = M.next;
            }
            if (size < blocksize_a) {
                result = K.itens[index];
                mover_para_esquerda(index,K);
            } else if (K == last) {
                result = K.itens[(index + K.contador) - size];
                mover_para_esquerda((index + K.contador) - size,K);
            } else {
                result = K.itens[r];
                mover_para_esquerda(r,K);
            }
            K.contador--;
            if(K.contador == 0){
                P.next = K.next;
                numbersofblock--;
            }
            size--;

        }
        return result;
    }



    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        block<T> K = first;
        int m = blocksize_a/2;
        T result = null;
        if(index < size) {
            for (int i = 0; i < (index / m); i++) {
                if (K.next != null) {
                    K = K.next;
                }
            }
            m = index % m;
            if (size < blocksize_a) {
                result = K.itens[index];
            } else if (K == last) {
                result = K.itens[(index + K.contador) - size];
            } else {
                result = K.itens[m];
            }
        }
        return result;
    }

    public void set(int index, T element){
        block<T> K = first;
        int m = blocksize_a/2;
        if(index < size) {
            for (int i = 0; i < (index / m); i++) {
                if (K.next != null) {
                    K = K.next;
                }
            }
            m = index % m;
            if (size < blocksize_a) {
                K.itens[index] = element;
            } else if (K == last) {
                K.itens[(index + K.contador) - size] = element;
            } else {
                K.itens[m] = element;
            }
        }

    }


    @Override
    public IList<T> shallowCopy() {
        UnrolledLinkedList<T> K = new UnrolledLinkedList<>(blocksize_a);
        int i = 0;
        while(i < size){
                K.add(get(i));
                i++;
        }
        return  K;
    }

    @Override
    public Iterator<T> iterator() {
        return new List_Iterator();
    }

    private class List_Iterator implements Iterator<T> {

        block<T> iterator;
        int tamanho;
        int i;

        List_Iterator() {
            iterator = first;
            this.tamanho = size;
            this.i = 0;
        }

        public boolean hasNext() {
            return ((this.iterator != null) && size > 0);
        }

        public T next() {
            T result = null;
            if (size > 0) {
                result = get(i);
                i++;
                if (i == size) {
                    iterator = null;
                }
            }
            return result;
        }
    }

    class block<T> {
        T[] itens;
        block<T> next;
        int contador;

        @SuppressWarnings("unchecked")
        public block (T[] item,int blocksize) {
            itens = (T[]) new Object[blocksize] ;
            this.next = null;
            contador = 0;
        }
    }

}


/*----------------------------- A Função Main -----------------------------------------------------------
    public static void main(String args[]){
        UnrolledLinkedList List_K = new UnrolledLinkedList(16);


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

                //List_K.add(0);
                //List_K.add(1);
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

//System.out.println(Arrays.deepToString(List_K.getArrayOfBlocks()));

//----------------------GetArraysBlock- Fim    -----------------------------//


//----------------------AddAt- Inicio-------------------------------------//


//List_K.addAt(5,23);
//List_K.addAt(11,23);
//List_K.addAt(56,38);

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


    /*  //---------------------- Variaveis gerais()- Fim    -------------------------------------//

     /*  //---------------------- ShallowCopy()- Inicio    -------------------------------------//

        System.out.println("Print copiada: ");
        UnrolledLinkedList B = (UnrolledLinkedList) List_K.shallowCopy();
        B.print();




     /*  //---------------------- ShallowCopy()- Fim    -------------------------------------//
}








*/








