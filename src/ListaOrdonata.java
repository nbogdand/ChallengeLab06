import java.util.List;

public class ListaOrdonata implements Lista {

    // current size of vector
    int auxDim = 1;

    // index of last added element
    int lastElement = 0;


    int[] vector = new int[auxDim];



    @Override
    public void addElement(int element) {

        // if there is enough space in vector
        // to add a new element
        if((lastElement + 1 + 1) <= auxDim){

            //  System.out.println("am suficienta memorie, size=" + vector.length + " element=" + element);

            // position of the new element (ex: element = 27)
            //
            // 1 3 5 11 21 22 23 25 32 33 35 0 0 0 0 0
            //                      ^
            //                      |
            //                    index
            //
            // element should be placed after 25,
            // so we need to shift everything 1 position to the
            // right and insert the element right after 25 and
            // before 32

            insertElementInOrder(element);

            System.out.println("dupa inserare : lastEl=" + lastElement + " size=" +auxDim );

        }else



            // if there is no more space available in the current
            // vector we need to create a new one and change the
            // class reference to it

            if( (lastElement + 1 + 1) > auxDim){

                //    System.out.println(" !NU! am suficienta memorie, size=" + vector.length + " element=" + element);


                // increase the size of the vector by 25%
                if(auxDim/4 != 0) {
                    auxDim += auxDim / 4;
                }else {
                    auxDim++;
                }


                int[] newVector = new int[auxDim];

                System.arraycopy(vector,0,newVector,0,vector.length);

                vector = newVector;

                insertElementInOrder(element);

            }
    }

    @Override
    public boolean removeElement(int element) {

        int i = 0;
        boolean found = false;

        for( i = 0 ; i < lastElement; i++){
            if(vector[i] == element){
                found = true;
                break;
            }
        }

        for ( ; i < lastElement - 1; i++){
            vector[i] = vector[i+1];
        }

        if(found) {
            lastElement--;
            shrinkVectorIfNeeded();
        }


        return found;
    }

    @Override
    public int removeAll(int element) {

        int numberOfRemovals = 0;
        int nr = 0;

        for(int i = 0; i < lastElement; i++){
            if(vector[i] == element) {
                numberOfRemovals++;
            }
        }

        nr = numberOfRemovals;
        while (nr != 0){
            removeElement(element);
            nr--;
        }

        return numberOfRemovals;
    }

    @Override
    public int get(int index) {
        return vector[index];
    }

    @Override
    public void print() {
        for(int i = 0; i < lastElement; i++){
            System.out.print(vector[i] + " ");
        }
    }

    @Override
    public int size() {
        return lastElement;
    }


    private void insertElementInOrder(int element){

        int index = 0;

        for(int i = 0; i < vector.length ; i++){
            if(vector[i] >= element || vector[i] == 0){
                index = i;
                break;
            }
        }

        for(int i = vector.length - 1; i > index; i-- ){
            vector[i] = vector[i-1];
        }

        vector[index] = element;

        lastElement++;
    }

    private void shrinkVectorIfNeeded(){
        if(lastElement <= auxDim / 2 ){
            int[] newVector = new int[auxDim/2];
            auxDim /= 2;
            System.arraycopy(vector,0,newVector,0,lastElement);

            vector = newVector;
            //      System.out.println("am aplicat shrink !");
        }
    }
}
