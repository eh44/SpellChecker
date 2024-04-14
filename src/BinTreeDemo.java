public class BinTreeDemo{

    public static void main(String[] args){

        BinarySearchTree1 myTree = new BinarySearchTree1();



        for(int i=0; i< 20; ++i)

            myTree.insert((int)(Math.random()*100));



        myTree.display();



        if(myTree.search(42)){

            System.out.println("found it.");

        }else{

            System.out.println("did not find it.");

        }

    }

}





