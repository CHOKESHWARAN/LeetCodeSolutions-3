import java.util.*;

class Solution {
    private int[] newParent;
    private int[] lastSeen;
    private List<Integer>[] children;
    private List<Integer>[] newChildren;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.lastSeen = new int[26];
        Arrays.fill(this.lastSeen, -1);

        this.children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        dfsReparent(0);

        this.newChildren = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        this.ans = new int[n];
        dfsSize(0);
        return ans;
    }

    private void dfsReparent(int u) {
        int cIdx = s.charAt(u) - 'a';
        int prevNode = lastSeen[cIdx];
        if (prevNode != -1) {
            newParent[u] = prevNode;
        }

        lastSeen[cIdx] = u;
        for (int v : children[u]) {
            dfsReparent(v);
        }
        lastSeen[cIdx] = prevNode;
    }

    private int dfsSize(int u) {
        int size = 1;
        for (int v : newChildren[u]) {
            size += dfsSize(v);
        }
        ans[u] = size;
        return size;
    }
}