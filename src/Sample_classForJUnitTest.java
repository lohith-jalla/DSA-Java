class Sample_classForJUnitTest {

    public int add(int a,int b){
        return a+b;
    }

    public static void main(String args[]){
        Sample_classForJUnitTest a=new Sample_classForJUnitTest();
        System.out.println(a.add(2,4));
    }
}
