package hkttty.jian.page1;

public class No2 {
    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    // 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public String replaceSpace(StringBuffer str) {
        if(str.length()==0){
            return new String("");
        }
        int count = 0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        char arr[] = new char[str.length() + count * 2];
        int index = 0;
        for (int i = 0; i < arr.length;) {
            char c = str.charAt(index++);
            if(c==' '){
                arr[i++] = '%';
                arr[i++] = '2';
                arr[i++] = '0';
            }else{
                arr[i++] = c;
            }
        }
        return new String(arr);
    }
}
