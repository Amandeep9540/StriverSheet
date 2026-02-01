package graph.problems;


import java.util.*;

public class FloodFill733 {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int row = 1;
        int col = 1;
        int color = 2;
        int[][] filledImage = floodFill(image,row,col,color);
        for(int i=0;i<filledImage.length;i++){
            for(int j=0;j<filledImage[i].length;j++){
                System.out.print(filledImage[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevColor = image[sr][sc];
        image[sr][sc] = color;
            if (prevColor == color) return image;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(List.of(sr,sc));
        while(!queue.isEmpty()){
            List<Integer> curr = queue.poll();
            int row = curr.get(0);
            int col = curr.get(1);
            //check the upwards
            if(row-1>=0 && image[row-1][col] == prevColor){
                image[row-1][col] = color;
                queue.offer(List.of(row-1,col));
            }
            //check the downwards
            if(row+1 < image.length && image[row+1][col] == prevColor){
                image[row+1][col] = color;
                queue.offer(List.of(row+1,col));
            }
            //check the left
            if(col+1<image[0].length && image[row][col+1] == prevColor){
                image[row][col+1] = color;
                queue.offer(List.of(row,col+1));
            }
            //cehck the right
            if(col-1 >=0 && image[row][col-1] == prevColor){
                image[row][col-1] = color;
                queue.offer(List.of(row,col-1));
            }
        }
        return image;
    }
}
