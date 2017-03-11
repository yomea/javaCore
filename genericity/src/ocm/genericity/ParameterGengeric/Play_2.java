package ocm.genericity.ParameterGengeric;

//不能编译，会报告实现了两次相同的接口
//但是非常搞笑的是，将Play_1和Play_2的泛型擦除后，就不会报错了。
public class Play_2 extends Play_1 implements Payable<String> {

}
