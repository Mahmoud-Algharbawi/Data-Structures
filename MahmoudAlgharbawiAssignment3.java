import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")

/**
 *
 * @author Mahmoud Algharbawi
 */
public class MahmoudAlgharbawiAssignment3{
    static File inputFile = new File("Assignment3Data.txt");


    // Main method.
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner (inputFile);

        // Create array lists to store the file data.
        ArrayList <String> City1 = new ArrayList<>(); 
        ArrayList <String> City2 = new ArrayList<>(); 
        ArrayList <String> Distance = new ArrayList<>(); 

        // Read the file data and store it in 3 different arraylists 
        // In each line, the three types are seperated by tabs.
        while (in.hasNext())
        {
            String curLine = in.nextLine();
            String[] splitted = curLine.split("\t");
            String C = splitted[0];
            String c = splitted[1];
            String d = splitted[2];
                
            City1.add(C);
            City2.add(c);
            Distance.add(d);
        }


        System.out.print("\n\n");


        // Create a binary search tree for distance.
        MahmoudAlgharbawiBinarySearchTree<String> MyMahmoudBST = new MahmoudAlgharbawiBinarySearchTree();
        for (String d: Distance)
            MyMahmoudBST.insert(d);
        
        // Traverse tree and printing combinations
        System.out.println("Binary Search Tree:");
        printTreeCombinations(MyMahmoudBST);

        // Search for an element
        System.out.print("\n\nChecking if 1998 is in the tree: " );
        if (MyMahmoudBST.search("1998"))
            System.out.print("Yes");
        else
            System.out.print("No");
        
        // Get a path from the root to 549
        System.out.print("\n\nA path from the root to 549 is: ");  
        java.util.ArrayList < MahmoudAlgharbawiBinarySearchTree.TreeNode<String> > path = MyMahmoudBST.path("549");
        for ( int i=0; path != null && i< path.size(); i++ )
            System.out.print( path.get(i).element + " " );


        System.out.print("\n\n");


        // Create an AVL tree
        MahmoudAlgharbawiAVLTree<String> MyMahmoudAVLT = new MahmoudAlgharbawiAVLTree();
        for (String d: Distance)
            MyMahmoudAVLT.insert(d);

        System.out.println("AVL Tree:");
        // Add elements then print the tree.
        MyMahmoudAVLT.insert("100");
        MyMahmoudAVLT.insert("200");
        System.out.print("\nAfter inserting 100 and 200: ");
        printTreeCombinations(MyMahmoudAVLT);

        // Delete elements then print the tree.
        MyMahmoudAVLT.delete("100");
        MyMahmoudAVLT.delete("200");
        System.out.print("\nAfter removing 100 and 200: ");
        printTreeCombinations(MyMahmoudAVLT);

        // Add 5 then print the tree.
        MyMahmoudAVLT.insert("5");
        System.out.print("\nAfter inserting 5: ");
        printTreeCombinations(MyMahmoudAVLT);

        //deleting 5 then print tree
        MyMahmoudAVLT.delete("5");
        System.out.print("\nAfter removing 5: ");
        printTreeCombinations(MyMahmoudAVLT);

        // Traverse the tree.
        System.out.print("\nTraversing elements: ");
        for (String s: MyMahmoudAVLT)
            System.out.print(s + " ");


        System.out.print("\n\n");


        // Create a hashset
        java.util.Collection<String> MyMahmoudHS = new MahmoudAlgharbawiHashSet();

        // Add elements of City1 to the hashset.
        for (String s: City1)
            MyMahmoudHS.add(s);

        System.out.println("Hashset: ");
        // Print elements of the hashset.
        System.out.println("Elements in hashset: " + MyMahmoudHS );

        // Print size of the hashset.
        System.out.println("\nThe number of elements in the hashset: " + MyMahmoudHS.size());

        // Check if the set contains Albuquerque
        System.out.print("\nChecking if Albuquerque is in the hashset: " );
        if (MyMahmoudHS.contains("Albuquerque"))
            System.out.print("It is in the hashset");
        else
            System.out.print("It is not in the hashset");

        // Remove Albuquerque and print the set elements in upper case.
        MyMahmoudHS.remove("Albuquerque");
        System.out.print("\n\nHashset in upper case: ");
        for (String s: MyMahmoudHS)
            System.out.print(s.toUpperCase() + " ");
        
        // Clear the set and print it.
        MyMahmoudHS.clear();
        System.out.println("\nElements in hashset after clearing: " + MyMahmoudHS );


        System.out.print("\n\n");


        // Create a map
        MahmoudAlgharbawiMap<String, String> MyMahmoudHM = new MahmoudAlgharbawiHashMap();
        System.out.println("HashMap: ");
        // Add items from City2 and Distance to the map.
        for(int i=0; i<Distance.size(); i++)
        {
            String d = Distance.get(i);
            String c = City2.get(i);
            MyMahmoudHM.put(d,c);
        }

        // Print entries of the map.
        System.out.println("Entries in map: " + MyMahmoudHM);

        // Check if the key 200 is in the map.
        System.out.print("\nChecking if the distance 200 is in the map:  "); 
        if (MyMahmoudHM.containsKey("200"))
            System.out.print("It is in the map");
        else
            System.out.print("It is not in the map");

        // Find the value corresponding to 2690.
        System.out.println("\nThe value corrsponding to 2690 is: " 
            + MyMahmoudHM.get("2690"));

        // Check if Dallas in the map.
        System.out.print("\nChecking if Dallas is in the map:  "); 
        if ( MyMahmoudHM.containsValue("Dallas"))
            System.out.print("It is in the map.");
        else
            System.out.print("It is not in the map.");
            
        // Remove Jackson from the map.
        MyMahmoudHM.remove("Jackson");
        System.out.println("\n\nRemoving Jackson: " + MyMahmoudHM );
        
        // Clear the map.
        MyMahmoudHM.clear();
        System.out.println("\nClearing the map: " + MyMahmoudHM) ;


        System.out.print("\n\n\n");

       
        // Create an empty unweighted graph.
        MahmoudAlgharbawiUnweightedGraph<String> MyMahmoudUG = new MahmoudAlgharbawiUnweightedGraph();
        //printing the size of an empty graph
        System.out.println("\nThe number of vertices in graph: " + MyMahmoudUG.getSize());
        
        MyMahmoudUG.printEdges();

        
    }


    //A method to print the AVLTREE combinations
    public static void printTreeCombinations (MahmoudAlgharbawiBinarySearchTree tree)
    {
        System.out.print("\nInorder: ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.println("\n\nNumber of nodes: " + tree.getSize());
    }   
}

