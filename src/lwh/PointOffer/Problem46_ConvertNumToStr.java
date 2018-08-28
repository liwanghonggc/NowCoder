package lwh.PointOffer;

/** 把数字翻译成字符串 **/
public class Problem46_ConvertNumToStr {

    public static void main(String[] args) {
        String str = "12258";
        System.out.println(getTranslationCount(str));
    }

    private static int getTranslationCount(String str){
        if(str == null || str.length() == 0){
            return 0;
        }

        int len = str.length();
        int[] counts = new int[len];
        int count = 0;

        for(int i = len - 1; i >= 0; i--){
            if(i < len - 1){
                count = counts[i+1];
            }else{
                count = 1;
            }

            if(i < len - 1){
                int digit1 = str.charAt(i) - '0';
                int digit2 = str.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if(converted >= 10 && converted <= 25){
                    if(i < len - 2){
                        count += counts[i+2];
                    }else{
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        count = counts[0];

        return count;
    }
}
