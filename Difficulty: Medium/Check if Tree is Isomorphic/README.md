<h2><a href="https://www.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1">Check if Tree is Isomorphic</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given two&nbsp;Binary Trees. Check whether they are&nbsp;Isomorphic or not.</span></p>
<p><span style="font-size: 18px;"><strong>Note:&nbsp;</strong><br>Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right children of several nodes.&nbsp;Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.<br>For example, the following two trees are isomorphic with the following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.<br><a href="https://media.geeksforgeeks.org/wp-content/cdn-uploads/ISomorphicTrees-e1368593305854.png"><img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/ISomorphicTrees-e1368593305854.png" alt="ISomorphicTrees" width="397" height="163"></a></span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span><strong>Input: </strong>root1[] = [1, 2, 3, 4, 5, 7, 6, N, 7, 8], root2[] = [1, 3, 2, N, 6, 4, 5, 8, 7]<strong><br></strong>
<a style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; white-space: normal;" href="https://media.geeksforgeeks.org/wp-content/cdn-uploads/ISomorphicTrees-e1368593305854.png"><img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/ISomorphicTrees-e1368593305854.png" alt="ISomorphicTrees" width="397" height="163"></a><strong>
Output: </strong>true</span></pre>
<pre><span style="font-size: 18px;"><strong>Input:</strong> root1[] = [1, 2, 3, 4], root2[] = [1, 3, 2, 4] 1 <strong> </strong> 1 &nbsp; / \ / \ &nbsp; 2 3 3 2 &nbsp; / / &nbsp; 4<strong>&nbsp; </strong>4<strong> Output: </strong>false </span></pre>
<p>&nbsp;</p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>root1[] = [1, 2, 3, 4], root2[] = [1, 3, 2, N, N, N, 4]<strong><br></strong>
      1   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;1
&nbsp;   /  \         /   \
&nbsp;  2    3       3     2
&nbsp; /                    \
&nbsp; 4<strong>&nbsp;                    </strong>4<strong>
Output: </strong>true</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1&lt;=number of nodes&lt;=10<sup>5<br></sup>1&lt;= node-&gt;data &lt;=10<sup>5</sup><sup><br></sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;