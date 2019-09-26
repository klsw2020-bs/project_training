//判断是否需要继续生成的标志 开始置false  
static boolean goodRoll = false;
 	//生成四个随机数 去掉最小值并返回剩下三个骰子点数和
    public static int genAttribute(){
        
        Random dice = new Random();
        //sumArray存放生成的四个1-6的随机数（random生成的数从0开始 所以+1）
        int[] sumArray = {dice.nextInt(6)+1, dice.nextInt(6)+1, dice.nextInt(6)+1, dice.nextInt(6)+1};
 
        // 将生成的4个数从小到大排序 这样后面三个就是最大的
        java.util.Arrays.sort(sumArray);
        return (sumArray[1] + sumArray[2] + sumArray[3]);
    }
 
    //检查生成的六个属性是否满足要求
	public static boolean checkFinalArray(int[] checkArray){
        
        int fifteenCount = 0;
 
        // 先记录属性值>=15的个数放在fifteenCount变量中
        for (int z : checkArray){
            if (z >= 15){
                fifteenCount++;
            }
        }
 		//检查属性值>=15的个数是否>=2 并且总和是否>=75
        return (fifteenCount >= 2 && Arrays.stream(checkArray).sum() >= 75);
    }
 
    public static void main(String[] args) {
        //利用while循环检查是否生成了满足条件的属性值 没有就一直循环
        while (!goodRoll){
            int[] finalArray;
            finalArray = new int[6];
 
            //for循环用于生成6个属性值
            for (int i = 0; i<6;++i){
                finalArray[i] = genAttribute();
            }
            //如果满足条件的话
            if (checkFinalArray(finalArray)){
                //先输出总和
                System.out.println("sum: " + Arrays.stream(finalArray).sum());
                
                for (int x : finalArray){
                    System.out.println(x);
                }
                //满足条件将goodRoll置为true 以结束while循环
                goodRoll = true;
            }      
        }
    }