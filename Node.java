/*
class Node
contains the definitions and constructors to create a node for the Red Black Tree
conatins pretty() function to print the tree





*/

public class Node implements Sentinel
{
	Node left;
	Node right;
	Node parent;
	String color;
	String type;
	
	int count;
	int id;
	
	/////////////////////
	///CONSTRUCTORS/////
	///////////////////
	Node() 
	{
		
		count=0;
		id=0;
		left=nil;
		right=nil;
		parent=nil;
		color="red";
		type="node";
	}
	
	Node(String str)
	{
		
		count=0;
		id=0;
		left=null;
		right=null;
		parent=null;
		color="black";
		type=str;
	}
	
	Node(int k)
	{
		count=-1;
		id=k;
		left=nil;
		right=nil;
		parent=nil;
		color="red";
		type="node";
	}
	Node(int k,int c)
	{
		count=c;
		id=k;
		left=nil;
		right=nil;
		parent=nil;
		color="red";
		type="node";
	}
	
	/////////////////////
	///PRINT FUNCTION///
	///////////////////
	void pretty(int l)
	{
		for(int i=0;i<l;i++)
	    {
	        
			System.out.print(".");
	    }
		
		System.out.println(this.id +" color : "+ this.color+ " parent: "+this.parent);
		if(this.left!=nil)
		{
			left.pretty(l+1);
		}
		if(this.right!=nil)
		{
			right.pretty(l+1);
		}
	}
	
}
