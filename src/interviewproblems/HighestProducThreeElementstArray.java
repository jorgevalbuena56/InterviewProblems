package interviewproblems;

/**
 * 
 * Given an array_of_ints, find the highest_product you can get from three of the integers.
 * The input array_of_ints will always have at least three integers. The integers CAN be negative.
 * 
 * The method get the max product of 3 consists in basically find the biggest 3 numbers 
 * from the array and the smallest 2 numbers from the array in just 1 iteration over the array.
 * 
 * @author George
 */	

public class HighestProducThreeElementstArray {
    
    public static void main(String args[]){
        
        int[] array1 =  {1, 2 ,3};
        int[] array2 =  {1, -2, 2, -3};
        int[] array3 =  {1, 1, 2, -3, 1};
        
        HighestProducThreeElementstArray p = new HighestProducThreeElementstArray();
        
        System.out.println("Max Array 1: " + p.highest_product_of_3(array1));
        System.out.println("Max Array 2: " + p.highest_product_of_3(array2));
        System.out.println("Max Array 3: " + p.highest_product_of_3(array3));
    }
    
    public int highest_product_of_3(int[] array){
        if (array.length < 3){
            throw new Error("Less than 3 items!");
        }
        
        /* the minimums initialized with max int to avoid cases with extreme max in array 
           and false minims 0 minimums returned */        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        /* the same logic for maximum initializations but of course inverted 
           to avoid extreme minimum values in array and false 0 maximums */
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;        
        
        for(int i=0; i<array.length;i++){
            //test if max1 is smaller than current array value
            if (array[i] > max1) {
                //if array[i] is greater than the biggest max then a chain reaction is started,
                // max3 will be max2, max2 will be actual max1 and max1 will be array[i]    
                max3 = max2;
                max2 = max1;
                max1 = array[i];
            
            }else if(array[i] > max2){
                /* in case if current array[i] isn't bigger than max1 
                   we test it to see maybe is bigger than second max. 
                   Then the same logic from above is applied for the max2 amd max3 */
                max3 = max2;
                max2 = array[i];
                
            }else if(array[i] > max3){
               /* finally if current array value isn't bigger than max1 and max2 
                  maybe is greater than max3 */
                max3 = array[i];
            }
            
            /* The logic from above with maximums is is applied here with minimums 
               but of course inverted to discover the 2 minimums from current array. */
            if (array[i] < min1) {
                
                min2 = min1;
                min1 = array[i];
                
            } else if (array[i] < min2) {
                
                min2 = array[i];
            }
        }
        
        /* After we discovered the 3 greatest maximums and the 2 smallest minimums from the array 
           we do the 2 products of 3 from the greatest maximum and the 2 minimums . 
           This is necessary because mathematically the product of 2 negative values is a positive value, 
           and because of this the product of min1 * min2 * max1 can be greater than max1 * max2 * max3 
           and the product built from the the 3 maximums. */
        int prod1 = min1 * min2 * max1;
        int prod2 = max1 * max2 * max3;
        
        //here we just return the biggest product
        return prod1 > prod2 ? prod1 : prod2;
    }
}
