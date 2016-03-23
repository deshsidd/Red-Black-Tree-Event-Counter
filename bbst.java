/*
class bbst
contains public static void main. Main program flow starts from here.
conatains all the unit test functions .





*/

import java.io.*;
import java.util.*;

public class bbst implements Sentinel{

	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		long endTime;

		if(args.length!=1) //incorrect arguments found
		{
			System.out.println("Usage : java Main <filename>");
			return;
		}

		String filename=args[0];
		String line = null;
		String firstline=null;
		int n=0;

		
        try 
        {






            // FileReader reads text files in the default encoding.
            FileReader fr = new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader br = new BufferedReader(fr);
            
            //get the first line in file(number of nodes to be inserted)
            firstline=br.readLine();
            n=Integer.parseInt(firstline);
            
            //arrays to store and handle input
            String arr[];
            int store[][]=new int[n][2];

            //puting input into 2-D array
            for(int i=0;i<n;i++)
            {
            	arr=br.readLine().split(" ");
            	int id=Integer.parseInt(arr[0]);
            	int c=Integer.parseInt(arr[1]);
            	store[i][0]=id;
            	store[i][1]=c;
            	//System.out.println("Node : "+ i+1 + " inserted.");
            }
            //store now contains all the input data
            
            //initiatizing red black tree
            RedBlackTree rbt=new RedBlackTree();
            //generating the RBT in O(n) time
            Node r=rbt.genTree(store,0,n-1,nil);
            rbt.root=r;

            //rbt.prettyPrint();

            //code to read the command.txt file from stdin
            Scanner sc=new Scanner(System.in);
            String func="";
            int arg1=-1;
            int arg2=-1;
			func=sc.next();
            while(func!="quit")
            {
            	
            	switch(func)
            	{
            	case "increase":arg1=sc.nextInt();
            					arg2=sc.nextInt();
            					rbt.Increase(arg1, arg2);
            					break;
            		
            	case "reduce":  arg1=sc.nextInt();
								arg2=sc.nextInt();
								rbt.Reduce(arg1, arg2);
								break;
								
            	case "count":	arg1=sc.nextInt();
            					rbt.Count(arg1);
            					break;
            					
            	case "inrange": arg1=sc.nextInt();
								arg2=sc.nextInt();
								rbt.InRange(arg1, arg2);
								break;
								
            	case "next":	arg1=sc.nextInt();
								rbt.Next(arg1);
								break;
								
            	case "previous":arg1=sc.nextInt();
								rbt.Previous(arg1);
								break;
								
								
            	case "quit":	endTime   = System.currentTimeMillis();
            					long totalTime = endTime - startTime;
            					//System.out.println("Time taken is : "+ totalTime);
            					return;
            					
            	
            	case "default":	System.out.println("Incorrect command : "+ func);
            					return;
            	}
            		
            	func=sc.next();
            }
            

        

            // closing the file
            br.close();         
        }
        catch(FileNotFoundException ex) //if file does not open successfully
        {
            System.out.println("Error opening the file :'" + filename + "'");                
        }
        catch(IOException ex)  //error while reading the file
        {
            System.out.println("Error reading the file :'" + filename + "'");                  
        }
		
		
		
		
		
		//testPrint();
		//testSearch(20);
        //testCount();
		//testNext(2);
		//testPrevious(23);
		//testIncrease(4,5);
		//testReduce(7,3);
		//testInRange(1,8);
	}
	


	/////////////////////
	///TEST FUNCTIONS///
	///////////////////
	
	
	static void testSearch(int x)
	{
		Node r=new Node(20);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={10,30,25,35};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i]);
			rbt.insert(n);
		}
		Node n=rbt.search(x);
        if(n==null)
        {
        	System.out.println("not found");
        }
        else
        {
        	System.out.println("found : "+n.id);
        }
	}
	static void testPrint()
	{
		Node r=new Node(1);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={2,3,4,5};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i]);
			rbt.insert(n);
		}
		rbt.prettyPrint();
	}
	static void testCount()
	{
		Node r=new Node(1);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={2,3,4,5};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i]);
			rbt.insert(n);
		}
		rbt.Count(4);
	}
	static void testNext(int x)
	{
		Node r=new Node(1);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={2,5,6,3};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i]);
			rbt.insert(n);
		}
		System.out.println("Next is:");
		rbt.Next(x);
		//rbt.prettyPrint();
	}
	static void testPrevious(int x)
	{
		Node r=new Node(1);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={2,5,6,3};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i]);
			rbt.insert(n);
		}
		System.out.println("Previous is:");
		rbt.Previous(x);
		//rbt.prettyPrint();
	}
	static void testIncrease(int id,int c)
	{
		Node r=new Node(1);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={2,5,6,3};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i],arr[i]);
			rbt.insert(n);
		}
		rbt.Increase(id,c);
		rbt.prettyPrint();
	}
	static void testReduce(int id,int c)
	{
		Node r=new Node(1);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={2,5,6,3};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i],arr[i]);
			rbt.insert(n);
		}
		rbt.Reduce(id,c);
		rbt.prettyPrint();
	}
	static void testInRange(int id1,int id2)
	{
		Node r=new Node(2,2);
		RedBlackTree rbt=new RedBlackTree(r);
		int arr[]={1,5,6,3};
		for(int i=0;i<arr.length;i++)
		{
			Node n=new Node(arr[i],arr[i]);
			rbt.insert(n);
		}
		rbt.InRange(id1,id2);
		//rbt.prettyPrint();
	}
}
