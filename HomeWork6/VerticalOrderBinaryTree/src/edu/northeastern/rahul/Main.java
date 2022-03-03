package edu.northeastern.rahul;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution{
    public List<List<Integer>> verticalTraversal(TreeNode root)

            Queue<Integer> queue = new PriorityQueue<>()
        q.put([root,0,0])
        nodes={}
        Left,Right=0,0

        #BFS Traversal
        while(not(q.empty())):
        p=q.get()
        node=p[0]
        x=p[1]
        y=p[2]



        Left,Right=min(Left,x),max(Right,x)


        if nodes.get(x,-1)==-1:
        nodes[x]={}


        if nodes[x].get(y,-1)!=-1:
        nodes[x][y].append(node.val)
        nodes[x][y]=sorted(nodes[x][y])

        else:
        nodes[x][y]=[node.val]


        if node.left!=None:
        q.put([node.left,x-1,y+1])


        if node.right!=None:
        q.put([node.right,x+1,y+1])


        diff=abs(Left)


        totalValues=abs(Left)+Right+1


        ans=[[] for i in range(totalValues)]


        for i in nodes:
        for j in nodes[i]:


        ans[i+diff]+=nodes[i][j]

        #Returning Output List
        return ans


}